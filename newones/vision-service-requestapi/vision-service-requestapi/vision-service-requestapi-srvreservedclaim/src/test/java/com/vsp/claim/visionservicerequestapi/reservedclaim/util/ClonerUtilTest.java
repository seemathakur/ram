package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.junit.MockObjectProvider;

public class ClonerUtilTest {
	
	private static final MockObjectProvider mockProvider = new MockObjectProvider();

	@Test
	public void testCloningClaim() throws Exception {
		Claim testClaim = getTestClaimFromJson();
		Claim claimClone = ClonerUtil.clone(testClaim);
		assertClaim(testClaim, claimClone);
	}

	private Claim getTestClaimFromJson() throws Exception {
		return (Claim) mockProvider.mockObjectFromJson("com/vsp/claim/visionservicerequestapi/reservedclaim/mapping/PreClaim.json", 
				Claim.class);
	}

	private void assertClaim(Claim testClaim, Claim claimClone) {
		assertNotNull(claimClone);
		assertTrue(testClaim != claimClone);
		assertEquals("202132159", claimClone.getClaimKey().getClaimNumber());
		assertEquals("00", claimClone.getClaimKey().getClaimExtNumber());
	}
	
	@Test
	public void testCloningClaimLine() throws Exception {
		ClaimLine claimLine = getClaimLineFromJson();
		ClaimLine clone = ClonerUtil.clone(claimLine);
		assertClaimLine(claimLine, clone);
	}
	
	private ClaimLine getClaimLineFromJson() throws IOException {
		return (ClaimLine) mockProvider.mockObjectFromJson("com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimLineRequest.json", 
				ClaimLine.class);
	}
	
	private void assertClaimLine(ClaimLine original, ClaimLine clone) {
		assertNotNull(clone);
		assertTrue(original != clone);
		assertEquals(1, (int) clone.getLineNumber());
		assertEquals("MV", clone.getClaimLineTypeCode());
		assertEquals(BigDecimal.valueOf(15.25), clone.getOutOfPocketAmount());
	}

}
