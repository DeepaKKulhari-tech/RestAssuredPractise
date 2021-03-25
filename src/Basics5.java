import io.restassured.RestAssured;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import files.ReusableMethods;

public class Basics5 {

	@Test
	public void Test()
	{
		RestAssured.baseURI = "https://maps.googleapis.com";

		Response resp=given().
				param("location", "42.3675294,-71.186966").param("radius", "10000")
				.param("key", "AIzaSyAvwgkkWfxIObdrgTBzUZWqjIhRtOg7Iao").log().all().
				when().get("maps/api/place/nearbysearch/json").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
				.body("results[0].name", equalTo("Boston")).and().header("Server", "scaffolding on HTTPServer2").log().all().
				extract().response();
				;
		
				JsonPath jp=ReusableMethods.rawToJson(resp);
				int count=jp.get("results[0].size()");
				System.out.println(count);
				
				for(int i=0;i<count;i++)
				{
					String s=jp.get("results["+i+"].name");
					System.out.println(s);
					
					
				}
		
		
	}
}
