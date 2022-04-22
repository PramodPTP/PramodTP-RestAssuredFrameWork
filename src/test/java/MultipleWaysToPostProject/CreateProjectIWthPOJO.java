package MultipleWaysToPostProject;

import org.testng.annotations.Test;

import CommanLibraries.JavaUtility;
import io.restassured.http.ContentType;
import projectlibrary.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectIWthPOJO 
{
@Test
public void CreateProject() 
{
	JavaUtility jlib=new JavaUtility();
	baseURI="http://localhost:8084";
	
	ProjectLibrary pobj=new ProjectLibrary("pammi", "kgf", "kgfchapte", 201);
	
	given()
	.body(pobj)
	.contentType(ContentType.JSON)

	.when()
	.post("/addProject")

	.then()
	.assertThat()
	.contentType(ContentType.JSON)
	.statusCode(201)
	.log().all();

}
}
