package com.vsp.claim.visionservicerequest.test;

public enum StoryStateSingletonEnum {
	CLAIM_KEY("claimKey"),
	CLAIM("claim"),
	PATIENT_KEY("patient"),
	MEMBER_POLICY("memberPolicy"),
	EFFECTIVE_DATE ("effectiveDate"),
	PRODUCT_CATALOG_KEYS("productCatalogKey"),
	MEMBER_POLICY_KEY("memberPolicyKey"),
	CONSUMER_ID("consumerId"),
	NETWORK_ID("providerNetwork"),
	PRODUCT_PACKAGE_NAME("productPackageName"),
	AUTH_ISSUED_IN_SCENARIO("authIssued"),
	ACCESS_TOKEN_PROVIDER ("accessTokenProvider"),
	LINE_NUMBER("lineNumber"),
	NUM_CLAIM_LINES("numClaimLines"),
	CLAIM_LINE("claimLine"),
	CLAIMS_CREATED_IN_SCENARIO("outstandingClaims"),
	LEGACY_AUTH_NUMBER("legacyAuthorization"),
	LEGACY_AUTH_PATIENT_HISTORY("legacyAuthorizationPatientHistory"),
	VISION_SERVICE_REQUEST("servicerequest"), 
	TRACKING_NUMBER("trackingNumber"),
	CLIENT_ID("clientId"),
	DIVISION_ID("divisionId"),
	POLICY_ID("policyId"),
	ELIGIBLE_PRODUCT_ITEM("eligibleProductItem"),
	ELIGIBLE_PRODUCT_ITEMS("eligibleProductItems");

	
	private String name; 
	
	private StoryStateSingletonEnum(String name){
		this.name = name; 
	}
	
	public String getName(){
		return this.name;
	}

}
