package com.vsp.claim.visionservicerequestapi.shared.util;

import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.DateInterval;

public final class EffectiveDateHelper {
	
	private EffectiveDateHelper() { }

	public static String getAsOfDate(Claim claim) {
		DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd");
		if(getAsOfDateMidnight(claim) != null){
			return pattern.print(getAsOfDateMidnight(claim));
		} else {
			return null;
		}	
	}
	
	public static DateMidnight getAsOfDateMidnight(Claim claim){
		DateMidnight asOfDate = null;
		List<ClaimLine> claimLines = claim.getClaimLines(); 
		if(hasClaimLines(claimLines) && getFirstClaimLine(claimLines) != null && getFirstClaimLine(claimLines).getReservationInterval()!=null){
			asOfDate = getFirstClaimLine(claimLines).getReservationInterval().getBegin();
		}
		if(asOfDate == null) {
			asOfDate = getTodaysDate();
		}
		return asOfDate;
	}
	
	private static boolean hasClaimLines(List<ClaimLine> claimLines){
		return claimLines != null && claimLines.size() > 0; 		
	}
	
	private static ClaimLine getFirstClaimLine(List<ClaimLine> claimLines){
		return claimLines.get(0);
	}
	
	public static DateMidnight getAsOfDateFromClaimLine(ClaimLine claimLine) {
		DateInterval reservationInterval = claimLine.getReservationInterval();
		DateMidnight asOfDate = null;
		if(reservationInterval != null) {
			asOfDate = reservationInterval.getBegin();
		} else {
			asOfDate = getTodaysDate();
		}
		return asOfDate;
	}

	private static DateMidnight getTodaysDate() {
		return new DateMidnight();
	}

}
