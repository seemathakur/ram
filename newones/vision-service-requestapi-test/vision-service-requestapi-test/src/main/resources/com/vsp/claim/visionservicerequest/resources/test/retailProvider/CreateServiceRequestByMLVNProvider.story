Create a service request by MLVN (Metlife) Provider

Narrative:
As a MetLife Vision provider
I want to create a service request for SignatureChoice.
			 			 
Scenario: #1 - Create service request for product package SignatureChoice, as a MLVN doctor.
Ensure that the resulting service request has the correct product items. Assert that the providerNetworkAccessPoints and any other Provider details are NOT on the service request.
Meta:
@jira AUTH-2596	@jira AUTH-2594

Given a MetLife Vision provider log on
And a key memberPolicyKey of 30036084-0006-851505036
And a key consumerId of 306128340
And a key providerNetwork of MLVN
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey 	|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|
| ContactLensService	|

When I create the service request
And I save the authorization number

Then the selected eligible product items should be:  
| productCatalogKey		|
| GenExam				|
| Lens					|
| Frame					|
| ContactLens			|
| ContactLensService	|


Then the service request should be: 
| productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId|
| SignatureChoice		| MLVN |

And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30


Scenario: #2 - Create service request for product package SignatureChoice, as a MLVN doctor.
Ensure that the resulting service request has the correct product items. Assert that the providerNetworkAccessPoints and any other Provider details are NOT on the service request.
Meta:
@jira AUTH-2589 @jira AUTH-2594

Given a MetLife Vision provider log on
And a key memberPolicyKey of 30051158-0004-851545036
And a key consumerId of 306128341
And a key providerNetwork of MLVN
And a key productPackageName of SignatureChoice
And a list 
| productCatalogKey |
| GenExam |
| Lens				|
| Frame				|
| ContactLens		|
| ContactLensService|

When I create the service request
And I save the authorization number

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|
| Lens				|
| Frame				|
| ContactLens		|
| ContactLensService|

And the service request should be: 
| productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId|
| SignatureChoice		| MLVN |

And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30


Scenario: #3 - Create service request for product package ExamOnly, as a MLVN doctor.
Ensure that the resulting service request has the correct product items. Assert that the providerNetworkAccessPoints and any other Provider details are NOT on the service request.
Meta:
@jira AUTH-2589 @jira AUTH-2594

Given a MetLife Vision provider log on
And a key memberPolicyKey of 30036084-0002-851575036
And a key consumerId of 306128342
And a key providerNetwork of MLVN
And a key productPackageName of ExamOnly
And a list 
| productCatalogKey 	|
| GenExam				|

When I create the service request
And I save the authorization number

Then the selected eligible product items should be:
| productCatalogKey		|
| GenExam				|

And the service request should be: 
| productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId|
| ExamOnly				| MLVN |

And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the GenExam eligibility interval end date is CURRENT_DATE+30


Scenario: #4 - Create service request for product package AdditionalPair, as a MLVN doctor.
Ensure that the resulting service request has the correct product items. Assert that the providerNetworkAccessPoints and any other Provider details are NOT on the claim.
Meta:
@jira AUTH-2589 @jira AUTH-2594

Given a MetLife Vision provider log on
And a key memberPolicyKey of 30051158-0004-851545036
And a key consumerId of 306128341
And a key providerNetwork of MLVN
And a key productPackageName of AdditionalPair
And a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|
| ContactLensService|

When I create the service request
And I save the authorization number

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|
| Frame				|
| ContactLens		|
| ContactLensService|

And the service request should be: 
| productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId|
| AdditionalPair		| MLVN |

And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the ContactLensService eligibility interval end date is CURRENT_DATE+30


Scenario: #5 - Create service request for product package CoveredContactLenses, as a MLVN doctor.
Ensure that the resulting service request has the correct product items. Assert that the providerNetworkAccessPoints and any other Provider details are NOT on the service request.
Meta:
@jira AUTH-2589 @jira AUTH-2594

Given a MetLife Vision provider log on
And a key memberPolicyKey of 30039427-0410-858002546
And a key consumerId of 306243893
And a key providerNetwork of MLVN
And a key productPackageName of CoveredContactLenses
And a list 
| productCatalogKey |
| ContactLens		|

When I create the service request
And I save the authorization number

Then the selected eligible product items should be: 
| productCatalogKey		|
| ContactLens		|

And the service request should be: 
| productPackageName	| providerNetworkAccessPoint.providerNetworkKey.networkId|
| CoveredContactLenses	| MLVN |

And the service request field provider.key.providerTaxId should be empty
And the service request field provider.providerNetworkAccessPoints should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode should be empty
And the service request field providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence should be empty

And the ContactLens eligibility interval end date is CURRENT_DATE+30