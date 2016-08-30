Feature: Logon 2

  @Meta
    @regression

  Scenario: Try to log on yet again
    Given I navigate to the Eyefinity Logon Portal
    When A user logs on with <credentials>
      |username|9498314144|
      |password|4314|
    Then I should see  the VSP Online link

