package com.vsp.claim.visionservicerequestapi.reservedclaim.config;

public enum ReservedClaimResourceOperationEnum {
	RETRIEVE_CLAIM("retrieve"),
	SEARCH_CLAIM("search"),
	CREATE_CLAIM("create"),
	CREATE_CLAIM_LINES("createLines"),
	UPDATE_CLAIM("update"),
	UPDATE_CLAIM_LINE("updateLine"),
	DELETE_CLAIM("delete"),
	DELETE_CLAIM_LINE("deleteLine");
	
	private final String operation;
	
	ReservedClaimResourceOperationEnum(String operation) {
		this.operation = operation;
	}
	
	public String getOperation() {
		return operation;
	}
}
