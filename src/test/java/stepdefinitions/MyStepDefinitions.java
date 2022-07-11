package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import context.TestContext;
import domainobjects.BillingDetails;
import domainobjects.Product;
import factory.DriverFactory;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import owner.Ownerclass;
import pages.CartPage;
import pages.CheckOutPage;
import pages.PageFactoryManager;
import pages.StorePage;

public class MyStepDefinitions {
//private final WebDriver driver;
private BillingDetails billingDetails;
private StorePage storePage;
public MyStepDefinitions(TestContext context)
{
	//driver=context.driver;//pico container will make sure that this driver is specific to scenario. So there will be no conflicts
    storePage=PageFactoryManager.getStorePage(context.driver);
}

@Given("I'm a guest customer")
public void i_m_a_guest_customer() {
	//driver=DriverFactory.getDriver();
	//new StorePage(driver).load(Ownerclass.configLoader().baseUrl());
	storePage.load(Ownerclass.configLoader().baseUrl());
}

}