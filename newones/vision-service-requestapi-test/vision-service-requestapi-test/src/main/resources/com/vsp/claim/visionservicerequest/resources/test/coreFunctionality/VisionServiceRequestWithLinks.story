VisionServiceRequest operations (Create, Retrieve, Search, Add, Delete) that populates the various links in VisionServiceRequest and SelectedEligibleProductItems 

Narrative:
As a Doctor 
I want to perform the various Vision Service Request operations and ascertain that the various links are populated.

Meta:
@jira AUTH-3095 @jira AUTH-3096 @jira AUTH-3175
					 
Scenario: #1 - Create the Vision Service Request. 
Assert that the various links have the correct values.

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

!-- AUTH-3095
And the service request should be:
| addSelectedEligibleProductItems.rel | addSelectedEligibleProductItems.type | 
| urn://vnd.vsp.rels/addselectedeligibleproductitems | application/vnd.vsp.eligibilityproductitems |

!-- AUTH-3096
And the service request should be:
| selectedEligibleProductItems[0].self.rel | selectedEligibleProductItems[0].self.type | 
| self | application/vnd.vsp.eligibilityproductitem |

!-- AUTH-3175
And the service request should be:
| self.rel | self.type | 
| self | application/vnd.vsp.visionservicerequest |

				 
Scenario: #2 - Retrieve a Vision Service Request and validate the link fields are correctly populated.

Given a key trackingNumber of 100458507
When I retrieve the vision service request

Then the service request should be: 
| trackingNumber | authorizationNumber | productPackageName | classId | issueDate  | 
| 100458507 	 | 11036393				| SignatureChoice	| 0001	  | 2017-01-09 |

!-- AUTH-3095
And the service request should be:
| addSelectedEligibleProductItems.rel | addSelectedEligibleProductItems.type | 
| urn://vnd.vsp.rels/addselectedeligibleproductitems | application/vnd.vsp.eligibilityproductitems |

!-- AUTH-3096
And the service request should be:
| selectedEligibleProductItems[0].self.rel | selectedEligibleProductItems[0].self.type | 
| self | application/vnd.vsp.eligibilityproductitem |

!-- AUTH-3175
And the service request should be:
| self.rel | self.type | 
| self | application/vnd.vsp.visionservicerequest |

Scenario: #3 - Search vision service requests from CLM 2342T, CLM2343T tables 
by clientId (membr_group_id), divisionId (membr_group_div), subscriberId (membr_id) and consumerId
Assert that the various links have the correct values.

Given a MetLife Vision provider log on
And a home url
When the link followed with parameters is visionservicerequests:
|name		|value|
|clientId	|30016772|
|divisionId	|0001|
|policyId	|851414717|
|consumerId	|303175542|

Then the HTTP status code is 200
And the service requests should be: 
|patient.memberPolicyKey.clientId 	|patient.memberPolicyKey.divisionId	|patient.memberPolicyKey.policyId	|patient.consumerId	|
|30016772							|0001								|851414717							|303175542			|

!-- AUTH-3175
And the service requests should be: 
| self.rel 	| self.type |
| self		| application/vnd.vsp.visionservicerequest |

And the search results have a self link populated on each result

!-- AUTH-3096
And the search results have a selectedEligibleProductItems self link populated on each result

!-- AUTH-3095
And the search results have a addSelectedEligibleProductItems link populated on each result

Scenario: #4 - Delete existing Vision service request.
Assert that the various links have the correct values.

Given a key memberPolicyKey of 00101119-0002-851994717
And a key consumerId of 306474979
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam |

When I create the service request
And I delete the service request

Then the service request field authorizationNumber should not be empty

!-- AUTH-3095
And the service request should be:
| addSelectedEligibleProductItems.rel | addSelectedEligibleProductItems.type | 
| urn://vnd.vsp.rels/addselectedeligibleproductitems | application/vnd.vsp.eligibilityproductitems |

!-- AUTH-3096
And the service request should be:
| selectedEligibleProductItems[0].self.rel | selectedEligibleProductItems[0].self.type | 
| self | application/vnd.vsp.eligibilityproductitem |

!-- AUTH-3175
And the service request should be:
| self.rel | self.type | 
| self | application/vnd.vsp.visionservicerequest |

Scenario: #5 - Given an authorization issued to GenExam. When I add other material services, then the
Vision Service Request will also contain the material services in addition to GenExam.
Assert that the various links have the correct values.

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

!-- AUTH-3096
And the selected eligible product items should be: 
| self.type | self.rel |
| application/vnd.vsp.eligibilityproductitem | self |

Scenario: #6 - Given an authorization issued to Exam and Material Services. When I remove the exam services, then the
Vision Service Request will contain only material services.
Assert that the various links have the correct values.

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

!-- AUTH-3096
And the selected eligible product items should be: 
| self.type | self.rel |
| application/vnd.vsp.eligibilityproductitem | self |
