package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;

import org.hamcrest.Matchers;
import org.junit.rules.ExpectedException;

import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;

public class ExceptionAssertions {

	public static void createRuleAssertWebApplicationExpectionWithHTTPStatusCode(ExpectedException thrown, 
			int statusCode) {
		thrown.expect(WebApplicationException.class);
		thrown.expect(hasProperty("response", hasProperty("status", is(statusCode))));
	}
	
	
	public static void createRuleAssertServiceClientExceptionWithCause(ExpectedException thrown, Class exception) {
		thrown.expect(ServiceClientException.class);
		thrown.expectCause(org.hamcrest.Matchers.<Throwable>instanceOf(exception));
	}
	
	
	public static void createRuleAssertAsyncThrowsExecutionExceptionWrapsServiceClientExceptionWithCause(ExpectedException thrown, Class exception) {
		thrown.expect(ExecutionException.class);
		thrown.expect(hasProperty("cause", hasProperty("cause", Matchers.instanceOf(exception))));
		thrown.expectCause(org.hamcrest.Matchers.<Throwable>instanceOf(ServiceClientException.class));
	}
	
	
}
