package factory;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExcception {
public WebDriver driver;
	public static void main(String[] args) {
		try {
			int num=10/2;
			System.out.println(num);
		} catch (Exception e) {
			System.out.println(e.getMessage()+e.getLocalizedMessage());
			e.printStackTrace();
			System.out.println(e.getStackTrace());
		}



	}
	

}
