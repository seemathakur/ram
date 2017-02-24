package com.vsp.claim.visionservicerequestapi.servicerequest.serviceclient;

import java.util.concurrent.Future;

import com.vsp.api.client.model.ClientDivision;
import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;

public interface ClientDivisionServiceClient extends RestServiceClient{

	Future<ClientDivision> retrieveClientDivision(CommandRequest request);
	
}
