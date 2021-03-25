
import io.restassured.RestAssured;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class Basics {

	@Test
	public void Test() {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://maps.googleapis.com";

		String s=given().
				param("location", "42.3675294,-71.186966").param("radius", "10000")
				.param("key", "AIzaSyAvwgkkWfxIObdrgTBzUZWqjIhRtOg7Iao").
				when().get("maps/api/place/nearbysearch/json").asString();
				//.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				//.body("results[0].name", equalTo("Boston")).and().header("Server", "scaffolding on HTTPServer").;
		System.out.println(s);

	}
}
