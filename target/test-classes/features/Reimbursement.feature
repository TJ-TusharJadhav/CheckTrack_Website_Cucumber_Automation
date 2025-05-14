Feature: Verify Reimbursement and Reimbursement appproval Functionality

  Background: 
    Given the user is logged in

  @empty_both
  Scenario Outline: verify the user send reimbursement request in submited status
    Given User navigates to the reimbursement request form
    When User fills the reimbursement request form "<Summary>" "<Expense_date>" "<Details>" "<Amount>" "<Supporting_file>"
    And User clicks the Submit button
    Then The reimbursement request should be saved in the submitted stage
    And A success message should be displayed Reimbursement request has been submitted
    And The past reimbursements request page should appear
    And Sumitted data should be displayed in reimbursement datils page "<Summary>" "<Expense_date>" "<Details>" "<Amount>" "<Supporting_file>"

    Examples: 
      | Summary | Expense_date     | Details | Amount | Supporting_file                                               |
      | Website | 25 November 2025 | AToZ    |    499 | \\src\\main\\java\\proof_path\\timeentryrequest to revise.jpg |

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
