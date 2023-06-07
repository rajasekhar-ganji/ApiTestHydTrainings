package utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import java.io.File;
import org.json.JSONObject;

public class ReadDatafromNotePadConvertJson {
	@Test
	public static void ReadNotePadAndConvertJSON() throws Exception
	{
	 File inputFile = new File(ConstantPathsAndvalues.notepadpath);
	 	BufferedReader br = new BufferedReader(new FileReader(inputFile));
    	 StringBuilder contentBuilder = new StringBuilder();
         String line=null;
         while ((line = br.readLine()) != null) {
             System.out.println(line);
             contentBuilder.append(line).append("\n");  
         }
        
          File outputFile = new File(ConstantPathsAndvalues.addpet);
          BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
          bw.write(contentBuilder.toString());
          bw.newLine();
          bw.close();
         }
     
 }



