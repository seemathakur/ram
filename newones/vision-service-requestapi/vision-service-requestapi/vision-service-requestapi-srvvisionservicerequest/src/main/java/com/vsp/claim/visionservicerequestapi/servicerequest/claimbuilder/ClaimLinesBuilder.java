package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import java.util.List;

import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.exception.ClaimBuilderException;

public interface ClaimLinesBuilder {
	
	List<ClaimLine> buildClaimLines() throws ClaimBuilderException; 
	List<ClaimLine> getClaimLines();

}
