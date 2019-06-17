package com.skg.basic;

import java.util.Stack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.ProfilesIni;

public class BrowserSetup {
	static WebDriver driver;
	public static void setUpBrowser(String browser) throws Exception
	{

	    switch(browser)
	    {
	    case "chrome":

	        // Write the code here for open chrome browser
	    	 System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
	    	 
	    	 ChromeOptions options = new ChromeOptions();
	    	 options.addArguments("start-maximized");
	    	 options.addArguments("disable-infobars");
	    	 
	    	driver = new ChromeDriver();
	     	break;
	    	
	    case "firefox":
	    	
	        // Write the code here for open firefox browser
//	    	ProfilesIni profile = new ProfilesIni();
//	    	FirefoxProfile myprofile = profile.getProfile("default");
//	    	myprofile.setAcceptUntrustedCertificates(true);
//	    	myprofile.setAssumeUntrustedCertificateIssuer(true);
	    	driver = new FirefoxDriver();
	    	
	    	break;
	    	
	    case "IE":
	    System.setProperty("webdriver.edge.driver", ".\\msedgedriver.exe");
	    //Initialize InternetExplorerDriver Instance.
	  driver = new EdgeDriver();
	   
	    default :
	        System.out.println("Browser choice not available");     

	    }
	}

}
