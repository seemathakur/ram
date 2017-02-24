Only the office populated on the claim should be able to create lines on the claim

Narrative:
In order to ensure security of members' information
As a provider
I want to create claim lines serviced by my office

@Meta: 
@jira AUTH-1621
					 
Scenario: 1 - Doctor issues authorization for patient in participating network and creates lines successfully
Given a doctor log on
And a key memberPolicyKey of 00857001-0100-858017570
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE

And a list 
| productCatalogKey |
| GenExam			|

When I create the service request
And I create reserved claim lines:
| productCatalogKey |
| Lens 				|
| Frame				| 
Then the HTTP status code is 200

					 
Scenario: 2 - A service location log on successfully creates lines on a claim that has no provider information entered.
Given a claim with no service location info
And a doctor log on
And a key effectiveDate of CURRENT_DATE
When I create reserved claim lines: 
| productCatalogKey |
| Lens 				|
| Frame				| 

Then the HTTP status code is 200

Scenario: 3 - A service location log on gets a 403 (Permission Denied) error when they create lines on a claim that 
has a different service location populated on it.
Given a claim with an alternative service location
And a doctor log on
And a key effectiveDate of CURRENT_DATE
When I create reserved claim lines: 
| productCatalogKey |
| Lens 				|
| Frame				| 

Then the HTTP status code is 403

Scenario: 4 - An application log on successfully creates lines on a claim that has a service location populated.
Given a claim with an alternative service location
And an api log on
And a key effectiveDate of CURRENT_DATE
When I create reserved claim lines: 
| productCatalogKey |
| Lens 				|
| Frame				| 

Then the HTTP status code is 200