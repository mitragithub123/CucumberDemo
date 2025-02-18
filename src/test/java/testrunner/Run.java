package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features={".\\Feature\\Customer.feature", ".\\Feature\\Login.feature"},
    glue="stepdefinations",
    dryRun=false,
    publish=true,
    tags="@smoke",
    monochrome=true,//To make console output readable.
    		plugin = {
                    "pretty",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
            }
)
public class Run {
    
}

/*---------- Plugin ----------*/
//plugin= {"pretty", "json:target/cucumber-reports/report_json.json"}
//plugin= {"pretty", "junit:target/cucumber-reports/report_xml.xml"}

/*---------- Tag ----------*/
//tags="@sanity"
//tags="@smoke"
//tags="@smoke or @sanity"
//tags="@smoke and @sanity"
//tags="@smoke and not @sanity"

/*---------- Feature ----------*/
//features={".\\Feature\\Customer.feature", ".\\Feature\\Login.feature"},-->2 files
//features=".\\Feature\\",-->Entire feature folder