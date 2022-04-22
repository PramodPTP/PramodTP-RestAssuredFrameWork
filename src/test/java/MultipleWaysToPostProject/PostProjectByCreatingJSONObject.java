package MultipleWaysToPostProject;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import CommanLibraries.JavaUtility;
import io.restassured.http.ContentType;

public class PostProjectByCreatingJSONObject 
{
@Test
public void CreateProject()
{
	JavaUtility jlib=new JavaUtility();
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "pammi"+jlib.getRandomNumber());
	jobj.put("projectName", "KGFchapter-4");
	jobj.put("status", "on going");
	jobj.put("teamSize", 30);

	baseURI="http://localhost:8084/";


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
