package com.vsp.claim.visionservicerequestapi.shared.logging;


public final class ApiInvocationEvent extends TimerEvent {
	
	private String apiName;
	
	public ApiInvocationEvent(String apiName) {
		this.apiName = apiName;
	}
	
	public ApiInvocationEvent(String apiName, String description) {
		this.apiName = apiName;
		this.setDescription(description);
	}
	
	public String getApiName() {
		return apiName;
	}
	
	@Override
	public String getIdentifier() {
		return this.apiName;
	}

	@Override
	public String getFixedMessage() {
		return "Calling API";
	}	
}
