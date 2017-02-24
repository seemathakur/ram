package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import java.util.concurrent.Future;

import com.vsp.api.provider.model.ProviderNetworkAccessPoints;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.request.AccessPointCommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.exception.ServiceClientException;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;

public interface AccessPointsServiceClient extends RestServiceClient{
		
	Future<ProviderNetworkAccessPoints> searchAsynchronously(AccessPointCommandRequest commandRequest) throws ServiceClientException;

}
