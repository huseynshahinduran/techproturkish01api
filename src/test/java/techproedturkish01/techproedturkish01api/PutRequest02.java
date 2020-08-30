package techproedturkish01.techproedturkish01api;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class PutRequest02 extends TestBase01{
	
	/*
	  
	  
	  
	  
	 */
	
	
	@Test 
	public void put01() {
		
		Response response=given().
				spec(spec03).
				when().
				get("/58");
		response.prettyPrint();

		JSONObject jsonObject=new JSONObject();
		jsonObject.put("title", "Huseyn");
		jsonObject.put("userId", 58);
		jsonObject.put("id", 542);
		jsonObject.put("completed", true);
		
		Response responseAfterPut=given().
								contentType(ContentType.JSON).
								spec(spec03).
								body(jsonObject.toString()).
								when().
								put("/58");
		responseAfterPut.prettyPrint();
		
		response.
			then().
			assertThat().
			statusCode(200);
		
		JsonPath json=responseAfterPut.jsonPath();
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertEquals(json.getBoolean("completed"),jsonObject.get("completed"));
		softAssert.assertEquals(json.getBoolean("title"),jsonObject.get("title"));
		softAssert.assertEquals(json.getBoolean("userId"),jsonObject.get("userId"));
		softAssert.assertEquals(json.getBoolean("id"),jsonObject.get("id"));
		
	}
	
	
	
	

}
