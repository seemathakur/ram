Create split service request for Market Product Exam Plus With Allowance

Narrative:
As a Doctor
I want to create a split service request for AdditionalPair

Meta: @regression
@jira AUTH-1725
				 			 		 
Scenario: #1 - Reserve Lens and frame Frame for  AdditionalPair. Ensure that
the service requests have the correct product items, and that the legacy authorization
exists and has the correct service items.

Given a key memberPolicyKey of 00857001-0110-854115036
And a key consumerId of 306024695
And a key providerNetwork of 1000
And a key productPackageName of AdditionalPair
And a list 
| productCatalogKey |
| Lens				|
| Frame				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|
| Frame				|

And the service request should be: 
|productPackageName | 
|AdditionalPair		| 

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30

Scenario: #2 - Reserve ContactLens and ContactLensService for  AdditionalPair. Ensure that
the service request has the correct product items, and that the legacy authorization
exists and has the correct service items.

Given a key memberPolicyKey of 00857001-0110-854115036
And a key consumerId of 306024695
And a key providerNetwork of 1000
And a key productPackageName of AdditionalPair
And a list 
| productCatalogKey |
| ContactLens		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| ContactLens		|

And the service request should be:
|productPackageName | 
|AdditionalPair		| 

And the ContactLens eligibility interval end date is CURRENT_DATE+30
