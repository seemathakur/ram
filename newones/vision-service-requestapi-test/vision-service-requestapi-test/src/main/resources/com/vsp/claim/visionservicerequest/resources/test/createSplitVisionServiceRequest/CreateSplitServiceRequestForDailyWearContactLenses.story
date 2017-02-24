Create split service request for Market Product Exception Product Packages

Narrative:
As a Doctor
I want to create a split service request for DailyWearContactLenses

Meta: 
@jira AUTH-1734
				 			 
Scenario: #1 - Reserve Exam, then reserve Lens, Frame and ContactLens for 
DailyWearContactLenses(SignaturE). Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.

!-- We issue to signature, and DailyWearContactLenses is the in leiu of --!
Given a key memberPolicyKey of 12098740-0001-853355036
And a key consumerId of 306024012
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

Then the service request should be: 
| productPackageName	| 
| Signature				| 

!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|

When I create the service request

Then the selected eligible product items should be:  
| productCatalogKey	|
| Lens				|
| Frame				|
| ContactLens		|

Then the service request should be:  
| productPackageName| 
| Signature			| 
