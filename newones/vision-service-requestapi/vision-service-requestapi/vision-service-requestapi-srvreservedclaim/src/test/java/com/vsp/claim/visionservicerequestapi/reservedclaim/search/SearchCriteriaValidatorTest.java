package com.vsp.claim.visionservicerequestapi.reservedclaim.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SearchCriteriaValidatorTest {

	private static final String CLIENT_ID = "00850012";
	private static final String DIVISION_ID = "0001";
	private static final String SUBSCRIBER_ID = "12345678";
	private static final String CONSUMER_ID = "1234567";
	private SearchCriteriaBuilder builder; 
		
	
	@Test	
	public void testValidSearchWithClientIdDivisionIdSubscriberIdAndConsumerId(){
		builder = new SearchCriteriaBuilder();
		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(SUBSCRIBER_ID);
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertTrue(validator.isValid()); 
	}
	
	@Test	
	public void isInvalidSearchWithClientIdSubscriberId(){
		builder = new SearchCriteriaBuilder();
		
		builder.setClientId(CLIENT_ID);
		builder.setSubscriberId(SUBSCRIBER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid()); 
	}	
	
	@Test	
	public void isInvalidSearchWithConsumerId(){
		builder = new SearchCriteriaBuilder(); 
		
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid()); 
	}	
	
	@Test
	public void isInvalidSearchWithNoCriteria(){
		builder = new SearchCriteriaBuilder();
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid());
	}
	
	@Test
	public void isInvalidSearchClientIdConsumerId(){
		builder = new SearchCriteriaBuilder();
		builder.setClientId(CLIENT_ID);
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid());
	}	
	
	@Test
	public void isInvalidSearchSubscriberIdConsumerId(){
		builder = new SearchCriteriaBuilder();
		builder.setSubscriberId(SUBSCRIBER_ID);
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid());
	}
	
	@Test
	public void isInvalidSearchDivIdConsumerId(){
		builder = new SearchCriteriaBuilder();
		builder.setDivisionId(DIVISION_ID);
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid());
	}	
	
	@Test
	public void isInvalidSearchClientIdDivIdConsumerId(){
		builder = new SearchCriteriaBuilder();
		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid());
	}
	
	@Test
	public void isInvalidSearchDivIdSubscriberIdConsumerId(){
		builder = new SearchCriteriaBuilder();
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(SUBSCRIBER_ID);
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid());
	}
	
	@Test
	public void isInvalidSearchClientIdSubscriberIdConsumerId(){
		builder = new SearchCriteriaBuilder();
		builder.setClientId(CLIENT_ID);
		builder.setSubscriberId(SUBSCRIBER_ID);
		builder.setConsumerId(CONSUMER_ID);
		SearchCriteriaValidator validator = new SearchCriteriaValidator(builder);
		assertFalse(validator.isValid());
	}
	
}
