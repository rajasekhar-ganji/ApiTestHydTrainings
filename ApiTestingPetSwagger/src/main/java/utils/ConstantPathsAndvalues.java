package utils;

public class ConstantPathsAndvalues {

	public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	public final static String propertyfile_path  = PROJECT_BASE_PATH + "/src/test/resources/PetSwaggerProperties.properties";
	public final static String addpettostore = PROJECT_BASE_PATH + "/src/test/resources/petaddtostore.json";
	public final static String updatepetdata = PROJECT_BASE_PATH + "/src/test/resources/updatepetexistingdata.json";
	public final static String uploadimage = PROJECT_BASE_PATH + "/src/test/resources/puppy.jpg";
	public final static int statuscode=200;
	public final static String pet="/pet/";
	public final static String uploadimage="/uploadImage";
}
