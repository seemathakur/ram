Create a service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a service request for DEPPlus

Meta: @regression
@jira AUTH-1704
				 			 
Scenario: #1 - Create service request for product package DEPPlus. Ensure that the service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12009774-0005-853165036
And a key consumerId of 306023815
And a key providerNetwork of 1000
And a key productPackageName of DEPPlus
And a list 
| productCatalogKey |
| Examination		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Examination		|

And the service request should be:
|productPackageName |
|DEPPlus			| 

And the Examination eligibility interval end date is CURRENT_DATE+30
