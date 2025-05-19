package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseClass;

public class Team_membersPage extends BaseClass{
	private By add_team_member_btn  = By.xpath("//flt-semantics[@aria-label='ADD TEAM MEMBER']");
	private By get_timezone  = By.xpath("//flt-semantics[@role='group']");
	
	public void Click_add_team_member_btn() throws InterruptedException {
        WebElement addMemberbtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(add_team_member_btn));
        addMemberbtn.click();
        Thread.sleep(1000);
    }
	public void get_default_timezone(String Expected_Timezone) throws InterruptedException {
		Thread.sleep(5000);
		WebElement timezoneElement = BaseClass.wait.until(ExpectedConditions.presenceOfElementLocated(get_timezone));
		String actualTimezone = timezoneElement.getDomAttribute("aria-label"); 
        Assert.assertEquals(actualTimezone, Expected_Timezone);
    }
	
	

}
