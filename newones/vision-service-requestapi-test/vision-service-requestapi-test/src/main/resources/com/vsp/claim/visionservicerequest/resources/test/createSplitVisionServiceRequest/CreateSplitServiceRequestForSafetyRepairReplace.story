Create split service request for Market Product Exception Product Packages

Narrative:
As a Doctor
I want to create a split service request for SafetyRepairReplace

Meta: 
@jira AUTH-1734
				 			 
Scenario: #1 - Reserve Lens, then reserve Frame for 
SafetyRepairReplace. Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.

Given a key memberPolicyKey of 12009774-0005-853375036
And a key consumerId of 306024013
And a key providerNetwork of 1000
And a key productPackageName of SafetyRepairReplace
And a list 
| productCatalogKey |
| Lens				|

When I create the service request

Then the selected eligible product items should be: 
| productPackageName	| 
| SafetyRepairReplace	| 

!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Frame				|

When I create the service request

Then the selected eligible product items should be: 
| productPackageName	|  
| SafetyRepairReplace	| 