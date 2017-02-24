Create a service request for Market Product Exception product packages

Narrative:
As a Doctor
I want to create a service request for XPEC

Meta: 
@jira AUTH-1714
				 			 
Scenario: #1 - Create service request for product package XPEC. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 30035650-0020-853385036
And a key consumerId of 306024014
And a key providerNetwork of 50NH
And a key productPackageName of XPEC
And a list 
| productCatalogKey |
| Examination		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Examination		|

And the service request should be:
|productPackageName | 
|XPEC				| 

And the Examination eligibility interval end date is CURRENT_DATE+30
