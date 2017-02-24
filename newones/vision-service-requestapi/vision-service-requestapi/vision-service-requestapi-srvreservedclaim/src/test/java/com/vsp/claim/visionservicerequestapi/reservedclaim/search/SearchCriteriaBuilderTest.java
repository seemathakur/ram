package com.vsp.claim.visionservicerequestapi.reservedclaim.search;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.vsp.claim.common.exception.BadRequestCriteriaException;
import com.vsp.il.util.NameValuePair;

public class SearchCriteriaBuilderTest {
	
	private static final String CLIENT_ID = "00850012";
	private static final String DIVISION_ID = "0001";
	private static final String SUBSCRIBER_ID = "123456789";
	private static final String CONSUMER_ID = "12345678";
	private SearchCriteriaBuilder builder; 
	
	
	@Test(expected=BadRequestCriteriaException.class)
	public void buildMemberPolicySearchCriteria(){
		createSearchCriteriaBuilderWithMemberPolicySearchCriteria();
		buildSearchCriteriaList();
	}
	
	@Test
	public void buildMemberPolicyAndConsumerSearchCriteria(){
		createSearchCriteriaBuilderWithMemberPolicyConsumerSearchCriteria();
		List<NameValuePair> criteria = buildSearchCriteriaList();
		
		assertNotNull(criteria);
		assertSearchCriteriaContainsMemberPolicyConsumerSearchCriteria(criteria);
	}
	
	@Test(expected=BadRequestCriteriaException.class)
	public void buildMemberPolicyAndConsumerSearchCriteriaBadConsumerId(){
		createSearchCriteriaBuilderWithMemberPolicyConsumerSearchCriteriaAndBadConsumerId();
		List<NameValuePair> criteria = buildSearchCriteriaList();
		
		assertNotNull(criteria);
		assertSearchCriteriaContainsMemberPolicyConsumerSearchCriteria(criteria);
	}
	
	@Test(expected=BadRequestCriteriaException.class)
	public void buildConsumerIdSearchCriteria(){
		createSearchCriteriaBuilderWithConsumerIdCriteria();
		buildSearchCriteriaList();
	}
	
	private List<NameValuePair> buildSearchCriteriaList(){
		return builder.build();
	}
	
	
	private static void assertSearchCriteriaContainsMemberPolicyConsumerSearchCriteria(List<NameValuePair> criteria){
		assertTrue(criteria.contains(new NameValuePair(SearchCriteriaBuilder.CLIENT_ID, CLIENT_ID))); 
		assertTrue(criteria.contains(new NameValuePair(SearchCriteriaBuilder.DIVISION_ID, DIVISION_ID)));
		assertTrue(criteria.contains(new NameValuePair(SearchCriteriaBuilder.SUBSCRIBER_ID, SUBSCRIBER_ID)));
		assertTrue(criteria.contains(new NameValuePair(SearchCriteriaBuilder.CONSUMER_ID, Integer.valueOf(CONSUMER_ID)))); 
	}
	
	
	private SearchCriteriaBuilder createSearchCriteriaBuilderWithMemberPolicySearchCriteria(){
		builder = new SearchCriteriaBuilder(); 
		
		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(SUBSCRIBER_ID);
		
		return builder; 
	}
	
	private SearchCriteriaBuilder createSearchCriteriaBuilderWithMemberPolicyConsumerSearchCriteria(){
		builder = new SearchCriteriaBuilder(); 
		
		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(SUBSCRIBER_ID);
		builder.setConsumerId(CONSUMER_ID);
		
		return builder; 
	}
	
	private SearchCriteriaBuilder createSearchCriteriaBuilderWithMemberPolicyConsumerSearchCriteriaAndBadConsumerId(){
		builder = new SearchCriteriaBuilder(); 
		
		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(SUBSCRIBER_ID);
		builder.setConsumerId("A248923");
		
		return builder; 
	}
	
	private SearchCriteriaBuilder createSearchCriteriaBuilderWithConsumerIdCriteria(){
		builder = new SearchCriteriaBuilder(); 
		builder.setConsumerId(CONSUMER_ID);
		return builder; 
	}
	
}
