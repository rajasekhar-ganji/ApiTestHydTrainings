package api.com.pet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConstantPathsAndvalues;
import utils.HelperProperties;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class UtilsClass {
	static Response response;
	static String getstatus;
	static int id;
	public static Logger log = Logger.getLogger(UtilsClass.class);
	public static void uploadImageOfPet() {
		log.info("Before uploading image");
		log.info("Before get response");
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.multiPart("file", new File(ConstantPathsAndvalues.uploadpic))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
				.post(ConstantPathsAndvalues.pet + id + ConstantPathsAndvalues.uploadimage).then().log().all().extract().response();
		log.info("get response successfully");
		log.info("Upload image successfully");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
			
		}
		
		
	}

	public static void postUploadImage(int id) {
		log.info("Before uploading image");
		log.info("Before get response");
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.multiPart("file", new File(ConstantPathsAndvalues.uploadpic))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
				.post(ConstantPathsAndvalues.pet+ id + ConstantPathsAndvalues.uploadimage).then().log().all().extract().response();
		log.info("Uploaded image successfully");
		log.info("get response successfully");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
			
		}
		
	}

	public static void findById(int id) {
		log.info("Before get response");
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.header(HelperProperties.ConnectPropertyFile("contentname"),
						HelperProperties.ConnectPropertyFile("contenttype"))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
				.when().get(ConstantPathsAndvalues.pet+ id).then().log().all().extract().response();
		log.info("get response successfully");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
			
		}
	}

	public static void addPetToStore() {
		JSONParser json = new JSONParser();
		FileReader file = null;
		try {
			file = new FileReader(ConstantPathsAndvalues.addpettostore);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Object jsondata = null;
		try {
			jsondata = json.parse(file);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		JSONObject passingdata = (JSONObject) jsondata;
		log.info("Before get response");
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.header(HelperProperties.ConnectPropertyFile("contentname"),
						HelperProperties.ConnectPropertyFile("contenttype"))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
				.body(passingdata.toString()).when().post(ConstantPathsAndvalues.pet).then().log().all().extract().response();
		log.info("get response successfully");
		id = response.jsonPath().get("id");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
		
		}
		
		if(response.getStatusLine().equals(HelperProperties.ConnectPropertyFile("statusline")))
		{
			log.info("Status line validation success");
		}
		else {
			log.warn("Status line validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusLine(), equalTo(HelperProperties.ConnectPropertyFile("statusline")));
			
		}
		
	}

	public static void deletePetData() {
		log.info("Before get response");
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.header(HelperProperties.ConnectPropertyFile("contentname"),
						HelperProperties.ConnectPropertyFile("contenttype"))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
				.when().delete(ConstantPathsAndvalues.pet + id).then().log().all().extract().response();
		log.info("get response successfully");
		System.out.println("the pet details deleted successfully");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
			
		}
		if(response.getStatusLine().equals(HelperProperties.ConnectPropertyFile("statusline")))
		{
			log.info("Status line validation success");
		}
		else {
			log.warn("Status line validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusLine(), equalTo(HelperProperties.ConnectPropertyFile("statusline")));
		
		}
		
	}

	public static void findPetGetById() {
		log.info("Before get response");
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.header(HelperProperties.ConnectPropertyFile("contentname"),
						HelperProperties.ConnectPropertyFile("contenttype"))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
		.when().get(ConstantPathsAndvalues.pet + id).then().log().all().extract().response();
		log.info("get response successfully");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
			
		}
		
		if(response.getStatusLine().equals(HelperProperties.ConnectPropertyFile("statusline")))
		{
			log.info("Status line validation success");
		}
		else {
			log.warn("Status line validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusLine(), equalTo(HelperProperties.ConnectPropertyFile("statusline")));
			
		}
		
	}

	public static void findPetByStatus() {
		log.info("Before get response");
		getstatus = response.jsonPath().get("status");
		String status = "findByStatus?status=" + getstatus;
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.header(HelperProperties.ConnectPropertyFile("contentname"),
						HelperProperties.ConnectPropertyFile("contenttype"))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
				.when().get(ConstantPathsAndvalues.pet + status).then().log().all().extract().response();
		log.info("get response successfully");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
			
		}
	
		if(response.getStatusLine().equals(HelperProperties.ConnectPropertyFile("statusline")))
		{
			log.info("Status line validation success");
		}
		else {
			log.warn("Status line validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusLine(), equalTo(HelperProperties.ConnectPropertyFile("statusline")));
			
		}
		
	}

	public static void updatePetData() {
		JSONParser json = new JSONParser();
		FileReader file = null;
		try {
			file = new FileReader(ConstantPathsAndvalues.updatepetdata);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Object jsondata = null;
		try {
			jsondata = json.parse(file);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		JSONObject passingdata = (JSONObject) jsondata;
		log.info("Before get response");
		response = RestAssured.given().baseUri(HelperProperties.ConnectPropertyFile("baseURI"))
				.header(HelperProperties.ConnectPropertyFile("contentname"),
						HelperProperties.ConnectPropertyFile("contenttype"))
				.header(HelperProperties.ConnectPropertyFile("authorization"),
						HelperProperties.ConnectPropertyFile("apikey")
								+ HelperProperties.ConnectPropertyFile("apiKeyAccessToken"))
				.body(passingdata.toString()).when().put(ConstantPathsAndvalues.pet).then().log().all().extract().response();
		log.info("get response successfully");
		if(response.getStatusCode()==ConstantPathsAndvalues.statuscode)
		{
			log.info("Status code validation success");
		}
		else {
			log.warn("Status code validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusCode(), is(ConstantPathsAndvalues.statuscode));
			
		}
		if(response.getStatusLine().equals(HelperProperties.ConnectPropertyFile("statusline")))
		{
			log.info("Status line validation success");
		}
		else {
			log.warn("Status line validation failed");
			log.warn("Test execution Stop");
			assertThat(response.getStatusLine(), equalTo(HelperProperties.ConnectPropertyFile("statusline")));
			
		}
		
		
	}
}
