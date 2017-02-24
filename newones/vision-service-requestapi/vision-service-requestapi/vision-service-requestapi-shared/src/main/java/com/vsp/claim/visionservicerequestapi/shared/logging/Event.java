package com.vsp.claim.visionservicerequestapi.shared.logging;

import java.util.Objects;

public abstract class Event {
	private long begin;
	private long end;
	private String description;

	public abstract Event begin();
	
	public abstract Event end();
	
	public abstract String getIdentifier();
	
	public abstract String getFixedMessage();
	
	public long getEventSpan() {
		return (begin > end)?(begin-end):(end-begin);
	}

	public boolean hasEnded() {
		return end != 0;
	}
	
	protected long getBegin() {
		return begin;
	}

	protected void setBegin(long begin) {
		this.begin = begin;
	}

	protected long getEnd() {
		return end;
	}

	protected void setEnd(long end) {
		this.end = end;
	}

	protected String getDescription() {
		return String.format("%s:%s:%s", getFixedMessage(), getIdentifier(), description);
	}
	
	protected void setDescription(String description) {
		this.description = description;
	}

	@Override 
	public String toString() {
	      return " Event {" +
	            " cause ='" + Objects.toString(begin) + '\'' +
	            ", code ='" + Objects.toString(end) + '\'' +
	            ", description ='" + Objects.toString(description) + '\'' +
	            "} " + super.toString();
	}

}
