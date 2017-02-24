Narrative:
In order to
As a
I want to
Meta: @jira 333
Scenario:
When I open browser to https://www-acpt.vsp.com/home.html
When I type asmith11 in TARGET id = userid
When I type $Test123 in TARGET id = password
When I click TARGET id = login_0
When I pause 9000 milliseconds
When I click TARGET xpath = html/body/div[1]/div[3]/div[1]/nav/ul/li[2]/a
When I pause 9000 milliseconds
Then I assert row 1 column 1 of TABLE id = Benefit RESULT text = Eligibility:
When I close the browser