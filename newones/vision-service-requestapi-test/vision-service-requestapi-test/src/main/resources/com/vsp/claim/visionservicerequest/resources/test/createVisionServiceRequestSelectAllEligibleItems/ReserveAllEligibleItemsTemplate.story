Create a service request for Market Product Exam Only

Narrative:
As a Doctor
I want to create a service request for Market Product Exam Only

Meta: 
@jira AUTH-1705-template
				 			 
Scenario: #1 - Create service request for product package Exam Only, and ensure that the service request has the correct product items
Given a key memberPolicyKey of 12180519-0001-858027438
And a key consumerId of 1568871
And a key providerNetwork of 1000
And a key productPackageName of ExamOnly
And a list 
| productCatalogKey |
| GenExam			|

When I reserve the eligible product items
And I wait 10 seconds
And I follow the link to the ReservedClaim

Then the selected eligible product items should be: 
|lineNumber | productPackageName	| productCatalogKey	|
| 1         | ExamOnly				| GenExam			|