Remove an eligible product item from Vision Service Request

Narrative:
As a Doctor
I want to remove an eligible product item from the Vision Service Request

 			 
Scenario: 1 - Given an authorization issued to Exam and Material Services. When I remove the exam services, then the
Vision Service Request will contain only material services
Meta: @jira AUTH-3035

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

When I create the service request
And I delete the selected eligible product item GenExam from the vision service request
And I retrieve the patient history for the legacy authorization
And I retrieve the vision service request

Then the delete eligibility product item response should be: 
| productCatalogKey	| 
| GenExam			| 

And the selected eligible product items should not contain:  
| productCatalogKey | 
| GenExam			|

And the selected eligible product items should be: 
| productCatalogKey |   
| Lens				| 
| Frame				| 
| ContactLens		| 

And the patient history service items will contain: 
| productCatalogKey.name |
| Lens					 |
| Frame					 |
| ContactLens			 |

And the patient history service items will not contain the product catalog keys: 
| productCatalogKey.name |  
| GenExam				 |


Scenario: 2 - Given an authorization issued to all services. When I remove the material services, then the
Vision Service Request will contain only exam services
Meta: @jira AUTH-3035

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

When I create the vision service request
And I delete the selected eligible product item Lens from the vision service request
And I delete the selected eligible product item Frame from the vision service request
And I delete the selected eligible product item ContactLens from the vision service request
And I retrieve the patient history for the legacy authorization
And I retrieve the vision service request

Then the selected eligible product items should not contain: 
| productCatalogKey |   
| Lens				| 
| Frame				| 
| ContactLens		| 

And the selected eligible product items should be: 
| productCatalogKey |
| GenExam			|

Then the patient history service items will contain: 
| productCatalogKey.name |
| GenExam				 |

And the patient history service items will not contain the product catalog keys: 
| productCatalogKey.name |  
| Lens					 |
| Frame					 |
| ContactLens			 |

Scenario: 3 - Given an authorization issued to all services. When I remove the Lens & ContactLens service, then the
Vision Service Request will contain only the GenExam and Frame services
Meta: @jira AUTH-3035

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

When I create the vision service request
And I delete the selected eligible product item Lens from the vision service request
And I delete the selected eligible product item ContactLens from the vision service request
And I retrieve the patient history for the legacy authorization
And I retrieve the vision service request

Then the selected eligible product items should not contain: 
| productCatalogKey |    
| Lens				|  
| ContactLens		|  

And the selected eligible product items should be: 
| productCatalogKey | 
| GenExam			| 
| Frame				| 

Then the patient history service items will contain: 
| productCatalogKey.name |
| GenExam				 |
| Frame					 |

And the patient history service items will not contain the product catalog keys: 
| productCatalogKey.name |  
| Lens					 |
| ContactLens			 |


Scenario: 4 - Creating a reservation for all services except GenExam. When I attempt to remove GenExam, the resource returns 404
Meta: @jira AUTH-3035

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| Lens					|
| Frame					|
| ContactLens			|

When I create the vision service request
And I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 404

Scenario: 5 - When I remove an eligible product item from a non-existent Vision Service Request then the resource returns 404.  
Meta: @jira AUTH-3035

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a key trackingNumber of 999999999

When I delete the selected eligible product item Lens from the vision service request

Then the HTTP status code is 404

Scenario: 6 - Doctor issues authorization for patient in participating network and removes service successfully
Meta: @jira AUTH-3038

Given a doctor log on
And a key memberPolicyKey of 00857001-0100-858017570
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE

And a list 
| productCatalogKey |
| GenExam			|
| Frame				|

When I create the service request
And I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 200

					 
Scenario: 7 - A service location log on successfully deletes services on a vision service request 
that has no provider information entered.
Meta: @jira AUTH-3038

Given a vision service request with no service location info
And a doctor log on

When I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 200

Scenario: 8 - A service location log on gets a 403 (Permission Denied) error when they delete services from a vision service request
has a different service location populated on it.
Meta: @jira AUTH-3038

Given a vision service request with an alternative service location
And a doctor log on

When I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 403

Scenario: 9 - An application log on successfully deletes services from a vision service request 
that has a service location populated.
Meta: @jira AUTH-3038

Given a vision service request with an alternative service location
And an api log on

When I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 200

Scenario: 10 - A MetLife Vision service location log on can delete services from a vision service request 
that does not have a DR phone populated on it.
Meta: @jira AUTH-3038

Given a vision service request issued to the member created by a MetLife Vision provider

And a MetLife Vision provider log on

When I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 200

Scenario: 11 - An application log on successfully removes services from a vision service request 
that does not have a DR phone number populated.
Meta: @jira AUTH-3038

Given a vision service request issued to the member created by a MetLife Vision provider
And an api log on

When I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 200


Scenario: 12 - An alternate MetLife Vision provider successfully removes services from a
vision service request that does not have a DR phone number populated.
Meta: @jira AUTH-3038

Given a vision service request issued to the member created by a MetLife Vision provider
And an alternate MetLife Vision provider log on

When I delete the selected eligible product item GenExam from the vision service request

Then the HTTP status code is 200