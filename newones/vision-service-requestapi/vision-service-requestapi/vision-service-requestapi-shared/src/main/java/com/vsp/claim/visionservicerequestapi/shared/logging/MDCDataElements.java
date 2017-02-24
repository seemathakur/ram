package com.vsp.claim.visionservicerequestapi.shared.logging;

public enum MDCDataElements {

	OPERATION("operation"),
	TXN_ID ("txid"),
	CLAIM_KEY ("claimKey"),
	LINE_NUMBER ("lineNumber"),
	AUTHORIZATION_NUMBER ("authorizationNumber"),
	POLICY_ID ("policyId"),
	CONSUMER_ID ("consumerId"),
	CLIENT_ID ("clientId"),
	DIVISION_ID ("divisionId"),
	NETWORK_ID ("networkId"),
	PRODUCT_PACKAGE_NAME ("productPackageName");
	
	private final String value;
	
	MDCDataElements(String value)
	{
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
