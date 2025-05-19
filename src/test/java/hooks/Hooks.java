package hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ScreenRecorderUtil;

public class Hooks extends BaseClass{

    @Before
    public void setup(Scenario scenario) throws Exception {
        initializeDriver();
        
     // Get the scenario name for recording
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        ScreenRecorderUtil.startRecord(scenarioName); 
        
        driver = getDriver(); // Get WebDriver instance
        
       
    }

    @After
    public void teardown(Scenario scenario) throws Exception {
        Thread.sleep(1000);
        ScreenRecorderUtil.stopRecord();
        
        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        } else {
            // Delete the recording if the scenario passed
            deleteLastRecordedVideo();
        }

        BaseClass.closeDriver();
    }

    private void deleteLastRecordedVideo() {
        try {
            String lastVideoPath = ScreenRecorderUtil.getLastRecordedFilePath();
            if (lastVideoPath != null) {
                File videoFile = new File(lastVideoPath);
                if (videoFile.exists()) {
                    videoFile.delete();
                    System.out.println("Deleted video file for passed test case: " + lastVideoPath);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to delete video file: " + e.getMessage());
        }
        
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
    
}}
