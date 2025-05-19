package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/OrganizationSetting.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/OrganizationSetting-reports.html"}
       ,tags = "@Timezone123asd"
		)
public class OrganizationSettingRunner extends AbstractTestNGCucumberTests{

}
