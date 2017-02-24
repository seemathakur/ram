package com.vsp.claim.visionservicerequestapi.servicerequest.service;

import static com.vsp.claim.visionservicerequestapi.servicerequest.mapper.VisionServiceRequestsMapper.mapClaimsToServiceRequests;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.claim.model.Claims;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.claim.model.VisionServiceRequests;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.SearchReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.config.ResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.VisionServiceRequestLinkBuilder;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;

public class SearchVisionServiceRequestsLifecycleBean {

	@Autowired
	private ApiContext apiContext;
	@Autowired
	private SearchReservedClaimsBean searchReservedClaimsBean; 
	
	private static final Logger LOG = LoggerFactory.getLogger(SearchVisionServiceRequestsLifecycleBean.class);
	
	public VisionServiceRequests searchVisionServiceRequests(String clientId, String divisionId, String policyId, String consumerId){		
		
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
		
		mdcConfiguration.setOperation(ResourceOperationEnum.SEARCH_VISION_SERVICE_REQUESTS.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClientId(clientId)
			.setDivisionId(divisionId)
			.setPolicyId(policyId)
			.setConsumerId(consumerId)
			.configure();
		
		ApiInvocationEvent timerEvent = createApiInvocationEvent("searchVisionServiceRequests", "Search vision service requests");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, timerEvent);
		
		Claims claims = searchClaims(clientId, divisionId, policyId, consumerId);
		VisionServiceRequests serviceRequests = mapClaimsToServiceRequests(claims);
		setLinksOnServiceRequests(serviceRequests);
		
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, timerEvent);
		
		mdcConfiguration.clear();
		
		return serviceRequests;
	}

	private Claims searchClaims(String clientId, String divisionId, String policyId, String consumerId) {
		return searchReservedClaimsBean.search(clientId, divisionId, policyId, consumerId);
	}

	private void setLinksOnServiceRequests(VisionServiceRequests visionServiceRequests) {	
		for (VisionServiceRequest visionServiceRequest: visionServiceRequests) {
			visionServiceRequest.setSelf(VisionServiceRequestLinkBuilder.buildSelfLink(visionServiceRequest.getTrackingNumber()));
		}
	}
}
