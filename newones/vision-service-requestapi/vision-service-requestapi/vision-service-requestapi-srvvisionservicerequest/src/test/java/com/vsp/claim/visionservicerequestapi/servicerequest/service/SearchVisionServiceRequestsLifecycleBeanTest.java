package com.vsp.claim.visionservicerequestapi.servicerequest.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vsp.api.claim.model.VisionServiceRequest;
import com.vsp.api.claim.model.VisionServiceRequests;
import com.vsp.api.util.ApiContext;
import com.vsp.claim.visionservicerequestapi.reservedclaim.persistence.PreClaimRepository;
import com.vsp.claim.visionservicerequestapi.reservedclaim.service.SearchReservedClaimsBean;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.CreateServiceRequestTestHelper;
import com.vsp.claim.visionservicerequestapi.servicerequest.helper.MockHelper;
import com.vsp.il.util.Preferences;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={
		SearchVisionServiceRequestsLifecycleBeanTest.Config.class
})
public class SearchVisionServiceRequestsLifecycleBeanTest {
	
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
		public SearchVisionServiceRequestsLifecycleBean searchServiceRequestsLifecycle() {
			return new SearchVisionServiceRequestsLifecycleBean();
		}
		
		@Bean
		public ApiContext apiContext(){
			return mock(ApiContext.class);
		}
		
		@Bean 
		public SearchReservedClaimsBean searchBean(){
			SearchReservedClaimsBean searchBean = mock(SearchReservedClaimsBean.class); 
			Mockito.when(searchBean.search(Matchers.anyString(), Matchers.anyString(), 
					Matchers.anyString(), Matchers.anyString())).thenReturn(MockHelper.buildClaims());
			return searchBean;
		}
		
		@Bean
		public PreClaimRepository preClaimRepository(){
			return mock(PreClaimRepository.class); 
		}
	}
		
	@Autowired SearchReservedClaimsBean searchClaims;
	@Autowired SearchVisionServiceRequestsLifecycleBean searchServiceRequests;
	
	@Test
	public void testServiceRequestForProductPackage() {
		VisionServiceRequests items = searchServiceRequests.searchVisionServiceRequests(CreateServiceRequestTestHelper.CLIENT_ID,
				CreateServiceRequestTestHelper.DIV_ID, CreateServiceRequestTestHelper.POLICY_ID, 
				CreateServiceRequestTestHelper.CONSUMER_ID);
		
		Mockito.verify(searchClaims, Mockito.times(1)).
			search(Matchers.anyString(), Matchers.anyString(), Matchers.anyString(), Matchers.anyString()); 
		assertNotNull(items);
		assertSearchResultsHaveSelfLink(items); 
	}

	private void assertSearchResultsHaveSelfLink(VisionServiceRequests requests) {
		for(VisionServiceRequest request: requests){
			assertNotNull(request.getSelf());
		}
	}

}
