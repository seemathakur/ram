Create a service request for Market Product Exam Only

Narrative:
As a Doctor
I want to create a service request for Exam Only

Meta: @regression
@jira AUTH-1705
				 			 
Scenario: #1 - Create service request for product package ExamOnly. Ensure that the service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12180519-0001-858027438
And a key consumerId of 1568871
And a key providerNetwork of 1000
And a key productPackageName of ExamOnly
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be:
| productCatalogKey	|   
| GenExam			|  

And the service request should be: 
|productPackageName |
|ExamOnly			|

And the GenExam eligibility interval end date is CURRENT_DATE+30
