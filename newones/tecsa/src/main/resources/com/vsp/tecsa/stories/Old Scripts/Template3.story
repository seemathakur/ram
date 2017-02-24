Meta: 
@jira 3002
@author mattjo

Narrative:
In order to test Client Portal Navigation Links
As a member of ABC group
I want to verify that I can navigate successfully

Scenario: 1 - Client Portal Navigation Smoke Test (Navigates 50 Pages, Verifies 35 Checkpoints, 2 Field entries)
Given browser is at https://visionbenefits-acpt.vsp.com/
Given I am on the template page
When I type <UserID> in UserID field
When I type <Password> in Password field
When I click the LOG IN button
!-- CHECKPOINT 1
Then the ME Header field text equals MANAGE ELIGIBILITY - CLIENT DETAILS
When I click the ENHANCE YOUR PLAN link link
!-- CHECKPOINT 2
Then the EYP Header field text equals ENHANCE YOUR PLAN
When I click the MANAGE YOUR PLAN link link
When I click the DOCTOR DIRECTORY link link
!-- CHECKPOINT 3
Then the DD Header field text equals DOCTOR DIRECTORY
When I click the MANAGE YOUR PLAN link link
When I click the CONTACT US link link
!-- CHECKPOINT 4
Then the CU Header field text equals CONTACT US
When I click the MANAGE YOUR PLAN link link
When I click the DOCTOR DIRECTORY link link
!-- CHECKPOINT 5
Then the CITY Header field text equals Doctor Directory by City or State ( * Required Information )
When I click the COUNTRY link link
!-- CHECKPOINT 6  
Then the COUNTRY Header field text equals Doctor Directory by County ( * Required Information )
When I click the ADDRESS link link
!-- CHECKPOINT 7
Then the ADDRESS Header field text equals Doctor Directory by Address ( * Required Information )
When I click the NAME link link
!-- CHECKPOINT 8
Then the NAME Header field text equals Doctor Directory by Doctor or Office Name ( * Required Information )
When I click the CITY link link
!-- CHECKPOINT 9
Then the CITY Header field text equals Doctor Directory by City or State ( * Required Information )
When I click the RESOURCES link link
When I click the MEMBER SUPPORT link link
!-- CHECKPOINT 10
Then the MS Header field text equals MEMBER SUPPORT & COMMUNICATION
When I click the EXCLUSIVE PROGRAMS link link
!-- CHECKPOINT 11
Then the EP Header field text equals EXCLUSIVE PROGRAMS & OFFERS
When I click the MEMBER SUPPORT FAQS link link
!-- CHECKPOINT 12
Then the MSF Header field text equals MEMBER SUPPORT FAQS
When I click the STAYING CONNECTED link link
!-- CHECKPOINT 13
Then the SC Header field text equals STAYING CONNECTED
When I click the HIPAA COMPLIANCE link link
!-- CHECKPOINT 14
Then the HIPAA Header field text equals HIPAA
When I click the CONTACT US#2 link link
!-- CHECKPOINT 15
Then the CU2 Header field text equals CONTACT US
When I click the ADMINISTRATION link link
!-- CHECKPOINT 16
Then the ADMIN BOX field text equals Account Administration
When I click the CLAIMS link link
!-- CHECKPOINT 17
Then the CLAIMS BOX field text equals Authorizations
When I click the MS link link
!-- CHECKPOINT 18
Then the MS BOX field text equals Find a Doctor
When I click the TECH SUPPORT link link
When I click the OTHER link link
!-- CHECKPOINT 19
Then the OTHER BOX field text equals General
When I click the MANAGE YOUR PLAN link link
When I click the MANAGE ELIG link link
!-- CHECKPOINT 20
Then the ME Header field text equals MANAGE ELIGIBILITY - CLIENT DETAILS
When I click the MANAGE FAQS link link
!-- CHECKPOINT 21
Then the MF BOX field text equals ELIGIBILITY MANAGEMENT FAQS
When I click the WHY VSP link link
When I click the TOPNAV RESOURCES link link
!-- CHECKPOINT 22
Then the RES Header field text equals TOOLS TO SUPPORT YOUR EMPLOYEES
When I click the CENTERNAV SM image link link
!-- CHECKPOINT 23
Then the SM Header field text equals SECURE MAIL
When I click the TOPNAV RESOURCES link link
When I click the CENTERNAV MS image link link
!-- CHECKPOINT 24
Then the MS Header field text equals MEMBER SUPPORT & COMMUNICATION
When I click the TOPNAV RESOURCES link link
When I click the CENTERNAV DD image link link
!-- CHECKPOINT 25
Then the DD Header field text equals DOCTOR DIRECTORY
When I click the TOPNAV RESOURCES link link
When I click the CENTERNAV EP image link link
!-- CHECKPOINT 26
Then the EP Header field text equals EXCLUSIVE PROGRAMS & OFFERS
When I click the TOPNAV RESOURCES link link
When I click the CENTERNAV EC image link link
!-- CHECKPOINT 27
Then the EC Header field text equals STAYING CONNECTED
When I click the CENTERNAV COE tab link link
!-- CHECKPOINT 28
Then the EC Header field text equals STAYING CONNECTED
When I click the TOPNAV RESOURCES link link
When I click the CENTERNAV WW image link link
!-- CHECKPOINT 29
Then the EC Header field text equals STAYING CONNECTED
When I click the TOPNAV RESOURCES link link
When I click the CENTERNAV COE image link link
!-- CHECKPOINT 30
Then the EC Header field text equals STAYING CONNECTED
When I click the TOPNAV RESOURCES link link
When I click the CENTERNAV SM image link link
!-- CHECKPOINT 31
Then the SM Header field text equals SECURE MAIL
When I click the SECURE MAIL link link
!-- CHECKPOINT 32
Then the SM Header field text equals SECURE MAIL
When I click the EXISTING USER LOGIN link link
!-- CHECKPOINT 33
Then the EUL Header field text equals SECURE MAIL EXISTING USER
When I click the NEW USER link link
!-- CHECKPOINT 34
Then the NU Header field text equals SECURE MAILBOX ( * REQUIRED FIELDS )
When I click the SECURE MAIL FAQS link link
!-- CHECKPOINT 35
Then the SMF Header field text equals SECURE MAIL FAQS	
When I click the LOG OUT button
Then the browser should close

Examples:
|UserID|Password|
|cind.ri25|$Test123|







