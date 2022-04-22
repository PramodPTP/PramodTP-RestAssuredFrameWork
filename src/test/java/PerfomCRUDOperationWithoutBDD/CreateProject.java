package PerfomCRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject 
{
	@Test
	public void CreateProject() {


		//crete the prerequistes-request body
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "pammi");
		jobj.put("projectName", "KGFchapter-3");
		jobj.put("status", "on going");
		jobj.put("teamSize", 15);

		RequestSpecification rest = RestAssured.given();
		rest.body(jobj);
		rest.contentType(ContentType.JSON);

		//step 2:perfom action
		Response response = rest.post("http://localhost:8084/addProject");
		
		//step 3: validate the response
		System.out.println(response.getContentType());
		System.out.println(response.asString());
		System.out.println(response.prettyPrint());
		System.out.println(response.prettyPeek());

	}
}
