Eligibility Interval Builder

Narrative:
As a Doctor
I want to Eligibility Interval Builder

Meta: @regression 
@jira AUTH-787 @jira AUTH-2595
				 			 
Scenario: #1 - Reserved all services without an effective date
Given a key memberPolicyKey of 30025017-0002-858247868
And a key consumerId of 2418077
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the issue date is CURRENT_DATE
And the GenExam eligibility interval start date is CURRENT_DATE
And the GenExam eligibility interval end date is CURRENT_DATE+30


Scenario: #2 - Reserved all services with an effective date
Given a key memberPolicyKey of 30025017-0002-858247868
And a key consumerId of 2418077
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE_MINUS_1
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the issue date is CURRENT_DATE
And the GenExam eligibility interval start date is CURRENT_DATE_MINUS_1
And the GenExam eligibility interval end date is CURRENT_DATE+29

Scenario: #4 - Given an effective period on product of 2014-12-31
Meta: @skip
Given a key memberPolicyKey of 12300897-1349-851324717
And a key consumerId of 303175385
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of 2014-12-20
And a list 
| productCatalogKey |
| Lens			    |
| Frame             |

When I create the service request

Then the issue date is CURRENT_DATE

And the Lens eligibility interval start date is 2014-12-20
And the Lens eligibility interval end date is 2014-12-31

And the Frame eligibility interval start date is 2014-12-20
And the Frame eligibility interval end date is 2014-12-31

Scenario: #5 - Given an elapsed days was null (not 0) and the auth type was not null and was end of month
!-- This test case is no longer valid because we do not issue the authorization based on productItemAuthorization code
Meta: @skip
Given a key memberPolicyKey of 12012021-0004-851394717
And a key consumerId of 303175501
And a key providerNetwork of 1000
And a key productPackageName of ExamOnly
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the GenExam eligibility interval start date is CURRENT_DATE
And the GenExam eligibility interval end date is CURRENT_DATE+30
And the issue date is CURRENT_DATE