package com.rest.practise;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;

import static org.hamcrest.Matchers.*;

public class GetLibrarySettings {

	@Test
	public void getSettings() throws IOException
	{
	// RestAssured.baseURI="http://axis360apiqa.baker-taylor.com";
	 String URI="/Services/VendorAPI/getLibrarySettings/v4";
	 String libraryName="Sales/QA Demo Library";
	
	 
	String token= TokenAPI.GetAccestoken();
	
	given()
	.headers("Authorization",token)
	.headers("Library",TokenAPI.LibraryName)
	.when().get(URI)
	.then().assertThat().statusCode(200)
	.body("LibrarySettingsResponseV4.searchLibraryResult.libraryInformation.libraryName",equalTo(libraryName));
	
	String res=
	
	given()
	.headers("Authorization",token)
	.headers("Library",TokenAPI.LibraryName)
	.when().get(URI)
	.then()
	.extract().asString();
	
	System.out.println(res);	
	
	XmlPath xs=new XmlPath(res);
	System.out.println(xs.getString("LibrarySettingsResponseV4.searchLibraryResult.libraryInformation.libraryName"));
	

	
	}
	
}
