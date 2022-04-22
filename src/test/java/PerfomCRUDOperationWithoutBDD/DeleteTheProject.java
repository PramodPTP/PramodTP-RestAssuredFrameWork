package PerfomCRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTheProject {
	@Test
	public  void DeleteTheProject()
	{
       //step 1:pre requisties5
		
	//step 2:actions 
		Response rest = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_403");
		
		//step 3:validation
		rest.then().log().all();
		

	}

}
