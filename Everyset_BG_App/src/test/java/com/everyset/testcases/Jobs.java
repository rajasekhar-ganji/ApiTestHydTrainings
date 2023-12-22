package com.everyset.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.everyset.pageObjects.JobsPOM;
import com.everyset.utilities.ReadingFiles_Utils;
public class Jobs extends BaseClass {
	
	@BeforeMethod
    public void OpenBrowser() {
		WebDriver driver=getDriver();
		driver.manage().window().maximize();
		driver.get(ReadingFiles_Utils.ConnectPropertyFile("url"));
		pom=new JobsPOM(driver);
		
    }
	
//	@Test(priority = 1)
//	public void Invites() throws Exception {
//		extentTest = extent.startTest("Invites");
//		pom=new JobsPOM(driver);
//		pom.invites();
//	}
//
//	@Test(priority = 2)
//	public void Unavailable() throws Exception {
//		extentTest = extent.startTest("Unavailable");
//		pom.unavailable();
//	}
	@Test
	public void Available() throws Exception {
		pom.Login();
		pom.available();
	}

	@Test
	public void AvailChecks() throws Exception {
		pom.Login();
		pom.availchecksTab();
	}

//	@Test
//	public void AvailConfirmed() throws Exception {
//		extentTest = extent.startTest("AvailConfirmed");
////		WebDriver driver = getDriver();
////		pom=new JobsPOM(driver);
//		pom.availconfirmed();
//	}
	
//	@Test(priority = 6)
//	public void Denied() throws Exception {
//		 extentTest = extent.startTest("Denied");
//		pom.DeniedJobs();
//	}
//	@Test(priority = 7)
//	public void Released() throws Exception {
//		 extentTest = extent.startTest("Released");
//		pom.ReleasedJobs();
//	}
//	
	@Test
		public void Booked() throws Exception {
		    pom.Login();
			pom.BookedTab();
		}
//	
//	@Test(priority=9)
//	public void BookedWithTick() throws Exception {
//		 extentTest = extent.startTest("BookedWithTick");
//		pom.BookedWithTick();
//	}
//		@Test(priority = 10)
//		public void NoShow() throws Exception {
//		 extentTest = extent.startTest("NoShow");
//			pom.NoShowJobs();
//		}
//		@Test(priority = 11)
//		public void Canceled() throws Exception {
//			 extentTest = extent.startTest("Canceled");
//			pom.CanceledJobs();
//		}
//		@Test(priority = 12)
//		public void CanceledwithPay() throws Exception {
//			 extentTest = extent.startTest("CanceledwithPay");
//			pom.CanceledWithPayJobs();
//		}
//	

}