package MultipleWaysToPostProject;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import CommanLibraries.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap 
{
@Test
public void CreateProject() 
{
	JavaUtility jlib=new JavaUtility();
	HashMap hash=new HashMap();
	hash.put("createdBy", "pammi"+jlib.getRandomNumber());
	hash.put("projectName", "kgfchapter-4");
	hash.put("status", "completed");
	hash.put("teamSize", 10);
	
	given()
	.body(hash)
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
