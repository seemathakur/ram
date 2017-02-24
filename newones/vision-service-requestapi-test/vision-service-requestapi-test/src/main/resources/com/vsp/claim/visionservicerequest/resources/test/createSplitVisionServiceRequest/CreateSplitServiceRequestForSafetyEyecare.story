Create split service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a split service request for SafetyEyecare

Meta: @regression
@jira AUTH-1724, @jira AUTH-2594
				 			 
Scenario: #1 - Reserve Lens only, then reserve Frame for SafetyEyecare. Ensure that the service requests have the correct product items, and that the legacy authorizations exist and have
the correct service items.
Given a key memberPolicyKey of 12342077-0104-853345036
And a key consumerId of 306023816
And a key providerNetwork of 1000
And a key productPackageName of SafetyEyecare
And a list 
| productCatalogKey |
| Lens				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|

And the service request should be: 
|productPackageName	|  
|SafetyEyecare		| 

And the Lens eligibility interval end date is CURRENT_DATE+30

!-- 2nd Authorization --!
Given a list 
| productCatalogKey |
| Frame				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Frame				|

And the service request should be: 
|productPackageName	| 
|SafetyEyecare		|   

And the Frame eligibility interval end date is CURRENT_DATE+30
