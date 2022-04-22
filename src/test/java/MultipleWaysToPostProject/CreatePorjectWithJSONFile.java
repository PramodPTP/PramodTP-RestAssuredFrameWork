package MultipleWaysToPostProject;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.http.entity.mime.content.FileBody;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;
import  io.restassured.http.ContentType;



public class CreatePorjectWithJSONFile 
{
	@Test
	public void CreateProject() 
	{
		//step 1:create pre reqi
		java.io.File file=new java.io.File(".\\Data.json");
		baseURI="http://localhost:8084/";

		//step 2: perfome actions
		given()
		.body(file)
		.contentType(ContentType.JSON)

		.when()
		.post("addProject")

		.then()  //step 3: validation
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}
}
