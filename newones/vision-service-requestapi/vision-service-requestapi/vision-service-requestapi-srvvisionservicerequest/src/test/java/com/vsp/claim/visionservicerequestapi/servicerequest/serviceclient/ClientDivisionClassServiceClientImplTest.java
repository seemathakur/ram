package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vsp.api.client.model.ClientDivision;
import com.vsp.api.client.model.ClientDivisionKey;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveClientDivisionCommandRequest;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.client.RestLink;
import com.vsp.oauth.AccessToken;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		ClientDivisionServiceClientImpl.class,
		ClientDivisionClassServiceClientImplTest.Config.class
})
public class ClientDivisionClassServiceClientImplTest {
	
		@Configuration
		static class Config {
						
			static {
				if(!Preferences.initialized()) {
					Preferences.initialize();
				}
			}
		}

		
	@Mock
	private RestClient<Home> mockRestClient;
	
	@Autowired @InjectMocks
	private ClientDivisionServiceClient clientDivisionClassServiceClient;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private ClientDivision response;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void tearDown() throws Exception {
		response = null;
	}
	
	@Test
	public void testSuccessfulClientCall() throws Exception {
		RetrieveClientDivisionCommandRequest request = buildClientCommandRequest();
		mockRetrieveClientDivision(mockFollowClientDivisionRestLinkSuccessfully());
		response = clientDivisionClassServiceClient.retrieveClientDivision(request).get();
 		assertSuccessfulCall();
	}
	
	@SuppressWarnings("unchecked")
	private void mockRetrieveClientDivision(RestLink<ClientDivision> restLink){
		when(mockRestClient.link(any(Link.class))).thenReturn(restLink);
	}
	
	private ClientDivision buildMockClientDivisionResponse() throws JsonParseException, JsonMappingException, IOException{
		ClientDivision clientDivision = new ClientDivision();
		ClientDivisionKey key = new ClientDivisionKey();
		key.setClientId("00857001");
		clientDivision.setKey(key);
		return clientDivision; 
	}

	private RetrieveClientDivisionCommandRequest buildClientCommandRequest() {
		RetrieveClientDivisionCommandRequest request = new RetrieveClientDivisionCommandRequest();
		request.setClientId("00857001");
		request.setDivisionId("0100"); 
		request.setAccessToken(mock(AccessToken.class));
		request.setAsOfDate("2016-04-01");
		return request;
	}
	
	
	private void runRetrieveDivisionClass(RetrieveClientDivisionCommandRequest request) throws Exception {
		response = clientDivisionClassServiceClient.retrieveClientDivision(request).get();
	}
	
	private void assertSuccessfulCall() {
		assertTrue("TestDivisionClassSoapServiceClient::assertSuccessfulCall"
				+ ":: Expected Client result to not be null", response != null);
		assertEquals("TestDivisionClassSoapServiceClient::assertSuccessfulCall"
				+ ":: Unexpected Client id.", 
				"00857001", response.getKey().getClientId());
	}
	
	@Test
	public void testRuntimeException() throws Exception{
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		RetrieveClientDivisionCommandRequest request = buildClientCommandRequest();
		mockRetrieveClientDivision(mockFollowClientDivisionRestLinkWithException());
		response = clientDivisionClassServiceClient.retrieveClientDivision(request).get();
		runRetrieveDivisionClass(request);
	}
	

	@SuppressWarnings("unchecked")
	private RestLink<ClientDivision> mockFollowClientDivisionRestLinkSuccessfully() {
		RestLink<ClientDivision> mockRestLink = mock(RestLink.class);
		when(mockRestLink.type(ClientDivision.class)).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
		when(mockRestLink.runas(any(AccessToken.class))).thenReturn(mockRestLink);
        when(mockRestLink.follow()).thenAnswer(new Answer<ClientDivision>() {
            @Override
            public ClientDivision answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                return buildMockClientDivisionResponse();
            }
        });
		return mockRestLink;
	}
	

	@SuppressWarnings("unchecked")
	private RestLink<ClientDivision> mockFollowClientDivisionRestLinkWithException() {
		RestLink<ClientDivision> mockRestLink = mock(RestLink.class);
		when(mockRestLink.type(ClientDivision.class)).thenReturn(mockRestLink);
		when(mockRestLink.method(HttpMethod.GET)).thenReturn(mockRestLink);
		when(mockRestLink.runas(any(AccessToken.class))).thenReturn(mockRestLink);
        when(mockRestLink.follow()).thenAnswer(new Answer<ClientDivision>() {
            @Override
            public ClientDivision answer(InvocationOnMock invocation) throws Throwable {
                Thread.sleep(250);
                throw new WebApplicationException();
            }
        });
		return mockRestLink;
	}
	
}
