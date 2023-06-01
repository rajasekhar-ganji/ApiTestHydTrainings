package utils;

import java.io.File;

public class ConstantPathsAndvalues {

	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	 public final static String propertyfile_path  = PROJECT_BASE_PATH +File.separator+ "/src/test/resources"+File.separator+"/PetSwaggerProperties.properties";
	 public final static String addpet = PROJECT_BASE_PATH +File.separator+ "/src/test/resources"+File.separator+"/petaddtostore.json";
	    public final static String updatepetdata = PROJECT_BASE_PATH +File.separator +"/src/test/resources"+File.separator+"/updatepetexistingdata.json";
	    public final static String uploadpic = PROJECT_BASE_PATH +File.separator+ "/src/test/resources"+File.separator+"/puppy.jpg";
	    public final static int statuscode=200;
	   
	    
}
