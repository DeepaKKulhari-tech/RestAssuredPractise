
import io.restassured.RestAssured;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import files.Payload;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetAllInventoryLibrary {

	@Test()
	public void Test() throws IOException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "http://axis360apiqa.baker-taylor.com";

		given().header("Authorization",Payload.GetAccestoken()).
		        header("Library","nolibraryId").
				param("pageSize","10").
				param("modifiedDate","03/14/2019").
				when().get("/Services/VendorAPI/getalllibraryinventory").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().body();
		

	}
	
	

}
