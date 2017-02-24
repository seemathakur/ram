package com.vsp.claim.visionservicerequestapi.shared.logging;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.vsp.il.util.Preferences;

public class EventTest{
	
	public static final String TEST_ID = "test";
	public static final String TEST_DESCRIPTION = "description";
	public static final String FIXED_MESSAGE_API = "Calling API";
	public static final String FIXED_MESSAGE_MEMORY = "Memory information";
	public static final String FIXED_MESSAGE_SERVICE = "Calling Service";
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}	

	@Test
	public void testApiInvocationEventName() {
		ApiInvocationEvent event = new ApiInvocationEvent(TEST_ID);
		Event e = event.begin();
		String id = e.getIdentifier();
		String fixed = e.getFixedMessage();
		assertEquals(id,TEST_ID);
		assertEquals(fixed,FIXED_MESSAGE_API);
	}
	
	@Test
	public void testApiInvocationEventNameDesc() {
		ApiInvocationEvent event = new ApiInvocationEvent(TEST_ID,TEST_DESCRIPTION);
		Event e = event.begin();
		String id = e.getIdentifier();
		String fixed = e.getFixedMessage();
		String desc = e.getDescription();
		String apiName = event.getApiName();
		assertEquals(id,TEST_ID);
		assertEquals(apiName,TEST_ID);
		assertEquals(fixed,FIXED_MESSAGE_API);
		assertEquals(desc,FIXED_MESSAGE_API + ":" + TEST_ID + ":" + TEST_DESCRIPTION);
	}
	
	@Test
	public void testServiceInvocationEventName() {
		ServiceInvocationEvent event = new ServiceInvocationEvent(TEST_ID);
		Event e = event.begin();
		String id = e.getIdentifier();
		String fixed = e.getFixedMessage();
		assertEquals(id,TEST_ID);
		assertEquals(fixed,FIXED_MESSAGE_SERVICE);
	}
	
	@Test
	public void testServiceInvocationEventNameDesc() {
		ServiceInvocationEvent event = new ServiceInvocationEvent(TEST_ID,TEST_DESCRIPTION);
		Event e = event.begin();
		String id = e.getIdentifier();
		String fixed = e.getFixedMessage();
		String desc = e.getDescription();
		String apiName = event.getServiceName();
		assertEquals(id,TEST_ID);
		assertEquals(apiName,TEST_ID);
		assertEquals(fixed,FIXED_MESSAGE_SERVICE);
		assertEquals(desc,FIXED_MESSAGE_SERVICE + ":" + TEST_ID + ":" + TEST_DESCRIPTION);
	}
	
	@Test 
	public void testGetDurationInMillis() throws InterruptedException {
		ApiInvocationEvent event = new ApiInvocationEvent(TEST_ID,TEST_DESCRIPTION);
		TimerEvent e = event.begin();
		Thread.sleep(1000);
		e.end();
		long dur = e.getDurationInMillis();
		Assert.assertTrue(dur-1>=0);
	}
	
	@Test
	public void testIsEnded() {
		ApiInvocationEvent event = new ApiInvocationEvent(TEST_ID,TEST_DESCRIPTION);
		Event e = event.begin();
		e.end();
		Assert.assertTrue(e.hasEnded());
	}
	
	@Test
	public void testIsNotEnded() {
		ApiInvocationEvent event = new ApiInvocationEvent(TEST_ID,TEST_DESCRIPTION);
		Event e = event.begin();
		Assert.assertTrue(!e.hasEnded());
	}

	@Test
	public void testMemoryInformationEventName() {
		MemoryInformationEvent event = new MemoryInformationEvent(TEST_ID);
		Event e = event.begin();
		String id = e.getIdentifier();
		String fixed = e.getFixedMessage();
		assertEquals(id,TEST_ID);
		assertEquals(fixed,FIXED_MESSAGE_MEMORY);
	}
	
	@Test
	public void testMemoryExecutionEventNameDesc() throws InterruptedException {
		MemoryInformationEvent event = new MemoryInformationEvent(TEST_ID,TEST_DESCRIPTION);
		Event e = event.begin();
		String id = e.getIdentifier();
		String fixed = e.getFixedMessage();
		String desc = e.getDescription();
		String processName = event.getProcessName();
		assertEquals(id,TEST_ID);
		assertEquals(processName,TEST_ID);
		assertEquals(fixed,FIXED_MESSAGE_MEMORY);
		assertEquals(desc,FIXED_MESSAGE_MEMORY + ":" + TEST_ID + ":" + TEST_DESCRIPTION);
	}
	
	@Test 
	public void testGetConsumedMemory() throws InterruptedException {
		MemoryInformationEvent event = new MemoryInformationEvent(TEST_ID,TEST_DESCRIPTION);
		MemoryEvent e = event.begin();
		// this is to consume some memory - 1 MB
		byte b[] = new byte[1048576];
		e.end();
		String memoryUsed = e.getConsumedMemory();
		if (StringUtils.contains(memoryUsed, "(")) {
			String memory = StringUtils.strip(memoryUsed, "()");
			Assert.assertTrue(Integer.parseInt(memory) >= 0);
		}
		else {
			Assert.assertTrue(Integer.parseInt(memoryUsed.trim()) >= 1048576);
		}
	}
}
