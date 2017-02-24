Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @regression
@jira AUTH-1234

Scenario: #1 - Updating an existing claim with new data returns a 200.
Given the claim key 100049664-00

When I initialize the claim with default values
And I update the reserved claim with content in com/vsp/claim/visionservicerequest/resources/test/eClaimServices/payload/ClaimTest.json


Then the HTTP status code is 200
And the claim should be:
|provider.key.providerTaxId	|memberSignatureIndicator	|memberSignatureDate	|
|261856406					|true						|0001-01-02				|

And the claim should be:
|patientAccountNumber	|acceptAssignmentIndicator	|provider.address.street1	|provider.address.street2	|provider.address.zipCode	|provider.address.zipExtension|
|BERGE00001    			|true						|3333 QUALITY DRIVE			|HQ5						|95670						|7985							|

And the claim should be:
|provider.name				|provider.address.stateCode	|provider.address.city	|
|ABQ HEALTH PARTNERS LLC    |CA							|RANCHO CORDOVA         |

And the claim should be:
|providerNetworkAccessPoint.serviceLocation.name|providerNetworkAccessPoint.serviceLocation.physicalAddress.stateCode	|providerNetworkAccessPoint.serviceLocation.physicalAddress.city	|
|ABQ HEALTH PARTNERS                			|CA																		|RANCHO CORDOVA         											|

And the claim should be:
|providerNetworkAccessPoint.serviceLocation.physicalAddress.street1	|providerNetworkAccessPoint.serviceLocation.physicalAddress.street2	|providerNetworkAccessPoint.serviceLocation.physicalAddress.zipCode	|providerNetworkAccessPoint.serviceLocation.physicalAddress.zipExtension|
|3333 QUALITY DRIVE													|HQ5																|95670																|7985																	|