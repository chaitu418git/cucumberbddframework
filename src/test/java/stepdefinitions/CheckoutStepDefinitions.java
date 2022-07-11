package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import context.TestContext;
import domainobjects.BillingDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckOutPage;
import pages.PageFactoryManager;

public class CheckoutStepDefinitions {
//private final WebDriver driver;
private final TestContext context;
private CheckOutPage checkoutPage;
	public CheckoutStepDefinitions(TestContext context)
	{
		this.context=context;
		//driver=context.driver;
		checkoutPage=PageFactoryManager.getCheckoutPage(context.driver);
	}
	
	
	@When("I provide billing details")
	public void i_provide_billing_details() {
	checkoutPage.setBillingDetails(context.billingDetails);
	}
	@When("I place an order")
	public void i_place_an_order() throws InterruptedException {
	//new CheckOutPage(driver).placeOrder();
		checkoutPage.placeOrder();
	}

	@Then("the order should be placed successfully")
	public void the_order_should_be_placed_successfully() {
		Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNotice());
	}
}
