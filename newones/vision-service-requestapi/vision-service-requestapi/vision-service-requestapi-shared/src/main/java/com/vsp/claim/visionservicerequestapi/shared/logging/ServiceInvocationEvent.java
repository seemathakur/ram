package com.vsp.claim.visionservicerequestapi.shared.logging;

public final class ServiceInvocationEvent extends TimerEvent {
	
	private String serviceName;
	
	public ServiceInvocationEvent(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public ServiceInvocationEvent(String serviceName, String description) {
		this.serviceName = serviceName;
		this.setDescription(description);
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	@Override
	public String getIdentifier() {
		return this.serviceName;
	}

	@Override
	public String getFixedMessage() {
		return "Calling Service";
	}	
}
