Verify a link for a Doctor to view Reserved Eligible Items 

Narrative:
As a Doctor 
I want to click on link to view Reserved Eligible Items

Meta: @regression 
@jira AUTH-699
					 
Scenario: #1 - Reserve all services for Spouse.

Given a key memberPolicyKey of 30021299-0001-858047868 
And a key consumerId of 2289778
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| GenExam			|
| Lens				|
| Frame 			|
| ContactLens		|

When I create the service request

Then the service request should be: 
| classId 	|productPackageName	|
| 0001 		|SignatureChoice 	|

And the service request should be: 
| member.name.firstName | member.name.lastName |  
| TERRYXXX | RESERVE | 

And the service request should be: 
| member.addresses[0].street1 | member.addresses[0].city | member.addresses[0].stateCode | member.addresses[0].zipCode | member.addresses[0].zipExtension |   
| 3333 QUALITY DRIVE | RANCHO CORDOVA | CA | 95670 | 7985 |  

And the service request should be: 
| member.memberPolicyKey.clientId | member.memberPolicyKey.divisionId | member.memberPolicyKey.policyId |  
| 30021299 | 0001 | 858047868 |  

And the service request should be:  
| member.membershipId | member.dateOfBirth | member.gender | 
| 858047868 | 1990-04-30 | F | 

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |  
| 2289778 | JASON | RESERVE | 

And the service request should be: 
| patient.memberPolicyKey.clientId | patient.memberPolicyKey.divisionId | patient.memberPolicyKey.policyId | 
| 30021299 | 0001 | 858047868 | 

And the service request should be: 
| patient.dateOfBirth | patient.gender | patient.relationToSubscriber | 
| 1990-05-01 | M | Spouse | 
 
And the selected eligible product items should be:  
|  productCatalogKey|
|  GenExam			| 
| Lens				|
| Frame 			|
| ContactLens		| 


