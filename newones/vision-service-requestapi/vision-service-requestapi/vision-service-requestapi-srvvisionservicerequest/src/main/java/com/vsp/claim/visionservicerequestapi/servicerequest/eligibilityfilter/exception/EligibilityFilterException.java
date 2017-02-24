package com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.exception;

public class EligibilityFilterException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public EligibilityFilterException(String message){
		super(message);
	}
	
	public EligibilityFilterException(String message, Throwable cause){
		super(message, cause);
	}

}
