package com.vsp.claim.visionservicerequest.test.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateMidnight;

public class DateParse {	
	
	public static DateMidnight parse(String token) throws Exception {
		if(token.contains("-")) 
			return parseYyyyMmDd(token);
		else 
			return parseDateByToken(token);
	}
	
	private static DateMidnight parseDateByToken(String token) throws Exception {		
		String[] tokens = splitTokensOnMathOperators(token);
		DateMidnight toReturn = handleDateToken(tokens[0]);
		
		if(tokens.length == 3 && isNumeric(tokens[2]))
		{
			toReturn = performArithmeticOnDate(toReturn, Arrays.copyOfRange(tokens, 1, 3));
		}
		
		return toReturn;
	}

	private static String[] splitTokensOnMathOperators(String token) {
		List<String> tokens = new ArrayList<String>(Arrays.asList(token.split("\\+")));
		if(tokens.size() < 2) {
			tokens = new ArrayList<String>(Arrays.asList(token.toLowerCase().split("_minus_")));
			if(tokens.size() > 1) {
				tokens.add(1, "-");
			}
		} else {
			tokens.add(1, "+");
		}
		return tokens.toArray(new String[0]);
	}

	private static DateMidnight handleDateToken(String token) throws Exception {
		DateMidnight toReturn = initializeTodaysDate();
		switch(token.toLowerCase())
		{
			case "current_date":
				// Handled by initialization
				break;
			case "first_of_the_month":
				toReturn = getFirstOfMonth(toReturn);
				break;
			case "first_of_the_following_month":
				toReturn = getNextFirstOfMonth(toReturn);
				break;	
			case "end_of_current_month":
				toReturn = getEndOfMonth();
				break;
			case "next_frequency_period":
				toReturn = getNextFrequencyPeriod();
				break;
			default: 
				Exception e = new Exception("Unidentified date token: " + token); 
				throw e;
		}
		return toReturn;
	}
	
	private static DateMidnight getFirstOfMonth(DateMidnight toReturn) {
		return new DateMidnight().withDayOfMonth(1);
	}

	private static DateMidnight getNextFrequencyPeriod() {
		return new DateMidnight().withMonthOfYear(1).plusYears(1);
	}

	private static DateMidnight getEndOfMonth() {
		DateMidnight firstDay = new DateMidnight().withDayOfMonth(1);
		return firstDay.plusMonths(1).minusDays(1);  
	}

	private static DateMidnight initializeTodaysDate() {
		return new DateMidnight();
	}

	private static DateMidnight getNextFirstOfMonth(DateMidnight toReturn) {
		toReturn = toReturn.plusMonths(1);
		toReturn = toReturn.withDayOfMonth(1);
		return toReturn;
	}

	private static DateMidnight performArithmeticOnDate(DateMidnight toReturn,
			String[] operationArray) {
		if(operationArray[0].equals("+")) {
			toReturn = addDays(toReturn, operationArray[1]);
		} else if(operationArray[0].equals("-")) {
			toReturn = subtractDays(toReturn, operationArray[1]);
		}
		return toReturn;
	}

	private static DateMidnight addDays(DateMidnight startDate, String days) {
		int daysToAdd = Integer.parseInt(days);
		startDate = startDate.plusDays(daysToAdd);
		return startDate;
	}

	private static DateMidnight subtractDays(DateMidnight startDate, String days) {
		int daysToSubtract = Integer.parseInt(days);
		startDate = startDate.minusDays(daysToSubtract);
		return startDate;
	}

	private static DateMidnight parseYyyyMmDd(String token) throws NumberFormatException, Exception
	{
		Calendar cal = Calendar.getInstance();;
		Date d = new Date();
		cal.setTime(d);
		
		String[] tokens = null;
		String[] temp = null;
		
		tokens = token.split("-");
		
		if(tokens.length != 3)
		{
			Exception e = new Exception("Unidentified date token: " + token); throw e;
		}
		
		//Case 02-02-02+3
		if(tokens[2].contains("+"))
		{
			temp = tokens[2].split("\\+");
			tokens[2] = temp[0];
		}
		
		//Case 02-02-02+30 Checking format
		if(temp != null && temp.length > 2)
		{
			Exception e = new Exception("Unidentified date token: " + token); 
			throw e;
		}
		
		if(tokens[0].length() != 4 || tokens[1].length() > 2 || tokens[2].length() > 2)	{
			Exception e = new Exception("Unidentified date token: " + token); 
			throw e;
		}else if(!isNumeric(tokens[0])) {
			Exception e = new Exception("Unidentified date token: " + tokens[0]); 
			throw e;
		}else if(!isNumeric(tokens[1]))	{
			Exception e = new Exception("Unidentified date token: " + tokens[1]); 
			throw e;
		}else if(!isNumeric(tokens[2]))	{
			Exception e = new Exception("Unidentified date token: " + tokens[2]); 
			throw e;
		}
		
		cal.set(Calendar.YEAR, Integer.parseInt(tokens[0]));
		cal.set(Calendar.MONTH, Integer.parseInt(tokens[1]) - 1);
		cal.set(Calendar.DATE, Integer.parseInt(tokens[2]));
		
		//Case 02-02-02+30  (Adding the 30)
		if(temp != null && isNumeric(temp[1])) {
			cal.add(Calendar.DATE, Integer.parseInt(temp[1]));
		}
		
		return new DateMidnight(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,cal.get(Calendar.DATE));
		
	}
	
	private static boolean isNumeric(String str)  throws Exception
	{  
	  try  
	  {  
	     Integer.parseInt(str);
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    throw nfe;
	  }  
	  return true;  
	}

}
