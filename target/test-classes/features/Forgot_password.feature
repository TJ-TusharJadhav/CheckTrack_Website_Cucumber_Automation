Feature: Verify Forgot Password Functionality

  Scenario: Unsuccessful password recovery with unregistered email
    Given the user is neviget Forgot Password page
    When the user enters an unregistered Email and click continue button "tushar_3489_test@yopmail.com"
    Then This Email is not registered message should be displayed

  Scenario: Unsuccessful password recovery with empty email field
    Given the user is neviget Forgot Password page
    When the user clicks on the Continue button leaves the Email field empty
    Then Please enter a valid email address message should be displayed

  @tag1
  Scenario Outline: User resets the password and logs in successfully
    Given the user is neviget Forgot Password page
    When the user enters an registered Email and click continue button "<Email>"
    Then a confirmation message Password reset link has been sent to your registered email should be displayed
    When the user opens the Set Password link sent via email "<Email>"
    And the user sets a new password <Password>
    Then the user should be able to log in successfully with the newly set password "<Email>" <Password>

    Examples: 
      | Email                   |
      | ctforgotpass@yopmail.com |
