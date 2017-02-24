package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimStatusEnum;
import com.vsp.il.util.Preferences;

public class ReservedClaimStatusEnumTest {
	private static final String INVALID_RESERVED = "IR";
	private static final String RESERVED = "RS";
	private static final String DELETED = "DE";
	private static final String UNKNOWN = "";
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testInvalidReservedCode() {
		assertEquals(INVALID_RESERVED, ReservedClaimStatusEnum.INVALID_RESERVED.getStatusCode());
	}
	
	@Test
	public void testReservedCode() {
		assertEquals(RESERVED, ReservedClaimStatusEnum.RESERVED.getStatusCode());
	}
	
	@Test
	public void testAbandonedCode() {
		assertEquals(DELETED, ReservedClaimStatusEnum.DELETED.getStatusCode());
	}
	
	@Test
	public void testUnknownCode() {
		assertEquals(UNKNOWN, ReservedClaimStatusEnum.UNKNOWN.getStatusCode());
	}
	
	@Test
	public void testFromStatusCodeUNKOWN() {
		assertEquals(ReservedClaimStatusEnum.UNKNOWN, ReservedClaimStatusEnum.fromStatusCode(null));
		assertEquals(ReservedClaimStatusEnum.UNKNOWN, ReservedClaimStatusEnum.fromStatusCode("Not match"));		
	}
	
	@Test
	public void testFromStatusCodeRESERVED() {
		assertEquals(ReservedClaimStatusEnum.RESERVED, ReservedClaimStatusEnum.fromStatusCode("RS"));		
	}
	
	@Test
	public void testFromStatusCodeINVALID() {
		assertEquals(ReservedClaimStatusEnum.INVALID_RESERVED, ReservedClaimStatusEnum.fromStatusCode("IR"));		
	}
	
	@Test
	public void testFromStatusCodeDELETED() {
		assertEquals(ReservedClaimStatusEnum.DELETED, ReservedClaimStatusEnum.fromStatusCode("DE"));
	}
	
}
