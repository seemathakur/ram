Create a service request for member + spouse

Meta:
@jira AUTH-919
				 			 
Scenario: #1 - Member is active and Coverage Code is B -  Member + Spouse. Reserve for member
Given a key memberPolicyKey of 12058969-0101-858317868
And a key consumerId of 300002509
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey 	|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

When I create the service request

Then the service request should be: 
|productPackageName	|
|SignatureChoice 	| 

And the selected eligible product items should be: 
| productCatalogKey		|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

Scenario: #2 - Member is active and Coverage Code is B -  Member + Spouse. Reserve for spouse
Given a key memberPolicyKey of 12058969-0101-858317868
And a key consumerId of 300002511
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey 	|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

When I create the service request

Then the service request should be: 
|productPackageName	|
|SignatureChoice 	|

Then the selected eligible product items should be: 
| productCatalogKey		|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

Scenario: #3 - Member is active and Coverage Code is B -  Member + Spouse. Reserve for child, unable to
Create service request

Given a key memberPolicyKey of 12058969-0101-858317868
And a key consumerId of 300002510
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey 	|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

When I create the service request
Then the HTTP status code is 400

Scenario: #4 - Member is active and Coverage Code is B -  Member + Spouse. Reserve for domestic partner
Given a key memberPolicyKey of 12058969-0101-858327868
And a key consumerId of 300002512
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey 	|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

When I create the service request

Then the service request should be:  
| productPackageName	|
| SignatureChoice 		| 

Then the selected eligible product items should be: 
| productCatalogKey		|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|