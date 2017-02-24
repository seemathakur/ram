Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @regression
@jira AUTH-1216

Scenario: 1 - Retieve a reserved claim and validate that it has a link to create the lines, and that the lines have self links.
Given a claim with an alternative service location
And an api log on
When the reserved claim is retrieved
Then the HTTP status code is 200
And the list validClaimOperations should contain:
| type | rel | 
| application/vnd.vsp.claimlines | urn://vnd.vsp.rels/createlines |
And the list claimLines should contain:
| selfLink.type | selfLink.rel |
| application/vnd.vsp.claimline | self | 