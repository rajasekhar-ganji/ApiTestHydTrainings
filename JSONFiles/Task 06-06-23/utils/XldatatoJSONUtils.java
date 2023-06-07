package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
public class XldatatoJSON {

	public static JSONArray Xlutil () throws Exception {
		
FileInputStream fileInputStream = new FileInputStream(ConstantPathsAndvalues.xlpath);
	
        Workbook workbook = new XSSFWorkbook(fileInputStream);
       Sheet sheet = workbook.getSheetAt(0);

       JSONArray jsonArray = new JSONArray();
       
       for (int i = 1; i <= sheet.getLastRowNum(); i++) {
           Row row = sheet.getRow(i);
           JSONObject jsonObject = new JSONObject();

           for (int j = 0; j < row.getLastCellNum(); j++) {
               Cell cell = row.getCell(j);
               String columnName = sheet.getRow(0).getCell(j).getStringCellValue();
               DataFormatter df=new DataFormatter();
               if (cell != null) {
                   Object cellValue=df.formatCellValue(cell);
                   jsonObject.put(columnName, cellValue);
               }
           }

           jsonArray.put(jsonObject);
       }
return jsonArray;
	}
	}

