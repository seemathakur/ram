Create a service request for Market Product Medicaid

Narrative:
As a Doctor
I want to create a service request for Medicaid

Meta: @regression
@jira AUTH-1706
				 			 
Scenario: #1 - Create service request for product package Medicaid. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Meta: @jira AUTH-2594

Given a key memberPolicyKey of 12004200-0001-853515036
And a key consumerId of 306024008
And a key providerNetwork of 50CA
And a key productPackageName of Medicaid
And a list 
| productCatalogKey 	 |
| GenExam				 |
| Lens					 |
| Frame					 |
| ContactLens			 |
| ContactLensService	 |
| OutOfOfficeVisit	 	 |
| VisionTherapyEvaluation|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		 |
| GenExam				 |
| Lens					 |
| Frame					 |
| ContactLens			 |
| ContactLensService	 |
| OutOfOfficeVisit		 |
| VisionTherapyEvaluation|

And the service request should be: 
|productPackageName | 
|Medicaid			| 

And the GenExam eligibility interval end date is END_OF_CURRENT_MONTH
And the Lens eligibility interval end date is END_OF_CURRENT_MONTH
And the Frame eligibility interval end date is END_OF_CURRENT_MONTH
And the ContactLens eligibility interval end date is END_OF_CURRENT_MONTH
And the ContactLensService eligibility interval end date is END_OF_CURRENT_MONTH
And the VisionTherapyEvaluation eligibility interval end date is END_OF_CURRENT_MONTH
And the OutOfOfficeVisit eligibility interval end date is END_OF_CURRENT_MONTH

Scenario: #2 - Create service request for product package PEC(Medicaid). Ensure that the service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12057267-0017-853315036
And a key consumerId of 306024007
And a key providerNetwork of 50CA
And a key productPackageName of PEC
And a list 
| productCatalogKey |
| Examination		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Examination		|  

And the service request should be: 
| productPackageName| 
| PEC				| 

And the Examination eligibility interval end date is CURRENT_DATE+30
