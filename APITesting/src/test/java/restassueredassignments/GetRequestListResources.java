package restassueredassignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetRequestListResources {
	
	@Test
	public void testGetlistResources() {

		baseURI = "https://reqres.in/api/";

		given()
		    .get("/unknown")
		.then()
		    .statusCode(200)
		    .log().all();

	}


}
