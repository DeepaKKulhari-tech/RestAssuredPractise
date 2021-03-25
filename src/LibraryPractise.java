import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LibraryPractise {

	Properties prop=new Properties();
	@BeforeTest
	public void getData() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\deepak.kumar\\eclipse-workspace\\RestAssuredProject\\src\\Env.properties");
	    prop.load(fis);
	    
	}
	
	@Test
	public void AccessToken() 
	{
		
		
		RestAssured.baseURI="http://axis360apiqa.baker-taylor.com";
		given().header("Authorization",prop.getProperty("Authorization")).body("");
	}
}
