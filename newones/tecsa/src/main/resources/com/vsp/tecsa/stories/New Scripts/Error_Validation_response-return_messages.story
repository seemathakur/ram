Promotions Error Messages

Meta:
@jira MP-4

Scenario: Search Promotion not found
Given a clientId of 123456789
And a classId of 0003
And an asOfDate of 2014-08-01

When I search for Promotions and get an error response

Then the HTTP status code is 400
And the HTTP error response message matches Not a valid Client id

Scenario: Retrieve Promotion not found
Given a clientId of 12319587
And a classId of 0003
And an asOfDate of 2014-01-01

When I search for Promotions
And I retrieve a Promotion and get an error response

Then the HTTP status code is 404
And the HTTP error response message matches No Promotion found !!!
