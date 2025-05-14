
Feature: Verify Payslips Functionality
Background: 
  Given the user is logged in
  
  Scenario: Display Registered Business Address on Payslip
    Given the registered business address has been saved,
    And a payroll process has been approved,
    When the user downloads the payslip,
    Then the selected registered business address should be shown on the payslip.
