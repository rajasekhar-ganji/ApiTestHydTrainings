package com.everyset.utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.xml.XmlSuite;


import com.everyset.testcases.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReport_Utils extends BaseClass implements IReporter {
	  public ExtentReports extent;
	  public ExtentTest test;
 
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) { 
    	String timestamp = getCurrentTime();
    	
        extent = new ExtentReports(outputDirectory + File.separator
                + ReadingFiles_Utils.ConnectPropertyFile("ReportFileName") +"_"+timestamp+ ".html",true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                try {
                    buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        extent.flush();
        extent.close();
    }
    public void buildTestNodes(IResultMap tests, LogStatus status) throws IOException {
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getName());
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));
              
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
                
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }
                
                extent.endTest(test);
            }
        }
    }
    
    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

    private static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss-SSS");
        return dateFormat.format(new Date());
    }
}
