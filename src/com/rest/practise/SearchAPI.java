package com.rest.practise;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

public class SearchAPI {

	@Test
	public void doSearch() throws IOException
	{
		String URI="/Services/VendorAPI/searchTitles/v4";
		
		String token= TokenAPI.GetAccestoken();
		
		
		given()
		.headers("Authorization",token)
		.headers("Library",TokenAPI.LibraryName)
		.queryParam("searchType","Term").queryParam("searchTerm", "news")
		.when().get(URI)
		.then().assertThat().statusCode(200);
		
		
		String resp=
		given()
		.headers("Authorization",token)
		.headers("Library",TokenAPI.LibraryName)
		.queryParam("searchType","Term").queryParam("searchTerm", "The").log().all()
		.when().get(URI)
		.then().log().all().extract().response().asString();
		
		System.out.println(resp);
		
		XmlPath xs=new XmlPath(resp);
		System.out.println(xs.getString("searchTitleResponse.searchTitleResult.resultCount"));
		
	}
}
