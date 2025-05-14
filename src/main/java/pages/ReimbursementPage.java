package pages;

import java.awt.AWTException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import base.BaseClass;
import utility.FileUploadUtil;

public class ReimbursementPage extends BaseClass {
	private By AddReimbursementsBtn  = By.xpath("//flt-semantics[@aria-label='REQUEST']");
	private By SummaryNameFiled  = By.xpath("//input[@aria-label='Summary']");
	private By Expense_date  = By.xpath("//input[@aria-label='Expense date']");
	private By Details  = By.xpath("//textarea[@aria-label='Details']");
	private By Amount  = By.xpath("//input[@aria-label='Amount']");
	private By supporing_proof  = By.xpath("//flt-semantics[@aria-label='Supporting images or documents\n"
    		+ "(maximum 5 MB each)']");
	private By SubmitBtn  = By.xpath("//flt-semantics[@aria-label='SUBMIT']");
	private By CancelBtn  = By.xpath("//flt-semantics[@aria-label='CANCEL']");
	private By PastRequests  = By.xpath("//flt-semantics[@aria-label='Past requests']");
	
	public void Click_AddReimbursementsBtn() throws InterruptedException {
        WebElement ReimbursementsBtn1 = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(AddReimbursementsBtn));
        Thread.sleep(1000);
        ReimbursementsBtn1.click();
    }
	
	public void EnterSummaryName(String summary) throws InterruptedException {
        WebElement SummaryName = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SummaryNameFiled));
        Thread.sleep(1000);
        SummaryName.sendKeys(summary);
    }
	public void Select_ExpenceDate(String Expense_date1) throws InterruptedException {
		WebElement ExpenceDate = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Expense_date));
        Thread.sleep(1000);
        ExpenceDate.click();
	        Thread.sleep(1000);

	        // Select Date
	        String[] dateParts = Expense_date1.split(" ");
	        String day = dateParts[0];         // "20"
	        String month = dateParts[1];       // "November"
	        String year = dateParts[2];        // "2024"

	        // Call your custom calendar selection method
	        date.selectDate(day, month, year);
	        Thread.sleep(2000);
    }
	public void EnterDetails(String Details1) throws InterruptedException {
        WebElement Detail = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Details));
        Thread.sleep(1000);
        Detail.sendKeys(Details1);
    }
	public void EnterAmount(String price) throws InterruptedException {
        WebElement Amount1 = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Amount));
        Thread.sleep(1000);
        Amount1.sendKeys(price);
    }
	public void Upload_Reimbursement_Attachment(String path) throws InterruptedException, AWTException {
        WebElement proof = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(supporing_proof));
        Thread.sleep(1000);
        proof.click();
        Thread.sleep(2000);
        String imagePath = System.getProperty("user.dir") + path;
        FileUploadUtil.uploadFile(imagePath);
        
    }
	public void Click_submit_button() throws InterruptedException {
		 WebElement date = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitBtn));
	        Thread.sleep(1000);
	        date.click();
   }
	public void Click_cancel_button() throws InterruptedException {
		 WebElement date = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(CancelBtn));
	        Thread.sleep(1000);
	        date.click();
  }
	public void verify_request_status() throws InterruptedException {
		Thread.sleep(3000);
		String Actual =driver.findElement(By.xpath("(//flt-semantics[@aria-label='Website\n"
				+ "S\n"
				+ "Expense date:\n"
				+ "25/11/2025\n"
				+ "Amount:\n"
				+ "₹499.00'])")).getDomAttribute("aria-label");
		String Expected = "Website\n"
				+ "S\n"
				+ "Expense date:\n"
				+ "25/11/2025\n"
				+ "Amount:\n"
				+ "₹499.00";
		Assert.assertEquals(Expected, Actual);
 }
	public void verify_Past_request() throws InterruptedException {
		 WebElement date = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(PastRequests));
	        Thread.sleep(1000);
	        date.isDisplayed();
		
 }
	public void validate_request_data(String Summary, String Expense_date, String Details, String Amount, String Supporting_file) throws InterruptedException, ParseException {
		WebElement submit =driver.findElement(By.xpath("//flt-semantics[@aria-label='Website\n"
				+ "S\n"
				+ "Expense date:\n"
				+ "25/11/2025\n"
				+ "Amount:\n"
				+ "₹499.00']"));

		submit.click();
		Thread.sleep(1000);
//		verify summary name 
		String Actual =driver.findElement(By.xpath("(//flt-semantics[@role='text'])[1]")).getDomAttribute("aria-label");
		Thread.sleep(1000);
		Assert.assertEquals(Actual, Summary);
		
//		Verify status(draft,submitted, approved)
		driver.findElement(By.xpath("(//flt-semantics[@aria-label='S'])[1]")).isDisplayed();
		
		String RequestDetails =driver.findElement(By.xpath("(//flt-semantics[@role='text'])[3]")).getDomAttribute("aria-label");
		
		
		// verifying Expense date in submitted request  
	    Pattern pattern1 = Pattern.compile("Expense date:\\s*(\\d{2}/\\d{2}/\\d{4})");
	    Matcher matcher1 = pattern1.matcher(RequestDetails);
	    if (matcher1.find()) {
	        String actualExpenseDate= matcher1.group(1); 
	        Thread.sleep(1000);
	        
//	        Convert date format  
	        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy");
	        SimpleDateFormat output = new SimpleDateFormat("dd MMMM yyyy");

	        Date dateObj = input.parse(actualExpenseDate);
	        String converted = output.format(dateObj);

	        Assert.assertEquals(converted, Expense_date);

	    } 

		// verifying Submitted date in submitted request  
		 Pattern pattern = Pattern.compile("Submitted date:\\s*(\\d{2}/\\d{2}/\\d{4})");
		    Matcher matcher = pattern.matcher(RequestDetails);

		    if (matcher.find()) {
		        String actualSubmittedDate  = matcher.group(1);
		        String expectedDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		        Thread.sleep(1000);
		        Assert.assertEquals(actualSubmittedDate , expectedDate);

		    } 

		 
//			verify amount 
		    
		    Pattern pattern2 = Pattern.compile("₹(\\d+)");
		    Matcher matcher2 = pattern2.matcher(RequestDetails);
		    if (matcher2.find()) {
		        String actualAmount  = matcher2.group(1); 
		        Thread.sleep(1000);
		        Assert.assertEquals(actualAmount , Amount);

		    }
			
//			verify Details 
		    Pattern pattern11 = Pattern.compile("Details:\\s*(.*)", Pattern.DOTALL);
		    Matcher matcher11 = pattern11.matcher(RequestDetails);
		    if (matcher11.find()) {
		        String actualDetails  = matcher11.group(1); 
		        Thread.sleep(1000);
		        Assert.assertEquals(actualDetails , Details);

		    } 
		
}

	

}
