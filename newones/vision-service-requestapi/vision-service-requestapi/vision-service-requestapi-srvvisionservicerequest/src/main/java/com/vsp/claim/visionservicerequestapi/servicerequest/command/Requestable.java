package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;

public interface Requestable {
	
	void buildRequest(VisionServiceRequestApiContext context);
	
}
