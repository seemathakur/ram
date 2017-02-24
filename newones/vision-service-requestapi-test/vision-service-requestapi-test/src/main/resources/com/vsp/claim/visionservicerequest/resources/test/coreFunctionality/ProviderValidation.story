Add provider information to created reserved claim

Narrative:
As a Doctor 
I want to Add provider information to created reserved claim

Meta: @regression 
@jira AUTH-915
					 
Scenario: #1 - Mississippi medicaid doctor tries to issue auth for Califonia medicaid patient 
Given a Mississippi Medicaid doctor
And a key memberPolicyKey of 12004200-0001-851404717 
And a key consumerId of 303175502
And a key providerNetwork of 50CA
And a key productPackageName of Medicaid 

And a key effectiveDate of 2015-04-13
And a list 
| productCatalogKey |
| GenExam			|
| ContactLensService|
| Lens				|
| Frame 			|
| ContactLens		|

When I create the service request

Then the HTTP status code is 404
