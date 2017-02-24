package com.vsp.claim.visionservicerequestapi.servicerequest.claimbuilder;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.vsp.api.provider.model.ProviderNetworkAccessPoint;
import com.vsp.claim.visionservicerequestapi.servicerequest.command.CommandMap;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.il.util.Preferences;

public class ProviderNetworkAccessPointBuilderTest {

	@Before
	public void setup(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void buildProviderNetworkAccessPoint() throws Exception{
		ProviderNetworkAccessPointBuilder builder = new ProviderNetworkAccessPointBuilder(buildCommandMap());
		ProviderNetworkAccessPoint result = builder.buildProviderNetworkAccessPoint();
		assertNotNull(result);
	}

	private CommandMap buildCommandMap() {
		return MockHelper.buildCommandMap();
	}

}
