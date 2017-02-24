package com.vsp.claim.visionservicerequestapi.shared.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;

import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.il.util.Preferences;

public class GenericCommandExceptionHandlerTest {
	
	private GenericCommandExceptionHandler exceptionHandler;
	
	@Before
	public void setUp() {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		exceptionHandler = new GenericCommandExceptionHandler();
	}

	@Test(expected = WebApplicationException.class)
	public void testCatchInterruptedException() {
		try {
			InterruptedException testException = new InterruptedException();
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			exceptionHandler.handle(testException, request.toString());
		} catch(WebApplicationException e) {
			assertThrownException(e);
			throw e;
		}
		fail("Expected an exception to be thrown");
	}

	private CommandRequest buildTestRetrieveMemberPoliciesRequest() {
		return new MockCommandRequest();
	}

	private void assertThrownException(WebApplicationException e) {
		assertNotNull(e.getResponse());
		assertEquals(500, e.getResponse().getStatus());
	}
	
	@Test(expected = WebApplicationException.class)
	public void testCatchServiceClientException() {
		try {
			CommandRequest request = buildTestRetrieveMemberPoliciesRequest();
			ServiceClientException serviceClientException = new ServiceClientException("Stuff Broke!", request);
			exceptionHandler.handle(serviceClientException, request.toString());
		} catch(WebApplicationException e) {
			assertThrownException(e);
			throw e;
		}
		fail("Expected an exception to be thrown");
	}

}
