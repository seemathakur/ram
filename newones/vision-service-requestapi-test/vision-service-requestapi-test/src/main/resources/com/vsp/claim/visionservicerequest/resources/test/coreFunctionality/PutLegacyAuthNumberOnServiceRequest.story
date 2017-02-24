Put legacy auth # on reserved claim

Narrative:
As a Doctor
I want to Put legacy auth # on reserved claim

Meta:
@jira AUTH-864
Scenario: #1 - For Exam Only claim, legacy auth number must be on reserved claim
Given a key memberPolicyKey of 12180519-0001-858027438
And a key consumerId of 1568871
And a key providerNetwork of 1000
And a key productPackageName of ExamOnly
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the service request field authorizationNumber should not be empty

