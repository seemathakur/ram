package com.vsp.claim.visionservicerequestapi.servicerequest.command.request;

import com.vsp.claim.visionservicerequestapi.shared.command.request.CommandRequest;

public class AccessPointCommandRequest implements CommandRequest {
	
	private String providerTaxId;
	private String serviceLocationHashCode;
	private String serviceLocationSequence;
	private String networkId;
	
	public String getProviderTaxId() {
		return providerTaxId;
	}
	
	public void setProviderTaxId(String providerTaxId) {
		this.providerTaxId = providerTaxId;
	}
	
	public String getServiceLocationHashCode() {
		return serviceLocationHashCode;
	}

	public void setServiceLocationHashCode(String serviceLocationHashCode) {
		this.serviceLocationHashCode = serviceLocationHashCode;
	}

	public String getServiceLocationSequence() {
		return serviceLocationSequence;
	}

	public void setServiceLocationSequence(String serviceLocationSequence) {
		this.serviceLocationSequence = serviceLocationSequence;
	}
	
	public String getNetworkId() {
		return networkId;
	}
	
	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() 
				+ ": " 
				+ providerTaxId 
				+ "-" 
				+ serviceLocationHashCode
				+ "-" 
				+ serviceLocationSequence
				+ "-"
				+ networkId;
	}
	
}
