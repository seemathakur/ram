Meta: @jira 3003
@author mattjo

Narrative:
In order to test member log-in
As a member of ABC group
I want to verify that I can log-in successfully

Scenario: 1 - Log-in without Example Parameters
Given browser is at https://visionbenefits-acpt.vsp.com/
Given I am on the template page
When I type 12345678 in UserID field
When I type VSP%client2011 in Password field
When I click the LOG IN button
When I verifyText MANAGE ELIGIBILITY - CLiENT DETAILS in ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div[1]/h1
When I click the LOG OUT button
Then the browser should close


Scenario: 2 - Using Example Parameters
!-- Open a browser and go to this URL
Given browser is at https://visionbenefits-acpt.vsp.com/
!-- Reference the xml object library file called template.xml
Given I am on the template page
!-- When I type value in the alias field in the template.xml file
When I type <UserID> in UserID field
When I type <Password> in Password field
!-- When I click the alias button
When I click the LOG IN button
!-- When I verifyText value in ELEMENT locatorType = locatorValue
When I verifyText MANAGE ELIGIBILITY - CLIENT DETAILS in ELEMENT xpath = html/body/div[1]/div[3]/div[2]/div[1]/h1
!-- When I click the alias button
When I click the LOG OUT button
Then the browser should close

Examples:
|UserID|Password|
|12345678|VSP%client2011|
|cind.ri25|$Test123|
|cind.ri5|$Test123|
|cind.ri55|$Test123|







