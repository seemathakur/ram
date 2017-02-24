package com.vsp.claim.visionservicerequestapi.shared.serviceclient;

import com.vsp.api.home.model.Home;
import com.vsp.jaxrs.client.RestClient;

public interface RestServiceClient {

	void setRestClient(RestClient<Home> restClient);
	RestClient<Home> getRestClient();

}
