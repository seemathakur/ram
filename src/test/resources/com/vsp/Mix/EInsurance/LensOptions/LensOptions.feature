Feature: Lens Option Updates

  In order to verify the available lens options for doctors
  As a user of the VSP Online portal.
  I want to be able to validate from a supplied spreadsheet that all options are present.

  Scenario: [0]  Test Setup: Log on and navigate to setup for test
    Given I navigate to the Eyefinity Logon Portal
    When A user logs on with <credentials>
      |username|9498314144|
      |password|4314|
    Then I navigate to EInsurance homepage and enter <auth> and click go
    |auth|10410721|

  Scenario: [2] I run the Lens Options Update Additions from excel
    Given I load the excel file <filename>
      |filename|LSUDeactivations.xlsx|
    Then I iterate through the rows using selenium grid <run_remote>
      |false|

# if you want to run these tests locally change the above to false
# however be sure to set back to true when done
# if you are going to submit the code otherwise this will not run on the selenium grid




#  Scenario: [1]  Lens Additions
#    Given I hit the continue button.
#    When I input the following lens options <finishing> , <vision> , <material> , <lens>
#      |finishing|Lab Finishing|
#      |vision   |Progressive|
#      |material |Plastic|
#      |lens     |Camber B - Clear|
#    And I select a lab.
#    Then I calculate and continue.
#    Then I verify the service report contains <results>
#    |OA|
