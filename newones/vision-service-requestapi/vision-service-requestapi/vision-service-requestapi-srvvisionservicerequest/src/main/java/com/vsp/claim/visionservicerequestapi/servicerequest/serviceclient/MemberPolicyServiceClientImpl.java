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

import com.vsp.api.consumer.MemberPolicyResource;
import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveMemberPolicyCommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.claim.visionservicerequestapi.shared.logging.ServiceInvocationEvent;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.link.LinkBuilder;
import com.vsp.oauth.AccessToken;

@Service("memberPolicyServiceClient")
@Scope("prototype")
public class MemberPolicyServiceClientImpl implements MemberPolicyServiceClient {

	private RestClient<Home> restClient;
	private static final Logger LOG = LoggerFactory.getLogger(MemberPolicyServiceClientImpl.class);

	@Async
	public Future<MemberPolicy> retrieveMemberPolicy(CommandRequest commandRequest) throws ServiceClientException {
		Link<MemberPolicy> link = buildMemberPolicyLinkWithParameters(commandRequest);
		AccessToken accessToken = getAccessTokenFromCommandRequest(commandRequest); 
		MemberPolicy memberPolicy = callMemberPolicyResource(link, accessToken); 

		return new AsyncResult<MemberPolicy>(memberPolicy);
	}

	private MemberPolicy callMemberPolicyResource(Link<MemberPolicy> link, AccessToken accessToken) {
		ServiceInvocationEvent timerEvent = startServiceInvocationLogEvent(MemberPolicyResource.class.getSimpleName(), HttpMethod.GET, LOG);
		MemberPolicy memberPolicy =  executeRetrieveMemberPolicyLink(link, accessToken);
		stopServiceInvocationLogEvent(LOG, timerEvent);
		return memberPolicy; 
	}


	private AccessToken getAccessTokenFromCommandRequest(CommandRequest commandRequest) {
		return ((RetrieveMemberPolicyCommandRequest)commandRequest).getAccessToken();
	}

	private Link<MemberPolicy> buildMemberPolicyLinkWithParameters(CommandRequest commandRequest) throws ServiceClientException {
		RetrieveMemberPolicyCommandRequest request = (RetrieveMemberPolicyCommandRequest)commandRequest;
		LinkBuilder.resource(MemberPolicyResource.class)
				.link(request, "retrieveMemberPolicy")
				.getPolicy(request.getClientId(), 
						request.getDivisionId(), 
						request.getSubscriberId(), 
						request.getAsOfDate()); 
		return request.getRetrieveMemberPolicy();
	}

	protected MemberPolicy executeRetrieveMemberPolicyLink(Link<MemberPolicy> memberPolicyLink, AccessToken accessToken) {
		return restClient.link(memberPolicyLink)
				.type(MemberPolicy.class)
				.runas(accessToken)
				.method(HttpMethod.GET)
				.follow();
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