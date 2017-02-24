package com.vsp.claim.visionservicerequestapi.servicerequest.config;

public enum ResourceOperationEnum {
	CREATE_VISION_SERVICE_REQUEST("createVisionServiceRequest"),
	DELETE_VISION_SERVICE_REQUEST("deleteVisionServiceRequest"),
	SEARCH_VISION_SERVICE_REQUESTS("searchVisionServiceRequests");

	private final String operation;
	
	ResourceOperationEnum(String operation) {
		this.operation = operation;
	}
	
	public String getOperation() {
		return operation;
	}
}