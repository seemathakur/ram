Create split service request for Market Product Signature

Narrative:
As a Doctor
I want to create a split service request for Signature - for members with CLEX product

					 			 		 
Scenario: #1 - Reserve Exam and ContactLensService, then reserve Lens, Frame for 
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items. 
The 2nd reservation will fail because of PBEC eligibility lookup.
Meta: @regression
@jira AUTH-1727 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
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
|Signature			|  

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
!-- ContactLens, ContactLensService in lieu of Lens,frame --!
Given a list 
| productCatalogKey |
| Lens				|
| Frame				|

When I create the service request

Then the service request should be: 
|productPackageName	| 
|Signature			| 

And the Frame eligibility interval end date is CURRENT_DATE+30
	
Scenario: #2 - Reserve Exam only, then reserve Lens, Frame ContactLens and ContactLensService for 
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1727 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	|  
|Signature			| 

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
|Signature			|   

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30
			
Scenario: #3 - Reserve Exam, Lens, Frame and ContactLens for
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1727 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
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
|Signature			|  

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the GenExam eligibility interval end date is CURRENT_DATE+30


Scenario: #4 - Reserve Exam, then reserve ContactLens for 
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1727 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	|
|Signature			|

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
!-- Lens in lieu of ContactLens --!
Given a list 
| productCatalogKey |
| ContactLens		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| ContactLens		|

And the service request should be: 
|productPackageName	|   
|Signature			|   

And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #5 - Reserve Exam, then reserve Lens, Frame for 
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1727 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			|

And the service request should be: 
|productPackageName	| 
|Signature			| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
!-- ContactLens in lieu of Frame, Lens --!
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
|Signature			| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30

Scenario: #6 - Reserve Exam, then reserve Lens, FrameWithSunLensInsert for 
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1727 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam           |

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey |
| GenExam           |

And the service request should be: 
|productPackageName	|   
|Signature			| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
!-- ContactLens, ContactLensService in lieu of Frame, Lens --!
Given a list 
| productCatalogKey	|
| Lens				|
| FrameWithSunLensInsert|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey     |
| Lens                  |
| FrameWithSunLensInsert|

And the service request should be: 
|productPackageName	|  
|Signature			|  

And the Lens eligibility interval end date is CURRENT_DATE+30
And the FrameWithSunLensInsert eligibility interval end date is CURRENT_DATE+30

Scenario: #7 - Reserve ContactLens and ContactLensService for
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1727 @jira acptregression
!-- Lens in lieu of ContactLens --!

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
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
|Signature			|  

And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30

Scenario: #8 - Reserve ContactLensService, then reserve ContactLens for 
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
The 2nd reservation will fail because of PBEC eligibility lookup.
Meta: @regression
@jira AUTH-1727 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| ContactLensService|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| ContactLensService|

And the service request should be: 
|productPackageName	|  
|Signature			|  

And the ContactLensService eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey 	|
| ContactLens			|

When I create the service request

Then the service request should be: 
|productPackageName	|  
|Signature			|  

And the ContactLens eligibility interval end date is CURRENT_DATE+30

Scenario: #9 - Reserve Exam, then lens, then frame for 
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
The 3rd reservation will fail because of PBEC eligibility lookup.
Meta: @regression
@jira AUTH-1727 @jira AUTH-2133 @jira acptregression

Given a key memberPolicyKey of 00105558-0001-853455036
And a key consumerId of 306023998
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request


Then the selected eligible product items should be:  
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	|  
|Signature			|   

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
!-- Lens in lieu of ContactLens --!
Given a list 
| productCatalogKey 	|
| Lens			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|
| Lens					|

And the service request should be: 
|productPackageName	|  
|Signature			|  

And the Lens eligibility interval end date is CURRENT_DATE+30

!-- 3rd Reservation --!
Given a list 
| productCatalogKey 	|
| Frame					|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|
| Frame					|

And the service request should be: 
|productPackageName	| 
|Signature			|   

And the Frame eligibility interval end date is CURRENT_DATE+30