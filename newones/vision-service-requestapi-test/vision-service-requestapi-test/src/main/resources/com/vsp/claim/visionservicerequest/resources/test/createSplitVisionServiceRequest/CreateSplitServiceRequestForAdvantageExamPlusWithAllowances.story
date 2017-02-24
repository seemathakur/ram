Reservation for Market Product Exam Plus With Allowance

Narrative:
As a Doctor
I want to create a split service request for Advantage ExamPlusWithAllowance
 	
Meta: @regression
@jira AUTH-1725 @jira AUTH-2594
		 		 
Scenario: #1 - Reserve Exam only, then reserve Lens, Frame ContactLens, and ContactLensService for 
Advantage ExamPlusWithAllowance. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Given a key memberPolicyKey of 30016184-0019-853215036
And a key consumerId of 306023944
And a key providerNetwork of 4000
And a key productPackageName of ExamPlusWithAllowance
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be:
|productPackageName		| 
|ExamPlusWithAllowance	| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|
| ContactLensService|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|
| Frame				|
| ContactLens		| 
| ContactLensService|

And the service request should be: 
|productPackageName		|  
|ExamPlusWithAllowance	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30

Scenario: #2 - Reserve Exam only, then reserve Lens and Frame for 
Advantage ExamPlusWithAllowance. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Given a key memberPolicyKey of 30016184-0019-853215036
And a key consumerId of 306023944
And a key providerNetwork of 4000
And a key productPackageName of ExamPlusWithAllowance
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName		| 
|ExamPlusWithAllowance	|  

And the GenExam eligibility interval end date is CURRENT_DATE+30

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
|productPackageName		| 
|ExamPlusWithAllowance	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30

Scenario: #3 - Reserve ContactLensService only, then reserve ContactLens for 
Advantage ExamPlusWithAllowance. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
NOTE: As CLEX is not independently reserve-able in BDS, no auth is issued for just ContactLensService
This client is termed in production and product is likely not correct.
Meta: @skip 

Given a key memberPolicyKey of 30016184-0019-853215036
And a key consumerId of 306023944
And a key providerNetwork of 4000
And a key productPackageName of ExamPlusWithAllowance
And a list 
| productCatalogKey |
| ContactLensService|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| ContactLensService|

And the service request should be: 
|productPackageName		|   
|ExamPlusWithAllowance	|  

And the ContactLensService eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey |
| ContactLens		|
And the patient has an outstanding auth for Y with services CL as of CURRENT_DATE

When I create the service request
Then the HTTP status code is 204