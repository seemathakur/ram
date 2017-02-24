package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.factory.CommandFactory;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.jaxrs.client.RestClient;

@Service("commandMap")
public class CommandMapBuilderImpl implements CommandMapBuilder {

	@Autowired
	private List<CommandFactory> commandFactories;
	
	private static final Logger LOG = LoggerFactory.getLogger(CommandMapBuilderImpl.class);
	
	public List<CommandFactory> getCommandFactories() {
		return commandFactories;
	}

	public void setCommandFactories(List<CommandFactory> commandFactories) {
		this.commandFactories = commandFactories;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CommandMap buildCommandMap(VisionServiceRequestApiContext context, List<String> executableCommands) {
		CommandMap commandMap = new CommandMap();
		for(CommandFactory factory: commandFactories){	
			Command<?> command = factory.buildCommand();
			if(shouldExecuteCommand(command, executableCommands)){				
				executeCommand(command, context);
				commandMap = addCommandToMap(command, commandMap);
			}			
		}
		
		return commandMap;
	}
	
	private CommandMap addCommandToMap(Command<?> command, CommandMap commandMap) {
		CommandMap toReturn = commandMap; 
		commandMap.put(command.toString(), command);
		return toReturn;
	}

	private void buildRequest(VisionServiceRequestApiContext context, Command<?> command) {
		if(command instanceof Requestable){
			((Requestable)command).buildRequest(context);
		}
	}
	
	private void initializeRestClient(Command<?> command,RestClient<Home> restClient) {
		((RestCommand)command).initializeServiceClient(restClient);
		DebugLogger.debugEnabled(LOG,"RestClient initialized for command {}", command.toString());
	}

	private boolean shouldInitializeRestClient(Command<?> command) {
		return command instanceof RestCommand;
	}

	private void runCommand(Command<?> command) {
		DebugLogger.debugEnabled(LOG,"Run command: {}", command.toString());
		command.run();
	}

	private void executeCommand(Command<?> command, VisionServiceRequestApiContext context) {
		if(shouldInitializeRestClient(command)){
			initializeRestClient(command, context.getRestClient()); 
		}
		buildRequest(context, command);
		runCommand(command); 
	}

	private boolean shouldExecuteCommand(Command<?> commandToExecute, List<String> executableCommands) {
		return executableCommands.contains(commandToExecute.toString()); 
	}
}
