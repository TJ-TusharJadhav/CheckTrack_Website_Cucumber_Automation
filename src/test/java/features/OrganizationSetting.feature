Feature: Verify Organization Setting Functionality
@UpdateCompanyName
  Scenario Outline: Update Company Name
    Given I am on the Organization Settings page "<username>" "<password>"
    And I see the current Company Name displayed
    When I click the edit icon next to Company Name
    And I enter "<New_Company_Name>" in the input field
    And I click the Save button
    Then the company name should be updated successfully
    And the new company name should be displayed "<New_Company_Name>"

    Examples: 
      | username                   | password                   | New_Company_Name           |
      | tushar_test1.6@yopmail.com | tushar_test1.6@yopmail.com | ABCDEFGHIJKLMNOPQRSTUVWXYZ |
      #| abcdefghijklmnopqrstuvwxyz |
      #|                 1234567890 |

  Scenario: Prevent saving an empty Company Name
    Given I am on the Organization Settings page
    And I click the edit icon next to Company Name
    When I clear the company name field
    And I click the Save button
    Then an error message should be displayed Company Name cannot be empty

  Scenario Outline: Cancel Editing the Company Name
    Given I am on the Organization Settings page
    And I see the current Company Name displayed
    When I click the edit icon next to Company Name
    And I enter "<New_Company_Name>" in the input field
    And I click the Cancel button
    Then the company name should remain unchanged
    And the previous company name should be displayed

    Examples: 
      | New_Company_Name             |
      | TechNova Global Pvt. Ltd.    |
      | Innovate Solutions Pvt. Ltd. |
      | AlphaTech Enterprises        |

  Scenario Outline: Update Date Format
    Given I am on the Organization Settings page
    And I see the current Date Format displayed
    When I click the edit icon next to Date Format
    And I select "<New_Date_Format>" from the dropdown
    And I click the Save button
    Then the date format should be updated successfully
    And the selected format should be displayed

    Examples: 
      | New_Date_Format |
      | MM/dd/yyyy      |
      | dd-MM-yyyy      |
      | EEE,MM/dd/yyyy  |
      | EEE,dd-MM-yyyy  |

  Scenario Outline: Cancel Editing the Date Format
    Given I am on the Organization Settings page
    And I see the current Date Format displayed
    When I click the edit icon next to Date Format
    And I select "<New_Date_Format>" from the dropdown
    And I click the Cancel button
    Then the date format should remain unchanged
    And the previous date format should be displayed

    Examples: 
      | New_Date_Format |
      | MM/dd/yyyy      |
      | dd-MM-yyyy      |
      | EEE,MM/dd/yyyy  |
      | EEE,dd-MM-yyyy  |

  Scenario Outline: Update Timezone
    Given I am on the Organization Settings page
    And I see the current Timezone displayed
    When I click the edit icon next to Timezone
    And I select "<New_Timezone>" from the dropdown
    And I click the Save button
    Then the timezone should be updated successfully
    And the selected timezone should be displayed

    Examples: 
      | New_Timezone     |
      | America/New_York |
      | Europe/London    |
      | Asia/Dubai       |

  Scenario Outline: Cancel Editing the Timezone
    Given I am on the Organization Settings page
    And I see the current Timezone displayed
    When I click the edit icon next to Timezone
    And I select "<New_Timezone>" from the dropdown
    And I click the Cancel button
    Then the timezone should remain unchanged
    And the previous timezone should be displayed

    Examples: 
      | New_Timezone     |
      | America/New_York |
      | Europe/London    |
      | Asia/Dubai       |

  Scenario Outline: Verify TAN format for validity
    Given the admin user logs in with valid credentials
    When the user opens the Tax Details form in the organization settings
    And the user enters TAN number "<TAN>" in the TAN field
    And clicks the save button
    Then "<Expected_Result>" should be displayed

    Examples: 
      | TAN          | Expected_Result                                             |
      | ABCD12345E   | Valid                                                       |
      | ABC12345E    | Invalid (incorrect format: less than 4 alphabets in prefix) |
      | ABCD1234E    | Invalid (incorrect length: less than 10 characters)         |
      | ABCD1234567E | Invalid (incorrect length: more than 10 characters)         |
      | 1BCD12345E   | Invalid (incorrect format: non-alphabet in prefix)          |
      | ABCD12A45E   | Invalid (incorrect format: non-digit in numeric sequence)   |
      | ABCD12345#   | Invalid (incorrect format: non-alphabet in suffix)          |
      | abcd12345e   | Invalid (incorrect format: lowercase letters used)          |
      | ABCD-12345E  | Invalid (incorrect format: special character included)      |
      | ABCD 12345E  | Invalid (incorrect format: spaces included)                 |

  Scenario Outline: Validate input in PAN field
    Given the admin user logs in with valid credentials
    When the user opens the Tax Details form in the organization settings
    And the user enters "<input>" in the PAN field
    And clicks the save button
    Then the system should "<Expected_Result>"

    Examples: 
      | input        | Expected_Result                                      |
      | ABCDE1234F   | accept only valid PAN numbers                        |
      | ABCD@1234F   | reject input with special characters                 |
      | ABCD123F     | reject input with less than 10 characters            |
      | ABCDE12345FG | reject input with more than 10 characters            |
      |   1234567890 | reject input with only numbers                       |
      | ABCDEFGHIJ   | reject input with only letters                       |
      | abcde1234f   | reject input with lowercase letters                  |
      | AbCdE1234F   | reject input with mixed case letters                 |
      | A1B2C3D4E5   | reject input with incorrect letter positions         |
      |              | reject empty input                                   |
      | ABCD 1234F   | reject input with whitespace                         |
      | ABCDE1234F@  | reject input with special characters at the end      |
      |   1234512345 | reject input with numbers in place of letters        |
      | ABCDEABCDE   | reject input with letters in place of numbers        |
      | ABCDE1234F   | remove leading and trailing spaces before validation |

  Scenario Outline: Validate input in GSTIN field
    Given the admin user logs in with valid credentials
    When the user opens the Tax Details form in the organization settings
    And the user enters "<GSTIN_Input>" in the GSTIN field
    And the click save button
    Then "<Expected_Result>"

    Examples: 
      | GSTIN_Input     | Expected_Result                                          |
      | 22AAAAA0000A1Z5 | Only valid GST numbers should be accepted                |
      | 22AAAA000A1Z5   | Incorrect length GST numbers should not be accepted      |
      | 22AAAAA0000A1Z$ | Invalid characters in GST numbers should not be accepted |
      | 27AAAAA0000A1Z5 | Different state codes should be accepted                 |
      | 22AAAAA000A1Z   | Short GST numbers should not be accepted                 |
      |                 | Empty input should not be accepted                       |
      | 22AAAAA0000A1Z@ | Special characters in GST numbers should not be accepted |

  Scenario: Registered Business address
    Given the admin user logs in with valid credentials
    When the user opens the Tax Details form in the organization settings
    And Click the address field
    Then Campnay address list should be displayed
    And Selected address should be displayed

  Scenario: Empty input and error
    Given the admin user logs in with valid credentials
    And registered business address is not save
    When the user opens the Tax Details form in the organization settings
    And click the save button
    Then Empty field should not accept
    And Error should be shown in registered business address field

  Scenario: Data validation
    Given the admin user logs in with valid credentials
    When the user opens the Tax Details form in the organization settings
    And Fill the form and click the save button
    Then Enterd Data should be save

  Scenario: Display Registered Business Address on Payslip
    Given the registered business address has been saved,
    And a payroll process has been approved,
    And the user logs in with valid credentials,
    When the user downloads the payslip,
    Then the selected registered business address should be shown on the payslip.

  Scenario: Setting cut-off date for reimbursement
    Given the user is on the Reimbursement Configuration page
    When the user selects a cut-off date from the dropdown
    And clicks the Save button
    Then the selected cut-off date should be saved and applied for the reimbursement cycle

  Scenario: User submits a reimbursement request during the current cycle
    Given the admin/HR has set the cut-off date in the Reimbursement configuration
    When the user submits their request during the current cycle
    Then Submitted reimbursement request will be processed in the current cycle success message should be displayed

  Scenario: User submits a reimbursement request during the upcoming cycle
    Given the admin/HR has set the cut-off date in the Reimbursement configuration
    When the user submits their request during the upcoming cycle
    Then Submitted reimbursement request will be processed in the coming cycle success message should be displayed

  Scenario Outline: Add a new work location
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I enter "<Address>" in the Address field
    And I select "<Country>" from the Country dropdown
    And I select "<State>" from the State dropdown
    And I select "<City>" from the City dropdown
    And I enter "<Pincode>" in the Pincode field
    And I click the Save button
    Then the new work location should be added successfully
    And I should see "<Address>" "<City>" "<State>" "<Country>" "<Pincode>" in the Work Locations list

    Examples: 
      | Address              | Country        | State      | City      | Pincode  |
      | 1234 Tech Street     | United states  | California | San Jose  |    95112 |
      | 456 MG Road          | India          | Karnataka  | Bengaluru |   560001 |
      | Suite 78, Downing St | United Kingdom | England    | London    | SW1A 2AA |

  Scenario Outline: Edit an existing work location
    Given I am on the Organization Settings page
    And I see the Work Locations section
    And there is an existing work location "<ExistingAddress>"
    When I click the edit icon next to the work location
    And I update the Address field with "<NewAddress>"
    And I update the Country to "<NewCountry>"
    And I update the State to "<NewState>"
    And I update the City to "<NewCity>"
    And I update the Pincode to "<NewPincode>"
    And I click the Save button
    Then the work location should be updated successfully
    And I should see "<NewAddress>" "<NewCity>" "<NewState>" "<NewCountry>" "<NewPincode>" in the Work Locations list

    Examples: 
      | ExistingAddress      | NewAddress         | NewCountry     | NewState  | NewCity   | NewPincode |
      | 1234 Tech Street     | 5678 Innovation Rd | United states  | Texas     | Austin    |      73301 |
      | 456 MG Road          | 789 Brigade Road   | India          | Karnataka | Bengaluru |     560002 |
      | Suite 78, Downing St | 10 Baker Street    | United Kingdom | England   | London    | W1U 3AH    |

  Scenario Outline: Cancel adding a new work location
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I enter "<Address>" in the Address field
    And I select "<Country>" from the Country dropdown
    And I select "<State>" from the State dropdown
    And I select "<City>" from the City dropdown
    And I enter "<Pincode>" in the Pincode field
    And I click the Cancel button
    Then the work location should not be added
    And I should not see "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"  in the Work Locations list

    Examples: 
      | Address              | Country        | State      | City      | Pincode  |
      | 1234 Tech Street     | United states  | California | San Jose  |    95112 |
      | 456 MG Road          | India          | Karnataka  | Bengaluru |   560001 |
      | Suite 78, Downing St | United Kingdom | England    | London    | SW1A 2AA |

  Scenario Outline: Delete an existing work location
    Given I am on the Organization Settings page
    And I see the Work Locations section
    And there is an existing work location "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    When I click the delete icon next to the work location
    And I confirm the deletion in the confirmation dialog
    Then the work location should be removed from the Work Locations list
    And I should not see "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"  in the list

    Examples: 
      | Address              | Country        | State      | City      | Pincode  |
      | 1234 Tech Street     | United states  | California | San Jose  |    95112 |
      | 456 MG Road          | India          | Karnataka  | Bengaluru |   560001 |
      | Suite 78, Downing St | United Kingdom | England    | London    | SW1A 2AA |

  Scenario Outline: Cancel deletion of a work location
    Given I am on the Organization Settings page
    And I see the Work Locations section
    And there is an existing work location "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    When I click the delete icon next to the work location
    And I cancel the deletion in the confirmation dialog
    Then the work location should still be present in the "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"  list

    Examples: 
      | Address              | Country        | State      | City      | Pincode  |
      | 1234 Tech Street     | United states  | California | San Jose  |    95112 |
      | 456 MG Road          | India          | Karnataka  | Bengaluru |   560001 |
      | Suite 78, Downing St | United Kingdom | England    | London    | SW1A 2AA |
