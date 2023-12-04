package com.everyset.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.everyset.testcases.BaseClass;
public class FailedTestcase_Screenshot_Utils extends BaseClass  implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString().replace(":", "-").replace(":", "-");
	     
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(Constant_Paths.screenshotpath +"Failedtestcase_Screenshotfor- "+ result.getName()+" - "+timestamp + ".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		//HelperClass.failed();
	}

	