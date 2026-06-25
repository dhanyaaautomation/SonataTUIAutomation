Feature: Home Page Functionality

  @regression
  Scenario: Verify user can scroll through search results

    Given User launches the TUI Challenge application
    When User logs in using valid test data
    And User scrolls till end of the results list
    Then Application should remain stable without crashing

  @smoke
  Scenario: Verify Home screen tabs are displayed and accessible

    Given User launches the TUI Challenge application
    When User logs in using valid test data
    And User clicks Hotels tab
    Then Hotels tab should be selected
    When User clicks Holidays tab
    Then Holidays tab should be selected
    When User clicks All tab
    Then All tab should be selected