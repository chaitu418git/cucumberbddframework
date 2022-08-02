package runner;



import org.junit.runner.RunWith;

import domainobjects.BillingDetails;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
features = {".//Features/"},
        glue ={"stepdefinitions","hooks","customtype","domainobjects"},
        dryRun = false,
       monochrome = true,
     // plugin =  {"pretty","html:test-output"},
plugin = {"message:target/cucumber-report/cucumber-report.json","pretty","html:target/cucumber-report/cucumber.html","summary"},
//snippets = CAMELCASE,
tags = "@guest"
)
public class JUnitRunnerTest {

}
