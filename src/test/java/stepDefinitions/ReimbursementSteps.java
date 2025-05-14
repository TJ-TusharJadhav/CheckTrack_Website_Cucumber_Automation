package stepDefinitions;

import java.awt.AWTException;
import java.text.ParseException;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReimbursementSteps extends BaseClass{
	
	@Given("User navigates to the reimbursement request form")
	public void user_navigates_to_the_reimbursement_request_form() throws InterruptedException {
		Dashboard.clickreimbursement();
		Reimbursement.Click_AddReimbursementsBtn();
		}
	
	@When("User fills the reimbursement request form {string} {string} {string} {string} {string}")
	public void user_fills_the_reimbursement_request_form(String Summary, String Expense_date, String Details, String Amount, String Supporting_file) throws InterruptedException, AWTException {
		Reimbursement.EnterSummaryName(Summary);
		Reimbursement.Select_ExpenceDate(Expense_date);
		Reimbursement.EnterDetails(Details);
		Reimbursement.EnterAmount(Amount);
		Reimbursement.Upload_Reimbursement_Attachment(Supporting_file);
		}
	
	@When("User clicks the Submit button")
	public void user_clicks_the_submit_button() throws InterruptedException {
		Reimbursement.Click_submit_button();
		}
	
	@Then("The reimbursement request should be saved in the submitted stage")
	public void the_reimbursement_request_should_be_saved_in_the_submitted_stage() throws InterruptedException {
		Reimbursement.verify_request_status();
		}
	
	@Then("A success message should be displayed Reimbursement request has been submitted")
	public void a_success_message_should_be_displayed_reimbursement_request_has_been_submitted() {
		
	}
	
	@Then("The past reimbursements request page should appear")
	public void the_past_reimbursements_request_page_should_appear() throws InterruptedException {
		Reimbursement.verify_Past_request();
		}
	
	@Then("Sumitted data should be displayed in reimbursement datils page {string} {string} {string} {string} {string}")
	public void sumitted_data_should_be_displayed_in_reimbursement_datils_page(String Summary, String Expense_date, String Details, String Amount, String Supporting_file) throws InterruptedException, ParseException {
		Reimbursement.validate_request_data(Summary, Expense_date, Details, Amount, Supporting_file);
		}
}
