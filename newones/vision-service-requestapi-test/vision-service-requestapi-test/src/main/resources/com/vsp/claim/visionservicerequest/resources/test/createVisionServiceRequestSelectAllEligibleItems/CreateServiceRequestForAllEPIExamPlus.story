Create a service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a service request for Exam Plus

Meta: @regression
@jira AUTH-1704 @jira AUTH-2594
				 			 
Scenario: #1 - Create service request for product package ExamOnly (Exam Plus). Ensure that the service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12006950-0001-853095036
And a key consumerId of 306023805
And a key providerNetwork of 1000
And a key productPackageName of ExamOnly
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	| 
| GenExam			| 

Then the service request should be:  
|productPackageName |
|ExamOnly			| 

And the GenExam eligibility interval end date is CURRENT_DATE+30
