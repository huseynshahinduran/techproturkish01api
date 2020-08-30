package techproedturkish01.techproedturkish01api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

public class GetRequest09 extends TestBase01{
	
	@Test
	public void get01() {
	Response response=given().
						spec(spec02).
					  when().
					  	get();
	
	response.prettyPrint();
	
	JsonPath json=response.jsonPath();
	
//	System.out.println(json.getList("data.employee_name"));
//	assertEquals("Isim istenilen gibi degil","Garrett Winters",json.getList("data[1].employee_name"));//Hard assertion
	
	/*
	 * Soft Assertion icin 3 adim takip edilmelidir: 1) SoftAssert class'indan bir obje (softAssert) olustur
	 * 												 2) Objeyi (softAssert) kullanarak assertion yap
	 * 												 3) softAssert.assertAll();
	 */
	
	SoftAssert softAssert=new SoftAssert();
//	softAssert.assertEquals(json.getList("data[1].employee_name"),"Garrett Winters","Isim istenen gibi degil");
//	softAssert.assertAll();
	
	//Iscilerin arasinda Herrod Chandler'in var oldugunu "verify" ediniz
	softAssert.assertTrue(json.getList("data.employee_name").contains("Herrod Chandler"),"Herrod Chandler yok");
	softAssert.assertAll();
	
	//24 tane isci oldugunu verify ediniz
	softAssert.assertEquals(json.getList("data.id").size(),24, "24 isci yok");
	
	//7. iscinin maasinin 137500 oldugunu verify ediniz
	softAssert.assertEquals(json.getString("data[6].employee_salary"), "137500","Maas istenen gibi degil");
	
	
	
	
	
	}
}
