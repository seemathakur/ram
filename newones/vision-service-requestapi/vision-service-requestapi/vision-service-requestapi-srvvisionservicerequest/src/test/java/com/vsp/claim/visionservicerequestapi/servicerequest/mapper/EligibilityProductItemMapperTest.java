package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.api.util.DateInterval;
import com.vsp.il.util.Preferences;


public class EligibilityProductItemMapperTest {
	
	private static final String PRODUCT_CATALOG_KEY = "GenExam"; 
	private static final DateMidnight BEGIN_DATE = new DateMidnight(2016,10,01);
	private static final DateMidnight END_DATE = new DateMidnight(2016,10,31);
	
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testBuildEligibilityProductItemsWithReservationInterval(){ 
		ClaimLine claimLine = buildClaimLineWithEffectiveDate(new DateInterval(BEGIN_DATE, END_DATE)); 
		EligibilityProductItem epi = EligibilityProductItemMapper.mapClaimLineToEligibilityProductItem(claimLine);
		
		assertProductItemMatches(epi.getProductCatalogKey(), PRODUCT_CATALOG_KEY);
		assertEligibilityIntervalMatches(epi.getEligibilityInterval(), claimLine.getReservationInterval());
	}
	
	@Test
	public void testBuildEligibilityProductItemsWithEmptyReservationInterval(){ 
		ClaimLine claimLine = buildClaimLineWithEffectiveDate(new DateInterval()); 
		EligibilityProductItem epi = EligibilityProductItemMapper.mapClaimLineToEligibilityProductItem(claimLine);
		
		assertProductItemMatches(epi.getProductCatalogKey(), PRODUCT_CATALOG_KEY);
		assertNotNull(epi.getEligibilityInterval()); 
		assertNull(epi.getEligibilityInterval().getBegin());
		assertNull(epi.getEligibilityInterval().getEnd());
	}
	
	@Test
	public void testBuildEligibilityProductItemsWithNullReservationInterval(){ 
		ClaimLine claimLine = buildClaimLineWithEffectiveDate(null); 
		EligibilityProductItem epi = EligibilityProductItemMapper.mapClaimLineToEligibilityProductItem(claimLine);
		
		assertProductItemMatches(epi.getProductCatalogKey(), PRODUCT_CATALOG_KEY);
		assertNull(epi.getEligibilityInterval()); 
	}
	
	private void assertEligibilityIntervalMatches(DateInterval eligibilityInterval, DateInterval reservationInterval) {
		assertEquals(0, reservationInterval.getBegin().compareTo(eligibilityInterval.getBegin())); 
		assertEquals(0, reservationInterval.getEnd().compareTo(eligibilityInterval.getEnd())); 
	}

	private ClaimLine buildClaimLineWithEffectiveDate(DateInterval interval) {
		ClaimLine line = new ClaimLine();
		line.setProductCatalogKey(PRODUCT_CATALOG_KEY);
		line.setReservationInterval(interval);
		return line;
	}

	private void assertProductItemMatches(String actualProductCatalogKey, String expectedProductCatalogKey) {
		assertEquals(actualProductCatalogKey, expectedProductCatalogKey);
	}

	
}
