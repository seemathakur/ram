Call MemberPolicies to populate member/patient info on ReservedClaim

Narrative:
As a Doctor 
I want to Call MemberPolicies to populate member/patient info on ReservedClaim

Meta: @regression  
@jira AUTH-699
					 
Scenario: #1 - Patient has relationToMember of child on asofdate 2015-02-01
!-- Originally added this test to verify adding member with different relationToMember on asOfDate
!-- no need to include this in the regression since it is testing memberpolicies functionality
Meta: @skip

Given a key memberPolicyKey of 30025017-0002-858247868
And a key consumerId of 2418077
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of 2015-02-01
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName | patient.relationToSubscriber | 
| 2418077 | JASON | RESERVE | Child |  

Scenario: #2 - Patient has relationToMember of student on asofdate CURRENT DATE

Given a key memberPolicyKey of 30025017-0002-858247868
And a key consumerId of 2418077
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName | patient.relationToSubscriber |
| 2418077 | JASON | RESERVE | Student | 

Scenario: #3 - Patient does not exist on asofdate, returns HTTP status 404 Not Found
!-- This scenario is skipped because memberpolicies is returning HTTP 500 when the member is not found instead of 404
Meta: @skip

Given a key memberPolicyKey of 30025017-0001-858247868
And a key consumerId of 2418075
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of 2014-07-01
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request
Then the HTTP status code is 404



