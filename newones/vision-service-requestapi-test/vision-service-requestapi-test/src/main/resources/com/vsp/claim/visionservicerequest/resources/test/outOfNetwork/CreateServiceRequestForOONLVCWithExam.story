Create a service request for LVC with Exam

Narrative:
As a Doctor
I want to create a service request for LVC with Exam

Meta: 
@jira AUTH-2590
				 			 
Scenario: #1 - Create service request for product package LVC with Exam. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given an open access provider log on
And a key memberPolicyKey of 12338432-0014-851204717
And a key consumerId of 306244089
And a key providerNetwork of 9000
And a key productPackageName of LVCWithExam
And a list 
| productCatalogKey |
| Examination		|
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| Examination		| 
| GenExam			|

And the service request should be: 
|productPackageName | providerNetworkAccessPoint.providerNetworkKey.networkId |
|LVCWithExam		|  9000													  |

And the Examination eligibility interval end date is CURRENT_DATE+30
And the GenExam eligibility interval end date is CURRENT_DATE+30

And the service request field authorizationNumber should not be empty
And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty