package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.Claims;
import com.vsp.api.claim.model.VisionServiceRequests;

public final class VisionServiceRequestsMapper {
	
	private VisionServiceRequestsMapper(){	
	}
	
	public static VisionServiceRequests mapClaimsToServiceRequests(Claims claims){
		VisionServiceRequests serviceRequests = new VisionServiceRequests();
		for(Claim claim: claims){
			serviceRequests.add(VisionServiceRequestMapper.mapClaimToServiceRequest(claim));
		}
		return serviceRequests;
	}

}
