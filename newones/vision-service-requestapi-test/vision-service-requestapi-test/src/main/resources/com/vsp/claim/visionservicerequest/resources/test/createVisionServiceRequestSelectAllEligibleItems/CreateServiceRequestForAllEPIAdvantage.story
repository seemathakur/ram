Create a service request for Market Product Advantage Plan

Narrative:
As a Doctor
I want to create a service request for Advantage

Meta: @regression
@jira AUTH-1710
				 			 
Scenario: #1 - Create a service request product package Advantage. 
Ensure that the service request has the correct product items, 
and that the legacy authorization exists and has the correct 
service items.

Given a key memberPolicyKey of 30041570-0007-853305036
And a key consumerId of 306024006
And a key providerNetwork of 4000
And a key productPackageName of Advantage
And a list 
| productCatalogKey |
| GenExam			|
| Lens				|
| Frame				|
| ContactLens		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 
| Lens				| 
| Frame				| 
| ContactLens		| 

And the service request should be: 
| productPackageName| 
| Advantage 		| 

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30