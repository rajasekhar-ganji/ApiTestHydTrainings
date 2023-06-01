package utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class UtilsClass {
	public static Properties prop;
	public static JSONObject passingdata;
	public static FileReader file;
	public static Object jsondata;
	public static Response response;
	public static String getstatus;
	public static int id;
	public static JSONParser json;
	public static Logger log = Logger.getLogger(UtilsClass.class);
	public static RequestSpecification request;

	public static void baseUrl() {
		RestAssured.baseURI = HelperUtils.ConnectPropertyFile("baseURI");
	}

	public static void sendRequest() {
		request = RestAssured.given()
				.header(HelperUtils.ConnectPropertyFile("contentname"), HelperUtils.ConnectPropertyFile("contenttype"))
				.header(HelperUtils.ConnectPropertyFile("authorization"), HelperUtils.ConnectPropertyFile("apikey")
						+ HelperUtils.ConnectPropertyFile("apiKeyAccessToken"));
	}

	public static void addPetToStoreNow() {
		passingdata = HelperUtils.ConnectJsonFile(HelperUtils.ConnectPropertyFile("requestname"));
		log.info("Before get response");
		response = request.body(passingdata.toJSONString()).when().post().then().log().all().extract().response();

		log.info("get response" + response.getStatusLine());
		id = response.jsonPath().get("id");
	}

	public static void uploadImageOfPet() {

		log.info("Before uploading image");
		log.info("Before get response");
		response = RestAssured.given().multiPart("file", new File(ConstantPathsAndvalues.uploadpic))
				.header(HelperUtils.ConnectPropertyFile("authorization"),
						HelperUtils.ConnectPropertyFile("apikey")
								+ HelperUtils.ConnectPropertyFile("apiKeyAccessToken"))
				.post(id + HelperUtils.ConnectPropertyFile("uploadimage")).then().log().all().extract().response();
		log.info("get response successfully");
		log.info("Upload image successfully");

	}
	public static void deletePetData() {
		log.info("Before get response");
		response = request.when().delete(HelperUtils.ConnectPropertyFile("symbol")+id).then().log().all().extract().response();
		log.info("get response successfully");
		System.out.println("the pet details deleted successfully");
	}

	public static void findPetGetById() {
		log.info("Before get response");
		response = request.when().get(HelperUtils.ConnectPropertyFile("symbol")+id).then().log().all().extract().response();
		log.info("get response successfully");
	}

	public static void findPetByStatus() {
		log.info("Before get response");
		getstatus = response.jsonPath().get("status");
		String status = "findByStatus?status=" + getstatus;
		response = request.when().get(status).then().log().all().extract().response();
		log.info("get response successfully");

	}

	public static void updatePetData() {
		log.info("Before get response");
		passingdata = HelperUtils.ConnectJsonFile(HelperUtils.ConnectPropertyFile("requestname"));
		response = request.body(passingdata.toJSONString()).when().put().then().log().all().extract().response();

		log.info("get response successfully");
	}

	public static void validations() {
		if (response.getStatusCode() == ConstantPathsAndvalues.statuscode) {
			log.info("Status code validation success");
		} else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
		}

		if (response.getStatusLine().equals(HelperUtils.ConnectPropertyFile("statusline"))) {
			log.info("Status line validation success");
		} else {
			log.warn("Status line validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusLine(), equalTo(HelperUtils.ConnectPropertyFile("statusline")));

		}
	}
}
