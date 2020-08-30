package techproedturkish01.techproedturkish01api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import com.google.gson.Gson;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRequest12 extends TestBase01{

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
			  	get();

		response.prettyPrint();
		
		List<Map<String, String>>  listOfMaps=response.as(ArrayList.class);
		System.out.println(listOfMaps.get(69));
		
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertTrue(listOfMaps.size()==200, "Id sayisi istenen gibi degil");
		softAssert.assertAll();
		
		softAssert.assertEquals(listOfMaps.get(120).get("completed"),true,"Istenen gibi degil");
		softAssert.assertAll();
		
		softAssert.assertEquals(listOfMaps.get(listOfMaps.size()-2).get("title"), "numquam repellendus a magnam", "title istenilen gibi degil");
		softAssert.assertAll();
		
		//Java Object'ini Json formatina cevirme.
		Gson gson=new Gson();
		String jsonFromList=gson.toJson(listOfMaps);
		System.out.println(jsonFromList);

	}
}
