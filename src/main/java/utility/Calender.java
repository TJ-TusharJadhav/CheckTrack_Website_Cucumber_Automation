package utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class Calender extends BaseClass {

    // Constructor
//    public Calender(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }

    public void selectDate(String exDay, String exMonth, String exYear) throws InterruptedException {
        int expectedYear = Integer.parseInt(exYear);
        String expectedMonth = exMonth;

        By nextButton = By.xpath("(//flt-semantics[@role='button'])[2]");
        By prevButton = By.xpath("(//flt-semantics[@role='button'])[1]");

        String displayedMonthYear = driver.findElement(By.xpath("(//flt-semantics[@role='text'])[1]")).getDomAttribute("aria-label");
        String[] parts = displayedMonthYear.split(","); 
        String[] monthDay = parts[2].trim().split(" "); 
        String displayedMonth = monthDay[0]; 
        int displayedYear = Integer.parseInt(parts[3].trim()); 

        while (!(displayedMonth.equalsIgnoreCase(expectedMonth) && displayedYear == expectedYear)) {
            if (displayedYear < expectedYear || (displayedYear == expectedYear && isMonthBefore(displayedMonth, expectedMonth))) {
                wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(prevButton)).click();
            }

            new Actions(driver).moveByOffset(0, 0).perform();
            Thread.sleep(1000); // UI delay

            // Refresh after click
            displayedMonthYear = driver.findElement(By.xpath("(//flt-semantics[@role='text'])[1]")).getDomAttribute("aria-label");
            parts = displayedMonthYear.split(","); 
            monthDay = parts[2].trim().split(" ");
            displayedMonth = monthDay[0];
            displayedYear = Integer.parseInt(parts[3].trim());

            System.out.println("Updated Month-Year: " + displayedMonth + " " + displayedYear);
        }

        // Select day after matching year and month
        String expectedDateXPath = String.format("//flt-semantics[@aria-label='%s, %s, %s %s, %s']",
                exDay,
                getDayOfWeek(exDay, exMonth, exYear),
                exMonth,
                exDay,
                exYear);

        System.out.println("Clicking on: " + expectedDateXPath);

        try {
            WebElement dateElement = driver.findElement(By.xpath(expectedDateXPath));
            dateElement.click();
        } catch (Exception e) {
            System.out.println("Date not found: " + e.getMessage());
        }
    }

    // Compare if current month is before target month
    private boolean isMonthBefore(String currentMonth, String targetMonth) {
        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
            int currentIndex = LocalDate.parse("01 " + currentMonth + " 2000", DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)).getMonthValue();
            int targetIndex = LocalDate.parse("01 " + targetMonth + " 2000", DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)).getMonthValue();
            return currentIndex < targetIndex;
        } catch (Exception e) {
            System.out.println("Month comparison failed: " + e.getMessage());
            return false;
        }
    }

    // Get day of week for a given date
    public static String getDayOfWeek(String day, String month, String year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(day + " " + month + " " + year, formatter);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.toString().substring(0, 1) + dayOfWeek.toString().substring(1).toLowerCase();
    }
    
    public void selectDateOntimeline(String exDay, String exMonth, String exYear) throws InterruptedException {
        int expectedYear = Integer.parseInt(exYear);
        String expectedMonth = exMonth;

        
        By nextButton = By.xpath("(//flt-semantics[@role='button'])[4]");
        By prevButton = By.xpath("(//flt-semantics[@role='button'])[3]");

        String displayedMonthYear = driver.findElement(By.xpath("(//flt-semantics[@role='text'])[7]")).getDomAttribute("aria-label"); System.out.println("displayedMonthYear: " + displayedMonthYear);
        String[] parts = displayedMonthYear.split(","); 
        String[] monthDay = parts[2].trim().split(" "); 
        String displayedMonth = monthDay[0]; 
        int displayedYear = Integer.parseInt(parts[3].trim()); 

        while (!(displayedMonth.equalsIgnoreCase(expectedMonth) && displayedYear == expectedYear)) {
            if (displayedYear < expectedYear || (displayedYear == expectedYear && isMonthBefore(displayedMonth, expectedMonth))) {
                wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
            } else {
                wait.until(ExpectedConditions.elementToBeClickable(prevButton)).click();
            }

            new Actions(driver).moveByOffset(0, 0).perform();
            Thread.sleep(1000); // UI delay

            // Refresh after click
            displayedMonthYear = driver.findElement(By.xpath("(//flt-semantics[@role='text'])[7]")).getDomAttribute("aria-label");
            parts = displayedMonthYear.split(","); 
            monthDay = parts[2].trim().split(" ");
            displayedMonth = monthDay[0];
            displayedYear = Integer.parseInt(parts[3].trim());

            System.out.println("Updated Month-Year: " + displayedMonth + " " + displayedYear);
        }

        // Select day after matching year and month
        String expectedDateXPath = String.format("//flt-semantics[@aria-label='%s, %s, %s %s, %s']",
                exDay,
                getDayOfWeek(exDay, exMonth, exYear),
                exMonth,
                exDay,
                exYear);

        System.out.println("Clicking on: " + expectedDateXPath);

        try {
            WebElement dateElement = driver.findElement(By.xpath(expectedDateXPath));
            dateElement.click();
        } catch (Exception e) {
            System.out.println("Date not found: " + e.getMessage());
        }
    }
    
    
}
