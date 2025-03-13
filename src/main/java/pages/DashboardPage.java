package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class DashboardPage extends BaseClass {
	
private By mainManu  = By.xpath("//flt-semantics[@aria-label='Open navigation menu']");
private By Organization_settings  = By.xpath("//flt-semantics[@aria-label='Organization settings']");
	
	public void clickmainManu() {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(mainManu));
        loginBtn.click();
    }
	
	public void clickOrganization_settings() {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Organization_settings));
        loginBtn.click();
    }

}
