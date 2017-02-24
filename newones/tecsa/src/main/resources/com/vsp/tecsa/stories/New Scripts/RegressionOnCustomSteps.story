Meta: 
@jira RegressionTest2
@author JuanLo2

Narrative:
In order to make sure the GUI Test Steps still work
As a client admin of a group
I want to verify that the Test Steps still work 

Scenario: OLD OLD - Working With Custom Steps Part I OLD OLD
Meta:
skip
When I open <browserType> <browserVersion> to https://member-vma3.vsp.com/
Given I delete all cookies
Given I view the RegressionOnGuiTestStepsPage
When I maximize the browser
When I clear value from the Member UserId Field
When I type nardom in the Member UserId Field
When I clear value from TARGET CSSSELECTOR = #accBody > #login > fieldset > div > div.relativePosition > div.longFieldWrapper > #password
When I type pamPBE1 in the Member UserPassword Field
When I click the Member LogIn Button
When I pause 10000 milliseconds
When I click TARGET CSSSELECTOR = div.accountButton > a
!-- ---- Work With Custom Methods
Then I assert row 2 column 2 of TABLE ID = Benefit RESULT text = Every year beginning in January.
Then I assert row 1 column 2 of TABLE Well Vision Table RESULT text = YOU ARE ELIGIBLE
When I pause 1000 milliseconds
When I click the TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[2]/form/div/div/a and select the link Tom Nardo from the jQuery Style dropdown
When I pause 3000 milliseconds
When I click the Choose Member dropdown and select the link Dependent not listed? from the jQuery Style dropdown
When I pause 3000 milliseconds
When I navigate browser to https://visionplans-test.vsp.com/
When I clear value from the UserId Field
When I type cbinternal in TARGET ID = userid
When I clear value from TARGET ID = password
When I type $Test123 in TARGET ID = password
When I submit TARGET ID = login_0
When I pause 2000 milliseconds
When I click the Client Headquarters dropdown and select Georgia from the jQuery Style clientHeadquarters dropdown
When I pause 1000 milliseconds
Then I assert the innerHTML equals Georgia from TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[1]/div[2]/div[1]/div/span
When I click the TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[1]/div/a and select July from the jQuery Style effectiveDate_month dropdown
When I pause 1000 milliseconds
Then I assert the innerHTML equals July from TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[1]/div/span
When I pause 3000 milliseconds
!-- ---- Work with Month and Year jQuery dropdown Custom Steps
When I click the TARGET Xpath = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[1]/div/a and select 0 month(s) from the CurrentMonth from the jQuery Style effectiveDate_month dropdown
When I pause 1000 milliseconds
When I click the Effective Month jQuery dropdown and select -10 month(s) from the CurrentMonth from the jQuery Style effectiveDate_month dropdown
When I pause 1000 milliseconds
When I click the TARGET Xpath = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[2]/div/a and select 0 year(s) from the CurrentYear from the jQuery Style effectiveDate_year dropdown
When I pause 1000 milliseconds
When I click the Effective Year jQuery dropdown and select 0 years(s) from the CurrentYear from the jQuery Style effectiveDate_year dropdown
When I pause 2000 milliseconds
!-- ---- End Work with Month and Year jQuery dropdown Custom Steps
When I navigate browser to https://visionplans-test.vsp.com/doc-directory.html
When I pause 2000 milliseconds
When I select Wisconsin from the State dropdown
When I pause 1000 milliseconds
Then I assert the innerHTML equals Wisconsin from TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[2]/div[4]/div/form/div[2]/div[2]/div/div/div/span
When I pause 2000 milliseconds
When I navigate browser to http://www.eyeconic.com/
When I pause 2000 milliseconds
When I hover over the TARGET CSSSELECTOR = a.white.txtLg.bold[onclick="showHeaderMenu($('#shopMenu'));"] and select the link CONTACT LENSES from the Hover Style dropdown
When I pause 2000 milliseconds
When I hover over the FIND dropdown and select the link BRANDS from the Hover Style dropdown
When I pause 2000 milliseconds
!-- ---- End Work With Custom Methods
When I quit all browsers
When I pause 1500 milliseconds


Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|CHROME		|			   |
|FIREFOX 	|              |



Scenario: 1 - Working With Custom Steps Part I
When I open <browserType> <browserVersion> to https://www-acpt.vsp.com/home.html
Given I delete all cookies
Given I view the RegressionOnGuiTestStepsPage
When I maximize the browser
When I click TARGET LinkText = LOGIN
When I clear value from TARGET ID = userid
When I type nardom in TARGET ID = userid
When I clear value from TARGET ID = password
When I type pamPBE1 in TARGET ID = password
When I press the ENTER keys
When I pause 3000 milliseconds
When I click TARGET CSSSELECTOR = div.accountButton > a
When I wait for TARGET ID = ExamBenefit to be present
!-- ---- Work With Custom Methods
Then I assert row 2 column 2 of TABLE ID = ExamBenefit RESULT text = You can have an eye exam every 12 months beginning in January.
Then I assert row 1 column 2 of TABLE WellVision Table RESULT text = YOU ARE ELIGIBLE.
When I pause 1000 milliseconds
When I click the TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[2]/form/div/div/a and select the link Tom Nardo from the jQuery Style dropdown
When I pause 3000 milliseconds
Then I assert the innerHTML equals Tom Nardo from TARGET CSSSELECTOR = div.jqTransformSelectWrapper div span
When I pause 1000 milliseconds
When I click the Choose Member dropdown and select the link Dependent not listed? from the jQuery Style dropdown
When I pause 3000 milliseconds
Then I assert the innerHTML equals Other Covered Dependents from TARGET CSSSELECTOR = div.full h1
When I pause 2000 milliseconds
When I navigate browser to https://visionplans-test.vsp.com/
When I clear value from the UserId Field
When I type cbinternal in TARGET ID = userid
When I clear value from TARGET ID = password
When I type $Test123 in TARGET ID = password
When I submit TARGET ID = login_0
When I pause 2000 milliseconds
When I click the Client Headquarters dropdown and select Georgia from the jQuery Style clientHeadquarters dropdown
When I pause 1000 milliseconds
Then I assert the innerHTML equals Georgia from TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[1]/div[2]/div[1]/div/span
When I click the TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[1]/div/a and select July from the jQuery Style effectiveDate_month dropdown
When I pause 1000 milliseconds
Then I assert the innerHTML equals July from TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[1]/div/span
When I pause 3000 milliseconds
!-- ---- Work with Month and Year jQuery dropdown Custom Steps
When I click the TARGET Xpath = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[1]/div/a and select 0 month(s) from the CurrentMonth from the jQuery Style effectiveDate_month dropdown
When I pause 1000 milliseconds
When I click the Effective Month jQuery dropdown and select -10 month(s) from the CurrentMonth from the jQuery Style effectiveDate_month dropdown
When I pause 1000 milliseconds
When I click the TARGET Xpath = html/body/div[1]/div[3]/div[2]/div[1]/div[3]/form/div[4]/div[3]/div[2]/div/a and select 0 year(s) from the CurrentYear from the jQuery Style effectiveDate_year dropdown
When I pause 1000 milliseconds
When I click the Effective Year jQuery dropdown and select 0 years(s) from the CurrentYear from the jQuery Style effectiveDate_year dropdown
When I pause 2000 milliseconds
!-- ---- End Work with Month and Year jQuery dropdown Custom Steps
When I navigate browser to https://visionplans-test.vsp.com/doc-directory.html
When I pause 2000 milliseconds
When I select Wisconsin from the State dropdown
When I pause 1000 milliseconds
Then I assert the innerHTML equals Wisconsin from TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[2]/div[4]/div/form/div[2]/div[2]/div/div/div/span
When I pause 2000 milliseconds
When I navigate browser to http://www.eyeconic.com/
When I pause 2000 milliseconds
When I hover over the TARGET CSSSELECTOR = a.white.txtLg.bold[onclick="showHeaderMenu($('#shopMenu'));"] and select the link CONTACT LENSES from the Hover Style dropdown
When I pause 2000 milliseconds
When I hover over the FIND dropdown and select the link BRANDS from the Hover Style dropdown
When I pause 2000 milliseconds
!-- ---- End Work With Custom Methods
When I quit all browsers
When I pause 1500 milliseconds


Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|CHROME		|			   |
|FIREFOX 	|              |



Scenario: 2 - Working With Custom Steps Part II
When I open <browserType> <browserVersion> to https://visionbenefits-test.vsp.com/
When I maximize the browser
Given I view the RegressionOnGuiTestStepsPage
When I clear value from TARGET ID = userid
When I type cbinternal in TARGET ID = userid
When I clear value from TARGET ID = password
When I type $Test123 in TARGET ID = password
When I submit LogIn Button
When I pause 2500 milliseconds
When I select MEMBER ID from TARGET ID = idType
When I type 000000068 in TARGET ID = idValue
When I press the ENTER key
When I click TARGET LINKTEXT = Update
!-- ---- Work with Month, Day and Year Custom Steps
When I select 0 month(s) from the CurrentMonth from TARGET Cssselector = #updatePane #columnarForm .formSection .formColumn #birthDate_month
When I pause 1000 milliseconds
When I select -1 month(s) from the CurrentMonth from the Effective SelectMonth dropdown
When I pause 1000 milliseconds
When I select 0 day(s) from the CurrentDay from TARGET Cssselector = #updatePane #columnarForm .formSection .formColumn #birthDate_day
When I pause 1000 milliseconds
When I select 0 day(s) from the CurrentDay from the Effective SelectDay dropdown
When I clear value from TARGET CssSelector = #updatePane #columnarForm .formSection .formColumn #birthDate_year
When I type 0 year(s) from the CurrentYear in TARGET CssSelector = #updatePane #columnarForm .formSection .formColumn #birthDate_year
When I pause 1000 milliseconds
When I clear value from TARGET CssSelector = #updatePane #columnarForm .formSection .formColumn #birthDate_year
When I type -10 year(s) from the CurrentYear in the Effective TypeYear Field
When I pause 2000 milliseconds
!-- ---- End Work with Month, Day and Year Custom Steps
When I quit all browsers
When I pause 1500 milliseconds


Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|CHROME		|			   |
|FIREFOX 	|              |


