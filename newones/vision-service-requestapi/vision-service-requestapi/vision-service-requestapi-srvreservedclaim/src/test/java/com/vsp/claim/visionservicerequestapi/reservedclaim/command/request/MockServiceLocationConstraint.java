package com.vsp.claim.visionservicerequestapi.reservedclaim.command.request;

import com.vsp.oauth.ServiceLocationConstraint;

public class MockServiceLocationConstraint extends ServiceLocationConstraint {
	
	public void setProviderTaxId(String providerTaxId){
		super.setProvider_tax_id(providerTaxId);
	}
}
