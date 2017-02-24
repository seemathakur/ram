package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.ClaimError;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.Notification;
import com.vsp.claim.visionservicerequestapi.servicerequest.notification.NotificationHandler;
import com.vsp.claim.visionservicerequestapi.shared.logging.LogUtil;

public class ClaimErrorBuilder {
	
	private static final String ERROR_CATEGORY = "Claim";
	private static final int MAX_ERROR_LENGTH = 10;
	private static final Logger LOG = LoggerFactory.getLogger(ClaimErrorBuilder.class);
	
	public List<ClaimError> buildClaimErrorsFromNotifications(List<Notification> notifications){
		List<ClaimError> errors = initializeClaimErrors();

		if(NotificationHandler.hasNotifications(notifications)){
			for(Notification notification: notifications){
				ClaimError error = mapNotificationToError(notification);
				errors.add(error);
			}
		}
		
		LogUtil.logClaimErrors(LOG, errors);
		
		return errors;
	}
	
	private String trimCode(String code){
		String trimmedCode = code != null ? code : "";
		int length = trimmedCode.length();
		
		if(length > MAX_ERROR_LENGTH){
			int offset = length - MAX_ERROR_LENGTH;
			trimmedCode = trimmedCode.substring(offset);
		}
		
		return trimmedCode; 
	}
	
	private ClaimError mapNotificationToError(Notification notification) {
		ClaimError error = new ClaimError();
		error.setErrorCategory(ERROR_CATEGORY);
		String errorNumber = trimCode(notification.getCode());
		error.setErrorNumber(errorNumber);
		return error;
	}

	private List<ClaimError> initializeClaimErrors(){
		return new ArrayList<ClaimError>();
	}

}
