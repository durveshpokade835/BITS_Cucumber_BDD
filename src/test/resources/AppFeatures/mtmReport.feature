#Feature: Pharmacist Portal mtm Report Feature
#
#  Background:
#    Given user has already logged in to application and is on patient page
#      | username                            | password   |
#      | hardstop-pharmacist6@mailinator.com | Password1# |
##    And the user clicks on Patient button
#
#  Scenario: Verify that the appropriate date gets selected according to the condition
#    Given the user is on the Patient page
##    When the user clicks on Patient button
#    When enters Id "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9"
#    And the user clicks on Search button then report button and MTM Reports button
#    And the user selects CMR as review type
#    And the user select a date "10" days before the current date
#    And the user clicks on Set Conversation Date Button
#    Then the pop up msg should get displayed "The date of the conversation with the patient has been set to 09/24/2024"