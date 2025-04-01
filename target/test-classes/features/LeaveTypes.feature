Feature: Verify leave types Functionality

  Background: 
    Given HR logged into the CheckTrack application
    And HR navigate to the Leave Types section

  Scenario Outline: Check bydefolt added leave types
    Given I am on the Leave Managemen page
    And I navigate to the Leave Types section
    And I click on the Add Leave Type button
    When I enter <Types> in the Type input field
    And I enter <input_value> in the Description input field
    And I click the Save button
    Then the leave type should be added successfully

    Examples: 
      | Types                                      | input_value                |
      | Number: 1234567890                         |                 1234567890 |
      | Capital letter: ABCDEFGHIJKLMNOPQRSTUVWXYZ | ABCDEFGHIJKLMNOPQRSTUVWXYZ |
      | Small letter: abcdefghijklmnopqrstuvwxyz   | abcdefghijklmnopqrstuvwxyz |
