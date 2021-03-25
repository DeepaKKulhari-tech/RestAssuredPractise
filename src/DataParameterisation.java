import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReusableMethods;
import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DataParameterisation {

	@Test(dataProvider="addBookData")
	public void TestPost(String ISBN,String AISLE)

	{
		RestAssured.baseURI = "http://216.10.245.166";

		 Response resp=given().headers("Content-Type", "application/json")
				.body(Payload.BookData(ISBN,AISLE))
				.when().post("/Library/Addbook.php").then().assertThat().statusCode(200).extract().response();
		 
		 
			JsonPath js=ReusableMethods.rawToJson(resp);
			String ss = js.get("ID");
			System.out.println(ss);


		
	}
	
	
	@DataProvider(name="addBookData")
	public Object[][] getData()
	{
		return new Object[][] {{"999","hjhlkda"},{"991","jkkj"}};
		
	}
}
