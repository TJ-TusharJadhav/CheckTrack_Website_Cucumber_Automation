package hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup() {
        BaseClass.initializeDriver();
        driver = BaseClass.getDriver(); // Get WebDriver instance
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }
        BaseClass.closeDriver();
    }

    public void takeScreenshot(Scenario scenario) {
        try {
            // Generate a timestamp for unique filenames
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Capture the screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create the filename with the scenario name
            String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".png";
            String filePath = "./screenshots/" + screenshotName;

            // Save the screenshot
            FileUtils.copyFile(srcFile, new File(filePath));

            System.out.println("Screenshot saved: " + filePath);
            
            // Embed screenshot in the Cucumber report
            byte[] screenshot = FileUtils.readFileToByteArray(srcFile);
            scenario.attach(screenshot, "image/png", scenario.getName());
            
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
