package com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.eligibility.model.EligibilityCoverage;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.eligibility.model.EligibilityProductPackage;
import com.vsp.claim.visionservicerequestapi.servicerequest.eligibilityfilter.exception.EligibilityFilterException;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockObjectProvider;
import com.vsp.il.util.Preferences;

public class TestEligibilityFilter {
	

	private EligibilityFilter filter; 
	private List<Exception> exceptions;
	private List<List<String>> expectedProductPackagesList; 
	private List<String> expectedEligibleItemsList; 
	
	EligibilityProductPackage productPackage; 
	
	private static final String VSP_NETWORK_ID = "1000";
	private static final String COSTA_NETWORK_ID = "COSTA";
	private static final String SIGNATURE_PRODUCT_PACKAGE = "Signature"; 
	private static final String SIGNATURE_CHOICE_PACKAGE = "SignatureChoice"; 
	private static final String GEN_EXAM = "GenExam";
	private static final String CONTACT_LENS_SERVICE = "ContactLensService";
	private static final String CONTACT_LENS = "ContactLens";
	private static final String LENS = "Lens"; 
	private static final String FRAME = "Frame";
	private static final String RETINAL_SCREENING = "RetinalScreening";
	private static final String FRAME_WITH_SUN_LENS_INSERT = "FrameWithSunLensInsert";
	
	
	@Before
	public void setUp() {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}		
		createExpectedProductPackagesList();
		createExpectedEligibleItemsList(); 
		initializeFilter(mockEligibility());
	}
	
	private void initializeErrorList(){
		exceptions = new ArrayList<Exception>();
	}
	
	private void createExpectedEligibleItemsList(){
		expectedEligibleItemsList = new ArrayList<String>();
		
		expectedEligibleItemsList.add(GEN_EXAM);
		expectedEligibleItemsList.add(FRAME);
		expectedEligibleItemsList.add(CONTACT_LENS_SERVICE);
		expectedEligibleItemsList.add(FRAME_WITH_SUN_LENS_INSERT);
		expectedEligibleItemsList.add(LENS);
		expectedEligibleItemsList.add(RETINAL_SCREENING);
		
	}
	
	private void createExpectedProductPackagesList(){
		expectedProductPackagesList = new ArrayList<List<String>>(); 
		
		List<String> genExam = new ArrayList<String>(); 
		genExam.add(GEN_EXAM);
		
		List<String> lens = new ArrayList<String>();
		lens.add(LENS);
		
		List<String> frame = new ArrayList<String>();
		frame.add(FRAME);
		
		List<String> ncl = new ArrayList<String>();
		ncl.add(CONTACT_LENS);
		ncl.add(CONTACT_LENS_SERVICE);
		
		List<String> clService = new ArrayList<String>();
		clService.add(CONTACT_LENS_SERVICE);
		
		List<String> retinal = new ArrayList<String>();
		retinal.add(RETINAL_SCREENING);
		
		List<String> sunglasses = new ArrayList<String>();
		sunglasses.add(FRAME_WITH_SUN_LENS_INSERT);
		
		expectedProductPackagesList.add(genExam); 
		expectedProductPackagesList.add(frame);
		expectedProductPackagesList.add(ncl);
		expectedProductPackagesList.add(clService);
		expectedProductPackagesList.add(retinal);
		expectedProductPackagesList.add(sunglasses);
	}
	
	@Test
	public void testInvalidEligibilityNetwork(){
		
		initializeErrorList();
		filterByProviderNetworkIdAndProductPackage(null, SIGNATURE_CHOICE_PACKAGE);		
		
		String expectedException = "EligibilityFilter could not retrieve the network NULL";
		assertEligibilityNetworkNotFoundException(expectedException);
		
		clearResults();
		
	}
	
	@Test
	public void testInvalidProductPackage(){
		
		initializeErrorList();
		filterByProviderNetworkIdAndProductPackage(VSP_NETWORK_ID, null);
		
		String expectedException = "EligibilityFilter could not retrieve the product package NULL";
		assertEligibilityProductPackageNotFoundException(expectedException);
		
		clearResults();
		
	}
	
	@Test
	public void testValidEligibilityResponse(){
		
		initializeErrorList();
		filterByProviderNetworkIdAndProductPackage(VSP_NETWORK_ID, SIGNATURE_PRODUCT_PACKAGE);
		
		assertProductPackage(SIGNATURE_PRODUCT_PACKAGE);
		assertCoverages();
		assertEligibleItems();
		assertNoErrors(); 
	
		clearResults(); 
	}
	
	
	private void filterByProviderNetworkIdAndProductPackage(String providerNetworkId, String productPackageName){
		try {
			productPackage = filter.filterEligibilityByProviderNetworkIdAndProductPackage(providerNetworkId, productPackageName);
		} catch (EligibilityFilterException e) {
			exceptions.add(e); 
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testEligibilityNetworkNotFoundException(){
		initializeErrorList(); 
		filterByProviderNetworkIdAndProductPackage(COSTA_NETWORK_ID, SIGNATURE_CHOICE_PACKAGE);
		
		String expectedException = "EligibilityFilter could not retrieve the network COSTA";
		assertEligibilityNetworkNotFoundException(expectedException);
		
		clearResults(); 
	}
	
	@Test
	public void testEligibilityProductPackageNotFoundException(){
		initializeErrorList(); 
		filterByProviderNetworkIdAndProductPackage(VSP_NETWORK_ID, SIGNATURE_CHOICE_PACKAGE);
		
		String expectedException = "EligibilityFilter could not retrieve the product package SignatureChoice";
		assertEligibilityProductPackageNotFoundException(expectedException);
		
		clearResults();
	}
	
	private void clearResults(){
		clearExceptions();
	}
	
	private void assertEligibilityProductPackageNotFoundException(String expectedException){
		
		String error = "TestEligibilityFilter::testEligibilityProductPackageNotFoundException::assertEligibilityProductPackageNotFoundException"
				+ " expected errors but there were none";
		assertTrue(error, !exceptions.isEmpty());
		
		error = "TestEligibilityFilter::testEligibilityProductPackageNotFoundException::assertEligibilityProductPackageNotFoundException"
				+ " expected exception " + expectedException;
		assertTrue(error, createExceptionList().contains(expectedException)); 
		
	}
	
	private void assertEligibilityNetworkNotFoundException(String expectedException){
		
		String error = "TestEligibilityFilter::testEligibilityNetworkNotFoundException::assertEligibilityNetworkNotFoundException"
				+ " expected errors but there were none";
		assertTrue(error, !exceptions.isEmpty());
		
		error = "TestEligibilityFilter::testEligibilityNetworkNotFoundException::assertEligibilityNetworkNotFoundException"
				+ " expected exception " + expectedException;
		assertTrue(error, createExceptionList().contains(expectedException)); 
		
	}
	
	private List<String> createExceptionList(){
		List<String> exceptionsList = new ArrayList<String> ();
		for(Exception exception: exceptions){
			exceptionsList.add(exception.getMessage()); 
		}
		
		return exceptionsList; 
	}
	
	private void assertNoErrors(){
		
		String error = "TestEligibilityFilter::testValidEligibilityResponse::assertNoErrors"
				+ " expected no errors but there were " + exceptions.size() + " exceptions";
		assertTrue(error, exceptions.isEmpty());
	}
			
	private void assertProductPackage(String expectedProductPackage){
		
		String error = "TestEligibilityFilter::testValidEligibilityResponse::assertProductPackage"
				+ " expected product package does not match " + expectedProductPackage;
		
		assertEquals(error, expectedProductPackage, getProductPackageName()); 
	}
	
	private String getProductPackageName(){
		return productPackage.getName(); 
	}
	
	private void assertEligibleItems(){
		List<EligibilityProductItem> eligibleItems = productPackage.getEligibleItems(); 
		List<String> productCatalogKeysFromEligibleItems = getProductCatalogKeyFromEligibleItems(eligibleItems); 
		
		for(String expectedEligibleItem : expectedEligibleItemsList){
			
			String error = "TestEligibilityFilter::testValidEligibilityResponse::assertEligibleItems"
					+ " expected product catalog key not found " + expectedEligibleItem;
			
			assertTrue(error, productCatalogKeysFromEligibleItems.contains(expectedEligibleItem)); 
		}
		
	}
	
	private List<String> getProductCatalogKeyFromEligibleItems(List<EligibilityProductItem> eligibleItems){
		List<String> productCatalogKeys = new ArrayList<String>();
		
		for(EligibilityProductItem eligibleItem : eligibleItems ){
			productCatalogKeys.add(eligibleItem.getProductCatalogKey());
		}
		
		return productCatalogKeys;
	}
	
	private void assertCoverages(){
		List<EligibilityCoverage> coverages = productPackage.getCoverages(); 
		List<List<String>> productPackagesListFromCoverages = getProductPackagesListFromCoverages(coverages); 

		for(List<String> expectedProductPackages : this.expectedProductPackagesList ){
			
			String error = "TestEligibilityFilter::testValidEligibilityResponse::assertCoverage"
					+ " expected product package not found " + expectedProductPackages.toString();
			
			assertTrue(error, productPackagesListFromCoverages.contains(expectedProductPackages)); 
		}
	}
	
	private List<List<String>> getProductPackagesListFromCoverages(List<EligibilityCoverage> coverages){
		List<List<String>> productPackagesList = new ArrayList<List<String>>(); 
		
		for(EligibilityCoverage coverage:coverages){
			productPackagesList.add(coverage.getProductCatalogKeys());
		}
		
		return productPackagesList; 
	}
	
	private void initializeFilter(Eligibility eligibility){
		initializeErrorList();
		filter = new EligibilityFilter(eligibility); 
	}
	
	private void clearExceptions(){
		exceptions = null; 
	}
	

	private Eligibility mockEligibility() {
		Eligibility eligibility = new Eligibility();
		
		try {
			MockObjectProvider objectProvider = new MockObjectProvider();
			eligibility = (Eligibility) objectProvider.mockObjectFromJson(
					"com/vsp/claim/visionservicerequestapi/servicerequest/eligibilityfilter/Eligibility.json", Eligibility.class);
		} catch (IOException e) {
			fail("Failed to load test object from json.");
		}
		
		return eligibility;
	}


}
