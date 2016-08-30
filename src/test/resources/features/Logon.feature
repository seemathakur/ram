Feature: Log on to EyeFinity portal

  In order to perform other tests
  As a test user
  I want to be able to log on to the EyeFinity portal.


# this is a comment

  Scenario: Log on to eyefinity portal
    Given I navigate to the Eyefinity Logon Portal
    When A user logs on with <credentials>
      |username|9498314144|
      |password|4314|
    Then I should see  the VSP Online link

