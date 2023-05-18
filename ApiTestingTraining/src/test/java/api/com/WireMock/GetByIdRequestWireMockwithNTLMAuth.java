package api.com.WireMock;

import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetByIdRequestWireMockwithNTLMAuth {
	public static JsonPath jsonpath;
	public static Response response;
	public static ArrayList<Object> list;
	    private static final int PORT = Constant.portnumber;
	    private static final String HOST = Constant.hostname;
	    private static WireMockServer server = new WireMockServer(PORT);
	    @BeforeClass
	    public static void setup() {
	        server.start();
	        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
	        mockResponse.withStatus(Constant.statuscode).withHeader(Constant.content,Constant.contenttype );
	        WireMock.configureFor(HOST, PORT); // http://localhost:8080
	        WireMock.stubFor(WireMock.get(Constant.getbyid).willReturn(mockResponse));
	    }
	    @Test
	    public void get() {
	    	
	   response= RestAssured.given().baseUri(Constant.baseurl).auth().ntlm(Constant.ntlmusername,Constant.ntlmpassword,Constant.ntlmdomain,Constant.ntlmworkstation).accept(ContentType.JSON).when().get(Constant.getbyid).then()
	                .assertThat().statusCode(Constant.statuscode).and().log().all().extract().response();
	   
	jsonpath = response.jsonPath();
   	list = jsonpath.get("data.id");

	for (int i = 0; i < list.size(); i++) {
	if ((jsonpath.get("data.id[" + i + "]")).equals(3)) {
		System.out.println("employee_id :" + jsonpath.get("data.id[" + i + "]"));
		System.out.println("employee_name :" + jsonpath.get("data.employee_name[" + i + "]"));
		System.out.println("employee_salary :" + jsonpath.get("data.employee_salary[" + i + "]"));
		System.out.println("employee_age :" + jsonpath.get("data.employee_age[" + i + "]"));
		System.out.println("message "+":"+"the data get by using getById successfully");
	}
		}
	    }
	    
	    @AfterClass
	    public static void teardown() {
	        if (null != server && server.isRunning()) {
	            server.stop();
	        }
	    }
  }
