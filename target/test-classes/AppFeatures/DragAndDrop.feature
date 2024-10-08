@DragAndDrop
Feature: Validate drag and drop functionality

  @testScenario1
  Scenario Outline: Validate table column order after drag and drop
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    Then the user should be logged in
    And User clicks on the Patient button for patient search
    And User enters the patient ID "<patientId>"
    And User is on the table page
    When User drags the "<Source Column>" and drops it on "<Destination Column>"
    Then The new column index sequence should be:
      | Column         |
      | Priority       |
      | Status         |
      | Due Date       |
      | Task           |
      | Name           |
      | Phone          |
      | Note           |
      | Assigned To    |
      | Recipient Role |
      | Recipient Name |
      | Language       |
      | GNR Date (Adh) |
    Examples:
      | userName                            | password   | patientId                            | Source Column | Destination Column |
      | hardstop-pharmacist6@mailinator.com | Password1# | da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9 | Due Date      | Status             |

  @testScenario2
  Scenario Outline: Validate List order after drag and drop
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    Then the user should be logged in
    And User clicks on the Patient button for patient search
    And User enters the patient ID "<patientId>"
    And User is on the table page
    When User drags the "<Source Column>" and drops it on "<Destination Column>" from show hide section
    Then The new column index sequence in a list should be:
      | Column         |
      | Priority       |
      | Status         |
      | Due Date       |
      | Task           |
      | Name           |
      | Phone          |
      | Note           |
      | Assigned To    |
      | Recipient Role |
      | Recipient Name |
      | Language       |
      | GNR Date (Adh) |
    Examples:
      | userName                            | password   | patientId                            | Source Column | Destination Column |
      | hardstop-pharmacist6@mailinator.com | Password1# | da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9 | Due Date      | Status             |


  @testScenario3
  Scenario Outline: Validate reset functionality
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    Then the user should be logged in
    And User clicks on the Patient button for patient search
    And User enters the patient ID "<patientId>"
    And User is on the table page
    When User drags the "<Source Column>" and drops it on "<Destination Column>" from show hide section
    And User clicks on Reset Button
    Then The new column index sequence in a list should be:
      | Column         |
      | Due Date       |
      | Priority       |
      | Status         |
      | Task           |
      | Name           |
      | Phone          |
      | Note           |
      | Assigned To    |
      | Recipient Role |
      | Recipient Name |
      | Language       |
      | GNR Date (Adh) |
    Examples:
      | userName                            | password   | patientId                            | Source Column | Destination Column |
      | hardstop-pharmacist6@mailinator.com | Password1# | da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9 | Due Date      | Status             |