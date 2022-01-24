package restassueredassignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetRequestSingleResourcerNotFound {
	
	@Test
	public void testGetRequestSingleResourcerNotFound() {
		
		baseURI = "https://reqres.in/api/";

		given()
		    .get("/users/23")
		.then()
		    .statusCode(404)
		.log().body();
		
	}

}
