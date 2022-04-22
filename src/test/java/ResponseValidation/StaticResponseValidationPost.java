package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommanLibraries.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import  static io.restassured.RestAssured.*;
import projectlibrary.ProjectLibrary;

public class StaticResponseValidationPost
{
	@Test
	public void ResponsePost() 
	{
		JavaUtility jlib=new JavaUtility();
  ProjectLibrary plib=new ProjectLibrary("shankarnag", "sangliyana"+jlib.getRandomNumber(), "completed", 4);
		baseURI="http://localhost:8084";

		Response respo = given()
				.body(plib)
				.contentType(ContentType.JSON)

				.when()
				.post("/addProject");

		String actdata = respo.jsonPath().get("status");//get([0].projectId  
		Assert.assertEquals(actdata,"completed");
		respo.then().log().all(); 

	}

}
