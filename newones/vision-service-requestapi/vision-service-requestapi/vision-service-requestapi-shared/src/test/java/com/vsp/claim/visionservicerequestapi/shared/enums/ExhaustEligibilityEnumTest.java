package com.vsp.claim.visionservicerequestapi.shared.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vsp.il.util.Preferences;

public class ExhaustEligibilityEnumTest {
	
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	
	@Test
	public void testYMapsToExhaust(){
		assertEquals(ExhaustEligibilityEnum.fromCode("Y"), ExhaustEligibilityEnum.EXHAUST);
	}
	
	@Test
	public void testNMapsToDoNotExhaust(){
		assertEquals(ExhaustEligibilityEnum.fromCode("N"), ExhaustEligibilityEnum.DO_NOT_EXHAUST);
	}
	
	@Test
	public void testAMapsToAdHoc(){
		assertEquals(ExhaustEligibilityEnum.fromCode("A"), ExhaustEligibilityEnum.AD_HOC);
	}
	
	@Test
	public void testFMapsToFuture(){
		assertEquals(ExhaustEligibilityEnum.fromCode("F"), ExhaustEligibilityEnum.EXHAUST_FUTURE_ELIGIBILITY);
	}
	
	@Test
	public void testXMapsToUnknown(){
		assertEquals(ExhaustEligibilityEnum.fromCode("X"), ExhaustEligibilityEnum.UNKNOWN);
	}

}
