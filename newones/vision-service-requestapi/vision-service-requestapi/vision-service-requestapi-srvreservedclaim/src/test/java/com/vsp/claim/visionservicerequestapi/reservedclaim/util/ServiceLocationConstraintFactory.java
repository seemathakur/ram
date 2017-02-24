package com.vsp.claim.visionservicerequestapi.reservedclaim.util;

import org.junit.Before;

import com.vsp.claim.visionservicerequestapi.reservedclaim.command.request.MockServiceLocationConstraint;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.ServiceLocationConstraint;

public class ServiceLocationConstraintFactory {
	
	private static final String PROVIDER_TAX_ID = "987456123";
	private static final String SERVICE_LOCATION_HASH_CODE = "23 ";
	private static final String SERVICE_LOCATION_SEQUENCE = "0";
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	public static ServiceLocationConstraint buildServiceLocationConstraint(String hashCode, String locationSeq, String providerTaxId){
		MockServiceLocationConstraint constraint = new MockServiceLocationConstraint();
		
		constraint.setService_location_hash_code(hashCode);
		constraint.setService_location_sequence(locationSeq);
		constraint.setProviderTaxId(providerTaxId);
		
		return constraint; 
	}
	
	
	public static ServiceLocationConstraint buildServiceLocationConstraint(){
		MockServiceLocationConstraint constraint = new MockServiceLocationConstraint();
		
		constraint.setService_location_hash_code(SERVICE_LOCATION_HASH_CODE);
		constraint.setService_location_sequence(SERVICE_LOCATION_SEQUENCE);
		constraint.setProviderTaxId(PROVIDER_TAX_ID);
		
		return constraint; 
	}

}
