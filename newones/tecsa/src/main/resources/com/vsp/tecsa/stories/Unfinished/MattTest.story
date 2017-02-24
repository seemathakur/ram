Meta: @jira 1000
@author mattjo

Narrative:
In order to
As a member of the Client Administrative Services Department with a Client Portal role of PFSAdmin, 
I want to update a Member’s name prefix in EM so I can track the most recent name prefix for the member and address the Member properly when communicating with the member.

Scenario: 
Given browser is at https://visionbenefits-acpt.vsp.com/
Given I am on the home page
When I type 12345678 in the Benefits Managers User Name field
When I type VSP%client2011 in the Password field
When I click the LOG IN button
When I verifyText value in ELEMENT locatorType = locatorValue
!--


Scenario: 2 - Using Example Parameters
!-- Given browser is at webPage
Given browser is at https://visionbenefits-acpt.vsp.com/
!-- Given I am on the alias page
Given I am on the Template1 page
!-- When I type value in the alias field
When I type <UserID> in the UserID field
When I type <Password> in the Password field
!-- When I click the alias button
When I click the LogIn button
!-- When I verifyText value in ELEMENT locatorType = locatorValue
When I verifyText Manage Eligibility - Client Details in ELEMENT xpath = //html/body/div[1]/div[3]/div[2]/div[1]/h1
!-- When I click the alias button
When I click the LogOut button
Then the browser should close



Examples:
|UserID|Password|
|12345678|VSP%client2011|

 
