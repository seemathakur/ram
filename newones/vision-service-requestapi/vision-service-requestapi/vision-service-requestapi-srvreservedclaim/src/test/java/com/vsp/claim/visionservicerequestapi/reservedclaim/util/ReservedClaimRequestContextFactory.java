package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.ReservedClaimRequestContext;

public class ReservedClaimRequestContextFactory {
	
	public static ReservedClaimRequestContext buildRequestContext(ApiContext context, Claim claim){	
		return new ReservedClaimRequestContext(claim, context);
	}
	
	
	
}
