package com.everyset.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.everyset.testcases.BaseClass;
public class ExtentReportwithScreenshot_Util extends BaseClass {
	static ExtentReports extent;
	public static ExtentReports getExtentReports() {
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(Constant_Paths.extentreportpath
				+ ReadingFiles_Utils.ConnectPropertyFile("ReportFileName") + "_" + getCurrentTime() + ".html");
		reporter.config().setDocumentTitle("Everyset Suite Result");
		reporter.config().setReportName("Job Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "ATMECSBLRLT-073");
		extent.setSystemInfo("User Name", "rajasekhar.ganji");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Java Version", "17.0.6");
		
		return extent;
	}

	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String timestamp = getCurrentTime(); 
		//WebDriver driver=getDriver();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = Constant_Paths.screenshotpath + ReadingFiles_Utils.ConnectPropertyFile("Screetshotname")
				+ " " + screenshotName + "_" + timestamp + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String getCurrentTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss-SSS");
		return dateFormat.format(new Date());
	}
}
