package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import java.util.concurrent.Future;

import com.vsp.api.consumer.model.MemberPolicy;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;

public interface MemberPolicyServiceClient extends RestServiceClient{
	Future<MemberPolicy> retrieveMemberPolicy(CommandRequest request) throws ServiceClientException;
}
