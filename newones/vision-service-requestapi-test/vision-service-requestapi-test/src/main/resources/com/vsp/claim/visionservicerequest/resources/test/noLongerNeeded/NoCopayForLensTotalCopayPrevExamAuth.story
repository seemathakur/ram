Last Updated: Seth VG (6/23/2014)

Narrative: Line 32 of Reserve Claim.xlsx

Meta: 

!-- Eligibility frequency ends at the end of the year, so the reservation interval end date is end of month

Scenario: As of date: current
copay: total
Client product has an auth exp period of 30 days
product package VSP Choice plan
Outstanding Auth E

Given a patient with policy id 00101116-0007-858147868 and consumer id 2289810  
Given the patient has an outstanding auth for 9 with services E as of CURRENT_DATE_MINUS_5

And a claim line of Lens for SignatureChoice
And a reservation interval start date of CURRENT_DATE
Given a provider network of 2000

When I reserve the preclaim

Then the claim number is NON_EMPTY

And the Lens reservation interval start date is CURRENT_DATE
And the GenExam reservation interval end date is CURRENT_DATE+30

And the effective date is CURRENT_DATE

