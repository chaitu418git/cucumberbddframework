package hooks;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import context.TestContext;
import factory.DriverFactory;
import factory.SendEmail;
import factory.SendEmail1;
import factory.SendMailSSLWithAttachment;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import owner.Ownerclass;

import org.apache.commons.mail.*;
public class MyHooks {
private WebDriver driver;
private final TestContext context;

public MyHooks(TestContext context)
{
	this.context=context;
}
@Before
public void before(Scenario scenario)
{
	System.out.println("BEFORE: THREAD ID : "+Thread.currentThread().getId()+","+"SCENARIO NAME: "+scenario.getName());
driver=DriverFactory.initializeDriver(Ownerclass.configLoader().browser());
context.driver=driver;
}
@After
public void after(Scenario scenario)
{
	System.out.println("AFTER: THREAD ID : "+Thread.currentThread().getId()+","+"SCENARIO NAME: "+scenario.getName());
	if(scenario.isFailed())
	{
		//Take a Screenshot
		final byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		//embed it in the report
		scenario.attach(screenshot, "image/png", ""+scenario.getName()+"");
	}
driver.quit();
}

  @AfterAll public  static void afterAll() throws EmailException 
  {
	  new SendEmail1().sendEmail();
	  
  }
  
//  @BeforeAll public static void beforeAll() {
//  
//  }
 
}
