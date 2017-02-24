Create split service request for Market Product Signature

Narrative:
As a Doctor
I want to create a split service request for Signature - for members without CLEX product
					 			 		 		 			 
Scenario: #1 - Reserve Exam, then reserve Lens, Frame ContactLens, ContactLensService, 
FrameWithSunLensInsert, for Signature.
Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.

Meta: @regression
@jira AUTH-1727

Given a key memberPolicyKey of 00857001-0100-853035036
And a key consumerId of 306023996
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be: 
|productPackageName	|   
|Signature			|    

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!

Given a list 
|productCatalogKey     |
|Lens                  |
|Frame                 |
|ContactLens           |
|FrameWithSunLensInsert|
|RetinalScreening      |

When I create the service request

Then the selected eligible product items should be: 
|productCatalogKey     |
|Lens                  |
|Frame                 |
|ContactLens           |
|FrameWithSunLensInsert|
|RetinalScreening      |

And the service request should be: 
|productPackageName	|  
|Signature			|  

And the Lens eligibility interval end date is CURRENT_DATE+30 
And the Frame eligibility interval end date is CURRENT_DATE+30 
And the ContactLens eligibility interval end date is CURRENT_DATE+30 
And the FrameWithSunLensInsert eligibility interval end date is CURRENT_DATE+30 
And the RetinalScreening eligibility interval end date is CURRENT_DATE+30 


Scenario: #2 - Reserve Exam and ContactLensService, then reserve Lens, Frame and ContactLens for 
Signature. Ensure that the service requests have the correct product items,
and that the second legacy authorization DOES NOT EXIST. 
Meta: @regression
@jira AUTH-2133

Given a key memberPolicyKey of 00857001-0100-853035036
And a key consumerId of 306023996
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
|productCatalogKey |
|GenExam           |

When I create the service request

Then the selected eligible product items should be: 
|productCatalogKey |
|GenExam           |

And the service request should be: 
|productPackageName	| 
|Signature			| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
|productCatalogKey|
|ContactLens      |
|Lens             |
And the patient has an outstanding auth for A with services EL as of CURRENT_DATE_MINUS_1

When I create the service request
Then the HTTP status code is 204

Scenario: #3 Reserve Exam only, then reserve Lens, Frame ContactLens and ContactLensService for 
SignatureChoice. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.

Meta: @regression
@jira AUTH-1727

Given a key memberPolicyKey of 00857001-0100-853035036
And a key consumerId of 306023996
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be:
|productPackageName	| 
|Signature			| 

And the GenExam eligibility interval end date is CURRENT_DATE+30

!-- 2nd Reservation --!
Given a list 
| productCatalogKey |
| Lens				|
| Frame				|
| ContactLens		|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|
| Frame				|
| ContactLens		|

And the service request should be: 
|productPackageName	|   
|Signature			|   

And the Lens eligibility interval end date is CURRENT_DATE+30
And the Frame eligibility interval end date is CURRENT_DATE+30
And the ContactLens eligibility interval end date is CURRENT_DATE+30


Scenario: #4 - Reserve ContactLens and ContactLensService for
Signature. Ensure that the service requests have the correct product items,
and that the legacy authorizations exist and have the correct service items.
Meta: @regression
@jira AUTH-1727

Given a key memberPolicyKey of 00857001-0100-853035036
And a key consumerId of 306023996
And a key providerNetwork of 1000
And a key productPackageName of Signature
And a list 
|productCatalogKey |
|ContactLens       |

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| ContactLens		|

And the service request should be:
|productPackageName	|
|Signature			| 

And the ContactLens eligibility interval end date is CURRENT_DATE+30