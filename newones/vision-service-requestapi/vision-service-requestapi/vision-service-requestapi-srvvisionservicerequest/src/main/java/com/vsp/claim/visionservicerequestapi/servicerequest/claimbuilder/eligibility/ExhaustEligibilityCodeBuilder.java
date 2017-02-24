package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.eligibility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.Claim;
import com.vsp.claim.visionservicerequestapi.shared.enums.ExhaustEligibilityEnum;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;
import com.vsp.xl.codes.product.ProductPackageCodes;

public class ExhaustEligibilityCodeBuilder {
	
	private Claim claim;
	private String productPackageName;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExhaustEligibilityCodeBuilder.class);
	
	public ExhaustEligibilityCodeBuilder(Claim claim, String productPackageName){
		this.claim = claim;
		this.productPackageName = productPackageName;
	}
	
	public ExhaustEligibilityEnum buildAffectEligibilityCode(){
		ExhaustEligibilityEnum exhaustEligibilityCode = ExhaustEligibilityEnum.UNKNOWN;
		
		if(hasProductPackageException()){
			DebugLogger.debugEnabled(LOG, "Product package is LowVision, thus Do Not Exhaust Eligibility");
			exhaustEligibilityCode = ExhaustEligibilityEnum.DO_NOT_EXHAUST; 
		}else if (!isPopulated()) {
			DebugLogger.debugEnabled(LOG, "Affect eligibility code was not populated on the claim, thus default to Exhaust Eligiblity");
			exhaustEligibilityCode = ExhaustEligibilityEnum.EXHAUST;
		}else {
			exhaustEligibilityCode = ExhaustEligibilityEnum.fromCode(claim.getAffectEligibilityCode());
		}
		
		logExhaustEligibilityCode(exhaustEligibilityCode);
		
		return exhaustEligibilityCode;
	}

	private void logExhaustEligibilityCode(ExhaustEligibilityEnum exhaustEligibilityCode) {
		LOG.info("Exhaust Eligibility set to {}, code value={}", exhaustEligibilityCode.name(), exhaustEligibilityCode.getCode());
	}

	private boolean isPopulated() {
		return claim.getAffectEligibilityCode() != null;
	}

	private boolean hasProductPackageException() {
		return productPackageName.equalsIgnoreCase(ProductPackageCodes.Low_Vision.getCodeValue());
	}

}
