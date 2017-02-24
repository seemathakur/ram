package com.vsp.claim.visionservicerequestapi.shared.logging;

public abstract class TimerEvent extends Event {
	
	public TimerEvent begin() {
		setBegin(System.currentTimeMillis());
		return this;
	}
	
	public TimerEvent end() {
		setEnd(System.currentTimeMillis());
		return this;
	}
	
	public long getDurationInMillis() {
		return getEventSpan();
	}
}
