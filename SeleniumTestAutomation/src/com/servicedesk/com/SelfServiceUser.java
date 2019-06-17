package com.servicedesk.com;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.Test;

public class SelfServiceUser extends MainServiceDesk {
	static String url="https://waynecounty-uat.saasit.com";
@Test
	public static void ReportTechnologyIssue() throws Exception {
	

// setUp("firefox");
setUp("firefox");
//verifyUrl(url);
ReportIssue();
tearDown();

	
	
	


	
	

	
}

}
