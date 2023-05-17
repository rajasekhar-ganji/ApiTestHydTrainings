package api.com.WireMock;

public class Constant {
		
		public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	    public final static String jsonfile_pathforpost = PROJECT_BASE_PATH + "/src/test/resources/TestBodyPost.json";
	    public final static String jsonfile_pathforput = PROJECT_BASE_PATH + "/src/test/resources/TestBodyPut.json";
	    public final static String jsonfile_pathforpatch = PROJECT_BASE_PATH + "/src/test/resources/TestBodyPatch.json";
	    public final static String xmlfile_path=PROJECT_BASE_PATH+"/testng.xml";
	    public final static String post="/api/examples/create";
	    public final static String baseurl="http://localhost:8080";
	    public final static String get="/api/examples";
	    public final static String put="/api/examples/modify";
	    public final static String patch="/api/examples/partialmodify";
	    public final static String content="Content-Type";
	    public final static String contenttype="application/json";
	    public final static String statusline="HTTP/1.1 200 OK";
	    public final static int statuscode=200;
	    public final static int portnumber=8080;
	    public final static String hostname="localhost";
	    public final static String method="Get";
	    public final static String name="raj";
	    public final static String putvalidatename="sekhar";
	    public final static String matchValue="employee_name";
	    public final static String matchsalaryValue="employee_salary";
	    public final static int salary=50000;
	    public final static String delete="/api/example/9";
	


}


