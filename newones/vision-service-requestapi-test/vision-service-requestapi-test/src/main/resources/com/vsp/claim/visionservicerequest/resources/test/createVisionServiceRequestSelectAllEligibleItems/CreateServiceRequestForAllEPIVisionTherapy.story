Create a service request for Market Product VSP Choice Plan

Narrative:
As a Doctor
I want to create a service request for VisionTherapy

Meta: @regression
@jira AUTH-1711-x
				 			 
Scenario: #1 - Create service request for product package VisionTherapy. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 00857001-0100-853855036
And a key consumerId of 306024701
And a key providerNetwork of 1000
And a key productPackageName of VisionTherapy
And a list 
| productCatalogKey 		|
| VisionTherapyEvaluation	|
| VisionTherapySessions		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey			|
| VisionTherapyEvaluation	|
| VisionTherapySessions		|

And the service request should be:
|productPackageName | 
|VisionTherapy		| 

And the VisionTherapyEvaluation eligibility interval end date is CURRENT_DATE+30
And the VisionTherapySessions eligibility interval end date is CURRENT_DATE+30
