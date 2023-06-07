package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class XldataUtils {
	 public static String convertSheetToJson(String request) {
         FileInputStream file = null;
		try {
			file = new FileInputStream(ConstantPathsAndvalues.xlpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet
         try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         Row row = null;
	  if(request.equals("post")) {
      row = sheet.getRow(ConstantPathsAndvalues.row); 
	  }
	  else if(request.equals("put"))
	  {
	  row = sheet.getRow(ConstantPathsAndvalues.rownum); 
	  }
     int i=0;
     while(i>=0) {
     int id = (int) row.getCell(i).getNumericCellValue();
     i++;
     int categoryId = (int) row.getCell(i).getNumericCellValue();
     i++;
     String categoryName = row.getCell(i).getStringCellValue();
     i++;
     String name = row.getCell(i).getStringCellValue();
     i++;
     String photoUrl = row.getCell(i).getStringCellValue();
     i++;
     int tagId = (int) row.getCell(i).getNumericCellValue();
     i++;
     String tagName = row.getCell(i).getStringCellValue();
     i++;
     String status = row.getCell(i).getStringCellValue();
     i++;
     StringBuilder jsonBuilder = new StringBuilder();
     jsonBuilder.append("{\n");
     jsonBuilder.append("\t\"id\": ").append(id).append(",\n");
     jsonBuilder.append("\t\"category\": {\n");
     jsonBuilder.append("\t\t\"id\": ").append(categoryId).append(",\n");
     jsonBuilder.append("\t\t\"name\": \"").append(categoryName).append("\"\n");
     jsonBuilder.append("\t},\n");
     jsonBuilder.append("\t\"name\": \"").append(name).append("\",\n");
     jsonBuilder.append("\t\"photoUrls\": [\n");
     jsonBuilder.append("\t\t\"").append(photoUrl).append("\"\n");
     jsonBuilder.append("\t],\n");
     jsonBuilder.append("\t\"tags\": [\n");
     jsonBuilder.append("\t\t{\n");
     jsonBuilder.append("\t\t\t\"id\": ").append(tagId).append(",\n");
     jsonBuilder.append("\t\t\t\"name\": \"").append(tagName).append("\"\n");
     jsonBuilder.append("\t\t}\n");
     jsonBuilder.append("\t],\n");
     jsonBuilder.append("\t\"status\": \"").append(status).append("\"\n");
     jsonBuilder.append("}");
     return jsonBuilder.toString();
 }
	return null;
	
    
}
}
