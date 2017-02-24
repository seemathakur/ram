package com.vsp.claim.visionservicerequestapi.shared.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class CommandExceptionHandler {
	
	private static final Logger LOG = LoggerFactory.getLogger(CommandExceptionHandler.class);
	
	private static final int REST_ERR_CD_400 = Response.Status.BAD_REQUEST.getStatusCode();
	private static final int REST_ERR_CD_500 = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
	
	public abstract void handle(Exception exception, String request);
	
	protected void logException(String request, WebApplicationException exception) {
		String logMessage = makeMessageForCommandRequest(request);
		LOG.error(logMessage, exception);
	}

	protected String makeMessageForCommandRequest(String request) {
		return "Exception thrown for " + request;
	}

	protected WebApplicationException buildInternalServerApplicationException(Throwable executionExceptionCause) {
		return new WebApplicationException(executionExceptionCause);
	}
	
	protected WebApplicationException buildInternalServerException(Throwable executionExceptionCause) {
		return new WebApplicationException(executionExceptionCause, REST_ERR_CD_500);
	}

	protected boolean isCauseWebApplicationException(Throwable exception) {
		return exception instanceof WebApplicationException;
	}

	protected boolean isCauseRuntimeException(Throwable exception) {
		return exception instanceof RuntimeException;
	}
	
	protected boolean isCauseServiceClientException(Throwable executionExceptionCause) {
		return executionExceptionCause instanceof ServiceClientException;
	}

	protected WebApplicationException buildWebApplicationExceptionWithSameStatusAsCause(
			WebApplicationException executionExceptionCause) {
		Response responseToThrow = executionExceptionCause.getResponse();
		return new WebApplicationException(executionExceptionCause, responseToThrow);
	}

	protected WebApplicationException buildBadDataWebApplicationException(
			ServiceClientException executionExceptionCause) {
		return new WebApplicationException(executionExceptionCause, REST_ERR_CD_400);
	}

}
