package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TimelineSteps extends BaseClass{
	@When("the user navigates to the timeline page")
	public void the_user_navigates_to_the_timeline_page() throws InterruptedException {
		Dashboard.clickMyTimesheet();
		Timeline.Click_On_AddBtn();
		Timeline.Select_Project();
		Timeline.Select_Task();
	}

	@When("selects the date {string}")
	public void selects_the_date(String string) throws InterruptedException {
		Timeline.Select_Date(string);
	}
	@When("selects the time {string}")
	public void selects_the_time(String string) throws InterruptedException {
		Timeline.Select_Time(string);
	}

	@Then("the time entry should be saved successfully with the selected date and time")
	public void the_time_entry_should_be_saved_successfully_with_the_selected_date_and_time() throws InterruptedException {
		Timeline.Validate_TimeEntry();
		
	}
	
}
