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
import com.vsp.claim.visionservicerequestapi.servicerequest.command.RetrieveMemberPoliciesCommand;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.MemberPolicyServiceClientImpl;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.RestClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		RetrieveMemberPolicyCommandFactoryTest.Config.class,
		MemberPolicyServiceClientImpl.class	
})
public class RetrieveMemberPolicyCommandFactoryTest {
	@Configuration
	static class Config {
		@Bean
		@Scope("prototype")
		public RetrieveMemberPoliciesCommand memberPolicyCommand() {
			return new RetrieveMemberPoliciesCommand();
		}
		
		@Bean(name = "retrieveMemberPoliciesCommandFactory")
		public RetrieveMemberPolicyCommandFactory memberPolicyCommandFactory() {
			return new RetrieveMemberPolicyCommandFactory() {
				@Override
				protected RetrieveMemberPoliciesCommand createRetrieveMemberPoliciesCommand() {
					return memberPolicyCommand();
				}

			};
		}
	}
	@Autowired
	private RetrieveMemberPolicyCommandFactory factory;
	
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
		RetrieveMemberPoliciesCommand builtCommand = 
				(RetrieveMemberPoliciesCommand) factory.buildCommand();
		((RestCommand)builtCommand).initializeServiceClient(restClient);
		assertNotNull(builtCommand);
		assertNotNull(builtCommand.getServiceClient());
		assertTrue(builtCommand.getServiceClient().getRestClient() == restClient);
	}
	
	@Test
	public void testBuildCommandBuildsSeperateCommands() {
		RetrieveMemberPoliciesCommand builtCommand = 
				(RetrieveMemberPoliciesCommand) factory.buildCommand();
		((RestCommand)builtCommand).initializeServiceClient(restClient);
		RetrieveMemberPoliciesCommand builtCommandTwo =
				(RetrieveMemberPoliciesCommand) factory.buildCommand();
		((RestCommand)builtCommandTwo).initializeServiceClient(restClient);
		assertTrue(builtCommand != builtCommandTwo);
		assertTrue(builtCommand.getServiceClient() != builtCommandTwo.getServiceClient());
		assertTrue(builtCommandTwo.getServiceClient().getRestClient() == restClient);
		assertTrue(builtCommand.getServiceClient().getRestClient() == restClient);
		assertTrue(builtCommandTwo.getServiceClient().getRestClient() == builtCommand.getServiceClient().getRestClient());
	}

}
