package com.vsp.claim.visionservicerequestapi.reservedclaim.search;

import org.apache.cxf.common.util.StringUtils;

import com.vsp.claim.visionservicerequestapi.shared.validation.Validator;

public class SearchCriteriaValidator implements Validator {
	
	private SearchCriteriaBuilder searchCriteriaBuilder;
	
	public SearchCriteriaValidator(SearchCriteriaBuilder searchCriteriaBuilder){
		this.searchCriteriaBuilder = searchCriteriaBuilder;
	}

	@Override
	public boolean isValid() {
		return isNotEmpty(searchCriteriaBuilder.getSubscriberId())
				&& isNotEmpty(searchCriteriaBuilder.getClientId())
				&& isNotEmpty(searchCriteriaBuilder.getDivisionId())
				&& isNotEmpty(searchCriteriaBuilder.getConsumerId());
	}
	
	private boolean isNotEmpty(String string){
		return !StringUtils.isEmpty(string);
	}
	

	@Override
	public String getErrorMessage() {
		return "Valid searches must be one of the following: " 
		+ "(1) clientId=[0-9]{8}&divisionId=[0-9]{4}&subscriberId=[0-9]{9}&consumerId=[0-9]+";
	}

	@Override
	public String getErrorCode() {
		return "";
	}

}
