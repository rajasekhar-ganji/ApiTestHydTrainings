package com.everyset.testcases;


import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.everyset.pageObjects.MyProfilePOM;
import com.everyset.utilities.TestDataProvider;

public class LoginModule extends BaseClass  {
	public static WebDriver driver = getDriver();
	
	MyProfilePOM pom;
	@BeforeMethod
	public void ConnectBrowser() {
		BaseClass baseClass = new BaseClass();
		baseClass.DriversetUp();
		pom = new MyProfilePOM(driver);
	}
	
		@Test(dataProvider = "senddatafor_login", dataProviderClass = TestDataProvider.class)
		public void login(String username, String password) {
			pom.LoginModule(username, password);
	}
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
}
