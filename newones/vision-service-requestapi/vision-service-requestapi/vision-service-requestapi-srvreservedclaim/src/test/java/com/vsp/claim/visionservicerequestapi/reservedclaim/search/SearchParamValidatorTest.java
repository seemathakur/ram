package com.vsp.claim.visionservicerequestapi.reservedclaim.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SearchParamValidatorTest {

	private static final String CLIENT_ID = "00850012";
	private static final String DIVISION_ID = "0001";
	private static final String MEMBER_POLICY_ID = "123456789";
	private static final String CONSUMER_ID = "1234567800";


	@Test
	public void testAllParamsValid() {
		SearchParamValidator validator = new SearchParamValidator(
				createCompleteSearchCriteriaBuilder());
		assertTrue(validator.isValid());
	}


	@Test
	public void testClientIdInvalid() {
		SearchCriteriaBuilder builder = createCompleteSearchCriteriaBuilder();
		builder.setClientId("1234567");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}
	
	
	@Test
	public void testAlphanumericConsumerIdIsInvalid() {
		SearchCriteriaBuilder builder = createCompleteSearchCriteriaBuilder();
		builder.setConsumerId("A12345t");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}
	
	@Test
	public void testDivisionIdInvalid() {
		SearchCriteriaBuilder builder = createCompleteSearchCriteriaBuilder();
		builder.setDivisionId("12345");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}

	@Test
	public void testPolicyIdInvalid() {
		SearchCriteriaBuilder builder = createCompleteSearchCriteriaBuilder();
		builder.setSubscriberId("ABCD123456789");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}

	@Test
	public void testClientDivPolicyOnly() {
		SearchParamValidator validator = new SearchParamValidator(createClientDivPolicyBuilder());
		assertTrue(validator.isValid());
	}
	
	@Test
	public void testClientDivPolicyOnlyInvalidClient() {
		SearchCriteriaBuilder builder = createClientDivPolicyBuilder();
		builder.setClientId("");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}
	
	@Test
	public void testClientDivPolicyOnlyInvalidDiv() {
		SearchCriteriaBuilder builder = createClientDivPolicyBuilder();
		builder.setDivisionId("123");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}
	
	@Test
	public void testClientDivPolicyOnlyInvalidPolicy() {
		SearchCriteriaBuilder builder = createClientDivPolicyBuilder();
		builder.setSubscriberId("1234567890123456789012345678901");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}
	

	@Test
	public void testValidMemberPolicyKeyAndConsumerId() {
		SearchParamValidator validator = new SearchParamValidator(createClientPolicyBuilder());
		assertTrue(validator.isValid());
	}
	

	@Test
	public void testClientDivPolicyConsumerOnly() {
		SearchParamValidator validator = new SearchParamValidator(createClientDivPolicyConsumerBuilder());
		assertTrue(validator.isValid());
	}
	

	@Test
	public void testConsumerOnly() {
		SearchParamValidator validator = new SearchParamValidator(createConsumerBuilder());
		assertTrue(validator.isValid());
	}
	
	@Test
	public void testConsumerOnlyInvalid() {
		SearchCriteriaBuilder builder = createConsumerBuilder();
		builder.setConsumerId("");
		SearchParamValidator validator = new SearchParamValidator(builder);
		assertFalse(validator.isValid());
	}

	private SearchCriteriaBuilder createCompleteSearchCriteriaBuilder() {
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder();

		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(MEMBER_POLICY_ID);
		builder.setConsumerId(CONSUMER_ID);

		return builder;
	}

	
	private SearchCriteriaBuilder createClientDivPolicyBuilder() {
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder();

		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(MEMBER_POLICY_ID);

		return builder;
	}
	
	private SearchCriteriaBuilder createClientPolicyBuilder() {
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder();

		builder.setClientId(CLIENT_ID);
		builder.setSubscriberId(MEMBER_POLICY_ID);

		return builder;
	}
	
	
	private SearchCriteriaBuilder createClientDivPolicyConsumerBuilder() {
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder();

		builder.setClientId(CLIENT_ID);
		builder.setDivisionId(DIVISION_ID);
		builder.setSubscriberId(MEMBER_POLICY_ID);
		builder.setConsumerId(CONSUMER_ID);

		return builder;
	}
	
	private SearchCriteriaBuilder createConsumerBuilder() {
		SearchCriteriaBuilder builder = new SearchCriteriaBuilder();
		
		builder.setConsumerId(CONSUMER_ID);

		return builder;
	}
}
