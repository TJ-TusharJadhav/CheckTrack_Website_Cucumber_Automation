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

  

  Scenario Outline: Verify that different types of inputs are accepted in the Type and Description input fields
    And I click on the Add Leave Type button
    When I enter "<Types>" in the Type input field
    And I enter "<policy>" in the policy input field
    And I click the Save button
    Then New leave type should be added successfully with type name and policy "<Types>" "<policy>"

    Examples: 
      | Types                                            | policy                       |
      | Number: 1234567890                               |                   1234567890 |
      | Special characters: ~!@$%^&()_+{}:<>?`-=[]\\;,./ | ~!@$%^&()_+{}:<>?`-=[]\\;,./ |
      | Capital letter: ABCDEFGHIJKLMNOPQRSTUVWXYZ       | ABCDEFGHIJKLMNOPQRSTUVWXYZ   |
      | Small letter: abcdefghijklmnopqrstuvwxyz         | abcdefghijklmnopqrstuvwxyz   |
