Meta: 
@jira 10001
@author mattjo

Narrative:
In order to test client log-in
As a client admin of different groups
I want to verify that I can log-in successfully and that invalid login attempts fail

Scenario: 1 - Verify 3 successful member login attempts and 2 unsuccessful attempts
When I open browser to https://visionbenefits-acpt.vsp.com/
Given I view the ClientHomePage
When I type <UserID> in the UserID
When I type <Password> in the Password
When I click the LogIn Button
Given I view the ClientDetailPage
Then I assert the text from the TopNav Button equals <Text>
When I click the LogOut/Register Button
When I close the browser


!-- When this ID is reset and working, use this...
!-- |12345678|VSP%client2011| log out |
!-- When ID is not working, use this...
!-- |12345678|VSP%client2011| REGISTER |

Examples:
|UserID		|Password	|Text		|
|cind.ri25	|$Test123	|LOG OUT	|
|cind.ri5	|$Test123	|LOG OUT	|
|cind.ri55	|$Test123	|LOG OUT	|
|cind.ri55	|WrongPass	|REGISTER	|
|WrongID	|$Test123	|REGISTER	|



