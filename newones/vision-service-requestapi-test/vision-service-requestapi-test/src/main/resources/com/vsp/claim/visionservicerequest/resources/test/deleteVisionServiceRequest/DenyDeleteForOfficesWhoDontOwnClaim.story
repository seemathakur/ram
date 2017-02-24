Only the office populated on the claim should be able to delete/abandon the claim

Narrative:
In order to ensure security of members' information
As a provider
I want to make sure only authorized provider or personel able to delete/abandon claims serviced by my office

Meta: @regression
@jira AUTH-1017 @jira AUTH-2745 @jira acptregression
	 
Scenario: 1 - A service provider log on successfully delete a claim issued to the same provider
Given a claim issued to the provider
And a doctor log on

When the reserved claim is deleted by following the self link on the claim

Then the HTTP status code is 200
				 
Scenario: 2 - A service provider log on successfully delete a claim that has no service location information entered.
Given a claim with no service location info
And a doctor log on

When the reserved claim is deleted by following the self link on the claim

Then the HTTP status code is 200

Scenario: 3 - A service provider log on gets a 403 (Permission Denied) error when deleting a created claim that 
has a different service location populated on it.
Given a claim with an alternative service location
And a doctor log on

When the reserved claim is deleted by following the self link on the claim

Then the HTTP status code is 403

Scenario: 4 - An api (not an OAuth office) log on successfully delete a claim that has a service location populated.
Given a claim issued to the provider
And an api log on

When the reserved claim is deleted by following the self link on the claim

Then the HTTP status code is 200