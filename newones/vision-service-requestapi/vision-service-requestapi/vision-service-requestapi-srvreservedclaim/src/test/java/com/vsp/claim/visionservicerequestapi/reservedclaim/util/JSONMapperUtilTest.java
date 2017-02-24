package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;

public class JSONMapperUtilTest {
	
	private static final String TEST_CLAIM_STRING = "{\"claimKey\":{\"claimNumber\":\"1234567890\",\"claimExtNumber\":\"00\"},\"groupStateCode\":\"CA\",\"contactLensBoxCount\":0}";
	private static final ClaimKey TEST_CLAIM_KEY = new ClaimKey("1234567890", "00");
	private static final String TEST_STATE = "CA";

	@Test
	public void testConvertFromJSON() throws Exception {
		Claim testClaim = buildClaim();
		Claim claim = JSONMapperUtil.convertFromJSONString(TEST_CLAIM_STRING);
		assertClaim(testClaim, claim);
	}

	@Test
	public void testConvertToJSON() throws Exception {
		Claim testClaim = buildClaim();
		String message = JSONMapperUtil.convertToJSONString(testClaim);
		assertEquals(message, TEST_CLAIM_STRING);
	}

	
	private void assertClaim(Claim testClaim, Claim claim) {
		assertNotNull(claim);
		assertEquals(testClaim.getClaimKey().getClaimNumber(), claim.getClaimKey().getClaimNumber());
		assertEquals(testClaim.getClaimKey().getClaimExtNumber(), claim.getClaimKey().getClaimExtNumber());
		assertEquals(testClaim.getGroupStateCode(), claim.getGroupStateCode());
	}
	
	private Claim buildClaim(){
		Claim claim = new Claim();		
		claim.setClaimKey(TEST_CLAIM_KEY);
		claim.setGroupStateCode(TEST_STATE);

		return claim;
	}
}
