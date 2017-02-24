package com.vsp.claim.visionservicerequestapi.shared.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;

import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.il.util.Preferences;

public class ConcurrencyExecutionExceptionHandlerTest {
	
	private ConcurrencyExecutionExceptionHandler exceptionHandler;
	

	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		exceptionHandler = new ConcurrencyExecutionExceptionHandler();
	}

	@Test(expected = WebApplicationException.class)
	public void testCatchExecutionExceptionWith404() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ExecutionException thrownTestException = buildTestExecutionException404();
			exceptionHandler.handle(thrownTestException, request.toString());
		} catch(WebApplicationException e) {
			assertThrownException404(e);
			throw e;
		}
	}
	
	@Test(expected = WebApplicationException.class)
	public void testCatchExecutionExceptionWith500() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ExecutionException thrownTestException = buildTestExecutionException500();
			exceptionHandler.handle(thrownTestException, request.toString());
		} catch(WebApplicationException e) {
			assertThrownException500(e);
			throw e;
		}
	}

	private CommandRequest buildTestRetrieveMemberPoliciesRequest() {
		return new MockCommandRequest();
	}

	private ExecutionException buildTestExecutionException404() {
		return new ExecutionException(new WebApplicationException(404));
	}
	
	private ExecutionException buildTestExecutionException500() {
		return new ExecutionException(new WebApplicationException(500));
	}

	private void assertThrownException404(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(404, e.getResponse().getStatus());
	}
	
	private void assertThrownException500(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(500, e.getResponse().getStatus());
	}
	
	@Test(expected = WebApplicationException.class)
	public void testCatchExecutionExceptionWithNullPointer() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ExecutionException thrownTestException = buildTestExecutionExceptionWithNullPointer();
			exceptionHandler.handle(thrownTestException, request.toString());
		} catch(WebApplicationException e) {
			assertThrown500Exception(e);
			throw e;
		}
	}

	private ExecutionException buildTestExecutionExceptionWithNullPointer() {
		return new ExecutionException(new NullPointerException());
	}

	private void assertThrown500Exception(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(500, e.getResponse().getStatus());
	}
	
	@Test(expected = WebApplicationException.class)
	public void testCatchExecutionExceptionWithServiceClientException() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ExecutionException thrownTestException = buildTestExecutionExceptionThatHasServiceClientExceptionFrom404(
					request);
			exceptionHandler.handle(thrownTestException, request.toString());
		} catch(WebApplicationException e) {
			assertThrownException404(e);
			throw e;
		}
	}

	private ExecutionException buildTestExecutionExceptionThatHasServiceClientExceptionFrom404(CommandRequest request) {
		WebApplicationException exceptionFor404 = new WebApplicationException(404);
		ServiceClientException causeException = new ServiceClientException("", request, exceptionFor404);
		return new ExecutionException(causeException);
	}
	
	@Test(expected = WebApplicationException.class)
	public void testWrappedServiceClientExceptionWithNoCause() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ExecutionException thrownException = buildWrappedServceClientExceptionWithNoCause(request);
			exceptionHandler.handle(thrownException, request.toString());
		} catch(WebApplicationException e) {
			assertThrown400Exception(e);
			throw e;
		}
	}

	private ExecutionException buildWrappedServceClientExceptionWithNoCause(CommandRequest request) {
		ServiceClientException causeException = new ServiceClientException("", request);
		return new ExecutionException(causeException);
	}

	private void assertThrown400Exception(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(400, e.getResponse().getStatus());
	}
	
	@Test(expected = WebApplicationException.class)
	public void testWrappedServiceClientExceptionWithIllegalArgumentException() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ExecutionException thrownException = buildWrappedServiceExceptionWithIllegalArgumentCause(request);
			exceptionHandler.handle(thrownException, request.toString());
		} catch(WebApplicationException e) {
			assertThrown500Exception(e);
			throw e;
		}
	}

	private ExecutionException buildWrappedServiceExceptionWithIllegalArgumentCause(CommandRequest request) {
		IllegalArgumentException cause = new IllegalArgumentException();
		ServiceClientException wrappedException = new ServiceClientException("", request, cause);
		return new ExecutionException(wrappedException);
	}

}
