package files;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Payload {

	
	public static String getPostData()
	{
		return "{" +

				"\"location\": {" +

				"\"lat\": -33.8669710," +

				"\"lng\": 151.1958750" +

				"}," +

				"\"accuracy\": 50," +

				"\"name\": \"Google Shoes!\"," +

				"\"phone_number\": \"(02) 9374 4000\"," +

				"\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\"," +

				"\"types\": [\"shoe_store\"]," +

				"\"website\": \"http://www.google.com.au/\"," +

				"\"language\": \"en-AU\"" +

				"}";
		
	}
	
	public static String BookData(String ISBN, String AISLE)
	{
		return "{\r\n" + "\r\n" + "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+ISBN+"\",\r\n" + "\"aisle\":\""+AISLE+"\",\r\n" + "\"author\":\"Montu kumar\"\r\n" + "}";
		
	}
	
	@Test
	public static String GetAccestoken() throws IOException

	{
		RestAssured.baseURI = "http://axis360apiqa.baker-taylor.com";

		Response resp = given()
				.headers("Authorization", "dABzADMANgAwAF8AYQB4AGkAcwAzADYAMABhAHAAaQA6AHQAUwAjAF4AMABAAEEAcAAhAA==").

				when().post("/Services/VendorAPI.svc/accesstoken").
				then().assertThat().statusCode(200).log().all()
				.extract().response();

		JsonPath js = ReusableMethods.rawToJson(resp);
		String ss = js.get("access_token");
		System.out.println("The String is" + ss);
		return ss;

	}
	
	

}
