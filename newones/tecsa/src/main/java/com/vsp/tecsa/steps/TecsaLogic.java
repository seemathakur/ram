package com.vsp.tecsa.steps;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.LocalFileDetector;

import com.vsp.il.test.jbehave.core.state.StoryStateSingleton;
import com.vsp.il.test.jbehave.gui.actions.GuiActions;
import com.vsp.il.test.jbehave.gui.exceptions.JBehaveException;

import difflib.*;

public class TecsaLogic {
	
	private GuiActions guiActions;
	private static final String INC_MONTH = "month";
	private static final String INC_YEAR = "year";
	public static final String SAVE_ATTR_KEY = "savedData";
	
	public TecsaLogic(GuiActions guiActions) {
		this.guiActions = guiActions;
	}

	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// WHEN STEPS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
    // #############################################################
    // WORK WITH LISTBOXES #########################################
	
	public void guiActionsTargetClick(String state) {
		guiActions.threadSleep(500);
		char c = state.charAt(0);
		String s = Character.toString(c);
		guiActions.targetClick("xpath", "//*[@class='rowElem']/*[@class='jqTransformSelectWrapper']/*/a[@class='jqTransformSelectOpen']");
		guiActions.threadSleep(500);
		guiActions.xSendKeys(s);
		String locatorValue = "//ul[@class='state']/li[*]/*[contains(text(),'" + state + "')]";
		guiActions.targetClick("xpath", locatorValue);
	}
	
    public void guiActionsJqueryTargetClick (String locatorType, String locatorValue, String value, String ulClassName) {
        guiActions.threadSleep(500);
        char c = value.charAt(0);
        String s = Character.toString(c);
        guiActions.targetClick(locatorType, locatorValue);
        guiActions.threadSleep(500);
        guiActions.xSendKeys(s);
        String ulLocatorValue = "//ul[@class= '" + ulClassName + "']/li[*]/*[contains(text(),'" + value + "')]";
        guiActions.targetClick("xpath", ulLocatorValue);
  }

    public void guiActionsJqueryAliasClick (String alias, String value, String ulClassName) {
        guiActions.threadSleep(500);
        char c = value.charAt(0);
        String s = Character.toString(c);
        guiActions.aliasClick(alias);
        guiActions.threadSleep(500);
        guiActions.xSendKeys(s);
        String ulLocatorValue = "//ul[@class= '" + ulClassName + "']/li[*]/*[contains(text(),'" + value + "')]";
        guiActions.targetClick("xpath", ulLocatorValue);
  }
    
    // #############################################################
    // WORK WITH LINK INSIDE LISTBOXES #############################
    
    public void guiActionsJqueryTargetLinkClick (String locatorType, String locatorValue, String value) {
    	guiActions.threadSleep(500);
    	guiActions.targetClick(locatorType, locatorValue);
    	guiActions.threadSleep(500);
    	guiActions.targetClick("PARTIALLINKTEXT", value);
    }

    public void guiActionsJqueryAliasLinkClick (String alias, String value) {
        guiActions.threadSleep(500);
        guiActions.aliasClick(alias);
        guiActions.threadSleep(500);
        guiActions.targetClick("PARTIALLINKTEXT", value);
    } 
    
    public void guiActionsMoveToELementTargetLinkSelect (String locatorType, String locatorValue, String value) {
    	guiActions.threadSleep(500);
    	guiActions.targetMoveToElement(locatorType, locatorValue);
        guiActions.threadSleep(200);
        guiActions.targetMoveToElement("LINKTEXT", value);      
        guiActions.threadSleep(700);
        guiActions.xDoubleClick();
    }

    public void guiActionsMoveToELementAliasLinkSelect (String alias, String value) {
        guiActions.threadSleep(500);
        guiActions.aliasMoveToElement(alias);
        guiActions.threadSleep(200);
        guiActions.targetMoveToElement("LINKTEXT", value);      
        guiActions.threadSleep(700);
        guiActions.xDoubleClick();
    } 
    
    // #############################################################
    // SELECT/TYPE CURRENT DATE ####################################
    
    // ##################### STRING METHODS ########################
    
    public String getMonthName(int number) {
        String months[] = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"};
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, number);
  		String value = months[cal.get(Calendar.MONTH)];    	
  			return value;    	
    }
    
    public String getMonthNumber(int number) {
        String monthNumber[] = {
                "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12"};
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, number);
  		String value = monthNumber[cal.get(Calendar.MONTH)];    	
  			return value;    	
    }
    
    public Map<String, String> getNewMonthYear(int number) {
        String monthNumber[] = {
                "01", "02", "03", "04",
                "05", "06", "07", "08",
                "09", "10", "11", "12"};
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, number);
        Map<String, String> dateMap = new HashMap<String, String>();      
  		String newMonth = monthNumber[cal.get(Calendar.MONTH)];
  		dateMap.put(INC_MONTH, newMonth);
  		String newYear = String.valueOf(cal.get(Calendar.YEAR));
  		dateMap.put(INC_YEAR, newYear);
  		return dateMap;  
    }
    
    public String getYear(int number) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, number);
  		String value = String.valueOf(cal.get(Calendar.YEAR));
		return value;
    }
    
    public String getDay(int number) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, number);
        int DayOfMonth = cal.get(Calendar.DAY_OF_MONTH);   
  			if (DayOfMonth < 10 ) {
  				String value = String.format("%02d", DayOfMonth);
  					return value;
		}
  			else {
  				String value = String.valueOf(DayOfMonth);
  					return value;  
		}
    }
    
    // #################### TEST STEP LOGIC #######################
    
    public void guiActionsTargetGetMonth(int number, String locatorType, String locatorValue) {
		guiActions.threadSleep(500);
  		String value = getMonthName(number);
  		guiActions.targetSelectByVisibleText(locatorType, locatorValue, value); 
    } 
    
    public void guiActionsAliasGetMonth(int number, String alias) {
		guiActions.threadSleep(500);
  		String value = getMonthName(number);
  		guiActions.aliasSelectByVisibleText(alias, value); 
    }
    
    public void guiActionsJqueryTargetMonthSelect(String locatorType, String locatorValue, int number, String ulClassName) {
        guiActions.threadSleep(500);
        String value = getMonthName(number);
        char c = value.charAt(0);
        String s = Character.toString(c);
        guiActions.targetClick(locatorType, locatorValue);
        guiActions.threadSleep(500);
        guiActions.xSendKeys(s);
        String ulLocatorValue = "//ul[@class= '" + ulClassName + "']/li[*]/*[contains(text(),'" + value + "')]";
        guiActions.targetClick("xpath", ulLocatorValue);
  }

    public void guiActionsJqueryAliasMonthSelect(String alias, int number, String ulClassName) {
        guiActions.threadSleep(500);
        String value = getMonthName(number);
        char c = value.charAt(0);
        String s = Character.toString(c);
        guiActions.aliasClick(alias);
        guiActions.threadSleep(500);
        guiActions.xSendKeys(s);
        String ulLocatorValue = "//ul[@class= '" + ulClassName + "']/li[*]/*[contains(text(),'" + value + "')]";
        guiActions.targetClick("xpath", ulLocatorValue);
  }
    
    public void guiActionsTargetGetDay(int number, String locatorType, String locatorValue) {
		guiActions.threadSleep(500);
  		String value = getDay(number);
  		guiActions.targetSelectByVisibleText(locatorType, locatorValue, value); 
    } 
    
    public void guiActionsAliasGetDay(int number, String alias) {
		guiActions.threadSleep(500);
  		String value = getDay(number);
  		guiActions.aliasSelectByVisibleText(alias, value); 
    }
    
    public void guiActionsJqueryTargetYearSelect(String locatorType, String locatorValue, int number, String ulClassName) {
        guiActions.threadSleep(500);
        String value = getYear(number);
        char c = value.charAt(0);
        String s = Character.toString(c);
        guiActions.targetClick(locatorType, locatorValue);
        guiActions.threadSleep(500);
        guiActions.xSendKeys(s);
        String ulLocatorValue = "//ul[@class= '" + ulClassName + "']/li[*]/*[contains(text(),'" + value + "')]";
        guiActions.targetClick("xpath", ulLocatorValue);
  }

    public void guiActionsJqueryAliasYearSelect(String alias, int number, String ulClassName) {
        guiActions.threadSleep(500);
        String value = getYear(number);
        char c = value.charAt(0);
        String s = Character.toString(c);
        guiActions.aliasClick(alias);
        guiActions.threadSleep(500);
        guiActions.xSendKeys(s);
        String ulLocatorValue = "//ul[@class= '" + ulClassName + "']/li[*]/*[contains(text(),'" + value + "')]";
        guiActions.targetClick("xpath", ulLocatorValue);
  }

	public void guiActionsAliasTypeYear(int number, String alias) {
		guiActions.threadSleep(500);
  		String value = getYear(number);
  		guiActions.aliasSendKeys(alias, value);
	}

	public void guiActionsTargetTypeYear(int number, String locatorType, String locatorValue) {
		guiActions.threadSleep(500);
  		String value = getYear(number);
  		guiActions.targetSendKeys(locatorType, locatorValue, value);
	} 
	
	public void guiActionsTypeMonthAndFillYear(int number) {
		guiActions.threadSleep(500);
		Map<String, String> dateMap = getNewMonthYear(number);
  		guiActions.targetSendKeys("ID", "in2", dateMap.get(INC_MONTH));
  		guiActions.targetSendKeys("ID", "in3", dateMap.get(INC_YEAR));
	}
	
	public void guiActionsTargetTypeMonthDayYear(int months, int days, int years, String locatorType, String locatorValue) {
		String monthNumber = getMonthNumber(months);
		String dayNumber = getDay(days);
		String yearNumber = getYear(years);
		guiActions.targetSendKeys(locatorType, locatorValue, monthNumber + "/" + dayNumber + "/" + yearNumber);		
	}

	public void guiActionsAliasTypeMonthDayYear(int months, int days, int years, String alias) {
		String monthNumber = getMonthNumber(months);
		String dayNumber = getDay(days);
		String yearNumber = getYear(years);	
		guiActions.aliasSendKeys(alias, monthNumber + "/" + dayNumber + "/" + yearNumber);		
	}
	
	public void guiActionslogInToMemberUsingUserIDAndPassword(String userId, String password) {
		guiActions.threadSleep(500);
		guiActions.targetClick("ID", "login_link");
		guiActions.targetSendKeys("ID", "userid", userId);
		guiActions.targetSendKeys("ID", "password", password);
		guiActions.targetClick("ID", "login_0");
		guiActions.threadSleep(2000);
	} 
	
    // #############################################################
    // WORK WITH LOGONS ############################################
	
	public void guiActionsProtectWithKey(String key, String text) {	
		guiActions.encodeText(key, text);		
	}
		
	public void guiActionslogInToClientPortal() {	
		guiActions.threadSleep(500);
	  	guiActions.targetSendKeys("ID", "userid", "cbinternal");
	  	guiActions.targetEncodedText("ID", "password","$Testing8456978", "BE5074BA74952599177F6005D5E432F0");
	  	guiActions.targetClick("ID", "login_0");
	  	guiActions.threadSleep(2000);		
	}
	
    // #############################################################
    // WORK CALENDAR POP UP ########################################
	
	public void guiActionsDateClick(int months, String days) {

		guiActions.targetClick("ClassName", "ui-datepicker-trigger");
		guiActions.targetClick("CSSSELECTOR","span.ui-icon.ui-icon-circle-triangle-w");
		String currentYear = getYear(0);
		String currentMonth = getMonthShortName();
		guiActions.targetSelectByVisibleText("ClassName", "ui-datepicker-year", currentYear);
		guiActions.targetSelectByVisibleText("ClassName", "ui-datepicker-month", currentMonth);
		int x = 0;
		while (x < months) {
			guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
			x++;
		}

		int day = Integer.parseInt("-".concat(days));

		Calendar cal = new GregorianCalendar();
		cal.getTime();
		cal.roll(Calendar.MONTH, months);
		cal.roll(Calendar.DAY_OF_MONTH, day);

		int newDay = cal.get(Calendar.DAY_OF_MONTH);

		Date newDate = cal.getTime();
		SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
		String assertedDate = date_format.format(newDate);
		String linkedDate = Integer.toString(newDay);
		System.out.println(assertedDate);

		guiActions.targetClick("LinkText", linkedDate);
		guiActions.targetGetAttributeContentEquals("ID", "asOfDate", "value", assertedDate, true);
	}

	public String getMonthShortName() {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
				"Aug", "Sep", "Oct", "Nov", "Dec" };
		Calendar cal = Calendar.getInstance();
		String value = months[cal.get(Calendar.MONTH)];
		return value;
	}

	public void guiActionsDecreaseDateAndAssertNotClickable(int months) {

		guiActions.targetClick("ClassName", "ui-datepicker-trigger");
		guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
		String currentYear = getYear(0);
		String currentMonth = getMonthShortName();
		guiActions.targetSelectByVisibleText("ClassName", "ui-datepicker-year", currentYear);
		guiActions.targetSelectByVisibleText("ClassName", "ui-datepicker-month", currentMonth);
		int x = 0;
		while (x < months) {
			guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
			x++;
		}
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		String currentDayMinusOne = String.valueOf(cal
				.get(Calendar.DAY_OF_MONTH));
		if (currentDayMinusOne.equals("30")) {
			guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
			guiActions.targetClick("ClassName", "ui-datepicker-trigger");
		} else {
			guiActions.setImplicitlyWait(1);
			guiActions.targetWaitFalse("LinkText", currentDayMinusOne);
			guiActions.setImplicitlyWait(40);
			guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
			guiActions.targetClick("ClassName", "ui-datepicker-trigger");
		}
	}

	public void guiActionsIncreaseDateAndAssertNotClickable() {

		guiActions.targetClick("ClassName", "ui-datepicker-trigger");
		guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
		String currentYear = getYear(0);
		String currentMonth = getMonthShortName();
		guiActions.targetSelectByVisibleText("ClassName", "ui-datepicker-year", currentYear);
		guiActions.targetSelectByVisibleText("ClassName", "ui-datepicker-month", currentMonth);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 1);
		String currentDayPlusOne = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		if (currentDayPlusOne.equals("1")) {
			guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
			guiActions.targetClick("ClassName", "ui-datepicker-trigger");
		} else {
			guiActions.setImplicitlyWait(1);
			guiActions.targetWaitFalse("LinkText", currentDayPlusOne);
			guiActions.setImplicitlyWait(40);
			guiActions.targetClick("CSSSELECTOR", "span.ui-icon.ui-icon-circle-triangle-w");
			guiActions.targetClick("ClassName", "ui-datepicker-trigger");
		}
	}
	
    // #############################################################
    // WORK WITH DEPENDENT TABLE ###################################
	
	public void guiActionsSelectTypeClearFromDependentsTableRowColumn(String action, String value, int row, int column) {

		try {

			String newColumn = String.valueOf(column);
			String xPathRowColumnSelect = "html/body/div[1]/div[3]/div[1]/div/div[4]/div[2]/form/table[1]/tbody/tr["+ row + "]/td[" + column + "]/select";
			String xPathRowColumnSevenInput = "html/body/div[1]/div[3]/div[1]/div/div[4]/div[2]/form/table[1]/tbody/tr["+ row + "]/td[" + column + "]/input[1]";
			String xpathOtherRowsColumnsInput = "html/body/div[1]/div[3]/div[1]/div/div[4]/div[2]/form/table[1]/tbody/tr["+ row + "]/td[" + column + "]/input";

			if (newColumn.equals("7")) {
				if (action.equalsIgnoreCase("type")) {
					guiActions.targetSendKeys("XPATH", xPathRowColumnSevenInput, value);
				} else if (action.equalsIgnoreCase("clear")) {
					guiActions.targetClear("XPATH", xPathRowColumnSevenInput);
				}
			} else if (action.equalsIgnoreCase("select")) {
				guiActions.targetSelectByVisibleText("XPATH", xPathRowColumnSelect, value);
			} else if (action.equalsIgnoreCase("type")) {
				guiActions.targetSendKeys("XPATH", xpathOtherRowsColumnsInput, value);
			} else if (action.equalsIgnoreCase("clear")) {
				guiActions.targetClear("XPATH", xpathOtherRowsColumnsInput);
			}
		} catch (Exception e) {
			throw new JBehaveException(e);
		}
	}
	
    // #############################################################
    // TYPE SAVED KEY VALUE IN FIELD ###############################

	public void guiActionsAliasTypeMySavedValue(String key, String alias) {
		String text = getStorySingletonByKey(key);
		String newText = text.replaceAll("\n", "");
		guiActions.aliasSendKeys(alias, newText);
	}

	public void guiActionsTargetTypeMySavedValue(String key, String locatorType, String locatorValue) {
		String text = getStorySingletonByKey(key);
		String newText = text.replaceAll("\n", "");
		guiActions.targetSendKeys(locatorType, locatorValue, newText);	
	}
	
    // #############################################################
    // NAVIGATE TO THE VSP PATIENT REPORT ##########################
	
    public void iNavigateToTheVspPatientReport(String reportUrl, String server, String authNumber, String memberId, String frame) {
    	String url = getReportUrl(reportUrl);
    	url = url.replace("{{server}}", server);
    	url = url.replace("{{authNumber}}", authNumber);
    	url = url.replace("{{memberId}}", memberId);
    	guiActions.navigateTo(url);
    	guiActions.threadSleep(2000);
    	
    	try {
    		guiActions.switchToAlert();
    		guiActions.alert("ok");
    		guiActions.switchToFrame(frame);
    	}catch (NoAlertPresentException No) {   		   		
        	guiActions.switchToFrame(frame); 
    	}
    	
		String savedKey = server + "--" + authNumber;		
    	guiActions.targetSetSaveAttributeContent("innerHTML", "TagName", "html", savedKey);
    	
    	try {
			guiActions.afterScenarioFailure();
		} catch (IOException e) {
			e.printStackTrace();
			fail("Screen Shot Was Not Taken!!");
		}		
    }
    
    private String getReportUrl(String reportUrl) {
    	
    	if (reportUrl.equalsIgnoreCase("patientRecord")) {
    		String patientRecordReport = "https://doctor-{{server}}.vsp.com/reports/html/reports.jsp?msgProcessor=1&authNum={{authNumber}}&phone=9498314144&origSys=C&memberid={{memberId}}&Opas=CA&patRecOnly=true&rep=rep&msgProc=ptrec&ns71ss=f&labIdWarning=false";
    		return patientRecordReport;
    	}else if (reportUrl.equalsIgnoreCase("lensEnhancementsCharges")) {
    		String lensEnhancementsCharges = "https://doctor-{{server}}.vsp.com/reports/html/reports.jsp?rep=rep&msgProc=patientop&rep=rep&cache=t&msgProcessor=1&authNum={{authNumber}}&phone=9498314144&origSys=C&memberid={{memberId}}&Opas=CA&patRecOnly=true&ns71ss=f&labIdWarning=false&hst=doctor-{{server}}.vsp.com";
    		return lensEnhancementsCharges;
    	}else if (reportUrl.equalsIgnoreCase("savingsStatement")) {
    		String savingsStatement = "https://doctor-{{server}}.vsp.com/reports/html/reports.jsp?rep=rep&msgProc=wvss&rep=rep&cache=t&msgProcessor=1&authNum={{authNumber}}&phone=9498314144&origSys=C&memberid={{memberId}}&Opas=CA&patRecOnly=true&ns71ss=f&labIdWarning=false&hst=doctor-{{server}}.vsp.com";
    		return savingsStatement;
    	}else if (reportUrl.equalsIgnoreCase("service")) {
    		String service = "https://doctor-{{server}}.vsp.com/reports/html/reports.jsp?rep=rep&msgProc=drsvcrpt&rep=rep&cache=t&msgProcessor=1&authNum={{authNumber}}&phone=9498314144&origSys=C&memberid={{memberId}}&Opas=CA&patRecOnly=true&ns71ss=f&labIdWarning=false&hst=doctor-{{server}}.vsp.com";
    		return service;
    	}    	
		return reportUrl;
    }
    
	public void guiActionsSaveThePageSourceOfTheReport(String reportName, String server, String authNumber) {
    	
		String savedKey = reportName + "--" + server + "--" + authNumber;
    	guiActions.targetSetSaveAttributeContent("innerHTML", "TagName", "html", savedKey);
    	
    	try {
			guiActions.afterScenarioFailure();
		} catch (IOException e) {
			e.printStackTrace();
			fail("Screen Shot Was Not Taken!!");
		}
	}
	
	public void guiActionsWaitForCmsToBePresent() {
    	long endTime = System.currentTimeMillis() + (200 * 1000);
		while (System.currentTimeMillis() < endTime) {
			try {
				guiActions.switchToDefaultContent();
				guiActions.switchToFrame("guiPage");
				guiActions.targetWaitTrue("Name", "enteredDateOfService");
				guiActions.threadSleep(1000);
				guiActions.switchToDefaultContent();
				return;
			} catch (WebDriverException e) {
				// continue while Loop
			}
		}
		throw new JBehaveException("CMS Form is Not Present" );
	}
	
	public void guiActionsWaitForAuthorizationFieldToBePresent() {
    	long endTime = System.currentTimeMillis() + (200 * 1000);
		while (System.currentTimeMillis() < endTime) {
			try {
				guiActions.switchToDefaultContent();
				guiActions.switchToFrame("guiPage");
				guiActions.targetWaitTrue("ID", "authNum");
				guiActions.threadSleep(1000);
				guiActions.switchToDefaultContent();
				return;
			} catch (WebDriverException e) {
				// continue while Loop
			}
		}
		throw new JBehaveException("Authorization Field is Not Present" );
	}
	
	public void guiActionsWaitForPageSourceToBePresent() {
    	long endTime = System.currentTimeMillis() + (200 * 1000);
		guiActions.threadSleep(1500);
		while (System.currentTimeMillis() < endTime) {
			try {
	    		guiActions.switchToAlert();
	    		guiActions.alert("ok");
				guiActions.switchToDefaultContent();
				guiActions.switchToFrame("rptPage");
				guiActions.targetGetAttributeContentEquals("TagName", "html", "innerHTML", "$NO_TEXT", false);
				try {
					guiActions.setImplicitlyWait(1);
					guiActions.switchToDefaultContent();
					guiActions.switchToFrame("rptPage");
					guiActions.targetClick("Name", "Continue");
					guiActions.setImplicitlyWait(30);
					guiActions.switchToDefaultContent();
					guiActions.switchToFrame("rptPage");
					guiActions.targetGetAttributeContentEquals("TagName", "html", "innerHTML", "$NO_TEXT", false);
					guiActions.switchToDefaultContent();
					return;
				}catch (WebDriverException e) {
					guiActions.switchToDefaultContent();
					return;
				}
				
			} catch (NoAlertPresentException No) {
				guiActions.switchToDefaultContent();
				guiActions.switchToFrame("rptPage");
				guiActions.targetGetAttributeContentEquals("TagName", "html", "innerHTML", "$NO_TEXT", false);
				try {
					guiActions.setImplicitlyWait(1);
					guiActions.switchToDefaultContent();
					guiActions.switchToFrame("rptPage");
					guiActions.targetClick("Name", "Continue");
					guiActions.setImplicitlyWait(30);
					guiActions.switchToDefaultContent();
					guiActions.switchToFrame("rptPage");
					guiActions.targetGetAttributeContentEquals("TagName", "html", "innerHTML", "$NO_TEXT", false);
					guiActions.switchToDefaultContent();
					return;
				}catch (WebDriverException e) {
					guiActions.setImplicitlyWait(30);
					guiActions.switchToDefaultContent();
					return;
				}
				
	    	}catch (WebDriverException e) {
				// continue while Loop
			}
		}
		throw new JBehaveException("The Reports Page Source is Not Present" );
	}
		
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// THEN STEPS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
    // #############################################################
    // WORK WITH DEPENDENT TABLE ###################################
	
	public void guiActionsAssertTheDependentsTableRowErrorMessageEquals(int row, String value) {
		try {
			guiActions.targetGetTextContentEquals("XPATH", "html/body/div[1]/div[3]/div[1]/div/div[4]/div[2]/form/table[1]/tbody/tr[" + row + "]/td/div[7]/div", value, true);
		} catch (Exception e) {
			throw new JBehaveException(e);
		}
	}	
	
    // #############################################################
    // ASSERT TEXT IN A TABLE ROW AND COLUMN #######################
    
    public void guiActionsTargetGetTableContentContains(String locatorType, String locatorValue, int row, int column, String text, Boolean value){
  	  guiActions.targetGetTableContentContains(locatorType, locatorValue, row, column, text, value);
    }

    public void guiActionsAliasGetTableContentContains(String alias, int row, int column, String columnText, Boolean value) {
  	  guiActions.aliasGetTableContentContains(alias, row, column, columnText, value);	
    }
    
    // #############################################################
    // ASSERT TEXT IN SAVED KEY TO ELEMENT ON PAGE ##################
    
	public static String getStorySingletonByKey(String key) {
		return (String) StoryStateSingleton.INSTANCE.get(key);
	}
	
	public void clearSavedAttributeValue() {
		StoryStateSingleton.INSTANCE.clear();
	}

	public void guiActionsTargetVerifyTextContainsSavedValue(String key, String attributeType, String locatorType, String locatorValue) {
		String text = getStorySingletonByKey(key);
		guiActions.targetGetAttributeContains(locatorType, locatorValue, attributeType, text, true);	
	}
	
	public void guiActionsAliasVerifyTextContainsSavedValue(String key, String alias, String attributeType) {
		String text = getStorySingletonByKey(key);
		guiActions.aliasGetAttributeContains(alias, attributeType, text, true);	
	}
	
	public void guiActionsTargetVerifyTextEqualsSavedValue(String key, String attributeType, String locatorType, String locatorValue) {
		String text = getStorySingletonByKey(key);
		guiActions.targetGetAttributeContentEquals(locatorType, locatorValue, attributeType, text, true);	
	}
	
	public void guiActionsAliasVerifyTextEqualsSavedValue(String key, String alias, String attributeType) {
		String text = getStorySingletonByKey(key);
		guiActions.aliasGetAttributeContentEquals(alias, attributeType, text, true);	
	}
	
    // #############################################################
    // ASSERT TWO PAGE SOURCES ARE EQUAL ###########################
    
	public void guiActionsAssertThePageSourceOnAreEqual(String reportName, String authNumber, String serverOne, String serverTwo) {	
		try {		
			
			String savedKeyOne = reportName + "--" + serverOne + "--" + authNumber;
			String savedKeyTwo = reportName + "--" + serverTwo + "--" + authNumber;
			
			String pageSourceOne = getStorySingletonByKey(savedKeyOne);
			String pageSourceTwo = getStorySingletonByKey(savedKeyTwo);
			
			String fileDirectory = "target/jbehave/savedPageSources/" + reportName + "/AuthNumber--" + authNumber;
				
				File directoryFolder = new File(fileDirectory);
					try{
					    if (!directoryFolder.exists()){
					    	boolean result = false;
					    	result = directoryFolder.mkdirs();    
						     if(result){
						    	 System.out.println("Directory was created succesfully!!");
						     }  
					    }
					}catch(Exception e){  
						fail("Failed to successfully create directory!!");
					}
					
				List<String> newFileOne = splitSavedKey(pageSourceOne, savedKeyOne, fileDirectory);
				List<String> newFileTwo = splitSavedKey(pageSourceTwo, savedKeyTwo, fileDirectory);
				
				Patch patch = DiffUtils.diff(newFileOne, newFileTwo);
					
					File pageSourceFile = new File(fileDirectory + "/Diff_" + savedKeyOne + "_VS_" + savedKeyTwo + ".html");
					List<String> diffList = new ArrayList<String>();
					try {
						
						PrintWriter printwriter = new PrintWriter(pageSourceFile);
						
							for (Delta delta: patch.getDeltas()){
								String sourceOne = savedKeyOne + " PAGE SOURCE REPORT: " + delta.getOriginal();
								String sourceTwo = savedKeyTwo + " PAGE SOURCE REPORT: " + delta.getRevised();
								printwriter.println("---------------------------------------------------------------------------------------------------");
								printwriter.println("</br>");
								printwriter.println(sourceOne.trim());
								printwriter.println("</br>");
								printwriter.println(sourceTwo.trim());
								printwriter.println("</br>");
								System.out.println(sourceOne.trim());
								System.out.println(sourceTwo.trim());
								System.out.println();
								diffList.add(sourceOne.trim());
								diffList.add(sourceTwo.trim());
							}
						printwriter.close();
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						fail("File Not Found Exception. Please check to see that file Exists!!");
					}
					
					if (diffList.isEmpty()) {
						try {
							PrintWriter fileWriter = new PrintWriter(pageSourceFile);
							System.out.println("##################################################################################");
							System.out.println();
							System.out.println("THESE PAGE SOURCES ARE EQUAL!!!!!!");
							System.out.println();
							System.out.println("##################################################################################");
							System.out.println();
							fileWriter.println("##################################################################################");
							fileWriter.println("</br>");
							fileWriter.println();
							fileWriter.println("</br>");
							fileWriter.println("THESE PAGE SOURCES ARE EQUAL!!!!!!");
							fileWriter.println("</br>");
							fileWriter.println();
							fileWriter.println("</br>");
							fileWriter.println("##################################################################################");
							fileWriter.println("</br>");
							fileWriter.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
							fail("File Not Found Exception. Please check to see that file Exists!!");
						}
					} else {
						fail("THE TWO PAGE SOURCES DO NOT MATCH!!! Please check the file at:  " + pageSourceFile + "  to see the differences!!!");
					}
		}catch (NullPointerException n) {
			n.printStackTrace();
			fail("NullPointerException!! Check to see if you have two Page Sources to compare!");
    	}
	}
	
	private List<String> splitSavedKey(String pageSource, String savedKey, String fileDirectory) {

		File directoryFolder = new File(fileDirectory);
		try {
			if (!directoryFolder.exists()) {
				boolean result = false;
				result = directoryFolder.mkdirs();
				if (result) {
					System.out.println("Directory was created succesfully!!");
				}
			}
		} catch (Exception e) {
			fail("Failed to successfully create directory!!");
		}

		String fileLocation = fileDirectory + "/" + savedKey + "_NO_JavaScript.html";

		File pageSourceFile = new File(fileLocation);
		List<String> stripedFile = new ArrayList<String>();

		try {
			PrintWriter printwriter = new PrintWriter(pageSourceFile);
			String[] tempString;
			tempString = pageSource.split("\\n");
			for (int i = 0; i < tempString.length; i++) {
				String trimedArray = tempString[i].trim();
				if (trimedArray.equals("")) {
					continue;
				} else if (trimedArray.contains("<script")) {
					continue;
				} else if (trimedArray.contains("</script")) {
					continue;
				} else if (!trimedArray.contains("<")) {
					continue;
				} else if (trimedArray.contains("document.write")) {
					continue;
				}
				System.out.println(trimedArray);
				stripedFile.add(trimedArray);
				printwriter.println(trimedArray);

			}
			printwriter.close();
			System.out.println();
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("File Not Found Exception. Please check to see that file Exists!!");
		}
		return stripedFile;
	}
	
    // #############################################################
    // WORK WITH UPLOADING FILES ###################################
	
	private String getUploadFilePath(String filepath, String location) {
		File file = null;
		try {
			if (location.equalsIgnoreCase("project")) {
			    file = new File(getClass().getClassLoader().getResource(filepath).toURI());
			    guiActions.threadSleep(1500);
			}else {
				file = new File(filepath);				
			}
			
			Assert.assertTrue(file.exists());  
			
		}catch (URISyntaxException e) {
		    e.printStackTrace();
			fail("An Unexpected URISyntaxException was thrown! Please check to see if the path -->  " + filepath + "  <-- is valid path!!");
		}catch (NullPointerException npe) {
			npe.printStackTrace();
			fail("An Unexpected NullPointerException was thrown! Please check to see if the path -->  " + filepath + "  <-- is valid path!!");
		}catch(AssertionError a) {
		    a.printStackTrace();
			fail("File Not Found!! Please check to see that file Exists!! If the file is located inside your project make sure the location is set to: ''project'' , It is currently set to -->  " + location );
		}
		
		LocalFileDetector filedetector = new LocalFileDetector();
		File finalFile = filedetector.getLocalFile(file.getAbsolutePath());
	    System.out.println(finalFile);
		
		return finalFile.getAbsolutePath();
	}
	
	private void robotUploadFile(String uploadFile) {
		StringSelection stringSelection = new StringSelection(uploadFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		guiActions.threadSleep(2000);
		try {
			Robot robot = new Robot();			
			robot.keyPress(KeyEvent.VK_ENTER);
			guiActions.threadSleep(200);
			robot.keyRelease(KeyEvent.VK_ENTER);
			guiActions.threadSleep(800);			
			robot.keyPress(KeyEvent.VK_CONTROL);
			guiActions.threadSleep(200);
			robot.keyPress(KeyEvent.VK_V);
			guiActions.threadSleep(200);
			robot.keyRelease(KeyEvent.VK_V);
			guiActions.threadSleep(200);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			guiActions.threadSleep(1500);			
			robot.keyPress(KeyEvent.VK_ENTER);
			guiActions.threadSleep(200);
			robot.keyRelease(KeyEvent.VK_ENTER);			
		} catch (AWTException e) {
			e.printStackTrace();
			throw new JBehaveException(e);
		}
		guiActions.threadSleep(1000);
	}

	public void guiActionsUploadAFileInThe(String filepath, String location, String alias) {
//		String uploadFile = getUploadFilePath(filepath, project);		
//		guiActions.aliasWebElementSendKeys(alias, uploadFile);		
		guiActions.aliasClick(alias);
		robotUploadFile(getUploadFilePath(filepath, location));
	}	
	
	public void guiActionsUploadAFileInTarget(String filepath, String location, String locatorType, String locatorValue) {
//		String uploadFile = getUploadFilePath(filepath, project);
//		guiActions.targetWebElementSendKeys(locatorType, locatorValue, uploadFile);
		guiActions.targetClick(locatorType, locatorValue);
		robotUploadFile(getUploadFilePath(filepath, location));
	}
}