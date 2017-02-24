-Written By: Seth Van Grinsven (Last Updated:7/9/14)

Narrative: <Insert Narrative Here>

Meta: 
@jira AUTH-445-J

Scenario: As of date current
copay exam and materials
Client product has Auth exp period 15 days
product package vsp choice
no outstanding auth

Given a patient with policy id 12334445-1004-851424717 and consumer id 303175550
And a product package name of SignatureChoice
And a claim line of GenExam
And a reservation interval start date of CURRENT_DATE
Given a provider network of 2000

When I reserve the preclaim

Then the claim number is NON_EMPTY

And the GenExam reservation interval start date is CURRENT_DATE
And the GenExam reservation interval end date is CURRENT_DATE+15


And the effective date is CURRENT_DATE