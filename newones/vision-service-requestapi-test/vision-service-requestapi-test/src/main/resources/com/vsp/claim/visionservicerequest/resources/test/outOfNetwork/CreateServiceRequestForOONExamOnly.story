Create a service request for Exam Only.

Narrative:
As a Doctor
I want to create a service request for Exam Only

Meta:
@jira AUTH-2590	

Scenario: #1 - Create service request for product package ExamOnly, as a Marchon (OON OpenAccess) doctor.
Ensure that the service request has the correct product items. Assert that the providerNetworkAccessPoints and any other Provider details are NOT on the claim.

Given an open access provider log on
And a key memberPolicyKey of 12180519-0001-858027438
And a key consumerId of 1568871
And a key providerNetwork of 9000
And a key productPackageName of ExamOnly
And a list 
| productCatalogKey 	|
| GenExam				|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|
| GenExam				|

And the service request should be: 
| productPackageName	|providerNetworkAccessPoint.providerNetworkKey.networkId|
| ExamOnly				| 9000 |

And the service request field authorizationNumber should not be empty
And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the GenExam eligibility interval end date is CURRENT_DATE+30