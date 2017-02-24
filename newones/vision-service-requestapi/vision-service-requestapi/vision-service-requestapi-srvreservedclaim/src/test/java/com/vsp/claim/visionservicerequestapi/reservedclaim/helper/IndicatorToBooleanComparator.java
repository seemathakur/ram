package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

public class IndicatorToBooleanComparator {
	
	public static boolean compare(String stringIndicator, Boolean booleanIndicator){
		if(stringIndicator == null)
			return false; 
		Boolean convertedIndicator = stringIndicator.equals("Y") ? Boolean.TRUE : Boolean.FALSE;

		return convertedIndicator == booleanIndicator; 
	}
}
