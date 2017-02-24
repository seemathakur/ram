package com.vsp.claim.visionservicerequestapi.servicerequest.command;

import java.util.List;

import com.vsp.claim.visionservicerequestapi.servicerequest.service.context.VisionServiceRequestApiContext;

public interface CommandMapBuilder{
	CommandMap buildCommandMap(VisionServiceRequestApiContext context, List<String> executableCommands);
}
