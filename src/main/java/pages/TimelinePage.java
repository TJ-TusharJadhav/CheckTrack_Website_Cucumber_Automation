package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;

public class TimelinePage extends BaseClass{
	private By SelectProject  = By.xpath("//flt-semantics[@aria-label='Timeline']");
	private By SelectTask  = By.xpath("//flt-semantics[@aria-label='Validate time Entry']");
	private By AddBtn  = By.xpath("//flt-semantics[@aria-label='ADD']");
	private By Savebtn  = By.xpath("//flt-semantics[@aria-label='SAVE']");
	
	public void Select_Project() throws InterruptedException {
        WebElement Project = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SelectProject));
        Thread.sleep(1000);
        Project.click();
    }
	public void Select_Task() throws InterruptedException {
        WebElement Task = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(SelectTask));
        Thread.sleep(1000);
        Task.click();
    }
	public void Click_On_AddBtn() throws InterruptedException {
        WebElement add = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(AddBtn));
        Thread.sleep(1000);
        add.click();
    }
	public void Click_on_save_button() throws InterruptedException {
        WebElement save = BaseClass.wait.until(ExpectedConditions.visibilityOfElementLocated(Savebtn));
        Thread.sleep(1000);
        save.click();
    }
	public void Select_Date(String Date) throws InterruptedException {
		Thread.sleep(1000);
        // Select Date
        String[] dateParts = Date.split(" ");
        String day = dateParts[0];         // "20"
        String month = dateParts[1];       // "November"
        String year = dateParts[2];        // "2024"

        // Call your custom calendar selection method
        date.selectDateOntimeline(day, month, year);
        Thread.sleep(2000);
        
    }
	public void Select_Time(String time1) throws InterruptedException {
		Thread.sleep(1000);
        // Select Date
        String[] dateParts = time1.split(" ");
        String Fhr = dateParts[0];         // "20"
        String Fmin = dateParts[1];       // "November"
        String FamPm = dateParts[2];        // "2024"
        String Thr = dateParts[3];         // "20"
        String Tmin = dateParts[4];       // "November"
        String TamPm = dateParts[5];        // "2024"

        // Call your custom calendar selection method
        time.selectTime(Fhr,Fmin,FamPm,Thr,Tmin,TamPm);
        
    }
public void Validate_TimeEntry() throws InterruptedException {
        
    }
	
	

}
