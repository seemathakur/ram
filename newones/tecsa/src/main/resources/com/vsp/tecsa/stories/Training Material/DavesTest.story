Meta: 
@jira DavesTest

Narrative:
In order to 
As a 
I want to 

Scenario: Using the Claim # List Field
Meta:
@skip
When I open browser to http://schqvclm250/testtools
When I maximize the browser
Given I view the DavesTestPage
When I click the R Region Radio Button
When I click the Select Button
Then I assert the text from the Success Message equals A region was successfully choosen.
When I click the Delete Claim Tool link
When I click the All Tables Radio Button
!-- When I click the Claim Number List Field
When I type C:\\Users\\juanlo2\\Desktop\\BlankFile.txt in the Claim Number List Field
When I click the Delete Button

Scenario: Loop Using the Claim # List Field
Meta:
@skip
When I clear value from the Claim Number List Field
When I type <Location> in the Claim Number List Field
When I click the Delete Button

Examples:
|Location									|
|C:\\Users\\juanlo2\\Desktop\\BlankFile.txt	|

Scenario: Using the Claim # Field

When I open browser to http://schqvclm250/testtools
When I maximize the browser
Given I view the DavesTestPage
When I click the R Region Radio Button
When I click the Select Button
Then I assert the text from the Success Message equals A region was successfully choosen.
When I click the Delete Claim Tool link
When I click the All Tables Radio Button
When I type 00 in the Claim Number Field
When I click the Delete Button


Scenario: Loop Using the Claim # Field

When I clear value from the Claim Number Field
When I type <claimNumber> in the Claim Number Field
When I click the Delete Button

Examples:
|claimNumber	|
|01				|
|02				|
|03				|
