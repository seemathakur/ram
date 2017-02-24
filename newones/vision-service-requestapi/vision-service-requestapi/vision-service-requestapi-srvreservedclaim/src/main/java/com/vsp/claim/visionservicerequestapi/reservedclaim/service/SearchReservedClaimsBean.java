package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.createApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.startLoggingApiInvocationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEventLogger.stopLoggingApiInvocationEvent;

import java.util.List;

import javax.ws.rs.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ext.XLogger;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.claim.model.Claims;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.common.exception.BadRequestCriteriaException;
import com.vsp.claim.visionservicerequestapi.reservedclaim.config.ReservedClaimResourceOperationEnum;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.search.SearchCriteriaBuilder;
import com.vsp.claim.visionservicerequestapi.shared.logging.ApiInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.MDCConfiguration;
import com.vsp.il.service.ServiceContext;
import com.vsp.il.util.NameValuePair;

public class SearchReservedClaimsBean {
	
	@Autowired private PreClaimRepository preClaimRepository;
	@Autowired private ApiContext apiContext;
	
	private static final Logger LOG = LoggerFactory.getLogger(SearchReservedClaimsBean.class);
	
	public Claims search(String clientId, String divisionId, String policyId, String consumerId){
		MDCConfiguration mdcConfiguration = new MDCConfiguration();
			
		mdcConfiguration.setOperation(ReservedClaimResourceOperationEnum.SEARCH_CLAIM.getOperation())
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClientId(clientId)
			.setDivisionId(divisionId)
			.setPolicyId(policyId)
			.setConsumerId(consumerId)
			.configure();
		
		ApiInvocationEvent event = createApiInvocationEvent("search()", "Search reserved claims");
		startLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);

		List<NameValuePair> searchCriteria = buildSearchCriteria(clientId, divisionId, policyId, consumerId); 
		Claims toReturn = searchClaims(searchCriteria); 
				
		stopLoggingApiInvocationEvent(LOG, XLogger.Level.INFO, event);
		mdcConfiguration.clear();
		return toReturn;
	}

	private Claims searchClaims(List<NameValuePair> searchCriteria) {
		return preClaimRepository.search(searchCriteria);	
	}

	private List<NameValuePair> buildSearchCriteria(String clientId, String divisionId, String policyId, String consumerId) {
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder(); 
		builder.setClientId(clientId);
		builder.setDivisionId(divisionId); 
		builder.setSubscriberId(policyId);
		builder.setConsumerId(consumerId);
		try {
			return builder.build();
		}catch (BadRequestCriteriaException exception){
			throw new BadRequestException(exception);
		}
		
	}

}
