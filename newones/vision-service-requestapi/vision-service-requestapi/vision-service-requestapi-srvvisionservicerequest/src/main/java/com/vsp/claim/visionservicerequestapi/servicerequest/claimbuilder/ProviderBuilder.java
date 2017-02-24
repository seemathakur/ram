package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.provider.model.Provider;
import com.vsp.api.provider.model.ProviderKey;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.api.provider.model.ServiceLocationKey;
import com.vsp.claim.visionservicerequestapi.shared.logging.DebugLogger;

public class ProviderBuilder {
	private Claim claim; 
	
	private static final Logger LOG = LoggerFactory.getLogger(ProviderBuilder.class);
	
	public ProviderBuilder(Claim claim){
		this.claim = claim;
	}
	
	public Provider buildProvider(){
		Provider provider = new Provider(); 
		ProviderKey key = new ProviderKey();
		key = buildProviderKeyFromServiceLocationKey();
		provider.setKey(key);
		return provider;
	}

	
	private ProviderKey buildProviderKeyFromServiceLocationKey(){
		ProviderKey key = new ProviderKey();
		if(hasServiceLocation() && hasServiceLocationKey() && hasProviderTaxIdOnServiceLocationKey()){
			String taxId = getProviderTaxIdFromServiceLocationKey();
			DebugLogger.debugEnabled(LOG, "getProviderTaxIdFromServiceLocationKey(): {}", taxId);
			key.setProviderTaxId(taxId);
		}
		return key;
	}
	
	private boolean hasProviderTaxIdOnServiceLocationKey(){
		return getProviderTaxIdFromServiceLocationKey()!= null; 
	}
	
	private String getProviderTaxIdFromServiceLocationKey(){
		return getServiceLocationKeyFromClaim().getProviderTaxId();
	}
	
	private boolean hasServiceLocation(){
		return getServiceLocationFromClaim()!= null; 
	}
	
	private ServiceLocation getServiceLocationFromClaim(){
		return claim.getProviderNetworkAccessPoint().getServiceLocation(); 
	}
	private boolean hasServiceLocationKey(){
		return getServiceLocationKeyFromClaim()!=null;
	}
	private ServiceLocationKey getServiceLocationKeyFromClaim(){
		return getServiceLocationFromClaim().getKey();
	}

}
