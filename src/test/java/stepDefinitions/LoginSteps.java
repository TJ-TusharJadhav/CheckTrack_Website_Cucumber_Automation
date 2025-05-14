package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends BaseClass{
	@Given("the user is logged in")
	public void the_user_is_logged_in() throws InterruptedException {
		loginPage.Valid_login();
	}

    @Given("User is on the CheckTrack login page")
    public void user_is_on_login_page() {
    }

    @When("User enters {string} and {string}")
    public void user_enters_credentials(String username, String password) throws InterruptedException {
    	loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_navigated_to_home() {
    	loginPage.Dashboard_displayed();
    	
    }
    
    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_and(String username, String password) throws InterruptedException {
    	loginPage.enterUsername(username);
        loginPage.enterPassword(password);
       
    }

    @Then("User should see a Bad credentials error message")
    public void user_should_see_a_Bad_credentials_error_message() {
    	loginPage.Bad_credentials_Error();
        
    }

    @When("User leaves the username field empty")
    public void user_leaves_the_username_field_empty() {
        
    }

    @When("User enters a valid password {string}")
    public void user_enters_a_valid_password(String password) throws InterruptedException {
    	loginPage.enterPassword(password);
        
    }

    @Then("User should see a Please enter a valid email ID error message")
    public void user_should_see_a_Please_enter_a_valid_email_ID_error_message() {
    	loginPage.Empty_Email_field_Error();
    	
        
    }

    @When("User enters a valid username {string}")
    public void user_enters_a_valid_username(String username) throws InterruptedException {
    	loginPage.enterUsername(username);
        
    }

    @When("User leaves the password field empty")
    public void user_leaves_the_password_field_empty() {
        
    }
    
    @Then("User should see a Password is required error message")
    public void User_should_see_a_Password_is_required_error_message(){
    	loginPage.Empty_Password_field_Error();
        
    }

    @When("User leaves the username and password fields empty")
    public void user_leaves_the_username_and_password_fields_empty() {
        
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
    	loginPage.Empty_Email_password_field_Error();
        
    }

    @When("User enters credentials for a terminated account {string} and {string}")
    public void user_enters_credentials_for_a_terminated_account_and(String username, String password) throws InterruptedException {
    	loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        
    }
    
    @Then("User should see a Your account has been terminated error message")
    public void User_should_see_a_Your_account_has_been_terminated_error_message() {
    	loginPage.Access_denied_Error_message();
       
    }
    
    @When("User clicks on the Manage CheckTrack Organization link")
    public void user_clicks_on_the_manage_check_track_organization_link() {
    	loginPage.Manage_CheckTrack_Organization();
    }
    
    @Then("Manage CheckTrack Organization tab should open")
    public void manage_check_track_organization_tab_should_open() throws InterruptedException {
    	loginPage.validatemanage();
    }
    
    @When("User clicks on the Onboard Your Organization link")
    public void user_clicks_on_the_manage_check_track_organization_link1() {
    	loginPage.Reegister_Your_Organisation();
    }
    
    @Then("Onboard Your Organization tab should open")
    public void manage_check_track_organization_tab_should_open1() throws InterruptedException {
    	loginPage.validateRegister();
    }
    
    
    
   
}
