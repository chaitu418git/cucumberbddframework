package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
//waitInSeconds
public void waitInSeconds(int milliSeconds)
{
	try {
		Thread.sleep(milliSeconds);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	catch (Exception e) {
      e.printStackTrace();
	}
}

//Get Current Time Stamp
public String getCurrentDateInHHMMSSFormat()
{
	DateFormat DF=DateFormat.getDateTimeInstance();
	Date date=new Date();
	String DateValue=DF.format(date);
	return DateValue;
}
//Get CurrentDateInDDMMYYYY
public String getCurrentDateInDDMMYYYYFormat()
{
	Date date=new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	String strDate= formatter.format(date);
	return strDate;
}
//Get CurrentDateInMMDDYYYY
public String getCurrentDateInMMDDYYYYFormat()
{
	Date date=new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	String strDate= formatter.format(date);
	return strDate;
}

//select the dropdown using "select by visible text" ->This will work only for Select tag in HTML
public void selectByVisibleText(By selectlocator, String VisibleText){
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectlocator));
		Select selObj=new Select(driver.findElement(selectlocator));
		selObj.selectByVisibleText(VisibleText);
	    } 
	catch (NoSuchElementException noElement) 
	   {
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	   }
	catch (ElementNotSelectableException e) {
		e.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
		
	catch (Exception e) 
	   {
		e.printStackTrace();
	   }

}

//select the dropdown using "select by index" -> This will work only for Select tag in HTML
public void selectByIndex(By selectlocator, int IndexValue){
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectlocator));
		Select selObj=new Select(driver.findElement(selectlocator));
		selObj.selectByIndex(IndexValue);
	} catch (NoSuchElementException noElement) {
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
	catch (ElementNotSelectableException e) {
		e.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}

}

//select the dropdown using "select by value", so pass Value as ‘thirdcolor’
public void selectByValue(By selectlocator, String Value){
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(selectlocator));
		Select selObj=new Select(driver.findElement(selectlocator));
		selObj.selectByValue(Value);
	} catch (NoSuchElementException noElement) {
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
	catch (ElementNotSelectableException e) {
		e.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}

}

//Click Operation
public void clickOnWebElement(By elementTobeClicked)
{
	try {
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(elementTobeClicked));
		ele.click();
	} catch (NoSuchElementException noElement) {
		System.out.println("Element " + elementTobeClicked + " was not found in DOM "+ noElement.getStackTrace());
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
	catch (ElementNotVisibleException e) {
		e.printStackTrace();
	}
	catch (ElementClickInterceptedException e) {
		e.printStackTrace();
	}
	catch (ElementNotInteractableException e) {
		e.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	
}
//Click By Using Java Script
public void clickByJs(By elementTobeClicked)
{
	try {
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(elementTobeClicked));
			} 
	catch (NoSuchElementException noElement) {
		System.out.println("Element " + elementTobeClicked + " was not found in DOM "+ noElement.getStackTrace());
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
	catch (ElementNotVisibleException e) {
		e.printStackTrace();
	}
	catch (ElementClickInterceptedException e) {
		e.printStackTrace();
	}
	catch (ElementNotInteractableException e) {
		e.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}
}
//SendKeys Method
public void sendKeysOnWebElement(By locator, String textToBeEntered)
{
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.findElement(locator).click();
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(textToBeEntered);
	} catch (NoSuchElementException noElement) {
		System.out.println("Element " + locator + " was not found in DOM "+ noElement.getStackTrace());
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}
	
}
//Accept Alert
public void acceptAlert(WebDriver driver)
{
	try {
		wait.until(ExpectedConditions.alertIsPresent());
driver.switchTo().alert().accept();	
}
	catch (NoAlertPresentException noAlert) {
		System.out.println("No Alert present " +noAlert.getStackTrace());
		noAlert.printStackTrace();
	}
	catch (TimeoutException e) {
	System.out.println("WebDriver couldn’t locate the Alert");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
//Dismiss Alert
public void dismissAlert(WebDriver driver)
{
	try {
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().dismiss();
}
	catch (NoAlertPresentException noAlert) {
		noAlert.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
//MouseOver Method->It will mouse hover on element
public void MouseOver(By locator){
	try {
		Actions actObj=new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		actObj.moveToElement(driver.findElement(locator)).build().perform();
	} catch (NoSuchElementException noElement) {
		System.out.println("Element " + locator + " was not found in DOM "+ noElement.getStackTrace());
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
			}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}
	

}

//DoubleClick
public void doubleClick(By locator){
	try {
		Actions actObj=new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		actObj.moveToElement(driver.findElement(locator)).doubleClick(driver.findElement(locator)).build().perform();
	} catch (NoSuchElementException noElement) {
		System.out.println("Element " + locator + " was not found in DOM "+ noElement.getStackTrace());
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}

}
//DoubleClickWithJS
public void doubleClickWithJs(By locator)
{
	try {
		Actions actObj=new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
		actObj.moveToElement(driver.findElement(locator)).doubleClick(driver.findElement(locator)).build().perform();
	} catch (NoSuchElementException noElement) {
		System.out.println("Element " + locator + " was not found in DOM "+ noElement.getStackTrace());
		System.out.println(noElement.getMessage());
		noElement.printStackTrace();
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		e.printStackTrace();
	}

}
//DragAndDrop
public void dragAndDrop(By sourceElement, By destinationElement)
{
	try {
		Actions actObj=new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(sourceElement));
		wait.until(ExpectedConditions.presenceOfElementLocated(destinationElement));
		actObj.dragAndDrop(driver.findElement(sourceElement), driver.findElement(destinationElement)).build().perform();
		
	} 
	catch (StaleElementReferenceException e) {
		System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
				+ e.getStackTrace());
	}
	catch (NoSuchElementException e) {
		System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
	} 
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
		e.printStackTrace();
	}
}
//DragAndDropWithClickAndHold
public void dragAndDropByClickAndHold(By sourceElement, By destinationElement)
{
	try {
		Actions actObj=new Actions(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(sourceElement));
		wait.until(ExpectedConditions.presenceOfElementLocated(destinationElement));
		actObj.clickAndHold(driver.findElement(sourceElement))
		.moveToElement(driver.findElement(destinationElement))
		.release(driver.findElement(destinationElement))
		.build()
		.perform();
		
		
	} 
	catch (StaleElementReferenceException e) {
		System.out.println("Element with " + sourceElement + "or" + destinationElement + "is not attached to the page document "
				+ e.getStackTrace());
	}
	catch (NoSuchElementException e) {
		System.out.println("Element " + sourceElement + "or" + destinationElement + " was not found in DOM "+ e.getStackTrace());
	} 
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		System.out.println("Error occurred while performing drag and drop operation "+ e.getStackTrace());
		e.printStackTrace();
	}
}
//SwithtoFrameWithWebElement
public void switchToFrameByWebElement(By frameWebElement)
{
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(frameWebElement));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameWebElement));
driver.switchTo().frame(driver.findElement(frameWebElement));		
	} catch (NoSuchFrameException e) {
		System.out.println("Unable to locate frame with element " + frameWebElement + e.getStackTrace());
	}
	catch (StaleElementReferenceException e) {
		System.out.println("Element with " + frameWebElement + "is not attached to the page document" + e.getStackTrace());
	}
	catch (TimeoutException e) {
		System.out.println("WebDriver couldn’t locate the element");
		}
	catch (WebDriverException e) {
		e.printStackTrace();
		}
	catch (Exception e) {
		System.out.println("Unable to navigate to frame with element " + frameWebElement + e.getStackTrace());
	}
}

//SiwtchToAParticluarWindow
public boolean switchToRightChildWindow(String windowTitle)
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
public void switchToParentWidnow(String parentId)
{
	try {
		driver.switchTo().window(parentId);
	} catch (NoSuchWindowException e) {
		e.printStackTrace();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

public String getParentId()
{
return driver.getWindowHandle();
}
public void getPageTitle()
{
	 try {
		 driver.getTitle();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void getCurrenturl()
{
	try {
		driver.getCurrentUrl();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
