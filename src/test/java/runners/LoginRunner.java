package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/Login.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/Login-reports.html"}
//       ,tags = "@otherlinks2"
		)

public class LoginRunner extends AbstractTestNGCucumberTests{

}
