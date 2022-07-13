package stepdefinitions;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import domainobjects.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import owner.Ownerclass;
import pages.PageFactoryManager;
import pages.StorePage;

public class StoreStepDefinitions {
	//private WebDriver driver;
	private StorePage storePage;
	public StoreStepDefinitions(TestContext context)
	{
		//driver=context.driver;
		storePage=PageFactoryManager.getStorePage(context.driver);
	}
	@Given("I'm on Store Page")
	public void i_m_on_store_page() {
		//driver=DriverFactory.getDriver();
		storePage.load(Ownerclass.configLoader().baseUrl());
	}
	@When("I add a {product} to the cart")
	public void i_add_a_to_the_cart(Product product) throws InterruptedException {
		System.out.println(product.getName());
	storePage.addToCart(product.getName());
	}
	@And("I have a product in the cart")
	public void i_have_a_product_in_the_cart() throws InterruptedException {
	storePage.addToCart("Blue Shoes1");
	}

}
