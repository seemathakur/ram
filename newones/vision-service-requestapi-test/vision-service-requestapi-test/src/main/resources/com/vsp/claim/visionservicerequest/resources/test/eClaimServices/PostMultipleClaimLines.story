Narrative:
As a consumer
I want to create multiple claim lines in one transaction
Meta: @regression
@jira AUTH-1622

Scenario: 1 - After create lines operation, there are 2 new lines
Given the claim key 100049664-00

When I initialize the claim with default values
And I create reserved claim lines with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimLinesTest.json

Then the claim lines should be:
| lineNumber	| productCatalogKey |
| 3 			| GenExam 			|
| 4 			| RetinalScreening	| 