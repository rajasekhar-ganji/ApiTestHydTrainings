package api.com.WireMock;

import java.net.URISyntaxException;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequestWireMockNoAuth {

	    private static final int PORT = Constant.portnumber;
	    private static final String HOST = Constant.hostname;
	    private static WireMockServer server = new WireMockServer(PORT);
	    @BeforeClass
	    public static void setup() {
	        server.start();
	        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
	        mockResponse.withStatus(Constant.statuscode).withHeader(Constant.content,Constant.contenttype );
	        WireMock.configureFor(HOST, PORT); // http://localhost:8080
	        WireMock.stubFor(WireMock.delete(Constant.delete).willReturn(mockResponse));
	    }
	    @Test
	    public void delete() throws URISyntaxException {
	   Response response= RestAssured.given().baseUri(Constant.baseurl).accept(ContentType.JSON).when().delete(Constant.delete).then()
	                .assertThat().statusCode(Constant.statuscode).log().all().extract().response();
	        System.out.println(response.getBody().asString());
	        System.out.println(response.statusCode());
	        String actualstatusline = response.getStatusLine();
			String expectedstatusline = Constant.statusline;
			Assert.assertEquals(actualstatusline, expectedstatusline);
	        System.out.println(response.statusLine());
	    }
	    @AfterClass
	    public static void teardown() {
	        if (null != server && server.isRunning()) {
	            server.stop();
	        }
	    }
	
  }

