package restassuredtestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchRequest {

@Test
public void testPatchCreatedUser() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject reqData = new JSONObject();
		
		reqData.put("name", "John");
		reqData.put("job", "Carpenter");
		
		System.out.println(reqData.toJSONString());
		
		given()
		     .body(reqData.toJSONString())
		.when()
		     .patch("/users/409")
		 .then()       
		   .statusCode(200)
		   .log().body();
		
}

}
