Create split service request for Market Product VSP Savings Pass

Narrative:
As a Doctor
I want to create a split service request for VSPVisionSavingsPass

Meta: @regression
@jira AUTH-1729
				 			 
Scenario: #1 - Reserve Exam, then reserve Lens, Frame, ContactLens, ContactLensService, and
RetinalScreening for VSPVisionSavingsPass. Ensure that the service request has the correct 
product items, and that the legacy authorization exists and has the correct service items.

Given a key memberPolicyKey of 12590546-0001-853285036
And a key consumerId of 306024004
And a key providerNetwork of 2000
And a key productPackageName of VSPVisionSavingsPass
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be:  
| productCatalogKey	|  
| GenExam			| 

And the service request should be: 
|productPackageName		|   
|VSPVisionSavingsPass	|  

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|
| RetinalScreening	|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				| 
| Frame				| 
| ContactLens		| 
| RetinalScreening  | 

And the service request should be: 
|productPackageName		| 
|VSPVisionSavingsPass	|  

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the RetinalScreening eligibility interval end date is CURRENT_DATE+30
