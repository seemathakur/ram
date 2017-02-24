Meta: 
@jira 20002
@author mattjo

Narrative:
In order to test client log-in
As a client admin of several groups
I want to verify that I can log-in successfully and that invalid login attempts fail

Scenario: 1 - Verify 3 successful member login attempts and 2 unsuccessful attempts
When I open browser to https://visionbenefits-acpt.vsp.com/
Given I view the ClientHomePage
When I type <UserID> in the UserID
When I type <Password> in the Password
When I click the LogIn Button
Given I view the ClientDetailPage
Then I assert the text from the LogOut/Register Button equals <Text>
When I click the LogOut/Register Button
When I close the browser


Examples:
|UserID		|Password	|Text		|
|j.be		|$Test111	|LOG OUT	|
|j.be2		|$Test222	|LOG OUT	|
|j.be3		|$Test333	|LOG OUT	|
|abcdef		|12345		|REGISTER	|
|WrongID	|$Test123	|REGISTER	|



