Create a service request by Marchon (OON OpenAccess) Provider

Narrative:
As an open access provider
I want to create a service request for ExamOnly.
		 		
Scenario: #1 - Create service request for product package SignatureChoice, as a Marchon (OON OpenAccess) doctor.
Ensure that the resulting service request has the correct product items. Assert that the providerNetworkAccessPoints and any other Provider details are NOT on the service request.
Meta:
@jira AUTH-2596  @jira AUTH-2594

Given an open access provider log on
And a key memberPolicyKey of 30036084-0006-851505036
And a key consumerId of 306128340
And a key providerNetwork of 9000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|

When I create the service request
And I save the authorization number

Then the selected eligible product items should be: 
| productCatalogKey		|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|


And the service request should be: 
| productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId|
| SignatureChoice		| 9000 |

And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30