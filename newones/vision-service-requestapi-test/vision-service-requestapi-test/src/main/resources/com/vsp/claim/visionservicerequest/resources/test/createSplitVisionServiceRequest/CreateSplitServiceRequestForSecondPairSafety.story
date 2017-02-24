Create split service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a split service request for SecondPairSafety

Meta: @regression
@jira AUTH-1724
				 			 
Scenario: #1 - Reserve Lens only, then reserve Frame for SecondPairSafety. Ensure that the service requests have the correct product items, and that the legacy authorizations exist and have
the correct service items.
Given a key memberPolicyKey of 12009774-0005-853155036
And a key consumerId of 306024026
And a key providerNetwork of 1000
And a key productPackageName of SecondPairSafety
And a list 
| productCatalogKey |
| Lens				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|

And the service request should be: 
|productPackageName	|  
|SecondPairSafety	|   

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
|SecondPairSafety	|  

And the Frame eligibility interval end date is CURRENT_DATE+30
