Create split service request for Market Product Exam Only

Narrative:
As a Doctor
I want to create a split service request for CVC Supplemental

Meta: @regression
@jira AUTH-1723
				 			 
Scenario: #1 - Reserve Exam only, then reserve Lens, Frame, and the vision therapy services 
for CVC Supplemental. Ensure that the service requests have the correct product items, and 
that the legacy authorizations exist and have the correct service items.

Given a key memberPolicyKey of 00857001-0100-853025036
And a key consumerId of 306023809
And a key providerNetwork of 1000
And a key productPackageName of ComputerVisionCarePlanSupplemental
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

And the service request should be: 
|productPackageName					| 
|ComputerVisionCarePlanSupplemental	|   

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Authorization --!
Given a list 
| productCatalogKey 		|
| Lens						|
| Frame						|
| VisionTherapyEvaluation	|
| VisionTherapySessions		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey			|
| Lens						|
| Frame						|
| VisionTherapyEvaluation	|
| VisionTherapySessions		|

And the service request should be:
|productPackageName					| 
|ComputerVisionCarePlanSupplemental	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the VisionTherapyEvaluation eligibility interval end date is CURRENT_DATE+30
And the VisionTherapySessions eligibility interval end date is CURRENT_DATE+30
