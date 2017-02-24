package com.vsp.claim.visionservicerequestapi.shared.logging;

public class MemoryInformationEvent extends MemoryEvent {
	
	private String processName;
	
	public long maximumMemory() {
		return Runtime.getRuntime().maxMemory();
	}
	
	public MemoryInformationEvent(String processName) {
		this.processName = processName;
	}
	
	public MemoryInformationEvent(String processName, String description) {
		this.processName = processName;
		this.setDescription(description);
	}
	
	public String getProcessName() {
		return processName;
	}

	@Override
	public String getIdentifier() {
		return this.processName;
	}
	
	@Override
	public String getFixedMessage() {
		return "Memory information";
	}
}
