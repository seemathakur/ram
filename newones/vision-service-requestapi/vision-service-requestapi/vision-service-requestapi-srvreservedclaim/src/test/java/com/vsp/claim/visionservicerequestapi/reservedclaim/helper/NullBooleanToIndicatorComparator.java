package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaults;

public class NullBooleanToIndicatorComparator {
	public static boolean compare(Boolean booleanIndicator, String stringIndicator){
		if(booleanIndicator == null){
			return stringIndicator.equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING); 
		}else{
			if(stringIndicator == null){
				return false; 
			}else{
				String convertedIndicator = booleanIndicator.booleanValue() ? "Y" : "N";
				return stringIndicator.equalsIgnoreCase(convertedIndicator);
			}
		}
	}

}
