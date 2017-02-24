package com.vsp.claim.visionservicerequestapi.servicerequest.service;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.home.model.Home;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.CreateReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.ClaimBuilderImpl;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.NoEligibleServicesException;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMapBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.config.ResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.servicerequest.mapper.VisionServiceRequestMapper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContextBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.IssueLegacyAuthorizationServiceClient;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;

public abstract class CreateVisionServiceRequestLifecycleBean {

	@Autowired private ApiContext apiContext;
	@Autowired private CommandMapBuilder commandMapBuilder;
	@Autowired private CreateReservedClaimsBean createReservedClaimsBean; 
	
	private static final Logger LOG = LoggerFactory.getLogger(CreateVisionServiceRequestLifecycleBean.class);
	private static final String AUTHORIZATION_DOMAIN = "authorization";
	private static final String EYECONIC_CLIENT_ID_KEY = "eyeconic.clientId"; 
	
	public VisionServiceRequest createVisionServiceRequest(
			String clientId, String divisionId, String policyId, String consumerId, String networkId, 
			String productPackageName, String effectiveDate, VisionServiceRequest serviceRequest) throws ClaimBuilderException, DatabaseIOException {

		VisionServiceRequest response = new VisionServiceRequest(); 
		
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ResourceOperationEnum.CREATE_VISION_SERVICE_REQUEST.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClientId(clientId)
			.setDivisionId(divisionId)
			.setPolicyId(policyId)
			.setConsumerId(consumerId)
			.setNetworkId(networkId)
			.setProductPackageName(productPackageName)
			.configure();
				
		ApiInvocationEvent timerEvent = createApiInvocationEvent("createVisionServiceRequest", "Create vision service request");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, timerEvent);
		
		
		VisionServiceRequestApiContext requestContext = buildContext(clientId, divisionId, policyId, consumerId, networkId, productPackageName, effectiveDate, serviceRequest);
		CommandMap transactionCommandMap = buildCommandMapOfInitializedCommands(requestContext);
		
		try{
			Claim request = buildPreClaim(requestContext, transactionCommandMap);
			setAuthorizationNumberAndTypeCodeOnClaim(request, requestContext);
			Claim reservedClaim = createClaim(request); 		
			response =  buildResponseFromClaim(reservedClaim);
		}catch(NoEligibleServicesException exception){
			setNoContentResponseStatus();
		}

		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, timerEvent);
		
		mdcConfiguration.clear();
		
		return response;
	}
	
	private VisionServiceRequestApiContext buildContext(String clientId, String divisionId, String policyId, String consumerId, String networkId, String productPackageName, String effectiveDate,VisionServiceRequest serviceRequest) {
		VisionServiceRequestApiContextBuilder builder = new VisionServiceRequestApiContextBuilder(clientId, divisionId, policyId, consumerId, networkId, productPackageName, effectiveDate, serviceRequest);
		VisionServiceRequestApiContext requestContext = builder.buildContext();
		requestContext.setApiContext(apiContext);
		requestContext.setRestClient(getRestClient());

		return requestContext;
	}

	
	private VisionServiceRequest buildResponseFromClaim(Claim reservedClaim) {
		VisionServiceRequest serviceRequest = new VisionServiceRequest();
		
		if(responseHasContent(reservedClaim)){
			serviceRequest = VisionServiceRequestMapper.mapClaimToServiceRequest(reservedClaim);
			LOG.info("Success! Created vision service request.");
		}else {
			LOG.info("The vision service request was not created.");
		}
		
		return serviceRequest; 
	}

	private void setNoContentResponseStatus() {
		apiContext.setHTTPStatusCode(Response.Status.NO_CONTENT);
	}
	
	private boolean responseHasContent(Claim reservedClaim) {
		return reservedClaim != null; 
	}

	private CommandMap buildCommandMapOfInitializedCommands(VisionServiceRequestApiContext requestContext) {
		return commandMapBuilder.buildCommandMap(requestContext, buildExecutableCommandList(requestContext));
	}

	protected Claim buildPreClaim(VisionServiceRequestApiContext requestContext, CommandMap transactionCommandMap) throws ClaimBuilderException {
		ClaimBuilderImpl builder = new ClaimBuilderImpl(requestContext, transactionCommandMap);
		return builder.buildClaim();
	}
	
	protected Claim createClaim(Claim claim) throws DatabaseIOException{
		return createReservedClaimsBean.create(claim);
	}
	
	protected ApiContext getApiContext(){
		return apiContext;
	}
	
	protected List<String> buildExecutableCommandList(VisionServiceRequestApiContext requestContext) {
		List<String> commandsToExecute = new ArrayList<String>();
		
		commandsToExecute.add(CommandMap.RETRIEVE_ELIGBILITY_COMMAND);
		commandsToExecute.add(CommandMap.RETRIEVE_MEMBER_POLICY_COMMAND);
		commandsToExecute.add(CommandMap.RETRIEVE_CLIENT_DIVISION_COMMAND);
		commandsToExecute.add(CommandMap.GENERATE_TRACKING_NUMBER_COMMAND); 
		
		if(shouldRetrieveAccessPoints(requestContext) && !requestContext.isIssueMemberAuthorizationOnly()){
			commandsToExecute.add(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND);
		}
		
		return commandsToExecute;
	}
	
	private boolean shouldRetrieveAccessPoints(VisionServiceRequestApiContext requestContext) {
		return requestContext.hasServiceLocationConstraint() || isEyeconicClientId(requestContext.getApiContext().getClientId());
	}
	
	private boolean isEyeconicClientId(String clientId){
		return clientId != null && clientId.equals(Preferences.get(AUTHORIZATION_DOMAIN, EYECONIC_CLIENT_ID_KEY));
	}
	
	private void setAuthorizationNumberAndTypeCodeOnClaim(Claim inputClaim, VisionServiceRequestApiContext requestContext){
		if (isLegacyAuthorizationBridgeEnabled()) {
			Claim response = issueLegacyAuthorization(inputClaim, requestContext);
			inputClaim.setAuthorizationNumber((response.getAuthorizationNumber()!=null) ? response.getAuthorizationNumber() : "0" );
			inputClaim.setAuthorizationTypeCode((response.getAuthorizationTypeCode()!=null) ? response.getAuthorizationTypeCode() : "");
		}
	}
	
	private boolean isLegacyAuthorizationBridgeEnabled() {
		return Preferences.getBoolean(AUTHORIZATION_DOMAIN, "EnableLegacyAuthorizationBridge");
	}
	
	protected Claim issueLegacyAuthorization(Claim claim, VisionServiceRequestApiContext requestContext) {
		try {
			IssueLegacyAuthorizationServiceClient serviceClient = createIssueLegacyAuthorizationServiceClient(requestContext);
			return invokeAuthorizationBusinessService(serviceClient, claim);
		}catch(WebApplicationException exception){
			throw new WebApplicationException(exception, exception.getResponse().getStatus());	
		}
	}
	
	protected Claim invokeAuthorizationBusinessService(IssueLegacyAuthorizationServiceClient serviceClient, Claim claim){
		return serviceClient.issueLegacyAuthorization(claim);
	}
	
	protected IssueLegacyAuthorizationServiceClient createIssueLegacyAuthorizationServiceClient(VisionServiceRequestApiContext requestContext) {
		IssueLegacyAuthorizationServiceClient serviceClient = new IssueLegacyAuthorizationServiceClient();
		serviceClient.setRestClient(requestContext.getRestClient());
		return serviceClient;
	}
	
	protected abstract RestClient<Home> getRestClient(); 
	
}
