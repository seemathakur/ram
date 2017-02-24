Create a service request for Market Product Signature

Narrative:
As a Doctor
I want to create a service request for Signature

Meta: @regression
@jira AUTH-1708 @jira acptregression
				 			 
Scenario: #1 - Create service request for product package Signature. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of <memberPolicyKey>
And a key consumerId of <consumerId>
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|
|FrameWithSunLensInsert	|
|RetinalScreening		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|   
| GenExam				| 
| Lens					| 
| Frame					| 
| ContactLens			| 
| FrameWithSunLensInsert| 
| RetinalScreening		|  

And the service request should be: 
|productPackageName | 
|Signature			| 

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the FrameWithSunLensInsert eligibility interval end date is CURRENT_DATE+30
And the RetinalScreening eligibility interval end date is CURRENT_DATE+30

!-- Member without CLEX, meaning Cl and CL service will resolve to CL in BDS -->
Examples:
|memberPolicyKey		|consumerId	|
|00857001-0100-853035036|306023996	|
|00857001-0100-853035036|306024685	|
|00857001-0100-853035036|306024686  |
