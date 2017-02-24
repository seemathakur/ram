package com.vsp.claim.visionservicerequestapi.shared.validation;

public interface Validator {

	boolean isValid(); 
	String getErrorMessage(); 
	String getErrorCode();
}
