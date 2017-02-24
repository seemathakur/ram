package com.vsp.claim.visionservicerequestapi.shared.enums;


public enum ExhaustEligibilityEnum {
	
	EXHAUST("Y"),
	DO_NOT_EXHAUST("N"),
	AD_HOC("A"),
	EXHAUST_FUTURE_ELIGIBILITY("F"),
	UNKNOWN("");
	
	private String code; 
	
	private ExhaustEligibilityEnum(String code){
		this.code = code; 
	}

	public String getCode() {
		return code;
	}
	
	public static ExhaustEligibilityEnum fromCode(String code){
		for(ExhaustEligibilityEnum enumValue : ExhaustEligibilityEnum.values()){
			if(enumValue.getCode().equalsIgnoreCase(code)){
				return enumValue; 
			}
		}
		return UNKNOWN; 
	}
	
	
}
