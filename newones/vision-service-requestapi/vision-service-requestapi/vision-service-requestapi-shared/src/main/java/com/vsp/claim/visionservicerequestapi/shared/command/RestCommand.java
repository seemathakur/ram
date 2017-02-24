package com.vsp.claim.visionservicerequestapi.shared.command;

import com.vsp.api.home.model.Home;
import com.vsp.claim.visionservicerequestapi.shared.serviceclient.RestServiceClient;
import com.vsp.jaxrs.client.RestClient;

public interface RestCommand {
	void initializeServiceClient(RestClient<Home> restClient); 
	RestServiceClient getServiceClient();
}
