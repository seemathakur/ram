Create a service request for Market Product Exam Only

Narrative:
As a Doctor
I want to create a service request for PEC

Meta: @regression
@jira AUTH-1705
				 			 
Scenario: #1 - Create service request for product package PEC. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 00857001-0100-853045036
And a key consumerId of 306023812
And a key providerNetwork of 1000
And a key productPackageName of PEC
And a list 
| productCatalogKey |
| Examination		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Examination		| 

And the service request should be: 
|productPackageName | 
|PEC				| 

And the Examination eligibility interval end date is CURRENT_DATE+30
