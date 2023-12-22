package com.everyset.testcases;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.everyset.pageObjects.JobsPOM;
import com.everyset.pageObjects.MyProfilePOM;
import com.everyset.utilities.Constant_Paths;
import com.everyset.utilities.ExtentReportwithScreenshot_Util;
import com.everyset.utilities.HelperClass;
import com.everyset.utilities.ReadingFiles_Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	public static Logger log = Logger.getLogger(BaseClass.class);
	//public static WebDriver driver;
	public static ExtentReports extent;
	public static  ExtentTest extentTest;
	public static JobsPOM pom;
	public static MyProfilePOM pom1;
	
	
	

		    @BeforeMethod
		    public void DriversetUp() {
		    //	WebDriverManager.chromedriver().setup();
		        System.setProperty("webdriver.chrome.driver", Constant_Paths.driverfile_path);
		        driverThreadLocal.set(new ChromeDriver());
		    }
		  
		   
		    @AfterMethod
		    public void tearDown() {
		        WebDriver driver = getDriver();
		            driver.quit();
		
		    }

		    public static  WebDriver getDriver() {
		        return driverThreadLocal.get();
		    }
		

//		if(ReadingFiles_Utils.ConnectPropertyFile("browsername").equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			//System.setProperty("webdriver.chrome.driver", Constant_Paths.driverfile_path);
//			WebDriver driver = new ChromeDriver();

		
//	//	else if(ReadingFiles_Utils.ConnectPropertyFile("browsername").equalsIgnoreCase("safari"))
//		{
//			WebDriverManager.safaridriver().setup();
//			 driver = new SafariDriver();
//		}
//		
////		pom1 = new MyProfilePOM(driver);
////		pom1.Login(ReadingFiles_Utils.ConnectPropertyFile("username"),ReadingFiles_Utils.ConnectPropertyFile("password"));
////		pom1.MyProfileSelection();
//	}
	    
//	@AfterMethod
//	public void teardownbroswer() {
//		 if (driver != null) {
//	            driver.close();;;
//	        }
//	}
}