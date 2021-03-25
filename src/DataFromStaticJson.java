import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DataFromStaticJson {

	@Test
	public void TestPost() throws IOException

	{
		RestAssured.baseURI = "http://216.10.245.166";

		 Response resp=given().headers("Content-Type", "application/json")
				.body(GeneratingStringfromResource("C:\\Users\\deepak.kumar\\Desktop\\GeneratingStringfromStaticJson.json"))
				.when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response();
		 
		 
			JsonPath js=ReusableMethods.rawToJson(resp);
			String ss = js.get("ID");
			System.out.println(ss);


		
	}
	
	public static String GeneratingStringfromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}

}
