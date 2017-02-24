package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.eligibility.model.EligibilityProductItem;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;

public final class EligibilityProductItemMapper {

	private EligibilityProductItemMapper(){
		
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(EligibilityProductItemMapper.class);
	
	public static EligibilityProductItem mapClaimLineToEligibilityProductItem(ClaimLine claimLine){
		EligibilityProductItem eligibilityProductItem = new EligibilityProductItem();
		
		eligibilityProductItem.setProductCatalogKey(claimLine.getProductCatalogKey());
		eligibilityProductItem.setEligibilityInterval(claimLine.getReservationInterval());
		
		DebugLogger.debugEnabled(LOG, "Building eligibility product item for product catalog key {}", claimLine.getProductCatalogKey());
		
		return eligibilityProductItem;
	}

}
