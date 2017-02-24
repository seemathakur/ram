Create split service request for Market Product VSP Choice

Narrative:
As a Doctor
I want to create a split service request for VDT

Meta: @regression
@jira AUTH-1727
				 			 
Scenario: #1 - Reserve Exam , then reserve Lens and Frame for 
VDT. Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.

Given a key memberPolicyKey of 12185351-0031-853265036
And a key consumerId of 306024000
And a key providerNetwork of 1000
And a key productPackageName of VDT
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

And the service request should be:
|productPackageName	| 
|VDT				| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Lens				|
| Frame				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				| 
| Frame				| 

And the service request should be: 
|productPackageName	|
|VDT				| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
