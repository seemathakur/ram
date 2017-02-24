Create a service request for Market Product Exception Product Packages

Narrative:
As a Doctor
I want to create a service request for LVCWithExam

Meta: 
@jira AUTH-1714
				 			 
Scenario: #1 - Create service request for product package LVCWithExam. Ensure that the service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12338432-0014-853365036
And a key consumerId of 306023810
And a key providerNetwork of 6001
And a key productPackageName of LVCWithExam
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Examination		|
| CustomLASIKLT		|
| CustomLASIKRT		|
| LASIKLT			|
| LASIKRT			|
| PRKLT				|
| PRKLT				|

And the service request should be: 
|productPackageName | 
|LVCWithExam		| 

And the Examination eligibility interval end date is CURRENT_DATE+30
And the CustomLASIKLT eligibility interval end date is CURRENT_DATE+30
And the CustomLASIKRT eligibility interval end date is CURRENT_DATE+30
And the LASIKLT eligibility interval end date is CURRENT_DATE+30
And the LASIKRT eligibility interval end date is CURRENT_DATE+30
And the PRKLT eligibility interval end date is CURRENT_DATE+30
And the PRKLT eligibility interval end date is CURRENT_DATE+30
