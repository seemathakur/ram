Do not remove last remaining eligible product item from Vision Service Request

Narrative:
As a Doctor
I want to remove an eligible product item to the Vision Service Request

Meta: @jira AUTH-3093
 			 
Scenario: 1 - Given an authorization issued to GenExam. When I attempt to remove the last remaining service, GenExam
then the service will return an HTTP 400

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| GenExam				|

When I create the service request
And I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 400

Scenario: 2 - Given an authorization issued to GenExam. When I attempt to remove the last remaining service, GenExam
then the service will not remove the GenExam service

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| GenExam				|

When I create the service request
And I delete the selected eligible product item GenExam from the vision service request
And I retrieve the vision service request

Then the selected eligible product items should be: 
| productCatalogKey | 
| GenExam			| 

