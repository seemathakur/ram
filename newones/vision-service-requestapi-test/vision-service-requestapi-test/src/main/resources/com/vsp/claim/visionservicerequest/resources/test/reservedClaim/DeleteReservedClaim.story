Delete Reserved Claim

Narrative:
As a VSP employee
I want to delete a reserved claim.

Meta: @regression 
@jira AUTH-1016 @jira AUTH-2745
			 			 
Scenario: #1 - Create a reserved claim, follow the link to the reserved claim, and then follow the delete link.
Given a patient with policy id 00857001-0100-858017570 and consumer id 300253761
And a product package name of Signature
And a claim line of GenExam
And a reservation interval start date of CURRENT_DATE
And a provider network of 1000

When I create a reserved claim
And the reserved claim is deleted by following the self link on the claim

Then the HTTP status code is 200

Scenario: #2 - Create a reserved claim, follow the link to the reserved claim, and then follow the delete link.
Now retrieving for the claim should return 404.
Given a patient with policy id 00857001-0100-858017570 and consumer id 300253761
And a product package name of Signature
And a claim line of GenExam
And a reservation interval start date of CURRENT_DATE
And a provider network of 1000

When I create a reserved claim
And the reserved claim is deleted by following the self link on the claim
And the reserved claim is retrieved

Then the HTTP status code is 404

Scenario: #3 - Delete reserved claim that does not exist
Given the claim key 100334766-00

When the reserved claim is deleted

Then the HTTP status code is 404







