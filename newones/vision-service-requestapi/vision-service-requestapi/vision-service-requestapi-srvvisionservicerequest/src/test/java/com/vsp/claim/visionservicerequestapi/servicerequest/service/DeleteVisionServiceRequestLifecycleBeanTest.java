package com.vsp.claim.visionservicerequestapi.servicerequest.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.core.Link;
import com.vsp.api.home.model.Home;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.DeleteReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.claim.visionservicerequestapi.shared.exception.DatabaseIOException;
import com.vsp.il.util.Preferences;
import com.vsp.jaxrs.client.HttpMethod;
import com.vsp.jaxrs.client.RestClient;
import com.vsp.jaxrs.client.RestLink;
import com.vsp.oauth.AccessToken;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={
		DeleteVisionServiceRequestLifecycleBeanTest.Config.class
})
public class DeleteVisionServiceRequestLifecycleBeanTest {
	
	@Configuration
	static class Config {
		static { 
			if(!Preferences.initialized()) {
				Preferences.initialize();
			}
		}
		
		@Bean
		public ApiContext ApiContext(){
			return mock(ApiContext.class);
		}
		
		@Bean
		public DeleteVisionServiceRequestLifecycleBean deleteVisionServiceRequest() {
			return new DeleteVisionServiceRequestLifecycleBean(){

				@Override
				protected RestClient<Home> getRestClient() {
					return mockRestClient();
				}
				
			};
		}
		
		@Bean
		public ApiContext apiContext(){
			return mock(ApiContext.class);
		}
		
		@Bean 
		public DeleteReservedClaimsBean deleteBean() throws DatabaseIOException{
			DeleteReservedClaimsBean deleteBean = mock(DeleteReservedClaimsBean.class); 
			Mockito.when(deleteBean.delete(Matchers.anyString(), Matchers.anyString())).
				thenReturn(MockHelper.buildMockClaim());
			return deleteBean;
		}
		
		@Bean
		public PreClaimRepository preClaimRepository(){
			return mock(PreClaimRepository.class); 
		}
		
		private RestClient mockRestClient(){
			RestClient rc = mock(RestClient.class);
			RestLink link = mock(RestLink.class); 
			when(rc.link(Matchers.any(Link.class))).thenReturn(link);
			when(link.type(Claim.class)).thenReturn(link);
			when(link.method(HttpMethod.DELETE)).thenReturn(link);
			when(link.runas(Matchers.any(AccessToken.class))).thenReturn(link);
			when(link.follow()).thenReturn(MockHelper.buildMockClaim());
			return rc; 
		}
	}
	
	@Autowired DeleteVisionServiceRequestLifecycleBean deleteVisionServiceRequestBean;
	@Autowired DeleteReservedClaimsBean deleteClaimBean; 
	
	@Test
	public void testDeleteVisionServiceRequest() throws DatabaseIOException {
		VisionServiceRequest visionServiceRequest = deleteVisionServiceRequestBean.deleteVisionServiceRequest(MockHelper.TRACKING_NUMBER); 
		Mockito.verify(deleteClaimBean, Mockito.times(1)).delete(MockHelper.CLAIM_NUMBER, MockHelper.CLAIM_EXT_NUMBER); 
		assertNotNull(visionServiceRequest);
	}

}
