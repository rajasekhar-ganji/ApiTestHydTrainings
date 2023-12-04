package com.everyset.testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import com.everyset.pageObjects.JobsPOM;
import com.everyset.utilities.ReadingFiles_Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginModule  {
	public static Logger log = Logger.getLogger(LoginModule.class);
 static WebDriver driver;
	
		public void login() throws Exception {
		 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    log.info("browser opened successfully");
			driver.manage().window().maximize();
			driver.get(ReadingFiles_Utils.ConnectPropertyFile("url"));
			JobsPOM	 pom=new JobsPOM(driver);
			  pom.Login();
			  log.info("login successfully");
			//  pom.invites();
		WebElement e=driver.findElement(By.xpath("//*[@id='submit-to-job-btn']"));
//			  String color=e.getCssValue("font-size");
//			 String hexcolor= Color.fromString(color).asHex();
//			  System.out.println(color);
		e.click();
		
			Thread.sleep(10000);
		
		WebElement e1=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button[2]"));
		Boolean result=e1.isEnabled();
		Assert.assertTrue(result);
		System.out.println(result);
	driver.findElement(By.xpath("//*[@id='CQ3']")).sendKeys("hiiii");
	Thread.sleep(3000);
	Boolean result2=e1.isEnabled();
	System.out.println(result2);
	}
}
