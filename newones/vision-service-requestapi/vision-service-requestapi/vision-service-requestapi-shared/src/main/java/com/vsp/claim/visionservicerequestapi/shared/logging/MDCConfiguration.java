package com.vsp.claim.visionservicerequestapi.shared.logging;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import com.vsp.api.claim.model.Claim;

public class MDCConfiguration {

	private MDCHelper mdcHelper;

	private String claimNumber;
	private String claimExtNumber;
	private String txnId;
	private int lineNumber; 
	private String authorizationNumber;
	private String policyId;
	private String consumerId;
	private String operation;
	private String productPackageName;
	private String networkId;
	private String clientId;
	private String divisionId;
	private String trackingNumber;
	
	private Map<String, String> elementsMap = new HashMap<>();
	
	public MDCConfiguration(){
		this.mdcHelper = new MDCHelper();
		mdcHelper.clear();
		
	}
		
	public MDCConfiguration configure(){
		buildElementsMap();
		mdcHelper.put(elementsMap);
		return this;
	}
	
	private void buildElementsMap(){
		if (StringUtils.isNotEmpty(clientId)) {
			elementsMap.put(MDCDataElements.CLIENT_ID.getValue(), String.valueOf(clientId));
		}
		if (StringUtils.isNotEmpty(divisionId)) {
			elementsMap.put(MDCDataElements.DIVISION_ID.getValue(), String.valueOf(divisionId));
		}
		if (StringUtils.isNotEmpty(policyId)) {
			elementsMap.put(MDCDataElements.POLICY_ID.getValue(), String.valueOf(policyId));
		}
		if (StringUtils.isNotEmpty(consumerId)) {
			elementsMap.put(MDCDataElements.CONSUMER_ID.getValue(), String.valueOf(consumerId));
		}
		if (StringUtils.isNotEmpty(networkId)) {
			elementsMap.put(MDCDataElements.NETWORK_ID.getValue(), String.valueOf(networkId));
		}
		if (StringUtils.isNotEmpty(productPackageName)) {
			elementsMap.put(MDCDataElements.PRODUCT_PACKAGE_NAME.getValue(), String.valueOf(productPackageName));
		}
		if (StringUtils.isNotEmpty(authorizationNumber)) {
			elementsMap.put(MDCDataElements.AUTHORIZATION_NUMBER.getValue(),authorizationNumber);
		}
		if (StringUtils.isNotEmpty(claimNumber) && StringUtils.isNotEmpty(claimExtNumber)) {
			StringBuilder value = getClaimNumberDashExtString(claimNumber, claimExtNumber);	
			String claimStr = MDCDataElements.CLAIM_KEY.getValue();
			elementsMap.put(claimStr, value.toString());
		}
		
		if(lineNumber > 0){
			elementsMap.put(MDCDataElements.LINE_NUMBER.getValue(), String.valueOf(lineNumber));
		}
		
		if (MapUtils.isNotEmpty(elementsMap)) {
			if (StringUtils.isNotEmpty(operation)) {
				elementsMap.put(MDCDataElements.OPERATION.getValue(), operation);
			}
			if (StringUtils.isNotEmpty(txnId)) {
				elementsMap.put(MDCDataElements.TXN_ID.getValue(), txnId);
			}
			mdcHelper.put(elementsMap);
		}
	}
	
	private void extractElementsFromClaim(Claim claim) {
		if (claim.getClaimKey() != null) {
			claimNumber = claim.getClaimKey().getClaimNumber();
			claimExtNumber = claim.getClaimKey().getClaimExtNumber();
		} 
		if (StringUtils.isNotEmpty(claim.getAuthorizationNumber())) {
			authorizationNumber = claim.getAuthorizationNumber();
		}
		if (hasPolicyId(claim)) {
			policyId = claim.getSubscriber().getMemberPolicyKey().getPolicyId();
		}
		if (hasConsumerId(claim)) {
			consumerId = claim.getPatient().getConsumerId();
		}
	}

	private boolean hasPolicyId(Claim claim) {
		return claim != null && claim.getSubscriber() != null 
				&& claim.getSubscriber().getMemberPolicyKey() != null 
				&& StringUtils.isNotEmpty(claim.getSubscriber().getMemberPolicyKey().getPolicyId());
	}
	
	private boolean hasConsumerId(Claim claim) {
		return claim != null && claim.getPatient() != null 
				&& StringUtils.isNotEmpty(claim.getPatient().getConsumerId());
	}
		
	private StringBuilder getClaimNumberDashExtString(String claimNumber, String claimExtNumber) {	
		StringBuilder value = new StringBuilder();
		value.append(claimNumber); 
		value.append("-"); // "dash" is preferred between claimNumber and claimExtNumber
		value.append(claimExtNumber); 
		return value;
	}
	
	/**
	 * Clear all entries in the MDC of the underlying implementation.
	 */
	public void clear() {
		mdcHelper.clear();
	}
	
	public MDCConfiguration setClaim(Claim claim){
		extractElementsFromClaim(claim);
		return this;
	}
	
	public MDCConfiguration setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
		return this; 
	}

	public MDCConfiguration setClaimExtNumber(String claimExtNumber) {
		this.claimExtNumber = claimExtNumber;
		return this;
	}

	public MDCConfiguration setTxnId(String txnId) {
		this.txnId = txnId;
		return this;
	}

	public MDCConfiguration setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
		return this;
	}

	public MDCConfiguration setAuthorizationNumber(String authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
		return this;
	}

	public MDCConfiguration setPolicyId(String policyId) {
		this.policyId = policyId;
		return this;
	}

	public MDCConfiguration setConsumerId(String consumerId) {
		this.consumerId = consumerId;
		return this;
	}

	public MDCConfiguration setOperation(String operation) {
		this.operation = operation;
		return this;
	}

	public MDCConfiguration setProductPackageName(String productPackageName) {
		this.productPackageName = productPackageName;
		return this;
	}

	public MDCConfiguration setNetworkId(String networkId) {
		this.networkId = networkId;
		return this;
	}

	public MDCConfiguration setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public MDCConfiguration setDivisionId(String divisionId) {
		this.divisionId = divisionId;
		return this;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public MDCConfiguration setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
		return this;
	}
}
