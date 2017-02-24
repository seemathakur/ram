package com.vsp.claim.visionservicerequestapi.servicerequest.notification;

import java.util.Objects;

public class Notification {

	private String code;
	private String description;
	private Throwable cause;
	
	public Notification(String code, String description, Throwable cause) {
		super();
		this.code = code;
		this.description = description;
		this.cause = cause;
	}	
	
	public Notification(String code) {
		super();
		this.code = code;
	}
	
	public Notification() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(
				this.cause, this.code, this.description);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) 
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Notification other = (Notification) obj;
		return    Objects.equals(this.cause, other.cause)
				&& Objects.equals(this.code, other.code)
				&& Objects.equals(this.description, other.description);
	}
}
