package com.vsp.claim.visionservicerequestapi.servicerequest.command.request;

import com.vsp.api.core.Link;
import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.oauth.AccessToken;

public class RetrieveEligibilityCommandRequest implements CommandRequest{
	
	private String clientId; 
	private String divisionId;
	private String subscriberId;
	private String consumerId;
	private String asOfDate; 
	private AccessToken accessToken;
	
	// TODO Get rid of knowledge of anything lower than Eligibility in this class
	private Link<Eligibility> retrieveMemberEligibility;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public String getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getAsOfDate() {
		return asOfDate;
	}

	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}
	
	public AccessToken getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	
	@Override
	public String toString() {
		return clientId + "-" + divisionId + "-" + subscriberId + "-" +
				consumerId + "&asOfDate=" + asOfDate;
	}

	public Link<Eligibility> getRetrieveMemberEligibility() {
		return retrieveMemberEligibility;
	}

	public void setRetrieveMemberEligibility(Link<Eligibility> retrieveMemberEligibility) {
		this.retrieveMemberEligibility = retrieveMemberEligibility;
	}

}
