package com.everyset.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
public class TestDataProvider {
	
	
	@DataProvider(name="CSVfileDataProvider")
	 public static String[][] provideCsvDat() throws Exception {
            String[][]data= ReadingFiles_Utils.CsvReader();
			return data;
       
	}
	
	 @DataProvider(name = "csvDataProvider")
	    public Object[][] provideCsvData() throws Exception {
	    	 String[][] sheetData = ReadingFiles_Utils.getDataFromSheet("Sheet3");
			return sheetData;
	    }
	 
	 
	 
	 
	 
	
	@DataProvider(name="senddataforcontact")
	public Object[][]getDataforContact() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet2");
		return data;
	}
	
	@DataProvider(name="senddataforappearance")
	
	public Object[][]getDataforappearance() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet3");
		return data;
	}
	
	@DataProvider(name="senddataforwardrobe")
	public Object[][]getDataforWardrobe() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet4");
		return data;
	}
	@DataProvider(name="senddataforvehicles")
	
	public Object[][]getDataforVehicles() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet5");
		return data;
	}
	
	@DataProvider(name="senddataforskills")
	public Object[][]getDataforskills() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet7");
		return data;
	}
	
	@DataProvider(name="senddataforprops")
	public Object[][]getDataforprops() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet8");
		return data;
	}
	
	@DataProvider(name="senddataforphotos")
	public Object[][]getDataforPhotos() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet11");
		return data;
	}
	
	@DataProvider(name="senddataformyprofile")
	public Object[][]getDataforMyprofile() throws Exception {
		Object[][]data=ReadingFiles_Utils.XlReader("Sheet10");
		return data;
	}

}