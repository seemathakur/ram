package com.vsp.claim.visionservicerequestapi.reservedclaim.mapping;

import static com.vsp.claim.visionservicerequestapi.reservedclaim.helper.ClaimLineMatcher.matchesJpaClaimLine;
import static com.vsp.claim.visionservicerequestapi.reservedclaim.helper.ClaimMatcher.matchesJpaClaim;
import static com.vsp.claim.visionservicerequestapi.reservedclaim.helper.PreClaimLineMatcher.matchesClaimLine;
import static com.vsp.claim.visionservicerequestapi.reservedclaim.helper.PreClaimMatcher.matchesClaim;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaim;
import com.vsp.claim.visionservicerequestapi.reservedclaim.jpa.model.PreClaimLine;
import com.vsp.claim.visionservicerequestapi.reservedclaim.junit.MockObjectProvider;
import com.vsp.il.util.Preferences;


public class PreClaimMapperTest {
	
	private static PreClaimMapper mapper;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		mapper = PreClaimMapper.getInstance();
	}
	

	@Test
	public void testClaimMapper() {
		initializeClaimMapper();
		PreClaim jpaClaim = mockPreClaim("com/vsp/claim/visionservicerequestapi/reservedclaim/mapping/PreClaim.json");
		Claim modelClaim = mapper.map(jpaClaim, Claim.class);
		assertRetrievedClaim(modelClaim, jpaClaim);
	}
	
	@Test
	public void testApiToJpaClaimMapper() {
		Claim apiClaim = mockClaim("com/vsp/claim/visionservicerequestapi/reservedclaim/ReservedClaimRequest.json");
		PreClaim jpaClaim = mapper.map(apiClaim, PreClaim.class);
		assertRetrievedPreClaim(apiClaim, jpaClaim);
	}
	
	private void initializeClaimMapper() {
		mapper = PreClaimMapper.getInstance();
	}

	private PreClaim mockPreClaim(String filepath) {
		PreClaim claim = new PreClaim();
		
		try {
			MockObjectProvider objectProvider = new MockObjectProvider();
			claim = (PreClaim) objectProvider.mockObjectFromJson(
					filepath, PreClaim.class);
		} catch (IOException e) {
			fail("Failed to load test object from json.");
		}
		return claim;
	}
	
	private Claim mockClaim(String filepath) {
		Claim claim = new Claim();
		
		try {
			MockObjectProvider objectProvider = new MockObjectProvider();
			claim = (Claim) objectProvider.mockObjectFromJson(
					filepath, Claim.class);
		} catch (IOException e) {
			fail("Failed to load test object from json.");
		}
		return claim;
	}
	
	
	private void assertRetrievedClaim(Claim modelClaim, PreClaim jpaClaim) {
		assertThat(modelClaim, matchesJpaClaim(jpaClaim));
		assertRetrievedClaimLines(modelClaim.getClaimLines(), jpaClaim.getClaimLines());
	}
	
	private void assertRetrievedPreClaim(Claim modelClaim, PreClaim jpaClaim) {
		assertThat(modelClaim, matchesClaim(jpaClaim));
		assertRetrievedPreClaimLines(modelClaim.getClaimLines(), jpaClaim.getClaimLines());
	}
	
	private void assertRetrievedPreClaimLines(List<ClaimLine> retrievedClaimLines, 
			List<PreClaimLine> testClaimLines){
		for(PreClaimLine testClaimLine: testClaimLines){
			ClaimLine retrievedClaimLine = getMatchingRetrievedClaimLine(testClaimLine, 
					retrievedClaimLines);
			assertThat(retrievedClaimLine, matchesClaimLine(testClaimLine));
		}
			
	}
	
	private void assertRetrievedClaimLines(List<ClaimLine> retrievedClaimLines, 
			List<PreClaimLine> testClaimLines){
		for(PreClaimLine testClaimLine: testClaimLines){
			ClaimLine retrievedClaimLine = getMatchingRetrievedClaimLine(testClaimLine, 
					retrievedClaimLines);
			assertThat(retrievedClaimLine, matchesJpaClaimLine(testClaimLine));
		}
			
	}
	
	private ClaimLine getMatchingRetrievedClaimLine(PreClaimLine testClaimLine, 
			List<ClaimLine> retrievedClaimLines){
		short line = testClaimLine.getClaimLineKey().getLineNumber();
		for(ClaimLine retrievedClaimLine : retrievedClaimLines){
			if(retrievedClaimLine.getLineNumber() == line)
				return retrievedClaimLine;
		}
		
		return new ClaimLine();
	}

}
