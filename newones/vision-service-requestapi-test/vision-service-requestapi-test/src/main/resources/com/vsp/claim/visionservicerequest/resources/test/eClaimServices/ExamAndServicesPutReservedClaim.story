Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @regression
@jira AUTH-1216

Scenario: #1 - Updating an existing claim with new data returns a 200.
Given the claim key 100049664-00

When I initialize the claim with default values
And I update the reserved claim with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimTest.json


Then the HTTP status code is 200
And the claim should be:
|diabetesIndicator|diabeticRetinopathyIndicator|highCholesterolIndicator|hypertensionIndicator|
|true             |true                        |true                    |true                 |

And the claim should be:
|diagnosis.1	|diagnosis.2	|diagnosis.3	|
|201.1			|101.5          |510.5			|

Scenario: #2 - Updating a non-existing claim returns a 404.
Given the claim key 100049664-99

When I update the reserved claim with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/NonExistantClaimTest.json

Then the HTTP status code is 404

Scenario: #3 - Updating a Claim that does not match the ClaimKey returns a 400.
Given the claim key 100049665-00

When I initialize the claim with default values
And I update the reserved claim with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimTest.json

Then the HTTP status code is 400