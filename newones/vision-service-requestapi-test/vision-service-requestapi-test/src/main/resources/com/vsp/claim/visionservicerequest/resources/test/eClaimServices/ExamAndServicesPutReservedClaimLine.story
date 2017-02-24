Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @regression
@jira AUTH-1216


Scenario: #1 - Updating an existing ClaimLine with new data returns a 200.
Given the claim key 100049664-00
And the claim line number 2

When I initialize the claim with default values
And I update the reserved claim line with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimLineTest.json

Then the HTTP status code is 200
And the claim line should be:
|billedAmount|emergencyIndicator|epsdtIndicator|placeOfServiceCode|serviceCode|serviceStartDate|serviceEndDate|unitCount|
|100         |true              |true          |1                 |FC         |0001-12-27      |0001-12-27    |10       |

And the claim line should be:
|diagnosisPointers[0]	|diagnosisPointers[1]	|diagnosisPointers[2]	|
|1				        |2              		|3						|

And the claim line should be:
|modifierCodes[0]|modifierCodes[1]|modifierCodes[2]|modifierCodes[3]|
|1               |2               |3               |4               |


Scenario: #2 - Updating a ClaimLine on a claim that does not exist returns a 404.
Given the claim key 100049664-99
And the claim line number 2

When I update the reserved claim line with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimLineTest.json

Then the HTTP status code is 404

Scenario: #3 - Updating a non-existent ClaimLine returns 404.
Given the claim key 100049664-00
And the claim line number 99

When I initialize the claim with default values
And I update the reserved claim line with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/NonExistantClaimLineTest.json

Then the HTTP status code is 404

Scenario: #4 - Updating a ClaimLine that does not match the ClaimLine key returns a 400.
Given the claim key 100049664-00
And the claim line number 99

When I initialize the claim with default values
And I update the reserved claim line with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimLineTest.json

Then the HTTP status code is 400
