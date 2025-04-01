package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseClass;

public class OrganizationSettingPage extends BaseClass{
	
	private By EditIcon_IN_CompanyName  = By.xpath("(//flt-semantics[@role='button'])[2]");
	private By EditTextField_IN_CompanyName  = By.xpath("//input[@data-semantics-role='text-field']");
	private By SaveButton_IN_CompanyName  = By.xpath("(//flt-semantics[@role='button'])[3]");
	private By Verify_new_company_name_IN_CompanyName  = By.xpath("(//flt-semantics[@role='text'])[3]");
	private By emptyCompanyFiledError = By.xpath("(//flt-semantics[@role='text'])[3]");
	private By CancelBtCompanyNmae = By.xpath("(//flt-semantics[@role='button'])[2]");
	
	private By EditIcon_IN_DateFormat  = By.xpath("(//flt-semantics[@role='button'])[3]");
	private By Click_Date_format  = By.xpath("(//flt-semantics[@role='button'])[5]");
	
	private By Click_TaxDetails  = By.xpath("//flt-semantics[@aria-label='Tax details']");
	private By Enter_TAN_No  = By.xpath("//input[@aria-label='Tax Deduction & Collection Account Number (TAN)']");
	private By SaveBT_ON_TaxDetails = By.xpath("(//flt-semantics[@role='button'])[5]");
	private By Invalid_TAN_NO_Error_ON_TaxDetails = By.xpath("//flt-semantics[@aria-label='Please enter a valid TAN number']");
	
	public void Verify_Invalid_TAN_no(String expectedCompanyName) {

		WebElement searchTextBox = driver.findElement(Invalid_TAN_NO_Error_ON_TaxDetails);
		String actualCompanyName = searchTextBox.getAttribute("aria-label");
	    System.out.println("Actual Company Name: " + actualCompanyName);
	    Assert.assertEquals(actualCompanyName, expectedCompanyName, "Company name did not match!");
		}
	
	public void Click_TaxDetails_on_organizationSetting() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Click_TaxDetails));
        loginBtn.click();
        Thread.sleep(1000);
    }
	
	public void Enter_TAN_NO(String TAN) throws InterruptedException {
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Enter_TAN_No));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.clear();
        loginBtn.sendKeys(TAN);
    }
	public void click_EditIcon_IN_CompanyName() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(EditIcon_IN_CompanyName));
        loginBtn.click();
        Thread.sleep(1000);
    }
	
	public void SaveBT_ON_TaxDetails_on_organizationSetting() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(SaveBT_ON_TaxDetails));
        loginBtn.click();
        Thread.sleep(1000);
    }
	
	public void click_EditTextField_IN_CompanyName(String CompanyName) throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(EditTextField_IN_CompanyName));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.clear();
        loginBtn.sendKeys(CompanyName);
    }
	
	public void click_SaveButton_IN_CompanyName() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(SaveButton_IN_CompanyName));
        loginBtn.click();
        Thread.sleep(1000);
    }
	
	public void Verify_new_company_name(String expectedCompanyName) {

		WebElement searchTextBox = driver.findElement(Verify_new_company_name_IN_CompanyName);
		String actualCompanyName = searchTextBox.getAttribute("aria-label");
	    System.out.println("Actual Company Name: " + actualCompanyName);
	    Assert.assertEquals(actualCompanyName, expectedCompanyName, "Company name did not match!");
		}
	
	public void remove_companyNmae_IN_CompanyName() throws InterruptedException {
		WebElement inputField = driver.findElement(EditTextField_IN_CompanyName); Thread.sleep(1000);
		inputField.sendKeys(Keys.CONTROL + "a");  
		inputField.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000);
		driver.findElement(By.xpath("(//flt-semantics[@role='button'])[3]")).click();Thread.sleep(1000);
    }
	
	public void VerifyErrorMessageInCompanyTestField() {
		WebElement searchTextBox = driver.findElement(emptyCompanyFiledError);
		String actualCompanyName = searchTextBox.getAttribute("aria-label");
	    System.out.println("Actual Company Name: " + actualCompanyName);
	    String expectedCompanyName = "Company name can't be empty";
	    Assert.assertEquals(actualCompanyName, expectedCompanyName, "Company name did not match!");
    }
	
	public void Click_cancelButtonOncompanyNmae() throws InterruptedException {
		remove_companyNmae_IN_CompanyName();
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(CancelBtCompanyNmae));
        loginBtn.click();
        Thread.sleep(1000);
		
    }
	
	public void VerifyPreviousCompanyName() {
		WebElement searchTextBox = driver.findElement(Verify_new_company_name_IN_CompanyName);
		String actualCompanyName = searchTextBox.getAttribute("aria-label");
		String expectedCompanyName = "TechNova Global Pvt. Ltd.";
	    System.out.println("Actual Company Name: " + actualCompanyName);
	    Assert.assertEquals(actualCompanyName, expectedCompanyName, "Company name did not match!");
    }
	
	public void Click_EditBt_On_DateFormat() throws InterruptedException {
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon_IN_DateFormat));
		Thread.sleep(1000);
        loginBtn.click();Thread.sleep(1000);
        loginBtn.click();Thread.sleep(1000);
    }
	public void selectDateFormat(String newFormat) throws InterruptedException {

        WebElement formatOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//flt-semantics[@aria-label='"+ newFormat +"']")));
        System.out.println("DateFormat: " + formatOption);
        formatOption.click();Thread.sleep(1000);
    }

    public void clickSaveButton() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(Click_Date_format));
        saveButton.click();Thread.sleep(1000);
    }

    public void verifyDateFormat(String expectedFormat) {
    	 WebElement formatOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//flt-semantics[@aria-label='"+ expectedFormat +"']")));
        String actualFormat = formatOption.getText();
        
        System.out.println("Displayed Date Format: " + actualFormat);
        Assert.assertEquals(actualFormat, expectedFormat, "Date format update failed!");
    }
	
	
	}
