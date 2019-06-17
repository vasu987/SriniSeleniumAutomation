package com.skg.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.servicedesk.com.MainServiceDesk;

public class BasicTest2 extends MainServiceDesk {
	static String url="https://waynecounty-uat.saasit.com";
	protected static WebDriverWait wait;
	protected static WebDriver driver;

@Test
	public static void SDTckt1() throws Exception {
		
  setUp("chrome");
	verifyUrl(url);
	ReportIssue();
	
	


	
	


	}

}
