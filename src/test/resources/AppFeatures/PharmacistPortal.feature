@advanceSearch
Feature: Pharmacist Portal Advance Search Feature

#  Background:
#
#  Scenario Outline: SETUP: Open Application And Login to the System
#    Given the user is on the login page "https://pharmacist-dev.arine.io/"
#    When User login with "<userName>" and "<password>"
#    And user clicks on Login button
#    Then the user should be logged in
#    Examples:
#      | userName                            | password   |
#      | hardstop-pharmacist6@mailinator.com | Password1# |

  @testScenario4
  Scenario: Verify that the Advanced Search popup opens successfully.
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "hardstop-pharmacist6@mailinator.com" and "Password1#"
    And user clicks on Login button
    When the user clicks on Patient button and ADVANCED text button
    Then the Advanced Patient Search popup should open

#  Scenario: Verify if the results are displayed when user enters First Name
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And user enters First Name "Hardstop"
#    And user clicks on Search button
#    Then the result should get displayed
#    And the First Name "Hardstop" should get displayed

#  Scenario: Verify if the results are displayed when user enters Last Name
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And user enters Last Name "Select health test patient 1"
#    And user clicks on Search button
#    Then the result should get displayed
#    And the Last Name "Select health test patient 1" should get displayed

#  Scenario: Verify if the results are displayed when user enters FirstName and City
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And user enters First Name "Hardstop"
#    And user enters City "Test City"
#    And user clicks on Search button
#    Then the result should get displayed
#    And the First Name "Hardstop" should get displayed
#    And the City Name "Test City" should get displayed

#  Scenario: Error Validation - Verify if the results are displayed when user enters City
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And user enters City "Test City"
#    And user clicks on Search button
#    Then the error pop up should appear "You must provide first or last name."

#  Scenario: Verify if the results are displayed when user enters FirstName and Selects State
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And user enters First Name "Hardstop"
#    And user selects State "California"
#    And user clicks on Search button
#    Then the result should get displayed
#    And the First Name "Hardstop" should get displayed
#    And the State "California" should get displayed

#  Scenario: Error Validation - Verify if the results are displayed when user Selects State
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And user selects State "California"
#    And user clicks on Search button
#    Then the error pop up should appear "You must provide first or last name."

#  Scenario: Verify if the results are displayed when user enters First Name and Zip Code
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And user enters First Name "Hardstop"
#    And User enters "99999" as Zip Code
#    And user clicks on Search button
#    Then the result should get displayed
#    And the First Name "Hardstop" should get displayed
#    And the ZipCode "99999" should get displayed

#verify
#  Scenario: Negative test scenario - Verify if the results are displayed when user enters Zip Code in invalid format
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "123" as Zip Code
#    And user clicks on Search button
#    Then Tooltip error message: "Please match the format requested." should display for Zip Code

#  Scenario: Verify if the results are displayed when user enters Phone Number
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "111-111-1111" as Phone
#    And user clicks on Search button
#    Then the result should get displayed
#    And the Phone "111-111-1111" should get displayed

    #verify
#  Scenario: Negative test scenario - Verify if the results are displayed when user enters Phone Number in invalid format
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "111-111-111" as Phone
#    And user clicks on Search button
#    Then Tooltip error message: "Please match the format requested." should display for Phone Number

#  Scenario: Verify if the results are displayed when user enters Birth Date
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "01/01/1965" as Birth Date
#    And user clicks on Search button
#    Then the result should get displayed
#    And the date "01/01/1965" should get displayed

#verify
#  Scenario: Negative test scenario - Verify if the results are displayed when user enters Birth Date in invalid format
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "32/01/19" as Birth Date
#    And user clicks on Search button
#    Then Tooltip error message: "Please match the format requested." should display for Birth Date

#  Scenario: Enter HPID and verify results
##    Given the user should be logged in
#    When the user clicks on Patient button and ADVANCED text button
#    And User enters "XD723643612345" as HPID
#    And user clicks on Search button
#    Then the result should get displayed
#    And the HPID "XD723643612345" should get displayed

#----------------------------------------------------------------------------------------------------------------
  @testScenario1
  Scenario Outline: Verify if the results are displayed when user enters specific Field
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    And the user clicks on Patient button and ADVANCED text button
    And user enters specific field
      | First Name | <First Name> |
      | Last Name  | <Last Name>  |
      | City       | <City>       |
      | State      | <State>      |
      | Zip Code   | <Zip Code>   |
      | Phone      | <Phone>      |
      | Birth Date | <Birth Date> |
      | HPID       | <HPID>       |
    And user clicks on Search button
    Then the result should get displayed
    And the "<Result>" should get displayed
    Examples:
      | userName                            | password   | First Name | Last Name                    | City      | State      | Zip Code | Phone        | Birth Date | HPID           | Result                       |
      | hardstop-pharmacist6@mailinator.com | Password1# | Hardstop   |                              |           |            |          |              |            |                | Hardstop                     |
      | hardstop-pharmacist6@mailinator.com | Password1# |            | Select health test patient 1 |           |            |          |              |            |                | Select health test patient 1 |
      | hardstop-pharmacist6@mailinator.com | Password1# | Hardstop   |                              | Test City |            |          |              |            |                | Test City                    |
      | hardstop-pharmacist6@mailinator.com | Password1# | Hardstop   |                              |           | California |          |              |            |                | CA                           |
      | hardstop-pharmacist6@mailinator.com | Password1# | Hardstop   |                              |           |            | 99999    |              |            |                | 99999                        |
      | hardstop-pharmacist6@mailinator.com | Password1# |            |                              |           |            |          | 111-111-1111 |            |                | 111-111-1111                 |
      | hardstop-pharmacist6@mailinator.com | Password1# |            |                              |           |            |          |              | 01/01/1965 |                | 01/01/1965                   |
      | hardstop-pharmacist6@mailinator.com | Password1# |            |                              |           |            |          |              |            | XD723643612345 | XD723643612345               |

    #-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  @testScenario2
  Scenario Outline: Error Validation - Verify if the results are displayed when user enters specific fields
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    And the user clicks on Patient button and ADVANCED text button
    And user enters specific field
      | City  | <City>  |
      | State | <State> |
    And user clicks on Search button
    And the error pop up should appear "<Result>"
    Examples:
      | userName                            | password   | City      | State      | Result                               |
      | hardstop-pharmacist6@mailinator.com | Password1# | Test City |            | You must provide first or last name. |
      | hardstop-pharmacist6@mailinator.com | Password1# |           | California | You must provide first or last name. |

    #--------------------------------------------------------------------------------------------------------------------------------
  @testScenario3
  Scenario Outline: Verify if the results are displayed when user enters specific Field
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    And the user clicks on Patient button and ADVANCED text button
    And user enters specific field
      | Zip Code   | <Zip Code>   |
      | Phone      | <Phone>      |
      | Birth Date | <Birth Date> |
    And user clicks on Search button
    Then Tooltip error message: "<Result>" should display for "<Field Locator>"
    Examples:
      | userName                            | password   | Zip Code | Phone       | Birth Date | Result                             | Field Locator             |
      | hardstop-pharmacist6@mailinator.com | Password1# | 123      |             |            | Please match the format requested. | //input[@name='zip_code'] |
      | hardstop-pharmacist6@mailinator.com | Password1# |          | 111-111-111 |            | Please match the format requested. | //input[@name='phone']    |
      | hardstop-pharmacist6@mailinator.com | Password1# |          |             | 32/01/19   | Please match the format requested. | //input[@name='dob']      |

