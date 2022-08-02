package pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
private static StorePage storePage;
private static CartPage cartPage;
private static CheckOutPage checkoutPage;
public static StorePage getStorePage(WebDriver driver)
{
	//Initially storePage object will be null and StorePage object will be created and it 
	//will hold that value as we have static keyword. So next time when program will come here 
	//it will be request for page and this time it will not be null and it will return the storepage object
	return storePage == null ? new StorePage(driver) : storePage;//Ternary Operator(just like if-else stmnt)
	
}
public static CartPage getCartPage(WebDriver driver)
{
	return cartPage == null ? new CartPage(driver) : cartPage;
}
public static CheckOutPage getCheckoutPage(WebDriver driver)
{
	return checkoutPage == null ? new CheckOutPage(driver) : checkoutPage;
}
}
