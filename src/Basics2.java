import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Basics2 {

	@Test
	public void TestPost()

	{
		RestAssured.baseURI = "http://216.10.245.166";

		String s=given().queryParam("key", "qaclick123").body("{" +

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

				"}").when().post("/maps/api/place/add/json").asString();
		//then().assertThat().statusCode(200).
		System.out.println(s);

		;
	}
}
