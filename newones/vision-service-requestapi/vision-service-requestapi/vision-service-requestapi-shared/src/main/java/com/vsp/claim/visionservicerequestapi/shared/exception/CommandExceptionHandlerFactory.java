package com.vsp.claim.visionservicerequestapi.shared.exception;

import java.util.concurrent.ExecutionException;


public final class CommandExceptionHandlerFactory {
	
	private CommandExceptionHandlerFactory() { }

	public static CommandExceptionHandler getExceptionHandler(Exception exception) {
		CommandExceptionHandler exceptionHandler = null;
		if(exception instanceof ExecutionException) {
			exceptionHandler =  new ConcurrencyExecutionExceptionHandler();
		} else if(exception instanceof ServiceClientException) {
			exceptionHandler = new ServiceClientCommandExceptionHandler();
		} else {
			exceptionHandler = new GenericCommandExceptionHandler();
		}
		return exceptionHandler;
	}

}
