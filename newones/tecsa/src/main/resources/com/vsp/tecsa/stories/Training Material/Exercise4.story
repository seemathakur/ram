Meta: 
@jira 20003
@author mattjo

Narrative:
In order to test the Find a Doctor function on Member Portal
As a non-member guest
I want to verify that I can search for a doctor

Scenario: 1 - Successful FAD search
When I open browser to https://www-acpt.vsp.com/
Given I view the MemberHomePage
When I type 95630 in the FAD Zip
When I click the FAD Search Button
Given I view the SearchResultsPage
Then I assert the text from the Dr1Name Field equals Cecille G Taylor MD
When I clear value from the Change Zip
When I type 95819 in the Change Zip
When I click the Update Button
Then I assert the text from the Dr1Name Field equals Eye Site Sacramento 
When I close the browser
