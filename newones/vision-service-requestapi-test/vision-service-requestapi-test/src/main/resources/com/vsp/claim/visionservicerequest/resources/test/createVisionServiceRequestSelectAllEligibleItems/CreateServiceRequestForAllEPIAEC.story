Create a service request for VSP Choice Plan
Narrative:
As a Doctor
I want to create a service request for AcuteEyeCare

Meta: @regression
@jira AUTH-1711-erin
				 			 
Scenario: #1 - Create service request for product package AcuteEyeCare. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12264659-0008-853415036
And a key consumerId of 306023978
And a key providerNetwork of CALOP
And a key productPackageName of AcuteEyeCare
And a list 
| productCatalogKey |
| Examination		|

When I create the service request

Then the selected eligible product items should be:  
| productCatalogKey	|
| Examination		|

And the service request should be: 
| productPackageName |
| AcuteEyeCare		 | 

And the Examination eligibility interval end date is CURRENT_DATE+30
