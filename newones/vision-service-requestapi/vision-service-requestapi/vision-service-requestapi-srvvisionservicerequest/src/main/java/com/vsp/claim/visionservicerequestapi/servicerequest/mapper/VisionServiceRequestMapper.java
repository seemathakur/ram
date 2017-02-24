package com.vsp.claim.visionservicerequestapi.servicerequest.mapper;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.VisionServiceRequest;

public final class VisionServiceRequestMapper {
	
	private VisionServiceRequestMapper() {
	}

	public static VisionServiceRequest mapClaimToServiceRequest(Claim claim) {
		VisionServiceRequest serviceRequest = new VisionServiceRequest();
		if (claim == null) {
			return serviceRequest;
		}
	
		serviceRequest.setMember(claim.getSubscriber());
		serviceRequest.setPatient(claim.getPatient());
		serviceRequest.setProviderNetworkAccessPoint(claim.getProviderNetworkAccessPoint());
		serviceRequest.setAuthorizationNumber(claim.getAuthorizationNumber());
		serviceRequest.setProductPackageName(claim.getProductPackageName());
		serviceRequest.setClassId(claim.getClassId());
		serviceRequest.setIssueDate(claim.getReservationIssueDate());
		setProvider(claim, serviceRequest);
		setTrackingNumber(claim, serviceRequest); 
		mapClaimLinesToEligibilityProductItems(claim, serviceRequest);
		
		return serviceRequest;
	}


	private static void setProvider(Claim claim, VisionServiceRequest serviceRequest) {
		if (claim.getProvider() != null) {
			serviceRequest.setProviderKey(claim.getProvider().getKey());
		}
	}

	private static void setTrackingNumber(Claim claim, VisionServiceRequest serviceRequest) {
		if (claim.getClaimKey() != null) {
			serviceRequest.setTrackingNumber(claim.getClaimKey().getClaimNumber());
		}
	}

	private static void mapClaimLinesToEligibilityProductItems(Claim claim, VisionServiceRequest serviceRequest) {
		serviceRequest.setSelectedEligibleProductItems(EligibilityProductItemsMapper.mapClaimLinesToEligibilityProductItems(
				claim.getClaimLines()));
	}	

}
