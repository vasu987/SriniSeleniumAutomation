package com.servicedesk.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateCloseTask extends MainServiceDesk{
	static String url="https://waynecounty-uat.saasit.com";
@Test
	public static void CreatingAndClosingTask() throws Exception {
	

// setUp("firefox");
 Thread.sleep(5000L);
setUp("firefox");
CreateCloseTask();
tearDown();

	
}

}



