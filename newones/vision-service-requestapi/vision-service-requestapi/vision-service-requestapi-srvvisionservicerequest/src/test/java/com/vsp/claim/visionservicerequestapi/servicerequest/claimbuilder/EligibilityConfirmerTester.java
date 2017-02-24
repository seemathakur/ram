package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateMidnight;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.DateInterval;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.MockRetrieveEligibilityCommand;
import com.vsp.il.util.Preferences;

public class EligibilityConfirmerTester {
	
	private MockRetrieveEligibilityCommand command; 
	private List<String> servicesNotConfirmed;
	
	private static final String VSP_NETWORK_ID = "1000";
	private static final String SIGNATURE = "Signature"; 
	private static final String GEN_EXAM = "GenExam";
	private static final String CONTACT_LENS_SERVICE = "ContactLensService";
	private static final String CONTACT_LENS = "ContactLens";
	private static final String LENS = "Lens"; 
	private static final String FRAME = "Frame";
	
	@Before
	public void setUp() {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		command = new MockRetrieveEligibilityCommand(); 
		initializeServicesNotConfirmed(); 
		setMockEligibility("com/vsp/claim/visionservicerequestapi/servicerequest/claimbuilder/Confirmer_Frame_Reserved.json");
	}
	
	@After
	public void tearDown() {
		clearServicesNotConfirmed();
	}
	
				
	@Test
	public void testClaimForFrameAvailable() {
		setMockEligibility("com/vsp/claim/visionservicerequestapi/servicerequest/claimbuilder/Confirmer_All_Available.json");
		confirmEligibilityForClaimLines(createClaimLinesToReserveExamLensFrame());
		assertClaimLineIsConfirmed(FRAME); 
	}	
		
	@Test
	public void testClaimForFrameReserved() {
		confirmEligibilityForClaimLines(createClaimLinesToReserveExamLensFrame());
		assertClaimLineIsNotConfirmed(FRAME); 
	}	
	
	@Test
	public void testClaimForLensUtilized() {
		confirmEligibilityForClaimLines(createClaimLinesToReserveExamLensFrame());
		assertClaimLineIsNotConfirmed(LENS); 
	}	
	
	@Test
	public void testClaimForContactLensAuthorized() {
		confirmEligibilityForClaimLines(createClaimLinesToReserveAll());
		assertClaimLineIsNotConfirmed(CONTACT_LENS); 
	}	
	
	@Test
	public void testClaimForContactLensServiceUnavailable() {
		confirmEligibilityForClaimLines(createClaimLinesToReserveAll());
		assertClaimLineIsNotConfirmed(CONTACT_LENS_SERVICE); 
	}
	
	@Test
	public void testClaimBuilderExceptionNoEligibility() {
		setMockEligibility("com/vsp/claim/visionservicerequestapi/servicerequest/claimbuilder/NetworkNotFound.json");
		confirmEligibilityForClaimLines(createClaimLinesToReserveAll());
		assertClaimLineIsNotConfirmed(CONTACT_LENS); 
		assertClaimLineIsNotConfirmed(CONTACT_LENS_SERVICE); 
		assertClaimLineIsNotConfirmed(GEN_EXAM);
		assertClaimLineIsNotConfirmed(LENS);
		assertClaimLineIsNotConfirmed(FRAME); 
	}
	
	private void confirmEligibility(ClaimLine claimline, String providerNetworkId) {
		EligibilityConfirmer confirmor = new EligibilityConfirmer(claimline, providerNetworkId, SIGNATURE); 
		confirmor.setRetrieveEligibilityCommand(command);
		if(!(confirmor.confirmEligibility())) {
			servicesNotConfirmed.add(claimline.getProductCatalogKey());
		}
	}
	
	private void confirmEligibilityForClaimLines(List<ClaimLine> claimLines){
		for(ClaimLine claimline: claimLines){
			confirmEligibility(claimline, VSP_NETWORK_ID);
		}
	}

	private void setMockEligibility(String filepath){
		command.setDataFile(filepath);
	}
	
	private void initializeServicesNotConfirmed(){
		servicesNotConfirmed = new ArrayList<String>(); 
	}
	
		
	private void clearServicesNotConfirmed(){
		servicesNotConfirmed = new ArrayList<String>();
	}
	
	private void assertClaimLineIsNotConfirmed(String productCatalogKey){
		String error = "EligibilityConfirmorTester::testClaimForClaimLineIsNotConfirmed failed";
		assertTrue(error, servicesNotConfirmed.contains(productCatalogKey));
	}

	private void assertClaimLineIsConfirmed(String productCatalogKey){
		String error = "EligibilityConfirmorTester::testClaimForClaimLineIsConfirmed failed";
		assertTrue(error, !servicesNotConfirmed.contains(productCatalogKey));
	}
	
	private List<ClaimLine> createClaimLinesToReserveExamLensFrame(){
		List<ClaimLine> claimLines = new ArrayList<ClaimLine>();
		
		claimLines.add(createClaimLine(GEN_EXAM));	
		claimLines.add(createClaimLine(LENS));
		claimLines.add(createClaimLine(FRAME));
		
		return claimLines; 
	}
	
	private List<ClaimLine> createClaimLinesToReserveAll(){
		List<ClaimLine> claimLines = new ArrayList<ClaimLine>();
		
		claimLines.add(createClaimLine(GEN_EXAM));
		claimLines.add(createClaimLine(LENS));
		claimLines.add(createClaimLine(FRAME));
		claimLines.add(createClaimLine(CONTACT_LENS));
		claimLines.add(createClaimLine(CONTACT_LENS_SERVICE));
		
		return claimLines; 
	}
	
	private ClaimLine createClaimLine(String productCatalogKey){
		ClaimLine claimLine = new ClaimLine(); 
		
		claimLine.setProductCatalogKey(productCatalogKey);
		claimLine.setReservationInterval(createReservationIntervalBeginDate(2014, 5, 15));
		
		return claimLine; 
	}
	
	private DateInterval createReservationIntervalBeginDate(int year, int month, int day){
		return new DateInterval (new DateMidnight(year, month, day), null); 
	}

}
