package com.vsp.claim.visionservicerequestapi.shared.logging;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateMidnight;
import org.junit.Before;
import org.junit.Test;

import com.vsp.il.util.Preferences;

public class LogUtilTest{
	
	@Before
	public void setUp() throws Exception {
		if(!Preferences.initialized()){
			Preferences.initialize();
		}
	}
	
	@Test
	public void testgetDateAsString() {
		DateMidnight date = new DateMidnight(2000,1,1);
		String dateString = LogUtil.getDateAsString(date);
		assertEquals(dateString,"2000-01-01");
	}
	
	@Test
	public void testgetDateAsStringNull() {
		String dateString = LogUtil.getDateAsString(null);
		assertEquals(dateString,null);
	}
}
