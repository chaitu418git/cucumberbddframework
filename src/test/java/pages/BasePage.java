package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
public WebDriver driver;
public WebDriverWait wait;

public BasePage(WebDriver driver)
{
	this.driver=driver;
	wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	//As we are using Pagefactory to define the ui elements, we need to initialize those ui elements, so for that below stmnt
	PageFactory.initElements(driver, this);//Here this represents the current class
}
public void load(String url)
{
	driver.get(url);
}
}
