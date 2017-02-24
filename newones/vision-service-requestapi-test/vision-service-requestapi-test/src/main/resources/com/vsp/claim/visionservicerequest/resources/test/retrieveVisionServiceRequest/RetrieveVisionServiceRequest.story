Retrieve Vision Service Request

Meta: @jira AUTH-3097
					 
Scenario: 1 - Retrieve a Vision Service Request and validate the fields are correctly populated

Given a key trackingNumber of 100458507
When I retrieve the vision service request

Then the service request should be: 
| trackingNumber | authorizationNumber | productPackageName | classId | issueDate  | 
| 100458507 	 | 11036393				| SignatureChoice	| 0001	  | 2017-01-09 |

And the service request should be: 
| providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode | providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence | 
| 2253																	 | 1																	  |

And the service request should be: 
| providerNetworkAccessPoint.serviceLocation.phoneNumber | providerNetworkAccessPoint.providerNetworkKey.networkId |
| 4158631818											 | 2000													   |

And the service request should be: 
| providerKey.providerTaxId |
| 943124549					 |

And the service request should be: 
| patient.consumerId | patient.name.firstName | patient.name.lastName |
| 2289778			 | JASON 				  | RESERVE				  |  			

And the service request should be: 
| patient.memberPolicyKey.clientId |  patient.memberPolicyKey.divisionId |  patient.memberPolicyKey.policyId |
| 30021299						   | 0001								 | 	858047868						 |		 

And the service request should be: 
| patient.relationToSubscriber  |
| Spouse						|

And the service request should be: 
| member.name.firstName | member.name.lastName |
| TERRYXXX 				  | RESERVE			     |  			

And the service request should be: 
| member.memberPolicyKey.clientId |  member.memberPolicyKey.divisionId |  member.memberPolicyKey.policyId |
| 30021299						   | 0001								 | 	858047868						 |		 

And the selected eligible product items should be: 
| productCatalogKey 	| eligibilityInterval.begin | eligibilityInterval.end |
| GenExam				| 2017-01-09				| 2017-02-08			  |
| Frame					| 2017-01-09				| 2017-02-08			  |


Scenario: 2 - Retrieve a Vision Service Request that does not exist returns 404

Given a key trackingNumber of 999999999
When I retrieve the vision service request
Then the HTTP status code is 404
