package testDelePack;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComMethods {
	public static WebDriverWait wait;
	public static WebDriver driver;
	public void load(WebDriver driver,String url)
	{
		driver.get(url);
	}
	public static boolean switchToRightChildWindow(WebDriver driver, String windowTitle)
	{
		try {
			Set<String> handles = driver.getWindowHandles();
			List<String> hList=new ArrayList<>(handles);
			 for(String e:hList)
			 {
				 String title=driver.switchTo().window(e).getTitle();
				 if(title.contains(windowTitle))
				 {
					 System.out.println("Found the right Window");
					 return true;
				 }
			 }
		}
		catch (NoSuchWindowException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//SwitchToParentWindow
	public void switchToParentWidnow(WebDriver driver, String parentId)
	{
		//load(url);
		//String parentId=driver.getWindowHandle();
		driver.switchTo().window(parentId);
	}
public String getParentId(WebDriver driver)
{
	return driver.getWindowHandle();
}
public void clickByJs(WebDriver driver,By elementTobeClicked)
{
	try {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(elementTobeClicked));
		Actions actObj=new Actions(driver);
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(elementTobeClicked));
		actObj.doubleClick(driver.findElement(elementTobeClicked)).build().perform();
	} 
	catch (NoSuchElementException noElement) {
		System.out.println("Element " + elementTobeClicked + " was not found in DOM "+ noElement.getStackTrace());
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
}
public void verifySortingASC(WebDriverWait wait,WebDriver driver, By locator) {
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	ArrayList<String> list=new ArrayList<>();
	List<WebElement> listofValues = driver.findElements(locator);
	for(WebElement value:listofValues)
	{
		list.add(value.getText());
	}
	System.out.println(list);
	ArrayList<String> tempList=new ArrayList<>();
	tempList.addAll(list);
	Collections.sort(tempList);
	System.out.println(tempList);
	Assert.assertEquals(list, tempList);
	System.out.println("Matched");
}
}
