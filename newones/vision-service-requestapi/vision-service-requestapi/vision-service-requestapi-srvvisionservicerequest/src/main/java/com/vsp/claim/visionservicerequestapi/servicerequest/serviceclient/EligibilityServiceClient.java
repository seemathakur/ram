package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import java.util.concurrent.Future;

import com.vsp.api.eligibility.model.Eligibility;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;

public interface EligibilityServiceClient extends RestServiceClient {
	Future<Eligibility> retrieveEligibility(CommandRequest request);
}
