package com.vsp.claim.visionservicerequestapi.servicerequest.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.CreateReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.NoEligibleServicesException;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMapBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.ExceptionAssertions;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.IssueLegacyAuthorizationServiceClient;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.client.RestLink;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={
		CreateVisionServiceRequestLifecycleBeanTest.Config.class
})
public class CreateVisionServiceRequestLifecycleBeanTest {

	static class Config {
		
		static {
			if(!Preferences.initialized()){
				Preferences.initialize();
			}
		}
		
		@Bean
		public ApiContext apiContext(){
			return mock(ApiContext.class);
		}
		
		@Bean
		public CommandMapBuilder commandMapBuilder(){
			return mock(CommandMapBuilder.class);
		}
		
		@Bean
		public CreateReservedClaimsBean createClaimsBean(){
			return mock(CreateReservedClaimsBean.class);
		}
		
		@Bean
		public PreClaimRepository preClaimRepository(){
			return mock(PreClaimRepository.class);
		}
		
		@Bean
		public CreateVisionServiceRequestLifecycleBean createVisionServiceRequestLfcBean(){
			return spy(new CreateVisionServiceRequestLifecycleBean(){

				@Override
				protected RestClient<Home> getRestClient() {
					return mockRestClient();
				}
				
			});
		}
		
		@Bean
		@Scope("prototype")
		public RestClient<Home> mockRestClient() {
			RestClient<Home> rc = mock(RestClient.class);
			RestLink link = mock(RestLink.class); 
			when(rc.link(Matchers.any(Link.class))).thenReturn(link);
			when(link.type(Claim.class)).thenReturn(link);
			when(link.body(Matchers.any(Claim.class))).thenReturn(link);
			when(link.method(HttpMethod.POST)).thenReturn(link);
			when(link.follow()).thenReturn(MockHelper.buildMockClaim());
			return rc; 
		}
	}

	@Autowired public CreateVisionServiceRequestLifecycleBean createVsrBean; 
	@Autowired CreateReservedClaimsBean createClaimsBean;
	@Autowired ApiContext mockApiContext; 
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	
	@Test
	public void testCreateNoServicesEligible() throws Exception{
		mockBuildClaimThrowsNoServicesEligible();
		createVsrBean.createVisionServiceRequest(MockHelper.CLIENT_ID, MockHelper.DIV_ID, MockHelper.POLICY_ID, 
				MockHelper.POLICY_ID, MockHelper.CONSUMER_ID, MockHelper.PRODUCT_PACKAGE, 
				MockHelper.EFFECTIVE_DATE.toString("yyyy-MM-dd"), MockHelper.buildVisionServiceRequest("GenExam")); 
		verifyZeroInteractions(createClaimsBean);
		verify(createVsrBean.getApiContext(), times(1)).setHTTPStatusCode(Response.Status.NO_CONTENT); 
		Mockito.reset(createClaimsBean, createVsrBean);
	}
	
	private void mockBuildClaimThrowsNoServicesEligible() throws ClaimBuilderException {
		Mockito.doThrow(new NoEligibleServicesException()).when(createVsrBean)
			.buildPreClaim(Matchers.any(VisionServiceRequestApiContext.class), 
					Matchers.any(CommandMap.class)); 
	}
	
	@Test
	public void testCreateVSR() throws Exception{
		mockBuildClaim();
		createVsrBean.createVisionServiceRequest(MockHelper.CLIENT_ID, MockHelper.DIV_ID, MockHelper.POLICY_ID, 
				MockHelper.POLICY_ID, MockHelper.CONSUMER_ID, MockHelper.PRODUCT_PACKAGE, 
				MockHelper.EFFECTIVE_DATE.toString("yyyy-MM-dd"), MockHelper.buildVisionServiceRequest("GenExam")); 
		verify(createClaimsBean, times(1)).create(Matchers.any(Claim.class));
		verify(createVsrBean, times(1))
			.createIssueLegacyAuthorizationServiceClient(Matchers.any(VisionServiceRequestApiContext.class)); 
		Mockito.reset(createClaimsBean, createVsrBean);
	}
	
	@Test
	public void testCreateVSRThrowsExceptionOnIssueAuthorization() throws Exception{
		ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		mockBuildClaim();
		Mockito.doThrow(new InternalServerErrorException()).when(createVsrBean).invokeAuthorizationBusinessService(Matchers.any(IssueLegacyAuthorizationServiceClient.class), Matchers.any(Claim.class));
		createVsrBean.createVisionServiceRequest(MockHelper.CLIENT_ID, MockHelper.DIV_ID, MockHelper.POLICY_ID, 
				MockHelper.POLICY_ID, MockHelper.CONSUMER_ID, MockHelper.PRODUCT_PACKAGE, 
				MockHelper.EFFECTIVE_DATE.toString("yyyy-MM-dd"), MockHelper.buildVisionServiceRequest("GenExam")); 
		verify(createClaimsBean, times(1)).create(Matchers.any(Claim.class));
		verify(createVsrBean, times(1))
			.createIssueLegacyAuthorizationServiceClient(Matchers.any(VisionServiceRequestApiContext.class)); 
		Mockito.reset(createClaimsBean, createVsrBean);
	}
	
	@Test
	public void testCreateWithEyeconicBatchClientId() throws Exception{
		when(mockApiContext.getClientId()).thenReturn("eyeconic-batch");
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(mockApiContext);
		
		List<String> commands = createVsrBean.buildExecutableCommandList(context); 
		assertTrue(commands.contains(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND));
	}
	
	@Test
	public void testCreateWithDrAccessToken() throws Exception{
		mockApiContext = MockHelper.mockApiContextWithAccessToken(MockHelper.mockAccessToken(MockHelper.TAX_ID, "0012", "129"));
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(mockApiContext);
		List<String> commands = createVsrBean.buildExecutableCommandList(context); 
		
		assertTrue(commands.contains(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND));
	}


	@Test 
	public void testCreateWithMemberAuthClientId() throws Exception{
		when(mockApiContext.getClientId()).thenReturn("vsp-retail"); 
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(mockApiContext);
		
		List<String> commands = createVsrBean.buildExecutableCommandList(context); 
		assertFalse(commands.contains(CommandMap.RETRIEVE_ACCESS_POINT_COMMAND));
	}
	
	@Test
	public void testCreateWithoutLegacyAuth() throws Exception{
		mockBuildClaim();
		Preferences.set("authorization", "EnableLegacyAuthorizationBridge", "false");
		createVsrBean.createVisionServiceRequest(MockHelper.CLIENT_ID, MockHelper.DIV_ID, MockHelper.POLICY_ID, 
				MockHelper.POLICY_ID, MockHelper.CONSUMER_ID, MockHelper.PRODUCT_PACKAGE, 
				MockHelper.EFFECTIVE_DATE.toString("yyyy-MM-dd"), MockHelper.buildVisionServiceRequest("GenExam")); 
		verify(createClaimsBean, times(1)).create(Matchers.any(Claim.class));
		verify(createVsrBean, times(0))
			.createIssueLegacyAuthorizationServiceClient(Matchers.any(VisionServiceRequestApiContext.class)); 
		Mockito.reset(createClaimsBean, createVsrBean);
		Preferences.set("authorization", "EnableLegacyAuthorizationBridge", "true");
	}

	private void mockBuildClaim() throws ClaimBuilderException {
		Mockito.doReturn(MockHelper.buildMockClaim()).when(createVsrBean)
			.buildPreClaim(Matchers.any(VisionServiceRequestApiContext.class), 
					Matchers.any(CommandMap.class)); 
	}
}
