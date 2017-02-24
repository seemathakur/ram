package com.vsp.claim.visionservicerequestapi.shared.exception;


public class ServiceClientException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ServiceClientException(String message, Object request, 
			Throwable cause) {
		super(makeMessage(message, request), cause);
	}
	
	public ServiceClientException(String message){
		super(message);
	}
	
	public ServiceClientException(){
		
	}
	
	public ServiceClientException(String message, Object request) {
		super(makeMessage(message, request));
	}
	
	public ServiceClientException(String message, Throwable cause){
		super(message, cause);
	}

	protected static String makeMessage(String message, Object request) {
		String requestType = request.getClass().getSimpleName();
		return message + " " + requestType + ": " + request.toString();
	}

}
