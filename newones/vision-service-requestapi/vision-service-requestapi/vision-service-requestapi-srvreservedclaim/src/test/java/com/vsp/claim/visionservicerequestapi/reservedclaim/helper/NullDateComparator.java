package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

import java.util.Date;

import org.joda.time.DateMidnight;

import com.vsp.claim.common.mapping.factory.jpa.JPAClaimDefaults;

public class NullDateComparator {
	
	public static boolean isDateEqualToDateMidnight(DateMidnight dateMidnight, Date date) {
		boolean result = false;
		
		if(dateMidnight == null) {
			if(date == null){
				return false;
			}else {
				return date.equals(JPAClaimDefaults.DEFAULT_DATE);
			}
		}
		else {
			DateMidnight convertedDate = new DateMidnight(date);			
			result = convertedDate.isEqual(dateMidnight);
		}
		return result;
	}
	

}
