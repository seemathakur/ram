package com.vsp.claim.visionservicerequestapi.shared.exception;


public class ClaimLineNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ClaimLineNotFoundException() {
	}
	
	public ClaimLineNotFoundException(String message) {
		super(makeMessage(message));
	}
	
	public ClaimLineNotFoundException(String message, Throwable cause) {
		super(makeMessage(message), cause);
	}
	
	public ClaimLineNotFoundException(Integer lineNumber, Throwable cause) {
		super(makeMessage(lineNumber), cause);
	}
	
	public ClaimLineNotFoundException(Integer lineNumber) {
		super(makeMessage(lineNumber));
	}
	
	private static String makeMessage(Integer lineNumber) {
		String msg = "Claim Line Number == NULL ";
		if(lineNumber != null) {
			msg = lineNumber.toString();
		}
		return "Claim Line Not Found! " + msg;
	}
	
	private static String makeMessage(String msg) {
		return "Claim Line Not Found! " + msg;
	}


}
