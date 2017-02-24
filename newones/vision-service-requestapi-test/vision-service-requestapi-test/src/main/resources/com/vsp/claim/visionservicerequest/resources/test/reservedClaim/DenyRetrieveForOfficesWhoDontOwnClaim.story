Only the office populated on the claim should be able to retrieve the claim

Narrative:
In order to ensure security of members' information
As a provider
I want to retrieve claims serviced by my office

@Meta: @regression
@jira AUTH-1015
					 
!-- AC 1 - A service location log in creates a claim and successfully retrieves the claim.
!-- Tested by regression "AddProviderInformationToCreatedReservedClaim.story"
					 
Scenario: 1 - A service location log on successfully retrieves a created claim that has no provider information entered.
Given a claim with no service location info
And a doctor log on
When the reserved claim is retrieved
Then the HTTP status code is 200
And the claim should be:
| statusCode |
| RS         |

Scenario: 2 - A service location log on gets a 403 (Permission Denied) error when they retrieve a created claim that 
has a different service location populated on it.
Given a claim with an alternative service location
And a doctor log on
When the reserved claim is retrieved
Then the HTTP status code is 403

Scenario: 3 - An application log on successfully retrieves a claim that has a service location populated.
Given a claim with an alternative service location
And an api log on
When the reserved claim is retrieved
Then the HTTP status code is 200
And the claim should be:
| statusCode |
| RS         |