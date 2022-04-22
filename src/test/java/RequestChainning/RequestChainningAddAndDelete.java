package RequestChainning;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CommanLibraries.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import projectlibrary.ProjectLibrary;

public class RequestChainningAddAndDelete
{
@Test
public void RequestChainning() 
{
	JavaUtility jlib=new JavaUtility();
	ProjectLibrary plib=new ProjectLibrary("salaga", "chrome"+jlib.getRandomNumber(), "completed", 40);

	baseURI="http://localhost:8084";

	Response respo = given()
			.body(plib)
			.contentType(ContentType.JSON)

			.when()
			.post("/addProject");

	//capture the project Id

	String proid = respo.jsonPath().get("projectId");
	System.out.println(proid);
	respo.then().log().all();

	//create a get request and pass proid as path parameter

	given()
	.pathParam("pid", proid)
	.when()
	.delete("/projects/{pid}")
	.then()
	.assertThat().statusCode(204).log().all();
}
}
