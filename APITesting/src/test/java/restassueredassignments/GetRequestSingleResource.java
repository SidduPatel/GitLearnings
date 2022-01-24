package restassueredassignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class GetRequestSingleResource {
	
	@Test
	public void testGetSingleResource() {

		baseURI = "https://reqres.in/api/";

		given()
		.get("/unknown/2")
		.then()
		     .statusCode(200)
			 .body("data.name", equalTo("fuchsia rose"))
			 .log().body()
		     .log().all();

	}


}
