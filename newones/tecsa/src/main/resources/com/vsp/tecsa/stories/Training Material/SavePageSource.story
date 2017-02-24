Meta: 
@jira SavePageSourceStory
@author Juan Lozano

Narrative:
In order to 
As a 
I want to 

Scenario: #1 - Login to Mix a1  
When I open browser to https://mixed-a1.eyefinity.com/eyefinity/html/eyefinity_logon.htm
When I maximize the browser
Given I view the SavePageSourcePage
When I type 4314 in the Password field
When I clear value from the Access ID field
When I type 9498314144 in the Access ID field
When I click the Logon button
When I wait for the Get Authorizations and Check Eligibility link to be present

Scenario: #1.1 Set up for loop
When I click the Get Authorizations and Check Eligibility link
When I wait for the Authorization page to be present
When I switch to frame guiPage
When I clear value from the Authorization field
When I type 10340024 in the Authorization field
When I pause 1000 milliseconds
When I click the GO button
When I wait for the CMS Form to be present
When I switch to default content
Given I set browser tab to homePage
When I switch to frame navPage
When I click the Reports tab
When I pause 1200 milliseconds
When I switch browser tab
When I pause 1000 milliseconds

Scenario: #1.2 Report Loop Executes
When I switch to default content
When I close the browser
When I switch browser tab to homePage
When I navigate the browser back
When I wait for the Authorization page to be present
When I pause 1000 milliseconds
When I switch to frame guiPage
When I clear value from the Authorization field
When I type <authNumber> in the Authorization field
When I click the GO button
When I wait for the CMS Form to be present
When I switch to default content
Given I set browser tab to homePage
When I switch to frame navPage
When I click the Reports tab
When I pause 3000 milliseconds
When I switch browser tab
When I maximize the browser
When I pause 1000 milliseconds
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Patient Record" Report
When I save the page source of the VSP patientRecord report on a1 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Lens Enhancements Charges tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Lens Enhancements Charges" Report
When I save the page source of the VSP lensEnhancementsCharges report on a1 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Savings Statement tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Savings Statement" Report
When I save the page source of the VSP savingsStatement report on a1 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Service Report tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Service" Report
When I save the page source of the VSP service report on a1 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the CMS Service Report tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "CMS Service" Report
When I save the page source of the VSP cmsService report on a1 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Packing Slip tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Packing Slip" Report
When I save the page source of the VSP packingSlip report on a1 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the PCP Form tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "PCP Form" Report
When I save the page source of the VSP pcpForm report on a1 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Patient History tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Patient History" Report
When I save the page source of the VSP patientHistory report on a1 and <authNumber>
When I pause 1000 milliseconds
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table



Scenario: #2 - Log out of MIX a1 and Login to MIX a2
When I switch to default content
When I close the browser
When I switch browser tab to homePage
When I navigate browser to https://mixed-a2.eyefinity.com/eyefinity/html/eyefinity_logon.htm
When I maximize the browser
When I type 4314 in the Password field
When I clear value from the Access ID field
When I type 9498314144 in the Access ID field
When I click the Logon button
When I wait for the Get Authorizations and Check Eligibility link to be present

Scenario: #2.1 Set up for loop
When I click the Get Authorizations and Check Eligibility link
When I wait for the Authorization page to be present
When I switch to frame guiPage
When I clear value from the Authorization field
When I type 10340024 in the Authorization field
When I pause 1000 milliseconds
When I click the GO button
When I wait for the CMS Form to be present
When I switch to default content
Given I set browser tab to homePage
When I switch to frame navPage
When I click the Reports tab
When I pause 1200 milliseconds
When I switch browser tab
When I pause 1000 milliseconds

Scenario: #2.2 Report Loop Executes
When I switch to default content
When I close the browser
When I switch browser tab to homePage
When I navigate the browser back
When I wait for the Authorization page to be present
When I pause 1000 milliseconds
When I switch to frame guiPage
When I clear value from the Authorization field
When I type <authNumber> in the Authorization field
When I click the GO button
When I wait for the CMS Form to be present
When I switch to default content
Given I set browser tab to homePage
When I switch to frame navPage
When I click the Reports tab
When I pause 3000 milliseconds
When I switch browser tab
When I maximize the browser
When I pause 1000 milliseconds
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Patient Record" Report
When I save the page source of the VSP patientRecord report on a2 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Lens Enhancements Charges tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Lens Enhancements Charges" Report
When I save the page source of the VSP lensEnhancementsCharges report on a2 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Savings Statement tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Savings Statement" Report
When I save the page source of the VSP savingsStatement report on a2 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Service Report tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Service" Report
When I save the page source of the VSP service report on a2 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the CMS Service Report tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "CMS Service" Report
When I save the page source of the VSP cmsService report on a2 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Packing Slip tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Packing Slip" Report
When I save the page source of the VSP packingSlip report on a2 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the PCP Form tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "PCP Form" Report
When I save the page source of the VSP pcpForm report on a2 and <authNumber>
When I switch to default content
When I switch to frame rptTop
When I click the Patient History tab
When I wait for the content of the Report to be present
When I pause 1000 milliseconds
When I switch to default content
When I switch to frame rptPage
!-- gets the "Patient History" Report
When I save the page source of the VSP patientHistory report on a2 and <authNumber>
When I pause 1000 milliseconds
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table



Scenario: #3 - Assert patientRecord Reports are Equal
Then I assert the patientRecord report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table

Scenario: #3.1 - Assert lensEnhancementsCharges Reports are Equal
Then I assert the lensEnhancementsCharges report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table

Scenario: #3.2 - Assert savingsStatement Reports are Equal
Then I assert the savingsStatement report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table

Scenario: #3.3 - Assert service Reports are Equal
Then I assert the service report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table

Scenario: #3.4 - Assert cmsService Reports are Equal
Then I assert the cmsService report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table

Scenario: #3.5 - Assert packingSlip Reports are Equal
Then I assert the packingSlip report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table

Scenario: #3.6 - Assert pcpForm Reports are Equal
Then I assert the pcpForm report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table

Scenario: #3.7 - Assert patientHistory Reports are Equal
Then I assert the patientHistory report page source of <authNumber> on a1 and a2 are equal
Examples:
com\vsp\tecsa\stories\Option Tables\PageSourceAuths.table


