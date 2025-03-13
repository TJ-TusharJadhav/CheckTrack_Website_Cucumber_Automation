Feature: Verify Forgot Password Functionality

  @tag1
  Scenario: Unsuccessful password recovery with unregistered email
    Given the user is on the CheckTrack Forgot Password page
    When the user enters an unregistered Email "tushar_3489_test@yopmail.com"
    And the user clicks on the Continue button
    Then an error message Email is not registered should be displayed

  Scenario: Unsuccessful password recovery with empty email field
    Given the user is on the CheckTrack Forgot Password page
    When the user leaves the Email field empty
    And the user clicks on the Continue button
    Then an error message Please enter a valid email address should be displayed

  Scenario Outline: User resets the password and logs in successfully
    Given the user is on the Forgot Password page of CheckTrack
    When the user enters a registered Email "<Email>"
    And the user clicks on the Continue button
    Then a confirmation message Password reset link has been sent to your registered email should be displayed
    And Set password link should be send in registered email
    When the user opens the Set Password link sent via email
    And the user sets a new password "<Password>"
    Then the user should be able to log in successfully with the newly set password "<Email>" "<Password>"

    Examples: 
      | Email                   | Password |
      | sagarthorat@yopmail.com | abc123   |
