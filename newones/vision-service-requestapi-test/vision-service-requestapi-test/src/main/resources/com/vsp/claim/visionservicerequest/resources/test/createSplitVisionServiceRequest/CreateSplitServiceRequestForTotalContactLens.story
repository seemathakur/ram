Create split service request for Market Product VSP Choice Plan

Narrative:
As a Doctor
I want to create a split service request for TotalContactLenses

Meta: 
@jira AUTH-1726-ignore
				 			 
Scenario: #1 - Reserve GenExam, then reserve ContactLens and ContactLensService for TotalContacts
Ensure that the service request has the correct product items, and that the legacy authorization 
exists and has the correct service items.

Given a key memberPolicyKey of 00101119-0002-853245036
And a key consumerId of 306023991
And a key providerNetwork of 1000
And a key productPackageName of TotalContactLenses
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be:
|productPackageName	| 
|TotalContactLenses	| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Authorization --!

Given a key memberPolicyKey of 00101119-0002-853245036
And a key consumerId of 306023991
And a key providerNetwork of 1000
And a key productPackageName of TotalContactLenses
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
|TotalContactLenses	|  

And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30
