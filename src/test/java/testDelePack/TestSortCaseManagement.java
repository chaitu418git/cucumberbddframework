package testDelePack;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSortCaseManagement extends ComMethods {
	public static WebDriver driver;
	public static WebDriverWait wait;
@Test
public void testSort() throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://edockets.stage.alncorp.com");
	Thread.sleep(5000);
	driver.findElement(By.id("jl-email-input")).click();
	driver.findElement(By.id("jl-email-input")).sendKeys("ppalle@alncorp.com");
	driver.findElement(By.id("loginFormInputPassword")).click();
	driver.findElement(By.id("loginFormInputPassword")).sendKeys("P@ssw0rdS");
	driver.findElement(By.name("button")).click();
	//Thread.sleep(15000);
	//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//*[local-name()='svg']/*[local-name()='circle']"))));
	
	
	new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Create']")));
	new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Create']")));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[text()='Create']")));
	//driver.findElement(By.xpath("//div[@class='select']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Case']")).click();
	Thread.sleep(6000);
	//new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//mat-select[contains(@class,'mat-select-empty') and contains(@formcontrolname,'status')]"))));
	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//mat-select[@formcontrolname='status']/div/div[2]/div[@class='mat-select-arrow'])[1]")));
	System.out.println("Status Dropdown is displayed");
	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//mat-select[@formcontrolname='status']/div/div[2]/div[@class='mat-select-arrow'])[1]")));
	//clickByJs(driver, null)
	//JavascriptExecutor executor=(JavascriptExecutor)driver;
	//executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//mat-select[@formcontrolname='status']/div/div[2]/div[@class='mat-select-arrow'])[1]")));
	//Actions action=new Actions(driver);
	//action.moveToElement(null).click(null)
	//action.moveToElement(driver.findElement(By.xpath("(//mat-select[@formcontrolname='status'])[1]"))).click(driver.findElement(By.xpath("(//mat-select[@formcontrolname='status'])[1]"))).build().perform();
	//executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//mat-select[@formcontrolname='status']/div/div[2]/div[@class='mat-select-arrow'])[1]")));
	//driver.findElement(By.xpath("(//mat-select[@formcontrolname='status']/div/div[2]/div[@class='mat-select-arrow'])[1]")).click();
	driver.findElement(By.xpath("(//mat-select[@formcontrolname='status'])[1]")).click();
	System.out.println("clciked");
	//driver.findElement(By.xpath("//mat-select[@formcontrolname='status']")).click();
	//Thread.sleep(2000);
	//By allOptions=By.xpath("//span[@class='mat-option-text']");
	//verifySortingASC(new WebDriverWait(driver, Duration.ofSeconds(20)),driver,allOptions);
	new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mat-option-text']")));
	ArrayList<String> list=new ArrayList<>();
	List<WebElement> listofValues = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
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

@After
public void testTear()
{
	//driver.quit();
}
}
