package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.core.Suspend;
import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveEligibilityCommandRequestBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.Notification;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.EligibilityServiceClient;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.RetrieveCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.UncheckedExceptionCommand;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;
import com.vsp.jaxrs.client.RestClient;

public class RetrieveEligibilityCommand extends RetrieveCommand implements UncheckedExceptionCommand<Eligibility>, Requestable, RestCommand{
	
	private static final Logger LOG = LoggerFactory.getLogger(RetrieveEligibilityCommand.class);	
			
	@Autowired
	private EligibilityServiceClient eligibilityClient;
	
	private Future<Eligibility> returnValue;
	private VisionServiceRequestApiContext requestContext;
	
	public RetrieveEligibilityCommand(){
		super(CommandMap.RETRIEVE_ELIGBILITY_COMMAND, "Retrieve eligibility");
	}

	@Override
	public void run() {
		validateRequestIsNotNull();	
		retrieveEligibility();
	}

	private void retrieveEligibility() {
		returnValue = eligibilityClient.retrieveEligibility(getRequest());
	}

	@Override
	public Eligibility getReturnValue() {
		Eligibility eligibility = getValidatedResponse();
		return eligibility;
	}
	
	private Eligibility getValidatedResponse() {
		Eligibility serviceClientResponse = null;
		try {
			serviceClientResponse = returnValue.get();
		}catch (InterruptedException | ExecutionException exception) {
			handleException(exception);
		}	
		validateResponseIsNotNull(serviceClientResponse);
		handleSuspends(serviceClientResponse);
		return serviceClientResponse;
	}


	private void handleSuspends(Eligibility eligibilityResponse) {
		List<Suspend> suspends = eligibilityResponse.getSuspends();
		if(hasSuspends(suspends)){
			LOG.info("EligibilityResponse has suspends, adding notifications to request context");
			addNotifications(suspends);
		}
	}

	private void addNotifications(List<Suspend> suspends) {
		for(Suspend suspend: suspends){
			addNotification(buildNotificationFromSuspend(suspend));
		}
	}

	private void addNotification(Notification notification){
		requestContext.addNotification(notification);
	}
	
	public List<Notification> getNotifications(){
		return requestContext.getNotifications();
	}

	private Notification buildNotificationFromSuspend(Suspend suspend) {
		Notification notification = new Notification();
		
		notification.setCode(suspend.getCode());
		notification.setDescription(suspend.getDescription());
		
		return notification;
	}

	@Override
	public void buildRequest(VisionServiceRequestApiContext context) {
		setRequest(RetrieveEligibilityCommandRequestBuilder.buildRequest(context));
		this.requestContext = context; 	
	}
	
	@Override
	public String toString(){
		return getCommandMapName();
	}

	@Override
	public void initializeServiceClient(RestClient<Home> restClient) {
		eligibilityClient.setRestClient(restClient);
	}

	@Override
	public RestServiceClient getServiceClient() {
		return eligibilityClient;
	}
		
	private boolean hasSuspends(List<Suspend> suspends) {
		return suspends != null && suspends.size() > 0;
	}	
}
