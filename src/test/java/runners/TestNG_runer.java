package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/OrganizationSetting.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
       ,tags = "@UpdateCompanyName"
		)

public class TestNG_runer extends AbstractTestNGCucumberTests{

}
