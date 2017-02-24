package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;

public interface ClaimLineBuilder {
	
	ClaimLine buildClaimLine(String productCatalogKey, int lineNumber) throws ClaimBuilderException;
	ClaimLine getClaimLine();

}
