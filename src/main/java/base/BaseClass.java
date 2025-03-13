package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static void initializeDriver() {
        if (driver == null) {  // Prevent multiple driver instances
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.get("https://app.checktrack.dev/#/login");
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
