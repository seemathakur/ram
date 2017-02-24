package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.scheduling.annotation.AsyncResult;

import com.vsp.api.client.model.ClientDivision;
import com.vsp.api.client.model.ClientDivisionKey;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveClientDivisionCommandRequest;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveClientDivisionCommandRequestBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.ClientDivisionServiceClientImpl;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.AccessToken;

public class RetrieveClientDivisionCommandTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Mock
	private ClientDivisionServiceClientImpl mockClient;
	
	@InjectMocks
	private RetrieveClientDivisionCommand clientCommand;
	
	private RetrieveClientDivisionCommandRequest request;
	private ClientDivision result;

	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
		request = null;
		result = null;
	}

	@Test
	public void testSuccessfulCommand() throws Exception {
		buildClientCommandRequest();
		ClientDivision mockResult = mockClientResult();
		mockCommandBehavior(mockResult);
		runCommand();
		populateResult();
		assertSuccessfulCommandResult();
	}
	
	private void buildClientCommandRequest() {
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		AccessToken accessToken = Mockito.mock(AccessToken.class);
		ApiContext apiContext = Mockito.mock(ApiContext.class);
		Mockito.when(apiContext.getAccessToken()).thenReturn(accessToken);
		context.setApiContext(apiContext);
		context.setApiContext(apiContext);
		request = RetrieveClientDivisionCommandRequestBuilder.buildRequest(context); 	
	}

	private ClientDivision mockClientResult() throws Exception {
		ClientDivision clientDivision = new ClientDivision();
		ClientDivisionKey key = new ClientDivisionKey();
		key.setClientId("00857001");
		clientDivision.setKey(key);
		return clientDivision; 
	}

	private void mockCommandBehavior(ClientDivision mockResult) throws ServiceClientException {
		setCommandRequest();
		when(mockClient.retrieveClientDivision(request)).thenReturn(new AsyncResult<ClientDivision>(mockResult));
	}
		
	private void setCommandRequest() {
		clientCommand.setRequest(request);
	}

	private void runCommand() {
		clientCommand.run();
	}
	
	private void populateResult() {
		result = clientCommand.getReturnValue();
	}

	private void assertSuccessfulCommandResult() {
		assertTrue("TestRetrieveClientCommand::testSuccessfulCommand:: Expected result to not be null.", result != null);
	}
	
	@Test
	public void testNullClientResponseThrowsHTTP404() throws ServiceClientException {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.NOT_FOUND.getStatusCode());
		buildClientCommandRequest();
		ClientDivision mockResult = null;
		mockCommandBehavior(mockResult);
		runCommand();
		populateResult();
	}
	
	@Test
	public void testNullClientCommandRequestThrowsHTTP400() {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.BAD_REQUEST.getStatusCode());
		runCommand();
	}
		
}
