package restassueredassignments;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class PostRequestLoginUnsuccessful {

@Test
	public void testPostRequestLoginUnSucessful() {

		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();
		reqData.put("email", "Siddu@gmail.com");
		System.out.println(reqData.toJSONString());


		given()
		     .body(reqData.toJSONString())
		.when()
		    .post("/login")
		.then()
		    .statusCode(400)
		.log().body()
		// if validation fails , status is displayed
		.log().ifValidationFails(LogDetail.STATUS);
	}


}


