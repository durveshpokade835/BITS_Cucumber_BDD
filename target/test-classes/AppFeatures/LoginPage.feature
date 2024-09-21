Feature: Pharmacist Login

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters the valid email "hardstop-pharmacist6@mailinator.com"
    And valid password "Password1#"
    And user clicks on Login button
    Then the user should be logged in


  Scenario: Login with invalid password and verify error message

    Given the user is on the login page
    When the user enters the valid email "hardstop-pharmacist6@mailinator.com"
    And the user enters invalid password "InvalidPassword"
    And user clicks on Login button
    Then an error message should be displayed "Wrong username/password"

  Scenario: Login with invalid email and verify error message
    Given the user is on the login page
    When the user enters an invalid email "hardstop-pharmacist6@mailinator.co"
    And valid password "Password1#"
    And user clicks on Login button
    Then I should see an error message "User not found"