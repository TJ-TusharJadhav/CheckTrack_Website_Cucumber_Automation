package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseClass;

public class LeaveTypesPage extends BaseClass{
	String leavetypeName = "Leave Name: "+ timeStamp;
	String actualTypeValue;
	String actualTypeValue1;
private By leaveTypeBtn  = By.xpath("(//flt-semantics[@role='img'])[1]");
private By paidLeave  = By.xpath("//flt-semantics[@aria-label='Paid Leave']");
private By UnpaidLeave  = By.xpath("//flt-semantics[@aria-label='Unpaid Leave']");

private By AddLeaveTypeBtn  = By.xpath("//flt-semantics[@aria-label='ADD LEAVE TYPE']");
private By Type  = By.xpath("//input[@data-semantics-role='text-field']");
private By Leave_Policy  = By.xpath("//textarea[@data-semantics-role='text-field']");
private By Balance_tracked_checkBox  = By.xpath("(//flt-semantics[@role='checkbox'])[1]");
private By Negative_Balance_allowed_checkBox  = By.xpath("(//flt-semantics[@role='checkbox'])[2]");

private By SaveBtn  = By.xpath("//flt-semantics[@aria-label='SAVE']");
private By CANCELBtn  = By.xpath("//flt-semantics[@aria-label='CANCEL']");

private By verityLeaveTypeNmae  = By.xpath("(//flt-semantics[@role='group'])[1]");
private By verityLeaveTypePage =By.xpath("//flt-semantics[@aria-label='Leave types']");
private By verityduplicateLeaveTypeerrormsg  = By.xpath("//flt-semantics[@aria-label='Duplicate leave type!']");
private By verityEmptyLeaveTypeerrormsg  = By.xpath("(//flt-semantics[@role='text'])[2]");

	
	public void clickleaveTypeBtn() throws InterruptedException {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(leaveTypeBtn));
        Thread.sleep(1000);
        mainManu1.click();
    }
	public void verfiy_paid_leave_type() throws InterruptedException {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(paidLeave));
        js.executeScript("arguments[0].value = '';", mainManu1);
        Thread.sleep(1000);  
        String Actual1= mainManu1.getDomAttribute("aria-label");
        String Expected1= "Paid Leave";
        Assert.assertEquals(Actual1, Expected1);
    }
	public void verfiy_Unpaid_leave_type() throws InterruptedException {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(UnpaidLeave));
        js.executeScript("arguments[0].value = '';", mainManu1);
        Thread.sleep(1000); 
        String Actual1= mainManu1.getDomAttribute("aria-label");
        String Expected1= "Unpaid Leave";
        Assert.assertEquals(Actual1, Expected1);
    }
	public void clickAddLeavetypeBtn() throws InterruptedException {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(AddLeaveTypeBtn));
        Thread.sleep(1000);
        mainManu1.click();
        Thread.sleep(1000);
    }
	public void Enter_duplicateLeaveTypeName(String name) throws InterruptedException {
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Type));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.clear();
        loginBtn.sendKeys(name);
    }
	public void Enter_LeaveTypeName(String name) throws InterruptedException {
		actualTypeValue  = name+ timeStamp;
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Type));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.clear();
        loginBtn.sendKeys(actualTypeValue );
    }
	public void Enter_LeavePolicy(String type) throws InterruptedException {
		actualTypeValue  = type+ timeStamp;
		Thread.sleep(1000);
		WebElement loginBtn = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Leave_Policy));
        loginBtn.click();Thread.sleep(1000);
        loginBtn.clear();
        loginBtn.sendKeys(actualTypeValue);
    }
	public void clickSaveBtn() throws InterruptedException {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
        Thread.sleep(1000);
        mainManu1.click();
    }
	public void clickcancelBtn() throws InterruptedException {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(CANCELBtn));
        Thread.sleep(1000);
        mainManu1.click();
    }
	
	public void verfiy_new_leave_type(String type, String policy) throws InterruptedException {
		String expectedType = type + timeStamp;
		String expectedpolicy = policy + "_" + timeStamp;
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(verityLeaveTypeNmae));
        Thread.sleep(1000); 
        String Actual1= mainManu1.getDomAttribute("aria-label");
        Assert.assertEquals(Actual1, expectedType);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//flt-semantics[@tabindex='0'])[6]")).click();
        Thread.sleep(1000);
        WebElement mainManu2 = driver.findElement(Leave_Policy);
        String Actual2= mainManu2.getDomAttribute("aria-label");
        
        Assert.assertEquals(Actual2, expectedpolicy);
	 }
	public void verfiy_duplicate_leave_type_error_message() throws InterruptedException {
        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(verityduplicateLeaveTypeerrormsg));
        Thread.sleep(1000); 
        String Actual1= mainManu1.getDomAttribute("aria-label");
        String Expected= "Duplicate leave type!";
        Assert.assertEquals(Actual1, Expected);
	 }
	 public void Enter_Leave_TypeName_For_Validation_This_type_is_trackORnottrack() throws InterruptedException {
	    	WebElement Unpaid = wait.until(ExpectedConditions.visibilityOfElementLocated(Type));
	        Thread.sleep(1000);
	        Unpaid.sendKeys(leavetypeName);
	    }
	 public void clickbalanceTrackedCheckBox() throws InterruptedException {
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Balance_tracked_checkBox));
	        Thread.sleep(1000);
	        mainManu1.click();
	    }
	 public void clickNegativeleaveCheckBox() throws InterruptedException {
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(Negative_Balance_allowed_checkBox));
	        Thread.sleep(1000);
	        mainManu1.click();
	    }
	 public void validation_unpaid_leave() throws InterruptedException {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//flt-semantics[@tabindex='0'])[6]")).click();
		 Thread.sleep(2000);
		 WebElement Unpaid = wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_tracked_checkBox));
		 String Actual= Unpaid.getDomAttribute("aria-checked");
		 String Expected= "false";
		 Assert.assertEquals(Actual, Expected);
	       
		 
	 }
	 public void validation_paid_BalanceTracked_leave() throws InterruptedException {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//flt-semantics[@tabindex='0'])[6]")).click();
		 Thread.sleep(2000);
		 WebElement Bt = wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_tracked_checkBox));
		 String Actual= Bt.getDomAttribute("aria-checked");
		 String Expected= "true";
		 Assert.assertEquals(Actual, Expected);
		 
		 WebElement Nb = wait.until(ExpectedConditions.visibilityOfElementLocated(Negative_Balance_allowed_checkBox));
		 String Actual1= Nb.getDomAttribute("aria-checked");
		 String Expected1= "false";
		 Assert.assertEquals(Actual1, Expected1);
	       
		 
	 }
	 public void validation_paid_BalanceTracked_leave1() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement Bt = wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_tracked_checkBox));
		 String Actual= Bt.getDomAttribute("aria-checked");
		 String Expected= "true";
		 Assert.assertEquals(Actual, Expected);
		 
		 WebElement Nb = wait.until(ExpectedConditions.visibilityOfElementLocated(Negative_Balance_allowed_checkBox));
		 String Actual1= Nb.getDomAttribute("aria-checked");
		 String Expected1= "false";
		 Assert.assertEquals(Actual1, Expected1);
	       
		 
	 }
	 public void validation_paid_negative_balance_leave() throws InterruptedException {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//flt-semantics[@tabindex='0'])[6]")).click();
		 Thread.sleep(2000);
		 WebElement Bt = wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_tracked_checkBox));
		 String Actual= Bt.getDomAttribute("aria-checked");
		 String Expected= "true";
		 Assert.assertEquals(Actual, Expected);
		 
		 WebElement Nb = wait.until(ExpectedConditions.visibilityOfElementLocated(Negative_Balance_allowed_checkBox));
		 String Actual1= Nb.getDomAttribute("aria-checked");
		 String Expected1= "true";
		 Assert.assertEquals(Actual1, Expected1);
	       
		 
	 }
	 public void validation_paid_negative_balance_leave1() throws InterruptedException {
		 Thread.sleep(2000);
		 WebElement Bt = wait.until(ExpectedConditions.visibilityOfElementLocated(Balance_tracked_checkBox));
		 String Actual= Bt.getDomAttribute("aria-checked");
		 String Expected= "true";
		 Assert.assertEquals(Actual, Expected);
		 
		 WebElement Nb = wait.until(ExpectedConditions.visibilityOfElementLocated(Negative_Balance_allowed_checkBox));
		 String Actual1= Nb.getDomAttribute("aria-checked");
		 String Expected1= "true";
		 Assert.assertEquals(Actual1, Expected1);
	       
		 
	 }
	 public void verfiy_Empty_leave_type_error_message() throws InterruptedException {
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(verityEmptyLeaveTypeerrormsg));
	        Thread.sleep(1000); 
	        String Actual1= mainManu1.getDomAttribute("aria-label");
	        String Expected= "Name can't be empty";
	        Assert.assertEquals(Actual1, Expected);
		 }
	 public void verfiy_leaveTypePage() throws InterruptedException {
	        WebElement mainManu1 = BaseClass.wait.until(ExpectedConditions.elementToBeClickable(verityLeaveTypePage));
	        WebElement mainManu2 =driver.findElement(AddLeaveTypeBtn);
	        Thread.sleep(1000); 
	        String Actual1= mainManu1.getDomAttribute("aria-label");
	        String Actual2= mainManu2.getDomAttribute("aria-label");
	        String Expected1= "Leave types";
	        String Expected2= "ADD LEAVE TYPE";
	        Assert.assertEquals(Actual1, Expected1);
	        Assert.assertEquals(Actual2, Expected2);
		 }
	 public void click_edit_icon_for_EditeLeaveType(String oldleavename) {
		 driver.findElement(By.xpath("//flt-semantics[@aria-label='"+oldleavename+"']/flt-semantics-container/flt-semantics[@tabindex='0']")).click();
		}
	 public void edit_leaveTypeAndPolicy(String name, String policy) throws InterruptedException {
		 Thread.sleep(1000); 
		 actualTypeValue  = name+ timeStamp;
		 actualTypeValue1  = policy+ timeStamp;
		 WebElement mainManu1 =driver.findElement(Type);
		 mainManu1.click();Thread.sleep(1000); 
		 js.executeScript("arguments[0].value = '';", mainManu1); 
		 mainManu1.sendKeys(actualTypeValue);
		 WebElement mainManu2 =driver.findElement(Leave_Policy);
		 mainManu2.click();Thread.sleep(1000); 
		 js.executeScript("arguments[0].value = '';", mainManu2);
		 mainManu2.sendKeys(actualTypeValue1);
		 
	 }
	 
	 }


