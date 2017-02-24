Meta: 
@jira 3004
@author mattjo

Narrative:
In order to test the Client Application form on Broker Portal
As a VSP broker
I want to verify that I can fill out and submit the form successfully

Scenario: 1 - Client Application form (87 fields entries)
Given browser is at https://visionplans-acpt.vsp.com/
Given I am on the template2 page
When I type <UserID> in UserID field
When I type <Password> in Password field
When I click the LOG IN button
When I click the CLIENT APPLICATION link link
!-- Form Page 0  Start of Application
When I type JBEHAVE TEST GROUP in CLIENT NAME field
When I click the CLIENT SIZE field
When I click the 10 to 499 selection
When I click the EFF MONTH field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div/div[1]/form/div[2]/div[3]/div[1]/ul/li[2]/a
When I click the EFF YEAR field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div/div[1]/form/div[2]/div[3]/div[2]/ul/li[2]/a
When I click the BEGIN NEW APPLICATION button
When I click the START APPLICATION button
!-- Form Page 1 - Client Info
When I type Tester in PRINCIPAL CONTACT field
When I type Software Test Engineer in PRINCIPAL CONTACT TITLE field
When I type 123 Quality Drive in ADDRESS PAGE1 field
When I type 9167233564 in TELEPHONE PAGE1 field
When I type Sacramento in CITY PAGE1 field
When I type 8007654321 in FAX PAGE1 field
When I click the STATE PAGE1 field
When I click the California selection
When I type JBehaveIsCool@vsp.com in EMAIL PAGE1 field
When I click the COUNTY PAGE1 field
When I click the Colusa selection
When I type 95825 in ZIP PAGE1 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[3]/div[1]/div/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[3]/div[1]/div/span/a
When I type Software in NATURE OF BUSINESS field
When I type 12345 in SIC field
When I click the HEADQTR field
When I click the NEW YORK selection
When I type 300 in ELIG EES field
When I type 400 in TOTAL EES field
When I click the COV DEP field
When I click the 17 selection
When I click the COV DEP IN SCHOOL field
When I click the 30 selection
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[5]/div[2]/div[1]/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[5]/div[2]/div[2]/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[5]/div[2]/div[3]/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[5]/div[2]/div[4]/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[5]/div[4]/div[1]/span/a
When I click the SEND TO field
When I click the Broker selection
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/form/div[7]/div[1]/div[2]/span/a
When I click the Save and Continue Page1 button
!-- Form Page 2 - Administration Info
When I click the ADD DIVISION button
When I type JBehave Automators Rule in DIVISION NAME field
When I click the SAVE DIVISION button
When I click the SAVE AND CONTINUE PAGE2 button
!-- Form Page 3 - Policy Details
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div[1]/form/div[1]/div/div[1]/input
When I click the VISION BENEFIT field
When I press the down ARROW key
When I press the ENTER key
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/input
When I click the PLAN TYPE field
When I press the down ARROW key
When I press the ENTER key
When I click the COPAY AMOUNT field
When I press the down ARROW key
When I press the ENTER key
When I click the FREQUENCY field
When I press the down ARROW key
When I press the ENTER key
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/input
When I click the FISCAL MONTH field
When I press the down ARROW key
When I press the ENTER key
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div[1]/form/div[4]/div[2]/div[1]/input[1]
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div[1]/form/div[4]/div[2]/div[2]/input[1]
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div[1]/form/div[4]/div[3]/div[2]/input
When I type JBEHAVE COMPANIES in NAME OF AFFILIATES field
When I click the RATE BASIS field
When I press the down ARROW key
When I press the ENTER key
When I type 75 in RATE 1 field
When I click the EFF DATE MONTH field
When I press the down ARROW key
When I press the ENTER key
When I click the EFF DATE YEAR field
When I press the down ARROW key
When I press the ENTER key
When I click the SAVE AND CONTINUE PAGE3 button
!-- Form Page 4 - Broker Info
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[1]/div/span/a
When I type JBEHAVE ASSOCIATES in LEGAL FIRM NAME field
When I type SOMETHING in DBA field
When I type 123 QUALITY DRIVE in ADDRESS PAGE4 field
When I type 9167772351 in TELEPHONE PAGE4 field
When I type FOLSOM in CITY PAGE4 field
When I type 9167540987 in FAX PAGE4 field
When I click the STATE PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[9]/div/ul/li[4]/a
When I click the COUNTY PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[10]/div/div/ul/li[2]/a
When I type 76598 in ZIP PAGE4 field
When I click the BL ISSUE DATE MONTH PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[12]/div[1]/ul/li[3]/a
When I click the BL ISSUE DATE DAY PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[12]/div[2]/ul/li[2]/a
When I type 2013 in BL ISSUE DATE YEAR PAGE4 field
When I type 123456789 in LICENSE NUMBER PAGE4 field
When I click the BL EXP DATE MONTH PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[14]/div[1]/ul/li[5]/a
When I click the BL EXP DATE DAY PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[1]/div[14]/div[2]/ul/li[2]/a
When I type 2014 in BL EXP DATE YEAR PAGE4 field
When I type HEAD HONCHO in CONTACT TITLE PAGE4 field
When I type 123456789 in CONTACT LICENSE NUMBER PAGE4 field
When I click the CL ISSUE DATE MONTH PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[2]/div[5]/div[1]/ul/li[4]/a
When I click the CL ISSUE DATE DAY PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[2]/div[5]/div[2]/ul/li[5]/a
When I type 2013 in CL ISSUE DATE YEAR PAGE4 field
When I click the CL EXP DATE MONTH PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[2]/div[6]/div[1]/ul/li[13]/a
When I click the CL EXP DATE DAY PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[2]/div[6]/div[2]/ul/li[26]/a
When I type 2015 in CL EXP DATE YEAR PAGE4 field
When I type MR GTS JBEHAVE in BROKER ASSISTANT PAGE4 field
When I type JBEHAVE@VSP.COM in EMAIL PAGE4 field
When I type 124314242 in TAXPAYER ID PAGE4 field
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[3]/div[2]/div[1]/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[3]/div[3]/div[1]/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[4]/div/span/a
When I click ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div/div[2]/div/form/div[4]/div/span/a
When I type JBEHAVE AGENT in STATE LICENSED AGENT PAGE4 field
When I type JBEHAVE DIRECTOR in AGENT TITLE PAGE4 field
When I click the SAVE AND CONTINUE PAGE4 button
!-- Form Page 5 - Agreement
When I type JBEHAVE INC in FIRM PAGE5 field
When I type MATTHEW JBEHAVE in CONTACT NAME PAGE5 field
When I type MATTHEW JBEHAVE in SIGNATURE PAGE5 field
When I type JBEHAVE GOD in TITLE PAGE5 field
When I click the SAVE AND CONTINUE PAGE5 button
!-- Form Page 6 - Submit
When I click the SUBMIT APPLICATION button
!-- Form Page 7 - Confirmation Page
When I verifyText VSP VISION PLAN APPLICATION in ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div[1]/h1
When I click the LOG OUT button
Then the browser should close

Examples:
|UserID|Password|
|sbi.go|VSP%broker2011|








