package restassuredtestcases;

import org.testng.annotations.Test;

import io.restassured.filter.log.LogDetail;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetRequestCucumberStyle {
	
	@Test
	public void testGetUserList() {
		baseURI = "https://reqres.in/api";
		
		given()
		    .get("/users?page=2")
		.then()
		    .statusCode(200)
		    .log().all();
	}
	@Test
	public void testValidateGetUserlistData () {
		
        baseURI = "https://reqres.in/api";
		
		given()
		    .get("/users?page=2")
		.then()
		    .statusCode(200)
		    .body("data[2].id", equalTo(9))
		    .body("data[0].first_name",equalTo("Michael"))
		    .body("data.first_name", hasItem("Lindsay"))
		    .body("data.first_name", hasItems("Michael", "Lindsay", "Byron"))
		    .log().body()
		    .log().headers()
		    .log().everything()
		    .log().status()
		    .log().ifStatusCodeIsEqualTo(203)
		    .log().ifValidationFails(LogDetail.STATUS)
		    .log().all();
	}

}
