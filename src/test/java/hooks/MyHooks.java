package hooks;

import org.openqa.selenium.WebDriver;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import owner.Ownerclass;

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
driver.quit();
}

}
