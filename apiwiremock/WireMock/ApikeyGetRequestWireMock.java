package api.com.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class ApikeyGetRequestWireMock {

	private static final int PORT = Constant.portnumber;
	private static final String HOST = Constant.hostname;
	private static WireMockServer server = new WireMockServer(PORT);

	@BeforeClass
	public static void setup() {
		server.start();
		ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
		mockResponse.withStatus(Constant.statuscode).withHeader(Constant.content, Constant.contenttype);
		WireMock.configureFor(HOST, PORT); // http://localhost:8080
		WireMock.stubFor(WireMock.get(Constant.get).willReturn(mockResponse));
	}

	@Test
	public void get() throws URISyntaxException {
		Response response = RestAssured.given().baseUri(Constant.baseurl).header(Constant.content, Constant.contenttype)
				.header(Constant.authorization, Constant.apikey + Constant.apiKeyAccessToken).accept(ContentType.JSON)
				.when().get(Constant.get).then().assertThat().statusCode(Constant.statuscode).and().log().all()
				.extract().response();
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
