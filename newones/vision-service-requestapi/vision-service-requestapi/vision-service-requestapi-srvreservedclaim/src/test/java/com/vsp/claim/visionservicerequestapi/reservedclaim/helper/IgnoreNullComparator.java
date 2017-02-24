package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

import java.math.BigDecimal;

import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaults;

public class IgnoreNullComparator {
	
	public static boolean compare(String ignoreNull, String comparable){
		boolean match = true; 
		if(ignoreNull != null){
			match = ignoreNull.equalsIgnoreCase(comparable); 
		}else{
			match = comparable.equalsIgnoreCase(JPAClaimDefaults.EMPTY_STRING);
		}
		return match; 
	}
	
	public static boolean compare(BigDecimal ignoreNull, BigDecimal comparable){
		boolean match = true; 
		if(ignoreNull != null){
			match = ignoreNull.equals(comparable); 
		}else{
			match = comparable.equals(JPAClaimDefaults.EMPTY_BIGDECIMAL);
		}
		return match; 
	}
	
	public static boolean compare(Integer ignoreNull, int comparable){
		boolean match = true; 
		if(ignoreNull != null){
			match = ignoreNull.equals(comparable); 
		}else{
			match = comparable == JPAClaimDefaults.DEFAULT_INT;
		}
		return match; 
	}

}
