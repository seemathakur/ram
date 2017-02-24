Narrative:
As a consumer
I want to have the correct timestamps on my claims 
Meta: @regression
@jira AUTH-2237

Scenario: 1 - Create a claim, assert the timestamps are current
Given a claim with no service location info

!-- the timestamps are correctly stored in the database with Pacific UTC time, but are 
!-- extracted as standard GMT time due to the HTTP headers. 
Then the claim timestamp should match todays date and current hour with GMT time
And the claim lines timestamps should match todays date and current hour with GMT time
