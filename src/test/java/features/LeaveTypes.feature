Feature: Verify leave types Functionality

  Background: 
    Given the user is logged in
    When the user navigates to the Leave Types page

  Scenario: Display of Paid and Unpaid leave types on Leave Types page
    Then the Paid leave type should be displayed
    And the Unpaid leave type should be displayed

  @Valid
  Scenario Outline: Display duplicate leave type error message when adding leave type
    And I click on the Add Leave Type button
    When I enter duplicate leave type "<Types>" in the Type input field
    And I click the Save button
    Then a Duplicate leave type error message should be displayed

    Examples: 
      | Types        |
      | Paid Leave   |
      | Unpaid Leave |

  Scenario: Create a new unpaid leave type
    When I click on the Add Leave Type button
    And I enter leave type name <Leave_type_name>
    And I click the Save button
    Then the unpaid leave type should be created

  Scenario: Create a new Paid Balance tracked leave type
    When I click on the Add Leave Type button
    And I enter leave type name <Leave_type_name>
    And I select only is balance tracked check box
    And I click the Save button
    Then the new Paid Balance tracked leave type should be created

  Scenario: Create a new Paid negative Balance allowed leave type
    When I click on the Add Leave Type button
    And I enter leave type name <Leave_type_name>
    And I select balance tracked and negative balance allowed check boxs
    And I click the Save button
    Then the new Paid negative Balance allowed leave type should be created
    
 @ashygdf
  Scenario Outline: Verify that different types of inputs are accepted in the Type and Description input fields
    And I click on the Add Leave Type button
    When I enter "<Types>" in the Type input field
    And I enter "<policy>" in the policy input field
    And I click the Save button
    Then New leave type should be added successfully with type name and policy "<Types>" "<policy>"

    # validation pending
    Examples: 
      | Types                                            | policy                       |
      | Number: 1234567890                               |                   1234567890 |
      | Special characters: ~!@$%^&()_+{}:<>?`-=[]\\;,./ | ~!@$%^&()_+{}:<>?`-=[]\\;,./ |
      | Capital letter: ABCDEFGHIJKLMNOPQRSTUVWXYZ       | ABCDEFGHIJKLMNOPQRSTUVWXYZ   |
      | Small letter: abcdefghijklmnopqrstuvwxyz         | abcdefghijklmnopqrstuvwxyz   |

  Scenario: Verify validation when Type field is empty
    And I click on the Add Leave Type button
    When I click the Save button
    Then I should see an error message Type is required

  Scenario: Verify cancel button functionality
    And I click on the Add Leave Type button
    When I click on the Cancel button
    Then I should be redirected back to the Leave Types page

  Scenario Outline: Edit an existing leave type with different input values
    And I click on the Add Leave Type button
    When I enter "<Existing_Type>" in the Type input field
    And I enter "<Old_policy>" in the policy input field
    And I click the Save button
    Then New leave type should be added successfully with type name and policy "<Existing_Type>" "<Old_policy>"
    And I chnage the leave type name and policy "<New_Type>" "<New_policy>"
    And I click the Save button
    Then leave type should be edit successfully with type name and policy "<New_Type>" "<New_policy>"

    # validation pending
    Examples: 
      | Existing_Type                                    | New_Type                                         | Old_policy                   | New_policy                   |
      | Special characters: ~!@$%^&()_+{}:<>?`-=[]\\;,./ | Number: 1234567890                               | ~!@$%^&()_+{}:<>?`-=[]\\;,./ |                   1234567890 |
      | Capital letter: ABCDEFGHIJKLMNOPQRSTUVWXYZ       | Special characters: ~!@$%^&()_+{}:<>?`-=[]\\;,./ | ABCDEFGHIJKLMNOPQRSTUVWXYZ   | ~!@$%^&()_+{}:<>?`-=[]\\;,./ |
      | Small letter: abcdefghijklmnopqrstuvwxyz         | Capital letter: ABCDEFGHIJKLMNOPQRSTUVWXYZ       | abcdefghijklmnopqrstuvwxyz   | ABCDEFGHIJKLMNOPQRSTUVWXYZ   |
      | Number: 1234567890                               | Small letter: abcdefghijklmnopqrstuvwxyz         |                   1234567890 | abcdefghijklmnopqrstuvwxyz   |

  Scenario: Ensure Is Balance Tracked checkboxes are not editable in edit leave type
    When I click on the Add Leave Type button
    And I enter leave type name <Leave_type_name>
    And I select only is balance tracked check box
    And I click the Save button
    Then the new Paid Balance tracked leave type should be created
    When I select only is balance tracked check box
    Then the Balance tracked checkbox should be disabled and not editable
    
 
  Scenario: Ensure Negative Balance Allowed checkboxes are not editable in edit leave type
    When I click on the Add Leave Type button
    And I enter leave type name <Leave_type_name>
    And I select balance tracked and negative balance allowed check boxs
    And I click the Save button
    Then the new Paid negative Balance allowed leave type should be created
    When I select balance tracked and negative balance allowed check boxs
    Then the negative balance allowed checkboxs should be disabled and not editable
