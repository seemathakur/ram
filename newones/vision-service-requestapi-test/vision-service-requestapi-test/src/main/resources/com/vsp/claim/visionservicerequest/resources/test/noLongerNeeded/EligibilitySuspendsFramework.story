Eligibility Suspends Framework

Narrative:
As a Doctor
I want to Eligibility Suspends Framework

!-- this is skipped because invalid address is not a valid scenario to test anymore
Meta: @skip 
@jira AUTH-788
					 			 
Scenario: #1 - Set up with suspend Address and follow the link
Given a key memberPolicyKey of 12154911-0105-851014717
And a key consumerId of 2428422
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I reserve the eligible product items
And the link followed is reservedClaim

Then the claim should be:  
| statusCode | 
| IR |
And the claim errors should be:
| errorNumber |
| PRELIQ0014 |
And the claim lines should be:
| lineNumber | statusCode |
| 1          | IR         |