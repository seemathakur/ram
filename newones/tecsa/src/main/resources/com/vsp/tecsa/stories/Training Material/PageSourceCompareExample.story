Meta: 
@jira PageSourceCompareExample
@author 

Narrative:
In order to 
As a 
I want to 

Scenario: #1 - LogIn to Portal and set up

When I open browser to https://mixed-a1.eyefinity.com/eyefinity/html/eyefinity_logon.htm
When I maximize the browser
When I type 4314 in TARGET Name = password
When I clear value from TARGET Name = accessID
When I type 9498314144 in TARGET Name = accessID
When I click TARGET Name = logon
When I wait for TARGET LinkText = Get Authorizations & Check Eligibility to be present
When I click TARGET LinkText = Get Authorizations & Check Eligibility
When I switch to frame guiPage
When I type 10340026 in TARGET ID = authNum 
When I click TARGET xpath = html/body/form/table[4]/tbody/tr[3]/td[5]/div[1]/form/table/tbody/tr[2]/td[3]/input[2]
Given I set browser tab to homePage
When I pause 20000 milliseconds
Then I assert the current url contains RDE1INSURANCEPARENT
When I switch to default content
When I switch to frame navPage
When I click TARGET XPath = html/body/form/table/tbody/tr[1]/td[1]/table/tbody/tr/td[4]/a/div
When I pause 5000 milliseconds
When I switch browser tab
Then I assert the current url contains 10340026
When I pause 2000 milliseconds
When I close the browser
When I switch browser tab to homePage

Scenario: #2- Assert different server reports page source patientRecord

When I navigate to the VSP patientRecord report on <server1> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
When I navigate to the VSP patientRecord report on <server2> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
Then I assert the patientRecord report page source of <authNumber> on <server1> and <server2> are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceCompareExample.table

Scenario: #3 - Assert different server reports page source lensEnhancementsCharges

When I navigate to the VSP lensEnhancementsCharges report on <server1> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
When I navigate to the VSP lensEnhancementsCharges report on <server2> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
Then I assert the lensEnhancementsCharges report page source of <authNumber> on <server1> and <server2> are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceCompareExample.table

Scenario: #4- Assert different server reports page source savingsStatement

When I navigate to the VSP savingsStatement report on <server1> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
When I navigate to the VSP savingsStatement report on <server2> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
Then I assert the savingsStatement report page source of <authNumber> on <server1> and <server2> are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceCompareExample.table


Scenario: #5 - Assert different server reports page source service

When I navigate to the VSP service report on <server1> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
When I navigate to the VSP service report on <server2> with <authNumber> and <memberId1> and save the page source from the <frame>
When I pause 500 milliseconds
Then I assert the service report page source of <authNumber> on <server1> and <server2> are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceCompareExample.table
