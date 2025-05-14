package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features/Reimbursement.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty", "html:target/Reimbursement_reports.html"}
//       ,tags = "@empty_both"
		)
public class ReimbursementRunner extends AbstractTestNGCucumberTests{

}
