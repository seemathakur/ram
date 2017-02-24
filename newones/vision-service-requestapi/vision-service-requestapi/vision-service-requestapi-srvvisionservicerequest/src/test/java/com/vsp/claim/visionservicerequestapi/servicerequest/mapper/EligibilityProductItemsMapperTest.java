package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.claim.model.ClaimLines;
import com.vsp.api.eligibility.model.EligibilityProductItems;
import com.vsp.il.util.Preferences;


public class EligibilityProductItemsMapperTest {
	
	private static final String PRODUCT_CATALOG_KEY1 = "GenExam"; 
	private static final String PRODUCT_CATALOG_KEY2 = "Frame"; 
	
	
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}

	@Test
	public void testBuildEligibilityProductItemsMultipleLines(){
		EligibilityProductItems epis = EligibilityProductItemsMapper.mapClaimLinesToEligibilityProductItems(buildProductCatalogKeyListMultipleLines());
		
		assertProductItemMatches(epis.get(0).getProductCatalogKey(), PRODUCT_CATALOG_KEY1);
		assertProductItemMatches(epis.get(1).getProductCatalogKey(), PRODUCT_CATALOG_KEY2);
	}
	
	@Test
	public void testBuildEligibilityProductItemsSingleLine(){
		EligibilityProductItems epis = EligibilityProductItemsMapper.mapClaimLinesToEligibilityProductItems(buildProductCatalogKeyListSingleLine());
		
		assertProductItemMatches(epis.get(0).getProductCatalogKey(), PRODUCT_CATALOG_KEY1);
	}
	
	@Test
	public void testBuildEligibilityProductItemsNoItems(){
		EligibilityProductItems epis = EligibilityProductItemsMapper.mapClaimLinesToEligibilityProductItems(new ArrayList<ClaimLine>());
		
		assertEquals(0, epis.size());
	}
	
	@Test
	public void testBuildEligibilityProductItemsNullItems(){
		EligibilityProductItems epis = EligibilityProductItemsMapper.mapClaimLinesToEligibilityProductItems(null);
		
		assertEquals(0, epis.size());
	}
		
	private ClaimLines buildProductCatalogKeyListSingleLine(){
		ClaimLines lines = new ClaimLines();
		lines.add(buildClaimLine(PRODUCT_CATALOG_KEY1));
		return lines;
	}
	
	private ClaimLines buildProductCatalogKeyListMultipleLines(){
		ClaimLines lines = new ClaimLines();
		lines.add(buildClaimLine(PRODUCT_CATALOG_KEY1));
		lines.add(buildClaimLine(PRODUCT_CATALOG_KEY2));
		return lines;
	}
	
	private ClaimLine buildClaimLine(String productCatalogKey) {
		ClaimLine line = new ClaimLine();
		line.setProductCatalogKey(productCatalogKey);
		return line;
	}

	private void assertProductItemMatches(String actualProductCatalogKey, String expectedProductCatalogKey) {
		assertEquals(actualProductCatalogKey, expectedProductCatalogKey);
	}

}
