package com.vsp.claim.visionservicerequestapi.reservedclaim.helper;

import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;

public class DateComparator {
	
	public static boolean isTimeStampEqualToDateTime(Timestamp timestamp, DateTime dateTime) {
		DateTime convertedTimestamp = new DateTime(timestamp.getTime());
		
		return convertedTimestamp.isEqual(dateTime);
	}
	
	public static boolean isDateEqualToDateMidnight(Date date, DateMidnight dateMidnight) {
		boolean result = false;
		
		if(date == null && dateMidnight == null) {
			result = true;
		}
		else {
			DateMidnight convertedDate = new DateMidnight(date);			
			result = convertedDate.isEqual(dateMidnight);
		}
		return result;
	}
	

}
