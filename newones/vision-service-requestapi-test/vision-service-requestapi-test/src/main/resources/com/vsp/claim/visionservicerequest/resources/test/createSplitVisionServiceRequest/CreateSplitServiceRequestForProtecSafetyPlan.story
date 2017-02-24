Create split service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a split service request for ProtecSafetyPlan


				 			 
Scenario: #1 - Reserve Exam, then reserve Frame and Lens for ProtecSafetyPlan. Ensure that
the service requests have the correct product items, and that the legacy authorizations 
exist and have the correct service items.
Meta: @regression
@jira AUTH-1724

!-- Plan does not have an Exam service category so no authorization can be issued

Given a key memberPolicyKey of 30016265-0015-853175036
And a key consumerId of 306023934
And a key providerNetwork of 1000
And a key productPackageName of ProtecSafetyPlan
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request
Then the HTTP status code is 400

Scenario: #2 - Reserve Frame and Lens for ProtecSafetyPlan. Ensure that
the service requests have the correct product items, and that the legacy authorizations 
exist and have the correct service items.
Meta: @regression
@jira AUTH-1724

Given a key memberPolicyKey of 30016265-0015-853175036
And a key consumerId of 306023934
And a key providerNetwork of 1000
And a key productPackageName of ProtecSafetyPlan
And a list 
| productCatalogKey |
| Lens				|
| Frame				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|
| Frame				|

And the service request should be: 
|productPackageName	| 
|ProtecSafetyPlan	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
