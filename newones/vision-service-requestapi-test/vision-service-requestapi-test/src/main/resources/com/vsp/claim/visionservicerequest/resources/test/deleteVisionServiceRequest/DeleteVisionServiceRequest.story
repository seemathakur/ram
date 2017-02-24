Delete Service Request

Narrative:
As a Doctor
I want to delete a Vision service request
		
Meta: @regression
@jira AUTH-2745 @jira acptregression
	 
Scenario: #1a - Delete existing Vision service request
Given a key memberPolicyKey of 00101119-0002-851994717
And a key consumerId of 306474979
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam |

When I create the service request
And I delete the service request
And I retrieve the patient history for the legacy authorization

Then the service request field authorizationNumber should not be empty
And the patient history should be: 
| status	| source |
| DE		| Auth   |

Scenario: #1b Search returns no service requests after service request was deleted 
Given an api log on
And a home url
When the link followed with parameters is visionservicerequests:
|name |value|
|clientId |00101119|
|divisionId |0002|
|policyId |851994717|
|consumerId |306474979|

Then the HTTP status code is 200
And the service requests list size should be 0

Scenario: #2a - Delete existing Vision service request where the legacy authorization has already been deleted 
(when in DE status subsequent delete of the same Vision service request has no effect).
Given a key memberPolicyKey of 00101119-0002-851994717
And a key consumerId of 306474979
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request
And I delete the legacy authorization for the service request
And I delete the service request
And I retrieve the patient history for the legacy authorization

Then the service request field authorizationNumber should not be empty
And the patient history should be: 
| status | source |
| DE 	 | Auth	  |

Scenario: #2b Search returns no service requests after service request was deleted 
Given an api log on
And a home url
When the link followed with parameters is visionservicerequests:
|name |value|
|clientId |00101119|
|divisionId |0002|
|policyId |851994717|
|consumerId |306474979|

Then the HTTP status code is 200
And the service requests list size should be 0

Scenario: #3 Delete existing Vision service request that does not have a legacy authorization on the claim
Given a service request that does not have legacy authorization

When I delete the service request

Then the HTTP status code is 400

Scenario: #4 Delete existing Vision service request for a claim that does not exist
Given a service request that does not exist

When I delete the service request

Then the HTTP status code is 404

Scenario: #5a - Delete existing Vision service request, after it has already been deleted
Given a key memberPolicyKey of 00101119-0002-851994717
And a key consumerId of 306474979
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request
And I delete the service request
And I delete the service request

Then the HTTP status code is 404

Scenario: #5b Search returns no service requests after service request was deleted 
Given an api log on
And a home url
When the link followed with parameters is visionservicerequests:
|name |value|
|clientId |00101119|
|divisionId |0002|
|policyId |851994717|
|consumerId |306474979|

Then the HTTP status code is 200
And the service requests list size should be 0
