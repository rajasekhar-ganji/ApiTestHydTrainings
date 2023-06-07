package jsonfileCreation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.json.JSONArray;
import org.testng.annotations.Test;

import utils.ConstantPathsAndvalues;
import utils.XldatatoJSON;

public class JsonCreatedByXl {
  @Test
  public void test() throws Exception {
	  JSONArray jsonArray = XldatatoJSON.Xlutil();
	  File outputFile = new File(ConstantPathsAndvalues.addpet);
      BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
      bw.write(jsonArray.toString());
      bw.newLine();
      bw.close();
  }
}
