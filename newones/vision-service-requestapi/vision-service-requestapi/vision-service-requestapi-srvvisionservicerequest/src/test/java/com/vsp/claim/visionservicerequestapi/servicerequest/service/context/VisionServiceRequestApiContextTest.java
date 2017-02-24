package com.vsp.claim.visionservicerequestapi.servicerequest.service.context;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.il.util.Preferences;
import com.vsp.oauth.AccessToken;
import com.vsp.oauth.ServiceLocationConstraint;

public class VisionServiceRequestApiContextTest {
	
	@Mock
	private ApiContext apiContext; 
	
	@Before
	public void init(){
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
		MockitoAnnotations.initMocks(this);
	}

	private void mockApiContextWithTokenHasServiceLocationConstraint(){
		ServiceLocationConstraint constraint = mock(ServiceLocationConstraint.class); 
		AccessToken token = mock(AccessToken.class); 
		Mockito.when(apiContext.getAccessToken()).thenReturn(token);
		Mockito.when(token.getService_location_constraint()).thenReturn(constraint);
	}
	
	private void mockApiContextWithClientId(String clientId){
		AccessToken token = mock(AccessToken.class); 
		Mockito.when(apiContext.getAccessToken()).thenReturn(token);
		Mockito.when(token.getClient_id()).thenReturn(clientId);
	}
	
	private void mockApiContextReturnsNoToken(){
		Mockito.when(apiContext.getAccessToken()).thenReturn(null);
	}

	@Test
	public void isMemberOnlyClientId(){
		mockApiContextWithClientId("vsp-retail");
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(apiContext);
		assertTrue(context.isIssueMemberAuthorizationOnly());
	}
	
	@Test
	public void isNotMemberOnlyClientId(){
		mockApiContextWithClientId("preclaim-api");
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(apiContext);
		assertFalse(context.isIssueMemberAuthorizationOnly());
	}
	
	@Test
	public void isNotMemberOnlyClientIdTokenIsNull(){
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(apiContext);
		assertFalse(context.isIssueMemberAuthorizationOnly());
	}
	
	@Test
	public void buildRequestContext(){
		mockApiContextWithTokenHasServiceLocationConstraint();
		VisionServiceRequestApiContext context = MockHelper.buildVisionServiceRequestApiContext();
		context.setApiContext(apiContext);
		
		assertNotNull(context);
		assertNotNull(context.getApiContext()); 
		assertNotNull(context.getServiceLocationConstraint()); 
		assertTrue(context.hasServiceLocationConstraint());
	}
}
