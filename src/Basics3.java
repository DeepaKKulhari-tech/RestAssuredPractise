import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.Payload;
import files.Resources;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Basics3 {
	
	Properties prop=new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\deepak.kumar\\eclipse-workspace\\RestAssuredProject\\src\\Env.properties");
	    prop.load(fis);
	    
	}

	@Test
	public void TestPostDelete()

	{
		RestAssured.baseURI = prop.getProperty("Host");

		Response resp=given().queryParam("key", "qaclick123").body(Payload.getPostData()).when().post(Resources.placedata()).then().assertThat().statusCode(200).
		extract().response();//getting data in raw format.
		
		String s=resp.asString();
		System.out.println(s);
		
		//Grab the place_id
		
		JsonPath js=new JsonPath(s);
		String ss=js.get("place_id");
		System.out.println(ss);
		//Place this ID in Delete request
		
		//given().queryParam("key", "qaclick123").
	    //body("{\"place_id\":\"6f48ef116435108c447f98440ddb6cda}").
	    //when().delete().then().statusCode(200);

		
	}
}
