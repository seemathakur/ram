Search Reserved Claims by client id + division id + subscriber id + consumer id

Narrative:
As a 2020Source
I want to search reserved claims.

!-- /reservedclaims?clientId=""&divisionId=""&policyId=""&consumerId=""
!-- MEMBR_GROUP_ID	MEMBR_GROUP_DIV	MEMBR_ID	CONSUMER_ID
!-- 00857001		0100			851314717	303175357
	 		
Scenario: #1 - Search reserved claims from CLM 2342T, CLM2343T tables 
by clientId (membr_group_id), divisionId (membr_group_div), subscriberId (membr_id) and consumerId
Assert that the claim record has the correct column values. 
Meta:
@jira AUTH-2667

Given a key clientId of 00857001
And a key divisionId of 0100
And a key policyId of 851314717
And a key consumerId of 303175357

When I search the reserved claims

Then the HTTP status code is 200
And the claims list size should be 5
And the claims should be: 
|patient.memberPolicyKey.clientId 	|patient.memberPolicyKey.divisionId	|patient.memberPolicyKey.policyId	|patient.consumerId	|
|00857001							|0100								|851314717							|303175357			|


Scenario: #2 - Search reserved claims from CLM 2342T, CLM2343T tables 
by clientId (membr_group_id), divisionId (membr_group_div), subscriberId (membr_id) and consumerId
Assert that no claims exist, when the search criteria do not match.
Meta:
@jira AUTH-2667

Given a key clientId of 00857000
And a key divisionId of 0100
And a key policyId of 851314717
And a key consumerId of 303175357

When I search the reserved claims

Then the HTTP status code is 200
And the claims list size should be 0

Scenario: #3 - Search reserved claims from CLM 2342T, CLM2343T tables 
by an invalid clientId (membr_group_id), and correct divisionId (membr_group_div), subscriberId (membr_id) and consumerId
Assert that HTTP return code is 400 (Bad Request).
Meta:
@jira AUTH-2667

Given a key clientId of 0085700100
And a key divisionId of 0100
And a key policyId of 851314717
And a key consumerId of 303175357

When I search the reserved claims

Then the HTTP status code is 400
