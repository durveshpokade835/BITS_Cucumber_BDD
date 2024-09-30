@PatientValidationFeature
Feature: Validating Patients Data, using DataTables and examples

  @PatientValScenario
  Scenario Outline: Search for a patient by ID and validate the information
    Given user has already logged in to application and is on patient page
    And user has entered credentials
      | userId | <userID> |
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
      | userID                               | FirstName                       | LastName                     | Hosp 30d | DOB        | Sex    | Age | Pt. Lang. | Insurance #    | Insurance Co.                   |
      | 4059581a-e693-455a-8d6b-4fc5a1ea3cc6 | Hardstop                        | Select health test patient 3 | No       | 01/01/1965 | female | 59  | English   | XD723643612345 | Hardstop SelectHealth           |
      | 8db898eb-bd30-4635-aaa2-bd42abd99eff | Hardstop                        | Select health test patient 5 | No       | 01/01/1965 | female | 59  | English   | XD723643612345 | Hardstop SelectHealth           |
      | a89a0a0c-4202-4b64-949a-5e48c16d1aea | Select concierge test patient 8 | Hardstop                     | No       | 01/01/1965 | female | 59  | English   | XD723643612345 | Hardstop SelectHealth Concierge |
