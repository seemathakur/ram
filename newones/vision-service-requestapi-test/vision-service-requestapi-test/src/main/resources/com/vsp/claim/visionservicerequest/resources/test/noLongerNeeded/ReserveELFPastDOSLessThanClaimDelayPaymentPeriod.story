-Written By: Seth Van Grinsven (Last Updated:7/9/14)

Narrative: Line 5
Meta:
@jira AUTH-445-J

Scenario: As of Date: past DOS < Claim delay payment period
Copay of Exam and Materials
Client Product has Auth exp period of 30 days 
Product package of 'VSP Choice Plan'

Given a patient with policy id 30021299-0001-858057868 and consumer id 2289771
And a product package name of SignatureChoice
And a claim line of GenExam
And a claim line of Lens
And a claim line of Frame
And a reservation interval start date of CURRENT_DATE_MINUS_30
Given a provider network of 2000

When I reserve the preclaim

Then the claim number is NON_EMPTY

And the GenExam reservation interval start date is CURRENT_DATE_MINUS_30
And the GenExam reservation interval end date is CURRENT_DATE

And the Frame reservation interval start date is CURRENT_DATE_MINUS_30
And the Frame reservation interval end date is CURRENT_DATE

And the Lens reservation interval start date is CURRENT_DATE_MINUS_30
And the Lens reservation interval end date is CURRENT_DATE

And the effective date is CURRENT_DATE
