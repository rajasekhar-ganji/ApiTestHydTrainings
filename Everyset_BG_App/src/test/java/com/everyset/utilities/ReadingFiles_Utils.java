package com.everyset.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class ReadingFiles_Utils {
	
	
	//Read properties file
	public static Properties prop;
	public static FileReader file;
	public static String ConnectPropertyFile(String name) {
		prop = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream(Constant_Paths.propertyfile_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(name);
		}
	
	
	
	
	//Excel Reader Utility
		public static String[][] XlReader(String sheetname) throws Exception {
			File excelFile = new File(Constant_Paths.xlpath);
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfColumns = sheet.getRow(0).getLastCellNum();
			String [][] data =  new String[noOfRows-1][noOfColumns];
			for (int i = 0; i < noOfRows-1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] =  df.formatCellValue(sheet.getRow(i+1).getCell(j));
				}
				
			}
			workbook.close();
			fis.close();
			return data;
			}
		


	
	// Csv File Reader utility for specific Sheetname
	 public static Object[][] getDataFromCsvFile() throws IOException, Exception {
	        File csvFile = new File(Constant_Paths.csvfilepath1);
	        FileReader fileReader = new FileReader(csvFile);
	        CSVReader reader = new CSVReader(fileReader);

	        List<Object[]> testData = new ArrayList<>();

	        String sheetName = null;
	        String[] headers = null;
	        String[][] data = null;
	        boolean isSheetData = false;

	        // Read the CSV file line by line
	        String[] nextLine;
	        while ((nextLine = reader.readNext()) != null) {
	            if (nextLine.length == 1 && !nextLine[0].isEmpty()) {
	                // This line is a sheet name
	                if (isSheetData) {
	                    // If we already have data for a sheet, add it to the list
	                    testData.add(new Object[]{sheetName, headers, data});
	                }
	                sheetName = nextLine[0];
	                headers = reader.readNext();
	                data = new String[0][];
	                isSheetData = true;
	            } else {
	                // This line is data for the current sheet
	                data = appendRow(data, nextLine);
	            }
	        }

	        // Add the last set of data to the list
	        if (isSheetData) {
	            testData.add(new Object[]{sheetName, headers, data});
	        }

	        // Convert the list to a 2D array and return
	        return testData.toArray(new Object[0][]);
	    }

	    public static String[][] appendRow(String[][] array, String[] row) {
	        String[][] newArray = new String[array.length + 1][];
	        System.arraycopy(array, 0, newArray, 0, array.length);
	        newArray[array.length] = row;
	        return newArray;
	    }
	    public static String[][] getDataFromSheet(String targetSheet) throws Exception {
	        Object[][] allData = getDataFromCsvFile();

	        for (Object[] sheetData : allData) {
	            String sheetName = (String) sheetData[0];
	            if (sheetName.equals(targetSheet)) {
	                return (String[][]) sheetData[2];
	            }
	        }

	        return null; // Sheet not found
	    }
	
	}
	        
	              
	            
	        
	

