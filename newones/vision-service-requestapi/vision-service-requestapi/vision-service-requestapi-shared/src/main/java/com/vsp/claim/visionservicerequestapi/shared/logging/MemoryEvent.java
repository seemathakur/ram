package com.vsp.claim.visionservicerequestapi.shared.logging;

public abstract class MemoryEvent extends Event {

	public MemoryEvent begin() {
		setBegin(Runtime.getRuntime().freeMemory());
		return this;
	}
	
	public MemoryEvent end() {
		setEnd(Runtime.getRuntime().freeMemory());
		return this;
	}
	
	public String getConsumedMemory() {
		long eventSpan = getEventSpan();
		
		if (getBegin() > getEnd()) {
			return String.valueOf(eventSpan);
		}
		else {
			return ("(" + eventSpan + ")");
		}			
	}
}
