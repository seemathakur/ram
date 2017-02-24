Narrative:
As a consumer
I want to have the self links be set properly after the create line operation
Meta: @regression
@jira AUTH-1528

Scenario: 1 - After create line operation, the self link is set properly on the line
Given the claim key 100049664-00

When I initialize the claim with default values
And I create a reserved claim line with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimLineTest.json


Then the claim line should be:
| selfLink.type 				| selfLink.rel 	|
| application/vnd.vsp.claimline | self 			| 