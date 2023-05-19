package api.com.WireMock;

import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchRequestWireMock {
	  	
	  	  private static JSONObject passingdata;
	  	    private static final int PORT = Constant.portnumber;
	  	    private static final String HOST = Constant.hostname;
	  	    private static WireMockServer server = new WireMockServer(PORT);

	  	    @BeforeTest
	  	    public static void GetDataFromJSONFile() {
	  	        JSONParser json = new JSONParser();
	  	        FileReader file = null;
	  	        try {
	  	            file = new FileReader(Constant.jsonfile_pathforpatch);
	  	        } catch (FileNotFoundException e) {
	  	            e.printStackTrace();
	  	        }
	  	        Object jsondata = null;
	  	        try {
	  	            jsondata = json.parse(file);
	  	        } catch (IOException | ParseException e) {
	  	            e.printStackTrace();
	  	        }
	  	        passingdata = (JSONObject) jsondata;
	  	        RestAssured.given().baseUri(Constant.baseurl).body(passingdata.toJSONString());
	  	    }

	  	    @BeforeClass
	  	    public static void setup() {
	  	        server.start();
	  	        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
	  	        mockResponse.withStatus(Constant.statuscode).withHeader(Constant.content, Constant.contenttype);
	  	        WireMock.configureFor(HOST, PORT);
	  	      WireMock.stubFor(WireMock.request("PATCH", WireMock.urlEqualTo(Constant.patch))
	  	    	    .willReturn(mockResponse));
	  	    }
	  	
	    @Test
	    public void patch() {
	  	    	Response response = RestAssured.given()
	  	    	.baseUri(Constant.baseurl).auth().digest(Constant.digestUsername,Constant.digestPassword)
	  	        .accept(ContentType.JSON)
	  	        .body(passingdata.toString())
	  	        .when()
	  	        .patch(Constant.patch)
	  	        .then()
	  	        .assertThat()
	  	        .statusCode(200)
	  	        .and()
	  	        .body(Constant.matchsalaryValue, Matchers.equalTo(Constant.salary))
	  	       .log().all().extract().response();
	  	        System.out.println(response.getBody().asString());
	  	        System.out.println(response.statusCode());
	  	        String actualstatusline = response.getStatusLine();
	  			String expectedstatusline = Constant.statusline;
	  			Assert.assertEquals(actualstatusline, expectedstatusline);
	  	        System.out.println(response.statusLine());
	  	    }

	  	    @AfterClass
	  	    public static void teardown() {
	  	        if (server != null && server.isRunning()) {
	  	            server.stop();
	  	        }
	  	    }

	  
  }
