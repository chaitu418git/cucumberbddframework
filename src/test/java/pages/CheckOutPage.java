package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import domainobjects.BillingDetails;

public class CheckOutPage extends BasePage{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	By billingFirstNameFld=By.id("billing_first_name");
	By billingLastNameFld=By.id("billing_last_name");
	By billingAddressOneFld=By.id("billing_address_1");
	By billingCityFld=By.id("billing_city");
	By billingStateDropDown=By.id("billing_state");
	By billingZipFld=By.id("billing_postcode");
	By billingEmailFld=By.id("billing_email");
	By placeOrderBtn=By.id("place_order");
	By noticetxt=By.xpath("//p[text()='Thank you. Your order has been received.']");
	
	public CheckOutPage enterBillingFirstName(String billingFirstName)
	{
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(billingFirstNameFld));
		ele.clear();
		ele.sendKeys(billingFirstName);
		return this;
	}
	public CheckOutPage enterBillingLastName(String billingLastName)
	{
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(billingLastNameFld));
		ele.clear();
		ele.sendKeys(billingLastName);
		return this;
	}
	public CheckOutPage enterBillingAddressOne(String billingAddressOne)
	{
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddressOneFld));
		ele.clear();
		ele.sendKeys(billingAddressOne);
		return this;
	}
	public CheckOutPage enterBillingCity(String billingCity)
	{
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(billingCityFld));
		ele.clear();
		ele.sendKeys(billingCity);
		return this;
	}
	public CheckOutPage selectBillingState(String billingStateName)
	{
		Select select=new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(billingStateDropDown)));
		select.selectByVisibleText(billingStateName);
		return this;
	}
	public CheckOutPage enterBillingZip(String billingZip)
	{
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(billingZipFld));
		ele.clear();
		ele.sendKeys(billingZip);
		return this;
	}
	public CheckOutPage enterBillingEmail(String billingEmail)
	{
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(billingEmailFld));
		ele.clear();
		ele.sendKeys(billingEmail);
		return this;
	}
	public CheckOutPage setBillingDetails(BillingDetails billingDetails)
	{
		return enterBillingFirstName(billingDetails.getBillingFirstName()).
			   enterBillingLastName(billingDetails.getBillingLastName()).
		       enterBillingAddressOne(billingDetails.getBillingAddressOne()).
		       enterBillingCity(billingDetails.getBillingCity()).
		       selectBillingState(billingDetails.getBillingStateName()).
		       enterBillingZip(billingDetails.getBillingZip()).
		       enterBillingEmail(billingDetails.getBillingEmail());
	}
	public CheckOutPage placeOrder()
	{
		wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
		return this;
	}
	public String getNotice()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(noticetxt)).getText();
	}

}
