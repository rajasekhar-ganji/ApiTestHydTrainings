package com.everyset.utilities;

import java.io.File;

public class Constant_Paths {
	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	public static final String Basepath = PROJECT_BASE_PATH + File.separator + "src\\test\\resources"+ File.separator + "UploadPhotos\\";
	public static final String FailedTestcasepath= PROJECT_BASE_PATH + File.separator + "test-output\\testng-failed.xml";
	
	public static final String photo1 = Basepath + "mahesh.jpg";
	public static final String photo2 = Basepath + "prabhas.jpg";
	public static final String photo3 = Basepath + "nani.jpg";
	public static final String photo4 = Basepath + "surya.jpg";

	public static final String Car1 = Basepath + "Car1.jpg";
	public static final String Car2 = Basepath + "Car2.jpg";
	public static final String Car3 = Basepath + "Car3.jpg";
	public static final String Car4 = Basepath + "Car4.jpeg";
	public static final String Car5 = Basepath + "Car5.jpg";
	
	public final static String driverfile_path=PROJECT_BASE_PATH + File.separator + "/src/test/resources"
			+ File.separator + "/Drivers/chromedriver.exe";
	public final static String propertyfile_path = PROJECT_BASE_PATH + File.separator + "/src/test/resources"
			+ File.separator + "/PropertyFile/Properties.properties";
			
	public final static String screenshotpath = PROJECT_BASE_PATH + File.separator + "/src/test/resources"
			+ File.separator + "/FailedTest_Screenshots/";
	public final static String xlpath = "C:\\Users\\rajasekhar.ganji\\Documents\\Profile.xlsx";
	
	public final static String csvfilepath1 = PROJECT_BASE_PATH + File.separator + "/src/test/resources"
			+ File.separator + "/TestData/TestData.csv";
	
	public static final String extentreportpath= PROJECT_BASE_PATH + File.separator + "/test-output/";
}
