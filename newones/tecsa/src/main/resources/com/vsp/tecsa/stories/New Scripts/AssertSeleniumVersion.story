Meta: 
@jira AssertSeleniumVersion
@author Juanlo2

Narrative:
In order to verify that we are up to date with the latest Selenium Version for our JBehave project 
As a JBehave Support Member 
I want to navigate to the Selenium HQ Web page and assert the current version of selenium

Scenario:

When I open FIREFOX to http://docs.seleniumhq.org/
When I click TARGET CSSSELECTOR = a[href="/download/"]
When I pause 2000 milliseconds
Then I assert the text equals 2.53.0 from TARGET XPATH = html/body/div[1]/div[2]/div[2]/p[3]/a
