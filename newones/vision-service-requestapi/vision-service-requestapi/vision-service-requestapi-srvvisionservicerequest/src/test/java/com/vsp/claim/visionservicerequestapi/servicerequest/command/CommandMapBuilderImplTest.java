package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.factory.CommandFactory;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.command.Command;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;

public class CommandMapBuilderImplTest {
	
	private CommandMapBuilderImpl builder;
	
	@Mock private RetrieveEligibilityCommand retrieveEligibilityCommand;
	@Mock private RetrieveAccessPointCommand retrieveAccessPointCommand; 
	@Mock private CommandFactory retrieveEligibilityCommandFactory;
	@Mock private CommandFactory retrieveProductCommandFactory;
	@Mock private CommandFactory retrieveAccessPointCommandFactory;
	@Mock private RestClient<Home> restClient; 
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void buildCommandMapWithCommandNames() throws Exception{
		mockCommands(); 
		List<String> commandsToBuild = new ArrayList<String>(); 
		commandsToBuild.add(CommandMap.RETRIEVE_ELIGBILITY_COMMAND);
		
		CommandMap commandMap = builder.buildCommandMap(buildReservedClaimContext(), commandsToBuild);
		assertNotNull(commandMap);
	
		assertTrue(commandMap.containsKey(CommandMap.RETRIEVE_ELIGBILITY_COMMAND));
		assertFalse(commandMap.containsKey(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND));
		
		verifyCommand(retrieveEligibilityCommand);
		verifyCommandFactory(retrieveEligibilityCommandFactory); 
		
		verifyCommandHasNoInvocations(retrieveAccessPointCommand);
	}
	
	private void verifyCommandHasNoInvocations(Command command) {
		Mockito.verify(((Requestable)command), Mockito.never()).buildRequest(Matchers.any(VisionServiceRequestApiContext.class));
		Mockito.verify(command, Mockito.never()).run();
	}

	private void verifyCommandFactory(CommandFactory commandFactory) {
		Mockito.verify(commandFactory).buildCommand();
	}

	private void verifyCommand(Command command) {
		Mockito.verify(((Requestable)command)).buildRequest(Matchers.any(VisionServiceRequestApiContext.class));
		Mockito.verify(command).run();
	}

	@Test(expected = WebApplicationException.class)
	public void buildCommandMapThrowsException() throws Exception{
		List<String> commandsToBuild = new ArrayList<String>(); 
		commandsToBuild.add(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND);
		
		mockExceptionCommands(); 
		CommandMap commandMap = builder.buildCommandMap(buildReservedClaimContext(), commandsToBuild);
		assertNotNull(commandMap);
		assertTrue(commandMap.containsKey(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND));
	}
	
	private VisionServiceRequestApiContext buildReservedClaimContext(){
		return MockHelper.buildVisionServiceRequestApiContext();
	}
		
	private void mockCommands() throws Exception{
		initializeCommandMapBuilder(); 
		
		mockCommand(retrieveEligibilityCommand, CommandMap.RETRIEVE_ELIGBILITY_COMMAND);
		mockCommandFactory(retrieveEligibilityCommandFactory, retrieveEligibilityCommand); 
		builder.getCommandFactories().add(retrieveEligibilityCommandFactory);
		
		
		mockCommand(retrieveAccessPointCommand, CommandMap.RETRIEVE_ACCESS_POINT_COMMAND);
		mockCommandFactory(retrieveAccessPointCommandFactory, retrieveAccessPointCommand);
		builder.getCommandFactories().add(retrieveAccessPointCommandFactory);
	}
	
	private void initializeCommandMapBuilder() {
		builder = new CommandMapBuilderImpl();
		builder.setCommandFactories(new ArrayList<CommandFactory>());
	}

	private void mockCommandFactory(CommandFactory commandFactory, Command command) {
		when(commandFactory.buildCommand()).thenReturn(command);
	}

	private void mockCommand(Command command, String commandName) {
		doNothing().when((RestCommand)command).initializeServiceClient(restClient);
		doNothing().when((Requestable)command).buildRequest(Matchers.any(VisionServiceRequestApiContext.class));
		doNothing().when(command).run();
		doReturn(commandName).when(command).toString();
	}
	
	@SuppressWarnings("unchecked")
	private void mockExceptionCommands() throws Exception{
		initializeCommandMapBuilder();
		builder.getCommandFactories().add(retrieveAccessPointCommandFactory);

		when(retrieveAccessPointCommandFactory.buildCommand()).thenReturn(retrieveAccessPointCommand);
		when(retrieveAccessPointCommand.toString()).thenReturn(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND); 
		doNothing().when(retrieveAccessPointCommand).buildRequest(Matchers.any(VisionServiceRequestApiContext.class));
		doNothing().when(retrieveAccessPointCommand).initializeServiceClient(mock(RestClient.class));
		doThrow(new WebApplicationException()).when(retrieveAccessPointCommand).run();
	}

}
