package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.startServiceInvocationLogEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.stopServiceInvocationLogEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.ClaimBenefitRequestResource;
import com.vsp.api.claim.model.Claim;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEvent;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.link.LinkBuilder;

public class IssueLegacyAuthorizationServiceClient implements RestServiceClient  {

	private RestClient<Home> restClient;
	private Link<Claim> issueLegacyAuthorization; 
	private final String RESOURCE_NAME = "Create" + ClaimBenefitRequestResource.class.getSimpleName();
	
	private static final Logger LOG = LoggerFactory.getLogger(IssueLegacyAuthorizationServiceClient.class);

	public IssueLegacyAuthorizationServiceClient() {
	}
	
	public Claim issueLegacyAuthorization(Claim claim) {
		LOG.info("Issue legacy authorization for claim");
		buildIssueLegacyAuthorizationLink(claim);
		ServiceInvocationEvent timerEvent = startServiceInvocationLogEvent(RESOURCE_NAME, HttpMethod.POST, LOG);
		Claim result = callClaimBenefitRequestResource(claim); 
		stopServiceInvocationLogEvent(LOG, timerEvent);
		return result;
	}
	
	private Claim callClaimBenefitRequestResource(Claim claim) {
		return restClient.link(issueLegacyAuthorization)
				.type(Claim.class)
				.method(HttpMethod.POST)
				.body(claim)
				.follow();
	}
	
	protected void buildIssueLegacyAuthorizationLink(Claim claim) {
		LinkBuilder.resource(ClaimBenefitRequestResource.class)
			.link(this, "issueLegacyAuthorization")
			.issueBenefitRequestFromClaim(claim);
	}
	
	public void setRestClient(RestClient<Home> restClient) {
		this.restClient = restClient; 
	}
	
	@Override
	public RestClient<Home> getRestClient() {
		return this.restClient;
	}

	public Link<Claim> getIssueLegacyAuthorization() {
		return issueLegacyAuthorization;
	}

	public void setIssueLegacyAuthorization(Link<Claim> issueLegacyAuthorization) {
		this.issueLegacyAuthorization = issueLegacyAuthorization;
	}

}