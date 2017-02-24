package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.scheduling.annotation.AsyncResult;

import com.vsp.api.core.Suspend;
import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.Notification;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.EligibilityServiceClientImpl;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.AccessToken;

public class RetrieveEligibilityCommandTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Mock
	private EligibilityServiceClientImpl mockClient;

	@InjectMocks
	private RetrieveEligibilityCommand eligibilityCommand;

	private Eligibility result;
	private List<Suspend> suspends; 
	private Eligibility mockResult; 
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
		buildReservedClaimRequestContext();
		mockResult = mockEligibilityResult();
	}

	@After
	public void tearDown() throws Exception {
		result = null;
		suspends = null;
	}

	@Test
	public void testSuccessfulCommandWithEligibilitySuspends() throws ServiceClientException{
		mockResult = setEligibilitySuspends(mockResult);
		mockCommandBehavior(mockResult);
		runCommand();
		populateResult();
		assertRequestContextContainsNotifications();
	}
	
	@Test
	public void testSuccessfulCommand() throws Exception {
		mockCommandBehavior(mockResult);
		runCommand();
		populateResult();
		assertSuccessfulCommandResult();
	}
	
	@Test
	public void testNullEligibilityResponseThrowsHTTP404() throws ServiceClientException {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.NOT_FOUND.getStatusCode());
		mockCommandBehavior(null);
		runCommand();
		populateResult();
	}
	
	@Test
	public void testGetEligibilityResponseThrowsHTTP500() throws InterruptedException, ExecutionException {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		mockServiceClientThrowsWebApplicationExceptionWrappedInExecutionException();
		runCommand();
		populateResult();
	}
	
	private void assertRequestContextContainsNotifications(){
		List<Notification> resultingNotifications = eligibilityCommand.getNotifications();
		assertEquals(suspends.get(0).getCode(), resultingNotifications.get(0).getCode());
		assertEquals(suspends.get(0).getDescription(), resultingNotifications.get(0).getDescription());
	}

	private Eligibility setEligibilitySuspends(Eligibility mockResult) {
		List<Suspend> suspends = buildSuspendsList();
		mockResult.setSuspends(suspends);
		return mockResult;
	}
	
	private List<Suspend> buildSuspendsList() {
		suspends = new ArrayList<Suspend>();
		Suspend suspend = new Suspend();
		suspend.setCode("PRELIQ0014");
		suspend.setDescription("MISSING/INV ADDRESS");
		suspends.add(suspend);
		return suspends;
	}

	private void buildReservedClaimRequestContext(){
		VisionServiceRequestApiContext requestContext = MockHelper.buildVisionServiceRequestApiContext();
		requestContext.setApiContext(mockApiContext());
		eligibilityCommand.buildRequest(requestContext);
	}
	
	private ApiContext mockApiContext() {
		ApiContext apiContext = mock(ApiContext.class);
		when(apiContext.getAccessToken()).thenReturn(new AccessToken());
		return apiContext;
	}

	private Eligibility mockEligibilityResult() {
		return new Eligibility();
	}

	private void mockCommandBehavior(Eligibility mockResult) throws ServiceClientException {
		when(mockClient.retrieveEligibility(Matchers.any(CommandRequest.class))).thenReturn(new AsyncResult<Eligibility>(mockResult));
	}
	
	private void runCommand() {
		eligibilityCommand.run();
	}

	private void populateResult() {
		result = eligibilityCommand.getReturnValue();
	}

	private void assertSuccessfulCommandResult() {
		assertTrue("TestRetrieveEligibilityCommand::testSuccessfulCommand::"
				+ " Expected result to not be null.", result != null);
	}
	
	@SuppressWarnings("unchecked")
	private void mockServiceClientThrowsWebApplicationExceptionWrappedInExecutionException() throws InterruptedException, ExecutionException{
		Future<Eligibility> result = mock(Future.class);
		when(result.get()).thenThrow(new ExecutionException(new InternalServerErrorException()));
		when(mockClient.retrieveEligibility(any(CommandRequest.class))).thenReturn(result);
	}

}
