package com.vsp.claim.visionservicerequestapi.reservedclaim.search;

import java.util.ArrayList;
import java.util.List;

import com.vsp.claim.common.exception.BadRequestCriteriaException;
import com.vsp.claim.visionservicerequestapi.shared.validation.Validator;
import com.vsp.il.util.NameValuePair;
import com.vsp.il.util.StringUtil;

public class SearchCriteriaBuilder {
	
	private String clientId; 	
	private String divisionId; 	
	private String subscriberId; 	
	private String consumerId; 	
	private List<NameValuePair> searchCriteria; 
		
	protected static final String CLIENT_ID = "membrGroupId";
	protected static final String DIVISION_ID = "membrGroupDiv";
	protected static final String SUBSCRIBER_ID = "membrId";
	protected static final String CONSUMER_ID = "consumerId";
	
		
	public SearchCriteriaBuilder() {		
		searchCriteria =  new ArrayList<NameValuePair>();
	}
	
	public List<NameValuePair> build() {
		validateSearchCriteria();
		
		addSearchCriteria(DIVISION_ID, divisionId);
		addSearchCriteria(SUBSCRIBER_ID, subscriberId);
		addSearchCriteria(CONSUMER_ID,  Integer.valueOf(consumerId));
		addSearchCriteria(CLIENT_ID, clientId);
		
		return searchCriteria;
	}

	private void validateSearchCriteria() {
		List<Validator> validators = new ArrayList<Validator>(); 
		
		validators.add(new SearchCriteriaValidator(this));
		validators.add(new SearchParamValidator(this)); 
		
		for(Validator validator: validators){
			if(!validator.isValid()){
				throw new BadRequestCriteriaException(validator.getErrorMessage());
			}
		}
	}

	private void addSearchCriteria(String name, Object value) {
		if (value != null) {
			if (value instanceof String && StringUtil.isEmpty((String) value)) {
				return;
			}
			searchCriteria.add(new NameValuePair(name, value));
		}
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	
	protected String getClientId() {
		return clientId;
	}

	protected String getDivisionId() {
		return divisionId;
	}

	protected String getConsumerId() {
		return consumerId;
	}

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

}
