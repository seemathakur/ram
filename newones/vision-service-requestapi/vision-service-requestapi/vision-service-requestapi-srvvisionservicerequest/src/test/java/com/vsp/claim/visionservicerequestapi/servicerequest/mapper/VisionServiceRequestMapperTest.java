package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import static com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper.buildMockClaim;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.provider.model.Provider;
import com.vsp.api.provider.model.ProviderKey;
import com.vsp.il.util.Preferences;

public class VisionServiceRequestMapperTest {

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
	public void testClaimResponseToServiceRequestMapper() {
		Claim claim = buildClaim();
		VisionServiceRequest serviceRequest = VisionServiceRequestMapper.mapClaimToServiceRequest(claim);	
		
		assertNotNull("Claim object is null", claim);
		assertNotNull("ServiceRequest object is null", serviceRequest);
		
		// Assert serviceRequest fields here to match the constants defined at the top
		assertTrue("ServiceRequest Member and Claim Subscriber mismatch", serviceRequest.getMember().equals(claim.getSubscriber()));		
		assertTrue("ServiceRequest and Claim ClientId mismatch", serviceRequest.getMember().getMemberPolicyKey().getClientId().equals(claim.getSubscriber().getMemberPolicyKey().getClientId()));
		assertTrue("ServiceRequest and Claim DivId mismatch", serviceRequest.getMember().getMemberPolicyKey().getDivisionId().equals(claim.getSubscriber().getMemberPolicyKey().getDivisionId()));
		assertTrue("ServiceRequest and Claim PolicyId mismatch", serviceRequest.getMember().getMemberPolicyKey().getPolicyId().equals(claim.getSubscriber().getMemberPolicyKey().getPolicyId()));
		
		assertTrue("ServiceRequest and Claim Patient mismatch", serviceRequest.getPatient().equals(claim.getPatient()));
		assertTrue("ServiceRequest and Claim Patient ConsumerId mismatch", serviceRequest.getPatient().getConsumerId().equals(claim.getPatient().getConsumerId()));
		
		assertTrue("ServiceRequest and Claim ProviderNetworkAccessPoint mismatch", serviceRequest.getProviderNetworkAccessPoint().equals(claim.getProviderNetworkAccessPoint()));
		assertTrue("ServiceRequest and Claim Provider NetowrkId mismatch", serviceRequest.getProviderNetworkAccessPoint().getProviderNetworkKey().getNetworkId().equals(claim.getProviderNetworkAccessPoint().getProviderNetworkKey().getNetworkId()));
		
		assertTrue("ServiceRequest and Claim Provider TaxId mismatch", serviceRequest.getProviderKey().getProviderTaxId().equals(PROVIDER_TAX_ID));
		
		assertTrue("ServiceRequest TrackingNumber and Claim ClaimNumber mismatch", serviceRequest.getTrackingNumber().equals(claim.getClaimKey().getClaimNumber()));
		
		assertTrue("ServiceRequest and Claim AuthorizationNumber mismatch", serviceRequest.getAuthorizationNumber().equals(AUTHORIZATION_NUMBER));
	
		assertTrue("ServiceRequest and Claim ProductPackageName mismatch", serviceRequest.getProductPackageName().equals(claim.getProductPackageName()));
	
		assertTrue("ServiceRequest and Claim ClassId mismatch", serviceRequest.getClassId().equals(CLASS_ID));
		
		assertTrue("ServiceRequest EffectiveDate and Claim ReservationIssueDate mismatch", serviceRequest.getIssueDate().equals(new DateMidnight(2016,2,20)));
		
		assertTrue("ServiceRequest and Claim ClaimLines-0 ProductCatalogKey mismatch", serviceRequest.getSelectedEligibleProductItems().get(0).getProductCatalogKey().equals(claim.getClaimLines().get(0).getProductCatalogKey()));
	
		assertTrue("ServiceRequest and Claim ClaimLines-0 EligibilityInterval mismatch", serviceRequest.getSelectedEligibleProductItems().get(0).getEligibilityInterval().equals(claim.getClaimLines().get(0).getReservationInterval()));
		
		assertTrue("ServiceRequest and Claim ClaimLines-1 ProductCatalogKey mismatch", serviceRequest.getSelectedEligibleProductItems().get(1).getProductCatalogKey().equals(claim.getClaimLines().get(1).getProductCatalogKey()));
		
		assertTrue("ServiceRequest and Claim ClaimLines-1 EligibilityInterval mismatch", serviceRequest.getSelectedEligibleProductItems().get(1).getEligibilityInterval().equals(claim.getClaimLines().get(1).getReservationInterval()));
	}
	

	@Test
	public void testClaimResponseToServiceRequestMapperWithNullClaim() {
		Claim claim = null;
		VisionServiceRequest serviceRequest = VisionServiceRequestMapper.mapClaimToServiceRequest(claim);	
		
		assertNotNull("ServiceRequest object is null", serviceRequest);	
	}

	@Test
	public void testClaimResponseToServiceRequestMapperWithNullProvider() {
		Claim claim = buildClaim();
		claim.setProvider(null);
		
		VisionServiceRequest serviceRequest = VisionServiceRequestMapper.mapClaimToServiceRequest(claim);	
		
		assertNotNull("ServiceRequest object is null", serviceRequest);	
		assertNull("ProviderKey is not null", serviceRequest.getProviderKey());
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
