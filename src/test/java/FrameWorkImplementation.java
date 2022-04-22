import org.testng.Reporter;
import org.testng.annotations.Test;

import CommanLibraries.BaseClassAPI;
import CommanLibraries.EndPointsLibrary;
import CommanLibraries.JavaUtility;
import CommanLibraries.RestAssuredLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import projectlibrary.ProjectLibrary;

public class FrameWorkImplementation extends BaseClassAPI 
{

	JavaUtility jlib=new JavaUtility();
	RestAssuredLibrary rlib=new RestAssuredLibrary();
	@Test
	public void CreateAddAndGet() throws Throwable 
	{
		ProjectLibrary pobj=new ProjectLibrary("pammi", "testyantra"+jlib.getRandomNumber(), "on going", 10);

		Response respo = given()
		.body(pobj)
		.contentType(ContentType.JSON)


		.when().post(EndPointsLibrary.CreateProject);
		
		
		String expdata = rLib.getJsonPath(respo, "projectId");
		System.out.println(expdata);
		
		given()
		 .pathParam("pid", expdata)
		.when()
		 .get(EndPointsLibrary.GetAllprojects+"/{pid}")
		.then().log().all();
		System.out.println("Data successfuly verifies in API response");
		
		//Step 4: Vefify the project in Database
		String query = "select * from project";
		String data = dLib.executeQueryAndGetData(query,expdata, 1);
		System.out.println(data);
		System.out.println("data verifed successfully in database");
		 
		
		
		
		
		
	}
	
	
	
	
}
