@PatientValidationFeature
Feature: Validating Patients Data, using DataTables and examples

#  @Setup
#  Scenario Outline: SETUP: Open Application And Login to the System
#    Given the user is on the login page "https://pharmacist-dev.arine.io/"
#    When User login with "<userName>" and "<password>"
#    And user clicks on Login button
#    Then the user should be logged in
#    Examples:
#      | userName                            | password   |
#      | hardstop-pharmacist6@mailinator.com | Password1# |

  @PatientValScenario
  Scenario Outline: Search for a patient by ID and validate the information
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    And User clicks on the Patient button for patient search
    And user has entered credentials "<userID>"
    And User tries to validate the information
    Then User verifies the data
      | FirstName     | <FirstName>     |
      | LastName      | <LastName>      |
      | Hosp 30d      | <Hosp 30d>      |
      | DOB           | <DOB>           |
      | Sex           | <Sex>           |
      | Age           | <Age>           |
      | Pt. Lang.     | <Pt. Lang.>     |
      | Insurance #   | <Insurance #>   |
      | Insurance Co. | <Insurance Co.> |
    Examples:
      | userName                            | password   | userID                               | FirstName                       | LastName                     | Hosp 30d | DOB        | Sex    | Age | Pt. Lang. | Insurance #    | Insurance Co.                   |
      | hardstop-pharmacist6@mailinator.com | Password1# | da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9 | Hardstop                        | Select health test patient 1 | No       | 01/01/1965 | female | 59  | English   | XD723643612345 | Hardstop SelectHealth           |
      | hardstop-pharmacist6@mailinator.com | Password1# | 6c3f2efb-c0fa-464d-a7fc-a0065407b9e5 | Hardstop                        | Select health test patient 4 | No       | 01/01/1965 | female | 59  | English   | XD723643612345 | Hardstop SelectHealth           |
      | hardstop-pharmacist6@mailinator.com | Password1# | a89a0a0c-4202-4b64-949a-5e48c16d1aea | Select concierge test patient 8 | Hardstop                     | No       | 01/01/1965 | female | 59  | English   | XD723643612345 | Hardstop SelectHealth Concierge |
