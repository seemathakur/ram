package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import com.vsp.api.claim.model.Claim;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;

public interface ClaimBuilder {
	
	Claim buildClaim() throws ClaimBuilderException;
}
