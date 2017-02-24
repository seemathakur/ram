Create split service request for Market Product Exam Plus With Allowance

Narrative:
As a Doctor
I want to create a split service request for ExamPlusWithAllowance

Meta: @regression
@jira AUTH-1725
				 			 		 
Scenario: #1 - Reserve Exam only, then reserve Lens, Frame ContactLens and ContactLensService for 
ExamPlusWithAllowance. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Given a key memberPolicyKey of 12129119-0002-853185036
And a key consumerId of 306023941
And a key providerNetwork of 1000
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

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|
| Frame				|
| ContactLens		|

And the service request should be:
|productPackageName		| 
|ExamPlusWithAllowance	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #2 - Reserve Exam only, then reserve Lens and Frame for 
ExamPlusWithAllowance. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Given a key memberPolicyKey of 12129119-0002-853185036
And a key consumerId of 306023941
And a key providerNetwork of 1000
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