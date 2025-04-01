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
import pages.LoginPage;
import utility.ScreenRecorderUtil;

public class Hooks {

    private WebDriver driver;
    LoginPage login = new LoginPage();

    @Before
    public void setup(Scenario scenario) throws Exception {
        BaseClass.initializeDriver();
        driver = BaseClass.getDriver(); // Get WebDriver instance
        
        // Get the scenario name for recording
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        ScreenRecorderUtil.startRecord(scenarioName);  // Start recording with scenario name

//        login.Valid_login(); // Perform login
    }

    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(1000);
        ScreenRecorderUtil.stopRecord();
        
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
