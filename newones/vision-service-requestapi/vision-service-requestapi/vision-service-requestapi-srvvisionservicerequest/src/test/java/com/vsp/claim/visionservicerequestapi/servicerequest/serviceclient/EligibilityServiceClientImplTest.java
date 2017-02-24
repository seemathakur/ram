package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.core.Link;
import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveEligibilityCommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.client.RestLink;
import com.vsp.oauth.AccessToken;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		EligibilityServiceClientImplTest.Config.class,
		EligibilityServiceClientImpl.class
})
public class EligibilityServiceClientImplTest {
	
	@Configuration
	public static class Config {
		{
			if(!Preferences.initialized()) {
				Preferences.initialize();
			}
		}
	}
	
	@Mock
	private RestClient<Home> mockRestClient;
	
	@Autowired @InjectMocks
	private EligibilityServiceClient eligibilityServiceClient;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private RetrieveEligibilityCommandRequest request;
	private Eligibility response;
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void tearDown() throws Exception {
		response = null;
	}


	@Test
	public void testSuccessfulEligibilityCall() throws Exception {
		buildRequest();
		mockRetrieveEligibility(mockFollowEligibilityRestLinkSuccessfully());
		getEligibilityResponse();
		assertSuccessfulEligibilityResponse();
	}
	

	@Test
	public void testFollowLinkToEligibilityThrowsWebApplicationException() throws Exception {		
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		buildRequest();
		mockRetrieveEligibility(mockFollowEligibilityRestLinkThrowsWebApplicationException());
		getEligibilityResponse();
	}
	

	@Test(expected=RuntimeException.class)
	public void testFollowLinkToEligibilityThrowsRuntimeException() throws Exception {
		buildRequest();
		mockRetrieveEligibility(mockFollowEligibilityRestLinkThrowsRuntimeException());
		getEligibilityResponse();
	}
	
	private void buildRequest() {
		request = new RetrieveEligibilityCommandRequest();
		request.setClientId("00857001");
		request.setDivisionId("0100");
		request.setSubscriberId("858017570");
		request.setConsumerId("1562475");
		request.setAccessToken(new AccessToken());
	}
		
		
	private void getEligibilityResponse() throws ServiceClientException, InterruptedException, ExecutionException {
		response = eligibilityServiceClient.retrieveEligibility(request).get();
	}
	
	private void assertSuccessfulEligibilityResponse() {
		assertNotNull("ClientProductServiceClientTest::assertSuccessfulProductCall::Response is null. Expected not null", response);
	}
	
	@SuppressWarnings("unchecked")
	private void mockRetrieveEligibility(RestLink<Eligibility> restLink){
		when(mockRestClient.link(any(Link.class))).thenReturn(restLink);
	}
	
	@SuppressWarnings("unchecked")
	private RestLink<Eligibility> mockFollowEligibilityRestLinkSuccessfully() {
		RestLink<Eligibility> mockRestLink = mock(RestLink.class);
		when(mockRestLink.type(Eligibility.class)).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
		when(mockRestLink.runas(any(AccessToken.class))).thenReturn(mockRestLink);
        when(mockRestLink.follow()).thenAnswer(new Answer<Eligibility>() {
            @Override
            public Eligibility answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                return new Eligibility();
            }
        });
		return mockRestLink;
	}
	
	@SuppressWarnings("unchecked")
	private RestLink<Eligibility> mockFollowEligibilityRestLinkThrowsWebApplicationException() {
		RestLink<Eligibility> mockRestLink = mock(RestLink.class);
		when(mockRestLink.type(Eligibility.class)).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
		when(mockRestLink.runas(any(AccessToken.class))).thenReturn(mockRestLink);
        when(mockRestLink.follow()).thenAnswer(new Answer<Eligibility>() {
            @Override
            public Eligibility answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                throw new WebApplicationException();
            }
        });
		return mockRestLink;
	}
	
	@SuppressWarnings("unchecked")
	private RestLink<Eligibility> mockFollowEligibilityRestLinkThrowsRuntimeException() {
		RestLink<Eligibility> mockRestLink = mock(RestLink.class);
		when(mockRestLink.type(Eligibility.class)).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
		when(mockRestLink.runas(any(AccessToken.class))).thenReturn(mockRestLink);
        when(mockRestLink.follow()).thenAnswer(new Answer<Eligibility>() {
            @Override
            public Eligibility answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                throw new RuntimeException();
            }
        });
		return mockRestLink;
	}

}
