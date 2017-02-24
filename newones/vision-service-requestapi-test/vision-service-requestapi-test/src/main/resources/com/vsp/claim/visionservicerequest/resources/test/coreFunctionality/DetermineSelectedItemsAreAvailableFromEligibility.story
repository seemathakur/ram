Determine if selected items are available from eligibility

Narrative:
As a Doctor
I want to Determine if selected items are available from eligibility

Meta: @regression 
@jira AUTH-747
					 
Scenario: #1 - Create a service request for all services when all eligible product items are AVAILABLE.

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

When I create the service request

Then the HTTP status code is 200

And the selected eligible product items should be:
| productCatalogKey		| 
| GenExam				| 
| Lens			 		| 
| Frame					| 
| ContactLens 		 	| 
| RetinalScreening	 	|


Scenario: #2 - Create a service request for all services for a patient with the eligble product item GenExam not AVAILABLE. 

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

And the patient has an outstanding auth for A with services E as of CURRENT_DATE_MINUS_1

When I create the service request

Then the HTTP status code is 200

And the selected eligible product items should be: 
| productCatalogKey			|
| Lens			 			|
| Frame						|
| ContactLens 		 		|
| RetinalScreening	 		|


And the selected eligible product items should not contain:
| productCatalogKey |
| GenExam			|


Scenario: #3 - Doctor Create a service request for all services when Lens and Frame are Reserved (a prior authorization exists for the doctor)

Given a doctor log on
And a key memberPolicyKey of 12057231-0001-858017868
And a key consumerId of 2289762
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| GenExam 				|
| ContactLensService 	|
| Lens 					| 
| Frame 				|
| ContactLens 			|
| FrameWithSunLensInsert| 

And the patient has an outstanding auth for A with services LF as of CURRENT_DATE_MINUS_1

When I create the service request

Then the HTTP status code is 200

And the selected eligible product items should be:  
| productCatalogKey			| 
| GenExam					| 

And the selected eligible product items should not contain: 
| productCatalogKey |
| Lens  |
| Frame | 
| ContactLensService |
| ContactLens |
| FrameWithSunLensInsert|

Scenario: #4 - Create a service request for all services when no services are available
Meta: @skip

Given a key memberPolicyKey of 30021299-0001-858077868 
And a key consumerId of 2289769
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice 
And a list 
| productCatalogKey |
| GenExam |
| ContactLensService |
| Lens | 
| Frame |
| ContactLens |
And the patient has an outstanding auth for 9 with services ELFCV as of CURRENT_DATE_MINUS_1

When I create the service request
Then the HTTP status code is 204

Scenario: #5 - Create past service request (1 days prior) for patient with GenExam not AVAILABLE today.
Given a key memberPolicyKey of 30021299-0001-858057868
And a key consumerId of 2289779 
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE_MINUS_1
And a list 
| productCatalogKey		|
| GenExam 				|
| Lens					|
| Frame					|
| ContactLens			|

And the patient has an outstanding auth for 9 with services E as of CURRENT_DATE

When I create the service request

Then the HTTP status code is 200

And the selected eligible product items should be: 
| productCatalogKey		|  	
| Lens					| 
| Frame 		 		| 
| ContactLens	 		| 

And the selected eligible product items should not contain: 
| productCatalogKey | 
| GenExam  | 

Scenario: #6 Create past service request for patient with all services available today
Given a key memberPolicyKey of 30021299-0001-858057868
And a key consumerId of 2289779 
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE_MINUS_1
And a list 
| productCatalogKey		|
| GenExam 				|
| Lens					|
| Frame					|
| ContactLens			|

When I create the service request

Then the HTTP status code is 200

And the selected eligible product items should be:  
| productCatalogKey		|
| GenExam 				|
| Lens					|
| Frame 		 		|
| ContactLens	 		| 

Scenario: #7 Create future service request in the next frequency period, for all services when Lens and Frame are not AVAILABLE today
!-- This scenario is not valid if you cannot issue a legacy authorization. When we cut off BDS this
!-- scenario will be valid
Meta: @skip

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of NEXT_FREQUENCY_PERIOD
And a list 
| productCatalogKey 	|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

And the patient has an outstanding auth for A with services LF as of CURRENT_DATE

When I create the service request

Then the HTTP status code is 200

And the selected eligible product items should be: 
| productCatalogKey			|
| GenExam					|
| ContactLensService 		|
| Lens			 			|
| Frame						|
| ContactLens 		 		|
| RetinalScreening	 		|

Scenario: #8 Create future service request, tomorrow, for all services when Exam is not AVAILABLE today
!-- This scenario is not valid if you cannot issue a legacy authorization. When we cut off BDS this
!-- scenario will be valid
Meta: @skip
Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of END_OF_CURRENT_MONTH
!-- And a key effectiveDate of CURRENT_DATE_PLUS_5
And a list 
| productCatalogKey 	|
| GenExam				|
| ContactLensService	|
| Lens					|
| Frame					|
| ContactLens			|
| RetinalScreening		|

And the patient has an outstanding auth for A with services E as of CURRENT_DATE

When I create the service request

Then the HTTP status code is 200

And the selected eligible product items should be: 
| productCatalogKey			|
| ContactLensService 		|
| Lens			 			|
| Frame						|
| ContactLens 		 		|
| RetinalScreening	 		|

And the selected eligible product items should not contain: 
| productCatalogKey |
| GenExam  |