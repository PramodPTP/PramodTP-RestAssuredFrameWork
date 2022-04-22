package PerfomCRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjects 
{

	@Test
	public void PutOperation() 
	{


		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Pramod");
		jobj.put("projectName", "kgf-chapter-3 war war");
		jobj.put("status", "on going");
		jobj.put("teamSize", 30);


		baseURI="http://localhost:8084/";
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)

		.when()
		.put("projects/TY_PROJ_1202")

		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();








	}
}
