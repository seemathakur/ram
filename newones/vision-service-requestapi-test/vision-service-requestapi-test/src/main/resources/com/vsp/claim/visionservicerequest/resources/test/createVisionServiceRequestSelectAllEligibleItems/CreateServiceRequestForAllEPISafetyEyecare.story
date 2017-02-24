Create a service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a service request for SafetyEyecare

Meta: @regression
@jira AUTH-1704 @jira AUTH-2594
				 			 
Scenario: #1 - Create service request for product package SafetyEyecare. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12342077-0104-853345036
And a key consumerId of 306023816
And a key providerNetwork of 1000
And a key productPackageName of SafetyEyecare
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
|productPackageName |
|SafetyEyecare		| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
