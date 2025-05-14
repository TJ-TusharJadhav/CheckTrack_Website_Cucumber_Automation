package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/TimelineSteps.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/TimelineSteps_reports.html"}
//       ,tags = "@Valid"
		)
public class TimelineRunner extends AbstractTestNGCucumberTests{

}
