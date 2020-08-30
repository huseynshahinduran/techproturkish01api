package techproedturkish01.techproedturkish01api;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetRequest13 extends TestBase01{
	
	@Test 
	public void get01() {
		

		Response response=given().
				spec(spec02).
			  when().
			  	get();

		response.prettyPrint();
		
		JsonPath json=response.jsonPath();
		SoftAssert softAssert=new SoftAssert();
		
		//1. Yol ama tavsiye edilmez
		softAssert.assertEquals(json.getString("data[0].employee_name"), "Tiger Nixon");
		softAssert.assertEquals(json.getString("data[1].employee_name"), "Garrett Winters");
		softAssert.assertEquals(json.getString("data[2].employee_name"), "Ashton Cox");
		softAssert.assertEquals(json.getString("data[3].employee_name"), "Cedric Kelly");
		softAssert.assertEquals(json.getString("data[4].employee_name"), "Airi Satou");
		
		softAssert.assertAll();
		
		//2. Yol
		List<String> isimList=new ArrayList<>();
		isimList.add("Tiger Nixon");
		isimList.add("Garrett Winters");
		isimList.add("Ashton Cox");
		isimList.add("Cedric Kelly");
		isimList.add("Airi Satou");
		
		for(int i=0; i<isimList.size(); i++) {
			
			softAssert.assertEquals(json.getString("data["+i+"].employee_name"), isimList.get(i));
			
		}
		
		
		//3. Yol
		List<Map> actualList=json.getList("data");
		System.out.println(actualList);
		
		Map<Integer, String> expectedMap=new HashMap<>();
		expectedMap.put(0, "Tiger Nixon");
		expectedMap.put(1, "Garrett Winters");
		expectedMap.put(2, "Ashton Cox");
		expectedMap.put(3, "Cedric Kelly");
		expectedMap.put(4, "Airi Satou");
		
		for(int i=0; i<expectedMap.size(); i++) {
			
			softAssert.assertEquals(actualList.get(i).get("employee_name"), expectedMap.get(i));
			
		}

		softAssert.assertAll();

	}
}
