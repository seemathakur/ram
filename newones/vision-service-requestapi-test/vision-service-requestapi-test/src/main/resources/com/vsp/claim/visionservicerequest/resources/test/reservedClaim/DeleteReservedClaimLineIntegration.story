Narrative:
As a consumer
I want to delete claim lines on the reserved claim
Meta: @regression
@jira AUTH-1361

Scenario: #1 - Delete an existing claim line returns a 200.
Given a claim with a list of three claim lines
When I delete claim line 2 

Then the HTTP status code is 200
And the claim line should be:
|lineNumber|
|2		   |


When the reserved claim is retrieved
Then the claim lines should not contain claim line number 2

