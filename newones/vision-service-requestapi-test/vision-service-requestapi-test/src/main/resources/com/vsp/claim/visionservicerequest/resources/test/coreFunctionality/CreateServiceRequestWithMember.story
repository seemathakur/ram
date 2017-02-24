Call MemberPolicies to populate member/patient info on ReservedClaim

Narrative:
As a Doctor 
I want to Call MemberPolicies to populate member/patient info on ReservedClaim

Meta: @regression 
@jira AUTH-699
					 
Scenario: #1 - Setup and patient information on the reserved clam must match the patient

Given a key memberPolicyKey of 30021299-0001-858047868
And a key consumerId of 2289770
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request


Then the service request should be: 
| member.name.firstName | member.name.lastName |
| TERRYXXX | RESERVE | 

And the service request should be: 
| classId 	| productPackageName	|
| 0001 		| SignatureChoice 		|

And the service request should be: 
| member.addresses[0].street1 | member.addresses[0].city | member.addresses[0].stateCode | member.addresses[0].zipCode | member.addresses[0].zipExtension |
| 3333 QUALITY DRIVE | RANCHO CORDOVA | CA | 95670 | 7985 | 

And the service request should be: 
| member.memberPolicyKey.clientId | member.memberPolicyKey.divisionId | member.memberPolicyKey.policyId |
| 30021299 | 0001 | 858047868 | 

And the service request should be: 
| member.membershipId | member.dateOfBirth | member.gender |
| 858047868 | 1990-04-30 | F |

Then the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 2289770 | TERRYXXX | RESERVE | 

And the service request should be: 
| patient.addresses[0].street1 | patient.addresses[0].city | patient.addresses[0].stateCode | patient.addresses[0].zipCode | patient.addresses[0].zipExtension | 
| 3333 QUALITY DRIVE | RANCHO CORDOVA | CA | 95670 | 7985 | 

And the service request should be: 
| patient.memberPolicyKey.clientId | patient.memberPolicyKey.divisionId | patient.memberPolicyKey.policyId |
| 30021299 | 0001 | 858047868 | 

And the service request should be: 
| patient.relationToSubscriber | patient.dateOfBirth | patient.gender |
|  Member | 1990-04-30 | F |

And the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|