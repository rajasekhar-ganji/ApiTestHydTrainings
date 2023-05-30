package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class HelperProperties {
	static Properties prop;
	public static String ConnectPropertyFile(String name) {
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
	}
	
