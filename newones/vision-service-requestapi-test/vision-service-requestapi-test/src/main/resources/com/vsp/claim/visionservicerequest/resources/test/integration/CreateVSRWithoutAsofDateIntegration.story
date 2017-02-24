Narrative:
As a 2020Source
I want to search service requests.

Meta: @jira acptregression
	 		
Scenario: 1 Search member policies, calculate eligibility and then issue a VSR without an asofdate

Given a MetLife Vision provider log on
And a home url
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|
| ContactLensService	|


When the link followed with parameters is memberpolicies:
|name		|value|
|policyid	|851505036|
And the link followed is [0].self
And the link followed is memberships.[0].eligibility
And the link networks[0].packages[0].createVisionServiceRequest is followed to create the vision service request

Then the HTTP status code is 200

And the GenExam eligibility interval start date is CURRENT_DATE
And the Lens eligibility interval start date is CURRENT_DATE
And the Frame eligibility interval start date is CURRENT_DATE
And the ContactLens eligibility interval start date is CURRENT_DATE
And the ContactLensService eligibility interval start date is CURRENT_DATE