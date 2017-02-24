package com.vsp.claim.visionservicerequestapi.servicerequest.notification;

import java.util.ArrayList;
import java.util.List;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimError;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder.ClaimErrorBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.shared.util.ReservedClaimStatusEnum;


public class ClaimBuilderNotificationHandler extends NotificationHandler {

	private VisionServiceRequestApiContext context; 
	
	public ClaimBuilderNotificationHandler(VisionServiceRequestApiContext context){
		this.context = context; 
	}
	
	public Claim handleNotifications(Claim claim) {
		Claim toReturn = claim; 
		
		setClaimErrors(toReturn);
		updateClaimStatus(toReturn);
		updateClaimLinesStatus(toReturn);
		
		return toReturn;
	}
	
	private void setClaimErrors(Claim claim) {
		if(hasNotifications(context.getNotifications())){
			ClaimErrorBuilder claimErrorBuilder = new ClaimErrorBuilder();
			List<ClaimError> claimErrors = claimErrorBuilder.buildClaimErrorsFromNotifications(context.getNotifications());
			List<ClaimError> cleansedErrors = purgeErrorsWithNoErrorNumber(claimErrors); 
			claim.setClaimErrors(cleansedErrors);
		}
	}
	
	private List<ClaimError> purgeErrorsWithNoErrorNumber(List<ClaimError> claimErrors) {
		List<ClaimError> cleansedErrors = new ArrayList<ClaimError>();
		for(ClaimError currentClaimError : claimErrors) {
			if(hasErrorNumber(currentClaimError)) {
				cleansedErrors.add(currentClaimError);
			}
		}
		return cleansedErrors;
	}

	private void updateClaimStatus(Claim claim) {
		if(hasClaimErrors(claim)) {
			setClaimStatus(claim, ReservedClaimStatusEnum.INVALID_RESERVED);
		}
	}
	
	private boolean hasClaimErrors(Claim claim){
		return !claim.getClaimErrors().isEmpty();
	}
	
	private void updateClaimLinesStatus(Claim claim) {
		if(hasClaimErrors(claim) && hasClaimLines(claim)) {
			for(ClaimLine claimLine : claim.getClaimLines()) {
				setClaimLineStatus(claimLine, ReservedClaimStatusEnum.INVALID_RESERVED);
			}
		}
	}
	
	private boolean hasClaimLines(Claim claim){
		return claim.getClaimLines() != null;
	}
	
	public void setClaimStatus(Claim claim, ReservedClaimStatusEnum status) {
		claim.setStatusCode(status.getStatusCode());
	}
	
	public void setClaimLineStatus(ClaimLine claimLine, ReservedClaimStatusEnum status) {
		claimLine.setStatusCode(status.getStatusCode());
	}
	
	private boolean hasErrorNumber(ClaimError claimError) {
		return claimError.getErrorNumber() != null && !claimError.getErrorNumber().isEmpty();
	}
}
