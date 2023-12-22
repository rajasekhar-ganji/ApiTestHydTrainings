package com.everyset.utilities;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.everyset.testcases.BaseClass;

public class ExtentReportListener extends BaseClass  implements ITestListener{
	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<>();
	static ExtentReports extent=ExtentReportwithScreenshot_Util.getExtentReports();
	static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Successfull TestCase - "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Skipped TestCase - "+ result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, "Failed Test Case Name - " + result.getMethod().getMethodName()); 
		extentTest.get().log(Status.FAIL, "Test Case Failed Reason ===> " + result.getThrowable()); 
		WebDriver driver = getDriver();
		Object testObject=result.getInstance();
		Class clazz=result.getTestClass().getRealClass();
		while (clazz != null) {
		    try {
		        Field driverField = clazz.getDeclaredField("driver");
		        driverField.setAccessible(true); // This is necessary if the field is private
		        driver = (WebDriver) driverField.get(testObject);
		        break; // Break the loop once you find the field
		    } catch (NoSuchFieldException e) {
		        // If the field is not found in the current class, move to the superclass
		        clazz = clazz.getSuperclass();
		    } catch (Exception e) {
		        e.printStackTrace();
		        break; // Handle other exceptions and break the loop
		    }
		}
		
		String screenshotPath = null;
			try {
				
				screenshotPath = ExtentReportwithScreenshot_Util.getScreenshot(driver,result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String timestamp = ExtentReportwithScreenshot_Util.getCurrentTime();
		extentTest.get().log(Status.FAIL, "Failed Test Screenshot - " + result.getName() + "_" + timestamp + ":"
				+ extentTest.get().addScreenCaptureFromPath(screenshotPath));
		}
	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
	