package stepDefinitions;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrganizationSettingSteps extends BaseClass{
	
	@Given("I am on the Organization Settings page")
	public void i_am_on_the_organization_settings_page() throws InterruptedException {
		Dashboard.clickmainManu(); Thread.sleep(1000);
		Dashboard.clickOrganization_settings(); Thread.sleep(1000);
	    
	}
	@Given("I see the current Company Name displayed")
	public void i_see_the_current_company_name_displayed() {
		OrganizationSetting.captureOldCompanyName();
	}
	@Given("I click the edit icon next to Company Name")
	public void i_click_the_edit_icon_next_to_company_name1() throws InterruptedException {
		OrganizationSetting.click_EditIcon_IN_CompanyName();
	   
	}

	@When("I enter {string} in the input field")
	public void i_enter_in_the_input_field(String string) throws InterruptedException {
		OrganizationSetting.click_EditTextField_IN_CompanyName(string);
	    
	}

	@When("I click the Save button on company name")
	public void i_click_the_save_button() throws InterruptedException {
		OrganizationSetting.click_SaveButton_IN_CompanyName();
	    
	}
	
	@When("I click the Save button on date format")
	public void i_click_the_save_button_on_date_format() throws InterruptedException {
		OrganizationSetting.clickSaveButtonOnDateformate();
	    
	}

	@Then("the new company name should be displayed {string}")
	public void the_new_company_name_should_be_displayed(String expectedCompanyName) {
		OrganizationSetting.Verify_new_company_name(expectedCompanyName);
	    
	}

	@When("I clear the company name field")
	public void i_clear_the_company_name_field() throws InterruptedException {
		OrganizationSetting.removeCompanyName();
	    
	}

	@Then("an error message should be displayed Company Name cannot be empty")
	public void an_error_message_should_be_displayed_company_name_cannot_be_empty() {
		OrganizationSetting.VerifyErrorMessageInCompanyTestField();
	    
	}
	@When("I click the Cancel button on company name")
	public void i_click_the_cancel_button_on_company_name() throws InterruptedException {
		OrganizationSetting.Click_cancelButtonOncompanyNmae();
	}

	@When("I click the Cancel button on date format")
	public void i_click_the_cancel_button_on_date_format() throws InterruptedException {
		OrganizationSetting.Click_cancelButtonOndateFormat();
	    
	}

	@Then("the previous company name should be displayed")
	public void the_previous_company_name_should_be_displayed() throws InterruptedException {
		OrganizationSetting.verifyCompanyNameNotChanged();
	    
	}
	@When("I click the edit icon next to Date Format")
	public void i_click_the_edit_icon_next_to_date_format() throws InterruptedException {
		OrganizationSetting.Click_EditBt_On_DateFormat();
	   
	}

	@When("I select {string} from the dropdown")
	public void i_select_from_the_dropdown(String string) throws InterruptedException {
		OrganizationSetting.selectDateFormat(string);
	    
	}
	@When("I select {string} timezone from the dropdown")
	public void i_select_from_the_dropdown1(String string) throws InterruptedException {
		OrganizationSetting.selecttimezone(string);
	    
	}

	@Then("the selected {string} date format should be displayed.")
	public void the_selected_date_format_should_be_displayed(String string) {
		OrganizationSetting.getDateFormat(string);
	}
	
	@Given("I see the current Date Format displayed")
	public void i_see_the_current_date_format_displayed() {
		OrganizationSetting.getOldDateFormat();
	}

	@Then("the previous date format should be displayed")
	public void the_previous_date_format_should_be_displayed() {
		OrganizationSetting.verifyOldDateFormat();
	   }
	@When("I click the edit icon to select new Timezone")
	public void i_click_the_edit_icon_next_to_timezone() throws InterruptedException {
		OrganizationSetting.ChangeTimezoneOnorgnizationSetting();
		}

	@When("the user opens the Tax Details form in the organization settings")
	public void the_user_opens_the_tax_details_form_in_the_organization_settings() throws InterruptedException {
		Dashboard.clickmainManu(); Thread.sleep(1000);
		Dashboard.clickOrganization_settings(); Thread.sleep(1000);
		OrganizationSetting.Click_TaxDetails_on_organizationSetting();
		}

	@When("the user enters valid TAN number {string} in the TAN field")
	public void the_user_enters_valid_tan_number_in_the_tan_field(String string) throws InterruptedException {
		OrganizationSetting.Enter_TAN_NO(string);
	   }
	
	@When("the user enters Invalid TAN number {string} in the TAN field")
	public void the_user_enters_Invalid_tan_number_in_the_tan_field(String string) throws InterruptedException {
		OrganizationSetting.Enter_TAN_NO(string);
	   }

	@When("clicks the save button in tax details page")
	public void clicks_the_save_button1() throws InterruptedException {
		OrganizationSetting.SaveBT_ON_TaxDetails_on_organizationSetting();
	   }

	@Then("Please enter a valid TAN number message should be displayed")
	public void please_enter_a_valid_tan_number_message_should_be_displayed() throws InterruptedException {
		OrganizationSetting.TANErrorMessage();
	}
	@Then("Please enter a valid PAN number message should be displayed")
	public void please_enter_a_valid_pan_number_message_should_be_displayed() throws InterruptedException {
		OrganizationSetting.PANErrorMessage();
	}
	@Then("Please enter a valid GSTIN number message should be displayed")
	public void please_enter_a_valid_GSTIN_number_message_should_be_displayed() throws InterruptedException {
		OrganizationSetting.GSTINErrorMessage();
	}
	
	@Then("{string} message should be displayed")
	public void message_should_be_displayed(String string) {
		OrganizationSetting.Verify_Invalid_TAN_no(string);
		}

	@When("the user enters {string} in the PAN field")
	public void the_user_enters_in_the_pan_field(String string) throws InterruptedException {
		OrganizationSetting.Enter_PAN_NO(string);
	   }

	@When("the user enters {string} in the GSTIN field")
	public void the_user_enters_in_the_gstin_field(String string) throws InterruptedException {
		OrganizationSetting.Enter_GSTIN_NO(string);
	    }

	@Then("New GSTIN number should be saved {string}")
	public void new_gstin_number_should_be_saved(String string) {
	}
	
	@Given("registered business address is not save in Tax Details form")
	public void registered_business_address_is_not_save_in_tax_details_form() throws InterruptedException {
		OrganizationSetting.registered_business_address_filed();
	}

	@Then("Please select Registered Business address error message should be dispalyed")
	public void please_select_registered_business_address_error_message_should_be_dispalyed() throws InterruptedException {
		OrganizationSetting.registered_business_address_filed_Error_message();
	}
	
	@Given("I click the Add Work Location button")
	public void i_click_the_add_work_location_button() throws InterruptedException {
		OrganizationSetting.Click_Add_Work_Location_Btn_on_organizationSetting();
	}
	@When("I fill Add Work Location form {string} {string} {string} {string} {string}")
	public void i_fill_and_save_the_add_work_location_form_with_and(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Enter_Address(Address);
		OrganizationSetting.Select_County(Country);
		OrganizationSetting.Select_State(State);
		OrganizationSetting.Select_City(City);
		OrganizationSetting.Enter_pincode(Pincode);
		OrganizationSetting.Click_SaveBtn_on_organizationSetting();
		
	}
	
	@Then("the new work location should be added to the list {string} {string} {string} {string} {string}")
	public void the_new_work_location_should_be_added_to_the_list_with_and(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Verify_new_address(Address, City, State, Country, Pincode);
	}
	
	@When("I click the edit icon on work location list {string} {string} {string} {string} {string}")
	public void i_click_the_edit_icon_on_work_location_list(String string, String string2, String string3, String string4, String string5) throws InterruptedException {
		OrganizationSetting.ClickingEditAddressIcon(string, string2, string3, string4, string5);
	}
	@When("I edit the Work Location {string} {string} {string} {string} {string}")
	public void i_edit_the_work_location(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Enter_Address_Edit(Address);
		OrganizationSetting.update_Countyinworklocation(Country);
		OrganizationSetting.update_Stateinworklocation(State);
		OrganizationSetting.update_Cityinworklocation(City);
		OrganizationSetting.update_pincode(Pincode);
		OrganizationSetting.Click_SaveBtn_on_organizationSetting();
	    
	}
	@Then("the work location should be updated successfully {string} {string} {string} {string} {string}")
	public void the_work_location_should_be_updated_successfully(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Verify_new_address(Address, City, State, Country, Pincode);
	}
	
	@When("I fill Add Work Location form and click cancel button {string} {string} {string} {string} {string}")
	public void i_fill_and_save_the_add_work_location(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Enter_Address(Address);
		OrganizationSetting.Select_County(Country);
		OrganizationSetting.Select_State(State);
		OrganizationSetting.Select_City(City);
		OrganizationSetting.Enter_pincode(Pincode);
		OrganizationSetting.CancelBT_ON_workLocation();
		
	}
	@Then("New work location should not be save in the Work Locations list {string} {string} {string} {string} {string}")
	public void new_work_location_should_not_be_save_in_the_work_locations_list(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Verify_new_address_is_not_saved(Address, City, State, Country, Pincode);
	}
	
	@When("I click the delete icon on work location list {string} {string} {string} {string} {string}")
	public void i_click_the_delete_icon_on_work_location_list(String string, String string2, String string3, String string4, String string5) throws InterruptedException {
		OrganizationSetting.ClickingDeleteAddressIcon(string, string2, string3, string4, string5);
	}
	@When("I confirm the deletion in the confirmation dialog")
	public void i_confirm_the_deletion_in_the_confirmation_dialog() throws InterruptedException {
		OrganizationSetting.Click_yesBtn_on_deleteworklocation();
	    
	}
	@Then("the work location should be removed from the Work Locations list {string} {string} {string} {string} {string}")
	public void the_work_location_should_be_removed_from_the_work_locations_list(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Verify_Selected_address_is_delete(Address, City, State, Country, Pincode);
	    
	}
	@When("I cancel the deletion in the confirmation dialog")
	public void i_cancel_the_deletion_in_the_confirmation_dialog() throws InterruptedException {
		OrganizationSetting.Click_NOBtn_on_deleteworklocation();
	   
	}
	@Then("the work location should still be present in work location list {string} {string} {string} {string} {string}")
	public void the_work_location_should_still_be_present_in_work_location_list(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.Verify_new_address(Address, City, State, Country, Pincode);
	    
	}
	
	@Then("Please Enter a valid TAN number error message should not displayed")
	public void please_enter_a_valid_tan_number_error_message_should_not_displayed() throws InterruptedException {
		OrganizationSetting.dONOT_DISPLAYED_ERROR_INVALID_MESSAGE_IN_TAN_FIELD();
	}
	
	@Then("Please Enter a valid PAN number error message should not displayed")
	public void please_enter_a_valid_pan_number_error_message_should_not_displayed() throws InterruptedException {
		OrganizationSetting.dONOT_DISPLAYED_ERROR_INVALID_MESSAGE_IN_PAN_FIELD();
	}
	@Then("Please Enter a valid GSTIN number error message should not displayed")
	public void please_enter_a_valid_gstin_number_error_message_should_not_displayed() throws InterruptedException {
		OrganizationSetting.dONOT_DISPLAYED_ERROR_INVALID_MESSAGE_IN_GSTIN_FIELD();
	}
	
	@When("the user selects Tax Payer Type from the options {string}")
	public void the_user_selects_tax_payer_type_from_the_options(String string) throws InterruptedException {
		OrganizationSetting.Select_TaxType(string);
	}
	@Then("Tax Payer Type should be displayed in the Tax payer type field {string}")
	public void tax_payer_type_should_be_displayed_in_the_tax_payer_type_field(String string) throws InterruptedException {
		OrganizationSetting.varity_selected_taxType(string);
	}
	
	@Then("Please select Registered Business address error message should be displayed")
	public void please_select_registered_business_address_error_message_should_be_displayed() throws InterruptedException {
		OrganizationSetting.verify_Error_message_For_Registered_Business_address();
	    
	}
	@When("the user clicks on the Registered Business Address dropdown field in tax details")
	public void the_user_clicks_on_the_registered_business_address_dropdown_field_in_tax_details() throws InterruptedException {
		OrganizationSetting.click_Tax_Details_inOrganization_details();
	}
	@When("selects a company address from the dropdown options {string} {string} {string} {string} {string}")
	public void selects_a_company_address_from_the_dropdown_options(String string, String string2, String string3, String string4, String string5) throws InterruptedException {
		OrganizationSetting.SelectRegisteredAddress(string, string2, string3, string4, string5);
	}
	@Then("the selected company address should be displayed in the Registered Business Address field {string} {string} {string} {string} {string}")
	public void the_selected_company_address_should_be_displayed_in_the_registered_business_address_field(String string, String string2, String string3, String string4, String string5) throws InterruptedException {
		OrganizationSetting.VerifySelectRegisteredAddress(string, string2, string3, string4, string5);
	}
	
	@When("the user fill the Tax Details form {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void the_user_fill_the_tax_details_form(String TaxTypes, String TAN, String PAN, String GST, String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.selectTaxTypeData(TaxTypes);
		OrganizationSetting.entertannumberdata(TAN);
		OrganizationSetting.enterpannumberdata(PAN);
		OrganizationSetting.enterGSTnumberdata(GST);
		OrganizationSetting.selectaddressData(Address, City, State, Country, Pincode);
		OrganizationSetting.Click_SaveBtn_on_organizationSetting();
	    
	}
	@Then("Enterd Tax Details should be save {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enterd_tax_details_should_be_save(String TaxTypes, String TAN, String PAN, String GST, String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
		OrganizationSetting.enterd_tax_details_should_be_save(TaxTypes,TAN, PAN,GST, Address, City, State, Country, Pincode);
	}
	
	
	

}
