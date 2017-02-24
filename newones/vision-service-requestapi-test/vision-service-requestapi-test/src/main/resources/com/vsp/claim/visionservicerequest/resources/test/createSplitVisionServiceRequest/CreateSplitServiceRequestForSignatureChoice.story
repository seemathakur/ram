Create split service request for Market Product VSP Choice

Narrative:
As a Doctor
I want to create a split service request for SignatureChoice

				
!-- Scenarios for member WITH CLEX--!				 			 		 
Scenario: #1 - Reserve Exam and ContactLensService, then reserve Lens, Frame and ContactLens for 
SignatureChoice. Ensure that the first claim has the correct product items,
and that the first legacy authorization exists and has the correct service items.
Ensure that the second legacy authorization is not created. 
Meta: @jira AUTH-2133 @jira acptregression
!-- The second reservation will fail because of the in lieu of's on ContactLens.  
!-- While ContactLens, Lens, and Frame are not on the first Auth, they are not displayed as
!-- eligible items by PBEC.  

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|
| ContactLensService|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|
| ContactLensService|

And the service request should be: 
|productPackageName	|   
|SignatureChoice	| 

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|
And the patient has an outstanding auth for 9 with services LFC as of CURRENT_DATE

When I create the service request
Then the HTTP status code is 204

Scenario: #2 - Reserve Exam only, then reserve Lens, Frame ContactLens and ContactLensService for 
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be:
|productPackageName	| 
|SignatureChoice	| 

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
|productPackageName	| 
|SignatureChoice	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30

Scenario: #3 - Reserve Exam, Lens, Frame and ContactLens for
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|
| Lens				|
| Frame				|
| ContactLens		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|
| Lens				|
| Frame				|
| ContactLens		|
 
And the service request should be:  
|productPackageName	| 
|SignatureChoice	| 

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #4 - Reserve Exam, then reserve ContactLens for 
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	|  
|SignatureChoice	|  

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey |
| ContactLens		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| ContactLens		|

And the service request should be:
|productPackageName	|
|SignatureChoice	| 

And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #5 - Reserve Exam, then reserve Lens, Frame for 
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|


When I create the service request

Then the selected eligible product items should be:  
| productCatalogKey	| 
| GenExam			|

And the service request should be:
|productPackageName	| 
|SignatureChoice	| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey 	|
| Lens					|
| Frame					|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|
| Lens					|
| Frame					|

And the service request should be: 
|productPackageName	|  
|SignatureChoice	|  

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30

Scenario: #6 - Reserve ContactLens and ContactLensService for
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| ContactLens		|
| ContactLensService|


When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| ContactLens		|
| ContactLensService|

And the service request should be: 
|productPackageName	|  
|SignatureChoice	|  

And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30

Scenario: #7 - Reserve ContactLensService, then reserve ContactLens for 
SignatureChoice. Ensure that the first claim has the correct product items,
and that the first legacy authorization exists and has the correct service items.
Ensure that the second legacy authorization is not created. 
Meta: @jira AUTH-2133 @jira acptregression
!-- The second reservation will fail because of the in lieu of's on ContactLens.  
!-- While ContactLens, Lens, and Frame are not on the first Auth, they are not displayed as
!-- eligible items by PBEC.  

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| ContactLensService|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| ContactLensService|

And the service request should be:
|productPackageName	| 
|SignatureChoice	| 

And the ContactLensService eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey 	|
| ContactLens			|
And the patient has an outstanding auth for 9 with services CL as of CURRENT_DATE

When I create the service request
Then the HTTP status code is 204

Scenario: #8 - Reserve Exam, then Frame, then Lens for 
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Given a key memberPolicyKey of 12130594-0006-853225036
And a key consumerId of 306023947
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be:
|productPackageName	|
|SignatureChoice	|

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey 	|
| Frame					|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|
| Frame					|

And the service request should be: 
|productPackageName	|  
|SignatureChoice	|  

And the Frame eligibility interval end date is CURRENT_DATE+30

!-- 3rd Reservation --!
Given a list 
| productCatalogKey 	|
| Lens					|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|
| Lens					|

And the service request should be: 
|productPackageName	|   
|SignatureChoice	|  

And the Lens eligibility interval end date is CURRENT_DATE+30

!-- Scenarios for member WITHOUT CLEX--!	
Scenario: #9 - Reserve Exam and ContactLensService, then reserve Lens, Frame and ContactLens for 
SignatureChoice. Ensure that the first claim has the correct product items,
and that the first legacy authorization exists and has the correct service items.
Ensure that the second legacy authorization is not created. 

Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12024990-0162-853475036
And a key consumerId of 306023970
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	| 
|SignatureChoice	|  

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|

When I create the service request

Then the service request should be: 
|productPackageName	|  
|SignatureChoice	| 

And the selected eligible product items should be: 
| productCatalogKey | 
| Lens				|
| Frame				|
| ContactLens		|  


Scenario: #10 Reserve Exam only, then reserve Lens, Frame ContactLens and ContactLensService for 
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12024990-0162-853475036
And a key consumerId of 306023970
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	|  
|SignatureChoice	|  

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
|SignatureChoice	| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #11 - Reserve ContactLens and ContactLensService for
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Meta: @regression
@jira AUTH-1726 @jira acptregression

Given a key memberPolicyKey of 12024990-0162-853475036
And a key consumerId of 306023970
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| ContactLens		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| ContactLens		|

And the service request should be: 
|productPackageName	|  
|SignatureChoice	|   

And the ContactLens eligibility interval end date is CURRENT_DATE+30