Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @regression
@jira AUTH-1233

Scenario: #1 - Updating an existing claim with new data returns a 200.
Given the claim key 100049664-00

When I initialize the claim with default values
And I update the reserved claim with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimTest.json


Then the HTTP status code is 200
And the claim should be:
|subscriber.name.firstName	|subscriber.name.lastName	|subscriber.name.middle	|
|JASPER						|JACKSXXX					|X						|

And the claim should be:
|subscriber.addresses[0].city	|subscriber.addresses[0].stateCode	|subscriber.addresses[0].street1	|subscriber.addresses[0].street2	|subscriber.addresses[0].zipCode|subscriber.addresses[0].zipExtension|
|RANCHO CORDOVA					|CA									|3333 QUALITY DRIVE					|HQ5								|95670							|7985								 |

And the claim should be:
|subscriber.dateOfBirth	|subscriber.gender	|subscriber.memberPolicyKey.clientId|subscriber.memberPolicyKey.divisionId|
|1971-06-11				|M					|00857001							|0100								  |

And the claim should be:
|otherInsuredIndicator	|otherInsuredGroupName	|otherInsuredPolicyNumber |cobClaimNumber	|
|true					|VISION SERVICE PLAN	|LH380115300         	  |7777908700		|

And the claim should be:
|otherInsuredDateOfBirth	|otherInsuredFirstName	|otherInsuredMiddleInitial	|otherInsuredLastName	|otherInsuredGender	|
|1971-06-11					|JASPER					|X							|JACKSXXX				|M					|