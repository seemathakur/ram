package com.vsp.claim.visionservicerequestapi.shared.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;

import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.il.util.Preferences;

public class ServiceClientCommandExceptionHandlerTest {
	
	private ServiceClientCommandExceptionHandler exceptionHandler;

	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		exceptionHandler = new ServiceClientCommandExceptionHandler();		
	}
	
	@Test(expected = WebApplicationException.class)
	public void testCatchExecutionExceptionWithServiceClientException() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ServiceClientException thrownTestException = 
					buildTestExecutionExceptionThatHasServiceClientExceptionFrom404(request);
			exceptionHandler.handle(thrownTestException, request.toString());
		} catch(WebApplicationException e) {
			assertThrownException(e);
			throw e;
		}
	}

	private CommandRequest buildTestRetrieveMemberPoliciesRequest() {
		return new MockCommandRequest();
	}

	private void assertThrownException(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(404, e.getResponse().getStatus());
	}

	private ServiceClientException buildTestExecutionExceptionThatHasServiceClientExceptionFrom404(CommandRequest request) {
		WebApplicationException exceptionFor404 = new WebApplicationException(404);
		ServiceClientException causeException = new ServiceClientException("", request, exceptionFor404);
		return causeException;
	}
	
	@Test(expected = WebApplicationException.class)
	public void testWrappedServiceClientExceptionWithNoCause() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ServiceClientException thrownException = buildWrappedServceClientExceptionWithNoCause(request);
			exceptionHandler.handle(thrownException, request.toString());
		} catch(WebApplicationException e) {
			assertThrown400Exception(e);
			throw e;
		}
	}

	private ServiceClientException buildWrappedServceClientExceptionWithNoCause(CommandRequest request) {
		return new ServiceClientException("", request);
	}

	private void assertThrown400Exception(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(400, e.getResponse().getStatus());
	}
	
	@Test(expected = WebApplicationException.class)
	public void testWrappedServiceClientExceptionWithIllegalArgumentException() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ServiceClientException thrownException = buildWrappedServiceExceptionWithIllegalArgumentCause(request);
			exceptionHandler.handle(thrownException, request.toString());
		} catch(WebApplicationException e) {
			assertThrown500Exception(e);
			throw e;
		}
	}

	private ServiceClientException buildWrappedServiceExceptionWithIllegalArgumentCause(CommandRequest request) {
		IllegalArgumentException cause = new IllegalArgumentException();
		return new ServiceClientException("", request, cause);
	}

	private void assertThrown500Exception(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(500, e.getResponse().getStatus());
	}

}
