package com.servicedesk.com;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class Functionality1  {
	protected static WebDriver driver;
	protected static JavascriptExecutor js;
	protected static WebElement element;
	protected static String a;
	protected static String baseUrl;
	protected static String fuelStationName= " ";
	protected static Boolean isPresent;
	protected static String location=" ";
	protected static String actualLocation=" ";
	protected static int j;
	protected static int rowCount;
	protected static int noOfColumns;
	protected static String[] Headers;
	protected static XSSFSheet sheet;
	protected static XSSFWorkbook workbook; 
	protected static Dimension d;
	

public static void setUp(String browser) throws Exception
{

    switch(browser)
    {
    case "chrome":

        // Write the code here for open chrome browser
    	 System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
    	driver = new ChromeDriver();
     	break;
    	
    case "firefox":
        // Write the code here for open firefox browser
    	System.setProperty("webdriver.gecko.driver",".\\geckodriver.exe");
//    	driver=new FirefoxDriver();
//    	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//    	capabilities.setCapability("marionette",true);
    	
   //  	FirefoxOptions options1 = new FirefoxOptions();
//   	 options1.addArguments("start-maximized");
//   	 options1.addArguments("disable-infobars");
//   	options1.setCapability("marionette", false);
       	
       // Write the code here for open firefox browser
   	
//   	  FirefoxOptions caps =  new FirefoxOptions().setProfile(new FirefoxProfile());
//   	  driver = new FirefoxDriver(caps);
    
  // 	ProfilesIni profile = new ProfilesIni();
   	  
  // 	FirefoxProfile myprofile = profile.getProfile("default");
//   	myprofile.setAcceptUntrustedCertificates(true);
//   	myprofile.setAssumeUntrustedCertificateIssuer(true);
   driver = new FirefoxDriver();
    	break;
   
    default :
        System.out.println("Browser choice not available");     

    }
}

public static void excelData(String filePath,String fileName,String sheetName,String location) throws Exception {


    FileInputStream file = new FileInputStream(filePath+"\\"+fileName); 
        
      //  File file = new File(filePath+"\\"+fileName);
      workbook = new XSSFWorkbook(file);
 
       sheet = workbook.getSheet(sheetName);
        noOfColumns = sheet.getRow(0).getLastCellNum();
        
                
      //Read sheet inside the workbook by its name
       
        //Find number of rows in excel file
       rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();
                 

        String[] Headers = new String[noOfColumns];
        for (j=0;j<noOfColumns;j++){
            Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
            
             
    

        if(Headers[j].equals(location))
        {
        	for (int k=1;k<=rowCount;k++) {
         String b=sheet.getRow(k).getCell(j).getStringCellValue();
         
         ArrayList<String> alist=new ArrayList<String>();
		  alist.add(b);
		// Displaying elements
	      for(String str:alist)
	      {
	       // System.out.println(str);
	        if(driver.findElements(By.cssSelector("div[title='"+str.trim()+"']")).size() != 0){
				fuelStationName=str.trim();
				validateLocations(fuelStationName);
				}
	        else
	        {
	        	System.out.println(str + " is not found");
	        }
			 
	             
         
     }
        }
        }
  
    

workbook.close();
file.close();
}
}
	
	
	


//@AfterClass(alwaysRun = true)
public static void tearDown() throws Exception {
  driver.quit();

}
	
		public static void 	verifyUrl(String baseUrl) throws InterruptedException {
					 
			  driver.get(baseUrl + "/");
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			  Thread.sleep(5000L);

				}
		
		public static void clickLocation() throws Exception {
			
			   driver.findElement(By.cssSelector("div[title=\"Search Results\"] > img")).click();
			
			Thread.sleep(2000L);
			
		}
		
		public static void validFuelPumps(String a) throws Exception {
			Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
			
			element=driver.findElement(By.xpath("//div[@title='"+a+"']"));
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(500L);
			
					
			if (selenium.isTextPresent(a))
			{
				System.out.println("Fuel Pump Name:  "+  a  );
				//Thread.sleep(1000L);
				//Close Window
				   driver.findElement(By.xpath("//div[@id='infoPopup']/div/div/i")).click();
				   Thread.sleep(500L);
			}
			
		}
		
		public static void validateTowingCompany(String a) throws Exception {
			Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
			
			element=driver.findElement(By.xpath("//div[@title='"+a+"']"));
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(500L);
			
					
			if (selenium.isTextPresent(a))
			{
			//	System.out.println("Towing Company Name:  "+  a  );
				//Thread.sleep(1000L);
				//Close Window
				   driver.findElement(By.xpath("//div[@id='infoPopup']/div/div/i")).click();
				   Thread.sleep(500L);
			}
			
		}
		
		public static void validateLocations(String a) throws Exception {

			 SoftAssert softAssertion= new SoftAssert();
			
			element=driver.findElement(By.xpath("//div[@title='"+a+"']"));
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(500L);
			a=a.trim();
			String b=driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div[1]")).getText();
			b=b.trim();
			Thread.sleep(500L);
//			System.out.println("A Value:" +a);
//			System.out.println("B Value:" +b);
				softAssertion.assertEquals(a,b);
				softAssertion.assertAll();
				//Close Window
				   driver.findElement(By.xpath("//div[@id='infoPopup']/div/div/i")).click();
				   Thread.sleep(500L);
			
			
		}
		
		public static void validateFuelLocations(String locationdynamic) throws Exception {

					 
			excelData("C://Srini", "ReadUsingPOI.xlsx", locationdynamic,"FuelLocations");
		}
		
					
	
		
		public static void validatePoliceLocations(String locationdynamic) throws Exception {
			 
			excelData("C://Srini", "ReadUsingPOI.xlsx", locationdynamic,"PoliceLocations");
			
					}
					 
					
	
		
		
		
		public static void validateTowingLocations(String locationdynamic) throws Exception {
			excelData("C://Srini", "ReadUsingPOI.xlsx", locationdynamic,"TowingLocations");
			
					}
			
		
		public static void validateHospitalLocations(String locationdynamic) throws Exception {
			excelData("C://Srini", "ReadUsingPOI.xlsx", locationdynamic,"HospitalLocations");
			
					}
			 
			
		
		public static void testCompassSearch(String enterAddress,String city) throws Exception {
			
			//10915 Belleville Road Belleville, MI 48111
			//Belleville
		 
		//	Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
		    driver.findElement(By.xpath("//div[@id='topBar']/div[3]/a/i")).click();
		    Thread.sleep(3000L);
		    driver.findElement(By.cssSelector("input.srchAddr")).clear();
		    driver.findElement(By.cssSelector("input.srchAddr")).sendKeys(enterAddress);
		    
		 // driver.findElement(By.cssSelector("input.srchAddr")).sendKeys("10915 Belleville Road Belleville, MI 48111");
		    Thread.sleep(2000L);
		    
		    driver.findElement(By.xpath("//*[@id='addySrchForm']/div/div[3]/div/div[2]/div/i")).click();
		    Thread.sleep(2000L);
		  
		   element= driver.findElement(By.xpath("//*[@id='addySrchForm']/div/div[3]/div/div[2]/div/input[2]"));
		//   element.sendKeys("Belleville");
		   element.sendKeys(city);
		    Thread.sleep(2000L);
		    element.sendKeys(Keys.TAB);
		    Thread.sleep(1000L);
		    
		    driver.findElement(By.xpath("//*[@id='addySrchForm']/div/div[3]/div/div[4]/div[2]/i")).click();
		    Thread.sleep(2000L);
		  }
		
		public static void verifyCompassHomePage(String baseUrl,String location1) throws Exception {
			Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
			 SoftAssert softAssertion= new SoftAssert();
			js = (JavascriptExecutor)driver;
			
			//Click Your Location
			clickLocation();
						    
				//Click Fuel  
				if (selenium.isTextPresent("Fuel"))	{
					element=driver.findElement(By.xpath("//*[@id='servicesSegment']/div[1]/p/img"));
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(2000L);
					actualLocation=location1;
					validateFuelLocations(actualLocation);
									}
				
				//Click Towing
				
				clickLocation();
				if (selenium.isTextPresent("Towing"))	{
					element=driver.findElement(By.xpath("//*[@id='servicesSegment']/div[2]/p/img"));
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(3000L);
					validateTowingLocations(actualLocation);
									}
				
				//Click Police
				clickLocation();
				if (selenium.isTextPresent("Police"))	{
					element=driver.findElement(By.xpath("//*[@id='servicesSegment']/div[3]/p/img"));
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(3000L);
					validatePoliceLocations(actualLocation);
									}
		
				
				//Click Hospitals
				clickLocation();
				if (selenium.isTextPresent("Hospitals"))	{
					element=driver.findElement(By.xpath("//*[@id='servicesSegment']/div[4]/p/img"));
					js.executeScript("arguments[0].click();", element);
					Thread.sleep(3000L);
					validateHospitalLocations(actualLocation);
									}
		
				
				
					
		}
		

	
	
		public static void electedOffices(String url1) throws InterruptedException {
			baseUrl=url1;
			Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
			 SoftAssert softAssertion= new SoftAssert();
			js = (JavascriptExecutor)driver;
		
			if((selenium.isTextPresent("News & Events"))) 
					{
				System.out.println("Navigated to Wayne County Page");
				Thread.sleep(500L);
				
			
				//Click Departments & Offices
				
				selenium.click("xpath=//*[@id='mainPusher']/div/div[1]/div[1]/div/div[1]/div[2]");
				Thread.sleep(1000L);
				
				System.out.println(selenium.getText("xpath=//*[@id='mainPusher']/div/div[1]/div[1]/div/div[1]/div[2]"));
				
				//Click Elected Offices
				
				element=driver.findElement(By.xpath("//*[@id='mm-0']/ul/li[2]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//Click Executive
				element=driver.findElement(By.xpath("//*[@id='mm-1']/ul/li[1]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//Click Home
				
				element=driver.findElement(By.xpath("//*[@id='mm-2']/ul/li[1]/a"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(4000L);
				
				//Click State of the County
				//element=driver.findElement(By.xpath("//*[@id='primary_nav']/a[2]"));
				//element=driver.findElement(By.xpath("//a[@title='State of the County']"));				
				element=driver.findElement(By.xpath("//div[@id='primary_nav']/a[@title='State of the County']"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(4000L);
				
				System.out.println("Clicked State of the County");
				
				a=driver.findElement(By.xpath("//*[@id='mainPusher']/div/div[2]/div/div[1]/article/h2")).getText();
				//System.out.println("State of County Text: " +a);
				softAssertion.assertEquals(a,"State of the County");
				//*[@id="primary_nav"]/a[2]
				
				System.out.println("Validated State of the County");
				//Click Biography
				element=driver.findElement(By.xpath("//*[@title='Biography']"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				a=driver.findElement(By.xpath("//*[@id='mainPusher']/div/div[2]/div/div[1]/article/h2")).getText();
			//	System.out.println("State of County Text: " +a);
				softAssertion.assertEquals(a,"Biography");
			
				
				//Click Administration Accomplishments
				element=driver.findElement(By.xpath("//*[@title='Administration Accomplishments']"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				a=driver.findElement(By.xpath("//*[@id='mainPusher']/div/div[2]/div/div[1]/article/h2")).getText();
			//	System.out.println("State of County Text: " +a);
				softAssertion.assertEquals(a,"Administration Accomplishments");
				
				
				
				//Click 	Inside Wayne County
				element=driver.findElement(By.xpath("//*[@title='Inside Wayne County']"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				a=driver.findElement(By.xpath("//*[@id='mainPusher']/div/div[2]/div/div[1]/article/h2")).getText();
			//	System.out.println("State of County Text: " +a);
				softAssertion.assertEquals(a,"Inside Wayne County");
			
				
				//Click News & Resources
				element=driver.findElement(By.xpath("//*[@title='News & Resources']"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				a=driver.findElement(By.xpath("//*[@id='mainPusher']/div/div[2]/div/div[1]/article/h2")).getText();
			//	System.out.println("State of County Text: " +a);
				softAssertion.assertEquals(a,"News & Resources");
			
				
				//Click Contact Us
				element=driver.findElement(By.xpath("//*[@title='Contact Us']"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				element=driver.findElement(By.xpath("//*[@id='primary_nav']/div/div/a[1]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				
				a=driver.findElement(By.xpath("//*[@id='mainPusher']/div/div[2]/div/div[1]/article/h2")).getText();
			//	System.out.println("State of County Text: " +a);
				softAssertion.assertEquals(a,"Contact Us");
				
				softAssertion.assertAll();
				
				//close submenu
				
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]/span"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//Click Departments & Offices
				
				
				selenium.click("xpath=//*[@id='mainPusher']/div/div[1]/div/div/div[2]");
				Thread.sleep(1000L);
				
				
				//click comission
				element=driver.findElement(By.xpath("//*[@id='mm-1']/ul/li[2]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//click commisioners
				
				
				element=driver.findElement(By.xpath("//*[@id='mm-4']/ul/li[2]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//close submenu commisioners
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]/span"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//click committes
				
				//*[@id="mm-4"]/ul/li[3]/a[2]
				element=driver.findElement(By.xpath("//*[@id='mm-4']/ul/li[3]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//close submenu committes
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]/span"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//click departments
				element=driver.findElement(By.xpath("//*[@id='mm-4']/ul/li[4]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//close submenu departments
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]/span"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
		        
				
				
				//click News & Resources
				element=driver.findElement(By.xpath("//*[@id='mm-4']/ul/li[5]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//close submenu News & Resources
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]/span"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				
				//Close Main Submenu
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//Click Clerk---------------------------Details Inside----------------------------------------------
				element=driver.findElement(By.xpath("//*[@id='mm-1']/ul/li[3]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				//Elections---Till----- News & resources----------------------------------------------
				
				for (int i=2;i<=3;i++)
					
				element=driver.findElement(By.xpath("//*[@id='mm-12']/ul/li["+i+"]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				}
				
				element=driver.findElement(By.xpath("//*[@id='mm-12']/ul/li[4]/a"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				//Click Departments & Offices
				
				
				selenium.click("xpath=//*[@id='mainPusher']/div/div[1]/div/div/div[2]");
				Thread.sleep(1000L);
				
				for (int i=5;i<=6;i++)
					
					
				{
					
				element=driver.findElement(By.xpath("//*[@id='mm-12']/ul/li["+i+"]/a[2]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				element=driver.findElement(By.xpath("//*[@id='rd-nav-slide-menu']/div[1]/div[2]/a[1]"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				}
				
				element=driver.findElement(By.xpath("//*[@id='mm-12']/ul/li[7]/a"));
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000L);
				
				System.out.println("Completed Wayne County Automation");
		}
				
	
			
			
			
		}



