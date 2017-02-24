package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception;

import com.vsp.api.claim.model.ClaimLine;

public class ClaimLineNotEligibleException extends ClaimBuilderException {
	
	private static final long serialVersionUID = 1L;
	
	private ClaimLine ineligibleClaimLine;

	public ClaimLineNotEligibleException(ClaimLine ineligibleClaimLine) {
		this.ineligibleClaimLine = ineligibleClaimLine;
	}
	
	public String getIneligibleProductCatalogKey() {
		return ineligibleClaimLine.getProductCatalogKey();
	}

}

