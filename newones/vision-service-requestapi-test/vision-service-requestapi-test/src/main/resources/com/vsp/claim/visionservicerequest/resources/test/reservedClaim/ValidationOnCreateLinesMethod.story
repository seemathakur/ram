Validation on create lines method

Narrative:
As a VSP employee
I want to ensure that independently creating claim lines enacts all the same procedures as those
which occur when creating an entire claim 
Meta: 
@skip
@jira AUTH-1618
				 			 
Scenario: #1 - Given a reservation for a member with all services eligible, creation of multiple lines 
will be successful, and these lines will have the appropriate fields populated 
(PCK, product package, status code, reservation interval)   

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| GenExam				|

When I create the service request
And I save the service request

And I create reserved claim lines: 
| productCatalogKey |
| Lens				|
| Frame				| 

Then the HTTP status code is 200
And the claim lines should be:
|lineNumber	|productCatalogKey	| statusCode|
|2			|Lens				| RS		|
|3			|Frame				| RS		|

And the Lens reservation interval start date is CURRENT_DATE
And the Lens reservation interval end date is CURRENT_DATE+30

And the Frame reservation interval start date is CURRENT_DATE
And the Frame reservation interval end date is CURRENT_DATE+30


Scenario: #2 - When I attempt to create multiple lines, of which the member is eligible for GenExam but
not for Frame, then the GenExam line will be created, but the Frame line will not.  

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| Lens					|
And the patient has an outstanding auth for A with services F as of CURRENT_DATE_MINUS_1

When I create the service request
And I save the service request

And I create reserved claim lines: 
| productCatalogKey |
| Frame				|
| GenExam			|

Then the HTTP status code is 200
And the claim lines should be:
|lineNumber	|productCatalogKey	|statusCode	|
|2			|GenExam			|RS			|

And the GenExam reservation interval start date is CURRENT_DATE
And the GenExam reservation interval end date is CURRENT_DATE+30