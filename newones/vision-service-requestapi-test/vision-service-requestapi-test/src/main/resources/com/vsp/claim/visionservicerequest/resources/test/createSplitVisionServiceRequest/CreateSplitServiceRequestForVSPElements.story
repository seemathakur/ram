Split service request for Market Product VSP Elements

Narrative:
As a Doctor
I want to Split service request for VSPElements
				 			 
Scenario: #1 - Reserve Exam, then reserve Lens, Frame ContactLens and ContactLensService for 
VSPElements, network 1000. Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.
Meta: @regression
@jira AUTH-1736

Given a key memberPolicyKey of 30042443-0005-853735036
And a key consumerId of 306024689
And a key providerNetwork of 1000
And a key productPackageName of VSPElements
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request


Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

And the service request should be: 
|productPackageName	|  
|VSPElements		| 


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
|VSPElements		|   

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #2 - Reserve Exam and ContactLensService, then reserve Lens, Frame and ContactLens for 
VSPElements, network 1000. Ensure that the first legacy authorization exists.  
Ensure that the second claim has no selected eligible product items, and that there is no second legacy authorization.
Meta: @regression 
@jira AUTH-2133


Given a key memberPolicyKey of 30042443-0005-853735036
And a key consumerId of 306024689
And a key providerNetwork of 1000
And a key productPackageName of VSPElements
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request


Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 


And the service request should be: 
|productPackageName	|  
|VSPElements		|   

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|
And the patient has an outstanding auth for A with services EV as of CURRENT_DATE_MINUS_1

When I create the service request
Then the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				| 
| Frame				|
| ContactLens		|


And the service request should be: 
|productPackageName	|  
|VSPElements		|   

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #3 - Reserve Exam, then reserve Lens, Frame and ContactLens, and ContactLensService for 
VSPElements, network 2000. Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.
Meta: @regression
@jira AUTH-1736

Given a key memberPolicyKey of 30042242-0008-853425036
And a key consumerId of 306024010
And a key providerNetwork of 2000
And a key productPackageName of VSPElements
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request


Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	|  
|VSPElements		|  

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
|VSPElements		|  

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #4 - Reserve Exam and ContactLensService, then reserve Lens, Frame and ContactLens for 
VSPElements, network 2000. Ensure that the first legacy authorization exists, and has the correct
service items.  Also ensure that the first claim has the correct selected eligible product items.
Ensure that the second claim has no selected eligible product items, and that there is no second legacy authorization.
Meta: @regression 
@jira AUTH-2133

Given a key memberPolicyKey of 30042242-0008-853425036
And a key consumerId of 306024010
And a key providerNetwork of 2000
And a key productPackageName of VSPElements
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

And the service request should be: 
|productPackageName	| 
|VSPElements		| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|
And the patient has an outstanding auth for 9 with services EV as of CURRENT_DATE_MINUS_1

When I create the service request
Then the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				|
| Frame				|
| ContactLens		|

And the service request should be: 
|productPackageName	| 
|VSPElements		| 

And the Frame eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #5 - Reserve Exam, then reserve Lens, Frame and ContactLens, and ContactLensService for 
VSPElements, network 4000. Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.
!--If the group population code on the Plan for VSP Elements is "X", BDS will issue the auth with 
!--expiration date = end of month.  Despite this, Product specifies the epiration date = 30 days.  
!--Pending a business decision, either Product or BDS will have to change.  For now, this test
!--serves to document the discrepancy, and to show that our API follows Product as desired.

!-- we will revisit this issue once the change is made.
Meta: @regression
@jira AUTH-1736 @jira AUTH-2594

Given a key memberPolicyKey of 30042506-0004-853545036
And a key consumerId of 306024690
And a key providerNetwork of 4000
And a key productPackageName of VSPElements
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request


Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

And the service request should be:
|productPackageName	| 
|VSPElements		| 

And the GenExam eligibility interval end date is END_OF_CURRENT_MONTH

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
|VSPElements		| 

And the Lens eligibility interval end date is END_OF_CURRENT_MONTH
And the Frame eligibility interval end date is END_OF_CURRENT_MONTH
And the ContactLens eligibility interval end date is END_OF_CURRENT_MONTH

Scenario: #6 - Reserve Exam and ContactLensService, then reserve Lens, Frame and ContactLens for 
VSPElements, network 4000. Ensure that the first legacy authorization exists, and has the correct
service items.  Also ensure that the first claim has the correct selected eligible product items.
Ensure that the second claim has no selected eligible product items, and that there is no second legacy authorization
Meta: @regression
@jira AUTH-2133 @jira AUTH-2594
!--If the group population code on the Plan for VSP Elements is "X", BDS will issue the auth with 
!--expiration date = end of month.  Despite this, Product specifies the epiration date = 30 days.  
!--Pending a business decision, either Product or BDS will have to change.  For now, this test
!--serves to document the discrepancy, and to show that our API follows Product as desired.

!-- we will revisit this issue once the change is made.

Given a key memberPolicyKey of 30042506-0004-853545036
And a key consumerId of 306024690
And a key providerNetwork of 4000
And a key productPackageName of VSPElements
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

And the service request should be:
|productPackageName	| 
|VSPElements		| 

And the GenExam eligibility interval end date is END_OF_CURRENT_MONTH

!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|
And the patient has an outstanding auth for Q with services EV as of CURRENT_DATE_MINUS_1

When I create the service request
Then the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				| 
| Frame				| 
| ContactLens		| 

And the service request should be: 
|productPackageName	| 
|VSPElements		| 

And the Lens eligibility interval end date is END_OF_CURRENT_MONTH
And the Frame eligibility interval end date is END_OF_CURRENT_MONTH
And the ContactLens eligibility interval end date is END_OF_CURRENT_MONTH