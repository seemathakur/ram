Create split service request for Market Product VSP Choice

Narrative:
As a Doctor
I want to create a split service request for VDTSupplemental

Meta: @regression
@jira AUTH-1727
				 			 
Scenario: #1 - Reserve Exam VisionTherapyEvaluation, and VisionTherapyEvaluation, then reserve 
Lens and Frame for VDTSupplemental. Ensure that the service request has the correct product items,
and that the legacy authorization exists and has the correct service items.

Given a key memberPolicyKey of 12090472-0025-853255036
And a key consumerId of 306024001
And a key providerNetwork of 1000
And a key productPackageName of VDTSupplemental
And a list 
| productCatalogKey 	|
| GenExam				|
|VisionTherapyEvaluation|
|VisionTherapySessions	|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey			| 
| GenExam					| 
| VisionTherapyEvaluation	| 
| VisionTherapySessions		| 

And the service request should be:  
|productPackageName	|   
|VDTSupplemental	|  

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the VisionTherapyEvaluation eligibility interval end date is CURRENT_DATE+30
And the VisionTherapySessions eligibility interval end date is CURRENT_DATE+30

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
|VDTSupplemental	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
