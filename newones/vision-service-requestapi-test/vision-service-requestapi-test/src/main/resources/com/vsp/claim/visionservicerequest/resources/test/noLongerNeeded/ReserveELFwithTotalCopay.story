-Written By: Seth Van Grinsven (Last Updated:7/9/14)

Narrative: line 3 excel

Meta: 
@jira AUTH-445-J

!-- Eligibility frequency ends at the end of the year, so the reservation interval end date is end of month
Scenario: Patient has an as of date: current
Copay of Total
Client Product with an Auth Period of 30 Days
Product Package of 'VSP Choice Plan'

Given a patient with policy id 00101116-0007-858117868 and consumer id 2289790
And a product package name of SignatureChoice
And a claim line of GenExam
And a claim line of Lens
And a claim line of Frame
And a reservation interval start date of CURRENT_DATE
Given a provider network of 2000

When I reserve the preclaim

Then the claim number is NON_EMPTY

And the GenExam reservation interval start date is CURRENT_DATE
And the GenExam reservation interval end date is CURRENT_DATE+30

And the Frame reservation interval start date is CURRENT_DATE
And the Frame reservation interval end date is CURRENT_DATE+30

And the Lens reservation interval start date is CURRENT_DATE
And the Lens reservation interval end date is CURRENT_DATE+30

And the effective date is CURRENT_DATE