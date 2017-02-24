package com.vsp.claim.visionservicerequestapi.reservedclaim.search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vsp.claim.visionservicerequestapi.shared.validation.Validator;

public final class SearchParamValidator implements Validator {

	private static final Pattern PARAM_CLIENT_ID_PATTERN = Pattern
			.compile("[0-9]{8}");	
	private static final Pattern PARAM_DIVISION_ID_PATTERN = Pattern
			.compile("[0-9]{4}");
	private static final Pattern PARAM_SUBSCRIBER_ID_PATTERN = Pattern
			.compile("[0-9]{9}");
	private static final Pattern PARAM_CONSUMER_ID_PATTERN = Pattern
			.compile("[0-9]+");

	private final SearchCriteriaBuilder searchCriteriaBuilder;

	public SearchParamValidator(SearchCriteriaBuilder searchCriteriaBuilder) {
		this.searchCriteriaBuilder = searchCriteriaBuilder;
	}

	/**
	 * @return <p>
	 *         true if parameters are in correct format
	 *         <p>
	 *         false, otherwise
	 * 
	 *         NOTE: Null is considered valid as parameters are optional.
	 */

	@Override
	public boolean isValid() {
		return isClientIdValid() && isDivisionIdValid() && isSubscriberIdValid() && isConsumerIdValid();
	}

	private boolean isClientIdValid() {
		return isPatternValid(searchCriteriaBuilder.getClientId(), PARAM_CLIENT_ID_PATTERN);
	}

	
	private boolean isDivisionIdValid() {
		return isPatternValid(searchCriteriaBuilder.getDivisionId(),PARAM_DIVISION_ID_PATTERN);
	}

	private boolean isSubscriberIdValid() {
		return isPatternValid(searchCriteriaBuilder.getSubscriberId(),PARAM_SUBSCRIBER_ID_PATTERN);
	}
	
	private boolean isConsumerIdValid() {
		return isPatternValid(searchCriteriaBuilder.getConsumerId(),
				PARAM_CONSUMER_ID_PATTERN);
	}


	private boolean isPatternValid(String value, Pattern pattern) {
		if (value == null) {
			return true;
		} else {
			Matcher matcher = pattern.matcher(value);
			return matcher.matches();
		}
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
