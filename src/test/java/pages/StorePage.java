package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{

	@FindBy(xpath = "//a[@title='View cart']")
	public WebElement text1;
	 By viewCartLink=By.xpath("//a[@title='View cart']");
	 //WebElement text=driver.findElement(viewCartLink);
	
	public StorePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void addToCart(String productName)
	{
		 By addToCartBtn=By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");
		 wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		 wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
		 
	}
	public void selectFieldValue()
	{
		//selectByVisibleText(text1, "");
	}

}
