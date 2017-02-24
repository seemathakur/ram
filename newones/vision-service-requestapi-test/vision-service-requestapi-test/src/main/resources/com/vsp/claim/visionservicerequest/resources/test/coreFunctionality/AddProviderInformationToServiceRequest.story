Add provider information to service request

Narrative:
As a Doctor 
I want to Add provider information to service request

Meta: @regression  
@jira AUTH-698
					 
Scenario: #1 - Doctor issues authorization for patient in participating network.
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

Then the service request should be: 
| providerNetworkAccessPoint.providerNetworkKey.networkId | 
| 1000 |

And the service request should be: 
| providerKey.providerTaxId |
| 330484151 |

And the service request should be: 
| providerNetworkAccessPoint.serviceLocation.name |
| SHAHLA ABEDI MD  |

And the service request should be:   
| providerNetworkAccessPoint.serviceLocation.key.serviceLocationHashCode | providerNetworkAccessPoint.serviceLocation.key.serviceLocationSequence |
| 15 | 1 | 

And the service request should be: 
| providerNetworkAccessPoint.serviceLocation.physicalAddress.street1 |
| 15 MAREBLU STE 260 |

And the service request should be:
| providerNetworkAccessPoint.serviceLocation.physicalAddress.city |
| ALISO VIEJO |

And the service request should be:
| providerNetworkAccessPoint.serviceLocation.physicalAddress.stateCode | providerNetworkAccessPoint.serviceLocation.physicalAddress.zipCode | providerNetworkAccessPoint.serviceLocation.physicalAddress.zipExtension |
| CA | 92656 | 3046 |

And the service request field providerNetworkAccessPoint.serviceLocation.physicalAddress.street2 should be empty
