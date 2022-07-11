package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	By productNameFld=By.xpath("//td[@class='product-name']/a");
	By productQuantityFld=By.xpath("//input[@type='number']");
	By proceedToCheckoutBtn=By.xpath("//div[@class='wc-proceed-to-checkout']/a");
	
	public String getProductName()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productNameFld)).getText();
	}
	public String getProductQuantity()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productQuantityFld)).getAttribute("value");
		
	}
	public void checkout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
	}

}
