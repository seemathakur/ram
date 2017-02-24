package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveMemberPolicyCommandRequest;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.RetrieveMemberPolicyCommandRequestBuilder;
import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient.MemberPolicyServiceClient;
import com.vsp.claim.visionservicerequestapi.shared.command.RestCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.RetrieveCommand;
import com.vsp.claim.visionservicerequestapi.shared.command.UncheckedExceptionCommand;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;
import com.vsp.jaxrs.client.RestClient;

public class RetrieveMemberPoliciesCommand extends RetrieveCommand implements UncheckedExceptionCommand<MemberPolicy>, Requestable, RestCommand{
	
	@Autowired
	private MemberPolicyServiceClient memberPolicyClient;
	
	private Future<MemberPolicy> returnValue;

	private static final Logger LOG = LoggerFactory.getLogger(RetrieveMemberPoliciesCommand.class);
	
	public RetrieveMemberPoliciesCommand(){
		super(CommandMap.RETRIEVE_MEMBER_POLICY_COMMAND, "Retrieve member policies");
	}

	@Override
	public void run(){
		validateRequestIsNotNull();	
		retrieveMemberPolicy();
	}
	
	private void retrieveMemberPolicy(){
		try {
			returnValue = memberPolicyClient.retrieveMemberPolicy((RetrieveMemberPolicyCommandRequest)getRequest());
		}catch (ServiceClientException serviceException) {
			setSynchronousException(serviceException);
		}
	}

	@Override
	public MemberPolicy getReturnValue() {
		MemberPolicy serviceClientResponse = getValidatedResponse();
		validateResponseIsNotNull(serviceClientResponse);
		return serviceClientResponse;
	}
	
	private MemberPolicy getValidatedResponse() {
		MemberPolicy serviceClientResponse = null;
		try {
			throwAnySynchronousException();
			serviceClientResponse = returnValue.get();
		}catch (InterruptedException | ExecutionException | ServiceClientException serviceException) {
			handleException(serviceException);
		}
		return serviceClientResponse;
	}
	
	@Override
	public void buildRequest(VisionServiceRequestApiContext context) {
		setRequest(RetrieveMemberPolicyCommandRequestBuilder.buildRequest(context));		
	}

	public String getRequestAsString() {
		return getRequest().toString();
	}

	@Override
	public String toString(){
		return getCommandMapName();
	}

	@Override
	public void initializeServiceClient(RestClient<Home> restClient) {
		memberPolicyClient.setRestClient(restClient);
	}

	@Override
	public RestServiceClient getServiceClient() {
		return memberPolicyClient;
	}
}
