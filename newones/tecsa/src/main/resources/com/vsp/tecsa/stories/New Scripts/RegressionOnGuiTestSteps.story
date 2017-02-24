Meta: 
@jira RegressionTest
@author JuanLo2

Narrative:
In order to make sure the GUI Test Steps still work
As a client admin of a group
I want to verify that the Test Steps still work

Scenario: 1 - Testing Gui Test Steps Part I
When I open <browserType> <browserVersion> to https://visionbenefits-test.vsp.com/
Given I delete all cookies
Given I view the RegressionOnGuiTestStepsPage
When I maximize the browser
When I click TARGET ID = userid
When I press the TAB key
Then I assert the TARGET ID = password focus equals true
Then I assert the TARGET ID = userid focus equals false
Then I assert the UserPassword Field focus equals true
Then I assert the UserId Field focus equals false
Then I assert the TARGET CSSSELECTOR = img[alt="VSP(R) Vision Care"] is not a broken image
Then I assert the Promo Image is not a broken image
Then I assert the text matches CAREERS from TARGET LINKTEXT = CAREERS
Then I assert the text from the CONTACT US link equals CONTACT US	
Then I assert the text from the Outreach link does not equal Help Me Please
Then I assert the text from the Newsroom link does not contain This Is a Test
Then I assert the text from the Privacy Policy link contains Policy
Then I assert the text equals HIPAA from TARGET LINKTEXT = HIPAA
Then I assert the text does not equal WIIIILLLLLLLLLSOOOOONNNNNNN!!!!!! from TARGET LINKTEXT = Report Fraud
Then I assert the text does not contain FireGamble from TARGET LINKTEXT = Terms of service
Then I assert the text contains Blog from TARGET LINKTEXT = VSP Blog
Then I assert the page title does not contain What Tittle
Then I assert the page title contains Benefits from VSP
Then I assert the page source does not contain http://www.WhyMe.com
Then I assert the current url does not contain http://www.google.com
Then I assert the current url contains //visionbenefits
Then I assert the text does not equal $NO_TEXT from TARGET CssSelector = .lostPassword
Then I assert the text from the Outreach link does not equal $NO_TEXT
Then I assert the text equals $NO_TEXT from TARGET ID = password
Then I assert the text from the UserPassword Field equals $NO_TEXT
Then I assert the cssType color from TARGET ID = login_rememberme equals rgba(0, 0, 0, 1)
Then I assert the cssType color from the Remember User ID CheckBox equals rgba(0, 0, 0, 1)
When I set IsSelected value to true from TARGET ID = login_rememberme
When I set the Remember User ID CheckBox IsSelected value to false
When I pause 1000 milliseconds
!-- ---- Using AttributeType Steps
Then I assert the innerHTML from the Report Fraud link equals Report Fraud
Then I assert the innerHTML from the Outreach link does not equal HOME
Then I assert the innerHTML from the Newsroom link does not contain DESIGN
Then I assert the innerHTML from the Privacy Policy link contains Policy
Then I assert the innerHTML equals HIPAA from TARGET LINKTEXT = HIPAA
Then I assert the innerHTML does not equal Newsroom from TARGET LINKTEXT = Terms of service
Then I assert the innerHTML does not contain YouTube from TARGET LINKTEXT = Sitemap
Then I assert the innerHTML contains Mobile from TARGET LINKTEXT = VSP Mobile Site
Then I assert the innerHTML does not equal $NO_TEXT from TARGET CssSelector = .lostPassword
Then I assert the innerHTML from the Outreach link does not equal $NO_TEXT
Then I assert the innerHTML equals $NO_TEXT from TARGET ID = password
Then I assert the innerHTML from the UserPassword Field equals $NO_TEXT
!-- ---- End Using AttributeType Steps
When I click TARGET LINKTEXT = CONTACT US
When I navigate the browser back
When I pause 500 milliseconds
When I navigate the browser forward
When I quit all browsers
When I pause 500 milliseconds
Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|CHROME		|			   |
|FIREFOX 	|              |


Scenario: 2 - Testing Gui Test Steps Part II
Given I open <browserType> <browserVersion>
Given I delete all cookies
When I maximize the browser
Given I view the RegressionOnGuiTestStepsPage
When I pause 1500 milliseconds
When I navigate browser to http://www.eyefinity.com
When I pause 1500 milliseconds
When I move to TARGET CLASSNAME = login_link
When I click
!-- ---- Work with select box assertions with tables and paths 
Then I assert the LogonType equals: 
|option|
|Eyecare Professional|
|Optical Lab|
|Supplier Partner|
|Practice Management Partner|
Then I assert TARGET ID = logonType equals: com\vsp\tecsa\stories\Option Tables\Equals.table
Then I assert the LogonType contains: 
|option|
|Supplier Partner|
|Eyecare Professional|
|Practice Management Partner|
|Optical Lab|
Then I assert TARGET ID = logonType contains: com\vsp\tecsa\stories\Option Tables\Contains.table
!-- ---- END Work with select box assertions with tables and paths
Given I set the implicit wait to 15 seconds
When I type 8086232866 in the Eyefinity UserId Field
When I type 1171 in the Eyefinity UserPassword Field
When I move to the Eyefinity LogIn Button
When I click
When I pause 3000 milliseconds
When I wait for the Eyefinity LogIn Button to not be present
When I wait for the Track Other Claims link to be present
When I click the Track Other Claims link
When I pause 1000 milliseconds
!-- ---- Work With Alerts
When I wait for TARGET NAME = clmNbr to be present
When I type Testing in TARGET NAME = clmNbr
When I click the Claim Tracking Search Button
When I pause 2000 milliseconds
When I switch to alert
Then I assert the text from the alert equals Please enter a numeric claim number.
Then I assert the text from the alert does not equals This is only a Test
When I OK the alert
!-- ---- End Work With Alerts
When I pause 1000 milliseconds
!-- ---- Work with and Verify Select boxes
Then I assert the Claim Status dropdown does not match This is FUN
Then I assert the Insurance Carrier dropdown does not contain D (01/12/23)
Then I assert the Claim Status dropdown contains Archived
Then I assert Email Webmaster is not contained in TARGET NAME = doctorbox
Then I assert Carpenters Health Welfare is contained in TARGET NAME = SelectedInsCosList
When I select Aetna from the Insurance Carrier dropdown
When I select Re-Submitted from TARGET NAME = statusType
!-- ---- End Work with and Verify Select boxes
When I pause 1000 milliseconds
!-- ---- Work With IsSelected and IsEnabled Steps
Then I assert IsSelected equals false from TARGET CSSSELECTOR = input[value="Date"]
Then I assert IsSelected from the Insured ID Radio Button equals false
When I click the Insurance Carrier Radio Button
Then I assert IsEnabled from the Insurance Carrier Radio Button equals true
Then I assert IsEnabled equals true from TARGET CSSSELECTOR = input[value="NoCriterion"]
!-- ---- End Work With IsSelected and IsEnabled Steps
When I quit all browsers
When I pause 500 milliseconds
Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|CHROME		|			   |
|FIREFOX 	|              |


Scenario: OLD OLD - Testing Gui Test Steps OLD OLD
Meta:
@skip
When I open <browserType> <browserVersion> to https://visionplans-test.vsp.com/
Given I delete all cookies
Given I view the RegressionOnGuiTestStepsPage
Given I set browser window to BENEFITS MANAGERS Page
When I click TARGET LINKTEXT = VSP Mobile Site
When I pause 3000 milliseconds
When I switch browser window
When I maximize the browser
When I click TARGET CSSSELECTOR = a[href="/scms/benefits/member-id-card.html"]
When I click TARGET LINKTEXT = Forgot Username or Password?
When I navigate the browser back
When I pause 1000 milliseconds
When I navigate the browser back
When I close the browser
When I switch browser tab to BENEFITS MANAGERS Page
When I pause 1000 milliseconds
When I clear value from the UserId Field
When I type cbinternal in TARGET ID = userid
When I clear value from TARGET ID = password
When I type $Test123 in TARGET ID = password
When I submit TARGET ID = login_0
When I maximize the browser
When I pause 2500 milliseconds
When I click TARGET CSSSELECTOR = a[href="/client-setup.html"]
When I pause 2000 milliseconds
!-- ---- Start New Application
When I type HELOO in TARGET ID = clientName
When I click the TARGET XPATH = .//*[@id='clientSetup']/div[2]/div[2]/div/div/a and select 2 to 9 eligible employees from the jQuery Style clientSize dropdown
When I click the Effective Month dropdown and select April from the jQuery Style effectiveDt_month dropdown
When I click the Effective Year dropdown and select 2015 from the jQuery Style effectiveDt_year dropdown
When I click TARGET ID = clientStart
When I pause 2500 milliseconds
When I click TARGET ID = startApplication
When I pause 2000 milliseconds
!-- ----- Broker Form
When I type HELOO in TARGET ID = app_client_entry_appInfo_clientInfo_principalContact
When I type HELOO in TARGET ID = app_client_entry_appInfo_clientInfo_principalContactTitle
When I type HELOO in TARGET ID = contactAddress
When I type 916-555-5555 in TARGET ID = contactPhone
When I type HELOO in TARGET ID = app_client_entry_appInfo_clientInfo_address_city
When I type jdfg@gmail.com in TARGET ID = app_client_entry_appInfo_clientInfo_email
When I click the TARGET XPATH = .//*[@id='app_client_entry']/div[2]/div[5]/div/div/a and select South Carolina from the jQuery Style clientState dropdown
When I click the TARGET XPATH = .//*[@id='clientCountySec']/div/div/a and select Florence from the jQuery Style clientCounty dropdown
When I type 95658 in TARGET ID = app_client_entry_appInfo_clientInfo_address_zip
When I type HELOO in TARGET ID = app_client_entry_appInfo_clientInfo_bizNature
When I type 2 in TARGET ID = app_client_entry_appInfo_clientInfo_eligibleEmployees
When I type 2 in TARGET ID = app_client_entry_appInfo_clientInfo_totalEmployees
When I click the TARGET XPATH = .//*[@id='app_client_entry']/div[5]/div[1]/div[1]/div/a and select 17 from the jQuery Style clientChildAge dropdown
When I pause 1500 milliseconds
When I click the TARGET XPATH = .//*[@id='app_client_entry']/div[5]/div[1]/div[3]/div/a and select 20 from the jQuery Style clientChildAgeSchool dropdown
When I pause 1500 milliseconds
When I click TARGET CSSSELECTOR = a.clientHasInetAccessN.jqTransformRadio
When I click the TARGET XPATH = .//*[@id='app_client_entry']/div[6]/div[1]/div/div/a and select Broker/Consultant from the jQuery Style contctInfoTo dropdown
When I click TARGET CSSSELECTOR = a.clientHasThrdPrtyAdminN
When I click TARGET ID = client-continue-button
When I pause 2500 milliseconds
When I click TARGET ID = benefitYearCAL
When I click TARGET ID = policy-continueBtn
When I pause 2500 milliseconds
!-- ---- End Broker Form
!-- ---- Verify Select boxes
Then I assert the Copay Amount dropdown does not match $13
Then I assert the Frequency of Service dropdown does not contain D (01/12/23)
Then I assert the Effective Date dropdown contains January
Then I assert Email Webmaster is not contained in TARGET ID = rateBasisType
Then I assert February is contained in TARGET ID = effectiveDate_month
When I select $10 from the Copay Amount dropdown
When I select B (12/12/24) from TARGET ID = frequency
When I click TARGET ID = policy-save-button
When I pause 3500 milliseconds
When I OK the alert
!-- ---- End Verify Select boxes
When I pause 3000 milliseconds
When I click TARGET CSSSELECTOR = a.logout
When I pause 1500 milliseconds
When I navigate browser to https://visionplans-test.vsp.com/
When I pause 1500 milliseconds
!-- ---- Delete Form and work with Alerts
When I clear value from the UserId Field
When I type cbinternal in TARGET ID = userid
When I clear value from TARGET ID = password
When I type $Test123 in TARGET ID = password
When I submit LogIn Button
When I maximize the browser
When I pause 2500 milliseconds
When I click TARGET CSSSELECTOR = a[href="/client-setup.html"]
When I pause 2000 milliseconds
When I click TARGET CSSSELECTOR = a[href="#tabs-2"]
When I click TARGET LINKTEXT = HELOO
When I click TARGET LINKTEXT = Client Info
When I pause 3000 milliseconds
When I clear value from TARGET ID = app_client_entry_appInfo_clientInfo_clientName
When I type HELOO2 in TARGET ID = app_client_entry_appInfo_clientInfo_clientName
When I pause 1000 milliseconds
When I click TARGET ID = client-save-button
When I pause 4000 milliseconds
Then I assert the text from the alert equals Client Info saved!
When I OK the alert
When I pause 3000 milliseconds
When I click TARGET CSSSELECTOR = a[href="/client-setup.html"]
When I pause 2000 milliseconds
When I click TARGET CSSSELECTOR = a[href="#tabs-2"]
When I click TARGET CSSSELECTOR = tr.odd td.tdLeftNoPad button.jqTransformButton
When I pause 1500 milliseconds
Then I assert the text from the alert does not equals This Is Only A test
When I OK the alert
When I pause 1500 milliseconds
When I click TARGET CLASSNAME = logout
When I pause 1500 milliseconds
When I navigate browser to https://visionplans-test.vsp.com/
When I pause 1500 milliseconds
When I click TARGET ID = login_rememberme
!-- ---- End Delete Form and work with Alerts
Then I assert IsSelected equals false from TARGET ID = login_rememberme
When I click the Remember User ID CheckBox
Then I assert IsSelected from the Remember User ID CheckBox equals true
Then I assert IsEnabled from the Remember User ID CheckBox equals true
When I click the Remember User ID CheckBox
Then I assert IsEnabled equals true from TARGET ID = login_rememberme
When I quit all browsers
When I pause 500 milliseconds
Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|CHROME		|			   |
|FIREFOX 	|              |


Scenario: 3 - Testing Gui Test Steps Part III
When I open <browserType> <browserVersion> to https://visionbenefits-test.vsp.com/
Given I delete all cookies
Given I view the RegressionOnGuiTestStepsPage
When I maximize the browser
Given I set browser window to BENEFITS MANAGERS Page
When I clear value from the UserId Field
When I clear value from TARGET ID = password
When I doubleClick the UserId Field
When I pause 2000 milliseconds
When I doubleClick TARGET ID = password
When I pause 2000 milliseconds
When I clear value from the UserId Field
When I type 12345678 in TARGET ID = userid
When I clear value from TARGET ID = password
When I type VSP%client2011 in TARGET ID = password
When I rightClick TARGET LINKTEXT = Forgot User Name or Password?
When I press the ARROW_DOWN key
When I press the ARROW_DOWN key
When I press the ENTER key
When I pause 1500 milliseconds
When I switch browser tab
When I maximize the browser
When I pause 2000 milliseconds
When I clear value from TARGET ID = userid2
When I type THIS IS ONLY A TEST, SMILE PLEASE ;-D in TARGET ID = userid2
When I clear value from TARGET ID = email
When I type THIS IS ONLY A TEST, NO NEED TO CRY ;-D in TARGET ID = email
When I pause 3000 milliseconds
When I close the browser
When I switch browser tab to BENEFITS MANAGERS Page
When I pause 1500 milliseconds
When I rightClick UserPassword Field
When I pause 1000 milliseconds
When I press the ARROW_DOWN key
When I press the ARROW_DOWN key
When I press the ENTER key
When I pause 1500 milliseconds
When I clear value from the UserId Field
When I type 12345678 in the UserId Field
When I clear value from TARGET ID = password
When I type VSP%client2011 in the UserPassword Field
When I submit LogIn Button
When I pause 7000 milliseconds
When I wait for TARGET ID = login_0 to not be present
When I switch to active element
When I navigate browser to https://visionbenefits-test.vsp.com/doc-directory.html
When I pause 3000 milliseconds
When I move to TARGET XPATH = html/body/div[1]/div[3]/div[1]/div[7]/div[4]/div/form/div[1]/div/div/a
When I click TARGET XPATH = html/body/div[1]/div[3]/div[1]/div[7]/div[4]/div/form/div[1]/div/div/a
When I pause 500 milliseconds
When I press the 0 key
When I pause 500 milliseconds
When I press the ENTER keys
When I pause 2000 milliseconds
When I click TARGET ID = city
When I select Washington from the State dropdown
When I pause 1000 milliseconds
When I quit all browsers
When I pause 500 milliseconds
!-- Interacting with the right click List Boxes doesn't work with Chrome.
!-- |CHROME 		|
Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|FIREFOX 	|              |


Scenario: 4 - Testing Gui Test Steps Part IV
Given I open <browserType> <browserVersion>
Given I delete all cookies
When I maximize the browser
Given I view the RegressionOnGuiTestStepsPage
When I type 12345678 in the UserId Field
When I type VSP%client2011 in the UserPassword Field
When I refresh the browser
When I pause 1500 milliseconds
When I navigate browser to http://www.eyefinity.com/home
When I pause 3000 milliseconds
When I click TARGET CLASSNAME = login_link
When I type 8086232866 in the Eyefinity UserId Field
When I type 1171 in the Eyefinity UserPassword Field
When I click the Eyefinity LogIn Button
When I pause 3000 milliseconds
When I click the File Claims link
When I pause 3000 milliseconds
!-- ---- Switch in and out of frame 
When I switch to frame guiPage
When I pause 1200 milliseconds
When I switch to default content
When I pause 1200 milliseconds
When I switch to frame portal
When I pause 1200 milliseconds
When I switch to default content
When I switch to frame navPage
When I switch to default content
When I pause 1500 milliseconds
!-- ---- End Frame Test
When I quit all browsers
When I pause 1500 milliseconds
Examples:
|browserType|browserVersion|
|IEXPLORER 	|10            |
|CHROME		|			   |
|FIREFOX 	|              |


Scenario: 5 - Testing Gui Test Steps Part V 
When I open FIREFOX to https://visionplans-test.vsp.com/
Given I delete all cookies
Given I view the RegressionOnGuiTestStepsPage
When I maximize the browser
When I clear value from the UserId Field
When I type cbinternal in TARGET ID = userid
When I clear value from TARGET ID = password
When I type $Test123 in TARGET ID = password
When I submit LogIn Button
When I click TARGET CSSSELECTOR = a[href="/doc-directory.html"]
When I pause 1500 milliseconds
When I click TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[2]/div[1]/h3/span
When I pause 1000 milliseconds
When I click the TARGET XPATH = html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/form/div[2]/div[1]/div/div/div/a and select California from the jQuery Style state dropdown
When I pause 1500 milliseconds
When I key down CONTROL
When I select Alpine from the County select box
When I select Butte from the County select box
When I key up CONTROL
When I pause 2000 milliseconds
When I click TARGET ID = createdfor
When I key down CONTROL
When I select Tulare from the County select box
When I select Tehama from the County select box
When I key up CONTROL
When I pause 2000 milliseconds
Then I assert page contains California
Then I assert page contains Alpine
Then I assert page contains Butte
When I quit all browsers
When I pause 500 milliseconds

Scenario: 6 - Testing Gui Test Steps Part VI
When I open <browserType> <browserVersion> to https://visionbenefits-test.vsp.com/
Given I view the ClientHomePage
When I type 12345678 in the UserID
When I type VSP%client2011 in the Password
When I click the LogIn Button
Then I assert the current url contains https://visionbenefits-test.vsp.com/logged-in-landing.html
Then I assert the page title contains Manage Eligibility - Client Details
Given I view the ClientDetailPage
Then I assert the text equals BIS Test's Account from TARGET CLASSNAME = loggedIn
Then I assert the text equals Log out from TARGET CLASSNAME = logout
When I click the LogOut/Register Button
When I close the browser
Examples:
|browserType|browserVersion|
|HTMLUNIT 	|IE8           |

Scenario: 7 - Testing Gui Test Steps Part VII
Given I open iexplorer 11 to relative path value.html
When I maximize the browser
When I pause 1000 milliseconds
Then I assert the page title contains VSP vision plans offer
Scenario: An examples table test to test the URL relative path
When I navigate browser to relative path <relativePath>
And I pause 1500 milliseconds
Then I assert the page title contains <pageTitle>
And I assert the current url contains <urlContains>
Examples:     
|relativePath                                 |pageTitle                                      |urlContains                                                                      |
|VSP-tools-manage-eligibility.html            |Tools to Manage Your Employees Eligibility     |https://visionbenefits-test.vsp.com/VSP-tools-manage-eligibility.html            |
|signon.html                                  |Benefits Managers Login                        |https://visionbenefits-test.vsp.com/signon.html                                  |
|register.html?WT.ac=client_login_ln_register |Register as a VSP Benefits Manager             |https://visionbenefits-test.vsp.com/register.html?WT.ac=client_login_ln_register |
|contact-non-secure.html                      |Contact Us                                     |https://visionbenefits-test.vsp.com/contact-non-secure.html                      |

Scenario: 8 - Testing Gui Test Steps Part VIII
When I open browser to https://visionbenefits-test.vsp.com/
When I maximize the browser
Given I view the ClientHomePage
When I type 12345678 in the UserID
When I type VSP%client2011 in the Password
When I click the LogIn Button
When I click TARGET XPATH = html/body/div[1]/div[1]/div[2]/div/div[1]/a[1]
When I click TARGET LINKTEXT = View My Account
Given I save the textContent from TARGET XPATH = html/body/div[1]/div[3]/div[1]/div/div/div[6] using the key firstName
Then I assert my saved value with firstName is contained in the innerHTML of TARGET CSSSELECTOR = .loggedIn

Scenario: 9 - Test Overriding Certificate Errors on Internet Explorer
When I open IExplorer 10 to https://dport-a1/login.2020
When I maximize the browser
When I type This is a Test in TARGET name = accountNumber
When I pause 2000 milliseconds



