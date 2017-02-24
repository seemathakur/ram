Narrative:
As an api consumer
I expect a HTTP 404 error code is returned when retrieving non-existent reserved claim
Meta:  @regression
@jira AUTH-1020

Scenario: 1 - A api consumer get a HTTP 404 error code when retrieving non-existent claim
Given an api log on
And the claim key 123456789-99

When the reserved claim is retrieved

Then the HTTP status code is 404