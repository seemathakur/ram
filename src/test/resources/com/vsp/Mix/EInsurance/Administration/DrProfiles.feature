Feature: Create / Update a doctor practice profile

  In order to maintain my practice profile on VSP online
  As a user of the VSP Online portal.
  I want to be able to log on to the EyeFinity portal and update my profile.


# this is a comment

  Scenario: [0]  Log on to Eyefinity portal
    Given I navigate to the Eyefinity Logon Portal
    When A user logs on with <credentials>
      |username|9498314144|
      |password|4314|
    Then I should click the VSP Online link

  Scenario: [1] User enters a fully filled out and valid Doctor Profile , required data setup for later tests
     Given I navigate to the practice page to monitor my profile
     When a user updates a provider <profile>
       |active|_practicingSince|_schoolName1 |_schoolName2   |_schoolName3|_schoolName4|_schoolName5|_degree1|_degree2|_degree3|_degree4|_degree5|_city1|_city2  |_city3          |_city4   |_city5   |_state1|_state2|_state3|_state4|_state5|_seeChildren03|_seeChildren35|_hardToFitContactLenses|_lowVision|_visionTherapy|_gender|_includeGenderInProfile|_includeCertificationsInProfile|_cert1|_cert2|_cert3|_cert4|_cert5|_includeAMA|_amaPinkEye|_amaGlaucoma|_amaCunjunctivitis|_amaAstigmatism|_amaCataracts|_amaMacular|_amaColorblind|_includePhoto|_pathToPhoto|lang1|lang2|_profStatement|
       |true  |2010			   |Miskatonic U |Evil University| SchoolC	  | SchoolD    |SchoolE	    |DO      |MD	  |DO	   |OD      |OD	     |Kent  |Portland|West Palm Beach |Dallas   |Tempe    |LA     |MI     |VT	  |AZ     |CA	  |true          |true          |true                   |true      |true          |F      | true 					| true 					        |cert A|cert B|cert C|cert D|cert E|true|true       |true        |true              |true      	   |true          |true        |true         |true          |			|Catalan|Chinese|I really like to be professional!|
     Then I save and publish the profile.

  Scenario: [2] I validate the published profile.
    Given I navigate to the practice page to monitor my profile
    Then I validate a previously input <profile>
      |active|_practicingSince|_schoolName1 |_schoolName2   |_schoolName3|_schoolName4|_schoolName5|_degree1|_degree2|_degree3|_degree4|_degree5|_city1|_city2  |_city3          |_city4   |_city5   |_state1|_state2|_state3|_state4|_state5|_seeChildren03|_seeChildren35|_hardToFitContactLenses|_lowVision|_visionTherapy|_gender|_includeGenderInProfile|_includeCertificationsInProfile|_cert1|_cert2|_cert3|_cert4|_cert5|_includeAMA|_amaPinkEye|_amaGlaucoma|_amaCunjunctivitis|_amaAstigmatism|_amaCataracts|_amaMacular|_amaColorblind|_includePhoto|_pathToPhoto|lang1|lang2|_profStatement|
      |true  |2010			  |Miskatonic U |Evil University| SchoolC	 | SchoolD    |SchoolE	   |DO      |MD	     |DO	  |OD      |OD	    |Kent  |Portland|West Palm Beach |Dallas   |Tempe    |LA     |MI     |VT	 |AZ	 |CA	 |true          |true         |true                   |true      |true          |F      | true 					| true 					        |cert A|cert B|cert C|cert D|cert E|true|true       |true        |true              |true      	   |true          |true        |true         |true          |			|Catalan|Chinese|I really like to be professional!|

  Scenario: [3] For provider Shahla Abedi I verify the Dr Title
    Given I navigate to the practice page to monitor my profile
    Then view the Doctor Title field I verify it displays <doctorTitle>
      |doctorTitle|Physician, Ophthalmologist|

  Scenario: [4] For provider Shahla Abedi I verify the Highlights
    Given I navigate to the practice page to monitor my profile
    Then view the Doctor Highlights field I verify it displays <highlights>
      |Welcomes new patients|
      |Offers eye exams|

  Scenario: [5] For provider Shahla Abedi I verify the Doctor Networks
    Given I navigate to the practice page to monitor my profile
    Then view the Doctor Network field I verify it displays <networks>
      |Choice|
      |Signature|
      |Advantage|
      |Medicaid |

