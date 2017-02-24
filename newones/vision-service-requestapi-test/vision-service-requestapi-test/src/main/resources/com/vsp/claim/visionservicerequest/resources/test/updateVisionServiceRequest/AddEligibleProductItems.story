Add eligiblility product items to Vision Service Request

Narrative:
As a Doctor
I want to add an eligible product item to the Vision Service Request

 			 
Scenario: 1 - Given an authorization issued to GenExam. When I add other material services, then the
Vision Service Request will also contain the material services in addition to GenExam.
Meta: @jira AUTH-3034 

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| GenExam				|

When I create the service request
And I add the selected eligible product items to the vision service request: 
| productCatalogKey |  
| Lens				|
| Frame				|

And I retrieve the patient history for the legacy authorization
And I retrieve the vision service request

Then the add eligibility product items response should be: 
| productCatalogKey	|  
| Lens				| 
| Frame				| 

And the selected eligible product items should be: 
| productCatalogKey | 
| GenExam			|  
| Lens				| 
| Frame				| 

And the patient history service items will contain: 
| productCatalogKey.name |
| GenExam				 |
| Lens					 |
| Frame					 |

Scenario: 2 Given an existing reservation for GenExam and a patient not eligible for Lens services 
a user can successfully add Frame services to the vision service request
Meta: @jira AUTH-3034

Given a key memberPolicyKey of 00857001-0100-858017570 
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE
And a list 
| productCatalogKey 	|
| GenExam				|

And the patient has an outstanding auth for A with services L as of CURRENT_DATE

When I create the service request
And I add the selected eligible product items to the vision service request: 
| productCatalogKey |  
| Lens				|
| Frame				|

And I retrieve the patient history for the legacy authorization
And I retrieve the vision service request

Then the add eligibility product items response should be: 
| productCatalogKey	|  
| Frame				| 

And the selected eligible product items should be:  
| productCatalogKey | 
| GenExam			|  
| Frame				| 

And the selected eligible product items should not contain: 
| productCatalogKey | 
| Lens				| 

And the patient history service items will contain: 
| productCatalogKey.name |
| GenExam				 | 
| Frame					 |

And the patient history service items will not contain the product catalog keys: 
| productCatalogKey.name |  
| Lens					 |


Scenario: 3 - When I add an eligible product item to a non-existent Vision Service Request then the resource returns 404.  
Meta: @jira AUTH-3034

Given a key trackingNumber of 999999999

When I add the selected eligible product items to the vision service request:
| productCatalogKey |  
| GenExam			|

Then the HTTP status code is 404

Scenario: 4 - Doctor issues authorization for patient in participating network and adds services successfully
Meta: @jira AUTH-3037 

Given a doctor log on
And a key memberPolicyKey of 00857001-0100-858017570
And a key consumerId of 300253761
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a key effectiveDate of CURRENT_DATE

And a list 
| productCatalogKey |
| GenExam			|

When I create the service request
When I add the selected eligible product items to the vision service request: 
| productCatalogKey |   
| Lens				|  
| Frame				|  
Then the HTTP status code is 200

					 
Scenario: 5 - A service location log on successfully adds services to an authorization that has no provider information (service location, phone number) entered.
Meta: @jira AUTH-3037

Given a vision service request with no service location info
And a doctor log on

When I add the selected eligible product items to the vision service request: 
| productCatalogKey |   
| Lens				|  

Then the HTTP status code is 200

Scenario: 6 - A service location log on gets a 403 (Permission Denied) error when they add services to a vision service request that 
has a different service location (service location, phone number) populated on it.
Meta: @jira AUTH-3037

Given a vision service request with an alternative service location
And a doctor log on

When I add the selected eligible product items to the vision service request: 
| productCatalogKey |   
| Lens				|  

Then the HTTP status code is 403

Scenario: 7 - An application log on successfully adds services to an authorization that has a service location populated.
Meta: @jira AUTH-3037

Given a vision service request with an alternative service location
And an api log on

When I add the selected eligible product items to the vision service request: 
| productCatalogKey |   
| Lens				| 

Then the HTTP status code is 200

Scenario: 8 - An application log on can add services successfully to an authorization that does not have the DR phone number populated
Meta: @jira AUTH-3037 

Given a vision service request issued to the member created by a MetLife Vision provider
And an api log on

When I add the selected eligible product items to the vision service request: 
| productCatalogKey |   
| Lens				|  
| Frame				|  
Then the HTTP status code is 200


Scenario: 9 - A MetLife Vision provider issues authorization for patient in participating network and add services successfully
Meta: @jira AUTH-3037 

Given a vision service request issued to the member created by a MetLife Vision provider
And a MetLife Vision provider log on

When I add the selected eligible product items to the vision service request: 
| productCatalogKey |   
| Lens				|  
| Frame				|  
Then the HTTP status code is 200


Scenario: 10 - An alternate MetLife Vision provider logged on can add services successfully to an authorization that does not have the DR phone number populated
Meta: @jira AUTH-3037 

Given a vision service request issued to the member created by a MetLife Vision provider
And an alternate MetLife Vision provider log on

When I add the selected eligible product items to the vision service request: 
| productCatalogKey |   
| Lens				|  
| Frame				|  
Then the HTTP status code is 200
