package utility;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class Timemethod extends BaseClass{
	
	 LocalTime now = LocalTime.now();
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
	    
	     String formattedTime = now.format(formatter);
	     String[] timeParts = formattedTime.split("[: ]");

	     String hour = timeParts[0];     // hh 
	     String minute = timeParts[1];   // mm
	     String ampm = timeParts[2];     // AM or PM

public void selectTime(String FromHr, String FromMin, String FromAmPm, String ToHr, String ToMin, String ToAmPm) throws InterruptedException {
       // FROM time
       WebElement FromHR = driver.findElement(By.xpath("//flt-semantics[contains(@aria-label,'FromTime') and contains(@aria-label,'" + hour + "')]"));
       FromHR.click();Thread.sleep(1000);
       WebElement FromHRE = driver.findElement(By.xpath("(//input[@aria-label='FromTime'])[1]"));
       FromHRE.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);Thread.sleep(1000);
       FromHRE.sendKeys(FromHr);Thread.sleep(1000);

       WebElement FromMinE = driver.findElement(By.xpath("(//input[@aria-label='FromTime'])[2]"));
       FromMinE.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);Thread.sleep(1000);
       FromMinE.sendKeys(FromMin);Thread.sleep(1000);

       WebElement FromAm = driver.findElement(By.xpath("(//flt-semantics[@aria-label='" + FromAmPm + "'])[1]"));
       FromAm.click();Thread.sleep(1000);

       // TO time
       WebElement ToHR = driver.findElement(By.xpath("//flt-semantics[contains(@aria-label,'ToTime') and contains(@aria-label,'" + hour + "')]"));
       js.executeScript("arguments[0].click();", ToHR);Thread.sleep(1000);

       WebElement ToHRE = driver.findElement(By.xpath("(//input[@data-semantics-role='text-field'])[2]"));
       ToHRE.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);Thread.sleep(1000);
       ToHRE.sendKeys(ToHr);Thread.sleep(1000);

       WebElement ToMinE = driver.findElement(By.xpath("(//input[@data-semantics-role='text-field'])[3]"));
       ToMinE.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);Thread.sleep(1000);
       ToMinE.sendKeys(ToMin);Thread.sleep(1000);

       WebElement ToAm = driver.findElement(By.xpath("(//flt-semantics[@aria-label='" + ToAmPm + "'])[2]"));
       ToAm.click();Thread.sleep(1000);
   }
  
   

}
