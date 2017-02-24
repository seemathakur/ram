Narrative:
In order to
As a
I want to
Meta: @jira 444
Scenario:
When I open browser to https://www-acpt.vsp.com/home.html
Given I view the LogInPage
When I type chrischase in the Member User Name field
When I type $Test123 in the Password field
When I click the LOG IN button
When I click TARGET xpath = html/body/div[1]/div[3]/div[1]/nav/ul/li[2]/a
Then I assert row 1 column 1 of TABLE id = Benefit RESULT text = Eligibility:
Then I assert row 1 column 2 of TABLE id = Benefit RESULT text = CALL MEMBER SERVICES AT (800) 877-7195.
Then I assert row 2 column 1 of TABLE id = Benefit RESULT text = Frequency:
Then I assert row 2 column 2 of TABLE id = Benefit RESULT text = You can have an eye exam 12 months after your last exam.
Then I assert row 3 column 1 of TABLE id = Benefit RESULT text = Copay:
Then I assert row 3 column 2 of TABLE id = Benefit RESULT text = $10.00
Then I assert row 4 column 1 of TABLE id = Benefit RESULT text = Coverage:
Then I assert row 4 column 2 of TABLE id = Benefit RESULT text = Your WellVision Exam is fully covered.
Then I assert row 5 column 1 of TABLE id = Benefit RESULT text = Description:
Then I assert row 5 column 2 of TABLE id = Benefit RESULT text = Your VSP doctor or retail chain provider can see if you have vision problems or other health conditions too.
When I close the browser