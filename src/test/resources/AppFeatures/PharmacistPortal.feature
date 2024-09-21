Feature: Pharmacist Portal Advance Search Feature

  Background:
    Given user has already logged in to application
    |username|password|
    |hardstop-pharmacist6@mailinator.com|Password1#|

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

  Scenario: Verify if the results are displayed when user enters City
    Given the user should be logged in
    When the user clicks on Patient button and ADVANCED text button
    And user enters City "Test City"
    And user clicks on Search button
    Then the error pop up should appear "You must provide first or last name."



