Create a service request for Signature

Narrative:
As a Doctor
I want to create a service request for Signature

Meta: 
@jira AUTH-2590
				 			 
Scenario: #1 - Create service request for product package Signature. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.

Given an open access provider log on
And a key memberPolicyKey of 00101119-0002-853245036
And a key consumerId of 306024697
And a key providerNetwork of 9000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|
| Lens 				|
| Frame				|
| FrameWithSunLensInsert | 

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|
| Lens				|
| Frame				|
| FrameWithSunLensInsert |

And the service request should be: 
|productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId |
|Signature 			|  9000													  |

And the service request field authorizationNumber should not be empty
And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the FrameWithSunLensInsert eligibility interval end date is CURRENT_DATE+30