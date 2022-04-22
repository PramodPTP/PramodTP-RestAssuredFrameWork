package PerfomCRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTheSingleProject {
	@Test
	public void GetTheSingleProject()
	{
      //step 1: pre requisties
		
		//step 2:actin
		Response rest = RestAssured.get("http://localhost:8084/projects/TY_PROJ_403");
		
		//step 3:validate the response
		rest.then().log().all();
		
		






	}

}
