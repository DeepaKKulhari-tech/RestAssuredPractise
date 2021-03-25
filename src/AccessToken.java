

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AccessToken {
	@Test
	public void GetAccestoken() throws IOException

	{
		RestAssured.baseURI = "http://axis360apiqa.baker-taylor.com";

		Response resp = given()
				.headers("Authorization","dABzADMANgAwAF8AYQB4AGkAcwAzADYAMABhAHAAaQA6AHQAUwAjAF4AMABAAEEAcAAhAA==")
				.when().post("/Services/VendorAPI.svc/accesstoken").then().assertThat().statusCode(200)
				.extract().response();

		JsonPath js = ReusableMethods.rawToJson(resp);
		String ss = js.get("access_token");
		//System.out.println("The String is" + ss);

	}
}