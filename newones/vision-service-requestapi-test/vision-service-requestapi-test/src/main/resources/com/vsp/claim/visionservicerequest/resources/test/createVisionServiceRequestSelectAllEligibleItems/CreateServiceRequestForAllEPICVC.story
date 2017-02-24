Create a service request for Market Product Exam Only

Narrative:
As a Doctor
I want to create a service request for CVC

Meta: @regression
@jira AUTH-1705
				 			 
Scenario: #1 - Create service request for product package CVC. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12021314-0018-853195036
And a key consumerId of 306023808
And a key providerNetwork of 1000
And a key productPackageName of ComputerVisionCarePlan
And a list 
| productCatalogKey 		|
| GenExam					|
| Lens						|
| Frame						|
| VisionTherapyEvaluation	|
| VisionTherapySessions		|

When I create the service request

Then the selected eligible product items should be:  
| productCatalogKey			|
| GenExam					|
| Lens						|
| Frame						|
| VisionTherapyEvaluation	|
| VisionTherapySessions		|

And the service request should be: 
| productPackageName	| 
|ComputerVisionCarePlan | 

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the VisionTherapyEvaluation eligibility interval end date is CURRENT_DATE+30
And the VisionTherapySessions eligibility interval end date is CURRENT_DATE+30
