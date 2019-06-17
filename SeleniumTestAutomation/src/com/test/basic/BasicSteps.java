package com.test.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BasicSteps {
	static String url="https://www.waynecounty.com";
@Test
	public static void test1() throws Exception {
	
	System.setProperty("webdriver.gecko.driver",".\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get(url + "/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  Thread.sleep(5000L);
	  driver.quit();
		
	}

}
