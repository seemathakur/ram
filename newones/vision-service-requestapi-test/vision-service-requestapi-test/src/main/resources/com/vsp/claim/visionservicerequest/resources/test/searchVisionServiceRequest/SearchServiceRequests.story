Search Vision Service Requests by client id + division id + subscriber id + consumer id

Narrative:
As a 2020Source
I want to search service requests.
	 		
Scenario: #1 - Search vision service requests from CLM 2342T, CLM2343T tables 
by clientId (membr_group_id), divisionId (membr_group_div), subscriberId (membr_id) and consumerId
Assert that the claim records have the correct column values.  @jira AUTH-2812
Meta: @jira AUTH-2912 @jira AUTH-2812

Given a MetLife Vision provider log on
And a home url
When the link followed with parameters is visionservicerequests:
|name		|value|
|clientId	|00857001|
|divisionId	|0100|
|policyId	|916858546|
|consumerId	|303175358|

Then the HTTP status code is 200
And the service requests list size should be 6
And the service requests should be: 
|patient.memberPolicyKey.clientId 	|patient.memberPolicyKey.divisionId	|patient.memberPolicyKey.policyId	|patient.consumerId	|
|00857001							|0100								|916858546							|303175358			|

And the service requests should be: 
| self.rel 	| self.type |
| self		| application/vnd.vsp.visionservicerequest |

And the search results have a self link populated on each result

Scenario: #2 - Search vision service requests from CLM 2342T, CLM2343T tables 
by clientId (membr_group_id), divisionId (membr_group_div), subscriberId (membr_id) and consumerId
Assert that no claims exist, when the search criteria do not match.
Meta:
@jira AUTH-2812

Given a MetLife Vision provider log on
And a home url
When the link followed with parameters is visionservicerequests:
|name		|value|
|clientId	|00857000|
|divisionId	|0100|
|policyId	|916858546|
|consumerId	|303175358|

Then the HTTP status code is 200
And the service requests list size should be 0

Scenario: #3 - Search vision service requests from CLM 2342T, CLM2343T tables 
by an invalid clientId (membr_group_id), and correct divisionId (membr_group_div), subscriberId (membr_id) and consumerId
Assert that HTTP return code is 400 (Bad Request), when the search criteria is invalid.
Meta:
@jira AUTH-2812

Given a MetLife Vision provider log on
And a home url
When the link followed with parameters is visionservicerequests:
|name		|value|
|clientId	|0085700100|
|divisionId	|0100|
|policyId	|916858546|
|consumerId	|303175358|

Then the HTTP status code is 400
