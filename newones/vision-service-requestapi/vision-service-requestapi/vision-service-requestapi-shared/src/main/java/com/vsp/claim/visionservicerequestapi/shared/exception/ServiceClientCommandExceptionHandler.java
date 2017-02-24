package com.vsp.claim.visionservicerequestapi.shared.exception;

import javax.ws.rs.WebApplicationException;

public class ServiceClientCommandExceptionHandler extends CommandExceptionHandler {
	
	@Override
	public void handle(Exception exception, String request) {
		WebApplicationException exceptionToThrow = buildExceptionToThrow((ServiceClientException) exception);
		logException(request, exceptionToThrow);
		throw exceptionToThrow;
	}

	/**
	 * The ordering of Exception catching, from specific to generic, is important in the following.
	 * @param exception
	 * @return
	 */
	private WebApplicationException buildExceptionToThrow(ServiceClientException exception) {
		WebApplicationException exceptionToThrow = null;
		Throwable serviceClientExceptionCause = exception.getCause();
		if(serviceClientExceptionCause == null) {
			exceptionToThrow = buildBadDataWebApplicationException(exception);
		}
		else if(isCauseWebApplicationException(serviceClientExceptionCause)) {
			exceptionToThrow = buildWebApplicationExceptionWithSameStatusAsCause(
					(WebApplicationException) serviceClientExceptionCause);
		} 
		else if(isCauseRuntimeException(serviceClientExceptionCause)) {
			exceptionToThrow = buildInternalServerException(serviceClientExceptionCause);
		}
		else {
			exceptionToThrow = buildInternalServerApplicationException(serviceClientExceptionCause);
		}
		return exceptionToThrow;
	}

}
