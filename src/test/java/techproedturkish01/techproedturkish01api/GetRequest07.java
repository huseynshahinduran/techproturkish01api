package techproedturkish01.techproedturkish01api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest07 extends TestBase01{
	
	@Test
	public void get01() {
		
		Response response=given().
				spec(spec01).
				get("/booking?firstname=Susan&depositepaid=true");//Iyi degil
		
		response.prettyPrint();
				
		assertTrue(response.getBody().asString().contains("bookingid"));
		
	}
	
	@Test
	public void get02() {
		
		spec01.queryParam("firstname","Susan",
						  "depositpaid",true);//Iyi
		
		Response response=given().
				spec(spec01).
				get("/booking/");
		
		response.prettyPrint();
				
		assertTrue(response.getBody().asString().contains("bookingid"));
		
	}

}
