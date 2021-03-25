package files;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EncodedString {
	@Test
	public void TestPost() throws IOException

	{
		RestAssured.baseURI = "http://vendorapiqa.axis360.org";

		Response resp = given().
				headers("Content-Type", "application/x-www-form-urlencoded").
				queryParam("vendorUserName","ts360_axis360api").
				queryParam("vendorpassword", ":tS#^0@Ap!").
				queryParam("libraryID", "nolibraryId").
				//.body(GeneratingStringfromResource("C:\\Users\\deepak.kumar\\Desktop\\environment.json"))

				when().post("/Home/Encode_Request/").then().assertThat().statusCode(200).log().all().extract().response();

		JsonPath js = ReusableMethods.rawToJson(resp);
		String ss = js.get("encodedString");
		System.out.println("The String is"+ss);

	}

	public static String GeneratingStringfromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));

	}

}
