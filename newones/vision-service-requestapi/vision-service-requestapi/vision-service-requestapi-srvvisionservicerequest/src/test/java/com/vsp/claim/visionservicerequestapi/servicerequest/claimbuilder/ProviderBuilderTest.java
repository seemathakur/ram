package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.provider.model.Provider;
import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.api.provider.model.ServiceLocation;
import com.vsp.api.provider.model.ServiceLocationKey;
import com.vsp.il.util.Preferences;


public class ProviderBuilderTest {
	
	private static final String TAX_ID = "123456789";

	private ProviderBuilder builder; 
	
	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void buildProvider(){
		initializeProviderBuilder(buildClaim());
		Provider builtProvider = builder.buildProvider(); 
		assertProviderContainsProviderTaxIdFromAccesspointServiceLocation(builtProvider);
	}
	
	@Test
	public void buildProviderServiceLocationIsNull(){
		initializeProviderBuilder(buildClaimWithoutServiceLocation());
		Provider builtProvider = builder.buildProvider(); 
		assertProviderTaxIdIsNotSetOnProviderKey(builtProvider);
	}
	
	@Test
	public void buildProviderServiceLocationKeyIsNull(){
		initializeProviderBuilder(buildClaimWithoutServiceLocationKey());
		Provider builtProvider = builder.buildProvider(); 
		assertProviderTaxIdIsNotSetOnProviderKey(builtProvider);
	}
	
	@Test
	public void buildProviderTaxIdOnServiceLocationKeyIsNull(){
		initializeProviderBuilder(buildClaimWithoutProviderTaxIdOnServiceLocationKey());
		Provider builtProvider = builder.buildProvider(); 
		assertProviderTaxIdIsNotSetOnProviderKey(builtProvider);
	}
	
	private void assertProviderTaxIdIsNotSetOnProviderKey(Provider builtProvider){
		assertNotNull(builtProvider);
		assertNotNull(builtProvider.getKey());
		assertNull(builtProvider.getKey().getProviderTaxId());
	}
		
	private void initializeProviderBuilder(Claim claim){
		builder = new ProviderBuilder(claim);
	}
	
	private void assertProviderContainsProviderTaxIdFromAccesspointServiceLocation(Provider builtProvider){
		assertNotNull(builtProvider);
		assertNotNull(builtProvider.getKey());
		assertNotNull(builtProvider.getKey().getProviderTaxId());
		assertEquals(builtProvider.getKey().getProviderTaxId(), TAX_ID);
	}

	private Claim buildClaim() {
		Claim claim = new Claim();
		claim.setProviderNetworkAccessPoint(buildAccessPoint());
		return claim;
	}
	
	private ProviderNetworkAccessPoint buildAccessPoint(){
		ProviderNetworkAccessPoint accesspoint = new ProviderNetworkAccessPoint(); 
		accesspoint.setServiceLocation(buildServiceLocation());
		return accesspoint; 
	}
	
	private ServiceLocation buildServiceLocation(){
		ServiceLocation serviceLocation = new ServiceLocation();
		serviceLocation.setKey(buildServiceLocationKey());
		return serviceLocation; 
	}
	
	private ServiceLocationKey buildServiceLocationKey(){
		ServiceLocationKey serviceLocationKey = new ServiceLocationKey();
		serviceLocationKey.setProviderTaxId(TAX_ID);
		return serviceLocationKey;
	}
	
	private Claim buildClaimWithoutServiceLocation(){
		Claim claim = buildClaim();
		claim.getProviderNetworkAccessPoint().setServiceLocation(null);
		return claim;
	}
	
	private Claim buildClaimWithoutServiceLocationKey(){
		Claim claim = buildClaim();
		claim.getProviderNetworkAccessPoint().getServiceLocation().setKey(null);
		return claim;
	}
	
	private Claim buildClaimWithoutProviderTaxIdOnServiceLocationKey(){
		Claim claim = buildClaim();
		claim.getProviderNetworkAccessPoint().getServiceLocation().getKey().setProviderTaxId(null);
		return claim;
	}
}
