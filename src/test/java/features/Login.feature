Feature: Verify Login Functionality

  @Valid
  Scenario Outline: Successful login with valid credentials
    Given User is on the CheckTrack login page
    When User enters "<username>" and "<password>"
    And User clicks on the login button
    Then User should be redirected to the dashboard

    Examples: 
      | username            | password            |
      | ctdemoa@yopmail.com | ctdemoa@yopmail.com |

  @invalid
  Scenario Outline: Login attempt with invalid credentials
    Given User is on the CheckTrack login page
    When User enters invalid "<username>" and "<password>"
    And User clicks on the login button
    Then User should see a Bad credentials error message

    Examples: 
      | username                 | password           |
      | tushar_test1@yopmail.com | tushar@yopmail.com |

  @empty_username
  Scenario Outline: Login with an empty username
    Given User is on the CheckTrack login page
    When User leaves the username field empty
    And User enters a valid password "<pass>"
    And User clicks on the login button
    Then User should see a Please enter a valid email ID error message

    Examples: 
      | pass               |
      | tushar@yopmail.com |

  @empty_password
  Scenario Outline: Login with an empty password
    Given User is on the CheckTrack login page
    When User enters a valid username "<username>"
    And User leaves the password field empty
    And User clicks on the login button
    Then User should see a Password is required error message

    Examples: 
      | username           |
      | tushar@yopmail.com |

  @empty_both
  Scenario: Login with both username and password empty
    Given User is on the CheckTrack login page
    When User leaves the username and password fields empty
    And User clicks on the login button
    Then User should see an error message

  @terminated
  Scenario Outline: Login with a terminated user account
    Given User is on the CheckTrack login page
    When User enters credentials for a terminated account "<username>" and "<password>"
    And User clicks on the login button
    Then User should see a Your account has been terminated error message

    Examples: 
      | username                   | password                   |
      | terminatedEmp@yopmail.com | abc123 |

  @links1
  Scenario: Navigate to Manage CheckTrack Organization tab form login page
    Given User is on the CheckTrack login page
    When User clicks on the Manage CheckTrack Organization link
    Then Manage CheckTrack Organization tab should open

  @links2
  Scenario: Navigate to Onboard Your Organization tab form login page 
    Given User is on the CheckTrack login page
    When User clicks on the Onboard Your Organization link
    Then Onboard Your Organization tab should open
