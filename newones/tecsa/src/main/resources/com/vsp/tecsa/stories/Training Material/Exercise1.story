Meta: 
@jira 20000
@author mattjo

Narrative:
In order to test client log-in
As a client admin of a group
I want to verify that I can log-in successfully

Scenario: 1 - Successful Log-in
When I open browser to https://visionbenefits-acpt.vsp.com/
Given I view the ClientHomePage
When I type j.be in the UserID
When I type $Test111 in the Password
When I click the LogIn Button
Given I view the ClientDetailPage
Then I assert the text from the Client Detail Header equals MANAGE ELIGIBILITY - CLIENT DETAILS
When I click the LogOut/Register Button
When I close the browser
