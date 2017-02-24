package com.vsp.claim.visionservicerequestapi.reservedclaim.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.shared.service.ClaimRequestContext;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.AccessToken;
import com.vsp.oauth.ServiceLocationConstraint;

public class ReservedClaimRequestContext extends ClaimRequestContext {
	
	private Claim claim;
	private List<ClaimLine> claimLines;
	private ApiContext apiContext; 
	private List<String> clientIdsToIssueMemberAuthOnly;
	private static final String AUTHORIZATION_DOMAIN = "authorization";
	
	private static final Logger LOG = LoggerFactory.getLogger(ReservedClaimRequestContext.class);
	
	public ReservedClaimRequestContext(Claim claim, ApiContext apiContext) {
		this(claim, claim.getClaimLines(), apiContext);		
	}
	
	public ReservedClaimRequestContext(Claim claim, List<ClaimLine> claimLines, ApiContext apiContext) {
		this.claim = claim; 
		this.claimLines = claimLines;
		this.apiContext = apiContext;
		clientIdsToIssueMemberAuthOnly = getListOfClientIdsToIssueMemberAuthOnly();
	}
	
	private List<String> getListOfClientIdsToIssueMemberAuthOnly() {
		return Preferences.getList(AUTHORIZATION_DOMAIN, "clientIdsToIssueMemberAuthorizationOnly");
	}

	public Claim getClaim() {
		return claim; 
	}

	public ApiContext getApiContext() {
		return apiContext;
	}
	
	public AccessToken getAccessToken() {
		return apiContext.getAccessToken();
	}

	public ServiceLocationConstraint getServiceLocationConstraint() {
		if(hasAccessToken()){
			return getServiceLocationConstraint(getAccessToken()); 
		}
		LOG.info("Access token does not have service location constraint");
		return null;
	}
	
	public boolean hasServiceLocationConstraint(){
		return getServiceLocationConstraint() != null;
	}

	private ServiceLocationConstraint getServiceLocationConstraint(AccessToken token) {
		return token.getService_location_constraint();
	}

	private boolean hasAccessToken() {
		return getAccessToken() != null; 
	}
	
	public List<ClaimLine> getClaimLines() {
		return claimLines;
	}

	public void setClaimLines(List<ClaimLine> claimLines) {
		this.claimLines = claimLines;
	}

	public boolean isIssueMemberAuthorizationOnly() {
		if(hasAccessToken()){
			return clientIdsToIssueMemberAuthOnly.contains(getAccessToken().getClient_id());
		}
		return false;
	}
}
