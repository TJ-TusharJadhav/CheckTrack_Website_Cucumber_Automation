package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

public class BaseClass {
	protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static LoginPage loginPage;

    public static void initializeDriver() {
        if (driver == null) { 
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            
            driver.get("https://app.checktrack.dev/#/login");
            
            loginPage = new LoginPage();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Avoid memory leaks
            wait = null;    // Reset WebDriverWait
        }
        
       
    }
}