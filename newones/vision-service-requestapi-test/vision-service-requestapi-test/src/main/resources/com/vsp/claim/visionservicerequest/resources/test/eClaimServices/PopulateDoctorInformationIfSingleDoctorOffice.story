Narrative:
As a provider
I want to have the provider information be prepopulated if I am the only provider at the service location
Meta: @regression
@jira AUTH-1357

Scenario: #1 - Provider information is pre-populated if there is only one provider at the service location.
Given a log on by the only doctor associated with a service location
And a key memberPolicyKey of 00857001-0100-858017570
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE

And a list 
| productCatalogKey |
| GenExam			|	

When I create the service request

Then the service request should be: 
|providerNetworkAccessPoint.doctor.key.doctorId |providerNetworkAccessPoint.doctor.name.firstName	|providerNetworkAccessPoint.doctor.name.lastName | 
|570926588										|CAMERON											|YEE											 |

And the service request should be:  
|providerNetworkAccessPoint.doctor.name.middle|providerNetworkAccessPoint.doctor.degreeCode	| providerNetworkAccessPoint.doctor.nationalProviderId	|  
|T											  |OD											| 1477689446											|


Scenario: #2 - Doctor information is not pre-populated if there is more than one doctor at the service location, 
Given a doctor log on
And a key memberPolicyKey of 00857001-0100-858017570
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE

And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the service request field providerNetworkAccessPoint.doctor.key.doctorId should be empty

And the service request field providerNetworkAccessPoint.doctor.name.firstName should be empty

And the service request field providerNetworkAccessPoint.doctor.name.lastName should be empty

And the service request field providerNetworkAccessPoint.doctor.name.middle should be empty

And the service request field providerNetworkAccessPoint.doctor.degreeCode should be empty

And the claim field providerNetworkAccessPoint.doctor.nationalProviderId should be empty

