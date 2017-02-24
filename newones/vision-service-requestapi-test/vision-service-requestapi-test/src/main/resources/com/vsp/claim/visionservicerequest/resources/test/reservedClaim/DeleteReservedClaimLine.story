Narrative:
As a consumer
I want to delete claim lines on the reserved claim
Meta: @regression
@jira AUTH-1361

Scenario: #1 - Delete an existing claim line returns a 200.
Given the claim key 100049664-00
And the claim line number 2

When I initialize the claim with default values
And I delete the claim line

Then the HTTP status code is 200
And the claim line should be:
|lineNumber|
|2		   |

Scenario: #2 - Delete a claim line on a claim that does not exist returns a 404.
Given the claim key 100049664-99
And the claim line number 2

When I delete the claim line

Then the HTTP status code is 404

Scenario: #3 - Delete a non-existent claim line returns 404.
Given the claim key 100049664-00
And the claim line number 99

When I initialize the claim with default values
And I delete the claim line

Then the HTTP status code is 404
