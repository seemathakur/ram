Meta: 
@jira JeffFa1
@author JeffFa

Narrative:
In order to test client log-in
As a client admin of a group
I want to verify that I can log-in successfully with various browsers

Scenario: 1 - Successful Log-in with IE8, IE9, Chrome & Firefox
When I open <Browser> <Version> to https://visionbenefits-acpt.vsp.com/
Given I view the ClientHomePage
When I type j.be in the UserID
When I type $Test111 in the Password
When I click the LogIn Button
Given I view the ClientDetailPage
Then I assert the text equals J'S ACCOUNT from TARGET CLASSNAME = loggedIn
Then I assert the text equals LOG OUT from TARGET CLASSNAME = logout
When I click the LogOut/Register Button
When I close the browser
Examples:
com/vsp/tecsa/stories/Option Tables/JeffFa1.table
