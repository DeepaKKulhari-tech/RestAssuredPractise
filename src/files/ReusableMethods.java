package files;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

	
	public static JsonPath rawToJson(Response resp)
	{
		String s=resp.asString();
		JsonPath js=new JsonPath(s);
		return js;
	}
}
