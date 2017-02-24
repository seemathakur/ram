Split service request for Market Product VSP Essentials Plan

Narrative:
As a Doctor
I want to Split service request for VSPEssentialsPlan

Meta: @regression
@jira AUTH-1730
				 			 
Scenario: #1 - Reserve Exam, then reserve Lens, Frame and ContactLens for 
VSPEssentialsPlan. Ensure that the resulting service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.

Given a key memberPolicyKey of 30041967-0001-853955036
And a key consumerId of 306024005
And a key providerNetwork of 4000
And a key productPackageName of VSPEssentialsPlan
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request


Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

And the service request should be:
|productPackageName	| 
|VSPEssentialsPlan	| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

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

And the service request should be: 
|productPackageName	|  
|VSPEssentialsPlan	|  

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30