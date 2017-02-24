Last Updated: Seth VG (6/23/2014)

Narrative: Line 29 of Reserve Claim.xlsx

Meta: 
@jira copayCollectedDate

!-- Eligibility frequency ends at the end of the year, so the reservation interval end date is end of month
Scenario: As of date: current date, Copay: Exam and Materials, Auth Exp Period: 30 Days, Product Package: VSP Choice plan, Outstanding Auth none

Given a patient with policy id 30021299-0001-858057868 and consumer id 2289779  
Given the patient has an outstanding auth for 9 with services F as of CURRENT_DATE_MINUS_5

And a claim line of Lens for SignatureChoice
And a reservation interval start date of CURRENT_DATE
Given a provider network of 2000

When I reserve the preclaim

Then the claim number is NON_EMPTY

And the Lens reservation interval start date is CURRENT_DATE
!-- And the Lens reservation interval end date is CURRENT_DATE+30
And the Lens reservation interval end date is END_OF_CURRENT_MONTH

And the effective date is CURRENT_DATE

