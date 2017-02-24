Meta:
@jira TestUploadFileStep

Narrative:
In order to 
As a 
I want to 

Scenario: Upload File
When I open <browser> to http://ea-app0508.vsp.com/base-rates-loader-ui/
When I maximize the browser
When I wait for TARGET CssSelector = .logged-out.ng-binding to be present
When I click TARGET CssSelector = .logged-out.ng-binding
When I wait for TARGET ID = username to be present
When I type ZothTest001 in TARGET ID = password
When I type TestLBRJennifer in TARGET ID = username
When I click TARGET CssSelector = .ping-button.normal.allow
When I wait for TARGET ID = dropbox to be present
When I upload the file com\vsp\tecsa\stories\Training Material\OON 1.pdf from my project into TARGET ID = dropbox
Then I assert the textContent contains Rejected file: OON 1.pdf from TARGET Xpath = html/body/div[2]/div[2]/div[2]/div/div/form/div/div[1]/ul/ul[1]
When I pause 2000 milliseconds

Examples:
|browser|
|Firefox|
|Chrome |















