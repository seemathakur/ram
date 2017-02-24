package com.vsp.tecsa.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.fail;
import com.vsp.il.test.jbehave.gui.actions.GuiActions;
import com.vsp.il.test.jbehave.gui.steps.GuiSteps;

public class TecsaSteps extends GuiSteps {
	
	private TecsaLogic tecsaLogic;
	
	public TecsaSteps(GuiActions guiActions) {
	  super(guiActions);
	  tecsaLogic = new TecsaLogic(guiActions);
  }
	
	@Given("a clientId of 123456789")
	public void failClientID() {
		fail("CLIENT ID NOT FOUND");
	}
	
	@Given("a clientId of 12319587")
	public void failClientID2() {
		fail("CLIENT ID NOT FOUND");
	}
	
	@Given("that Test Engineers are awesome")
	public void thatTestEngineersAreAwesome() {
		
	}
	
	@When("I ask them to do something")
	public void iAskThemToDoSomething() {
		
	}
	
	@Then("they do it awesome")
	public void theyDoItAwesome() {
		
	}
	
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// WHEN STEPS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
    // #############################################################
    // WORK WITH LISTBOXES #########################################
	
	/**
	 *	Custom Method to select a state value in an element from xml element repository
	 * 
	 *	@param value
	 *		specifies what state is selected by visible text
	 */
	@When(value="I select $state from the State dropdown", priority=1)
	public void iSelectFromTheStateDropdown(String state) {
		tecsaLogic.guiActionsTargetClick(state);
	}
	
	/**
	 *	Method to select element from dropdown list 
	 * 	.        
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	.
	 *	@param value
	 *		specifies what is text is typed
	 *	. 
	 *	@param ulClassName
	 *		specifies what is text is typed
	 *	. 
	 *	EXAMPLE:
	 *		When I click the TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a and select California from the jQuery Style state dropdown
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply clicks a specific locator type and locator value to interact with it.  
	 *	.
	 *		California ($value) is the value we want to select
	 *	.
	 *		state ($ulClassName) is the unified list class name. You can find this by Inspecting the Object Using FireBug
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when the Test Steps, �When I select value from TARGET locatorType = locatorValue� doesn't work. This Step essentially interacts with List dropdown Boxes.  
	 */
    @When(value="I click the TARGET $locatorType = $locatorValue and select $value from the jQuery Style $ulClassName dropdown", priority=2)
    public void iClickTargetAndSelectFromTheJqueryDropdown(String locatorType, String locatorValue, String value, String ulClassName) {
    	tecsaLogic.guiActionsJqueryTargetClick(locatorType, locatorValue, value, ulClassName);
    }

	/**
	 *	Method to select element from dropdown list 
	 * 	.        
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.
	 *	@param value
	 *		specifies what is selected
	 *	. 
	 *	@param ulClassName
	 *		specifies the unified list class name 
	 *	. 
	 *	EXAMPLE:
	 *		When I click the Doctor Network Arrow and select Choice from the jQuery Style network dropdown
	 *	.
	 *	NOTE:
	 *		Doctor Network Arrow ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *		Choice ($value) is the value we want to select
	 *	.
	 *		network ($ulClassName) is the unified list class name. You can find this by Inspecting the Object Using FireBug
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when the Test Steps, �When I select value from the alias� doesn't work. This Step essentially interacts with List dropdown Boxes.  
	 */
    @When(value="I click the $alias and select $value from the jQuery Style $ulClassName dropdown", priority=1)
    public void iClickAndSelectFromTheJqueryDropdown(String alias, String value, String ulClassName) {
    	tecsaLogic.guiActionsJqueryAliasClick(alias, value, ulClassName);
    }
    
    // #############################################################
    // WORK WITH LINK INSIDE LISTBOXES #############################
    
	/**
	 *	Method to select element from dropdown list 
	 * 	.        
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	.
	 *	@param value
	 *		specifies what is text is typed
	 *	. 
	 *	EXAMPLE:
	 *		When I click the TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a and select the link California from the jQuery Style dropdown
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply clicks a specific locator type and locator value to interact with it.  
	 *	.
	 *		California ($value) is the linked value we want to select
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when the Test Steps, �When I select value from TARGET locatorType = locatorValue� doesn't work. This Step essentially interacts with List dropdown Boxes.  
	 */
    @When(value="I click the TARGET $locatorType = $locatorValue and select the link $value from the jQuery Style dropdown", priority=2)
	public void iClickTargetAndSelectLinkFromTheJqueryDropdown(String locatorType, String locatorValue, String value) {
    	tecsaLogic.guiActionsJqueryTargetLinkClick(locatorType, locatorValue, value);
    }
    
	/**
	 *	Method to select element from dropdown list 
	 * 	.        
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.
	 *	@param value
	 *		specifies what is selected
	 *	.  
	 *	EXAMPLE:
	 *		When I click the Doctor Network Arrow and select the link Choice from the jQuery Style dropdown
	 *	.
	 *	NOTE:
	 *		Doctor Network Arrow ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *		Choice ($value) is the linked value we want to select
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when the Test Steps, �When I select value from the alias� doesn't work. This Step essentially interacts with List dropdown Boxes.  
	 */
    @When(value="I click the $alias and select the link $value from the jQuery Style dropdown", priority=1)
	public void iClickAndSelectLinkFromTheJqueryDropdown(String alias, String value) {
    	tecsaLogic.guiActionsJqueryAliasLinkClick(alias, value);
    }
	
	/**
	 *	Method to select element from hover style dropdown list 
	 * 	.        
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	.
	 *	@param value
	 *		specifies what is text is typed
	 *	. 
	 *	EXAMPLE:
	 *		When I hover over the TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a and select the link California from the Hover Style Style dropdown
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply overs over a specific locator type and locator value to interact with it.  
	 *	.
	 *		California ($value) is the linked value we want to select
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when the Test Steps, �When I select value from TARGET locatorType = locatorValue� doesn't work. This Step essentially interacts with Hover Style List dropdown Boxes.  
	 */
    @When(value="I hover over the TARGET $locatorType = $locatorValue and select the link $value from the Hover Style dropdown", priority=2)
	public void iHoverOverTargetAndSelectLinkFromHoverStyleDropdown(String locatorType, String locatorValue, String value) {
    	tecsaLogic.guiActionsMoveToELementTargetLinkSelect(locatorType, locatorValue, value);
    }
    
	/**
	 *	Method to select element from hover style dropdown list 
	 * 	.        
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.
	 *	@param value
	 *		specifies what is selected
	 *	.  
	 *	EXAMPLE:
	 *		When I hover over the Doctor Network Arrow and select the link Choice from the Hover Style dropdown
	 *	.
	 *	NOTE:
	 *		Doctor Network Arrow ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *		Choice ($value) is the linked value we want to select
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when the Test Steps, �When I select value from the alias� doesn't work. This Step essentially interacts with Hover Style List dropdown Boxes.  
	 */
    @When(value="I hover over the $alias and select the link $value from the Hover Style dropdown", priority=1)
	public void iHoverOverAndSelectLinkFromHoverStyleDropdown(String alias, String value) {
    	tecsaLogic.guiActionsMoveToELementAliasLinkSelect(alias, value);
    }
    
    // #############################################################
    // SELECT/TYPE CURRENT DATE ####################################
    
	/**
	 *	Method to select Month from a select dropdown box 
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentMonth.
	 *	.       
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	. 
	 *	EXAMPLE:
	 *		I select 0 month(s) from the CurrentMonth from TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a
	 *	.
	 *		In this example if the CurrentMonth is August then the month selected (because of the 0 ($number) is August. 
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply a specifies the integer number, LocatorType and LocatorValue of the select box where you will retrieve the date.
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of months that will be Subtracted from the CurrentMonth. 
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer -1 will select the month July.
	 *	.
	 *		Positive (exp: 1) values represent the number of months that will be Added to the CurrentMonth.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 1 will select the month September.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentMonth we are in.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 0 will select the month August.
	 */
    @When(value="I select $number month(s) from the CurrentMonth from TARGET $locatorType = $locatorValue", priority=1)
	public void iSelectMonthFromTarget(int number, String locatorType, String locatorValue) {
    	tecsaLogic.guiActionsTargetGetMonth(number, locatorType, locatorValue);
    }
    
	/**
	 *	Method to select Month from a select dropdown box 
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentMonth
	 *	.    
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.  
	 *	EXAMPLE:
	 *		I select 0 month(s) from the CurrentMonth from the the Month dropdown
	 *	.
	 *	NOTE:
	 *		0 ($number) is the value added/subtracted from the CurrentMonth. In this case 0 will represent the CurrentMonth we are in.
	 *	.
	 *		Month dropdown ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of months that will be Subtracted from the CurrentMonth. 
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer -1 will select the month July.
	 *	.
	 *		Positive (exp: 1) values represent the number of months that will be Added to the CurrentMonth.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 1 will select the month September.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentMonth we are in.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 0 will select the month August.
	 */
    @When(value="I select $number month(s) from the CurrentMonth from the $alias", priority=1)
	public void iSelectMonthFromThe(int number, String alias) {
    	tecsaLogic.guiActionsAliasGetMonth(number, alias);
    }
    
	/**
	 *	Method to select Month from a select dropdown box 
	 * 	.        
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentMonth
	 *	. 
	 *	@param ulClassName
	 *		specifies the ulClassName
	 *	. 
	 *	EXAMPLE:
	 *		When I click the TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a and select 0 month(s) from the CurrentMonth from the jQuery Style month dropdown
	 *	.
	 *		In this example if the CurrentMonth is August then the month selected (because of the 0 ($number) is August.
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply a specifies the integer number, LocatorType and LocatorValue of the select box where you will retrieve the date.  
	 *	.
	 *		0 ($number) is the number of months from the CurrentMonth
	 *	.
	 *		month ($ulClassName) is the unified list class name. You can find this by Inspecting the Object Using FireBug
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of months that will be Subtracted from the CurrentMonth. 
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer -1 will select the month July.
	 *	.
	 *		Positive (exp: 1) values represent the number of months that will be Added to the CurrentMonth.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 1 will select the month September.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentMonth we are in.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 0 will select the month August.
	 */
    @When(value="I click the TARGET $locatorType = $locatorValue and select $number month(s) from the CurrentMonth from the jQuery Style $ulClassName dropdown", priority=3)
    public void iClickTargetAndSelectMonthFromJquery(String locatorType, String locatorValue, int number, String ulClassName) {
    	tecsaLogic.guiActionsJqueryTargetMonthSelect(locatorType, locatorValue, number, ulClassName);
    }

	/**
	 *	Method to select Month from a select dropdown box 
	 * 	.        
	 *	@param alias
	 *		specifies which element to get from xml object
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentMonth
	 *	. 
	 *	@param ulClassName
	 *		specifies the unified list class name 
	 *	. 
	 *	EXAMPLE:
	 *		When I click the Month Arrow and select 0 month(s) from the CurrentMoth from the jQuery Style month dropdown
	 *	.
	 *		In this example if the CurrentMonth is August then the month selected (because of the 0 ($number) is August.
	 *	.
	 *	NOTE:
	 *		Month Arrow ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *		0 ($number) is the number of months from the CurrentMonth
	 *	.
	 *		month ($ulClassName) is the unified list class name. You can find this by Inspecting the Object Using FireBug
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of months that will be Subtracted from the CurrentMonth. 
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer -1 will select the month July.
	 *	.
	 *		Positive (exp: 1) values represent the number of months that will be Added to the CurrentMonth.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 1 will select the month September.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentMonth we are in.
	 *	.
	 *			QuickExample: If CurrentMonth is August then passing in the integer 0 will select the month August.
	 */
    @When(value="I click the $alias and select $number month(s) from the CurrentMonth from the jQuery Style $ulClassName dropdown", priority=2)
    public void iClickAndSelectMonthFromJquery(String alias, int number, String ulClassName) {
    	tecsaLogic.guiActionsJqueryAliasMonthSelect(alias, number, ulClassName);
    }
    
	/**
	 *	Method to select Day from a select dropdown box 
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentDay.
	 *	.       
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	. 
	 *	EXAMPLE:
	 *		I select 0 day(s) from the CurrentDay from TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a
	 *	.
	 *		In this example if the CurrentDay is 05 then the day selected (because of the 0 ($number) is 05. 
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply a specifies the integer number, LocatorType and LocatorValue of the select box where you will retrieve the date.
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of days that will be Subtracted from the CurrentDay. 
	 *	.
	 *			QuickExample: If CurrentDay is 05 then passing in the integer -1 will select the day 04.
	 *	.
	 *		Positive (exp: 1) values represent the number of days that will be Added to the CurrentDay.
	 *	.
	 *			QuickExample: If CurrentDay is 05 then passing in the integer 1 will select the day 06.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentDay we are in.
	 *	.
	 *			QuickExample: If CurrentDay is 05 then passing in the integer 0 will select the day 05.
	 */
    @When(value="I select $number day(s) from the CurrentDay from TARGET $locatorType = $locatorValue", priority=1)
	public void iSelectDayFromTarget(int number, String locatorType, String locatorValue) {
    	tecsaLogic.guiActionsTargetGetDay(number, locatorType, locatorValue);
    }
    
	/**
	 *	Method to select Day from a select dropdown box 
	 * 	. 
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentDay.
	 *	.       
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.  
	 *	EXAMPLE:
	 *		I select 0 day(s) from the CurrentDay from the Day dropdown
	 *	.
	 *		In this example if the CurrentDay is 05 then the day selected (because of the 0 ($number) is 05.
	 *	.
	 *	NOTE:
	 *		0 ($number) is the value added/subtracted from the CurrentDay. In this case 0 will represent the CurrentDay we are in.
	 *	.
	 *		Day dropdown ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of days that will be Subtracted from the CurrentDay. 
	 *	.
	 *			QuickExample: If CurrentDay is 05 then passing in the integer -1 will select the day 04.
	 *	.
	 *		Positive (exp: 1) values represent the number of days that will be Added to the CurrentDay.
	 *	.
	 *			QuickExample: If CurrentDay is 05 then passing in the integer 1 will select the day 06.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentDay we are in.
	 *	.
	 *			QuickExample: If CurrentDay is 05 then passing in the integer 0 will select the day 05.
	 */
    @When(value="I select $number day(s) from the CurrentDay from the $alias", priority=1)
	public void iSelectDayFromThe(int number, String alias) {
    	tecsaLogic.guiActionsAliasGetDay(number, alias);
    }
    
	/**
	 *	Method to select Year from a select dropdown box 
	 * 	.        
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentYear
	 *	. 
	 *	@param ulClassName
	 *		specifies the ulClassName
	 *	. 
	 *	EXAMPLE:
	 *		When I click the TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a and select 0 year(s) from the CurrentYear from the jQuery Style year dropdown
	 *	.
	 *		In this example if the CurrentYear is 2014 then the year selected (because of the 0 ($number) is 2014.
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply a specifies the integer number, LocatorType and LocatorValue of the select box where you will retrieve the date.  
	 *	.
	 *		0 ($number) is the number of years from the CurrentYear
	 *	.
	 *		year ($ulClassName) is the unified list class name. You can find this by Inspecting the Object Using FireBug
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of years that will be Subtracted from the CurrentYear. 
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer -1 will type the year 2013.
	 *	.
	 *		Positive (exp: 1) values represent the number of years that will be Added to the CurrentYear.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 1 will type the year 2015.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentYear we are in.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 0 will type the year 2014.
	 */
    @When(value="I click the TARGET $locatorType = $locatorValue and select $number year(s) from the CurrentYear from the jQuery Style $ulClassName dropdown", priority=3)
    public void iClickTargetAndSelectYearFromJquery(String locatorType, String locatorValue, int number, String ulClassName) {
    	tecsaLogic.guiActionsJqueryTargetYearSelect(locatorType, locatorValue, number, ulClassName);
    }

	/**
	 *	Method to select Year from a select dropdown box 
	 * 	.        
	 *	@param alias
	 *		specifies which element to get from xml object
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentYear
	 *	. 
	 *	@param ulClassName
	 *		specifies the unified list class name 
	 *	. 
	 *	EXAMPLE:
	 *		When I click the Year Arrow and select 0 month(s) from the CurrentYear from the jQuery Style year dropdown
	 *	.
	 *		In this example if the CurrentYear is 2014 then the year selected (because of the 0 ($number) is 2014
	 *	.
	 *	NOTE:
	 *		Year Arrow ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *		0 ($number) is the number of years from the CurrentYear
	 *	.
	 *		year ($ulClassName) is the unified list class name. You can find this by Inspecting the Object Using FireBug
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of years that will be Subtracted from the CurrentYear. 
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer -1 will type the year 2013.
	 *	.
	 *		Positive (exp: 1) values represent the number of years that will be Added to the CurrentYear.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 1 will type the year 2015.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentYear we are in.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 0 will type the year 2014.
	 */
    @When(value="I click the $alias and select $number years(s) from the CurrentYear from the jQuery Style $ulClassName dropdown", priority=2)
    public void iClickAndSelectYearFromJquery(String alias, int number, String ulClassName) {
    	tecsaLogic.guiActionsJqueryAliasYearSelect(alias, number, ulClassName);
    }
        
	/**
	 *	Method to Type Year in a text box 
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentYear.
	 *	.      
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	. 
	 *	EXAMPLE:
	 *		When I type 0 year(s) from the CurrentYear in TARGET XPATH = .//*[@id='doc-directory-submit']/div[1]/div[1]/div/div/a
	 *	.
	 *		In this example if the CurrentYear is 2014 then the day typed (because of the 0 ($number) is 2014.
	 *	.
	 *	NOTE:
	 *		The Above Example Test Steps is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). It simply a specifies the LocatorType and LocatorValue of the input box where you will type the date.
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of years that will be Subtracted from the CurrentYear. 
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer -1 will type the year 2013.
	 *	.
	 *		Positive (exp: 1) values represent the number of years that will be Added to the CurrentYear.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 1 will type the year 2015.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentYear we are in.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 0 will type the year 2014.
	 */
    @When(value="I type $number year(s) from the CurrentYear in TARGET $locatorType = $locatorValue", priority=1)
	public void iTypeYearInTarget(int number, String locatorType, String locatorValue) {
    	tecsaLogic.guiActionsTargetTypeYear(number, locatorType, locatorValue);
    }
    
	/**
	 *	Method to Type Year in a text box  
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the CurrentYear.
	 * 	.        
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.  
	 *	EXAMPLE:
	 *		When I type 0 year(s) from the CurrentYear in the Year field
	 *	.
	 *		In this example if the CurrentYear is 2014 then the day typed (because of the 0 ($number) is 2014.
	 *	.
	 *	NOTE:
	 *		0 ($number) is the value added/subtracted from the CurrentYear. In this case 0 will represent the CurrentYear we are in.
	 *	.
	 *		Year field ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of years that will be Subtracted from the CurrentYear. 
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer -1 will type the year 2013.
	 *	.
	 *		Positive (exp: 1) values represent the number of years that will be Added to the CurrentYear.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 1 will type the year 2015.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentYear we are in.
	 *	.
	 *			QuickExample: If CurrentYear is 2014 then passing in the integer 0 will type the year 2014.
	 */
    @When(value="I type $number year(s) from the CurrentYear in the $alias", priority=1)
	public void iTypeYearInThe(int number, String alias) {
    	tecsaLogic.guiActionsAliasTypeYear(number, alias);
    }
    
	/**
	 *	Method to Type Year in a text box  
	 * 	.
	 *	@param number
	 *		specifies the value added/subtracted from the Current Month.
	 *	.  
	 *	EXAMPLE:
	 *		When I increment the current date by 1 month in the Suppress by Client panel
	 *	.
	 *		In this example if the Current Month is 08 (August) then the Month typed in the Month field is 09 (September) and the Year typed in the Year field is 2014.
	 *	.
	 *		When I increment the current date by 7 months in the Suppress by Client panel
	 *	.
	 *		In this example if the Current Month is 08 (August) then the Month typed in the Month field is 03 (March) and the Year typed in the Year field is 2015.
	 *	.
	 *	NOTE:
	 *		0 ($number) is the value added/subtracted from the CurrentYear. In this case 0 will represent the CurrentYear we are in.
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number of months that will be Subtracted from the CurrentMonth. 
	 *	.
	 *			QuickExample: If CurrentMonth is 08 (August) then passing in the integer -1 will type the month 07 (July) and year is added accordingly.
	 *	.
	 *		Positive (exp: 1) values represent the number of months that will be Added to the CurrentMonth.
	 *	.
	 *			QuickExample: If CurrentMonth is 08 (August) then passing in the integer 1 will select the month 09 (September) and year is added accordingly.
	 *	.
	 *		Neutral ( 0 ) represents the CurrentMonth we are in.
	 *	.
	 *			QuickExample: If CurrentMonth is 08 (August) then passing in the integer 0 will select the month 08 (August) and year is added accordingly.
	 */
    @When(value="I increment the current date by $number {month|months} in the Suppress by Client panel")
	public void iTypeMonthInTargetAndFillInYearField(int number) {
    	tecsaLogic.guiActionsTypeMonthAndFillYear(number);
    }
    
	/**
	 *	Method to Type Year in a text box  
	 * 	.
	 *	@param months
	 *		specifies the months added/subtracted from the Current Month.
	 *	.  
	 *	@param days
	 *		specifies the days added/subtracted from the Current Month.
	 *	. 
	 *	@param years
	 *		specifies the years added/subtracted from the Current Month.
	 *	.
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	. 
	 *	EXAMPLE:
	 *		When I increment the current date by 0 month(s) 1 day(s) and 0 year(s) in the TARGET ID = date_box input field
	 *	.
	 *		In this example if the Current Date is 09/16/2014, then the date typed in the date_box input field will be 09/17/2014
	 *	.
	 *	NOTE:
	 *		0 ($number) is a value added/subtracted from the Current Date. In this case 0 will represent the Current Date we are in.
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number that will be Subtracted from the Current Date (month, day, year). 
	 *	.
	 *			QuickExample: If Current Date is 09/16/2014 then passing in the integer -1 for each of the values (month, day, year) will type 08/15/2013.
	 *	.
	 *		Positive (exp: 1) values represent the number that will be Added to the Current Date (month, day, year).
	 *	.
	 *			QuickExample: If Current Date is 09/16/2014 then passing in the integer 1 for each of the values (month, day, year) will type 10/17/2015.
	 *	.
	 *		Neutral ( 0 ) represents the Current Day we are in.
	 *	.
	 *			QuickExample: If Current Date is 09/16/2014 then passing in the integer 0 for each of the values (month, day, year) will type 09/16/2014 (current date).
	 */
    @When(value="I increment the current date by $months month(s) $days day(s) and $years year(s) in the TARGET $locatorType = $locatorValue input field", priority=2)
	public void iIncrementCurrentDateByMonthDayYearInTargetInputField(int months, int days, int years, String locatorType, String locatorValue) {
    	tecsaLogic.guiActionsTargetTypeMonthDayYear(months, days, years, locatorType, locatorValue);
    }
    
	/**
	 *	Method to Type Year in a text box  
	 * 	.
	 *	@param months
	 *		specifies the months added/subtracted from the Current Month.
	 *	.  
	 *	@param days
	 *		specifies the days added/subtracted from the Current Month.
	 *	. 
	 *	@param years
	 *		specifies the years added/subtracted from the Current Month.
	 *	.
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	. 
	 *	EXAMPLE:
	 *		When I increment the current date by 0 month(s) 1 day(s) and 0 year(s) in the Date Text Box input field
	 *	.
	 *		In this example if the Current Date is 09/16/2014, then the date typed in the Date Text Box input field will be 09/17/2014
	 *	.
	 *	NOTE:
	 *		0 ($number) is a value added/subtracted from the Current Date. In this case 0 will represent the Current Date we are in.
	 *	.
	 *	TIPS & TRICKS:
	 *		Negative (exp: -1) values represent the number that will be Subtracted from the Current Date (month, day, year). 
	 *	.
	 *			QuickExample: If Current Date is 09/16/2014 then passing in the integer -1 for each of the values (month, day, year) will type 08/15/2013.
	 *	.
	 *		Positive (exp: 1) values represent the number that will be Added to the Current Date (month, day, year).
	 *	.
	 *			QuickExample: If Current Date is 09/16/2014 then passing in the integer 1 for each of the values (month, day, year) will type 10/17/2015.
	 *	.
	 *		Neutral ( 0 ) represents the Current Day we are in.
	 *	.
	 *			QuickExample: If Current Date is 09/16/2014 then passing in the integer 0 for each of the values (month, day, year) will type 09/16/2014 (current date).
	 */
    @When(value="I increment the current date by $months month(s) $days day(s) and $years year(s) in the $alias input field", priority=1)
	public void iIncrementCurrentDateByMonthDayYearInInputField(int months, int days, int years, String alias) {
    	tecsaLogic.guiActionsAliasTypeMonthDayYear(months, days, years, alias);
    }
    
    // #############################################################
    // LogIn to Member portal ######################################
    
	/**
	 *	Method to LogIn to Member portal 
	 * 	.        
	 *	@param userId
	 *		specifies the userId that will be typed 
	 *	.
	 *	@param password
	 *		specifies the password that will be typed
	 *	. 
	 *	EXAMPLE:
	 *		When I log In to Member Portal using Cool as the UserID and W@rm as the Password
	 *	.
	 *	NOTE:
	 *		Cool ($userId) is the userId that will be typed on this example. 
	 *	.
	 *		W@rm ($password) is the userId that will be typed on this example. 
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to login to Member Portal with one step.
	 */
    @When("I log In to Member Portal using $userId as the UserID and $password as the Password")
	public void ilogInUsingUserIDAndPassword(String userId, String password) {
    	tecsaLogic.guiActionslogInToMemberUsingUserIDAndPassword(userId, password);
    }
    
    // #############################################################
    // WORK WITH LOGONS ############################################
    
	/**
	 *	Method to encrypt text with a key  
	 * 	.
	 *	@param key
	 *		key to encrypt text
	 * 	.        
	 *	@param text
	 *		text to be encrypted
	 *	.  
	 *	EXAMPLE:
	 *		When I use the key $Testing to protect the text $MyText
	 *	.
	 *	NOTE:
	 *		$Testing8456978 ($key) is the key we are going to use to encrypt text. 
	 *	.
	 *		$MyText ($text) is the text that is going to get encrypted.
	 *	.
	 *	TIPS & TRICKS:
	 *		Use This Test Step when you want to encrypt certain text for a script.
	 */
	@When("I use the key $key to protect the text $text")
	public void iProtectTheWithKey(String key, String text) {
		tecsaLogic.guiActionsProtectWithKey(key, text);
	}
    
	/**
	 *	Method to LogIn to Client portal 
	 *	. 
	 *	EXAMPLE:
	 *		When I log in to Client Portal
	 *	.
	 *	NOTE:
	 *		Use this Test Step when you want to log in to client portal 
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to login to Client Portal with one step.
	 */
	@When("I log in to Client Portal")
	public void ilogInToClientPortal() {
		tecsaLogic.guiActionslogInToClientPortal();
	}
	

    // #############################################################
    // WORK CALENDAR POP UP ########################################	
	
	/**
	 *	Custom Method to decrease given months and days from  the current date in a pop up calendar in the client portal
	 * 
	 *	@param months
	 *		specifies how many months to go back in the past
	 *	.
	 *	@param days
	 *		specifies how many days to go back in the past
	 *	.
	 *	EXAMPLE:
	 *		When I decrease the current date by 6 months and 3 days
	 *	.
	 *	NOTE:
	 *		6 ($months) is the number of months we are going back in the calendar from the current date
	 *	.
	 *		3 ($days) is the number of days we are going back in the calendar from the current date
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to decrease number of months and days from the current date on a pop up calendar in the client portal.  
	 */
	@When(value="I decrease the current date by $months {month|months} and $days {day|days}", priority=1)
	public void iSelectDate(int months, String days) {
		tecsaLogic.guiActionsDateClick(months, days);
	}
	
	/**
	 *	Custom Method to decrease given months from  the current date in a pop up calendar in the client portal and assert date is not clickable
	 * 
	 *	@param months
	 *		specifies how many months to go back in the past
	 *	.
	 *	EXAMPLE:
	 *		When I decrease the current date by 13 months and assert the day before is not clickable
	 *	.
	 *	NOTE:
	 *		13 ($months) is the number of months we are going back in the calendar from the current date
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to decrease number of months from the current date on a pop up calendar in the client portal and assert date is not clickable.  
	 */
	@When(value="I decrease the current date by $months {month|months} and assert the day before is not clickable")
	public void iDecreaseDateAndAssertNotClickable(int months) {
		tecsaLogic.guiActionsDecreaseDateAndAssertNotClickable(months);
	}
	
	/**
	 *	Custom Method to increase the current date by one day in a pop up calendar in the client portal and assert date is not clickable
	 * 
	 *	EXAMPLE:
	 *		When I decrease the current date by 13 months and assert the day before is not clickable
	 *	.
	 *	NOTE:
	 *		use this step to assert future day is not clickable in the calendar. 
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to increase one day in the current date on a pop up calendar in the client portal and assert date is not clickable.  
	 */
	@When(value="I increase the current date by One Day and assert the date is not clickable")
	public void iIncreaseDateAndAssertNotClickable() {
		tecsaLogic.guiActionsIncreaseDateAndAssertNotClickable();
	}
	
    // #############################################################
    // WORK WITH DEPENDENT TABLE ###################################
	
	/**
	 *	Custom Method to Select, Type and Clear information with a specific rows and columns in the Client Portals Update Dependent table
	 * 
	 *	@param action
	 *		specifies action to be used i.e. select, type or clear
	 *	.
	 *	@param value
	 *		specifies value to be selected or typed. This param is ignored when you use the action "clear"
	 *	.
 	 *	@param row
 	 *		specifies row to use on the table object. The number representing the row will be evens starting with 2 then going to 4 then 6 and so on till there is no more rows.
 	 *	.
 	 *	@param column
 	 *		specifies column to use on the table object. The number representing the column will be normal starting with 1 then going to 2 then 3 and so on till there is no more columns.
 	 *	.
	 *	EXAMPLE #1:
	 *		When I select Re-inst in the Dependents Table row 2 column 1
	 *	.
	 *	EXAMPLE #2:
	 *		When I type Re-inst in the Dependents Table row 2 column 7
	 *	.
	 *	EXAMPLE #3:
	 *		When I clear value in the Dependents Table row 2 column 7
	 *	.
	 *	NOTE EXAMPLE #1:
	 *		select ($action) is the action we will use in this step. It is not case sensitive.
	 *	.
	 *		Re-inst ($value) is the value we will be selecting from the specified row and column in the table. 
	 *	.
	 *		2 ($row) is the row we will be using.
	 *	.
	 *		1 ($column) is the column we will be using.  
	 *	.
	 *	NOTE EXAMPLE #2:
	 *		type ($action) is the action we will use in this step. It is not case sensitive.
	 *	.
	 *		Re-inst ($value) is the value we will be typing from the specified row and column in the table. 
	 *	.
	 *		2 ($row) is the row we will be using.
	 *	.
	 *		7 ($column) is the column we will be using.
	 *	.
	 *	NOTE EXAMPLE #3:
	 *		clear ($action) is the action we will use in this step. It is not case sensitive.
	 *	.
	 *		value ($value) in this step it does not matter what you use for value, it will not be used. It is ignored regardless of what you type. 
	 *	.
	 *		2 ($row) is the row we will be using.
	 *	.
	 *		7 ($column) is the column we will be using.  
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to Select, Type and Clear information with a specific rows and columns in the Client Portals Update Dependent table
	 */
	@When(value="I $action $value in the Dependents Table row $row column $column", priority=1)
	public void iSelectTypeClearFromDependentsTableRowColumn(String action, String value, int row, int column) {
		tecsaLogic.guiActionsSelectTypeClearFromDependentsTableRowColumn(action, value, row, column);
	}

    // #############################################################
    // TYPE SAVED KEY VALUE IN FIELD ###############################
    
	/**
	 *	Method to type a saved value�s content in a specified Element  
	 * 	.     
	 *	@param key
	 *		specifies the name of the variable you are going to use to save the content to.
	 *	.  
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.
	 *	EXAMPLE:
	 *		When I type my saved value with firstPatientName in the Patient Name Input Box
	 *	.
	 *	NOTE:
	 *		firstPatientName ($key) is the name of the key you are going to use in this example (It can be whatever you want it to be)
	 *	.
	 *		Patient Name Input Box ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to type a saved value�s content in a specified Element  
	 */
    @When(value="I type my saved value with $key in the $alias", priority=1)
	public void iTypeMySavedValue(String key, String alias) {
    	tecsaLogic.guiActionsAliasTypeMySavedValue(key, alias);
    }
    
	/**
	 *	Method to type a saved value�s content in a specified Element 
	 * 	.     
	 *	@param key
	 *		specifies the name of the variable you are going to use to save the content to.
	 *	. 
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	.
	 *	EXAMPLE:
	 *		When I type my saved value with firstPatientName in TARGET ID = j_id0:j_id1:orderdetails:j_id19:0:j_id24
	 *	.
	 *	NOTE:  
	 *		firstPatientName ($key) is the name of the key you are going to use in this example (It can be whatever you want it to be)
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to type a saved value�s content in a specified Element  
	 */
    @When(value="I type my saved value with $key in TARGET $locatorType = $locatorValue", priority=1)
	public void iTypeMySavedValueinTarget(String key, String locatorType, String locatorValue) {
    	tecsaLogic.guiActionsTargetTypeMySavedValue(key, locatorType, locatorValue);
    }
    
    // #############################################################
    // NAVIGATE TO THE VSP PATIENT REPORT ##########################
    
	/**
	 *	Method to navigate to the VSP patient report
	 * 	.  
	 *	@param patientRecord
	 *		Defaul is patientRecord. Passed in are 
	 *	.
	 *		patientRecord
	 *	.
	 *		lensEnhancementsCharges
	 *	.
	 *		savingsStatement
	 *	.
	 *		service
	 *	.     
	 *	@param serverOne
	 *		serverOne where the report is 
	 *	.
	 *	@param authNumber
	 *		authNumber to retrieve VSP patient Report
	 *	.
	 *	@param memberId
	 *		memberId of the member used for the report
	 *	.
	 *	@param frame
	 *		frame where the report page source is in
	 *	. 
	 *	EXAMPLE:
	 *		When I navigate to the VSP lensEnhancementsCharges report on a1 with 10340024 and 323232343425252525 and save the page source from the rptPage
	 *	.
	 *	NOTE:
	 *		You must use this step Twice before  you can use the step "I assert the $patientRecord report page source of $authNumber on $serverOne and $serverTwo are equal" or else it wont work. 
	 *	.
	 *		a1 ($serverOne) is the server used for this example
	 *	.
	 *		10340024 ($authNumber) is the auth number used for this example
	 *	.
	 *		323232343425252525 ($memberId) is the memberId used for this example
	 *	.
	 *		rptPage ($frame) is the frame used for this example
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to navigate to the VSP patient report with a specific server, auth, memberId and save the page source inside a specified frame.   
	 */
	@When("I navigate to the VSP $patientRecord report on $server with $authNumber and $memberId and save the page source from the $frame")
	public void iNavigateToTheVspPatientReportWithAuth(String patientRecord, String server, String authNumber, String memberId, String frame) {
		tecsaLogic.iNavigateToTheVspPatientReport(patientRecord, server, authNumber, memberId, frame);
	}
	
	/**
	 *	Method to navigate to the VSP patient report
	 * 	.  
	 *	@param patientRecord
	 *		Defaul is patientRecord. Basically the name you want to assing the folder where the printed results will be.
	 *	.     
	 *	@param server
	 *		server where the report is
	 *	.
	 *	@param authNumber
	 *		authNumber to retrieve VSP Report
	 *	.
	 *	EXAMPLE:
	 *		When I save the page source of the VSP patientHistory report on a1 and 10340024
	 *	.
	 *	NOTE:
	 *		You must use this step Twice before  you can use the step "I assert the $patientRecord report page source of $authNumber on $serverOne and $serverTwo are equal" or else it wont work. 
	 *	.
	 *		patientHistory ($patientRecord) is the name we will use for this example where the resukts be put in.
	 *	.
	 *		a1 ($server) is the server used for this example
	 *	.
	 *		10340024 ($authNumber) is the auth number used for this example
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to save the page source of a specific report.   
	 */
	@When("I save the page source of the VSP $patientRecord report on $server and $authNumber")
	public void iSaveThePageSourceOfTheReport(String patientRecord, String server, String authNumber) {
		tecsaLogic.guiActionsSaveThePageSourceOfTheReport(patientRecord, server, authNumber);
	}
	
	/**
	 *	Method to wait for the Authorization page to be present
	 * 	.  
	 *	EXAMPLE:
	 *		When I wait for the Authorization page to be present
	 *	.
	 *	NOTE:
	 *		You must use this step when you want to assure the Authorization page is present
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to wait for the Authorization page to be present  
	 */
	@When(value="I wait for the Authorization page to be present", priority =1)
	public void iWaitForTheAuthorizationPageToBePresent() {
		tecsaLogic.guiActionsWaitForAuthorizationFieldToBePresent();
	}
	
	/**
	 *	Method to wait for the CMS Form to be present
	 * 	.  
	 *	EXAMPLE:
	 *		When I wait for the CMS Form to be present
	 *	.
	 *	NOTE:
	 *		You must use this step after you click the "GO" button after submitting the auth
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to wait for the CMS Form to be present   
	 */
	@When(value="I wait for the CMS Form to be present", priority =1)
	public void iWaitForTheCmsFormToBePresent() {
		tecsaLogic.guiActionsWaitForCmsToBePresent();
	}
	
	/**
	 *	Method to wait for the content of the Report to be present
	 * 	.  
	 *	EXAMPLE:
	 *		When I wait for the content of the Report to be present
	 *	.
	 *	NOTE:
	 *		You must use this step after you click the "Reports tab" on the CMS form page
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to wait for the content of the Report to be present   
	 */
	@When(value="I wait for the content of the Report to be present", priority =1)
	public void iWaitForTheContentOfTheReport() {
		tecsaLogic.guiActionsWaitForPageSourceToBePresent();
	}   
	
    // #############################################################
    // WORK WITH UPLOADING FILES ###################################
	
	/**
	 *	Method to upload a specific file into a specified location
	 *	.
	 *	NOTE: THIS STEP ONLY WORKS LOCALLY RIGHT NOW! IT WILL NOT WORK ON JENKINS!!
	 * 	.
	 *	@param filepath
	 *		specifies the path of the file you want to upload
	 *	. 
	 *	@param project
	 *		specifies the location (i.e. is it located in the project or Locally in your machine) of the file you want to upload
	 *	.        
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.
	 *	EXAMPLE:
	 *		When I upload the file com\vsp\tecsa\stories\Training Material\OON 1.pdf from my project into the Image Upload button
	 *	.
	 *	NOTE:
	 *		com\vsp\tecsa\stories\Training Material\OON 1.pdf ($filepath) is the location where the file you want to upload
	 *	.
	 *		project ($project) is the location of the file. In this case its located inside the project
	 *	.
	 *		Image Upload button ($alias) is the name we are giving to the Object (alias) on this example.
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to upload a specific file into a specified location 
	 */
	@When(value="I upload the file $filepath from my $project into the $alias")
	public void iUploadAFileInThe(String filepath, String project, String alias) {
		tecsaLogic.guiActionsUploadAFileInThe(filepath, project, alias);
	}
	
	/**
	 *	Method to upload a specific file into a specified location
	 *	.
	 *	NOTE: THIS STEP ONLY WORKS LOCALLY RIGHT NOW! IT WILL NOT WORK ON JENKINS!!	 
	 * 	.
	 *	@param filepath
	 *		specifies the location of the file you want to upload
	 *	.  
	 *	@param project
	 *		specifies the location (i.e. is it located in the project or Locally in your machine) of the file you want to upload
	 *	.       
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	.
	 *	EXAMPLE:
	 *		When I upload the file com\vsp\tecsa\stories\Training Material\OON 1.pdf from my project into TARGET ID = file
	 *	.
	 *	NOTE:
	 *		com\vsp\tecsa\stories\Training Material\OON 1.pdf ($filepath) is the location where the file you want to upload
	 *	.
	 *		project ($project) is the location of the file. In this case its located inside the project
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to upload a specific file into a specified location 
	 */
	@When(value="I upload the file $filepath from my $project into TARGET $locatorType = $locatorValue")
	public void iUploadAFileInTarget(String filepath, String project, String locatorType, String locatorValue) {
		tecsaLogic.guiActionsUploadAFileInTarget(filepath, project, locatorType, locatorValue);
	}
    
     // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 	 // THEN STEPS $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 	 // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
    // #############################################################
    // WORK WITH DEPENDENT TABLE ###################################
	
	/**
	 *	Custom Method to Assert the Client Portals Update Dependent tables Error Messages with a specified row.
	 * 
 	 *	@param row
 	 *		specifies row to assert on table object. The number representing the row will be odds starting with 1 then going to 3 then 5 and so on till there is no more rows.
 	 *	.
	 *	@param value
	 *		specifies the text value from the Error Message.
	 *	.
	 *	EXAMPLE #1:
	 *		Then I assert the Dependents Table row 1 Error Message equals Invalid effective date.
	 *	.
	 *	NOTE EXAMPLE #1:
	 *		1 ($row) is the row we will be using.
	 *	.
	 *		Invalid effective date. ($value) is the value we will be Asserting. I orther words its what the text in the specified row equals.
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to Assert the Client Portals Update Dependent tables Error Messages with a specified row.
	 */
	@Then(value="I assert the Dependents Table row $row Error Message equals $value")
	public void iAssertTheDependentsTableRowEquals(int row, String value) {
		tecsaLogic.guiActionsAssertTheDependentsTableRowErrorMessageEquals(row, value);
	}	
 	
     // #############################################################
     // ASSERT TEXT IN A TABLE ROW AND COLUMN #######################
     
 	/**
 	 *	Method to assert rows and columns on a specified table object on a page
 	 *	.
 	 *	@param row
 	 *		specifies row to assert on table object
 	 *	.
 	 *	@param column
 	 *		specifies column to assert on table object 
 	 * 	.        
 	 *	@param locatorType
 	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
 	 *	.
 	 *	@param locatorValue
 	 *		specifies locator value
 	 *	.
 	 *	@param text
 	 *		specifies what the expected text result
 	 *	. 
 	 *	EXAMPLE:
 	 *		Then I assert row 4 column 1 of TABLE ID = ExamBenefit RESULT text = Your WellVision Exam is fully covered.
 	 *	.
 	 *	NOTE:
 	 *		The Above Example Test Step is the most common Step you will be working with when you want to Hard Code a Test Step within a .story(s). 
 	 *	.
 	 *		Your WellVision Exam is fully covered. ($text) is the value we want to select
 	 *	.
 	 *	TIPS & TRICKS:
 	 *		Use this Test Step when you want to verify text on specific rows and columns on a table
 	 */
 	@Then(value="I assert row $row column $column of TABLE $locatorType = $locatorValue RESULT text = $text", priority=2)
 	public void guiActionsTargetGetTableContentContains(int row, int column, String locatorType, String locatorValue, String text) {
 		tecsaLogic.guiActionsTargetGetTableContentContains(locatorType, locatorValue, row, column, text, true);
 	}
 	
 	/**
 	 *	Method to assert rows and columns on a specified table object on a page
 	 *	.
 	 *	@param row
 	 *		specifies row to assert on table object
 	 *	.
 	 *	@param column
 	 *		specifies column to assert on table object 
 	 *	.
 	 *	@param alias
 	 *		specifies which element to get from xml object
 	 *	.
 	 *	@param text
 	 *		specifies what the expected text result
 	 *	.  
 	 *	EXAMPLE:
 	 *		Then I assert row 4 column 1 of TABLE Contact Lens Exam Benefit Table RESULT text = Your WellVision Exam is fully covered.
 	 *	.
 	 *	NOTE:
 	 *		Contact Lens Exam Benefit Table ($alias) is the name we are giving to the Object (alias) on this example.
 	 *	.
 	 *		Your WellVision Exam is fully covered. ($text) is the value we want to select
 	 *	.
 	 *	TIPS & TRICKS:
 	 *		Use this Test Step when you want to verify text on specific rows and columns on a table
 	 */
 	@Then(value="I assert row $row column $column of TABLE $alias RESULT text = $text", priority=1)
 	public void guiActionsAliasGetTableContentContains(int row, int column, String alias, String text) {
 		tecsaLogic.guiActionsAliasGetTableContentContains(alias, row, column, text, true);
 	}
 	
    // #############################################################
    // ASSERT TEXT IN SAVED KEY TO ELEMENT ON PAGE ##################
 	
	/**
	 *	Method to assert a saved value�s content is contained in the attributeType of a TARGET Element  
	 * 	.     
	 *	@param key
	 *		specifies the name of the variable you are going to use to save the content to.
	 *	.  
	 *	@param attributeType
	 *		attributeType from the Elements DOM
	 *	. 
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	.
	 *	EXAMPLE:
	 *		When I assert my saved value with mySavedValue is contained in the textContent of TARGET ID = storyPointsField
	 *	.
	 *	NOTE:  
	 *		mySavedValue ($key) is the name of the key you are going to use in this example (It can be whatever you want it to be)
	 *	.
	 *		textContent ($attributeType) is the attributeType we are retrieving from the DOM
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to assert a the attributeType of TARGET Element is contained in the value of a saved key. 
	 */
 	@Then("I assert my saved value with $key is contained in the $attributeType of TARGET $locatorType = $locatorValue")
 	public void targetGetSavedValueContains(String key, String attributeType, String locatorType, String locatorValue) {
 		tecsaLogic.guiActionsTargetVerifyTextContainsSavedValue(key, attributeType, locatorType, locatorValue);			
 	}
 	
	/**
	 *	Method to assert a saved value�s content is contained in the attributeType of an Alias Element  
	 * 	.
	 *	@param key
	 *		specifies the name of the variable you are going to use to save the content to.
	 *	.  
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.
	 *	@param attributeType
	 *		attributeType from the Elements DOM        
	 *	.
	 *	EXAMPLE:
	 *		I assert my saved value with mySavedValue is contained in the registration Fields attributeType textContent
	 *	.
	 *	NOTE:
	 *		mySavedValue ($key) is the name of the key you are going to use in this example (It can be whatever you want it to be)
	 *	.
	 *		registration Fields ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *		textContent ($attributeType) is the attributeType we are retrieving from the DOM
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to assert a the attributeType of Alias Element is contained in the value of a saved key. 
	 */
 	@Then("I assert my saved value with $key is contained in the $alias attributeType $attributeType")
 	public void aliasGetSavedValueContains(String key, String alias, String attributeType) {
 		tecsaLogic.guiActionsAliasVerifyTextContainsSavedValue(key, alias, attributeType);			
 	}
 	
	/**
	 *	Method to assert a saved value�s content is contained in the attributeType of a TARGET Element  
	 * 	.     
	 *	@param key
	 *		specifies the name of the variable you are going to use to save the content to.
	 *	.  
	 *	@param attributeType
	 *		attributeType from the Elements DOM
	 *	. 
	 *	@param locatorType
	 *		specifies locator type: ID, CLASSNAME, TAGNAME, NAME, LINKTEXT, PARTIALLINKTEXT, CSSSELECTOR, XPATH
	 *	.
	 *	@param locatorValue
	 *		specifies locator value
	 *	.
	 *	EXAMPLE:
	 *		When I assert my saved value with mySavedValue is equal to the textContent of TARGET ID = storyPointsField
	 *	.
	 *	NOTE:  
	 *		mySavedValue ($key) is the name of the key you are going to use in this example (It can be whatever you want it to be)
	 *	.
	 *		textContent ($attributeType) is the attributeType we are retrieving from the DOM
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to assert a the attributeType of TARGET Element is contained in the value of a saved key. 
	 */
 	@Then("I assert my saved value with $key is equal to the $attributeType of TARGET $locatorType = $locatorValue")
 	public void targetGetSavedValueEquals(String key, String attributeType, String locatorType, String locatorValue) {
 		tecsaLogic.guiActionsTargetVerifyTextEqualsSavedValue(key, attributeType, locatorType, locatorValue);			
 	}
 	
	/**
	 *	Method to assert a saved value�s content is contained in the attributeType of an Alias Element  
	 * 	.
	 *	@param key
	 *		specifies the name of the variable you are going to use to save the content to.
	 *	.  
	 *	@param alias
	 *		specifies which element to get from xml object
	 *	.
	 *	@param attributeType
	 *		attributeType from the Elements DOM        
	 *	.
	 *	EXAMPLE:
	 *		I assert my saved value with mySavedValue is equal to the registration Fields attributeType textContent
	 *	.
	 *	NOTE:
	 *		mySavedValue ($key) is the name of the key you are going to use in this example (It can be whatever you want it to be)
	 *	.
	 *		registration Fields ($alias) is the name we are giving to the Object (alias) on this example. 
	 *	.
	 *		textContent ($attributeType) is the attributeType we are retrieving from the DOM
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to assert a the attributeType of Alias Element is contained in the value of a saved key. 
	 */
 	@Then("I assert my saved value with $key is equal to the $alias attributeType $attributeType")
 	public void aliasGetSavedValueEqulas(String key, String alias, String attributeType) {
 		tecsaLogic.guiActionsAliasVerifyTextEqualsSavedValue(key, alias, attributeType);			
 	}
 	
    // #############################################################
    // ASSERT TWO PAGE SOURCES ARE EQUAL ###########################
 	
	/**
	 *	Method to assert two page sources on two servers with same auths are equal 
	 * 	.
	 *	@param patientRecord
	 *		patientRecord is variable passed for each of the four reports!!
	 *	.  
	 *	@param authNumber
	 *		authNumber to retrieve Report
	 *	.
	 *	@param serverOne
	 *		serverOne where page source is saved 
	 *	.
	 *	@param serverTwo
	 *		serverTwo where page source is saved
	 *	. 
	 *	EXAMPLE:
	 *		Then I assert the patientRecord report page source of 10340024 on a1 and a2 are equal
	 *	.
	 *	NOTE:
	 *		You must use this step after "When I navigate to the VSP patienteport on $server with $authNumber and $memberId and save the page source from the $frame" or else it wont work. 
	 *	.
	 *		12345678 ($authNumber) is the auth number used for this example
	 *	.
	 *		12345678 ($authNumber) is the auth number used for this example
	 *	.
	 *		a1 ($serverOne) is the server used for this example
	 *	.
	 *		a2 ($serverTwo) is the server used for this example
	 *	.
	 *	TIPS & TRICKS:
	 *		Use this Test Step when you want to assert the page source of two different servers with the same auth are equal.   
	 */
	@Then("I assert the $patientRecord report page source of $authNumber on $serverOne and $serverTwo are equal")
	public void iAssertThePageSourceOnAreEqual(String patientRecordReport, String authNumber, String serverOne, String serverTwo) {
		tecsaLogic.guiActionsAssertThePageSourceOnAreEqual(patientRecordReport, authNumber, serverOne, serverTwo);
	}
}