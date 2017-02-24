Narrative:
As a consumer
I want to have my updates to the fields on the Exam and Services card of the CMS Form to be persisted. 
Meta: @regression
@jira AUTH-1332


Scenario: #1 - Retrieval of alpha diagnosis pointers from claim line returns a 200.
Given the claim key 100037273-00

When the reserved claim is retrieved

Then the HTTP status code is 200
And the claim lines should be:
|lineNumber	|diagnosisPointers[0]	|diagnosisPointers[1]	|diagnosisPointers[2]	|
|1			|A				        |B              		|C						|
|2			|B				        |A              		|C						|

Scenario: #2 - Retrieval of diagnosis codes from claim returns a 200.
Given the claim key 100037273-00

When the reserved claim is retrieved

Then the HTTP status code is 200
And the claim should be:
|diagnosis.A	|diagnosis.B	|diagnosis.C	|
|201.1			|101.5          |510.5			|