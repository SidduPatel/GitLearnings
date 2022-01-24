package restassuredtestcases;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutRequest {
	
@Test
public void testPutCreatedUser() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject reqData = new JSONObject();
		
		reqData.put("name", "John");
		reqData.put("job", "Analyst");
		
		System.out.println(reqData.toJSONString());
		
		given()
		     .header("Content-Type", "application/json")
		     .header("Connection", "keep-alive")
		     .contentType(ContentType.JSON)
		     .accept(ContentType.JSON)
		     .body(reqData.toJSONString())
		.when()
		     .put("/users/409")
		 .then()       
		   .statusCode(200)
		   .log().all();
		
}

}
