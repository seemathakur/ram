Narrative:
As a consumer
I want to create a service request and also issue a legacy authorization
Meta: @regression
@jira AUTH-1943

Scenario: #1 Create a service request for a patient and validate that the legacy authorization was also issued. 
The service request will have the authorization number and the authorization type code populated

Given a key memberPolicyKey of 00857001-0100-851035036
And a key consumerId of 303743747
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey 		|
| GenExam					|
| Lens						|
| Frame						|
| ContactLens				|
| ContactLensService		|
| FrameWithSunLensInsert	|
| RetinalScreening			|

When I create the service request
Then the service request field authorizationNumber should not be empty

Scenario: #2 Create a service request for a patient that is a child dependent 
where member+spouse only coverage is supported. The 
legacy authorization will not issue because of BDS errors. 
Subsequently, the service request will not be created and returns HTTP status 400.

Given a key memberPolicyKey of 12058969-0101-851354717
And a key consumerId of 303175425
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam 			|

When I create the service request
Then the HTTP status code is 400


