package api.com.WireMock;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import javax.crypto.Mac;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import java.util.HashMap;
import java.util.Map;

public class HawkAuthGetWireMock {

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
	public void getWithHawkAuth() {

		Map<String, String> header = new HashMap<String, String>();
		String[] headers = { Constant.hawkId, Constant.hawkKey, Constant.algorithm };

		for (String headerValue : headers) {
			header.put(Constant.authorization, headerValue);

		}
		Response response = RestAssured.given().baseUri(Constant.baseurl).header(Constant.content, Constant.contenttype)
				.headers(header).when().get(Constant.get).then().log().all().extract().response();
		System.out.println(response.getStatusCode());

	}

	@AfterClass
	public static void teardown() {
		if (null != server && server.isRunning()) {
			server.stop();
		}
	}

}
