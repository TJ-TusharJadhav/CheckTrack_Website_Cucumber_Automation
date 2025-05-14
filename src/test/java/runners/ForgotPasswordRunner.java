package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/Forgot_password.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/Forgot_Password-reports.html"}
//       ,tags = "@tag1"
		)

public class ForgotPasswordRunner extends AbstractTestNGCucumberTests{

}
