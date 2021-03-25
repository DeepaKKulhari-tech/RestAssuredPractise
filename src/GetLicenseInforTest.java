
import io.restassured.RestAssured;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import files.Payload;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetLicenseInforTest {

	@Test(dataProvider="getISBN", description="")
	public void testGetLicenseInfor_AllValidParamters(String ISBN,String CustID) throws IOException {
		// TODO Auto-generated method stub

		
		
		
		RestAssured.baseURI = "http://axis360apiqa.baker-taylor.com";

		given().header("Authorization",Payload.GetAccestoken()).
		        header("Library","nolibraryId").
				param("customerID",CustID).
				param("ISBN", ISBN).
				when().get("/Services/VendorAPI/getlicenseinformation").
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all();
		
		
		
		

	}
	
	
	@DataProvider(name="getISBN")
	public Object[][] getData()
	{
		return new Object[][] {{"9781575051949","70239"},{"9781223089171","70239"},{"9781554982035","70239"}};
		
	}
}
