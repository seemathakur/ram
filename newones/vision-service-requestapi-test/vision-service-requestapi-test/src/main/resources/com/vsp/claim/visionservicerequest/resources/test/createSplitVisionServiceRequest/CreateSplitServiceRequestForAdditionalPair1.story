Create a service request for Market Product Exception Product Packages

Narrative:
As a Doctor
I want to create a split service request for AdditionalPair1

Meta: 
@jira AUTH-1714
				 			 		 
Scenario: #1 - Reserve Frame only, then reserve Lens for 
AdditionalPair1. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
.
Given a key memberPolicyKey of 12057231-0001-853395036
And a key consumerId of 306024016
And a key providerNetwork of 1000
And a key productPackageName of AdditionalPair1
And a list 
| productCatalogKey |
| Frame				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Frame				|

And the service request should be: 
| productPackageName	|
| AdditionalPair1		| 

!-- 2nd Reservation --!
Given a list 
| productCatalogKey |
| Lens				|

When I create the service request


Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|

And the service request should be: 
| productPackageName	|
| AdditionalPair1		| 