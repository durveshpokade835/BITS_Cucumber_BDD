@loginFeature
Feature: Pharmacist Login


  @Setup @login
  Scenario Outline: SETUP: Open Application And Login to the System
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    Then the user should be logged in
    Examples:
      | userName                            | password   |
      | hardstop-pharmacist6@mailinator.com | Password1# |


  Scenario Outline: SETUP: Open Application And Login to the System
    Given the user is on the login page "https://pharmacist-dev.arine.io/"
    When User login with "<userName>" and "<password>"
    And user clicks on Login button
    Then the user should see an error message "<errorMsg>"
    Examples:
      | userName                            | password        | errorMsg                |
      | hardstop-pharmacist6@mailinator.com | InvalidPassword | Wrong username/password |
      | hardstop-pharmacist6@mailinator.co  | Password1#      | User not found          |