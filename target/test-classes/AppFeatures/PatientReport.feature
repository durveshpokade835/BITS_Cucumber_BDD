@patientSearch
Feature: Patient Search Functionality

  @patientSearchDate
  Scenario Outline: Search for a patient by ID and set a review date
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    And User clicks on the Patient button for patient search
    And User enters the patient ID "<patientId>"
    And User clicks Reports button, MTM Reports button and selects CMR review type
    And User selects the date <number of days> days back
    Then User clicks on the Date Conversation button
    Examples:
      | userName                            | password   | patientId                            | number of days |
      | hardstop-pharmacist6@mailinator.com | Password1# | 537a6caf-8df4-4da5-8238-f74030728005 | 10             |
      | hardstop-pharmacist6@mailinator.com | Password1# | da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9 | 10             |