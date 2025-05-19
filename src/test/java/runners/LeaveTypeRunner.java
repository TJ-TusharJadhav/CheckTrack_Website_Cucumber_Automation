package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/LeaveTypes.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/LeaveTypes_reports.html"}
       ,tags = "@ashygdf"
		)
public class LeaveTypeRunner extends AbstractTestNGCucumberTests{

}
