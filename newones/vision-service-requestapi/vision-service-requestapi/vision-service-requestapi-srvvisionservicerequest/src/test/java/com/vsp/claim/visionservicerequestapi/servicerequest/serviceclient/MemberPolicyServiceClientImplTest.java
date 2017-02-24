package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.concurrent.Future;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveMemberPolicyCommandRequest;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.client.RestLink;
import com.vsp.oauth.AccessToken;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		MemberPolicyServiceClientImplTest.Config.class
})
public class MemberPolicyServiceClientImplTest {
	
	@Configuration
	static class Config {
		static {
			if(!Preferences.initialized()) {
				Preferences.initialize();
			}
		}
		
		@SuppressWarnings("unchecked")
		@Bean
		public RestClient<Home> restClient(){
			return mock(RestClient.class);
		}
	}
	
	@Autowired
	private RestClient<Home> mockRestClient;
	
	private MemberPolicyServiceClientImpl memberPolicyServiceClient;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		initMocks(this);
		memberPolicyServiceClient = new MemberPolicyServiceClientImpl();
		memberPolicyServiceClient.setRestClient(mockRestClient);
	}

	@Test
	public void testSuccessfulServiceClientCall() throws Exception {
		RetrieveMemberPolicyCommandRequest commandRequest = buildTestRequest();
		mockRestClientInvocation(mockMemberPoliciesRestLink());
		Future<MemberPolicy> response = memberPolicyServiceClient.retrieveMemberPolicy(commandRequest);
		MemberPolicy retrievedResult = response.get();
		assertNotNull(retrievedResult);
	}
	
	@Test
	public void searchByMemberPolicyKeyThrows500WebApplicationException() throws Exception {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		RetrieveMemberPolicyCommandRequest testRequest = buildTestRequest();
		mockRestClientInvocation(mockMemberPoliciesRestLinkThrows500WebAppException());
		memberPolicyServiceClient.retrieveMemberPolicy(testRequest);
	}
		
	private RetrieveMemberPolicyCommandRequest buildTestRequest() {
		RetrieveMemberPolicyCommandRequest testRequest = new RetrieveMemberPolicyCommandRequest();
		testRequest.setClientId("00857001");
		testRequest.setDivisionId("0100");
		testRequest.setSubscriberId("858017570");
		testRequest.setAsOfDate("2015-01-01");
		testRequest.setAccessToken(mock(AccessToken.class));
		return testRequest;
	}
	
	@SuppressWarnings("unchecked")
	private void mockRestClientInvocation(RestLink<MemberPolicy> mockRestLink) throws Exception {
		when(mockRestClient.link(any(Link.class))).thenReturn(mockRestLink);;
	}
	
	private RestLink<MemberPolicy> mockMemberPoliciesRestLink() {
		RestLink<MemberPolicy> mockRestLink =  mockRestLink();
        when(mockRestLink.follow()).thenAnswer(new Answer<MemberPolicy>() {
            @Override
            public MemberPolicy answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                return new MemberPolicy();
            }
        });
		return mockRestLink;
	}
	
	private RestLink<MemberPolicy> mockMemberPoliciesRestLinkThrows500WebAppException() {
		RestLink<MemberPolicy> mockRestLink =  mockRestLink();
        when(mockRestLink.follow()).thenAnswer(new Answer<MemberPolicy>() {
            @Override
            public MemberPolicy answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
            }
        });
		return mockRestLink;
	}
	
	@SuppressWarnings("unchecked")
	private RestLink<MemberPolicy> mockRestLink(){
		RestLink<MemberPolicy> mockRestLink = mock(RestLink.class);
		when(mockRestLink.param(anyString(), anyString())).thenReturn(mockRestLink);
		when(mockRestLink.type(MemberPolicy.class)).thenReturn(mockRestLink);
		when(mockRestLink.runas(any(AccessToken.class))).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
		return mockRestLink;
	}

}
