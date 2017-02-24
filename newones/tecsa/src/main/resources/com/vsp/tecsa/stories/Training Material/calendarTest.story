Meta: 
@jira Test212345 

Narrative:
In order to 
As a 
I want to 

Scenario: #1 - Innitial Set up

When I open <browserType> to https://client-dev.vsp.com/
When I maximize the browser
When I type $Test123 in TARGET ID = password
When I clear value from TARGET ID = userid
When I type cbinternal in TARGET ID = userid
When I press the ENTER key
When I select MEMBER ID from TARGET ID = idType
When I type 000000068 in TARGET ID = idValue
When I press the ENTER key
When I pause 5000 milliseconds
When I click TARGET XPATH = html/body/div[1]/div[3]/div[1]/nav/ul/li[1]/a
When I click TARGET LinkText = Download Eligibility
When I click TARGET XPATH = html/body/div[1]/div[3]/div[2]/div/form/div[1]/div/table/tbody/tr[2]/td[1]/input
When I pause 1500 milliseconds
When I decrease the current date by 6 months and 3 days
