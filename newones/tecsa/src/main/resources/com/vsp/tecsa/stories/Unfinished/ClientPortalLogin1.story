Meta: 
@jira 10000
@author mattjo

Narrative:
In order to test client log-in
As a client admin of the XXX group
I want to verify that I can log-in successfully

Scenario: 1 - Simple Log-in
When I open browser to https://visionbenefits-acpt.vsp.com/
Given I view the ClientHomePage
When I type cind.ri25 in the UserID
When I type $Test123 in the Password
When I click the LogIn Button
Given I view the ClientDetailPage
Then I assert the text from the Client Detail Header equals MANAGE ELIGIBILITY - CLIENT DETAILS
When I click the LogOut Button
When I close the browser
 

