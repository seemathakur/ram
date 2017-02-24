package com.vsp.claim.visionservicerequestapi.shared.exception;

import javax.ws.rs.WebApplicationException;

public class GenericCommandExceptionHandler extends CommandExceptionHandler {

	@Override
	public void handle(Exception exception, String request) {
		WebApplicationException exceptionToThrow = buildInternalServerApplicationException(exception);
		logException(request, exceptionToThrow);
		throw exceptionToThrow;
	}

}
