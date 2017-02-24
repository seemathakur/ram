package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.startServiceInvocationLogEvent;
import static com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEventLogger.stopServiceInvocationLogEvent;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.vsp.api.core.Link;
import com.vsp.api.eligibility.MemberEligibilityResource;
import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveEligibilityCommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEvent;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.link.LinkBuilder;
import com.vsp.oauth.AccessToken;

@Service("eligibilityClient")
@Scope("prototype")
public class EligibilityServiceClientImpl implements EligibilityServiceClient{
	
	private RestClient<Home> restClient;
	private static final Logger LOG = LoggerFactory.getLogger(EligibilityServiceClientImpl.class);
	 
	@Async
	public Future<Eligibility> retrieveEligibility(CommandRequest request){
		Eligibility eligibility = new Eligibility();
		Link<Eligibility> eligibilityLink = buildEligibilityLink(request);
		eligibility = retrieveEligibility(eligibilityLink, request);
		return new AsyncResult<Eligibility>(eligibility);
	}
	
	protected Link<Eligibility> buildEligibilityLink(CommandRequest request) {
		RetrieveEligibilityCommandRequest eligReq = (RetrieveEligibilityCommandRequest)request; 
		LinkBuilder.resource(MemberEligibilityResource.class)
			.link(eligReq, "retrieveMemberEligibility")
			.getEligibility(
					eligReq.getClientId(), 
					eligReq.getDivisionId(), 
					eligReq.getSubscriberId(),
					eligReq.getConsumerId(),
					eligReq.getAsOfDate(),
					false);
		return eligReq.getRetrieveMemberEligibility();
	}

	protected Eligibility retrieveEligibility(Link<Eligibility> eligibilityLink, CommandRequest request) {
		ServiceInvocationEvent timerEvent = startServiceInvocationLogEvent(MemberEligibilityResource.class.getSimpleName(), HttpMethod.GET, LOG);
		Eligibility eligibility = callMemberEligibilityResource(eligibilityLink, request);
		stopServiceInvocationLogEvent(LOG, timerEvent);
		return eligibility;
	}
	
	protected Eligibility callMemberEligibilityResource(Link<Eligibility> eligibilityLink, CommandRequest request) {
		AccessToken clientToken = ((RetrieveEligibilityCommandRequest) request).getAccessToken();
		logEligibilityLink(eligibilityLink);
		
		return restClient.link(eligibilityLink)
				.type(Eligibility.class)
				.runas(clientToken)
				.method(HttpMethod.GET)
				.follow();
	}
	
	private void logEligibilityLink(Link<Eligibility> eligibilityLink) {
		if(eligibilityLink != null){
			LOG.info("GET on MemberEligibilityResource at {}", eligibilityLink.getHref()); 
		}
	}

	@Override
	public void setRestClient(RestClient<Home> restClient) {
		this.restClient = restClient; 
	}

	@Override
	public RestClient<Home> getRestClient() {
		return this.restClient;
	}
}
