package com.vsp.claim.visionservicerequestapi.servicerequest.service;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;

import javax.ws.rs.WebApplicationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.home.model.Home;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.DeleteReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.config.ResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.servicerequest.mapper.VisionServiceRequestMapper;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.DeleteLegacyAuthorizationServiceClient;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;
import com.vsp.jaxrs.client.RestClient;

public abstract class DeleteVisionServiceRequestLifecycleBean {
	
	@Autowired private ApiContext apiContext;
	@Autowired private DeleteReservedClaimsBean deleteReservedClaimsBean; 
	
	private static final Logger LOG = LoggerFactory.getLogger(DeleteVisionServiceRequestLifecycleBean.class);
	private static final String DEFAULT_EXT = "00";
	
	public VisionServiceRequest deleteVisionServiceRequest(String trackingNumber) throws DatabaseIOException{
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ResourceOperationEnum.DELETE_VISION_SERVICE_REQUEST.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setTrackingNumber(trackingNumber)	
			.configure();
		
		ApiInvocationEvent timerEvent = createApiInvocationEvent("deleteVisionServiceRequest", "Delete vision service request");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, timerEvent);
				
		deleteLegacyAuthorization(trackingNumber);
		LOG.info("The legacy authorization for vision service request {} was deleted successfully", trackingNumber);
		
		Claim deletedClaim = deleteReservedClaim(trackingNumber);
		LOG.info("The vision service request {} was deleted successfully", trackingNumber);

		VisionServiceRequest response = mapClaimToVisionServiceRequest(deletedClaim); 
		
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, timerEvent);
		mdcConfiguration.clear();
		
		return response;
	}

	private VisionServiceRequest mapClaimToVisionServiceRequest(Claim deleted) {
		return VisionServiceRequestMapper.mapClaimToServiceRequest(deleted);
	}

	private Claim deleteReservedClaim(String trackingNumber) throws DatabaseIOException {
		return deleteReservedClaimsBean.delete(trackingNumber, "00");
	}

	private void deleteLegacyAuthorization(String trackingNumber) {
		try {
			DeleteLegacyAuthorizationServiceClient serviceClient = new DeleteLegacyAuthorizationServiceClient();
			serviceClient.setRestClient(getRestClient());
			serviceClient.deleteClaimBenefitRequest(buildClaimKeyFromTrackingNumber(trackingNumber));
		}catch(WebApplicationException exception){
			throw new WebApplicationException(exception, exception.getResponse().getStatus());	
		}
	}
	
	private ClaimKey buildClaimKeyFromTrackingNumber(String trackingNumber) {
		return new ClaimKey(trackingNumber, DEFAULT_EXT); 
	}

	protected abstract RestClient<Home> getRestClient();

}
