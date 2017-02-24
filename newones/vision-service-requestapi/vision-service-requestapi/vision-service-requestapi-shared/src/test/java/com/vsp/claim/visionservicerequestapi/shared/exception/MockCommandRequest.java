package com.vsp.claim.visionservicerequestapi.shared.exception;

import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;

public class MockCommandRequest implements CommandRequest {
	
	@Override
	public String toString() {
		return "This is a mock class";
	}

}
