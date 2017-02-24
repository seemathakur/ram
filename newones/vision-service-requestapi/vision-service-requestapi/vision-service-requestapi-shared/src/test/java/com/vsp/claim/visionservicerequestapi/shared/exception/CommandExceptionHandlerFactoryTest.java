package com.vsp.claim.visionservicerequestapi.shared.exception;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;

import org.junit.Before;
import org.junit.Test;

import com.vsp.il.util.Preferences;

public class CommandExceptionHandlerFactoryTest {
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}

	@Test
	public void testServiceClientExceptionHandler() {
		ServiceClientException exception = new ServiceClientException("", new MockCommandRequest());
		CommandExceptionHandler exceptionHandler = CommandExceptionHandlerFactory.getExceptionHandler(exception);
		assertNotNull(exceptionHandler);
		assertTrue(exceptionHandler instanceof ServiceClientCommandExceptionHandler);
	}
	
	@Test
	public void testConcurrencyExecutionExceptionHandler() {
		ExecutionException exception = new ExecutionException(new WebApplicationException(400));
		CommandExceptionHandler exceptionHandler = CommandExceptionHandlerFactory.getExceptionHandler(exception);
		assertNotNull(exceptionHandler);
		assertTrue(exceptionHandler instanceof ConcurrencyExecutionExceptionHandler);
	}
	
	@Test
	public void testGenericExceptionHandler() {
		IllegalArgumentException exception = new IllegalArgumentException();
		CommandExceptionHandler exceptionHandler = CommandExceptionHandlerFactory.getExceptionHandler(exception);
		assertNotNull(exceptionHandler);
		assertTrue(exceptionHandler instanceof GenericCommandExceptionHandler);
	}

}
