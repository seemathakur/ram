package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper.buildMockClaim;
import static org.junit.Assert.assertEquals;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.Claims;
import com.vsp.api.claim.model.VisionServiceRequests;
import com.vsp.api.provider.model.Provider;
import com.vsp.api.provider.model.ProviderKey;
import com.vsp.il.util.Preferences;

public class VisionServiceRequestsMapperTest {

	private static final String PROVIDER_TAX_ID = "111223333";
	private static final String AUTHORIZATION_NUMBER = "10394310";
	private static final String CLASS_ID = "0001";
	
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testMapClaimsToServiceRequests() {
		Claims claims = new Claims(); 
		claims.add(buildClaim());
		claims.add(buildClaim()); 
	
		VisionServiceRequests serviceRequests = VisionServiceRequestsMapper.mapClaimsToServiceRequests(claims);	
		assertEquals(claims.size(), serviceRequests.size());
	}
	
	@Test
	public void testMapNoClaimsToServiceRequests() {
		Claims claims = new Claims(); 
	
		VisionServiceRequests serviceRequests = VisionServiceRequestsMapper.mapClaimsToServiceRequests(claims);	
		assertEquals(claims.size(), serviceRequests.size());
	}
	
	@Test
	public void testMapNullClaimsToServiceRequests() {
		Claims claims = new Claims(); 
	
		VisionServiceRequests serviceRequests = VisionServiceRequestsMapper.mapClaimsToServiceRequests(claims);	
		assertEquals(0, serviceRequests.size());
	}
	
	private Claim buildClaim() {
		Claim claim = buildMockClaim();
		
		ProviderKey providerKey = new ProviderKey();
		providerKey.setProviderTaxId(PROVIDER_TAX_ID);
		Provider provider = new Provider();
		provider.setKey(providerKey);
		claim.setProvider(provider);
		
		claim.setAuthorizationNumber(AUTHORIZATION_NUMBER);
		
		claim.setClassId(CLASS_ID);
		
		claim.setReservationIssueDate(new DateMidnight(2016,2,20));
		return claim;
	}
}
