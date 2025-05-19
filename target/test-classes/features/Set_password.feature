Feature: Verify Set password Functionality

  @tag1
  Scenario: User enters mismatched passwords
    Given the user is on the Set Password page of CheckTrack
    When the user enters a valid Password in the Password field "abc123"
    And a different password in the Confirm Password field "123abc"
    And the user clicks on the Set Password button
    Then an error message Password must match should be displayed

  Scenario: User enters a password with fewer than six characters
    Given the user is on the Set Password page of CheckTrack
    When the user enters a Password with fewer than six characters "abc12"
    And the user clicks on the Set Password button
    Then an error message Password must be at least six characters long should be displayed
