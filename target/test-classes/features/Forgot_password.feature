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
      
# this not possible becouse info/error is allready present 
   Scenario: Show error when password is less than six characters
   Given the user is neviget Forgot Password page
    When the user enters an registered Email and click continue button "ctforgotpass@yopmail.com"
    Then a confirmation message Password reset link has been sent to your registered email should be displayed
    When the user opens the Set Password link sent via email "ctforgotpass@yopmail.com"
    When the user enters "abc" in the Password field
    And enters "abc" in the Confirm Password field
    And clicks the Set Password button
    Then the system should display a message Password must be at least six characters long.
    
   # this not possible becouse info/error is allready present
   Scenario: Show error when password and confirm password do not match
     Given the user is neviget Forgot Password page
    When the user enters an registered Email and click continue button "ctforgotpass@yopmail.com"
    Then a confirmation message Password reset link has been sent to your registered email should be displayed
    When the user opens the Set Password link sent via email "ctforgotpass@yopmail.com"
    And the user enters "abc123" in the Password field
    And enters "abc124" in the Confirm Password field
    And clicks the Set Password button
    Then the system should display a message Password must match
    
    @sdfgset
     Scenario: Show error when password is empty
    Given the user is neviget Forgot Password page
    When the user enters an registered Email and click continue button "ctforgotpass@yopmail.com"
    Then a confirmation message Password reset link has been sent to your registered email should be displayed
    When the user opens the Set Password link sent via email "ctforgotpass@yopmail.com"
    When the user leaves the Password field empty
    And enters "abc123" in the Confirm Password field
    And clicks the Set Password button
    Then the system should display a message Password must be entered
    
@sdfgset
  Scenario: Show error when confirm password is empty
    Given the user is neviget Forgot Password page
    When the user enters an registered Email and click continue button "ctforgotpass@yopmail.com"
    Then a confirmation message Password reset link has been sent to your registered email should be displayed
    When the user opens the Set Password link sent via email "ctforgotpass@yopmail.com"
    When the user enters "abc123" in the Password field
    And leaves the Confirm Password field empty
    And clicks the Set Password button
    Then the system should display a message Confirm Password must be entered