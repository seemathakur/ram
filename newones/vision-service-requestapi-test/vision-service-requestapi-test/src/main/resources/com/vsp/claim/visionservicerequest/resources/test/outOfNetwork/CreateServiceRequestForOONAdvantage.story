Create a service request for Market Product Advantage Plan

Narrative:
As a Doctor
I want to create a service request for Advantage

Meta: 
@jira AUTH-2590
				 			 
Scenario: #1 - Create service request for product package Advantage. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.

Given an open access provider log on
And a key memberPolicyKey of 30041570-0007-853305036
And a key consumerId of 306024006
And a key providerNetwork of 9000
And a key productPackageName of Advantage
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
| productPackageName| providerNetworkAccessPoint.providerNetworkKey.networkId |
| Advantage 		|  9000													  |

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30

And the service request field authorizationNumber should not be empty
And the service request field providerKey.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty
