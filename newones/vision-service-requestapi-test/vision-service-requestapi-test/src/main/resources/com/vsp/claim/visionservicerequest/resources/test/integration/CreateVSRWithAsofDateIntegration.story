Create VSR with effective date

Meta: @jira AUTH-3182

!-- We need a story on PBEC backlog to build our link with the effective date query param. AUTH-3182 is the placeholder
	 		
Scenario: 2 Search member policies, calculate eligibility and then issue a VSR with an asofdate 

Given a home url
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|
| ContactLensService	|


When the link followed with parameters is memberpolicies:
|name		|value |
|policyid	|851505036|
|asofdate   | 2017-01-05 | 
And the link followed is [0].self
And the link followed is memberships.[0].eligibility
And the link networks[0].packages[0].createVisionServiceRequest is followed to create the vision service request

Then the HTTP status code is 200

And the GenExam eligibility interval start date is 2017-01-05
And the Lens eligibility interval start date is 2017-01-05
And the Frame eligibility interval start date is 2017-01-05
And the ContactLens eligibility interval start date is 2017-01-05
And the ContactLensService eligibility interval start date is 2017-01-05