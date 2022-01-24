package restassueredassignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestRegisterSuccessful {

		@Test
		public void testPostRequestRegisterSuccessful() {
			
			baseURI = "https://reqres.in/api";

			JSONObject reqData = new JSONObject();
			reqData.put("email","eve.holt@reqres.in");
			reqData.put("password", "pistol");
			System.out.println(reqData.toJSONString());


			given()
			    .header("Content-Type","application/json")
			    .contentType(ContentType.JSON)
			    .accept(ContentType.JSON)
			    .body(reqData.toJSONString())
			.when()
			   .post("/register")
			.then()
			    .statusCode(200)
			    .log().all();
		}
}
