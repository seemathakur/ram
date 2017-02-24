Meta: @jira 1001
@author mattjo

Narrative:
In order to
As a member of the Client Administrative Services Department with a Client Portal role of PFSAdmin, 
I want to update a Member’s name prefix in EM so I can track the most recent name prefix for the member and address the Member properly when communicating with the member.

Scenario: Testing Problem fields
!-- Given iexplorer is at https://visionbenefits-acpt.vsp.com/
Given browser is at url
!-- Given firefox is at https://visionbenefits-acpt.vsp.com/
When I type 12345678 in ELEMENT id = userid
When I type VSP%client2011 in ELEMENT id = password
When I pause 2000 milliseconds
When I clickAndWait ELEMENT id = login_0
Given I view home
When I click LOG OUT link
!-- When I click the Log In link
When I clickAndWait ELEMENT xpath = html/body/div[1]/div[1]/div[2]/div/div[1]/a[1]
When I type 12345678 in ELEMENT id = userid
When I type VSP%client2011 in ELEMENT id = password
When I pause 2000 milliseconds
When I clickAndWait ELEMENT id = login_0
!-- When I click Why VSP in the tab header
When I clickAndWait ELEMENT xpath = html/body/div[1]/div[1]/nav[2]/div/a[1]
When I pause 2000 milliseconds
When I clickAndWait ELEMENT css = img[alt="Down Arrow"]
When I click ELEMENT css = img[alt="Up Arrow"]
When I click LOG OUT link
Then the browser should close

