package com.everyset.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.everyset.pageObjects.JobsPOM;
import com.everyset.utilities.ReadingFiles_Utils;
import com.everyset.utilities.HelperClass;

public class Jobs extends BaseClass {
	public JobsPOM pom;

	@BeforeMethod
	public void LaunchChrome() {
		BaseClass.OpenBrowser();
		pom = new JobsPOM(driver);
		pom.Login();
	}

	@Test
	public void Unavailable() throws Exception {

		pom.unavailable();

	}

//	@Test
	public void Available() throws Exception {

		pom.available();

	}

}