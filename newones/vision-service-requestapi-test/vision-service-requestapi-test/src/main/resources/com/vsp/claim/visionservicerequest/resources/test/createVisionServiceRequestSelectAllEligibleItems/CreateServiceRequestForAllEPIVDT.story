Create a service request for Market Product Signature


Narrative:
As a Doctor
I want to create a service request for VDT

Meta: @regression
@jira AUTH-1708
				 			 
Scenario: #1 - Create service request for product package VDT. Ensure that the resulting 
service request has the correct product items, and that the legacy authorization exists and has the correct 
service items.
Given a key memberPolicyKey of 12185351-0031-853265036
And a key consumerId of 306024000
And a key providerNetwork of 1000
And a key productPackageName of VDT
And a list 
| productCatalogKey 	 |
| GenExam				 |
| Lens					 |
| Frame					 |

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	 	 |
| GenExam				 |
| Lens					 |
| Frame					 |

And the service request should be:
|productPackageName |
|VDT				|

And the GenExam eligibility interval end date is CURRENT_DATE+30
And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
