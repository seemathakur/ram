Verify a link for a Doctor to view Reserved Eligible Items 

Narrative:
As a Consumer of Eyeconic 
I want to Reserve material services for SignatureChoice for Non-CLEX members.

Meta: @regression
@jira AUTH-2233
	
Scenario: #1 - Issue Frame/Lens authorization for Eyeconic-able patient with SignatureChoice product package.
Assert that the service location is on the claim, and that the doctor phone number is on the patient history.  

Given an eyeconic log on
And a key memberPolicyKey of 12221655-0004-851565036
And a key consumerId of 306021881
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Lens				|
| Frame				|

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| SignatureChoice		| 0004 		|

Then the service request should be: 
| member.name.firstName | member.name.lastName | 
| CHOICEXXX | NOCLEX |  

Then the service request should be: 
| member.addresses[0].street1 | member.addresses[0].city | member.addresses[0].stateCode | member.addresses[0].zipCode |member.addresses[0].zipExtension |
| 3333 QUALITY DRIVE | RANCHO CORDOVA | CA | 95670 | 7985 |

Then the service request should be: 
| member.memberPolicyKey.clientId | member.memberPolicyKey.divisionId | member.memberPolicyKey.policyId |
| 12221655 | 0004 | 851565036 | 

Then the service request should be: 
| member.membershipId | member.dateOfBirth | member.gender |
| 851565036 | 2000-03-06 | F |

Then the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306021881 | CHOICEXXX | NOCLEX | 

Then the service request should be: 
| patient.addresses[0].street1 | patient.addresses[0].city | patient.addresses[0].stateCode | patient.addresses[0].zipCode | member.addresses[0].zipExtension |
| 3333 QUALITY DRIVE | RANCHO CORDOVA | CA | 95670 | 7985 |

Then the service request should be:  
| patient.memberPolicyKey.clientId | patient.memberPolicyKey.divisionId | patient.memberPolicyKey.policyId |
| 12221655 | 0004 | 851565036 | 

Then the service request should be: 
| patient.relationToSubscriber | patient.dateOfBirth | patient.gender |
| Member | 2000-03-06 | F |

And the issue date is CURRENT_DATE

And the selected eligible product items should be:  
| productCatalogKey	|  
| Lens				|   
| Frame				|  

And the Lens eligibility interval end date is CURRENT_DATE+30 
And the Frame eligibility interval end date is CURRENT_DATE+30 

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|9		| Member						| Choicexxx			 	 | Noclex			 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|
| Frame					| 

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|2000-03-06			| 12221655				 		 | 0004						  		| 851565036				  		 |

And the patient history effective interval end date is CURRENT_DATE+30	


Scenario: #2 - Issue Frame authorization for Eyeconic-able patient with SignatureChoice product package. Patient has already
used Lens - which implies Frame is also not available for Signature Choice (behaves as PBEC).
Given a key memberPolicyKey of 12221655-0004-851565036
And a key consumerId of 306021881
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Frame				|

And the patient has an outstanding auth for 9 with services L as of CURRENT_DATE_MINUS_1
And an eyeconic log on

When I create the service request
Then the HTTP status code is 204


Scenario: #3 - Issue Lens authorization for Eyeconic-able patient with SignatureChoice product package. Patient has already
used Frame 

Given a key memberPolicyKey of 12221655-0004-851565036
And a key consumerId of 306021881
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Lens				|

And the patient has an outstanding auth for 9 with services F as of CURRENT_DATE_MINUS_1
And an eyeconic log on

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| SignatureChoice 		| 0004		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306021881 | CHOICEXXX | NOCLEX | 

And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	| 
| Lens				|  

And the Lens eligibility interval end date is CURRENT_DATE+30

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|9		| Member						| Choicexxx			 	 | Noclex					 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|

And the patient history service items will not contain the product catalog keys: 
| productCatalogKey.name |
| Frame 				 |

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|2000-03-06			| 12221655				 		 | 0004						  		| 851565036				  		 |

And the patient history effective interval end date is CURRENT_DATE+30

Scenario: #4 - Issue ContactLens authorization for Eyeconic-able patient with SignatureChoice product package. 

Given an eyeconic log on
And a key memberPolicyKey of 12221655-0004-851565036
And a key consumerId of 306021881
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| ContactLens		|

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| SignatureChoice 		| 0004 		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306021881 | CHOICEXXX | NOCLEX | 

And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	| 
| ContactLens		| 

And the ContactLens eligibility interval end date is CURRENT_DATE+30

When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName	|
|9		| Member							| Choicexxx			 	 | Noclex			 			|

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|2000-03-06		| 12221655				 		 | 0004						  		| 851565036				  		 |

And the patient history effective interval end date is CURRENT_DATE+30

Scenario: #5 - Issue Lens/ContactLens authorization for Eyeconic-able patient with SignatureChoice product package. 

Given an eyeconic log on
And a key memberPolicyKey of 12221655-0004-851565036
And a key consumerId of 306021881
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| ContactLens		|
| Lens				|

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| SignatureChoice 		| 0004		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306021881 | CHOICEXXX | NOCLEX | 

And the issue date is CURRENT_DATE

And the selected eligible product items should be: 
| productCatalogKey	| 
| ContactLens		| 
| Lens				| 

And the ContactLens eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30


When I retrieve the patient history for the legacy authorization

Then the patient history should be:  
|benefit| patient.relationToSubscriber	| patient.name.firstName | patient.name.lastName |
|9		| Member							| Choicexxx			 	 | Noclex					 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|2000-03-06	| 12221655				 		 | 0004						  		| 851565036				  		 |

And the patient history effective interval end date is CURRENT_DATE+30


Scenario: #6 Create service request for Lens/Frame when GenExam has been utilized

Given an eyeconic log on
And a key memberPolicyKey of 12221655-0004-851565036
And a key consumerId of 306021881
And a key providerNetwork of 2000
And a key productPackageName of SignatureChoice
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey |
| Lens				|
| Frame				|

And the patient has an outstanding auth for 9 with services E as of CURRENT_DATE_MINUS_1

When I create the service request
And I save the authorization number

Then the service request should be: 
| productPackageName	| classId 	|
| SignatureChoice 		| 0004 		|

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 306021881 | CHOICEXXX | NOCLEX | 

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
|9		| Member						| Choicexxx			 	 | Noclex					 |

And the patient history service items will contain: 
|productCatalogKey.name |
| Lens					|
| Frame					|

And the patient history service items will not contain the product catalog keys: 
| productCatalogKey.name |
| GenExam 				 |

And the patient history should be: 
|patient.dateOfBirth|patient.memberPolicyKey.clientId|patient.memberPolicyKey.divisionId|patient.memberPolicyKey.policyId|
|2000-03-06			| 12221655				 		 | 0004						  		| 851565036				  		 |

And the patient history effective interval end date is CURRENT_DATE+30