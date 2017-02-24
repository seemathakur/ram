Only the office populated on the claim should be able to delete lines from the claim

Narrative:
In order to ensure security of members' information
As a provider
I want to delete claim lines serviced by my office

@Meta: @regression
@jira AUTH-1620
					 
Scenario: 1 - Doctor issues authorization for patient in participating network and deletes a line
Given a claim issued to the provider
And a doctor log on
When I delete the GenExam claim line
Then the HTTP status code is 200

					 
Scenario: 2 - A service location log on successfully deletes a line from a created claim that has no provider information entered.
Given a claim with no service location info
And a doctor log on
When I delete the GenExam claim line

Then the HTTP status code is 200

Scenario: 3 - A service location log on gets a 403 (Permission Denied) error when they delete a line from a created claim that 
has a different service location populated on it.
Given a claim with an alternative service location
And a doctor log on
When I delete the GenExam claim line

Then the HTTP status code is 403

Scenario: 4 - An application log on successfully deletes a line from a claim that has a service location populated.
Given a claim with an alternative service location
And an api log on
When I delete the GenExam claim line

Then the HTTP status code is 200