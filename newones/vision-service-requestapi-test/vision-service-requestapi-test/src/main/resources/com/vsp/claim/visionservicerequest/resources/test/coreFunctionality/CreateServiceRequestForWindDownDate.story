Create vision service request to test the Eligibility Effective Date and Wind Down Date (WDD) combinations

Narrative: I want to create a vision service request with various Effective Date and Wind Down Date combinations
		 		
Scenario: #1 - Create service request for product package SignatureChoice with effectiveDate at least 2 days before the WDD (10/31/2016).
Ensure that the resulting service request has the correct product items.
Meta:
@jira AUTH-2924

Given a key memberPolicyKey of 30016772-0001-851414717
And a key consumerId of 303175542
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of 2016-10-29
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|

When I create the service request
And I save the authorization number

Then the selected eligible product items should be: 
| productCatalogKey		|
| GenExam				|
| Lens					|

And the service request should be: 
| productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId|
| SignatureChoice		| 2000 |

And the GenExam eligibility interval end date is 2016-11-28
And the Lens eligibility interval end date is 2016-11-28

Scenario: #2 - Create service request for product package SignatureChoice with effectiveDate within 2 days before the WDD.
Ensure the request fails with 400 (Bad Request).
Meta:
@jira AUTH-2924

Given a key memberPolicyKey of 30016772-0001-851414717
And a key consumerId of 303175542
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of 2016-10-30
And a list 
| productCatalogKey 	|
| Frame					|

When I create the service request
Then the HTTP status code is 400

Scenario: #3 - Create service request for product package SignatureChoice with effectiveDate a day after the WDD.
Ensure the request fails with 400 (Bad Request).
Meta:
@jira AUTH-2924

Given a key memberPolicyKey of 30016772-0001-851414717
And a key consumerId of 303175542
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of 2016-11-01
And a list 
| productCatalogKey 	|
| Frame					|

When I create the service request
Then the HTTP status code is 400

Scenario: #4 - Create service request for product package SignatureChoice with effectiveDate long after the WDD.
Ensure the request fails with 400 (Bad Request).
Meta:
@jira AUTH-2924

Given a key memberPolicyKey of 30016772-0001-851414717
And a key consumerId of 303175542
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of 2016-11-15
And a list 
| productCatalogKey 	|
| Frame					|

When I create the service request
Then the HTTP status code is 400
