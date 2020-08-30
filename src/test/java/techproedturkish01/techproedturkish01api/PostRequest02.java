package techproedturkish01.techproedturkish01api;

import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequest02 extends TestBase01{
	
										/*
											POST Scenario:
									Accept type Json olsun
									When
									POST request yolladigimda
									1) https://restful-booker.herokuapp.com/booking
									2) Request Body 
									{
									"firstname": "Suleyman",
									"lastname": "Alptekin",
									"totalprice": 123,
									"depositpaid": true,
									"bookingdates": {
										"checkin": "2020-05-02",
										"checkout": "2020-05-05"
									},
									"additionalneeds": "Wifi"
									}
									Then 
									Status Code 200 olmali
									Response Body, Request Body ile ayni olmali.
									*/
	
	@Test
	public void post01() {
		
		Response response = createRequestBodyByJson();//JSONObject Class kullandik
		
		response.prettyPrint();
		
		response.
			then().
			assertThat().
			statusCode(200);
		
		JsonPath json=response.jsonPath();
		SoftAssert softAssert=new SoftAssert();
		
		//firstname assertion
		softAssert.assertEquals(json.getString("booking.firstname"),jsonRequestBody.getString("firstname"));
		
		//lastname assertion
		softAssert.assertEquals(json.getString("booking.lastname"),jsonRequestBody.getString("lastname"));
			
		//totalprice assertion
		softAssert.assertEquals(json.getInt("booking.totalprice"),jsonRequestBody.get("totalprice"));
		
		//depositpaid assertion
		softAssert.assertEquals(json.getBoolean("booking.depositpaid"),jsonRequestBody.getBoolean("depositpaid"));
		
		//checkin assertion
		softAssert.assertEquals(json.getString("booking.bookingdates.checkin"),jsonBookingDatesBody.getString("checkin"));
		
		//checkout assertion
		softAssert.assertEquals(json.getString("booking.bookingdates.checkout"),jsonBookingDatesBody.getString("checkout"));
			
		//additionalneeds assertion
		softAssert.assertEquals(json.getString("booking.additionalneeds"),jsonRequestBody.getString("additionalneeds"));	
			
			softAssert.assertAll();
		
			
		
		
	}

}
