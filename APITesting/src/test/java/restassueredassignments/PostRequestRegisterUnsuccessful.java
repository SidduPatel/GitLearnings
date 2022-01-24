package restassueredassignments;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class PostRequestRegisterUnsuccessful {

	@Test
	public void testPostRequestRegisterUnsuccesful() {
		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();
		reqData.put("email", "Siddu@gmail.com");

		System.out.println(reqData.toJSONString());


		given()
		    .body(reqData.toJSONString())
		.when()
		   .post("/register")
		.then()
		    .statusCode(400)
		    .log().body();
	}


}
