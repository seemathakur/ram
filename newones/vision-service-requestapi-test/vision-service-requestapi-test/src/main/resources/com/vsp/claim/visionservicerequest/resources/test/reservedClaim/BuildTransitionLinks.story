The claim should contain transition links

Narrative:
As a provider when I retrieve a reserved claim
I want to have links on the claim for taking action

@Meta: @regression 
@jira AUTH-634
					 

Scenario: 1 - Retieve a reserved claim
Given a claim with an alternative service location
And an api log on
When the reserved claim is retrieved
Then the HTTP status code is 200
And the list validClaimOperations should contain:
| type | rel | 
| application/vnd.vsp.submissionreceipt | urn://vnd.vsp.rels/submitclaim |
| application/vnd.vsp.claim | urn://vnd.vsp.rels/deleteclaim |




