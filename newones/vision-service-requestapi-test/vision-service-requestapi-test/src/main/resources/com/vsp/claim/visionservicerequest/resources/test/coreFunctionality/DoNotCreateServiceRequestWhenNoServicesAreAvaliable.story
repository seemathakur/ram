Narrative:
As a consumer
I do not want to create a service request when no services are available 
Meta: @regression
@jira AUTH-2133

Scenario: 1 - Do not create service request when no services are available and recieve a 204

Given a key memberPolicyKey of 00857001-0100-916708517
And a key consumerId of 305915526
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

And the patient has an outstanding auth for A with services E as of CURRENT_DATE_MINUS_1

When I create the service request

Then the HTTP status code is 204