Feature: Verify Organization Setting Functionality

  Background: 
    Given the user is logged in

  @Update_CompanyName
  Scenario Outline: Update Company Name
    Given I am on the Organization Settings page
    And I click the edit icon next to Company Name
    And I enter "<New_Company_Name>" in the input field
    And I click the Save button on company name
    Then the new company name should be displayed "<New_Company_Name>"

    Examples: 
      | New_Company_Name             |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZ   |
      | abcdefghijklmnopqrstuvwxyz   |
      |                   1234567890 |
      | ~!@$%^&()_+{}:<>?`-=[]\\;,./ |
      | TechNova Global Pvt. Ltd.    |
      | TechNova 1                   |
      | TechNova 2                   |

  Scenario: Prevent saving an empty Company Name
    Given I am on the Organization Settings page
    And I click the edit icon next to Company Name
    When I clear the company name field
    And I click the Save button on company name
    Then an error message should be displayed Company Name cannot be empty

  Scenario Outline: Cancel Editing the Company Name
    Given I am on the Organization Settings page
    And I see the current Company Name displayed
    When I click the edit icon next to Company Name
    And I enter "<New_Company_Name>" in the input field
    And I click the Cancel button on company name
    Then the previous company name should be displayed

    Examples: 
      | New_Company_Name          |
      | TechNova Global Pvt. Ltd. |

  @date
  Scenario Outline: Update Date Format
    Given I am on the Organization Settings page
    When I click the edit icon next to Date Format
    And I select "<New_Date_Format>" from the dropdown
    And I click the Save button on date format
    Then the selected "<New_Date_Format>" date format should be displayed.

    Examples: 
      | New_Date_Format |
      | MM/dd/yyyy      |
      | EEE, MM/dd/yyyy |
      | EEE, dd/MM/yyyy |
      | dd/MM/yyyy      |

  @date
  Scenario Outline: Cancel Editing the Date Format
    Given I am on the Organization Settings page
    And I see the current Date Format displayed
    When I click the edit icon next to Date Format
    And I select "<New_Date_Format>" from the dropdown
    And I click the Cancel button on date format
    And the previous date format should be displayed

    Examples: 
      | New_Date_Format |
      | MM/dd/yyyy      |
      | EEE, MM/dd/yyyy |
      | EEE, dd/MM/yyyy |
      | dd/MM/yyyy      |

  @Timezone123asd
  Scenario Outline: Update Timezone
    Given I am on the Organization Settings page
    When I click the edit icon to select new Timezone
    And I select timezone from the dropdown "<New_Timezone>"
    And I click the Save button on timezone
    Then the selected timezone should be displayed "<New_Timezone>"
    And selected timezone should be displaye in add team member form "<New_Timezone>"

    Examples: 
      | New_Timezone       |
      | Africa/Abidjan     |
      | Africa/Accra       |
      | Africa/Addis_Ababa |
      | Africa/Algiers     |
      | Africa/Asmara      |

  @Timezone123asd
  Scenario Outline: Cancel Editing the Timezone
    Given I am on the Organization Settings page
    And I see the current Timezone displayed
    When I click the edit icon to select new Timezone
    And I select "<New_Timezone>" from the dropdown
    And I click the Cancel button
    Then the previous timezone should be displayed

    Examples: 
      | New_Timezone       |
      | Africa/Abidjan     |
      | Africa/Accra       |
      | Africa/Addis_Ababa |
      | Africa/Algiers     |
      | Africa/Asmara      |

  @Add_Work_location
  Scenario Outline: Add a new work location
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I fill Add Work Location form "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    Then the new work location should be added to the list "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"

    Examples: 
      | Address                | City            | State       | Country | Pincode |
      | 101, Galaxy Heights    | Mumbai          | Maharashtra | India   |  123456 |
      | 22, Lotus Apartments   | New Delhi       | Delhi       | India   |  234567 |
      | 303, Sunrise Residency | Bangalore Rural | Karnataka   | India   |  345678 |
      | 55, Palm Beach Road    | Chennai         | Tamil Nadu  | India   |  456789 |
      | 88, Green Park Colony  | Hyderabad       | Telangana   | India   |  567890 |

  @Add_and_Edit_Work_location
  Scenario Outline: Add and Edit Work Location Successfully
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I fill Add Work Location form "<addAddress>" "<addCity>" "<addState>" "<addCountry>" "<addPincode>"
    And I click the edit icon on work location list "<addAddress>" "<addCity>" "<addState>" "<addCountry>" "<addPincode>"
    And I edit the Work Location "<editAddress>" "<editCity>" "<editState>" "<editCountry>" "<editPincode>"
    Then the work location should be updated successfully "<editAddress>" "<editCity>" "<editState>" "<editCountry>" "<editPincode>"

    Examples: 
      | addAddress     | addCity  | addState   | addCountry    | addPincode | editAddress         | editCity  | editState | editCountry | editPincode |
      | 12 Old Address | San Jose | California | United States |     111111 | 101 Updated Address | Bengaluru | Karnataka | India       |      444444 |

  @Cancel
  Scenario Outline: Cancel adding a new work location
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I fill Add Work Location form and click cancel button "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    Then New work location should not be save in the Work Locations list "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"

    Examples: 
      | Address               | Country        | State      | City      | Pincode |
      | 1259 Tech,password wd | United States  | California | San Jose  |   95112 |
      | 456 MG Road           | India          | Karnataka  | Bengaluru |  560001 |
      | Suite 78, Downing St  | United Kingdom | England    | London    |  672345 |

  @Delete
  Scenario Outline: Delete an existing work location
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I fill Add Work Location form "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    And I click the delete icon on work location list "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    And I confirm the deletion in the confirmation dialog
    Then the work location should be removed from the Work Locations list "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"

    Examples: 
      | Address                | Country       | State      | City      | Pincode |
      | 1259 Tech Street,add   | United States | California | San Jose  |   95112 |
      | 456 MG Road, add       | India         | Karnataka  | Bengaluru |  560001 |
      | Suite 78, Downing, add | India         | Karnataka  | Bengaluru |  346346 |

  @Delete
  Scenario Outline: Cancel deletion of a work location
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I fill Add Work Location form "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    And I click the delete icon on work location list "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    And I cancel the deletion in the confirmation dialog
    Then the work location should still be present in work location list "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"

    Examples: 
      | Address              | Country        | State      | City      | Pincode |
      | Tech Street,word     | United States  | California | San Jose  |    3456 |
      | 456 MG Road          | India          | Karnataka  | Bengaluru |  560001 |
      | Suite 78, Downing St | United Kingdom | England    | London    |  672345 |

  @tax_payer_type
  Scenario Outline: User selects a tax payer type from the Tax details dropdown
    When the user opens the Tax Details form in the organization settings
    And the user selects Tax Payer Type from the options "<Tax Payer Type>"
    Then Tax Payer Type should be displayed in the Tax payer type field "<Tax Payer Type>"

    Examples: 
      | Tax Payer Type  |
      | Proprietor      |
      | Partnership     |
      | LLP             |
      | Private Limited |
      | Public          |

  @valid_TAN
  Scenario Outline: Verify valid TAN format for validity
    When the user opens the Tax Details form in the organization settings
    And the user enters valid TAN number "<TAN>" in the TAN field
    And clicks the save button in tax details page
    Then Please Enter a valid TAN number error message should not displayed

    Examples: 
      | TAN        | Expected_Result |
      | ABCD12345E | Valid           |

  Scenario Outline: Verify Invalid TAN format for validity
    When the user opens the Tax Details form in the organization settings
    And the user enters Invalid TAN number "<TAN>" in the TAN field
    And clicks the save button in tax details page
    Then Please enter a valid TAN number message should be displayed

    Examples: 
      | TAN          | Expected_Result                                             |
      | ABC12345E    | Invalid (incorrect format: less than 4 alphabets in prefix) |
      | ABCD1234E    | Invalid (incorrect length: less than 10 characters)         |
      | ABCD1234567E | Invalid (incorrect length: more than 10 characters)         |
      | 1BCD12345E   | Invalid (incorrect format: non-alphabet in prefix)          |
      | ABCD12A45E   | Invalid (incorrect format: non-digit in numeric sequence)   |
      | ABCD-12345E  | Invalid (incorrect format: special character included)      |
      | ABCD 12345E  | Invalid (incorrect format: spaces included)                 |

  @valid_PAN
  Scenario Outline: Validate valid input in PAN field
    When the user opens the Tax Details form in the organization settings
    And the user enters "<input>" in the PAN field
    And clicks the save button in tax details page
    Then Please Enter a valid PAN number error message should not displayed

    Examples: 
      | input      | Expected_Result               |
      | ABCDE1234F | accept only valid PAN numbers |

  @Invalid_PAN
  Scenario Outline: Validate Invalid input in PAN field
    When the user opens the Tax Details form in the organization settings
    And the user enters "<input>" in the PAN field
    And clicks the save button in tax details page
    Then Please enter a valid PAN number message should be displayed

    Examples: 
      | input        | Expected_Result                                 |
      | ABCD@1234F   | reject input with special characters            |
      | ABCD123F     | reject input with less than 10 characters       |
      | ABCDE12345FG | reject input with more than 10 characters       |
      |   1234567890 | reject input with only numbers                  |
      | ABCDEFGHIJ   | reject input with only letters                  |
      | A1B2C3D4E5   | reject input with incorrect letter positions    |
      |              | reject empty input                              |
      | ABCD 1234F   | reject input with whitespace                    |
      | ABCDE1234F@  | reject input with special characters at the end |
      |   1234512345 | reject input with numbers in place of letters   |
      | ABCDEABCDE   | reject input with letters in place of numbers   |

  @Valid_GSTIN
  Scenario Outline: Validate valid input in GSTIN field
    When the user opens the Tax Details form in the organization settings
    And the user enters "<GSTIN_Input>" in the GSTIN field
    And clicks the save button in tax details page
    Then Please Enter a valid GSTIN number error message should not displayed

    Examples: 
      | GSTIN_Input     | Expected_Result                           |
      | 22AAAAA0000A1Z5 | Only valid GST numbers should be accepted |
      | 27AAAAA0000A1Z5 | Different state codes should be accepted  |

  @Invalid_GSTIN
  Scenario Outline: Validate invalid input in GSTIN field
    When the user opens the Tax Details form in the organization settings
    And the user enters "<GSTIN_Input>" in the GSTIN field
    And clicks the save button in tax details page
    Then Please enter a valid GSTIN number message should be displayed

    Examples: 
      | GSTIN_Input     | Expected_Result                                          |
      | 22AAAA000A1Z5   | Incorrect length GST numbers should not be accepted      |
      | 22AAAAA0000A1Z$ | Invalid characters in GST numbers should not be accepted |
      | 22AAAAA000A1Z   | Short GST numbers should not be accepted                 |
      |                 | Empty input should not be accepted                       |
      | 22AAAAA0000A1Z@ | Special characters in GST numbers should not be accepted |

  @empty_address
  Scenario: Empty Registered Business address filed should not accept
    When the user opens the Tax Details form in the organization settings
    And clicks the save button in tax details page
    Then Please select Registered Business address error message should be displayed

  @add_registered_Address
  Scenario Outline: Display of selected company address in Registered Business Address field
    Given I am on the Organization Settings page
    And I click the Add Work Location button
    When I fill Add Work Location form "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    Then the new work location should be added to the list "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    When the user clicks on the Registered Business Address dropdown field in tax details
    And selects a company address from the dropdown options "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    Then the selected company address should be displayed in the Registered Business Address field "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"

    Examples: 
      | Address                   | Country       | State      | City     | Pincode |
      | 1259 Tech Street,password | United States | California | San Jose |   95112 |

  @data_validation
  Scenario Outline: Verify whether the entered tax details are saved successfully or not.
    When the user opens the Tax Details form in the organization settings
    And the user fill the Tax Details form "<TaxTypes>" "<TAN>" "<PAN>" "<GST>" "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"
    Then Enterd Tax Details should be save "<TaxTypes>" "<TAN>" "<PAN>" "<GST>" "<Address>" "<City>" "<State>" "<Country>" "<Pincode>"

    Examples: 
      | TaxTypes        | TAN        | PAN        | GST             | Address                | City            | State       | Country | Pincode |
      | Proprietor      | MUMA12345E | ABCDE1234F | 27ABCDE1234F1Z5 | 101, Galaxy Heights    | Mumbai          | Maharashtra | India   |  123456 |
      | Partnership     | DELB67890A | PQRST6789L | 07PQRST6789L1Z2 | 22, Lotus Apartments   | New Delhi       | Delhi       | India   |  234567 |
      | LLP             | BLRA45678B | LMNOP4567K | 29LMNOP4567K1Z9 | 303, Sunrise Residency | Bangalore Rural | Karnataka   | India   |  345678 |
      | Private Limited | CHEC98765D | UVWXY9876M | 33UVWXY9876M1Z8 | 55, Palm Beach Road    | Chennai         | Tamil Nadu  | India   |  456789 |
      | Public          | HYDD54321C | ZYXWV5432N | 36ZYXWV5432N1Z4 | 88, Green Park Colony  | Hyderabad       | Telangana   | India   |  567890 |
