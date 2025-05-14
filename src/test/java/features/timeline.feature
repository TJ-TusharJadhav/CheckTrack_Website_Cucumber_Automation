Feature: Validate Time Entry Functionlity
Background: 
  Given the user is logged in

  @ValidTimeEntry
  Scenario Outline: Add and validate new time entry
    When the user navigates to the timeline page
    And selects the date "<date>"
    And selects the time "<Time>"
    Then the time entry should be saved successfully with the selected date and time

    Examples: 
      | date             | Time              |
      | 25 November 2025 | 10 10 AM 10 10 PM |
