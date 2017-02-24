Create a service request for Market Product Exam Only

Narrative:
As a Doctor
I want to create a service request for Low Vision

Meta: @regression
@jira AUTH-1705
				 			 
Scenario: #1 - Create service request for product package Low Vision(Signature). Ensure that the service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 00857001-0100-853075036
And a key consumerId of 306023811
And a key providerNetwork of 1000
And a key productPackageName of LowVision
And a list 
| productCatalogKey |
| LowVisionEval		|
| VisualAid			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| LowVisionEval		|
| VisualAid			|

And the service request should be: 
|productPackageName |
|LowVision			| 

And the LowVisionEval eligibility interval end date is CURRENT_DATE+30
And the VisualAid eligibility interval end date is CURRENT_DATE+30
