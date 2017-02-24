Verify a link for a Doctor to view Reserved Eligible Items 

Narrative:
As a Consumer of Eyeconic 
I want to reserve material services

Meta: @regression
@jira AUTH-2222

Scenario: #1 - Issue Frame/Lens authorization for Eyeconic-able patient with Signature product package. 
Assert that the service location is on the claim, and that the doctor phone number is on the patient history.

Given an eyeconic log on
And a key memberPolicyKey of 00101119-0002-916717857
And a key consumerId of 306011010
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Frame				|
| Lens				|

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|	
| Signature 			| 0001 		|	

And the service request should be:  
| member.name.firstName | member.name.lastName |
| CHRISXXX | VINCENT | 

And the service request should be:  
| member.addresses[0].street1 | member.addresses[0].city | member.addresses[0].stateCode | member.addresses[0].zipCode | member.addresses[0].zipExtension | 
| 3333 QUALITY DRIVE | RANCHO CORDOVA | CA | 95670 | 7985 |  

And the service request should be:  
| member.memberPolicyKey.clientId | member.memberPolicyKey.divisionId | member.memberPolicyKey.policyId |
| 00101119 | 0002 | 916717857 | 

And the service request should be: 
| member.membershipId | member.dateOfBirth | member.gender | 
| 916717857 | 1989-01-01 | F | 

And the service request should be:  
| patient.consumerId | patient.name.firstName | patient.name.lastName | 
| 306011010 | CHRISXXX | VINCENT |  

And the service request should be:  
| patient.addresses[0].street1 | patient.addresses[0].city | patient.addresses[0].stateCode | patient.addresses[0].zipCode | patient.addresses[0].zipExtension |  
| 3333 QUALITY DRIVE | RANCHO CORDOVA | CA | 95670 | 7985 |  

And the service request should be:  
| patient.memberPolicyKey.clientId | patient.memberPolicyKey.divisionId | patient.memberPolicyKey.policyId | 
| 00101119 | 0002 | 916717857 |  

And the service request should be:  
| patient.relationToSubscriber | patient.dateOfBirth | patient.gender | 
| Member | 1989-01-01 | F | 

And the service request should be: 
|providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode	| 
|1087																	| 
And the service request should be: 
|providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence|providerNetworkAccessPoint.serviceLocation.name|
|1																	   |EYECONIC.COM								   |
And the service request should be: 
|providerNetworkAccessPoint.serviceLocation.physicalAddress.street1|providerNetworkAccessPoint.serviceLocation.physicalAddress.city|
|10875 INTERNATIONAL DR STE 200										|RANCHO CORDOVA													   |
And the service request should be: 
|providerNetworkAccessPoint.serviceLocation.physicalAddress.stateCode|providerNetworkAccessPoint.serviceLocation.physicalAddress.zipCode|providerNetworkAccessPoint.serviceLocation.phoneNumber	|
|CA																	 |95670																|8553932664												|
And the service request should be: 
|providerNetworkAccessPoint.serviceLocation.physicalAddress.zipExtension|
|0000																	|

And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	| 
| Frame				| 
| Lens				| 

And the Frame eligibility interval end date is CURRENT_DATE+30 
And the Lens eligibility interval end date is CURRENT_DATE+30 

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|A		| Member						| Chrisxxx			 	 | Vincent			 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|
| Frame					| 

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|1989-01-01		| 00101119				 		 | 0002						  		| 916717857				  		 |

And the patient history should be: 
accesspoint.serviceLocation.phoneNumber| 
|8553932664  |            				| 

And the patient history effective interval end date is CURRENT_DATE+30	


Scenario: #2 - Issue Frame authorization for Eyeconic-able patient with Signature product package. Patient has already
used Lens

!-- NOTE:  The specific client we're using has a ProductPackage in-lieu-of on TotalContactLens, which causes the 
!-- productCatalogKey in-lieu-ofs to perform differently.  For a standard Signature client, this scenario is invalid  
!-- and would result in a failure to issue the legacy auth for Frame (performing similar to the AUTH-2233 stories).  
Given a key memberPolicyKey of 00101119-0002-916717857
And a key consumerId of 306011010
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Frame				|

And the patient has an outstanding auth for A with services L as of CURRENT_DATE_MINUS_1
And an eyeconic log on

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| Signature 			| 0001 		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306011010 | CHRISXXX | VINCENT | 

And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	|
| Frame				| 

And the Frame eligibility interval end date is CURRENT_DATE+30 

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|A		| Member						| Chrisxxx			 	 | Vincent			 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Frame					| 

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|1989-01-01		| 00101119				 		 | 0002						  		| 916717857				  		 |

And the patient history effective interval end date is CURRENT_DATE+30

Scenario: #3 - Issue Lens authorization for Eyeconic-able patient with Signature product package. Patient has already
used Frame 
Given a key memberPolicyKey of 00101119-0002-916717857
And a key consumerId of 306011010
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Lens				|

And the patient has an outstanding auth for A with services F as of CURRENT_DATE_MINUS_1
And an eyeconic log on

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| Signature 			| 0001 		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306011010 | CHRISXXX | VINCENT | 

And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				| 

And the Lens eligibility interval end date is CURRENT_DATE+30 

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|A		| Member						| Chrisxxx			 	 | Vincent			 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|1989-01-01		| 00101119				 		 | 0002						  		| 916717857				  		 |

And the patient history effective interval end date is CURRENT_DATE+30

Scenario: #4 - Issue ContactLens authorization for Eyeconic-able patient with Signature product package.
!-- This client has the TotalContactLenses product package on the product, so to issue ContactLens alone
!-- we must reserve with product package TotalContactLenses
Given an eyeconic log on
And a key memberPolicyKey of 00101119-0002-916717857
And a key consumerId of 306011010
And a key providerNetwork of 1000
And a key productPackageName of TotalContactLenses
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| ContactLens		|

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| TotalContactLenses 	| 0001 		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306011010 | CHRISXXX | VINCENT | 

And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	|
| ContactLens		| 

And the ContactLens eligibility interval end date is CURRENT_DATE+30 

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|A		| Member						| Chrisxxx			 	 | Vincent			 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|1989-01-01		| 00101119				 		 | 0002						  		| 916717857				  		 |

And the patient history effective interval end date is CURRENT_DATE+30


Scenario: #5 - Issue Lens/ContactLens authorization for Eyeconic-able patient with Signature product package.
!-- per terry: This member has TotalContactLenses, so reserving the contact lenses must happen via a separate reservations.   
!-- In this case, attempting to reserve ContactLens and Lens at the same time results in a Claim with only a lens claim line.
!-- This scenario serves as documentation for this case.

Given an eyeconic log on
And a key memberPolicyKey of 00101119-0002-916717857
And a key consumerId of 306011010
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| ContactLens		|
| Lens				|

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| Signature 			| 0001 		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306011010 | CHRISXXX | VINCENT | 


And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				| 

And the Lens eligibility interval end date is CURRENT_DATE+30 

When I retrieve the patient history for the legacy authorization 

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|A		| Member						| Chrisxxx			 	 | Vincent			 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|1989-01-01		| 00101119				 		 | 0002						  		| 916717857				  		 |

And the patient history effective interval end date is CURRENT_DATE+30

Scenario: #6 Create service request for Lens/Frame when GenExam has been utilized
Given a key memberPolicyKey of 00101119-0002-916717857
And a key consumerId of 306011010
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Lens				|
| Frame				|

And the patient has an outstanding auth for A with services E as of CURRENT_DATE_MINUS_1
And an eyeconic log on

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| Signature 			| 0001 		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306011010 | CHRISXXX | VINCENT | 


And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				| 
| Frame				| 

And the Frame eligibility interval end date is CURRENT_DATE+30 
And the Lens eligibility interval end date is CURRENT_DATE+30 

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|A		| Member						| Chrisxxx			 	 | Vincent			 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|
| Frame					|

And the patient history service items will not contain the product catalog keys: 
| productCatalogKey.name |
| GenExam 				 |

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|1989-01-01			| 00101119				 		 | 0002						  		| 916717857				  		 |

And the patient history effective interval end date is CURRENT_DATE+30
