package com.vsp.claim.visionservicerequest.test.util;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.vsp.claim.visionservicerequest.test.steps.ReservedClaimThenSteps;
import com.vsp.claim.visionservicerequest.test.util.DateParse;
import com.vsp.il.util.Preferences;

public class DateParse_Test {

	@Autowired
	private ReservedClaimThenSteps adapter;
	
	@Before
	public void before() {
		setUpPreferences();
	}
	
	@Test (expected = Exception.class)
	public void NumberTokenerAssertions_0_Fail() throws Exception {
		DateParse.parse("1111-20");
	}
	
	@Test (expected = Exception.class)
	public void NumberTokenerAssertions_1_Fail() throws Exception {
		DateParse.parse("111-02-20");
	}
	
	@Test (expected = Exception.class)
	public void NumberTokenerAssertions_2_Fail() throws Exception {
		DateParse.parse("11a-02-20");
	}
	
	@Test (expected = Exception.class)
	public void NumberTokenerAssertions_3_Fail() throws Exception {
		DateParse.parse("111-02-20");
	}
	
	@Test (expected = Exception.class)
	public void NumberTokenerAssertions_4_Fail() throws Exception {
		DateParse.parse("111-02-c3");
	}
	
	@Test
	public void testMinusDateToken() throws Exception {
		DateMidnight actualResult = DateParse.parse("CURRENT_DATE_MINUS_30");
		DateMidnight expectedResult = buildExpectedMinus30DaysResult();
		assertEquals("DateParse_Test::testMinusDateToken:: Expected two dates to match.",
				expectedResult, actualResult);
	}
	
	private DateMidnight buildExpectedMinus30DaysResult() {
		return new DateMidnight().minusDays(30);
	}

	@Test
	public void NumberTokenerAssertions_0_Pass() throws Exception {
		
		if(!new DateMidnight(1111,02,20).toString("yyyy-MM-dd").equals(DateParse.parse("1111-02-20")
				.toString("yyyy-MM-dd")))
		{

			Exception e = new Exception("CURRENT_DATE invalid");
			throw e;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 30);
		DateMidnight mn = new DateMidnight(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1, 
				cal.get(Calendar.DATE));
		
		if(!DateParse.parse("CURRENT_DATE+30").toString("yyyy-MM-dd").equals( mn.toString("yyyy-MM-dd")))
		{
			System.out.println(DateParse.parse("CURRENT_DATE+30").toString("yyyy-MM-dd"));
			System.out.println(mn.toString("yyyy-MM-dd"));
			Exception e = new Exception("CURRENT_DATE invalid");
			throw e;
		}		
		
		if(!DateMidnight.now().toString("yyyy-MM-dd").equals(DateParse.parse("CURRENT_DATE")
				.toString("yyyy-MM-dd")))
		{
			Exception e = new Exception("CURRENT_DATE invalid");
			throw e;
		}
		
		if(!new DateMidnight(2000,1,31).toString("yyyy-MM-dd").equals(DateParse.parse("2000-01-01+30")
				.toString("yyyy-MM-dd")))
		{
			Exception e = new Exception("CURRENT_DATE invalid");
			throw e;
		}
	}
	
	private void setUpPreferences()
	{
		if(!Preferences.initialized())
		{
			Preferences.initialize();
		}
	}
	
}
