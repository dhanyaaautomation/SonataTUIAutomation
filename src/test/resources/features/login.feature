Feature: Login Functionality

  @smoke
  Scenario: Verify successful login

    Given User launches the TUI Challenge application
    When User logs in using valid test data
    Then User should be navigated to the Home screen

  @smoke
  Scenario: Verify user can select date of birth using date picker

    Given User launches the TUI Challenge application
    When User enters username and password
    And User selects date of birth
    Then Selected date of birth should be displayed in the DOB field

  @regression
  Scenario: Verify validation when mandatory fields are empty

    Given User launches the TUI Challenge application
    When User clicks Submit without entering mandatory fields
    Then User should see mandatory field validation messages