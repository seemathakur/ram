package com.vsp.claim.visionservicerequestapi.shared.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import com.vsp.api.claim.model.Claim;
import com.vsp.api.claim.model.ClaimLine;
import com.vsp.api.util.DateInterval;
import com.vsp.il.util.Preferences;

public class EffectiveDateHelperTest {
	
	private static final DateMidnight RESERVATION_BEGIN = new DateMidnight("2015-01-02");
	private static final DateMidnight RESERVATION_ISSUE = new DateMidnight("2015-01-01");
	private DateTimeFormatter pattern = DateTimeFormat.forPattern("yyyy-MM-dd");
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}

	@Test
	public void testGetAsOfDateFromReservationBeginOnClaimLine(){
		String date = EffectiveDateHelper.getAsOfDate(buildClaimWithReservationIssueAndReservationBegin());
		assertNotNull(date); 
		assertEquals(pattern.print(RESERVATION_BEGIN), date);
	}
	
	private Claim buildClaimWithReservationIssueAndReservationBegin(){
		Claim claim = new Claim();
		claim.setReservationIssueDate(RESERVATION_ISSUE);
		List<ClaimLine> claimLines = new ArrayList<ClaimLine>();
		ClaimLine claimLine = new ClaimLine(); 
		claimLine.setReservationInterval(new DateInterval(RESERVATION_BEGIN, null));
		claimLines.add(claimLine); 
		claim.setClaimLines(claimLines);
		return claim;
	}
	
	@Test
	public void testGetNullAsOfDateFromClaimLinesWithoutReservationBegin(){
		String date = EffectiveDateHelper.getAsOfDate(buildClaimWithClaimLinesAndNoReservationBegin());
		String expected = pattern.print(new DateMidnight());
		assertEquals(expected, date);
	}
	
	private Claim buildClaimWithClaimLinesAndNoReservationBegin(){
		Claim claim = new Claim();
		List<ClaimLine> claimLines = new ArrayList<ClaimLine>();
		ClaimLine claimLine = new ClaimLine(); 
		claimLines.add(claimLine); 
		claim.setClaimLines(claimLines);
		return claim;
	}
	
	@Test
	public void testGetAsOfDateNoClaimLines(){
		String date = EffectiveDateHelper.getAsOfDate(buildClaimWithNoLines());
		String expected = pattern.print(new DateMidnight());
		assertEquals(expected, date);
	}
	
	private Claim buildClaimWithNoLines(){
		return new Claim();
	}
	
	@Test
	public void testGetAsOfDateFromClaimLine() {
		ClaimLine claimLine = buildTestClaimLine();
		DateMidnight asOfDate = EffectiveDateHelper.getAsOfDateFromClaimLine(claimLine);
		assertEquals(RESERVATION_BEGIN, asOfDate);
	}

	private ClaimLine buildTestClaimLine() {
		ClaimLine claimLine = new ClaimLine();
		claimLine.setReservationInterval(new DateInterval(RESERVATION_BEGIN, null));
		return claimLine;
	}
	
	@Test
	public void testGetNullAsOfDateFromClaimLine() {
		ClaimLine claimLine = new ClaimLine();
		DateMidnight asOfDate = EffectiveDateHelper.getAsOfDateFromClaimLine(claimLine);
		assertEquals(new DateMidnight(), asOfDate);
	}

}
