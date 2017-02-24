Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @skip
@jira AUTH-1231

Scenario: #1 - Updating an existing claim with new data returns a 200.
Given the claim key 100049664-00
And the version is 2.8

When I initialize the claim with default values
And I update the reserved claim with content in com/vsp/claim/preclaim/resources/test/eClaimServices/payload/ClaimTest.json


Then the HTTP status code is 200
And the claim should be:
|contactLensManufacturerCode|contactLensModality	|contactLensTypeCode	|contactLensBoxCount	|
|A							|1M						|C						|8						|