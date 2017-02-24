package com.vsp.claim.visionservicerequestapi.servicerequest.command.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveAccessPointCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.AccessPointsServiceClientImpl;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RetrieveAccessPointCommandFactoryTest.Config.class,
		AccessPointsServiceClientImpl.class
})

public class RetrieveAccessPointCommandFactoryTest {
	
	@Configuration
	static class Config {
		@Bean
		@Scope("prototype")
		public RetrieveAccessPointCommand accessPointCommand() {
			return new RetrieveAccessPointCommand();
		}
		
		@Bean(name = "retrieveAccessPointCommandFactory")
		public CommandFactory retrieveAccessPointCommandFactory() {
			return new RetrieveAccessPointCommandFactory() {
				@Override
				protected RetrieveAccessPointCommand createAccessPointCommand() {
					return accessPointCommand();
				}

			};
		}
	}

	@Autowired
	private RetrieveAccessPointCommandFactory factory;
	
	@Mock
	private RestClient<Home> restClient; 
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testBuildCommand(){
		RetrieveAccessPointCommand builtCommand = 
				(RetrieveAccessPointCommand) factory.buildCommand();
		((RestCommand)builtCommand).initializeServiceClient(restClient);
		assertNotNull(builtCommand);
		assertNotNull(builtCommand.getServiceClient());
		assertTrue(builtCommand.getServiceClient().getRestClient() == restClient);
	}
	
	@Test
	public void testBuildCommandBuildsSeperateCommands() {
		RetrieveAccessPointCommand builtCommand = 
				(RetrieveAccessPointCommand) factory.buildCommand();
		((RestCommand)builtCommand).initializeServiceClient(restClient);
		RetrieveAccessPointCommand builtCommandTwo =
				(RetrieveAccessPointCommand) factory.buildCommand();
		((RestCommand)builtCommandTwo).initializeServiceClient(restClient);
		assertTrue(builtCommand != builtCommandTwo);
		assertTrue(builtCommand.getServiceClient() != builtCommandTwo.getServiceClient());
		assertTrue(builtCommandTwo.getServiceClient().getRestClient() == restClient);
		assertTrue(builtCommand.getServiceClient().getRestClient() == restClient);
		assertTrue(builtCommandTwo.getServiceClient().getRestClient() == builtCommand.getServiceClient().getRestClient());
	}

	

}
