Create split service request for Market Product Medicaid

Narrative:
As a Doctor
I want to create a split service request for Medicaid

Meta: @regression
@jira AUTH-1732
				 			 
Scenario: #1 - Reserve Exam, then reserve Lens, frame, ContactLens and ContactLensService for 
Medicaid. Ensure that the service request has the correct product items, and that the 
legacy authorization exists and has the correct service items.

Given a key memberPolicyKey of 12004200-0001-853515036
And a key consumerId of 306024008
And a key providerNetwork of 50CA
And a key productPackageName of Medicaid
And a list 
| productCatalogKey |
| GenExam			|

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| GenExam			|

And the service request should be:
|productPackageName	|
|Medicaid			|

And the GenExam eligibility interval end date is END_OF_CURRENT_MONTH
!-- 2nd Reservation --!

Given a list 
| productCatalogKey |
| Lens					 |
| Frame					 |
| ContactLens			 |
| ContactLensService	 |

When I create the service request

Then the selected eligible product items should be: 
| productCatalogKey	|
| Lens				|
| Frame				|
| ContactLens		|
| ContactLensService|

And the service request should be: 
|productPackageName	|
|Medicaid			|

And the Lens eligibility interval end date is END_OF_CURRENT_MONTH
And the Frame eligibility interval end date is END_OF_CURRENT_MONTH
And the ContactLens eligibility interval end date is END_OF_CURRENT_MONTH
And the ContactLensService eligibility interval end date is END_OF_CURRENT_MONTH