Feature: Pharmacist Portal Advance Search Feature

  Background:
    Given user has already logged in to application
      | username                            | password   |
      | hardstop-pharmacist6@mailinator.com | Password1# |

  Scenario: Verify that the Advanced Search popup opens successfully.
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    Then the Advanced Patient Search popup should open

  Scenario: Verify if the results are displayed when user enters First Name
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user enters First Name "Hardstop"
    And user clicks on Search button
    Then the result should get displayed
    And the First Name "Hardstop" should get displayed

  Scenario: Verify if the results are displayed when user enters Last Name
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user enters Last Name "Select health test patient 1"
    And user clicks on Search button
    Then the result should get displayed
    And the Last Name "Select health test patient 1" should get displayed

  Scenario: Verify if the results are displayed when user enters FirstName and City
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user enters First Name "Hardstop"
    And user enters City "Test City"
    And user clicks on Search button
    Then the result should get displayed
    And the First Name "Hardstop" should get displayed
    And the City Name "Test City" should get displayed

  Scenario: Error Validation - Verify if the results are displayed when user enters City
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user enters City "Test City"
    And user clicks on Search button
    Then the error pop up should appear "You must provide first or last name."

  Scenario: Verify if the results are displayed when user enters FirstName and Selects State
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user enters First Name "Hardstop"
    And user selects State "California"
    And user clicks on Search button
    Then the result should get displayed
    And the First Name "Hardstop" should get displayed
    And the State "California" should get displayed

  Scenario: Error Validation - Verify if the results are displayed when user Selects State
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user selects State "California"
    And user clicks on Search button
    Then the error pop up should appear "You must provide first or last name."

  Scenario: Verify if the results are displayed when user enters Zip Code
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user enters First Name "Hardstop"
    And User enters "99999" as Zip Code
    And user clicks on Search button
    Then the result should get displayed
    And the First Name "Hardstop" should get displayed
    And the ZipCode "99999" should get displayed

#verify
#  Scenario: Negative test scenario - Verify if the results are displayed when user enters Zip Code in invalid format
#    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "99999" as Zip Code
#    And user clicks on Search button
#    Then the error pop up should appear "You must provide first or last name."

  Scenario: Verify if the results are displayed when user enters Phone Number
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And User enters "111-111-1111" as Phone
    And user clicks on Search button
    Then the result should get displayed
    And the Phone "111-111-1111" should get displayed

#  Scenario: Negative test scenario - Verify if the results are displayed when user enters Phone Number in invalid format
#    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "111-111-1111" as Phone
#    And user clicks on Search button
#    Then the result should get displayed
#    And And the Code "111-111-1111" should get displayed

  Scenario: Verify if the results are displayed when user enters Birth Date
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And User enters "01/01/1965" as Birth Date
    And user clicks on Search button
    Then the result should get displayed
    And the date "01/01/1965" should get displayed

#  Scenario: Negative test scenario - Verify if the results are displayed when user enters Birth Date in invalid format
#    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "01/01/1965" as Birth Date
#    And user clicks on Search button
#    Then the result should get displayed
#    And And the Code "01/01/1965" should get displayed

  Scenario: Enter HPID and verify results
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And User enters "XD723643612345" as HPID
    And user clicks on Search button
    Then the result should get displayed
    And the HPID "XD723643612345" should get displayed

