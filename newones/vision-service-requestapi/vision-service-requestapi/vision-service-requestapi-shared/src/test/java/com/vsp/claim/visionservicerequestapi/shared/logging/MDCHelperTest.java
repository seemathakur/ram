package com.vsp.claim.visionservicerequestapi.shared.logging;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.MDC;

import com.vsp.il.service.ServiceContext;
import com.vsp.il.util.Preferences;

public class MDCHelperTest{
	
	private MDCHelper mdcHelper = new MDCHelper();
	String claimStr = MDCDataElements.CLAIM_KEY.getValue();
	
	private class DummyThread extends Thread {
		
		private Logger logger;
		private String key;
		private String value;

		public DummyThread(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
	    public void run() {
			MDCHelper helper = new MDCHelper();
			Map<String, String> elementMap = new HashMap<>();
			elementMap.put(key, value);
			helper.put(elementMap);
			logger.info(MDC.get(MDCHelper.MDC_KEY));
		}
		
		public void setLogger(Logger logger) {
			this.logger = logger;
		}
	}
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		mdcHelper.clear();
	}
	
	@Test
	public void testMDCHelperPutWithValidStrings(){
		mdcHelperPut("Test1", "valid", "Test2", "valid");
		assertTrueForFields("Test1", "valid", "Test2", "valid");
	}
	
	@Test
	public void testMDCHelperPutWithEmptyStrings(){
		mdcHelperPut("", "value", "Test2", "");
		assertTrueForFields("", "value", "Test2", "");
	}
	
	@Test
	public void testClaimAndExtNumberValidValues(){
		initializeMDCForClaimString("Test1", "Test2");

		assertTrue(MDC.get(claimStr).equals("Test1-Test2"));
	}
	
	@Test
	public void testClaimAndExtNumberWithLineValidValues(){
		initializeMDCForClaimStringWithLine("Test1", "Test2", 100);
		
		assertTrue(MDC.get(claimStr).equals("Test1-Test2"));
		assertTrue(MDC.get(MDCDataElements.LINE_NUMBER.getValue()).equals("100"));
	}
	
	@Test
	public void testClaimNumberNullValue(){
		initializeMDCForClaimString(null, "Test2");
		assertNull(MDC.get(claimStr));
	}
	
	@Test
	public void testClaimAndExtNumberNullValues(){
		initializeMDCForClaimString(null, null);
		assertNull(MDC.get(claimStr));
	}
	
	@Test
	public void testMDCHelperPutWithNullElementMap(){
		Map<String, String> elementMap = null;
		try{
			mdcHelper.put(elementMap);
		}catch (IllegalArgumentException e){
			assertTrue(e.getMessage().equals("key parameter cannot be null"));
		}
	}
	
	@Test
	public void shouldKeepTheValuesOnSameThread(){
		Map<String, String> elementMap = new HashMap<>();
		elementMap.put("Test1", "value1");		
		mdcHelper.put(elementMap);
		
		MDCHelper mdcHelper2 = new MDCHelper();
		Map<String, String> elementMap2 = new HashMap<>();
		elementMap2.put("Test2", "1eulav");
		mdcHelper2.put(elementMap2);
		assertTrue(MDC.get("Test1").equals("value1"));
		assertTrue(MDC.get("Test2").equals("1eulav"));
	}
	
	@Test
	public void shouldNotKeepTheValuesAcrossDifferentThreads() throws InterruptedException{
		Logger loggerMockA = Mockito.mock(Logger.class);
		
		DummyThread threadA = new DummyThread("valueA", "A");
		DummyThread threadB = new DummyThread("valueB", "B");
		threadA.setLogger(loggerMockA);
		threadB.setLogger(loggerMockA);
		
		threadA.start();
		threadB.start();
		
		TimeUnit.SECONDS.sleep(1);
		
		//make sure both threads wrote the same string to the MDC map. Meaning the map is not shared across different threads
		//otherwise the value would be "valueA=A valueB=B " for the second thread.
		Mockito.verify(loggerMockA, Mockito.times(1)).info(Mockito.eq("valueA=A"));
		Mockito.verify(loggerMockA, Mockito.times(1)).info(Mockito.eq("valueB=B"));
	}
	
	@Test
	public void testMDCClear(){
		initializeMDCForClaimString("Test1", "Test2");

		mdcHelper.clear();
		assertNull(MDC.get(claimStr));
	}
	
	private void initializeMDCForClaimString(String claimNumber, String claimExtNumber){
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(MDCConfigurationTest.OPERATION)
			.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
			.setClaimNumber(claimNumber)
			.setClaimExtNumber(claimExtNumber)
			.configure();
	}
	
	private void initializeMDCForClaimStringWithLine(String claimNumber, String claimExtNumber, int lineNumber){
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(MDCConfigurationTest.OPERATION)
				.setTxnId(ServiceContext.getCurrentInstance().getTransactionID())
				.setClaimNumber(claimNumber)
				.setClaimExtNumber(claimExtNumber)
				.setLineNumber(lineNumber)
				.configure();
	}
	
	private void assertTrueForFields(String fieldName1, String fieldValue1, String fieldName2, String fieldValue2){
		assertTrue(MDC.get(fieldName1).equals(fieldValue1));
		assertTrue(MDC.get(fieldName2).equals(fieldValue2));
	}
	
	private void mdcHelperPut(String fieldName1, String fieldValue1, String fieldName2, String fieldValue2){
		
		Map<String, String> elementMap = new HashMap<>();
		elementMap.put(fieldName1, fieldValue1);
		elementMap.put(fieldName2, fieldValue2);
				
		mdcHelper.put(elementMap);
	}
}
