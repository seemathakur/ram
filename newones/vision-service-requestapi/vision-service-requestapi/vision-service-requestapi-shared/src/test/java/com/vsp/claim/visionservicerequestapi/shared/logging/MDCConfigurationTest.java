package com.vsp.claim.visionservicerequestapi.shared.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.MDC;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimKey;
import com.vsp.api.consumer.model.MemberPolicyKey;
import com.vsp.api.consumer.model.Membership;
import com.vsp.il.service.ServiceContext;
import com.vsp.il.util.Preferences;

public class MDCConfigurationTest {
	
	public static final String MDC_KEY = "mdcData";
	public static final String OPERATION = "create"; // any operation in ReservedClaimResourceOperationEnum
	public static final String TXID_ELEMENT = MDCDataElements.TXN_ID.getValue() ;
	public static final String LINE_NUMBER_ELEMENT = MDCDataElements.LINE_NUMBER.getValue() ;
	
	public static final String CLAIM_NUMBER = "10000000";
	public static final String CLAIM_EXT_NUMBER = "00";
	
	public static final String CLAIM_KEY = CLAIM_NUMBER+"-"+CLAIM_EXT_NUMBER;
	public static final String CLAIM_KEY_ELEMENT = MDCDataElements.CLAIM_KEY.getValue() ;
	
	public static final String CLIENT_ID = "00434000";
	public static final String CLIENT_ID_ELEMENT = MDCDataElements.CLIENT_ID.getValue() ;
	
	public static final String DIVISION_ID = "0001";
	public static final String DIVISION_ID_ELEMENT = MDCDataElements.DIVISION_ID.getValue() ;
	
	public static final String POLICY_ID = "9162204504";
	public static final String POLICY_ID_ELEMENT = MDCDataElements.POLICY_ID.getValue() ;
	
	public static final String CONSUMER_ID = "300000000";
	public static final String CONSUMER_ID_ELEMENT = MDCDataElements.CONSUMER_ID.getValue() ;
	
	public static final String NETWORK_ID = "300000000";
	public static final String NETWORK_ID_ELEMENT = MDCDataElements.NETWORK_ID.getValue() ;
	
	public static final String PRODUCT_PACKAGE_NAME = "Signature";
	public static final String PRODUCT_PACKAGE_NAME_ELEMENT = MDCDataElements.PRODUCT_PACKAGE_NAME.getValue() ;
	
	public static final String AUTHORIZATION_NUMBER = "123456789";
	public static final String AUTHORIZATION_NUMBER_ELEMENT = MDCDataElements.AUTHORIZATION_NUMBER.getValue() ;
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testConfigureMDCClaim() {
		String txid = ServiceContext.getCurrentInstance().getTransactionID();
		
		Claim claim = buildFullClaim();
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(OPERATION)
			.setTxnId(txid)
			.setClaim(claim).configure(); 
		String log = MDC.get(MDC_KEY);

		initMDC.clear();
		assertTrue(log.contains(TXID_ELEMENT+"="+txid));
		assertTrue(log.contains(POLICY_ID_ELEMENT+"="+POLICY_ID));
		assertTrue(log.contains(AUTHORIZATION_NUMBER_ELEMENT+"="+AUTHORIZATION_NUMBER));
		assertTrue(log.contains(CLAIM_KEY_ELEMENT+"="+CLAIM_KEY));
		assertTrue(log.contains(CONSUMER_ID_ELEMENT+"="+CONSUMER_ID));
	}
	
	@Test
	public void testConfigureMDCClaimNull() {
		String txid = ServiceContext.getCurrentInstance().getTransactionID();
		Claim claim = new Claim();
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(OPERATION)
			.setTxnId(txid)
			.setClaim(claim).configure();
		String log = MDC.get(MDC_KEY);
		initMDC.clear();
		assertEquals(log,null);
	}
	
	@Test
	public void testConfigureMDCClaimNullTxid() {
		String txid = null;
		Claim claim = new Claim();
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(OPERATION)
			.setTxnId(txid)
			.setClaim(claim).configure(); 
		String log = MDC.get(MDC_KEY);
		initMDC.clear();
		assertEquals(null,log);
	}
	
	
	@Test
	public void testConfigureMDCClaimString() {
		String txnId = ServiceContext.getCurrentInstance().getTransactionID();
		MDCConfiguration initMDC = new MDCConfiguration();

		initMDC.setOperation(OPERATION)
					.setTxnId(txnId)
					.setClaimNumber(CLAIM_NUMBER)
					.setClaimExtNumber(CLAIM_EXT_NUMBER).configure();
		
		String log = MDC.get(MDC_KEY);
		
		initMDC.clear();
		assertTrue(log.contains(TXID_ELEMENT+"="+txnId));
		assertTrue(log.contains(CLAIM_KEY_ELEMENT+"="+CLAIM_KEY));
	}
	
	@Test
	public void testConfigureMDCClaimLineKey() {
		String txid = ServiceContext.getCurrentInstance().getTransactionID();
		MDCConfiguration initMDC = new MDCConfiguration();
		int lineNumber = 1;
		
		initMDC.setOperation(OPERATION)
					.setTxnId(txid)
					.setClaimNumber(CLAIM_NUMBER)
					.setClaimExtNumber(CLAIM_EXT_NUMBER)
					.setLineNumber(lineNumber).configure();
		
		String log = MDC.get(MDC_KEY);
		
		initMDC.clear();		
		assertTrue(log.contains(TXID_ELEMENT+"="+txid));
		assertTrue(log.contains(CLAIM_KEY_ELEMENT+"="+CLAIM_KEY));
		assertTrue(log.contains(LINE_NUMBER_ELEMENT+"="+lineNumber));
	}
	
	@Test
	public void testConfigureMDCElementsMap() {
		String txid = ServiceContext.getCurrentInstance().getTransactionID();
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(OPERATION)
					.setTxnId(txid)
					.setClientId(CLIENT_ID)
					.setDivisionId(DIVISION_ID)
					.setPolicyId(POLICY_ID)
					.setConsumerId(CONSUMER_ID)
					.setNetworkId(NETWORK_ID) 
					.setProductPackageName(PRODUCT_PACKAGE_NAME).configure();
		String log = MDC.get(MDC_KEY);

		initMDC.clear();	
		assertTrue(log.contains(TXID_ELEMENT+"="+txid));	
		assertTrue(log.contains(CLIENT_ID_ELEMENT+"="+CLIENT_ID));
		assertTrue(log.contains(DIVISION_ID_ELEMENT+"="+DIVISION_ID));
		assertTrue(log.contains(POLICY_ID_ELEMENT+"="+POLICY_ID));
		assertTrue(log.contains(CONSUMER_ID_ELEMENT+"="+CONSUMER_ID));
		assertTrue(log.contains(NETWORK_ID_ELEMENT+"="+NETWORK_ID));
		assertTrue(log.contains(PRODUCT_PACKAGE_NAME_ELEMENT+"="+PRODUCT_PACKAGE_NAME));			
	}
	
	@Test
	public void testConfigureMDCClaimStringWithLineNull() {
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(OPERATION)
				.setLineNumber(0).configure();
		String log = MDC.get(MDC_KEY);
		initMDC.clear();
		assertEquals(null, log);
	}
	
	@Test
	public void testConfigureMDCConsumerDataNullElementsMapWithClaim() {
		MDCConfiguration initMDC = new MDCConfiguration();
		initMDC.setOperation(OPERATION).configure(); 
		String log = MDC.get(MDC_KEY);
		initMDC.clear();
		assertEquals(null,log);
	}
	
	@Test
	public void testConfigureMDCConsumerDataAndClaimKey() {
		String txid = ServiceContext.getCurrentInstance().getTransactionID();
		MDCConfiguration initMDC = new MDCConfiguration();
		
		initMDC.setOperation(OPERATION)
				.setTxnId(txid)
				.setClientId(CLIENT_ID)
				.setDivisionId(DIVISION_ID)
				.setPolicyId(POLICY_ID)
				.setConsumerId(CONSUMER_ID)
				.setNetworkId(NETWORK_ID)
				.setProductPackageName(PRODUCT_PACKAGE_NAME)
				.setClaimNumber(CLAIM_NUMBER)
				.setClaimExtNumber(CLAIM_EXT_NUMBER)
				.configure(); 
		
		String log = MDC.get(MDC_KEY);
		
		initMDC.clear();
		assertTrue(log.contains(TXID_ELEMENT+"="+txid));	
		assertTrue(log.contains(CLIENT_ID_ELEMENT+"="+CLIENT_ID));
		assertTrue(log.contains(DIVISION_ID_ELEMENT+"="+DIVISION_ID));
		assertTrue(log.contains(POLICY_ID_ELEMENT+"="+POLICY_ID));
		assertTrue(log.contains(CONSUMER_ID_ELEMENT+"="+CONSUMER_ID));
		assertTrue(log.contains(NETWORK_ID_ELEMENT+"="+NETWORK_ID));
		assertTrue(log.contains(PRODUCT_PACKAGE_NAME_ELEMENT+"="+PRODUCT_PACKAGE_NAME));
		assertTrue(log.contains(CLAIM_KEY_ELEMENT+"="+CLAIM_KEY));
	}
	
	public Claim buildFullClaim() {
		Claim claim = new Claim();
		claim.setClaimKey(buildClaimKey());
		claim.setAuthorizationNumber(AUTHORIZATION_NUMBER);
		claim.setSubscriber(buildSubscriberAndPatient());
		claim.setPatient(buildSubscriberAndPatient());
		return claim;
	}
	
	public ClaimKey buildClaimKey() {
		ClaimKey key = new ClaimKey();
		key.setClaimNumber(CLAIM_NUMBER);
		key.setClaimExtNumber(CLAIM_EXT_NUMBER);
		return key;
	}
	
	public Membership buildSubscriberAndPatient() {
		Membership s = new Membership();
		MemberPolicyKey m = new MemberPolicyKey();
		m.setPolicyId(POLICY_ID);
		s.setMemberPolicyKey(m);
		s.setConsumerId(CONSUMER_ID);
		return s;
	}
	
}
