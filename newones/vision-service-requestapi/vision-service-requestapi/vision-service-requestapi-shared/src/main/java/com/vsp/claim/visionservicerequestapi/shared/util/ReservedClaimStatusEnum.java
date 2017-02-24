package com.vsp.claim.visionservicerequestapi.shared.util;

public enum ReservedClaimStatusEnum {
	
	INVALID_RESERVED("IR"), 
	RESERVED("RS"),
	DELETED("DE"),
	UNKNOWN("");;
	
	private String code; 
	
	private ReservedClaimStatusEnum(String code){
		this.code = code; 
	}

	public String getStatusCode(){
		return this.code;
	}
	
	public static ReservedClaimStatusEnum fromStatusCode(String value) {
		for (ReservedClaimStatusEnum code : ReservedClaimStatusEnum.values()) {
			if (isStatusEqual(code.getStatusCode(), value)) {
				return code;
			}
		}

		return UNKNOWN;
	}
	
	private static boolean isStatusEqual(String code, String value) {
		return code.equals(value);
	}

}
