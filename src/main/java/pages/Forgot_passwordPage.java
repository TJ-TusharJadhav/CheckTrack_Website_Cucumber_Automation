package pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseClass;

public class Forgot_passwordPage extends BaseClass {
	
	String newPassword;
    String resetURL;
    
	private By ForgotBtn  = By.xpath("//flt-semantics[@aria-label='Forgot Password?']");
	private By Forgot_EmailField  = By.xpath("//input[@aria-label='Email']");
	private By ContinueBtnOnforgotP  = By.xpath("//flt-semantics[@aria-label='CONTINUE']");
	private By EmptyError  = By.xpath("//flt-semantics[@aria-label='Please enter a valid email Address']");
	private By unregistered_Email_error  = By.xpath("//flt-semantics[@aria-label='Something went wrong, please try again in sometime.']");
	private By sendForgotMailMessage  = By.xpath("//flt-semantics[@aria-label='Check your mail']");
	private By sendForgotMailMessage_info  = By.xpath("//flt-semantics[@aria-label='Password reset link has been sent on your registered email.']");
	
	
		
		public void clickForgotBtn() throws InterruptedException {
			 Thread.sleep(3000);
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(ForgotBtn));
	        mainManu1.click();
	    }
		public void EnterEmailOnforgotPage(String email1) throws InterruptedException {
			 Thread.sleep(3000);
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Forgot_EmailField));
	        mainManu1.sendKeys(email1);
	    }
		public void clickContinueBtn_On_forgot_Page() throws InterruptedException {
			 Thread.sleep(3000);
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(ContinueBtnOnforgotP));
	        mainManu1.click();
	    }
		
		public void Varify_Empty_emailTextField_eror() throws InterruptedException {
			 Thread.sleep(3000);
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(EmptyError));
	        String Actual=mainManu1.getDomAttribute("aria-label");
	        String Expected= "Please enter a valid email Address";
	        Assert.assertEquals(Actual, Expected);
	    }
		
		public void Varify_unregistered_Email_error() throws InterruptedException {
			 Thread.sleep(3000);
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(unregistered_Email_error));
	        String Actual= mainManu1.getDomAttribute("aria-label");
	        String Expected= "Something went wrong, please try again in sometime.";
	        Assert.assertEquals(Actual, Expected);
	    }
		
		public void Varify_sendForgotemailMessage() throws InterruptedException {
			 Thread.sleep(3000);
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(sendForgotMailMessage));
	        String Actual= mainManu1.getDomAttribute("aria-label");
	        String Expected= "Check your mail";
	        Assert.assertEquals(Actual, Expected);
	        
	        WebElement mainManu11 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(sendForgotMailMessage_info));
	        String Actual1= mainManu11.getDomAttribute("aria-label");
	        String Expected1= "Password reset link has been sent on your registered email.";
	        Assert.assertEquals(Actual1, Expected1);
	    }
		public void openSetPasswordLinkFromEmail(String email) throws InterruptedException {
			Thread.sleep(2000);
			 driver.get("https://yopmail.com/");Thread.sleep(2000);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).sendKeys(email);Thread.sleep(2000);
		        wait.until(ExpectedConditions.elementToBeClickable(By.id("refreshbut"))).click();Thread.sleep(2000);
		        driver.navigate().refresh();
		        Thread.sleep(2000);

		        driver.switchTo().frame("ifmail");
		        WebElement resetLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'setPassword')]")));
		        resetURL = resetLink.getDomAttribute("href");
		        driver.switchTo().defaultContent();
		        driver.get(resetURL);
	    }
		 public void setNewPassword() throws InterruptedException {
		        newPassword = "TSJ" + UUID.randomUUID().toString().substring(0, 4);
		        System.out.println("New Password: " + newPassword);

		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Password']"))).sendKeys(newPassword);
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("(//flt-semantics[@role='button'])[1]")).click();Thread.sleep(2000);

		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Confirm Password']"))).sendKeys(newPassword);
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("(//flt-semantics[@role='button'])[2]")).click();
		        Thread.sleep(1000);
		        driver.findElement(By.xpath("//flt-semantics[@aria-label='SET PASSWORD']")).click();
		    }
		 public void loginWithNewPassword(String email) throws InterruptedException {
		        driver.get("https://app.checktrack.dev/");
		        Thread.sleep(2000);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Email']"))).sendKeys(email);Thread.sleep(2000);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Password']"))).sendKeys(newPassword);Thread.sleep(2000);
		        driver.findElement(By.xpath("(//flt-semantics[@role='button'])[1]")).click();
		        Thread.sleep(2000);
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//flt-semantics[@aria-label='LOGIN']"))).click();
		        String Actual =driver.findElement(By.xpath("//flt-semantics[@aria-label='Hello,Forgot password']")).getDomAttribute("aria-label");
		        String expected ="Hello,Forgot password";
		        Thread.sleep(2000);
		        Assert.assertEquals(Actual , expected);
		    }

}
