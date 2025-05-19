package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Forgot_passwordSteps extends BaseClass{
	
	
	@Given("the user is neviget Forgot Password page")
	public void the_user_is_neviget_forgot_password_page() throws InterruptedException {
		forgot.clickForgotBtn();
	}

	@When("the user enters an unregistered Email and click continue button {string}")
	public void the_user_enters_an_unregistered_email_and_click_continue_button(String Email) throws InterruptedException {
		forgot.EnterEmailOnforgotPage(Email);
		forgot.clickContinueBtn_On_forgot_Page();
	}

	@Then("This Email is not registered message should be displayed")
	public void this_email_is_not_registered_message_should_be_displayed() throws InterruptedException {
		forgot.Varify_unregistered_Email_error();
	}

	@When("the user clicks on the Continue button leaves the Email field empty")
	public void the_user_clicks_on_the_continue_button_leaves_the_email_field_empty() throws InterruptedException {
		forgot.clickContinueBtn_On_forgot_Page();
	}

	@Then("Please enter a valid email address message should be displayed")
	public void please_enter_a_valid_email_address_message_should_be_displayed() throws InterruptedException {
		forgot.Varify_Empty_emailTextField_eror();
	}
	
	@When("the user enters an registered Email and click continue button {string}")
	public void the_user_enters_an_registered_email_and_click_continue_button(String Email) throws InterruptedException {
		forgot.EnterEmailOnforgotPage(Email);
		forgot.clickContinueBtn_On_forgot_Page();
	}

	@Then("a confirmation message Password reset link has been sent to your registered email should be displayed")
	public void a_confirmation_message_password_reset_link_has_been_sent_to_your_registered_email_should_be_displayed() throws InterruptedException {
		forgot.Varify_sendForgotemailMessage();
	}

	@When("the user opens the Set Password link sent via email {string}")
	public void the_user_opens_the_set_password_link_sent_via_email(String email123) throws InterruptedException {
		forgot.openSetPasswordLinkFromEmail(email123);
	}



	@When("the user sets a new password <Password>")
	public void the_user_sets_a_new_password_password() throws InterruptedException {
		forgot.setNewPassword();
	}

	@Then("the user should be able to log in successfully with the newly set password {string} <Password>")
	public void the_user_should_be_able_to_log_in_successfully_with_the_newly_set_password_password(String string) throws InterruptedException {
		forgot.loginWithNewPassword(string);
	}
	@When("the user leaves the Password field empty")
	public void the_user_leaves_the_password_field_empty() {
	}
	@When("enters {string} in the Confirm Password field")
	public void enters_in_the_confirm_password_field(String string) {
		forgot.enter_Conform_password(string);
	}
	@When("clicks the Set Password button")
	public void clicks_the_set_password_button() throws InterruptedException {
		forgot.click_set_password();
		
	}
	@Then("the system should display a message Password must be entered")
	public void the_system_should_display_a_message_password_must_be_entered() {
		forgot.verifyEmptyPasswordfield();
	}
	@When("the user enters {string} in the Password field")
	public void the_user_enters_in_the_password_field(String string) {
		forgot.enter_password(string);
	}
	@When("leaves the Confirm Password field empty")
	public void leaves_the_confirm_password_field_empty() {
	}
	@Then("the system should display a message Confirm Password must be entered")
	public void the_system_should_display_a_message_confirm_password_must_be_entered() {
		forgot.verifyEmptyConfirmPasswordfield();
	}

}
