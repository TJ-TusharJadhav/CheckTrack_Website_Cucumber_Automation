package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaveTypesSteps extends BaseClass{
	@When("the user navigates to the Leave Types page")
	public void the_user_navigates_to_the_leave_types_page() throws InterruptedException {
		Dashboard.clickmainManu();
		Dashboard.clickLeave_management();
		LeaveTypes.clickleaveTypeBtn();
	}

	@Then("the Paid leave type should be displayed")
	public void the_paid_leave_type_should_be_displayed() throws InterruptedException {
		LeaveTypes.verfiy_paid_leave_type();
	}

	@Then("the Unpaid leave type should be displayed")
	public void the_unpaid_leave_type_should_be_displayed() throws InterruptedException {
		LeaveTypes.verfiy_Unpaid_leave_type();
	}
	
	@When("I click on the Add Leave Type button")
	public void i_click_on_the_add_leave_type_button() throws InterruptedException {
		LeaveTypes.clickAddLeavetypeBtn();
	}
	@When("I enter {string} in the Type input field")
	public void i_enter_in_the_type_input_field(String string) throws InterruptedException {
		LeaveTypes.Enter_LeaveTypeName(string);
	}

	@When("I enter {string} in the policy input field")
	public void i_enter_in_the_description_input_field(String string) throws InterruptedException {
		LeaveTypes.Enter_LeavePolicy(string);
	}

	@When("I click the Save button")
	public void i_click_the_save_button() throws InterruptedException {
		LeaveTypes.clickSaveBtn();
	}

	@Then("New leave type should be added successfully with type name and policy {string} {string}")
	public void new_leave_type_should_be_added_successfully_with_type_name_and_policy(String leaveTypeName, String policy) throws InterruptedException {
		LeaveTypes.verfiy_new_leave_type(leaveTypeName, policy);
		
	} 
	@Then("a Duplicate leave type error message should be displayed")
	public void a_duplicate_leave_type_error_message_should_be_displayed() throws InterruptedException {
		LeaveTypes.verfiy_duplicate_leave_type_error_message();
	}
	@When("I enter duplicate leave type {string} in the Type input field")
	public void i_enter_duplicate_leave_type_in_the_type_input_field(String string) throws InterruptedException {
		LeaveTypes.Enter_duplicateLeaveTypeName(string);
	}
	
	@When("I enter leave type name <Leave_type_name>")
	public void i_enter_unpaid_leave_type_name_leave_type_name() throws InterruptedException {
		LeaveTypes.Enter_Leave_TypeName_For_Validation_This_type_is_trackORnottrack();
	}

	@Then("the unpaid leave type should be created")
	public void the_unpaid_leave_type_should_be_created() throws InterruptedException {
		LeaveTypes.validation_unpaid_leave();
	   
	}
	@When("I select only is balance tracked check box")
	public void i_select_only_is_balance_tracked_check_box() throws InterruptedException {
		LeaveTypes.clickbalanceTrackedCheckBox();
		LeaveTypes.clickNegativeleaveCheckBox();
		
	 }
	
	@When("I select balance tracked and negative balance allowed check boxs")
	public void i_select_balance_tracked_and_negative_balance_allowed_check_boxs() throws InterruptedException {
		LeaveTypes.clickbalanceTrackedCheckBox();
	 }

	@Then("the new Paid Balance tracked leave type should be created")
	public void the_new_paid_balance_tracked_leave_type_should_be_created() throws InterruptedException {
		LeaveTypes.validation_paid_BalanceTracked_leave();
	   
	}

	
	@Then("the new Paid negative Balance allowed leave type should be created")
	public void the_new_paid_negative_leave_type_should_be_created() throws InterruptedException {
		LeaveTypes.validation_paid_negative_balance_leave();
	}
	@When("I enter {string} {int} in the policy input field")
	public void i_enter_in_the_policy_input_field(String string, Integer int1) {
	}
	@Then("New leave type should be added successfully with type name and policy {string} Number: {int} {string} {int}")
	public void new_leave_type_should_be_added_successfully_with_type_name_and_policy_number(String string, Integer int1, String string2, Integer int2) {
	}

}
