package com.servicedesk.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.ClickElement;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class MainServiceDesk  {
	protected static WebDriver driver;
	protected static JavascriptExecutor js;
	protected static WebElement element;
	protected static String a,b,c;
	protected static String baseUrl;
	protected static String fuelStationName= " ";
	protected static Boolean isPresent;
	protected static String location=" ";
	protected static String actualLocation=" ";
	protected static int j;
	protected static int rowCount;
	protected static int noOfColumns;
	protected static String[] Headers;
	protected static Actions action;
	protected static StringSelection ss;
	protected static Dimension d;
	protected static WebDriverWait wait;
	protected static Select bldg;
	protected static String Pass=" ";
	protected static String ServiceRequestSearchFrame="ext-gen77";
	protected static String ServiceRequestFrame="ext-gen72";
	protected static String ServiceIncidentFrame="ext-gen97";
	protected static String Superuser="Nevena Malbasic";
	protected static String user="Srinivas Nukala";
	protected static Robot robot;
	protected static String ModifiedNotes="Modified Notes Second Time in Self Service Screen";
	protected static String PriorityValue=" ";
	protected static String SuperUserPriority="2 - High";
	protected static String RegularUserPriority="3 - Normal";
	protected static String SuperUserEmailValue="nmalbasic@waynecounty.com";
	protected static String SuperUserPhonevalue="1-313-967-6647";
	protected static String RegularUserEmailValue="Snukala@waynecounty.com";
	protected static String RegularUserPhonevalue="1-313-967-1387";
	protected static String AddressValue="500 Griswold Detroit MI 48226";
	protected static int i=1;
	protected static String IncidentValue=" ";
	
	protected static String UserEmail="";
	protected static String UserPhone="";
	protected static String UserAddress="";
	protected  static String CustomerNameXpath="frsqa_fname='ProfileLink'";
	protected  static String CustomeraAdressXpath="frsqa_fname='WC_CustomerAddress'";
	protected static String Sub,Sub2,Sub3,Sub4,Sub5,Sub6,Sub7,Sub8,Sub9,Sub10;
	
	
	protected static List<WebElement> lst;
	static String baseUrl1="https://waynecounty-uat.saasit.com";
	static String SubmitButton="Submit";
	static String ServiceHomePage="/html/body/div[1]/div[1]/div/div/div[3]/div/div[2]/div/div[1]/div[1]/ul/li[1]/a[2]/em/span/span";
	static String ReportTechnologyIssue="//span[text()='Report a technology issue']";
	static Logger logger;
	protected static String url="https://waynecounty-uat.saasit.com/Login.aspx?NoDefaultProvider=True";	

public static void setUp(String browser) throws Exception
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
    	
//    	FirefoxOptions options1 = new FirefoxOptions();
//    	 options1.addArguments("start-maximized");
//    	 options1.addArguments("disable-infobars");
//    	options1.setCapability("marionette", true);
        	
        // Write the code here for open firefox browser
    	
//    	  FirefoxOptions caps =  new FirefoxOptions().setProfile(new FirefoxProfile());
//    	  driver = new FirefoxDriver(caps);
  	 System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
     
//    	ProfilesIni profile = new ProfilesIni();
//    	  
//    	FirefoxProfile myprofile = profile.getProfile("default");
//    	myprofile.setAcceptUntrustedCertificates(true);
//    	myprofile.setAssumeUntrustedCertificateIssuer(true);
    	driver = new FirefoxDriver();
    	    	
    	break;
    	
    case "IE":
    System.setProperty("webdriver.edge.driver", ".\\msedgedriver.exe");
    //Initialize InternetExplorerDriver Instance.
  driver = new EdgeDriver();
   
    default :
        System.out.println("Browser choice not available");     

    }
    
	  driver.get(url);
	  Thread.sleep(2000L);
	  System.out.println("Entered URL");
		 serviceLogin();

    
    
}

public static void ValidateItems(String Clicks,String Item) throws Exception {
	
	System.out.println("*********************Validating : " + Item +"*******************************");

	Pass=Clicks;
	
	
	try {

	element=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
	
	  if(element.getText() != null){
	
		  System.out.println("******************************"+ element.getText() + " is Found************************************");
		  element.click();
		Thread.sleep(3000L);
		
	}
	}
	catch(ElementNotVisibleException te){
	
		System.out.println(element.getText() + " is not Found");
	}
	
}

public static void ValidateHomePage() throws Exception {
	System.out.println("*****************************Validating HomePage********************************************");
	element=driver.findElement(By.xpath(ServiceHomePage));
	
	  if(element.getText() != null){
	
		  System.out.println("******************************"+ element.getText() + "   is Present******************************************");
		  element.click();
		Thread.sleep(2000L);
		
	}
	else
	{
		System.out.println(element.getText() + "  is not Found");
	}


}

public static void NavigateToIWantToFrame(String FrameName) throws Exception {
	System.out.println("***************************Navigate to Frame: " + FrameName +"********************************");
	  driver.switchTo().frame(driver.findElement(By.id(FrameName)));
	    Thread.sleep(3000L);
   

}

public static void ClickReportTechnologyissue() throws Exception {
	element=driver.findElement(By.xpath("//span[contains(text(),'Report a technology issue')]"));
    element.click();
    Thread.sleep(3000L);
	
}

public static void SwitchToDefault() throws Exception {
	System.out.println("Switch to Default Home");
	      driver.switchTo().defaultContent();
    Thread.sleep(3000L);

}
public static void NavigateToReportTechnologyIssue() throws Exception {
	System.out.println("*********************************Switch to NavigateToReportTechnologyIssue Frame**********************************");
	 driver.switchTo().frame(driver.findElement(By.id("ext-gen77")));
	    Thread.sleep(3000L);

}



public static void ValidateNewTechnologyIssue() throws Exception {

	Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl1);
	
	
	element=driver.findElement(By.xpath("//input[@frsqa_fname='ProfileLink']"));
	System.out.println(element.getAttribute("value"));
	
    
    System.out.println("Building Name: ");
    
  
    element=driver.findElement(By.xpath("//input[@frsqa_fname='WC_BuildingPickList']"));
    element.sendKeys("14112 Woodward Ave.");
    Thread.sleep(1500L);
    element.sendKeys(Keys.TAB);
    Thread.sleep(1000L);
    
    element=driver.findElement(By.xpath("//div[@frsqa_fname='WC_BuildingAddress']"));
    Assert.assertEquals(element.getText(),"14112 Woodward Ave.   MI 48203");
   
    System.out.println(element.getText());
       
    System.out.println("Floor Number ");
   

    element=driver.findElement(By.xpath("//input[@frsqa_fname='WC_Floor']"));
	element.sendKeys("3'RD FLOOR");
	Thread.sleep(1500L);
	
	//Alernate Location
	 element=driver.findElement(By.xpath("//input[@frsqa_fname='WC_AlternateLocation']"));
		element.sendKeys("500 Grisworld Drive");
		Thread.sleep(1500L);
		   element.sendKeys(Keys.TAB);
		    Thread.sleep(1000L);
		
		//Alernate Phone
		
		 element=driver.findElement(By.xpath("//input[@frsqa_fname='WC_AlternatePhone']"));
		element.sendKeys("313-123-1234");
		Thread.sleep(1500L);
		 element.sendKeys(Keys.TAB);
		    Thread.sleep(1000L);
		
		
	
		
	//How to prefered to be conatcted
		
		 element=driver.findElement(By.xpath("//input[@frsqa_fname='WC_ContactMethod']"));
			element.sendKeys("Email");
			Thread.sleep(1500L);
			 element.sendKeys(Keys.TAB);
			    Thread.sleep(1000L);
	
	
	System.out.println("Asset Tag Name ");
	 element=driver.findElement(By.xpath("//input[@frsqa_fname='WC_AssetTag']"));
		element.sendKeys("H100023");
		Thread.sleep(1500L);
		 element.sendKeys(Keys.TAB);
		    Thread.sleep(1000L);
		
		 element=driver.findElement(By.xpath("//input[@frsqa_fname='Subject']"));
			element.sendKeys("PEOPLESOFT");
			Thread.sleep(1500L);
		    element.sendKeys(Keys.TAB);
		    Thread.sleep(1000L);
			
			 element=driver.findElement(By.xpath("//textarea[@frsqa_fname='Symptom']"));
				element.sendKeys("TEST ISSUE DESCRIPTION");
				Thread.sleep(1500L);
    element.sendKeys(Keys.TAB);
    Thread.sleep(1000L);
    
	 element=driver.findElement(By.xpath("//input[@name='file']"));

  
   action = new Actions(driver);
   action.moveToElement(element).click().build().perform();
   action.sendKeys(Keys.PAGE_DOWN).perform();
   Thread.sleep(4000L);
  
   
   EnterValueThroughMouseClicks("C:\\Srini\\ServiceTicket.txt");
//   StringSelection ss = new StringSelection("C:\\Srini\\ServiceTicket.txt");
//   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//
//   //imitate mouse events like ENTER, CTRL+C, CTRL+V
//   Robot robot = new Robot();
//   robot.keyPress(KeyEvent.VK_ENTER);
//   robot.keyRelease(KeyEvent.VK_ENTER);
//   robot.keyPress(KeyEvent.VK_CONTROL);
//   robot.keyPress(KeyEvent.VK_V);
//   robot.keyRelease(KeyEvent.VK_V);
//   robot.keyRelease(KeyEvent.VK_CONTROL);
//   robot.keyPress(KeyEvent.VK_ENTER);
//   robot.keyRelease(KeyEvent.VK_ENTER);
//   Thread.sleep(4000L);
	
	wait = new WebDriverWait(driver, 100);
	//element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen194")));
//    element.click();
//    Thread.sleep(2000L);
////    element=driver.findElement(By.id("ext-comp-1122"));
//     
////    element=driver.findElement(By.id("ext-gen100"));
	
	
//	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen194")));
//   element.click();
    
	driver.findElement(By.xpath("//button[contains(text(),'Save Incident')]")).click();
	Thread.sleep(7000L);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Back to My Items List')]"))).click();
	
    Thread.sleep(2000L);
    //Back to My Items List(button)
      
    
    element=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/p"));
   String IssueId1 =element.getText();
   
   System.out.println("ISSUE ID: " + IssueId1);
	
}
public static void ClickServiceDeskAnalyst() throws Exception {
	System.out.println("************************************************************************************************************************************************");
	System.out.println("Click Service Desk Analyst");
	
	driver.findElement(By.xpath("//div[contains(text(),'Service Desk Analyst')]")).click();
	Thread.sleep(2000L);
		
}
public static void ClickServiceService() throws Exception {
	System.out.println("************************************************************************************************************************************************");
	System.out.println("Click Service Desk Analyst");
	
	driver.findElement(By.xpath("//div[contains(text(),'Self Service User')]")).click();
	Thread.sleep(2000L);
		
}

public static void ClickIncidentButton() throws Exception {
	System.out.println("Click Incident Button");
	element=driver.findElement(By.xpath("//*[@id='ext-gen23']"));
	element.click();
	Thread.sleep(3500L);
	
}
public static void ClickNewIncident() throws Exception {
	System.out.println("Click New Incident Button");
	
	wait = new WebDriverWait(driver, 100);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen138")));
	element.click();
	Thread.sleep(3500L);
	
}

public static void ValidateUser(String priority) throws Exception {
	wait = new WebDriverWait(driver, 200);
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@frsqa_fname='ProfileLink']")));
	element.sendKeys(user);
	Thread.sleep(2500L);
	element.sendKeys(Keys.TAB);
    Thread.sleep(2500L);
	System.out.println("2.Validate Customer should be flagged as a VIP and the priority change to level 2- High");
	
	PriorityValue=driver.findElement(By.xpath("//input[@frsqa_fname='Priority']")).getAttribute("value");
	//PriorityValue=selenium.getValue("xpath=//input[@frsqa_fname='Priority']");
	Assert.assertEquals(PriorityValue,priority);
	
}
public static void ValidateCustomer(String user, String Priority,String uemail,String uphone,String uaddress,String verifyCustomer) throws Exception {
	
		Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl1);
		System.out.println("*****************************Verify " +verifyCustomer+  "Profile and Priority****************************");
		System.out.println("1.Enter Name in the customer field.");
		wait = new WebDriverWait(driver, 200);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@frsqa_fname='ProfileLink']")));
		element.clear();
		Thread.sleep(2500L);
		element.sendKeys(user);
		Thread.sleep(2500L);
		element.sendKeys(Keys.TAB);
	    Thread.sleep(2500L);
		System.out.println("2.Validate Customer Priority Values");
		
		PriorityValue=driver.findElement(By.xpath("//input[@frsqa_fname='Priority']")).getAttribute("value");
		//PriorityValue=selenium.getValue("xpath=//input[@frsqa_fname='Priority']");
		Assert.assertEquals(PriorityValue,Priority);
		System.out.println("3.Validate Customer Profile");
	
				
		
		
		System.out.println("4.Customer profile should include name, email address, phone number, and customer location (address)");
		element=driver.findElement(By.xpath("//div[contains(@frsqa_fname,'PrimaryEmail')]"));
		UserEmail=element.getText();
		Assert.assertEquals(UserEmail,uemail);
		
		element=driver.findElement(By.xpath("//div[contains(@frsqa_fname,'Phone1')]"));
		UserPhone=element.getText();
	//	Assert.assertEquals(UserPhone,uphone);
		
		element=driver.findElement(By.xpath("//div[contains(@frsqa_fname,'WC_CustomerAddress')]"));
		UserAddress=element.getText();
		Assert.assertEquals(UserAddress,uaddress);
		
		System.out.println("Successfully Validated " +verifyCustomer+  " Profile,Email,Phone and Address");
		Thread.sleep(1500L);
		
		//************************************Enter Owner Name******************************//
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@frsqa_fname='Owner']")));
		element.clear();
		RobotEnter();
		element.sendKeys(user);
		RobotEnter();
		RobotTab();
			
}

public static void VerifyDetailedService(String Service,String Category,String sub1,String sub2,String sub3,String sub4,String sub5,String sub6,String sub7,String sub8,String sub9,String sub10) throws Exception {
	System.out.println(" Choose  Service: " + Service);
	element = driver.findElement(By.xpath("//input[@frsqa_fname='Service']"));
	element.clear();
	Thread.sleep(1500L);
	element.sendKeys(Service);
	Thread.sleep(1500L);
	  element.sendKeys(Keys.TAB);
	    Thread.sleep(1500L);
	
	
	
	System.out.println("*****************Validate the Category for this Service****************");
	System.out.println("Validating Service:" +Service);
	element = driver.findElement(By.xpath("//input[@frsqa_fname='Category']"));
	element.clear();
	Thread.sleep(1500L);
	element.sendKeys(Category);
	Thread.sleep(1500L);
    element.sendKeys(Keys.TAB);
    Thread.sleep(1500L);
    
    System.out.println("*****************Validate the SubCategory for this Service****************");
    
           element = driver.findElement(By.xpath("//input[@frsqa_fname='Subcategory']"));
           
           if(!(sub1.equals(""))){
        	   	element.clear();
            	Thread.sleep(1500L);
            	element.sendKeys(sub1);
            	Thread.sleep(1500L);
            	 element.sendKeys(Keys.TAB);
        	   
           }
           
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub2);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub3);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub4);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub5);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub6);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub7);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub8);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub9);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }
           if(!(sub1.equals(""))){
       	   	element.clear();
           	Thread.sleep(1500L);
           	element.sendKeys(sub10);
           	Thread.sleep(1500L);
           	 element.sendKeys(Keys.TAB);
       	   
          }

	
}

public static void VerifyServices() throws Exception {
	
//	element=driver.findElement(By.cssSelector("div[frsqa_fname='Service']>span[class='x-form-twin-triggers']"));
//	element=driver.findElement(By.cssSelector("div[frsqa_fname='Service']>span[class='x-form-twin-triggers']"));
	
	//**************************************Validate All  Service,Category and SunCategory*************************************//
	System.out.println("********The category and subcategory list should appear based on the service that was selected*************");
//	VerifyDetailedService("Building Access Services","Guardian Building","Change","Disable","New","","","","","","","");
//	VerifyDetailedService("Building Access Services","400 Monroe","Change","Disable","New","","","","","","","");
//	VerifyDetailedService("Business Services","Procurement","New","","","","","","","","","");
//	VerifyDetailedService("Communications","Create Digital Media","New","","","","","","","","","");
//	VerifyDetailedService("Desktop Hardware Services","Desktop","Audio","BackUp ","Battery","BitLocker","BSOD","Cords/Connections","Hard Drive","Headsets","Keyboard","Memory");
//	VerifyDetailedService("Desktop Hardware Services","Laptop","Audio","BackUp ","Battery","BitLocker","BSOD","Cords/Connections/Adapters","Display","Docking Station","Hard Drive","Headsets");
//	VerifyDetailedService("Desktop Hardware Services","VOIP Phone","No Sound","Replace broken phone or phone cord","","","","","","","","");
	VerifyDetailedService("Desktop Software Services","Adobe","Acrobat (Full)","Creative Suites","Reader","Acrobat (Full)","Creative Suites","Reader","Acrobat (Full)","Creative Suites","Reader","Acrobat (Full)");

System.out.println("********Category and Subcategory list successfully apeared based on  the service that was selected*************");

	
}

public static void ChangeStatus() throws Exception {
	System.out.println("Change status from active to waiting for customer and click save and enter in notes Testing and your initials. Note your incident number.");
	element=driver.findElement(By.xpath("//input[@frsqa_fname='Status']"));
    element.clear();
    Thread.sleep(1000L);
    element.sendKeys("Waiting for Customer");
    Thread.sleep(1000L);
    RobotTab();
	
}


public static void SearchIncidentNumber(String iv) throws Exception {
	wait = new WebDriverWait(driver, 30);
	//element=driver.findElement(By.id("ext-comp-1106"));
	
		
	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1004")));
	element.sendKeys(iv);
	Thread.sleep(1000L);
	element.sendKeys(Keys.ENTER);
	Thread.sleep(2000L);
	
	 driver.findElement(By.linkText("SN2")).click();
	 Thread.sleep(3000L);
	 
	    driver.findElement(By.id("ext-comp-1125")).clear();
	    driver.findElement(By.id("ext-comp-1125")).sendKeys(ModifiedNotes);
	    Thread.sleep(2000L);
	    robot = new Robot();
	    robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_TAB);
	    
	    action = new Actions(driver);
	    action.moveToElement(driver.findElement(By.id("ext-gen203"))).click().build().perform();
	    action.sendKeys(Keys.PAGE_DOWN).perform();
	    Thread.sleep(3000L);
	 	
}

public static void setUp() throws Exception {
	String url="https://waynecounty-uat.saasit.com/Login.aspx?NoDefaultProvider=True";	
	System.setProperty("webdriver.gecko.driver",".\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get(url + "/");
	
	  System.out.println("test Url");
	  
	  driver.findElement(By.id("UserName")).sendKeys("snukala");
	  driver.findElement(By.id("Password")).sendKeys("Saibaba2005@");
	  driver.findElement(By.xpath("/html/body/div[4]/div/form/div[3]/button")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  Thread.sleep(5000L);
}
public static void CreateCloseTask() throws Exception {
	
	PrintStream out = new PrintStream(new FileOutputStream("C:\\Srini\\CreateCloseTaskDetails.txt"));
	System.setOut(out);
	
	ClickServiceDeskAnalyst();
	ValidateItems(SubmitButton,"Validate Submit Button");
	
	ClickIncidentButton();
	NavigateToIWantToFrame(ServiceIncidentFrame);
	//SearchServiceDeskRequest("23036");
	ClickNewIncident();
	ValidateCustomer(user,RegularUserPriority,RegularUserEmailValue,RegularUserPhonevalue,AddressValue,"Regular Customer");
	VerifyBuildingListFunction();
	VerifySummary();
	VerifyServices();
	VerifySaveWithSummaryandDesctiptionFirst("SN1","TEST1");
	CreateAttachment();
	VerifyTask();
	
}

public static void CreateAttachment() throws Exception {
	
	System.out.println("Create Attachment on the New Incident");
	
	js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,250)", "");
	Thread.sleep(3000L);
	driver.findElement(By.xpath("//span[contains(text(),'Attachment')]")).click();
	//driver.findElement(By.id("ext-gen843")).click();
	Thread.sleep(4000L);
	System.out.println("*****************Click New Attachment****************");
	element=driver.findElement(By.xpath("//button[contains(text(),'Attachment')]"));
	Thread.sleep(4000L);
	
	  action = new Actions(driver);
	   action.moveToElement(element).click().build().perform();
	   action.sendKeys(Keys.PAGE_DOWN).perform();
	   Thread.sleep(4000L);

	EnterValueThroughMouseClicks("C:\\Srini\\ServiceTicket.txt");
	 Thread.sleep(4000L);
	System.out.println("Attachment Created Successfully");
	
}


public static void ValidateServiceDeskIncident() throws Exception {
	
	PrintStream out = new PrintStream(new FileOutputStream("C:\\Srini\\CreateModifyIncident.txt"));
	System.setOut(out);
	
	ClickServiceDeskAnalyst();
	ValidateItems(SubmitButton,"Validate Submit Button");
	ClickIncidentButton();
	NavigateToIWantToFrame(ServiceIncidentFrame);
	ClickNewIncident();
	ValidateCustomer(Superuser,SuperUserPriority,SuperUserEmailValue,SuperUserPhonevalue,AddressValue,"VIP Customer");
	ValidateCustomer(user,RegularUserPriority,RegularUserEmailValue,RegularUserPhonevalue,AddressValue,"Regular Customer");
	VerifyBuildingListFunction();
	VerifySummary();
	VerifyServices();
	VerifySaveWithouthSummaryandDesctiption();
	VerifySaveWithSummaryandDesctiptionFirst("SN1","TEST1");
	ChangeStatus();
	VerifySaveWithSummaryandDesctiptionSecond("SN2","TEST2");
	
	

	
}
public static void ClickAllMyItems() throws Exception {
	
	System.out.println("Click All My Items");
	wait = new WebDriverWait(driver, 30);
	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen27")));
	element.click();
	Thread.sleep(1000L);

}

public static void GoToSelfServiceUser() throws Exception {
	Thread.sleep(3000L);
	//element=driver.findElement(By.xpath("button[contains(text(),'Service Desk Analyst')]"));
	
	//element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen62")));
	element=driver.findElement(By.id("ext-gen62"));
	element.click();
	Thread.sleep(2000L);
	
	element=driver.findElement(By.id("ext-gen104"));
	element.click();
	Thread.sleep(2000L);
	

	
}
public static void GoToServiceDeskAnalyst() throws Exception {
	Thread.sleep(3000L);
    driver.findElement(By.id("ext-gen42")).click();
	Thread.sleep(2000L);
	for(int i=0;i<=2;i++)
	{
		RobotTab();
	}

 RobotEnter();
	
}


public static void VerifySaveWithouthSummaryandDesctiption() throws Exception {
	System.out.println("******************Without filling the summary and description fields click save************************");
	element=driver.findElement(By.xpath("//input[@frsqa_fname='Subject']"));
    element.clear();
    Thread.sleep(1000L);
	element.sendKeys(Keys.TAB);
	Thread.sleep(1000L);
	   element=driver.findElement(By.xpath("//textarea[@frsqa_fname='Symptom']"));
		element.clear();
		Thread.sleep(1000L);
		element.sendKeys(Keys.TAB);
		Thread.sleep(1000L);
			
		 //  element=driver.findElement(By.xpath("//button[text()='Save']"));
		 element=driver.findElement(By.id("ext-gen362"));
			element.click();
			Thread.sleep(2000L);
			
			System.out.println("*************Validatng the Error received***************");
			
			element=driver.findElement(By.xpath("//span[@class='ext-mb-text']")); 
			String text = element.getAttribute("innerText");
			System.out.println("Error text value is: " +text);
		//	Assert.assertEquals(text,"The following information does not satisfy validation constraints:Summary: field value may not be empty Description: field value may not be empty");
//			element=driver.findElement(By.id("ext-gen887"));
//			element.click();
			
			element=driver.findElement(By.xpath("//div[@class='x-tool x-tool-close']")); 
			element.click();
//			driver.switchTo().alert().accept();
			Thread.sleep(2000L);
}

public static void VerifySaveWithSummaryandDesctiptionFirst(String Summ,String Desc) throws Exception {
	
	System.out.println("Enter Details in Summary and Description");
	element=driver.findElement(By.xpath("//input[@frsqa_fname='Subject']"));
    element.clear();
    Thread.sleep(1000L);
    element.sendKeys(Summ);
	element.sendKeys(Keys.TAB);
	Thread.sleep(1000L);
	
	
	   element=driver.findElement(By.xpath("//textarea[@frsqa_fname='Symptom']"));
		element.clear();
		Thread.sleep(1000L);
	    element.sendKeys(Desc);
		element.sendKeys(Keys.TAB);
		Thread.sleep(1000L);
		
				
	//	a=driver.findElement(By.xpath("//div[@class='x-frs-form-label x-frs-form-label-HeaderLabel  x-frs-form-field-readonly x-frs-form-label-readonly x-form-nohtml  headerlabel']")).getAttribute("text");
					
		 //  element=driver.findElement(By.xpath("//button[text()='Save']"));
		 element=driver.findElement(By.id("ext-gen362"));
			element.click();
			Thread.sleep(4000L);
		//	ClickJournal();
			//System.out.println("Creating and Modifying Incident Ended Successfully");
			
			
		

}

public static void ClickMainAnalyst() throws Exception {
    element=driver.findElement(By.id("ext-gen62"));
    element.click();
    Thread.sleep(3000L);
}
			
			


public static void VerifySaveWithSummaryandDesctiptionSecond(String Summ,String Desc) throws Exception {
	element=driver.findElement(By.xpath("//input[@frsqa_fname='Subject']"));
    element.clear();
    Thread.sleep(2000L);
    element.sendKeys(Summ);
	element.sendKeys(Keys.TAB);
	Thread.sleep(1000L);
	
	
	   element=driver.findElement(By.xpath("//textarea[@frsqa_fname='Symptom']"));
		element.clear();
		Thread.sleep(1000L);
	    element.sendKeys(Desc);
		element.sendKeys(Keys.TAB);
		Thread.sleep(1000L);
		
		 element=driver.findElement(By.id("ext-gen362"));
			element.click();
			Thread.sleep(2000L);
			System.out.println("*************Capture the Incident#***************");
			IncidentValue=driver.findElement(By.id("ext-comp-1527")).getText();
			IncidentValue=IncidentValue.substring(10,15);
//			String iv;
//			iv=IncidentValue;
			System.out.println("Incident Value: " +IncidentValue);
			System.out.println("Enter the Notes");
			
			 EnterValueThroughMouseClicks("Modified By SN");
			 RobotTab();
			 RobotEnter();
			 SwitchToDefault();
			 ClickMainAnalyst();
     
			     RobotTab();
			     RobotTab();
			     RobotEnter();
				ClickAllMyItems();
		    SwitchToDefault();
			NavigateToIWantToFrame(ServiceRequestSearchFrame);
		
			SearchIncidentNumber(IncidentValue);
			SwitchToDefault();
			GoToServiceDeskAnalyst();
			
			ClickIncidentButton();
			NavigateToIWantToFrame(ServiceIncidentFrame);
			SearchServiceDeskRequest(IncidentValue);
			ClickJournal();
			System.out.println("Creating and Modifying Incident Ended Successfully");
			System.out.println("****************************************************************************************************************************************************************");
			
			
			
		

}
public static void 	ClickNewTask() throws Exception {
	System.out.println("*****************Click New Task****************");
	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add Internal Task')]")));
	element.click();
	Thread.sleep(4000L);
	
	for (int i=0;i<=3;i++)
	{
		RobotTab();
	}
	     
	     EnterValueThroughMouseClicks("Desktop Support");
	     RobotTab();
	     
	 	for (int i=0;i<=4;i++)
		{
			RobotTab();
		}
	     
	     robot.keyPress(KeyEvent.VK_ENTER);
	     Thread.sleep(4000L);
	     
	     System.out.println("*****************New Task Created Successfully****************");
	     

//    
//	
//	System.out.println("**************Enter Text in Summary***********");
//	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@frsqa_fname='Subject']")));
//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	Thread.sleep(1000L);
//		element.clear();
//		Thread.sleep(1000L);
//	    element.sendKeys("TESTSN");
//	    Thread.sleep(1000L);
//	    System.out.println("**************Enter Text in Details***********");
//	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@frsqa_fname='Details']")));
//		element.clear();
//			Thread.sleep(1000L);
//		    element.sendKeys("TESTSN");
//		    Thread.sleep(1000L);
//		    System.out.println("**************Enter Team-DeskTop***********");
//			   element=driver.findElement(By.xpath("//input[@frsqa_fname='OwnerTeam']"));
//				element.clear();
//				Thread.sleep(1000L);
//			    element.sendKeys("Desktop Support");
//			    Thread.sleep(1000L);
//				driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
//				Thread.sleep(2000L);

}

public static void CompleteTask() throws Exception {
	System.out.println("*****************Click Accept Task****************");
	driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
	Thread.sleep(4000L);
	
	System.out.println("*****************Click Complete Task****************");
	driver.findElement(By.xpath("//button[contains(text(),'Complete')]")).click();
	Thread.sleep(4000L);
	
	
	for (int i=0;i<=7;i++)
	{
		RobotTab();
	}
	
	EnterValueThroughMouseClicks("Test Notes");
	RobotTab();
	
	RobotEnter();
	EnterValueThroughMouseClicks("Yes");
	RobotTab();	
	RobotEnter();
	RobotTab();	
	EnterValueThroughMouseClicks("Desktop Hardware Services");
	 RobotTab();
//	RobotEnter();
//	RobotTab();	
	EnterValueThroughMouseClicks("Desktop");
	 RobotTab();
//	RobotEnter();
//	RobotTab();
	EnterValueThroughMouseClicks("Hard Drive");
	 RobotTab();
	//RobotEnter();
	//RobotTab();
	EnterValueThroughMouseClicks("Test SN");
	 RobotTab();
	//RobotTab();
	RobotEnter();
	System.out.println("*****************Complete Task Done Successfully****************");
	
	
}

public static void EnterValueThroughMouseClicks(String Val) throws Exception {
	System.out.println("Value Entered/Choosed: " +Val);
    ss = new StringSelection(Val);
   // driver.switchTo().window(WindowEvent.WINDOW_FIRST);
    
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(ss, null);
//    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

    //imitate mouse events like ENTER, CTRL+C, CTRL+V
    robot = new Robot();
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(1000L);
    
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    Thread.sleep(2000L);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
    Thread.sleep(2000L);
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(1000L);
//    
    
    
//    robot.keyPress(KeyEvent.VK_ENTER);
//    robot.keyRelease(KeyEvent.VK_ENTER);
//    robot.keyPress(KeyEvent.VK_CONTROL);
//    robot.keyPress(KeyEvent.VK_V);
//    Thread.sleep(1000L);
//   
//    robot.keyRelease(KeyEvent.VK_CONTROL);
//    robot.keyRelease(KeyEvent.VK_V);
//    Thread.sleep(1000L);
//    robot.keyPress(KeyEvent.VK_ENTER);
//    robot.keyRelease(KeyEvent.VK_ENTER);
//    Thread.sleep(1000L);
    
//    robot.keyPress(KeyEvent.VK_TAB);
//    Thread.sleep(1000L);
	
}
public static void RobotEnter() throws Exception {
     
	robot = new Robot();
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(3000L);
	
}
public static void RobotTab() throws Exception {
	robot = new Robot();
    robot.keyPress(KeyEvent.VK_TAB);
    Thread.sleep(1500L);
	
}


public static void ClickReasignTask() throws Exception {
	System.out.println("*****************Click Reassign Task****************");
	
	driver.findElement(By.xpath("//button[contains(text(),'Reassign')]")).click();
	Thread.sleep(2000L);
	System.out.println("*****************Select Team Development & Integrations****************");
	EnterValueThroughMouseClicks("Development & Integrations");
	 RobotTab();
	EnterValueThroughMouseClicks("Test");
	 RobotTab();
	RobotEnter();
	System.out.println("*****************Reassign Task Created Successfully****************");

}


public static void VerifyTask() throws Exception {
	System.out.println("*********************ClickTask****************");
	driver.findElement(By.xpath("//span[contains(text(),'Task')]")).click();
	Thread.sleep(3000L);
	ClickNewTask();
	ClickReasignTask();
	
	CompleteTask();
	CloseTask();
	
	

	
	
	
	
}

public static void CloseTask() throws Exception {
	System.out.println("************Validate the Status of the Task***************");
	element=driver.findElement(By.xpath("//input[@frsqa_fname='Status']"));
	a=element.getAttribute("value");
	System.out.println("Status Value: " +a);
	Thread.sleep(2000L);
	Assert.assertEquals("Resolved",a);
	System.out.println("************Status of the Task is validated to Resolved Successfully***************");
	
	System.out.println("Task is Completed Successfully");
	System.out.println("************************************************************************************************************************************************");
	
}


public static void ClickJournal() throws Exception {
	
	driver.findElement(By.xpath("//span[contains(text(),'Journal')]")).click();
	Thread.sleep(2000L);

	a=driver.findElement(By.xpath("//div[contains(text(),'Notes')]")).getText();

	System.out.println("Journal Notes: " +a);
//	Thread.sleep(2000L);
//	Assert.assertEquals(a,ModifiedNotes);
	Thread.sleep(2000L);
}



public static void SearchServiceDeskRequest(String iv) throws Exception {
	wait = new WebDriverWait(driver, 30);
	//element=driver.findElement(By.id("ext-comp-1106"));
	
		
	element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-comp-1181")));
	element.sendKeys(iv);
	Thread.sleep(1000L);
	element.sendKeys(Keys.ENTER);
	Thread.sleep(3500L);
}
public static void ClickIncident() throws Exception {
	element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen23")));
	element.click();
	Thread.sleep(4000L);
	
}

public static void VerifyBuildingListFunction() throws Exception {
	
//	element=driver.findElement(By.xpath("//span[contains(@id,'ext-gen537')]"));
//    element.click();
//    Thread.sleep(3000L);
//    
//    lst = driver.findElements(By.xpath("//div[@id='ext-gen744']/div"));
//    lst.get(5).click();
//    Thread.sleep(1500L);
//    
//	List<WebElement> allLinks = driver.findElements(By.xpath("//div[contains(@id,'ext-gen744')]"));
//	Iterator<WebElement> itr = allLinks.iterator();
//	while(itr.hasNext()) {
//	    System.out.println(itr.next());
//	}
//	
	element=driver.findElement(By.xpath("//input[@frsqa_fname='WC_BuildingPickList']"));
	
	System.out.println("Manually type Hart Plaza into building list field");
	element.sendKeys("HART PLAZA.");
	Thread.sleep(2000L);
	element.sendKeys(Keys.TAB);
	Thread.sleep(2000L);
	System.out.println("Building field display turns red to alert that Hart Plaza is not a valid entry");
	
	System.out.println("Manually type 14112 Woodward Ave. into building list field");
	element.clear();
	Thread.sleep(2000L);
	
	element.sendKeys("14112 Woodward Ave.");
	Thread.sleep(2000L);
	element.sendKeys(Keys.TAB);
	Thread.sleep(2000L);
	a=driver.findElement(By.xpath("//div[@frsqa_fname='WC_BuildingAddress']")).getText();
	
	Assert.assertEquals(a,"14112 Woodward Ave.   MI 48203");
	
	System.out.println("Building address should be displayed successfully");

	
	
	}
public static void VerifySummary() throws Exception {
	System.out.println("***********************Type VDI Instructions into summary***************************");

	element=driver.findElement(By.xpath("//input[@frsqa_fname='Subject']"));
	element.sendKeys("VDI");
	element.sendKeys(Keys.TAB);
	Thread.sleep(2000L);

	System.out.println("VDI instructions knowledge article should appear on the right pane");
	a=driver.findElement(By.xpath("//div[@class='imcmatch-item-title']")).getText();
	//Assert.assertEquals(a,"Remote Access: login to Wayne County from elsewhere ()");
	a=driver.findElement(By.xpath("//div[@class='imcmatch-item-preview']")).getText();
   // Assert.assertEquals(a,"You can log in remotely to Wayne County's network using virtual desktop infrastructure, or VDI");
    System.out.println("VDI instructions knowledge article is validated successfully");
    System.out.println("****************************TYPE DESCRIPTION********************************");
    element=driver.findElement(By.xpath("//textarea[@frsqa_fname='Symptom']"));
	element.sendKeys("Test Description");
	element.sendKeys(Keys.TAB);
	Thread.sleep(2000L);
    
}
	




public static void ReportIssue() throws Exception {
	PrintStream out = new PrintStream(new FileOutputStream("C:\\Srini\\SelfServiceUser.txt"));
	System.setOut(out);
	
	
	Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl1);
	wait=new WebDriverWait(driver, 100);
	ClickServiceService();
	
	ValidateItems(SubmitButton,"Validate Submit Button");
	//ValidateItems(ServiceHomePage,"Validate ServiceHome Page");
	NavigateToIWantToFrame(ServiceRequestFrame);
	ClickReportTechnologyissue();
	SwitchToDefault();
	NavigateToReportTechnologyIssue();
	ValidateNewTechnologyIssue();
  
}

public static void ServiceTicket() throws Exception {
	Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl1);
	wait=new WebDriverWait(driver, 100);
	
	element=driver.findElement(By.xpath("/html/body/div[4]/div/form/div[4]/div/button"));
	element.click();
	Thread.sleep(2000L);
    driver.switchTo().frame(driver.findElement(By.id("ext-gen72")));
    Thread.sleep(1000L);
    
    element=driver.findElement(By.id("ext-comp-1106"));
    element.sendKeys("abc");
    
    
    
    element=driver.findElement(By.xpath("//span[text()='Report a technology issue']"));
   // element=driver.findElement(By.xpath("//span[@class='grid-link-button' and text()='Report a technologgery issue']"));
     //element=wait.until(ExpectedConditions.elementToBeClickable(By.("#ext-comp-1119 > div:nth-child(1) > table > tbody > tr > td:nth-child(2) > span")));
    //
   // element=driver.findElement(By.xpath("//div[contains(@class,'x-cl-wrap')]/descendant::span[text()='Report a technologgery issue']"));
     //element=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Report a technologgery issue")));
    element.click();
    Thread.sleep(10000L);
    
    driver.switchTo().defaultContent();
    Thread.sleep(1000L);
    
    driver.switchTo().frame(driver.findElement(By.id("ext-gen77")));
    Thread.sleep(1000L);
   
    
    element=driver.findElement(By.cssSelector("#ext-comp-1144"));
    String b=element.getText();
    System.out.println("Text Value is :" +b);
    
    //Attach Image
    
    //Building  ext-comp-1131
  
    element=driver.findElement(By.xpath("//span[contains(@id,'ext-gen206')]"));
    element.click();
    Thread.sleep(1500L);
    
    List<WebElement> lst = driver.findElements(By.xpath("//div[@id='ext-gen283']/div"));
    lst.get(1).click();
    
//    Iterator<Webelement> it = lst.iterator();
//    while (it.hasNext()) {
//        WebElement wb  = it.next();
//        if(wb.getText().equals(<Text to find in double quotes>)) {
//            wb.click();
//            break;
//        }
//
//    }
   
    //Floor  ext-comp-1133
 	
	selenium.type("id=ext-comp-1133", "3'rd");
	Thread.sleep(500L);
	
	//A
   
	   //Asset Tag ext-gen199
    element=driver.findElement(By.id("ext-comp-1125"));
    element.sendKeys("H100023");
    Thread.sleep(1500L);
    
      
    element=driver.findElement(By.id("ext-comp-1120"));
    element.sendKeys("PEOPLESOFT");
    Thread.sleep(1500L);
    //Description ext-comp-1127 -
    
    element=driver.findElement(By.id("ext-comp-1127"));
    element.sendKeys("TEST ISSUE DESCRIPTION");
   Thread.sleep(1000L);
   element = driver.findElement(By.id("ext-gen268"));
  
  Actions action = new Actions(driver);
   action.moveToElement(driver.findElement(By.id("ext-gen268"))).click().build().perform();
   action.sendKeys(Keys.PAGE_DOWN).perform();
   Thread.sleep(5000L);
//   
//   ((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
//   Thread.sleep(1000L);
   
   
  // ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation()."1000"+")");
   
  // element=wait.until(ExpectedConditions.elementToBeClickable(By.id("id=ext-gen268")));
//   Actions action = new Actions(driver);
//
//   action.moveToElement(element).click().build().perform();
//   Thread.sleep(1000L);
   
//  element.click();
     Thread.sleep(2500L);

//    // enter the file path onto the file-selection input field
     StringSelection ss = new StringSelection("C:\\Srini\\ServiceTicket.txt");
    // selenium.type("id=ext-gen268","C:\\Srini\\ServiceTicket.txt");
//    element.sendKeys("C:\\Srini\\ServiceTicket.txt");
//    Thread.sleep(2500L);
//    driver.findElement(By.name("Open")).click();
//    Thread.sleep(2000L);
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

     //imitate mouse events like ENTER, CTRL+C, CTRL+V
     robot = new Robot();
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_V);
     robot.keyRelease(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_ENTER);
     robot.keyRelease(KeyEvent.VK_ENTER);
     Thread.sleep(1000L);
    
    element=driver.findElement(By.id("ext-gen194"));
    element.click();
    Thread.sleep(2000L);
    element=driver.findElement(By.id("ext-comp-1122"));
    String IssueId=element.getText();
    
   
    
  //*[@id="ext-comp-1017"]/table/tbody/tr/td[1]
    
    element=driver.findElement(By.id("ext-gen100"));
    element.click();
    Thread.sleep(2000L);
    

    
    element=driver.findElement(By.xpath("//*[@id='ext-gen146']/div[1]/table/tbody/tr/td[1]/div/p"));
   String IssueId1 =element.getText();
   System.out.println("Issue id is: " + IssueId1);
   
   
    Thread.sleep(5000L);
    
  //*[@id="ext-gen146"]/div[1]/table/tbody/tr/td[1]/div/p

	
}

//public static void HomePageTest1() throws Exception {
//	Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl1);
//	wait=new WebDriverWait(driver, 100);
//	
//	element=driver.findElement(By.xpath("/html/body/div[4]/div/form/div[4]/div/button"));
//	element.click();
//	Thread.sleep(2000L);
//	
////
////	element=driver.findElement(By.xpath("//div[@id='ext-comp-1119']/div[2]/table/tbody/tr/td[2]/span"));
//	
//
//	Thread.sleep(5000L);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-gen23']"))).click();
//	Thread.sleep(500L);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-gen19']"))).click();
//	Thread.sleep(500L);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-gen27']"))).click();
//	Thread.sleep(500L);
//	
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-gen31']"))).click();
//	Thread.sleep(500L);
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-gen35']"))).click();
//	Thread.sleep(500L);
//	
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-gen37']"))).click();
//	Thread.sleep(5000L);
//	
////	Actions action = new Actions(driver);
////	action.moveToElement(element).moveToElement(driver.findElement(By.xpath("//*[@id='ext-gen118']/tbody/tr[3]/td/div"))).click().build().perform();
////	Thread.sleep(7500L);
//	
//	element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ext-gen118']/tbody/tr[3]/td/div")));
//	element.click();
//	
//		
//}
  

	
	
	


//@AfterClass(alwaysRun = true)
public static void tearDown() throws Exception {
  driver.quit();

}

public static void verifyUrlfirefox1() throws Exception {
	
//	String url="https://waynecounty-uat.saasit.com/Login.aspx?NoDefaultProvider=True";
	driver.get("https://waynecounty-uat.saasit.com");
	
	
//	driver.get
	Robot rb = new Robot();

    //Enter user name by ctrl-v
    StringSelection username = new StringSelection("snukala");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);            
    rb.keyPress(KeyEvent.VK_CONTROL);
    rb.keyPress(KeyEvent.VK_V);
    rb.keyRelease(KeyEvent.VK_V);
    rb.keyRelease(KeyEvent.VK_CONTROL);

    //tab to password entry field
    rb.keyPress(KeyEvent.VK_TAB);
    rb.keyRelease(KeyEvent.VK_TAB);
    Thread.sleep(500);

    //Enter password by ctrl-v
    StringSelection pwd = new StringSelection("Saibaba2005@");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
    rb.keyPress(KeyEvent.VK_CONTROL);
    rb.keyPress(KeyEvent.VK_V);
    rb.keyRelease(KeyEvent.VK_V);
    rb.keyRelease(KeyEvent.VK_CONTROL);
    
    driver.switchTo().alert().accept();
    
    

    //press enter
    
    
  //  rb.keyPress(KeyEvent.VK_ENTER);
//    rb.keyRelease(KeyEvent.VK_ENTER);
    
    
    
   // self.driver.switch_to.alert.accept()
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
}
	
		public static void 	serviceLogin() throws InterruptedException, AWTException, IOException {
			  
			  driver.findElement(By.id("UserName")).sendKeys("snukala");
			  driver.findElement(By.id("Password")).sendKeys("Saibaba2005@");
			  driver.findElement(By.xpath("/html/body/div[4]/div/form/div[3]/button")).click();
			  System.out.println("URL Entered");
			  
			  
			  
	   
	     //Using AutoIt as follows
//------------------------------------------------------------------------------------//			  
//    	  Runtime.getRuntime().exec("C:\\Srini\\LoginAuth.exe");
//		  Thread.sleep(2000L);
// ------------------------------------------------------------------------------------	//  
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   driver.manage().window().maximize();
			  Thread.sleep(1500L);
	 

				}
		
		public static void 	verifyUrl(String baseUrl) throws InterruptedException {

					 
			  driver.get(baseUrl);
			//  Thread.sleep(5000L);
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  Thread.sleep(1500L);
					
			 

				}
		
		
		
		
	
			
			
			
		}



