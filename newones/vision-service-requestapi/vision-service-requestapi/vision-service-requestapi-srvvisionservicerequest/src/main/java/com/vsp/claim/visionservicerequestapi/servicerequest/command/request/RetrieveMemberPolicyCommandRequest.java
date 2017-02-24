package com.vsp.claim.visionservicerequestapi.servicerequest.command.request;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.core.Link;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.oauth.AccessToken;


public class RetrieveMemberPolicyCommandRequest implements CommandRequest{
	
	private String clientId; 
	private String divisionId;
	private String subscriberId;
	private String consumerId;
	private String asOfDate;
	private AccessToken accessToken; 
	private Link<MemberPolicy> retrieveMemberPolicy;

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
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + clientId + "-" + divisionId + "-" + subscriberId + "-" +
				consumerId + "&asOfDate=" + asOfDate;
	}

	public AccessToken getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}

	public Link<MemberPolicy> getRetrieveMemberPolicy() {
		return retrieveMemberPolicy;
	}

	public void setRetrieveMemberPolicy(Link<MemberPolicy> retrieveMemberPolicy) {
		this.retrieveMemberPolicy = retrieveMemberPolicy;
	}

}
