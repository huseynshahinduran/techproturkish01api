package techproedturkish01.techproedturkish01api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetRequest11 extends TestBase01{
	
	/*
	 GSON: GSON, 1) Json formatindaki data'lari Java Objectlerine donusturur. (De-Serialization)
	  			 2) Java Object'lerini Json formatindaki data'lara donusturur.(Serialization)
	  			 
	  Note: GSON ile ayni isi yapan ObjectMapper class'da var
	 */
	
	@Test 
	public void get01() {
		
		Response response=given().
							spec(spec03).
						  when().
						  	get("/2");
		
		response.prettyPrint();
		
		HashMap<String, String> map=response.as(HashMap.class);
		System.out.println(map);
		
		System.out.println(map.keySet());//[id, completed, title, userId]
		System.out.println(map.values());//[2.0, false, quis ut nam facilis et officia qui, 1.0]
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(map.get("completed"), false, "false olmaliydi ama degil");
		softAssert.assertAll();
		
		softAssert.assertEquals(map.get("userId"), 1.0,"userId istenildigi gibi degil");
		softAssert.assertAll();
		
		softAssert.assertEquals(map.get("id"), 2.0,"id istenildigi gibi degil");
		softAssert.assertAll();
		
		softAssert.assertEquals(map.get("title"), "quis ut nam facilis et officia qui","title istenildigi gibi degil");
		softAssert.assertAll();
		
		Gson gson=new Gson();
		String jsonFromList=gson.toJson(map);
		System.out.println(jsonFromList);
		
	}
	
}
