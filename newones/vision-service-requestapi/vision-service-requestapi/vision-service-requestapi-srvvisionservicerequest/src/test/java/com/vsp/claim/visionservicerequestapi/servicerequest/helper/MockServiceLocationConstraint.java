package com.vsp.claim.visionservicerequestapi.servicerequest.helper;

import com.vsp.oauth.ServiceLocationConstraint;

public class MockServiceLocationConstraint extends ServiceLocationConstraint {
	
	public void setProviderTaxId(String providerTaxId){
		super.setProvider_tax_id(providerTaxId);
	}
}
