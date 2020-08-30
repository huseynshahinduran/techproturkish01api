package techproedturkish01.techproedturkish01api;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class GetRequest06 extends TestBase01{
	
	@Test
	public void get01() {
		
		Response response = given().
								spec(spec01).
							when().
								get("/booking/5");
		response.prettyPrint();
		
		response.
			then().
			assertThat().
			statusCode(200).
			contentType(ContentType.JSON).
			body("firstname", Matchers.equalTo("Eric"),
				 "lastname", Matchers.equalTo("Jackson"),
				 "totalprice", Matchers.equalTo(249),
				 "depositepaid", Matchers.equalTo(false),
				 "bookingdates.checkin", Matchers.equalTo("2016-04-18"),
				 "bookingdates.checkout", Matchers.equalTo("2019-07-02"),
				 "additionalneeds", Matchers.equalTo("Breakfast"));
	}

}
