package pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseClass;

public class OrganizationSettingPage extends BaseClass{
//	Company name
	private By EditIcon_IN_CompanyName  = By.xpath("(//flt-semantics[@role='button'])[2]");
	private By EditTextField_IN_CompanyName  = By.xpath("//input[@data-semantics-role='text-field']");
	private By SaveButton_IN_CompanyName  = By.xpath("(//flt-semantics[@role='button'])[3]");
	private By CancelBtCompanyNmae = By.xpath("(//flt-semantics[@role='button'])[2]");
	private By Verify_new_company_name_IN_CompanyName  = By.xpath("(//flt-semantics[@role='text'])[3]");
	private By emptyCompanyFiledError = By.xpath("(//flt-semantics[@role='text'])[3]");
	private By companyNameDisplay = By.xpath("(//flt-semantics[@role='text'])[3]");
	
//	Date format
	private By EditIcon_IN_DateFormat  = By.xpath("(//flt-semantics[@role='button'])[3]");
	private By SaveButton_IN_Date_format  = By.xpath("(//flt-semantics[@role='button'])[5]");
	private By Cancel_Date_format  = By.xpath("(//flt-semantics[@role='button'])[4]");
	private By getCurrentDateFormate  = By.xpath("(//flt-semantics[@role='text'])[5]");
	
//	Tax details
	private By Click_TaxDetails  = By.xpath("//flt-semantics[@aria-label='Tax details']");
	private By Enter_TAN_No  = By.xpath("//input[@aria-label='Tax Deduction & Collection Account Number (TAN)']");
	private By Enter_PAN_No  = By.xpath("//input[@aria-label='Permanent Account Number (PAN)']");
	private By Enter_GSTIN_No  = By.xpath("//input[@aria-label='GSTIN']");
	private By SaveBT_ON_TaxDetails = By.xpath("(//flt-semantics[@role='button'])[5]");
	private By Invalid_TAN_NO_Error_ON_TaxDetails = By.xpath("//flt-semantics[@aria-label='Please enter a valid TAN number']");
	private By TANError  = By.xpath("//flt-semantics[@aria-label='Please enter a valid TAN number']");
	private By PANError  = By.xpath("//flt-semantics[@aria-label='Please enter a valid PAN number']");
	private By GSTINError  = By.xpath("//flt-semantics[@aria-label='Please enter a valid GSTIN number']");
	
	//	Timezone
	private By editiconOntimezone=By.xpath("(//flt-semantics[@role='button'])[4]");
	private By clicktimezonedropdown= By.xpath("(//flt-semantics[@role='button'])[4]");
	private By SaveButton_IN_Timezone  = By.xpath("(//flt-semantics[@role='button'])[6]");
	private By CancelBtTimezone = By.xpath("(//flt-semantics[@role='button'])[5]");
	
//	registered business address
	private By registered_business_address=By.xpath("//flt-semantics[@aria-label='Registered Business address']");
	private By registered_business_address_error=By.xpath("//flt-semantics[@aria-label='Please select Registered Business address']");
	
//	Work location
	private By Add_Work_Location_Btn=By.xpath("//flt-semantics[@aria-label='Add work location']");
	private By AddressTextFiled=By.xpath("//textarea[@aria-label='Address']");
	private By ClickCountryfiled=By.xpath("//flt-semantics[@aria-label='Country']");
	private By SearchCountryBar=By.xpath("//input[@aria-label='Country']");
	private By ClickStatefiled=By.xpath("//flt-semantics[@aria-label='State']");
	private By SearchStateBar=By.xpath("//input[@aria-label='State']");
	private By ClickCityfiled=By.xpath("//flt-semantics[@aria-label='City']");
	private By SearchCityBar=By.xpath("//input[@aria-label='City']");
	private By PincodeTextFiled=By.xpath("//input[@aria-label='Pincode']");
	private By saveBtn =By.xpath("//flt-semantics[@aria-label='SAVE']");
	private By CancelBtWorklocation = By.xpath("(//flt-semantics[@role='button'])[2]");
	private By EditAddressTextFiled=By.xpath("(//textarea[@data-semantics-role='text-field'])[1]");
	private By YesBtn =By.xpath("//flt-semantics[@aria-label='YES']");
	private By noBtn =By.xpath("//flt-semantics[@aria-label='NO']");
	
	
	
	String oldDateFormat;
	 String oldCompanyName;
	 String oldtimezone;
	
	
	public void Verify_Invalid_TAN_no(String expectedCompanyName) {
		WebElement searchTextBox = driver.findElement(Invalid_TAN_NO_Error_ON_TaxDetails);
		String actualCompanyName = searchTextBox.getDomAttribute("aria-label");
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
	public void Enter_PAN_NO(String PAN) throws InterruptedException {
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Enter_PAN_No));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.clear();
        loginBtn.sendKeys(PAN);
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
	public void CancelBT_ON_workLocation() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(CancelBtWorklocation));
        loginBtn.click();
        Thread.sleep(1000);
    }
	
	public void click_EditTextField_IN_CompanyName(String CompanyName) throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(EditTextField_IN_CompanyName));
        loginBtn.click();Thread.sleep(1000);
//        loginBtn.sendKeys(Keys.CONTROL + "a");  Thread.sleep(1000);
//        loginBtn.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000); 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", loginBtn);
        
        Thread.sleep(1000);  // Add wait if needed, or use explicit wait
        loginBtn.sendKeys(CompanyName);
    }
	
	public void click_SaveButton_IN_CompanyName() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(SaveButton_IN_CompanyName));
        loginBtn.click();
        Thread.sleep(1000);
    }
	
	public void Verify_new_company_name(String expectedCompanyName) {

		WebElement searchTextBox = driver.findElement(Verify_new_company_name_IN_CompanyName);
		String actualCompanyName = searchTextBox.getDomAttribute("aria-label");
	    System.out.println("Actual Company Name: " + actualCompanyName);
	    Assert.assertEquals(actualCompanyName, expectedCompanyName, "Company name did not match!");
		}
	 public void captureOldCompanyName() {
	        WebElement companyNameElement = driver.findElement(companyNameDisplay);
	        oldCompanyName = companyNameElement.getDomAttribute("aria-label");
	        System.out.println("Captured old Company Name: " + oldCompanyName);
	    }

	    // Method to verify company name is not changed
	    public void verifyCompanyNameNotChanged() throws InterruptedException {
	    	Thread.sleep(2000);
	        WebElement companyNameElement = driver.findElement(companyNameDisplay);
	        String currentCompanyName = companyNameElement.getDomAttribute("aria-label");
	        System.out.println("Current Company Name: " + currentCompanyName);
	        Assert.assertEquals(currentCompanyName, oldCompanyName, "Company name should not be changed after cancel.");
	    }
	
	public void removeCompanyName() throws InterruptedException { 
		WebElement inputField = driver.findElement(EditTextField_IN_CompanyName); Thread.sleep(1000);
		inputField.sendKeys(Keys.CONTROL + "a");  Thread.sleep(500);
		inputField.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000);
		driver.findElement(By.xpath("(//flt-semantics[@role='button'])[3]")).click();Thread.sleep(1000);
	}
	

	
	public void VerifyErrorMessageInCompanyTestField() {
		WebElement searchTextBox = driver.findElement(emptyCompanyFiledError);
		String actualCompanyName = searchTextBox.getDomAttribute("aria-label");
	    System.out.println("Actual Company Name: " + actualCompanyName);
	    String expectedCompanyName = "Company name can't be empty";
	    Assert.assertEquals(actualCompanyName, expectedCompanyName, "Company name did not match!");
    }
	
	public void Click_cancelButtonOncompanyNmae() throws InterruptedException {
//		removeCompanyName();
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(CancelBtCompanyNmae));
		Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(1000);
		
    }
	public void Click_cancelButtonOndateFormat() throws InterruptedException {
		WebElement Date = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Cancel_Date_format));
		Thread.sleep(1000);
		Date.click();
        Thread.sleep(1000);
		
    }
	
	public void VerifyPreviousCompanyName() {
		WebElement searchTextBox = driver.findElement(Verify_new_company_name_IN_CompanyName);
		String actualCompanyName = searchTextBox.getDomAttribute("aria-label");
		String expectedCompanyName = "TechNova Global Pvt. Ltd.";
	    System.out.println("Actual Company Name: " + actualCompanyName);
	    Assert.assertEquals(actualCompanyName, expectedCompanyName, "Company name did not match!");
    }
	
	public void Click_EditBt_On_DateFormat() throws InterruptedException {
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon_IN_DateFormat));
		Thread.sleep(2000);
        loginBtn.click();Thread.sleep(2000);
        WebElement dateFormatDropdown = wait.until(ExpectedConditions.elementToBeClickable((EditIcon_IN_DateFormat)));
        dateFormatDropdown.click();
    }
	public void selectDateFormat(String newFormat) throws InterruptedException {

        WebElement formatOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//flt-semantics[@aria-label='"+ newFormat +"']")));
        System.out.println("DateFormat: " + formatOption);
        formatOption.click();Thread.sleep(1000);
    }

    public void clickSaveButtonOnDateformate() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(SaveButton_IN_Date_format));
        saveButton.click();Thread.sleep(1000);
    }

    public void verifyDateFormat(String expectedFormat) {
    	 WebElement formatOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//flt-semantics[@aria-label='"+ expectedFormat +"']")));
        String actualFormat = formatOption.getDomAttribute("aria-label");
        
        System.out.println("Displayed Date Format: " + actualFormat);
        Assert.assertEquals(actualFormat, expectedFormat, "Date format update failed!");
    }
    public void ChangeTimezoneOnorgnizationSetting() throws InterruptedException {
    	Thread.sleep(1000);
    	WebElement formatOption = wait.until(ExpectedConditions.elementToBeClickable(editiconOntimezone));
    	formatOption.click();Thread.sleep(2000);
    	WebElement formatOption1 = wait.until(ExpectedConditions.elementToBeClickable(clicktimezonedropdown));
    	formatOption1.click();Thread.sleep(2000);
      }
    
    public void getDateFormat(String currentdateformat) {
        WebElement dateFormatElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(getCurrentDateFormate));
        oldDateFormat = dateFormatElement.getDomAttribute("aria-label");
       System.out.println("Old Date Format: " + oldDateFormat);
        System.out.println("currentdateformat: " + currentdateformat);
        Assert.assertEquals(oldDateFormat, currentdateformat, "Company name should not be changed after cancel.");
	    
    }
    public void getOldDateFormat() {
        WebElement dateFormatElement = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(getCurrentDateFormate));
        oldDateFormat = dateFormatElement.getDomAttribute("aria-label");
       System.out.println("Old Date Format: " + oldDateFormat);  
    }

    public void verifyOldDateFormat() {
        WebElement dateFormatElement = BaseClass.wait.until(
            ExpectedConditions.visibilityOfElementLocated(getCurrentDateFormate)
        );
        String currentDateFormat = dateFormatElement.getDomAttribute("aria-label");
        System.out.println("Current Date Format: " + currentDateFormat);

        Assert.assertEquals(currentDateFormat, oldDateFormat, "Date format has changed!");
    }
    
    public void selecttimezone(String timezoneOption) throws InterruptedException {
    	Thread.sleep(2000);
        WebElement selectHr = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//flt-semantics[@aria-label='"+timezoneOption+"']")));
        js.executeScript("arguments[0].scrollIntoView(true);", selectHr);
        selectHr.click();
        
    }
    public void clickSaveButtonOntimezone() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(SaveButton_IN_Timezone));
        saveButton.click();Thread.sleep(1000);
    }
    
    public void TANErrorMessage() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(TANError));
        String error = saveButton.getDomAttribute("aria-label");
        System.out.println("TAN error message: " + error);
        saveButton.isDisplayed();Thread.sleep(1000);
        String expected_error_message = "Please enter a valid TAN number";
        Assert.assertEquals(error, expected_error_message);
    }
    public void PANErrorMessage() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(PANError));
        String error = saveButton.getDomAttribute("aria-label");
        System.out.println("PAN error message: " + error);
        saveButton.isDisplayed();Thread.sleep(1000);
        String expected_error_message = "Please enter a valid PAN number";
        Assert.assertEquals(error, expected_error_message);
    }
    public void Enter_GSTIN_NO(String PAN) throws InterruptedException {
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Enter_GSTIN_No));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.clear();
        loginBtn.sendKeys(PAN);
    }
    
    public void GSTINErrorMessage() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(GSTINError));
        String error = saveButton.getDomAttribute("aria-label");
        System.out.println("GSTIN error message: " + error);
        saveButton.isDisplayed();Thread.sleep(1000);
        String expected_error_message = "Please enter a valid GSTIN number";
        Assert.assertEquals(error, expected_error_message);
    }
    public void registered_business_address_filed() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(registered_business_address));
        String error = saveButton.getDomAttribute("aria-label");
        System.out.println("GSTIN error message: " + error);
        saveButton.isDisplayed();Thread.sleep(1000);
        String expected_error_message = "Registered Business address";
        Assert.assertEquals(error, expected_error_message);
    }
    public void registered_business_address_filed_Error_message() throws InterruptedException {
    	Thread.sleep(1000);
    	WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(registered_business_address_error));
        String error = saveButton.getDomAttribute("aria-label");
        System.out.println("GSTIN error message: " + error);
        saveButton.isDisplayed();Thread.sleep(1000);
        String expected_error_message = "Please select Registered Business address";
        Assert.assertEquals(error, expected_error_message);
    }
    public void Click_Add_Work_Location_Btn_on_organizationSetting() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Add_Work_Location_Btn));
        loginBtn.click();
        Thread.sleep(1000);
    }
    public void Enter_Address(String Address) throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(AddressTextFiled));
//        loginBtn.click();Thread.sleep(1000);
        loginBtn.sendKeys(Keys.CONTROL + "a");  Thread.sleep(1000);
        loginBtn.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000);
        loginBtn.sendKeys(Address);
    }
    public void Enter_Address_Edit(String Address) throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(EditAddressTextFiled));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.sendKeys(Keys.CONTROL + "a");  Thread.sleep(1000);
        loginBtn.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000);
        loginBtn.sendKeys(Address);
    }
    public void Select_County(String County1) throws InterruptedException {
    	 WebElement country = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(ClickCountryfiled));Thread.sleep(1000);
    	 country.click();Thread.sleep(2000);
    	 WebElement enterCountryName = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SearchCountryBar));Thread.sleep(2000);
    	 enterCountryName.sendKeys(County1);Thread.sleep(2000);
          driver.findElement(By.xpath("//flt-semantics[@aria-label='"+County1+"']")).click();Thread.sleep(1000);
         
    }
    public void update_Countyinworklocation(String County1) throws InterruptedException {
         driver.findElement(By.xpath("(//flt-semantics[@role='text'])[3]")).click();Thread.sleep(3000);
         WebElement enterCountryName = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SearchCountryBar));Thread.sleep(2000);
   	     enterCountryName.sendKeys(County1);Thread.sleep(2000);
   	  driver.findElement(By.xpath("//flt-semantics[@aria-label='"+County1+"']")).click();Thread.sleep(1000);
   	 }
    public void Select_State(String State) throws InterruptedException {
   	 WebElement country = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(ClickStatefiled));Thread.sleep(1000);
   	 country.click();Thread.sleep(1000);
   	 WebElement enterCountryName = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SearchStateBar));Thread.sleep(1000);
   	 enterCountryName.sendKeys(State);Thread.sleep(1000);
         driver.findElement(By.xpath("//flt-semantics[@aria-label='"+State+"']")).click();Thread.sleep(1000);
        
   }
    public void update_Stateinworklocation(String State) throws InterruptedException {
    	driver.findElement(By.xpath("(//flt-semantics[@role='text'])[4]")).click();Thread.sleep(2000);
      	 WebElement enterCountryName = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SearchStateBar));Thread.sleep(1000);
      	 enterCountryName.sendKeys(State);Thread.sleep(1000);
            driver.findElement(By.xpath("//flt-semantics[@aria-label='"+State+"']")).click();Thread.sleep(2000);
           
      }
    public void Select_City(String City) throws InterruptedException {
      	 WebElement country = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(ClickCityfiled));Thread.sleep(2000);
      	 country.click();Thread.sleep(2000);
      	 WebElement enterCountryName = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SearchCityBar));Thread.sleep(2000);
      	 enterCountryName.sendKeys(City);Thread.sleep(1000);
            driver.findElement(By.xpath("//flt-semantics[@aria-label='"+City+"']")).click();Thread.sleep(2000);
           
      }
    public void update_Cityinworklocation(String City) throws InterruptedException {
    	driver.findElement(By.xpath("(//flt-semantics[@role='text'])[5]")).click();Thread.sleep(2000);
      	 WebElement enterCountryName = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SearchCityBar));Thread.sleep(3000);
      	 enterCountryName.sendKeys(City);Thread.sleep(2000);
            driver.findElement(By.xpath("//flt-semantics[@aria-label='"+City+"']")).click();Thread.sleep(2000);
           
      }
    public void Enter_pincode(String pin) throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(PincodeTextFiled));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.sendKeys(Keys.CONTROL + "a");  Thread.sleep(1000);
        loginBtn.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000);
        loginBtn.sendKeys(pin);
    }
    
    public void update_pincode(String pin) throws InterruptedException {
    	WebElement loginBtn = driver.findElement(By.xpath("//input[@data-semantics-role='text-field']"));Thread.sleep(1000);
        loginBtn.click();Thread.sleep(2000);
        loginBtn.sendKeys(Keys.CONTROL + "a");  Thread.sleep(2000);
        loginBtn.sendKeys(Keys.BACK_SPACE);  Thread.sleep(2000);
        loginBtn.sendKeys(pin);
    }
    public void Click_SaveBtn_on_organizationSetting() throws InterruptedException {
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        loginBtn.click();
        Thread.sleep(1000);
    }
    public void Verify_new_address(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
    	Thread.sleep(1000);

        // Construct expected address string
        String expectedAddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;

        // Find all work locations & Get the last location
        List<WebElement> workLocations = driver.findElements(By.xpath("//flt-semantics[@role='group']"));
        int maxIndex = workLocations.size();
        System.out.println("maxIndex: "+maxIndex);
        WebElement lastLocation = workLocations.get(maxIndex - 1);
        String actualAddress = lastLocation.getDomAttribute("aria-label");
        
        Thread.sleep(1000);
        Assert.assertEquals(actualAddress, expectedAddress);
    	
    	
        
    }
    public void Verify_new_address_is_not_saved(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
    	Thread.sleep(1000);

        // Construct expected address string
        String expectedAddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;

        // Find all work locations & Get the last location
        List<WebElement> workLocations = driver.findElements(By.xpath("//flt-semantics[@role='group']"));
        int maxIndex = workLocations.size();
        System.out.println("maxIndex: "+maxIndex);
        WebElement lastLocation = workLocations.get(maxIndex - 1);
        String actualAddress = lastLocation.getDomAttribute("aria-label");
        
        Thread.sleep(1000);
//        Assert.assertEquals(actualAddress, expectedAddress);
        Assert.assertNotEquals(actualAddress, expectedAddress);
    	
    	
        
    }
    public void Verify_Selected_address_is_delete(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
    	Thread.sleep(1000);

        // Construct expected address string
        String expectedAddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;
        String Xpath_editaddress = "//flt-semantics[@aria-label='"+expectedAddress+"']";
        
        List<WebElement> addressList = driver.findElements(By.xpath(Xpath_editaddress));
        Assert.assertTrue(addressList.isEmpty(), "Address '" + Xpath_editaddress + "' should have been deleted but is still visible.");
    	
    	
        
    }
    public void ClickingEditAddressIcon(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
    	String editaddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;
    	System.out.println("Edit Address: "+editaddress);
    	String Xpath_editaddress = "(//flt-semantics[@aria-label='"+editaddress+"']/flt-semantics-container/flt-semantics)[1]";
    	System.out.println("Xpath edit address: "+Xpath_editaddress);
    	Thread.sleep(1000);
    	driver.findElement(By.xpath(Xpath_editaddress)).click();
    	
    }
    public void ClickingDeleteAddressIcon(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
    	String editaddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;
    	System.out.println("Edit Address: "+editaddress);
    	String Xpath_editaddress = "(//flt-semantics[@aria-label='"+editaddress+"']/flt-semantics-container/flt-semantics)[2]";
    	System.out.println("Xpath edit address: "+Xpath_editaddress);
    	Thread.sleep(1000);
    	driver.findElement(By.xpath(Xpath_editaddress)).click();
    	
//    	validate if selected address is selected or not for deleting 
    	String selected_add ="Are you sure you want to delete this work location?\n"
    			+ ""+editaddress+"";
    	System.out.println("selected_add: "+selected_add);
    	String actual_add =driver.findElement(By.xpath("(//flt-semantics[@role='text'])[2]")).getDomAttribute("aria-label");
    	System.out.println("actual_add: "+actual_add);
    	Assert.assertEquals(actual_add, selected_add);
    	
    }
    public void Click_yesBtn_on_deleteworklocation() throws InterruptedException {
    	Thread.sleep(1000);
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(YesBtn));
        loginBtn.click();
        
    }
    public void Click_NOBtn_on_deleteworklocation() throws InterruptedException {
    	Thread.sleep(1000);
        WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(noBtn));
        loginBtn.click();
        
    }
    public void dONOT_DISPLAYED_ERROR_INVALID_MESSAGE_IN_TAN_FIELD() throws InterruptedException {
    	Thread.sleep(1000);
    	List<WebElement> errorMessages = driver.findElements(TANError);
    	Assert.assertTrue(errorMessages.isEmpty(), "Error message should not be displayed.");
    	}
    public void dONOT_DISPLAYED_ERROR_INVALID_MESSAGE_IN_PAN_FIELD() throws InterruptedException {
    	Thread.sleep(1000);
    	List<WebElement> errorMessages = driver.findElements(PANError);
    	Assert.assertTrue(errorMessages.isEmpty(), "Error message should not be displayed.");
    	}
    public void dONOT_DISPLAYED_ERROR_INVALID_MESSAGE_IN_GSTIN_FIELD() throws InterruptedException {
    	Thread.sleep(1000);
    	List<WebElement> errorMessages = driver.findElements(GSTINError);
    	Assert.assertTrue(errorMessages.isEmpty(), "Error message should not be displayed.");
    	}
    public void Select_TaxType(String taxPayerType) throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//flt-semantics[@aria-label='Tax payer type']")).click();
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//flt-semantics[@aria-label='" + taxPayerType + "']")).click();
    	
    	}
    public void varity_selected_taxType(String taxPayerType) throws InterruptedException {
    	Thread.sleep(1000);
    	String actual = driver.findElement(By.xpath("(//flt-semantics[@role='button'])[2]")).getDomAttribute("aria-label");
    	Assert.assertEquals(actual, taxPayerType);
    	
    	}
    public void verify_Error_message_For_Registered_Business_address () throws InterruptedException {
    	Thread.sleep(1000);
    	String expected = "Please select Registered Business address";
    	String actual = driver.findElement(By.xpath("//flt-semantics[@aria-label='Please select Registered Business address']")).getDomAttribute("aria-label");
    	Assert.assertEquals(actual, expected);
    	
    	}
    public void click_Tax_Details_inOrganization_details() throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//flt-semantics[@aria-label='Tax details']")).click();
    	
    	}
    public void SelectRegisteredAddress(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//flt-semantics[@aria-label='Registered Business address']")).click();
    	String editaddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;
    	String Xpath_editaddress = "//flt-semantics[@aria-label='"+editaddress+"']";
    	System.out.println("Xpath edit address: "+Xpath_editaddress);
    	Thread.sleep(1000);
    	driver.findElement(By.xpath(Xpath_editaddress)).click();
    	
    	}
    public void VerifySelectRegisteredAddress(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
    	Thread.sleep(1000);
    	String expectedAddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;
    	String actualSelectedAddress =driver.findElement(By.xpath("(//flt-semantics[@role='button'])[3]")).getDomAttribute("aria-label");
    	Assert.assertEquals(actualSelectedAddress, expectedAddress);
    	
    	
    	}
    public void selectTaxTypeData(String taxPayerType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<String> xpaths = Arrays.asList(
            "//flt-semantics[@aria-label='Proprietor']",
            "//flt-semantics[@aria-label='Partnership']",
            "//flt-semantics[@aria-label='LLP']",
            "//flt-semantics[@aria-label='Private Limited']",
            "//flt-semantics[@aria-label='Public']",
            "//flt-semantics[@aria-label='Tax payer type']"
        );

        WebElement element = null;

        for (String xpath : xpaths) {
            try {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                System.out.println("Found element using XPath: " + xpath);
                break; // Exit the loop if found
            } catch (Exception e) {
                // Continue trying next xpath
            }
        }

        if (element != null) {
            element.click(); // Click on the found element
        } else {
            System.out.println("Element not found with any XPath!");
        }

        // Now, try to click specific taxPayerType
        try {
            WebElement taxTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//flt-semantics[@aria-label='" + taxPayerType + "']")));
            taxTypeElement.click();
            System.out.println("Clicked on tax type: " + taxPayerType);
        } catch (Exception e) {
            System.out.println("Specific tax type '" + taxPayerType + "' not found!");
        }
    }
    public void entertannumberdata(String tan) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By firstXPath = By.xpath("//input[@aria-label='Tax Deduction & Collection Account Number (TAN)']");
        By secondXPath = By.xpath("(//input[@data-semantics-role='text-field'])[1]");

        WebElement element = null;

        if (isElementPresent(firstXPath, wait)) {
            element = driver.findElement(firstXPath);
            System.out.println("Found using 1st XPath");
        } else if (isElementPresent(secondXPath, wait)) {
            element = driver.findElement(secondXPath);
            System.out.println("Found using 2nd XPath");
        } else {
            System.out.println("Element not found with any XPath!");
        }

        if (element != null) {
        	element.click();Thread.sleep(1000);
        	element.clear();Thread.sleep(1000);
            element.sendKeys(Keys.CONTROL + "a");  Thread.sleep(1000);
            element.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000); 
//          JavascriptExecutor js = (JavascriptExecutor) driver;
//          js.executeScript("arguments[0].value = '';", element);
          
          Thread.sleep(1000);  // Add wait if needed, or use explicit wait
            element.sendKeys(tan);
            System.out.println("Clicked successfully");
        }
    }

    private boolean isElementPresent(By locator, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void enterpannumberdata(String tan) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By firstXPath = By.xpath("//input[@aria-label='Permanent Account Number (PAN)']");
        By secondXPath = By.xpath("(//input[@data-semantics-role='text-field'])[2]");

        WebElement element = null;

        if (isElementPresent(firstXPath, wait)) {
            element = driver.findElement(firstXPath);
            System.out.println("Found using 1st XPath");
        } else if (isElementPresent(secondXPath, wait)) {
            element = driver.findElement(secondXPath);
            System.out.println("Found using 2nd XPath");
        } else {
            System.out.println("Element not found with any XPath!");
        }

        if (element != null) {
        	element.click();Thread.sleep(1000);
        	element.clear();Thread.sleep(1000);
            element.sendKeys(Keys.CONTROL + "a");  Thread.sleep(1000);
            element.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000); 
//          JavascriptExecutor js = (JavascriptExecutor) driver;
//          js.executeScript("arguments[0].value = '';", element);
          
          Thread.sleep(1000);  // Add wait if needed, or use explicit wait
            element.sendKeys(tan);
            System.out.println("Clicked successfully");
        }
    }
    public void enterGSTnumberdata(String tan) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        By firstXPath = By.xpath("//input[@aria-label='GSTIN']");
        By secondXPath = By.xpath("(//input[@data-semantics-role='text-field'])[3]");

        WebElement element = null;

        if (isElementPresent(firstXPath, wait)) {
            element = driver.findElement(firstXPath);
            System.out.println("Found using 1st XPath");
        } else if (isElementPresent(secondXPath, wait)) {
            element = driver.findElement(secondXPath);
            System.out.println("Found using 2nd XPath");
        } else {
            System.out.println("Element not found with any XPath!");
        }

        if (element != null) {
        	element.click();Thread.sleep(1000);
        	element.clear();Thread.sleep(1000);
            element.sendKeys(Keys.CONTROL + "a");  Thread.sleep(1000);
            element.sendKeys(Keys.BACK_SPACE);  Thread.sleep(1000); 
//          JavascriptExecutor js = (JavascriptExecutor) driver;
//          js.executeScript("arguments[0].value = '';", element);
          
          Thread.sleep(1000);  // Add wait if needed, or use explicit wait
            element.sendKeys(tan);
            System.out.println("Clicked successfully");
        }
    }
    
    public void selectaddressData(String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<String> xpaths = Arrays.asList(
            "//flt-semantics[@aria-label='101, Galaxy Heights, Mumbai, Maharashtra, India, 123456']",
            "//flt-semantics[@aria-label='22, Lotus Apartments, New Delhi, Delhi, India, 234567']",
            "//flt-semantics[@aria-label='303, Sunrise Residency, Bangalore Rural, Karnataka, India, 345678']",
            "//flt-semantics[@aria-label='88, Green Park Colony, Hyderabad, Telangana, India, 567890']",
            "//flt-semantics[@aria-label='55, Palm Beach Road, Chennai, Tamil Nadu, India, 456789']",
            "//flt-semantics[@aria-label='Registered Business address']"
        );

        WebElement element = null;

        for (String xpath : xpaths) {
            try {
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                System.out.println("Found element using XPath: " + xpath);
                break; // Exit the loop if found
            } catch (Exception e) {
                // Continue trying next xpath
            }
        }

        if (element != null) {
            element.click(); // Click on the found element
            String editaddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;
        	String Xpath_editaddress = "//flt-semantics[@aria-label='"+editaddress+"']";
        	System.out.println("Xpath edit address: "+Xpath_editaddress);
        	Thread.sleep(1000);
        	driver.findElement(By.xpath(Xpath_editaddress)).click();
        } else {
            System.out.println("Element not found with any XPath!");
        }
       
    }
    
    public void enterd_tax_details_should_be_save(String TaxTypes, String TAN, String PAN, String GST, String Address, String City, String State, String Country, String Pincode) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Thread.sleep(1000);
        driver.findElement(Click_TaxDetails).click();
        Thread.sleep(1000);
        
        // Validate TaxType
        WebElement TaxType1= driver.findElement(By.xpath("(//flt-semantics[@role='button'])[3]"));
        Assert.assertEquals(TaxType1.getDomAttribute("aria-label"), TaxTypes);
       

        // Validate TAN
        String tanElement = driver.findElement(By.xpath("(//input[@data-semantics-role='text-field'])[1]")).getDomAttribute("aria-label");
        String tan1 = tanElement.split("\\s+")[0];
        Assert.assertEquals(tan1, TAN);

        // Validate PAN
        String panElement = driver.findElement(By.xpath("(//input[@data-semantics-role='text-field'])[2]")).getDomAttribute("aria-label");
        String pan1 = panElement.split("\\s+")[0];
        Assert.assertEquals(pan1, PAN);

        // Validate GST
        String gstElement = driver.findElement(By.xpath("(//input[@data-semantics-role='text-field'])[3]")).getDomAttribute("aria-label");
        String GST1 = gstElement.split("\\s+")[0];
        Assert.assertEquals(GST1, GST);

        // Validate Address
        String expectedAddress = Address + ", " + City + ", " + State + ", " + Country + ", " + Pincode;
        WebElement addressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//flt-semantics[@role='button'])[4]")));
        Assert.assertEquals(addressElement.getDomAttribute("aria-label"), expectedAddress);

        System.out.println("All entered Tax Details are successfully validated.");
    }
    
    public void Change_timezone(String timezone) throws InterruptedException {
//    	WebElement edittimezone = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(editiconOntimezone));
//    	edittimezone.click();Thread.sleep(1000);
    	
//    	WebElement opendropdown = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(clicktimezonedropdown));
//    	opendropdown.click();Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//flt-semantics[@aria-label='"+timezone+"']")).click();
    }
    
    public void click_save_button_on_timezone() throws InterruptedException {
    	WebElement save = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SaveButton_IN_Timezone));
    	save.click();
    	Thread.sleep(1000);
    	}
    public void click_cancell_button_on_timezone() throws InterruptedException {
    	WebElement cancell = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(CancelBtTimezone));
    	cancell.click();
    	Thread.sleep(1000);
    	}
    public void verify_selected_timezone(String expected_timezone) throws InterruptedException {
    	String actual_timezone= driver.findElement(By.xpath("(//flt-semantics[@role='text'])[7]")).getDomAttribute("aria-label");
    	Assert.assertEquals(actual_timezone, expected_timezone);
    }
    public void verify_selected_timezoneon_addTeamMembre_form(String expected_timezone) throws InterruptedException {
    	String actual_timezone= driver.findElement(By.xpath("(//flt-semantics[@role='text'])[7]")).getDomAttribute("aria-label");
    	Assert.assertEquals(actual_timezone, expected_timezone);
    }
    public void getcurrenttimezone() {
    	oldtimezone= driver.findElement(By.xpath("(//flt-semantics[@role='text'])[7]")).getDomAttribute("aria-label");
    	System.out.println("Old timezone: "+oldtimezone);
    }
    public void verfiyoldtimezone() {
    	String actual_timezone= driver.findElement(By.xpath("(//flt-semantics[@role='text'])[7]")).getDomAttribute("aria-label");
    	System.out.println("actual_timezone: "+actual_timezone);
    	Assert.assertEquals(oldtimezone, actual_timezone);
    }
    

    
	}
