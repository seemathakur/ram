package com.vsp.claim.visionservicerequestapi.shared.exception;

public class DatabaseIOException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DatabaseIOException(String message) {
		super(message);
	}
	
	public DatabaseIOException(String message, Throwable cause) {
		super(message, cause);
	}

}
