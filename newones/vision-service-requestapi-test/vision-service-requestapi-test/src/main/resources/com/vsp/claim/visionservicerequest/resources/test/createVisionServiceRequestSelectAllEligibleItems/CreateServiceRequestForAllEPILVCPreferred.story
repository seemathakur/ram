Create a service request for Market Product Exam Only

Narrative:
As a Doctor
I want to create a service request for LVC Preferred

Meta: @regression
@jira AUTH-1705
				 			 
Scenario: #1 - Create service request for product package LVC Preferred. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 00107506-0005-853065036
And a key consumerId of 306023810
And a key providerNetwork of 6001
And a key productPackageName of LVCPreferred
And a list 
| productCatalogKey |
| Examination		|
| CustomLASIKLT		|
| CustomLASIKRT		|
| LASIKLT			|
| LASIKRT			|
| PRKLT				|
| PRKRT				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Examination		| 
| CustomLASIKLT		| 
| CustomLASIKRT		| 
| LASIKLT			|
| LASIKRT			|
| PRKLT				|
| PRKRT				|

And the service request should be: 
|productPackageName | 
|LVCPreferred		| 

And the Examination eligibility interval end date is CURRENT_DATE+30
And the CustomLASIKLT eligibility interval end date is CURRENT_DATE+30
And the CustomLASIKRT eligibility interval end date is CURRENT_DATE+30
And the LASIKLT eligibility interval end date is CURRENT_DATE+30
And the LASIKRT eligibility interval end date is CURRENT_DATE+30
And the PRKLT eligibility interval end date is CURRENT_DATE+30
And the PRKRT eligibility interval end date is CURRENT_DATE+30
