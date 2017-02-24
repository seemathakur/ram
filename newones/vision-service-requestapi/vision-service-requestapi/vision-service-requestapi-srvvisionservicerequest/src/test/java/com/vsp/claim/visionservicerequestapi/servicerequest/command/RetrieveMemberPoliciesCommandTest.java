package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.ExceptionAssertions.createRuleAssertWebApplicationExpectionWithHTTPStatusCode;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import javax.ws.rs.BadRequestException;
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

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveMemberPolicyCommandRequest;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockObjectProvider;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.MemberPolicyServiceClientImpl;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.il.util.Preferences;

public class RetrieveMemberPoliciesCommandTest {

	private RetrieveMemberPolicyCommandRequest request;
	private MemberPolicy result;
	private MockObjectProvider mockProvider;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Mock
	private MemberPolicyServiceClientImpl mockClient;

	@InjectMocks
	private RetrieveMemberPoliciesCommand memberPoliciesCommand;
		
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
		mockProvider = new MockObjectProvider();
	}

	@After
	public void tearDown() throws Exception {
		request = null;
		result = null;
	}

	@Test
	public void testSuccessfulCommand() throws Exception {
		buildMemberPoliciesRequest();
		mockRestClientInvocation(mockMemberPolicyResult());
		runCommand();
		populateResult();
		assertSuccessfulCommandResult();
	}
	

	@Test
	public void testInternalServerExceptionCommandTransformsToWebAppException() throws Exception {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		buildMemberPoliciesRequest();
		mockServiceClientThrowsWebApplicationException();
		runCommand();
		populateResult();
	}
	
	@Test
	public void testNullResultThrowsNotFoundExceptionHTTP404() throws Exception {
		createRuleAssertWebApplicationExpectionWithHTTPStatusCode(thrown, Response.Status.NOT_FOUND.getStatusCode());
		buildMemberPoliciesRequest();
		mockRestClientInvocation(null);
		runCommand();
		populateResult();
	}

	private void buildMemberPoliciesRequest() {
		request = new RetrieveMemberPolicyCommandRequest();
		request.setClientId("00857001");
		request.setDivisionId("0100");
		request.setSubscriberId("858017570");
		request.setAsOfDate("2014-05-28");
		memberPoliciesCommand.setRequest(request);
	}

	private MemberPolicy mockMemberPolicyResult() throws Exception {
		return (MemberPolicy) mockProvider.mockObjectFromJson("com/vsp/claim/memberpolicy/mock/858017570.json", MemberPolicy.class);
	}

	private void runCommand() throws Exception {
		memberPoliciesCommand.run();
	}

	private void populateResult() throws Exception {
		result = (MemberPolicy)memberPoliciesCommand.getReturnValue();
	}

	private void assertSuccessfulCommandResult() {
		assertTrue("TestRetrieveEligibilityCommand::testSuccessfulCommand::"
				+ " Expected result to not be null.", result != null);
	}

	@Test(expected=BadRequestException.class)
	public void testNullMemberPolicyCommandRequestThrowsBadRequestException() throws Exception {
		runCommand();
	}
	
	
	@SuppressWarnings("unchecked")
	private void mockRestClientInvocation(MemberPolicy mockResult) throws Exception {
		when(mockClient.retrieveMemberPolicy(Matchers.any(CommandRequest.class))).
		thenReturn(new AsyncResult<MemberPolicy>(mockResult)); 
	}
	
	private void mockServiceClientThrowsWebApplicationException() throws ServiceClientException {
		when(mockClient.retrieveMemberPolicy(Matchers.any(CommandRequest.class))).
		thenThrow(new InternalServerErrorException()); 
	}
	

}
