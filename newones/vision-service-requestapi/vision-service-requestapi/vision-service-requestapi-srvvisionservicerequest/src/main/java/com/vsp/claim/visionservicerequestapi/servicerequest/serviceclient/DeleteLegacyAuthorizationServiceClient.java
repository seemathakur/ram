package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.startServiceInvocationLogEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.stopServiceInvocationLogEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.ClaimBenefitRequestResource;
import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.link.LinkBuilder;


public class DeleteLegacyAuthorizationServiceClient implements RestServiceClient {
	
	private RestClient<Home> restClient;
	private Link<Claim> deleteLegacyAuthorization;
	private final String RESOURCE_NAME = "Delete" + ClaimBenefitRequestResource.class.getSimpleName();
	
	private static final Logger LOG = LoggerFactory.getLogger(DeleteLegacyAuthorizationServiceClient.class);

	
	public Claim deleteClaimBenefitRequest(ClaimKey claimKey){
		initDeleteClaimBenefitRequestLink(claimKey); 
		ServiceInvocationEvent timerEvent = startServiceInvocationLogEvent(RESOURCE_NAME, HttpMethod.DELETE, LOG);
		Claim result = followDeleteLink();
		stopServiceInvocationLogEvent(LOG, timerEvent);
		return result; 
	}
	
	private Claim followDeleteLink() {
		return restClient.link(deleteLegacyAuthorization)
				.type(Claim.class)
				.method(HttpMethod.DELETE)
				.follow(); 
	}
	
	private void initDeleteClaimBenefitRequestLink(ClaimKey claimKey) {
		LinkBuilder.resource(ClaimBenefitRequestResource.class)
			.link(this, "deleteLegacyAuthorization")
			.deleteBenefitRequestForClaim(claimKey.getClaimNumber(), claimKey.getClaimExtNumber());	
	}
	
	@Override
	public void setRestClient(RestClient<Home> restClient) {
		this.restClient = restClient; 
	}

	@Override
	public RestClient<Home> getRestClient() {
		return restClient;
	}
	
	public Link<Claim> getDeleteLegacyAuthorization() {
		return deleteLegacyAuthorization;
	}

	public void setDeleteLegacyAuthorization(Link<Claim> deleteLegacyAuthorization) {
		this.deleteLegacyAuthorization = deleteLegacyAuthorization;
	}

}
