package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.specification.RequestSpecification;


public class HelperUtils {
	
	public static Properties prop;
	public static JSONObject passingdata;
	public static FileReader file;
	public static Object jsondata;
	//properties file
	public static  String ConnectPropertyFile(String name) {
		prop = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream(ConstantPathsAndvalues.propertyfile_path);
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
	
	
	//json file update pet data
	public static  JSONObject ConnectJsonFile(String requesttype) {
	JSONParser json = new JSONParser();
	
	 if(requesttype.equals("post")) {
		try {
			file = new FileReader(ConstantPathsAndvalues.addpet);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	 else if(requesttype.equals("put")) {
		try {
			file = new FileReader(ConstantPathsAndvalues.updatepetdata);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
	Object jsondata = null;
	try {
		jsondata = json.parse(file);
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	}
	passingdata = (JSONObject) jsondata;
	return passingdata;
	}
}