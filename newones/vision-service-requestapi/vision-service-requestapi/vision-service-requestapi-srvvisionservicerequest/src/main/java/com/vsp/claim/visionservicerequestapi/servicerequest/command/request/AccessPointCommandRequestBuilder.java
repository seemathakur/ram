package com.vsp.claim.visionservicerequestapi.servicerequest.command.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.ServiceLocationConstraint;

public class AccessPointCommandRequestBuilder {
	
	private static final Logger LOG = LoggerFactory.getLogger(AccessPointCommandRequestBuilder.class);
	private static final String AUTHORIZATION_DOMAIN = "authorization"; 
	private static final String EYECONIC_CLIENT_ID = Preferences.get(AUTHORIZATION_DOMAIN, "eyeconic.clientId");
	private static final String EYECONIC_PROVIDER_TAX_ID = Preferences.get(AUTHORIZATION_DOMAIN, "eyeconic.providerTaxId");
	
	private AccessPointCommandRequest commandRequest;
	
	public AccessPointCommandRequestBuilder() {
		commandRequest = new AccessPointCommandRequest();
	}

	public AccessPointCommandRequest buildRequest(VisionServiceRequestApiContext requestContext) {
		ServiceLocationConstraint serviceLocationConstraint = requestContext.getServiceLocationConstraint();
		
		DebugLogger.debugEnabled(LOG, "Before setServiceLocationOnCommandRequest()");
		setServiceLocationFromRequestContext(serviceLocationConstraint);
		
		if(isEyeconicClientId(requestContext)){
			setEyeconicProviderKeyDefaults(); 
		}

		DebugLogger.debugEnabled(LOG, "Before setNetworkIdOnCommandRequest()");
		setNetworkIdOnCommandRequest(requestContext.getNetworkId()); 
		
		LOG.info("Built request: {}", commandRequest.toString());
		
		return commandRequest;
	}

	private void setEyeconicProviderKeyDefaults() {
		commandRequest.setProviderTaxId(EYECONIC_PROVIDER_TAX_ID);
		commandRequest.setServiceLocationHashCode(null);
		commandRequest.setServiceLocationSequence(null);
	}

	private boolean isEyeconicClientId(VisionServiceRequestApiContext requestContext) {
		String clientId = requestContext.getApiContext().getClientId();
		return clientId != null && clientId.equals(EYECONIC_CLIENT_ID);
	}

	private void setServiceLocationFromRequestContext(ServiceLocationConstraint serviceLocationConstraint) {
		if(serviceLocationConstraint != null) {
			commandRequest.setServiceLocationHashCode(getFormattedHashCodeFromServiceLocation(serviceLocationConstraint));
			commandRequest.setProviderTaxId(getFormattedTaxIdFromServiceLocation(serviceLocationConstraint));
			commandRequest.setServiceLocationSequence(getFormattedSequenceNumberFromServiceLocation(serviceLocationConstraint)); 
		}
		logServiceLocation(serviceLocationConstraint);
	}

	private void logServiceLocation(ServiceLocationConstraint serviceLocation) {
		if(serviceLocation != null){
			DebugLogger.debugEnabled(LOG, "Command request set ServiceLocationHashCode {}, ProviderTaxId {}, and ServiceLocationSequence {} from ServiceLocationConstraint",
					commandRequest.getServiceLocationHashCode(), 
					commandRequest.getProviderTaxId(), 
					commandRequest.getServiceLocationSequence());
		}else {
			LOG.info("Unable to set hash, sequence, and tax id because ServiceLocationConstraint is null");
		}
	}

	private String getFormattedHashCodeFromServiceLocation(ServiceLocationConstraint serviceLocation) {
		return serviceLocation.getService_location_hash_code();
	}

	private String getFormattedTaxIdFromServiceLocation(ServiceLocationConstraint serviceLocation) {
		return serviceLocation.getProvider_tax_id();
	}

	private String getFormattedSequenceNumberFromServiceLocation(ServiceLocationConstraint serviceLocation) {
		return serviceLocation.getService_location_sequence();
	}

	private void setNetworkIdOnCommandRequest(String networkId) {
		commandRequest.setNetworkId(networkId);
		DebugLogger.debugEnabled(LOG, "Command request setting: NetworkId {}", commandRequest.getNetworkId());
	}

}
