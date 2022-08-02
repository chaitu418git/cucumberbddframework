package testDelePack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Sorting {
	public static WebDriver driver;

public void sortTest()
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
	Select select=new Select(driver.findElement(By.id("tools")));
	ArrayList<String> list=new ArrayList<>();
	List<WebElement> allOptions = select.getOptions();
	for(WebElement option:allOptions)
	{
		list.add(option.getText());
	}
	System.out.println(list);
	ArrayList<String> tempList=new ArrayList<>();
	tempList.addAll(list);
	Collections.sort(tempList,Collections.reverseOrder());
	System.out.println(tempList);
	Assert.assertEquals(list, tempList);
	System.out.println("done");
}
}
