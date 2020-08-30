package techproedturkish01.techproedturkish01api;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PatchRequest01 extends TestBase01{

	@Test 
	public void patch01() {
		
	Response responseBeforePatch=given().
						spec(spec03).
					  when().
						get("/58");
	
	responseBeforePatch.prettyPrint();
	
	JSONObject jsonObject=new JSONObject();
	jsonObject.put("title", "Falcon");
	
	Response responseAfterPatch=given().
									contentType(ContentType.JSON).
									spec(spec03).
									body(jsonObject.toString()).
								when().
									patch("/58");
	
	responseAfterPatch.prettyPrint();
	
	responseAfterPatch.
					then().
					assertThat().
					statusCode(200);
	
	JsonPath json=responseAfterPatch.jsonPath();
	
	assertEquals(jsonObject.get("title"), json.get("title"));
	
	SoftAssert softAssert=new SoftAssert();
	softAssert.assertEquals(json.getString("title"), jsonObject.get("title"));
	softAssert.assertAll();
	
	}
}
