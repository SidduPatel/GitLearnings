package restassuredtestcases;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequest {
	@Test
	public void testPostCreateUser() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject reqData = new JSONObject();
		
		reqData.put("name", "John");
		reqData.put("job", "Teacher");
		
		System.out.println(reqData.toJSONString());
		
		given()
		     .header("Content-Type", "application/json")
		     .header("Connection", "keep-alive")
		     .contentType(ContentType.JSON)
		     .accept(ContentType.JSON)
		     .body(reqData.toJSONString())
		.when()
		     .post("/users")
		 .then()       
		   .statusCode(201)
		   .log().all();
			
	}

}
