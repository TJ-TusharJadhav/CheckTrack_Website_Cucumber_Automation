@localization
Feature: Verify localization functionality


 @Hindi
  Scenario: Verify language change functionality for Hindi
    Given the user is on the login page
    When the user selects Hindi from the language options
    Then the email text should be displayed in Hindi "Email"
    And the password text should be displyed in Hindi "password"
    And the forgotPassword text should be displyed in Hindi "forgotPassword"
    And the loginButton text should be displyed in Hindi "loginButton"
    And the language text should be displyed in Hindi "language"
    And the version text should be displyed in Hindi "version"

  @Gujarati
  Scenario: Verify language change functionality for Gujarati
    Given the user is on the login page
    When the user selects Gujarati from the language options
    Then the email text should be displayed in Gujarati "Email"
    And the password text should be displyed in Gujarati "password"
    And the forgotPassword text should be displyed in Gujarati "forgotPassword"
    And the loginButton text should be displyed in Gujarati "loginButton"
    And the language text should be displyed in Gujarati "language"
    And the version text should be displyed in Gujarati "version"

  @Marathi
 Scenario: Verify language change functionality for Marathi
    Given the user is on the login page
    When the user selects Marathi from the language options
    Then the email text should be displayed in Marathi "Email"
    And the password text should be displyed in Marathi "password"
    And the forgotPassword text should be displyed in Marathi "forgotPassword"
    And the loginButton text should be displyed in Marathi "loginButton"
    And the language text should be displyed in Marathi "language"
    And the version text should be displyed in Marathi "version" 

  @English
  Scenario: Verify language change functionality for English
    Given the user is on the login page
    When the user selects English from the language options
    Then the email text should be displayed in English "Email"
    And the password text should be displyed in English "password"
    And the forgotPassword text should be displyed in English "forgotPassword"
    And the loginButton text should be displyed in English "loginButton"
    And the language text should be displyed in English "language"
    And the version text should be displyed in English "version"
    