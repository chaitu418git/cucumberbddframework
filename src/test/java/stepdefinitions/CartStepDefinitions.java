package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import context.TestContext;
import domainobjects.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.PageFactoryManager;

public class CartStepDefinitions {
//private WebDriver driver;
private CartPage cartPage;
	public CartStepDefinitions(TestContext context) {
	//driver=context.driver;
	cartPage=PageFactoryManager.getCartPage(context.driver);
	}

	@Then("I should see {int} {product} in the cart")
	public void i_should_see_in_the_cart(int quantity, Product product) {
	   // Write code here that turns the phrase above into concrete actions
	 // String actualProductName=new CartPage(driver).getProductName();
	  //String actualQuantity=new CartPage(driver).getProductQuantity();	
	  Assert.assertEquals(product.getName(), cartPage.getProductName());
	  Assert.assertEquals(quantity, Integer.parseInt(cartPage.getProductQuantity()));
	}
	@And("I'm on the Checkout page")
	public void i_m_on_the_checkout_page() {
		cartPage.checkout();
	}
}
