Create a service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a service request for DEP

Meta: @regression
@jira AUTH-1704
				 			 
Scenario: #1 - Create service request for product package DEP. Ensure that the service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
!-- Product package changed and no longer has DEP in it - 01/11/2017
Meta: @skip

Given a key memberPolicyKey of 00101073-0003-853125036
And a key consumerId of 306023813
And a key providerNetwork of 1000
And a key productPackageName of DEP
And a list 
| productCatalogKey |
| Examination		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Examination		|

And the service request should be: 
|productPackageName | 
|DEP				|  

And the Examination eligibility interval end date is CURRENT_DATE+30
