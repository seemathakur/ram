package com.vsp.claim.visionservicerequestapi.servicerequest.command.request;

import com.vsp.api.client.model.ClientDivision;
import com.vsp.api.core.Link;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.oauth.AccessToken;

public class RetrieveClientDivisionCommandRequest implements CommandRequest{

	private String clientId;
	private String divisionId;
	private String asOfDate;
	private AccessToken accessToken;
	
	private Link<ClientDivision> retrieveClientDivision;
	
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
		
	public String getAsOfDate() {
		return asOfDate;
	}
	
	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}
	
	@Override
	public String toString() {
		return clientId + "-" + divisionId +
				"&asOfDate=" + asOfDate;
	}

	public AccessToken getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}

	public Link<ClientDivision> getRetrieveClientDivision() {
		return retrieveClientDivision;
	}

	public void setRetrieveClientDivision(
			Link<ClientDivision> retrieveClientDivision) {
		this.retrieveClientDivision = retrieveClientDivision;
	}

}
