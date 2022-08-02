package runner;



import org.junit.runner.RunWith;

import domainobjects.BillingDetails;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
features = {".//Features/"},
        glue ={"stepdefinitions","hooks","customtype","domainobjects"},
        dryRun = false,
       monochrome = true,
     // plugin =  {"pretty","html:test-output"},
//plugin = {"json:target/cucumber.json","pretty","html:target/cucumber-report/cucumber.html","summary"},
//snippets = CAMELCASE,

tags = "@guest"
)
public class JUnitRunnerTest {

}
