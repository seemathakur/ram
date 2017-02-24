package com.vsp.claim.visionservicerequestapi.shared.command;

import static com.vsp.claim.visionservicerequestapi.shared.logging.MemoryInformationEventLogger.createMemoryInformationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.MemoryInformationEventLogger.startLoggingMemoryInformationEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.MemoryInformationEventLogger.stopLoggingMemoryInformationEvent;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.ext.XLogger;

import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.CommandExceptionHandler;
import com.vsp.claim.visionservicerequestapi.shared.exception.CommandExceptionHandlerFactory;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.claim.visionservicerequestapi.shared.logging.MemoryInformationEvent;
import com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEvent;

public class RetrieveCommand {
	
	private CommandRequest request;
	private ServiceClientException synchronousException;
	private String commandMapName;
	private String commandMapDescription;
	
	private MemoryInformationEvent memoryEvent;
	private ServiceInvocationEvent timerEvent;
	
	protected RetrieveCommand(String commandMapName, String commandMapDescription) {
		this.commandMapName = commandMapName;
		this.commandMapDescription = commandMapDescription;
	}
	
	protected CommandRequest getRequest() {
		return request;
	}

	public void setRequest(CommandRequest request) {
		this.request = request;
	}

	protected ServiceClientException getSynchronousException() {
		return synchronousException;
	}

	protected void setSynchronousException(ServiceClientException synchronousException) {
		this.synchronousException = synchronousException;
	}
	
	protected String getCommandMapName() {
		return commandMapName;
	}
		
	protected String getCommandMapDescription() {
		return commandMapDescription;
	}
	
	protected void handleException(final Exception exception) {
		CommandExceptionHandler exceptionHandler = CommandExceptionHandlerFactory.getExceptionHandler(exception);
		exceptionHandler.handle(exception, request.toString());
	}
	
	protected void throwAnySynchronousException() throws ServiceClientException {
		if(synchronousException != null) {
			throw synchronousException;
		}
	}
	
	protected void validateRequestIsNotNull() {
		if(request == null) {
			String errorMessage = commandMapName + " request is null. Set command request before calling run(). Request validation failed, throwing a 400 response";
			throw new BadRequestException(new Throwable(errorMessage));
		}
	}

	protected void validateResponseIsNotNull(final Object serviceClientResponse) {
		if(serviceClientResponse == null) {
			String errorMessage = commandMapName + " response is null. Response validation failed, throwing a 404 response";
			throw new NotFoundException(new Throwable(errorMessage));
		}
	}
	
	protected void startMemoryInformationLogEvent(Logger log) {
		memoryEvent = createMemoryInformationEvent(getCommandMapName()+"-run()", getCommandMapDescription());
		startLoggingMemoryInformationEvent(log, XLogger.Level.DEBUG, memoryEvent);
	}
	
	protected void stopMemoryInformationLogEvent(Logger log) {
		stopLoggingMemoryInformationEvent(log, XLogger.Level.DEBUG, memoryEvent);	
	}
}
