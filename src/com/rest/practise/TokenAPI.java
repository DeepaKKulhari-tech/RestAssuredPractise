package com.rest.practise;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class TokenAPI {

	static String encodedStr = "UAByAG8AawBhAHIAbQBhAEEAUABJADoAUAByAG8AawBhAHIAbQBhAEAAQQB4AGkAcwAzADYAMABBAFAASQA6AGQAZQBtAG8A";
	static String LibraryName = "demo";
	static String URI = "/Services/VendorAPI.svc/accesstoken";
	static String time = "18000";
	String tokeType = "Bearer";
	static String serverName = "Microsoft-IIS/10.0";

	@Test
	public static String GetAccestoken() throws IOException

	{
		RestAssured.baseURI = "http://axis360apiqa.baker-taylor.com";

	
		
		String response = given().headers("Authorization", encodedStr).headers("Library", LibraryName).when().post(URI)
				.then().assertThat().statusCode(200).body("expires_in", equalTo(Integer.parseInt(time)))
				.header("Server", serverName).extract().response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);

		String s = js.getString("token_type");
		int sessiontime = js.getInt("expires_in");
		String token = js.getString("access_token");
		System.out.println(s);
		System.out.println(sessiontime);
		System.out.println(token);

		return token;
		
		
	}

}