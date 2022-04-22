package PerfomCRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateTheProject 
{
	@Test
	public void PostOperation() 
	{

		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "pammi");
		jobj.put("projectName", "KGFchapter-4");
		jobj.put("status", "on going");
		jobj.put("teamSize", 30);

		baseURI="http://localhost:8084/";
        //import rest assured in above import make it as static and put .* at end

		given()
		.body(jobj)
		.contentType(ContentType.JSON)

		.when()
		.post("addProject")

		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();

	}
}
