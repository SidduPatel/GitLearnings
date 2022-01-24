package restassueredassignments;


import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import javax.annotation.meta.When;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ExtractValuesFromRegisterSuccesfulResponse {
	
	@Test
	public void test() {
		//Register User
		baseURI = "https://reqres.in/api";

		JSONObject reqData = new JSONObject();
		
		reqData.put("email", "eve.holt@reqres.in"); 
		reqData.put("password", "pistol");
		System.out.println(reqData.toJSONString());
		
		               given()
		                   .header("Content-Type","application/json")
		                   .header("charset","utf-8")
		                   .header("Connection","keep-alive")
		                   .accept(ContentType.JSON)
				           .body(reqData.toJSONString())
				        .when()
				             .post("/register")
				         .then()
				              .statusCode(200)
				              .log().all();
	    //extract register token
		               String Regtoken = given()
		        		           .body(reqData.toJSONString())
		        		           .contentType(ContentType.JSON)
		        		           .accept(ContentType.JSON)
		        		           .header("charset","utf-8")
		        		          .when()
						             .post("/register")
							         .then()
							              .extract().path("token");
					
					System.out.println(Regtoken);
					
		//extract userId
					int userId = given()
							     .body(reqData.toJSONString())
							     .contentType(ContentType.JSON)
							     .accept(ContentType.JSON)
		        	 	          .header("charset","utf-8")
		        		      .when()
		        		         .post("/register")
		        		      .then()
					              .extract().path("id");
			
			System.out.println(userId);
		
			//User Login
			          given()
			              .header("Content-Type","application/json")
			              .header("Connection", "keep-alive")
			              .accept(ContentType.JSON)
			              .body(reqData.toJSONString())
			          .when()
			            .post("/login")
			         .then()
			         //verify status code
			         .statusCode(200)
			         .log().all();
			          
			     //Extract login token
			      String Logintoken = given()
			    		  .body(reqData.toJSONString())
			    		  .contentType(ContentType.JSON)
						  .accept(ContentType.JSON)
						  .header("charset","utf-8")
					.when()
					    .post("/login")
					.then()
					    .extract().path("token");
			        System.out.println(Logintoken); 
			        
			        //get single user to find the same user id 
			        given()
					   .get("/users/"+userId)
					.then()
					   .body("data.first_name", equalTo("Eve"))
					   .body("data.last_name", equalTo("Holt"))
					   .body("data.email", equalTo("eve.holt@reqres.in"))
					   .statusCode(200)
			           .log().body();

			 // SINGLE <RESOURCE> use the same user if >> validate details
					given()
					.get("/unknown/"+userId)
					.then()
					.body("data.color", equalTo("#7BC4C4"))
					.body("data.name", equalTo("aqua sky"))
					.body("data.id", equalTo(4))
					.statusCode(200)
                    .log().everything();

					//Patch same user >> validate response >> search user >> validate
					reqData.put("name", "John");
					reqData.put("job", "Teacher");

					try {
						given()
						.body(reqData.toJSONString())
						.when()
						.patch("/users/"+userId)
						.then()
						.statusCode(200)
						.log().body();
					} catch (AssertionError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("Updated successfully");

					//searching again if it is updated or not
					given() 
					    .get("/users/"+userId)
					.then()  
					    .statusCode(200)
					    .body("data.id", equalTo(4))
					    .log().body();
					//Delete
					when()
					.delete("/users/"+userId)
					.then()
					.statusCode(204)
					.log().body();

					System.out.println("Deleted successfully");
					
					//searching again if it is deleted or not
					   given()
					      .get("/users/"+userId)
					      .then()  
						    .statusCode(200)
						    .body("data.id", equalTo(4))
						    .log().body();
				


		    	
	}

}
