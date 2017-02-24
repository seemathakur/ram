Meta: 
@jira WindowTest
@author 

Narrative:
In order to 
As a 
I want to 

Scenario:

When I open browser to https://visionbenefits-acpt.vsp.com/
When I wait for TARGET ID = userid to be present
!-- Saves window A
Given I set browser tab to WindowTab_A
When I click TARGET LinkText = CAREERS
When I pause 2500 milliseconds
!-- switches to newly opened window
When I switch browser tab
!-- Saves window B
Given I set browser tab to WindowTab_B
!-- click on vsp---Optics Group image in the footer to open third window. 
When I click TARGET Xpath = html/body/div[1]/div[6]/div[1]/div/a[7]/img
When I pause 2500 milliseconds
!-- Try to switch into newly opened third window, but no luck because step switches to "WindowTab_A" instead.
When I switch browser tab
!-- Try switch again but goes to "WindowTab_B" instead.
When I pause 2500 milliseconds
When I switch browser tab
When I pause 2500 milliseconds
!-- Try switch again but goes back to "WindowTab_A" instead.
When I switch browser tab
When I pause 5000 milliseconds
!-- Seems the third window is not recognized. 

