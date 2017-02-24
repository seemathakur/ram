Create split service request for Market Product Exam Plus

Narrative:
As a Doctor
I want to create a split service request for SafetyEyecareSupplemental

Meta: @regression
@jira AUTH-1724
				 			 
Scenario: #1 - Reserve Exam only, then reserve Lens and Frame and FrameWithSunLensInsert for 
SafetyEyecareSupplemental. Ensure that the service requests have the correct product items, 
and that the legacy authorizations exist and have the correct service items.

Given a key memberPolicyKey of 03315888-0002-853105036
And a key consumerId of 306023930
And a key providerNetwork of 1000
And a key productPackageName of SafetyEyecareSupplemental
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be:  
|productPackageName			|
|SafetyEyecareSupplemental	| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Authorization --!
Given a list 
| productCatalogKey 	|
| Lens					|
| Frame					|
| FrameWithSunLensInsert|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey		|
| Lens					|
| Frame					|
| FrameWithSunLensInsert|

And the service request should be: 
|productPackageName			|  
|SafetyEyecareSupplemental	|   

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the FrameWithSunLensInsert eligibility interval end date is CURRENT_DATE+30
