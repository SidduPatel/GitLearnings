package restassueredassignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestLoginSuccessful {
	
	@Test
	public void testPostRequestLoginSucessful() {

		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();
		reqData.put("email","eve.holt@reqres.in");
		reqData.put("password", "cityslicka");
	    
	    System.out.println(reqData.toJSONString());
	    
	    given()
	        .header("Connection", "Keep-alive")
	        .contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .body(reqData.toJSONString())
	    .when()
	        .post("/login")
	    .then()
	        .statusCode(200)
	        .log().all();
			
		}
}
