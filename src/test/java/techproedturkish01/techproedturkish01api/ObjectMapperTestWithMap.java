package techproedturkish01.techproedturkish01api;

import java.util.HashMap;

import org.junit.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import Utilities.JsonUtil;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ObjectMapperTestWithMap extends TestBase01{
	
	@Test
	public void javaToJson() {
		
		HashMap<Integer, String> map=new HashMap<>();
		map.put(101, "Ali");
		map.put(102, "Can");
		map.put(103, "Remziye");
		System.out.println(map);
		
		String jsonFromMap=JsonUtil.convertJavaJson(map);
		System.out.println(jsonFromMap);
	}
	
	@Test
	public void jsonToJava() {
		
		Response response = given().
				               spec(spec01).
				            when().
				               get("/booking/3");
		response.prettyPrint();
		
		//API'dan gelen Json formatindaki data'yi Map'e cevirdim ==> De-Serialization
		Map<String,Object> jsonToMapApi = JsonUtil.convertJsonToJava(response.asString(), Map.class);
		System.out.println(jsonToMapApi);
		
		/*
		 1)API'dan gelen Json Formatindaki data'yi Map'e cevirdim
		 2)TestCase'de bana verilen data'yi Map'e cevirecegim
		 3)1.adimda olusturdugum Map ile 2.adimda olusturdugum Map'deki data'lari karsilastirarak 
		   verification yapacagim
		 */
		
		HashMap<String, Object> jsonToMapTestCase = new HashMap<>();
		jsonToMapTestCase.put("firstname", "Jim");
		jsonToMapTestCase.put("lastname", "Jones");
		jsonToMapTestCase.put("totalprice", 764);
		jsonToMapTestCase.put("depositpaid", false);
		
		response.
		     then().
		     assertThat().
		     statusCode(200);
		
		assertEquals(jsonToMapTestCase.get("firstname"),jsonToMapApi.get("firstname"));
		assertEquals(jsonToMapTestCase.get("lastname"),jsonToMapApi.get("lastname"));
		assertEquals(jsonToMapTestCase.get("totalprice"),jsonToMapApi.get("totalprice"));
		assertEquals(jsonToMapTestCase.get("depositpaid"),jsonToMapApi.get("depositpaid"));
	}
	
	
	
	
	
	
	
	
	

}
