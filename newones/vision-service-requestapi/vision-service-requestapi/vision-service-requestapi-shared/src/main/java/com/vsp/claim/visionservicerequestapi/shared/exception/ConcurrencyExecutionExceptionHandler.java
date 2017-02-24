package com.vsp.claim.visionservicerequestapi.shared.exception;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;


public class ConcurrencyExecutionExceptionHandler extends CommandExceptionHandler {

	@Override
	public void handle(Exception exception, String request) {
		WebApplicationException exceptionToThrow = buildExceptionToThrow((ExecutionException) exception);
		logException(request, exceptionToThrow);
		throw exceptionToThrow;
	}

	private WebApplicationException buildExceptionToThrow(ExecutionException exception) {
		WebApplicationException exceptionToThrow = null;
		Throwable executionExceptionCause = exception.getCause();
		if(isCauseWebApplicationException(executionExceptionCause)) {
			exceptionToThrow = buildWebApplicationExceptionWithSameStatusAsCause(
					(WebApplicationException) executionExceptionCause);
		} else if(isCauseServiceClientException(executionExceptionCause)){
			exceptionToThrow = buildWebApplicationExceptionFromServiceClient(
					(ServiceClientException) executionExceptionCause);
		} else {
			exceptionToThrow = buildInternalServerApplicationException(executionExceptionCause);
		}
		return exceptionToThrow;
	}

	private WebApplicationException buildWebApplicationExceptionFromServiceClient(
			ServiceClientException executionExceptionCause) {
		WebApplicationException exceptionToThrow = null;
		Throwable serviceClientExceptionCause = executionExceptionCause.getCause();
		if(serviceClientExceptionCause == null) {
			exceptionToThrow = buildBadDataWebApplicationException(executionExceptionCause);
		}
		else if(isCauseWebApplicationException(serviceClientExceptionCause)) {
			exceptionToThrow = buildWebApplicationExceptionWithSameStatusAsCause(
					(WebApplicationException) serviceClientExceptionCause);
		} else {
			exceptionToThrow = buildInternalServerApplicationException(executionExceptionCause);
		}
		return exceptionToThrow;
	}

}
