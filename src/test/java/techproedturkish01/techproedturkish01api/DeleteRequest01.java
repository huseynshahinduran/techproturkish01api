package techproedturkish01.techproedturkish01api;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.response.Response;
public class DeleteRequest01 extends TestBase01{

	@Test
	public void delete01() {
		
		Response responseBeforeDelete=given().
				spec(spec03).
			  when().
				get("/58");

		responseBeforeDelete.prettyPrint();

		Response responseAfterDelete=given().
				spec(spec03).
			  when().
				delete("/58");

		responseAfterDelete.prettyPrint();
		
		Response getResponseAfterDelete=given().
				spec(spec03).
			  when().
				get("/58");

		getResponseAfterDelete.prettyPrint();
		
		responseAfterDelete.
					then().
					assertThat().
					statusCode(200);
		
		
	}
	
}
