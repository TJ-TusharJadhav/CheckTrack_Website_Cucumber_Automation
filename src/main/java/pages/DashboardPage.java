package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class DashboardPage extends BaseClass {
	
private By mainManu  = By.xpath("//flt-semantics[@aria-label='Open navigation menu']");
private By Organization_settings  = By.xpath("//flt-semantics[@aria-label='Organization settings']");
private By reimbursement  = By.xpath("//flt-semantics[@aria-label='Reimbursement']");
private By projects  = By.xpath("//flt-semantics[@aria-label='Projects']");
private By timesheet  = By.xpath("//flt-semantics[@aria-label='My timesheet']");

private By leave_management  = By.xpath("//flt-semantics[@aria-label='Leave management']");
	
	public void clickmainManu() {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(mainManu));
        mainManu1.click();
    }
	
	public void clickOrganization_settings() {
        WebElement Organization_settings1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Organization_settings));
        Organization_settings1.click();
    }
	
	public void clickreimbursement() {
        WebElement reimbursement1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(reimbursement));
        reimbursement1.click();
    }
	public void clickprojects() {
        WebElement reimbursement1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(projects));
        reimbursement1.click();
    }
	public void clickMyTimesheet() {
        WebElement reimbursement1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(timesheet));
        reimbursement1.click();
    }
	public void clickLeave_management() throws InterruptedException {
		 Thread.sleep(1000); 
        WebElement reimbursement1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(leave_management));
        js.executeScript("arguments[0].value = '';", reimbursement1);
        reimbursement1.click();
    }

}
