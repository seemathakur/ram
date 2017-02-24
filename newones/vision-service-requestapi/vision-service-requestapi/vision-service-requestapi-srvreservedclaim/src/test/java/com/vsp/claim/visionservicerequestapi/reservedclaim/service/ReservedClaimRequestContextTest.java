package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.ApiContext;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.AccessToken;
import com.vsp.oauth.ServiceLocationConstraint;

public class ReservedClaimRequestContextTest {
	
	private ReservedClaimRequestContext reservedClaimRequestContext; 

	
	@Mock
	private ApiContext apiContext; 
	
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void buildRequestContext(){
		mockApiContextWithTokenHasServiceLocationConstraint();
		reservedClaimRequestContext = new ReservedClaimRequestContext(buildClaim(), apiContext);
		assertNotNull(reservedClaimRequestContext);
		assertNotNull(reservedClaimRequestContext.getClaim());
		assertNotNull(reservedClaimRequestContext.getClaimLines());
		assertNotNull(reservedClaimRequestContext.getApiContext()); 
		assertNotNull(reservedClaimRequestContext.getServiceLocationConstraint()); 
		assertTrue(reservedClaimRequestContext.hasServiceLocationConstraint());
	}
	
	private Claim buildClaim(){
		Claim claim = new Claim();
		claim.setClaimLines(new ArrayList<ClaimLine>());
		claim.getClaimLines().add(new ClaimLine());
		return claim;
	}
	
	@Test
	public void buildRequestContextNoApiContext(){
		mockApiContextReturnsNoToken();
		reservedClaimRequestContext = new ReservedClaimRequestContext(buildClaim(), apiContext);
		assertNotNull(reservedClaimRequestContext);
		assertNotNull(reservedClaimRequestContext.getClaim());
		assertNotNull(reservedClaimRequestContext.getClaimLines());
		assertNotNull(reservedClaimRequestContext.getApiContext()); 
		assertNull(reservedClaimRequestContext.getServiceLocationConstraint()); 
		assertFalse(reservedClaimRequestContext.hasServiceLocationConstraint());
	}
	
	@Test
	public void buildRequestContextClaimLinesConstructor(){
		mockApiContextReturnsNoToken();
		Claim claim = buildClaim();
		List<ClaimLine> claimLines = buildClaimLines();
		reservedClaimRequestContext = new ReservedClaimRequestContext(claim, claimLines, apiContext);
		assertNotNull(reservedClaimRequestContext);
		assertNotNull(reservedClaimRequestContext.getClaim());
		assertNotNull(reservedClaimRequestContext.getClaimLines());
		assertFalse(claim.getClaimLines() == reservedClaimRequestContext.getClaimLines());
		assertNotNull(reservedClaimRequestContext.getApiContext()); 
		assertNull(reservedClaimRequestContext.getServiceLocationConstraint()); 
	}
	
	private List<ClaimLine> buildClaimLines() {
		List<ClaimLine> lines = new ArrayList<ClaimLine>(); 
		lines.add(new ClaimLine()); 
		return lines;
	}

	private void mockApiContextWithTokenHasServiceLocationConstraint(){
		ServiceLocationConstraint constraint = mock(ServiceLocationConstraint.class); 
		AccessToken token = mock(AccessToken.class); 
		Mockito.when(apiContext.getAccessToken()).thenReturn(token);
		Mockito.when(token.getService_location_constraint()).thenReturn(constraint);
	}
	
	
	private void mockApiContextReturnsNoToken(){
		Mockito.when(apiContext.getAccessToken()).thenReturn(null);
	}

}
