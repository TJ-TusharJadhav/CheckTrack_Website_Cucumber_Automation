package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failed_scenarios.txt", 
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports-failed.html"}
)

public class FailedTestRunner  extends AbstractTestNGCucumberTests {

}
