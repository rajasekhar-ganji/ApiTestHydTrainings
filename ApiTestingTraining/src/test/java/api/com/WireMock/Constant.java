package api.com.WireMock;

public class Constant {
		
			//path
		public final static String PROJECT_BASE_PATH = System.getProperty("user.dir");
	    public final static String jsonfile_pathforpost = PROJECT_BASE_PATH + "/src/test/resources/TestBodyPost.json";
	    public final static String jsonfile_pathforput = PROJECT_BASE_PATH + "/src/test/resources/TestBodyPut.json";
	    public final static String jsonfile_pathforpatch = PROJECT_BASE_PATH + "/src/test/resources/TestBodyPatch.json";
	    public final static String xmlfile_path=PROJECT_BASE_PATH+"/testng.xml";
	    //base url
	    public final static String baseurl="http://localhost:8080";
	    //end points
	    public final static String get="/api/employees";
	    public final static String post="/api/examples/create";
	    public final static String put="/api/examples/modify";
	    public final static String patch="/api/examples/partialmodify";
	    public final static String delete="/api/example/9";
	    public final static String getbyid="/api/employees/1";
	    //content
	    public final static String content="Content-Type";
	    public final static String contenttype="application/json";
	    //response validations
	    public final static String statusline="HTTP/1.1 200 OK";
	    public final static int statuscode=200;
	    public final static String putvalidatename="sekhar";
	    public final static String matchValue="employee_name";
	    public final static String matchsalaryValue="employee_salary";
	    public final static int salary=50000;
	    public final static String method="Get";
	    public final static String name="raj";
	    //wiremock
	    public final static int portnumber=8080;
	    public final static String hostname="localhost";
	    //authorization
	    public final static String authorization="Authorization";
	    //bearer
	    public final static String bearer= "Bearer";
	    public final static String BearerToken= "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	    //jwt bearer
	    public final static String JwtBearerToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	    //api key
	    public final static String apikey="Api-Key ";
	    public final static String apiKeyAccessToken="xwbxiwx2nx2xhxxhwoxwiojiowui";
	    
	    //oauth2.0
	    public final static String oauth2accesstoken="ASFDDGFHCFDFHJHJHGKJ";
	    //Oauth1.0 
	    public final static String SignatureMethod="Oauth HMAC-SHA1";
	    public final static String ConsumerKey="Oauth ASDFGHJJJKKK";
	    public final static String ConsumerSecret="Oath QWETTYYY";
	    public final static String AccessToken="Oauth GHHHHIIKK";
	    public final static String TokenSecret="Oauth EEAESRSDYTDYTDDHD";
	    //Hawk auth
	    public final static String hawkId = "myhawkid123";
	    public final static String hawkKey = "myhawkkey134";
	    public final static String algorithm = "sha256";
	    //AwS Signature
	    public final static String AccessKey = "AWS_SDFGKBBSJXBSXBUXJSXJSXJNJNSJSJ";
	    public final static String SecretKey = "Aws_XHBUICEDUEUDUDHUDHWBDWDBD";
	    //ntlm auth
	    public final static String ntlmusername = "rajasekhar123";
	    public final static String ntlmpassword="raj@123*0112";
	    public final static String ntlmdomain="mydomain";
	    public final static String ntlmworkstation="work-main";
	    
	   //Basic auth
	    public final static String basicUsername= "rajasekhar123";
	    public final static String basicPassword="raj@12345";
	  //akamaiedge grida
	    public final static String akamaiAccessToken="akamai_myaccesstoken";
	    public final static	String ClientToken="akamai_myclienttoken";
	    public final static String ClientSecret="akamai_myclientsecret";
	     
	   
}


