package com.vsp.claim.visionservicerequestapi.shared.exception;

import java.util.List;

import com.vsp.api.claim.model.ClaimKey;
import com.vsp.il.util.NameValuePair;

public class ClaimNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ClaimNotFoundException() {
	}
	
	public ClaimNotFoundException(String message) {
		super(message);
	}
	
	public ClaimNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ClaimNotFoundException(ClaimKey claimKey, Throwable cause) {
		super(makeMessage(claimKey), cause);
	}
	
	public ClaimNotFoundException(ClaimKey claimKey) {
		super(makeMessage(claimKey));
	}
	
	public ClaimNotFoundException(List<NameValuePair> claimKeySearchCriteria) {
		super(makeMessage(claimKeySearchCriteria));
	}

	public ClaimNotFoundException(List<NameValuePair> claimKeySearchCriteria, Throwable cause) {
		super(makeMessage(claimKeySearchCriteria), cause);
	}

	private static String makeMessage(List<NameValuePair> claimKeySearchCriteria) {
		String msg = "Search Criteria ";
		if(claimKeySearchCriteria != null) {
			for(NameValuePair criterion : claimKeySearchCriteria) {
				msg += criterion + "; ";
			}
		} else {
			msg += "== NULL";
		}
		return msg;
	}
	
	private static String makeMessage(ClaimKey claimKey) {
		String msg = "ClaimKey == NULL ";
		if(claimKey != null) {
			msg = claimKey.toString();
		}
		return "Claim Not Found! " + msg;
	}

}
