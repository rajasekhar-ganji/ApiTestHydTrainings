package com.everyset.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.everyset.utilities.ReadingFiles_Utils;
import com.everyset.utilities.HelperClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Logger log = Logger.getLogger(BaseClass.class);
	public static WebDriver driver;
	
	
	public static void OpenBrowser() {
		if(ReadingFiles_Utils.ConnectPropertyFile("browsername").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(ReadingFiles_Utils.ConnectPropertyFile("browsername").equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			 driver = new SafariDriver();
		}
		 driver.manage().window().maximize();
		driver.get(ReadingFiles_Utils.ConnectPropertyFile("url"));
		HelperClass.TimeOut(3000);
		
	}

	public static void CloseBrowser() {
		driver.close();
	}
}
