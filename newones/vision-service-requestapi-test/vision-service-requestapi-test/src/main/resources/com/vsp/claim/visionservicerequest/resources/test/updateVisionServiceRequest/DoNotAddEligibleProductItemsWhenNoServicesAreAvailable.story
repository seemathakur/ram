Narrative:
As a consumer
I do not want to add eligible items to a vision service request when no services are available 
Meta: 
@jira AUTH-2380

Scenario: 1 - Given an existing reservation for Frame and a patient not eligible for GenExam services when a user attempts
to add a GenExam to the Vision Service Request then the service will return an HTTP 204

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| Frame					|

And the patient has an outstanding auth for A with services E as of CURRENT_DATE

When I create the service request
And I add the selected eligible product items to the vision service request: 
| productCatalogKey |  
| GenExam			|

Then the HTTP status code is 204


Scenario: 2 - Given an existing reservation for Frame when a user attempts
to add no eligible product items to the Vision Service Request then the service will return an HTTP 204

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| Frame				|

When I create the service request
And I add the selected eligible product items to the vision service request: 
|productCatalogKey|


Then the HTTP status code is 204
