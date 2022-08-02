package testDelePack;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingTest extends ComMethods{
	public static WebDriver driver;
	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		load(driver,"https://opensource-demo.orangehrmlive.com/");
		String parentId=getParentId(driver);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		if(switchToRightChildWindow(driver,"OrangeHRM - World's Most Popular Opensource HRIS - Home | Facebook"))
		{
			System.out.println(driver.getCurrentUrl() + driver.getTitle());
		}
		switchToParentWidnow(driver,parentId);

	}
}
