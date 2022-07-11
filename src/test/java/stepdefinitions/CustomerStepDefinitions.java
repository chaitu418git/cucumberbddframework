package stepdefinitions;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import domainobjects.BillingDetails;
import io.cucumber.java.en.And;

public class CustomerStepDefinitions {
private final WebDriver driver;
private final TestContext context;

public CustomerStepDefinitions(TestContext context)
{
	this.context=context;
	driver=context.driver;
}
@And("my billing details are")
public void my_billing_details_are(BillingDetails billingDetails) {
	//this.billingDetails=billingDetails;
	context.billingDetails=billingDetails;
}
}
