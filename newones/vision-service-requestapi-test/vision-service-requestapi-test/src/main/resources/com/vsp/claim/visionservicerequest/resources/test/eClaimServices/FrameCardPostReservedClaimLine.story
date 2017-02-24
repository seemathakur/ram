Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @regression
@jira AUTH-1228

Scenario: #1 - Adding a new ClaimLine to an existing claim returns a 200.
Given the claim key 100049664-00

When I initialize the claim with default values
And I create a reserved claim line with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimLineTest.json

Then the HTTP status code is 200
And the claim line should be:
|materialsSuppliedByCode|
|L						|