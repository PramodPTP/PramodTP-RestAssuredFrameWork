package PerfomCRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTheProject {
	@Test
	public void UpdateTheProject() {
		
		//step 1:pre requisites
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Pramod");
		jobj.put("projectName", "KGFchapter-3");
		jobj.put("status", "on going");
		jobj.put("teamSize", 30);
		
		RequestSpecification rest = RestAssured.given();
		rest.body(jobj);
		rest.contentType(ContentType.JSON);
		
		//step 2:actions
		
		
		Response update = rest.put("http://localhost:8084/projects/TY_PROJ_1002");
		
		//step 3:validation
		update.then().log().all();
		
		
		
		
	}

}
