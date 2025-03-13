package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class OrganizationSettingPage extends BaseClass{
	
	private By EditIcon_IN_CompanyName  = By.xpath("(//flt-semantics[@role='button'])[1]");
	private By EditTextField_IN_CompanyName  = By.xpath("(//flt-semantics[@role='button'])[2]");
	private By SaveButton_IN_CompanyName  = By.xpath("(//flt-semantics[@role='button'])[3]");
	
	public void click_EditIcon_IN_CompanyName() {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(EditIcon_IN_CompanyName));
        loginBtn.click();
    }
	
	public void click_EditTextField_IN_CompanyName(String CompanyName) {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(EditTextField_IN_CompanyName));
        loginBtn.sendKeys(CompanyName);
    }
	
	public void click_SaveButton_IN_CompanyName() {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(SaveButton_IN_CompanyName));
        loginBtn.click();
    }

}
