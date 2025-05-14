package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	private By usernameField  = By.xpath("//input[@aria-label='Email']");
    private By passwordField  = By.xpath("//input[@aria-label='Password']");
    private By loginButton  = By.xpath("//flt-semantics[@aria-label='LOGIN']");
    private By Dashboard  = By.xpath("//flt-semantics[@aria-label='Projects']");
    private By Bad_credentials = By.xpath("//flt-semantics[@aria-label='Bad credentials!']");
    private By Empty_UsernameFiled_error = By.xpath("//flt-semantics[@aria-label='Please enter a valid email ID']");
    private By Empty_passwordFiled_error = By.xpath("//flt-semantics[@aria-label=\"Password can't be blank\"]");
    private By Access_denied_error = By.xpath("//flt-semantics[@aria-label='Access denied!']");
    
    private By both_Empty_UsernameFiled_error = By.xpath("//flt-semantics[@aria-label='Please enter a valid email ID']");
    private By both_Empty_passwordFiled_error = By.xpath("//flt-semantics[@aria-label=\"Password can't be blank\"]");
    
    private By ManageCheckTrackOrganisation  = By.xpath("//flt-semantics[@aria-label='Manage CheckTrack Organisation']");
    private By ReegisterYourOrganisation  = By.xpath("//flt-semantics[@aria-label='Register your Organisation']");
    public String admin_Login = "asfdgzq345df@yopmail.com";
    
    public void Valid_login() throws InterruptedException {
    	
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        userField.sendKeys(admin_Login);
        Thread.sleep(3000);

        
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passField.sendKeys(admin_Login);
        Thread.sleep(2000);
        
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
        Thread.sleep(3000);
    }

    public void enterUsername(String username) throws InterruptedException {
        WebElement userField = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        Thread.sleep(1000);
        userField.sendKeys(username);
        Thread.sleep(2000);
    }

    public void enterPassword(String password) throws InterruptedException {
        WebElement passField = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passField.sendKeys(password);
        Thread.sleep(1000);
    }

    public void clickLogin() {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
    
    public void Bad_credentials_Error() {
        
    	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Bad_credentials));
        errorMessageElement.isDisplayed();
        
    
    }
public void Empty_Email_field_Error() {
        
    	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Empty_UsernameFiled_error));
        errorMessageElement.isDisplayed();
        
        
    
    }

public void Empty_Password_field_Error() {
    
	WebElement errorPass = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Empty_passwordFiled_error));
	errorPass.isDisplayed();

}

public void Empty_Email_password_field_Error() {
    
	WebElement errorEmail = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(both_Empty_UsernameFiled_error));
	WebElement errorPass = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(both_Empty_passwordFiled_error));
	errorEmail.isDisplayed();
	errorPass.isDisplayed();

}
public void Access_denied_Error_message() {
    
	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Access_denied_error));
	errorMessageElement.isDisplayed();

}
public void Dashboard_displayed() {
	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard));
    errorMessageElement.isDisplayed();
  }

public void Manage_CheckTrack_Organization() {
//	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(ManageCheckTrackOrganisation));
//    errorMessageElement.click();
  }

public void Reegister_Your_Organisation() {
//	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(ReegisterYourOrganisation));
//    errorMessageElement.click();
  }

public void validatemanage() throws InterruptedException {
	String parentWindow = driver.getWindowHandle();
	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(ManageCheckTrackOrganisation));
    errorMessageElement.click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	// Switch to the new tab
	Set<String> windowHandles = driver.getWindowHandles();
	for (String window : windowHandles) {
	    if (!window.equals(parentWindow)) {
	        driver.switchTo().window(window);
	        break;
	    }
	}
	
	Thread.sleep(2000);
	
	String expectedUrl = "https://company-admin.checktrack.dev/#/manageOrganisation";
	String actualUrl = driver.getCurrentUrl();
	System.out.println(actualUrl);
	Assert.assertEquals(actualUrl, expectedUrl, "New tab URL validation failed");

	// Validate page title
	String expectedTitle = "CheckTrack";
	String actualTitle = driver.getTitle();
	System.out.println(actualTitle);
	Assert.assertEquals(actualTitle, expectedTitle, "New tab title validation failed");
  }

public void validateRegister() throws InterruptedException {
	String parentWindow = driver.getWindowHandle();
	WebElement errorMessageElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(ReegisterYourOrganisation));
    errorMessageElement.click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	// Switch to the new tab
	Set<String> windowHandles = driver.getWindowHandles();
	for (String window : windowHandles) {
	    if (!window.equals(parentWindow)) {
	        driver.switchTo().window(window);
	        break;
	    }
	}
	
	Thread.sleep(2000);
	
	String expectedUrl = "https://company-admin.checktrack.dev/#/adminBasicDetailsForm";
	String actualUrl = driver.getCurrentUrl();
	System.out.println(actualUrl);
	Assert.assertEquals(actualUrl, expectedUrl, "New tab URL validation failed");

	// Validate page title
	String expectedTitle = "CheckTrack";
	String actualTitle = driver.getTitle();
	System.out.println(actualTitle);
//	Assert.assertEquals(actualTitle, expectedTitle, "New tab title validation failed");
	
  }

	

}
