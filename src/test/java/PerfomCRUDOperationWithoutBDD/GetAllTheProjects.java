package PerfomCRUDOperationWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllTheProjects {
	@Test
	public void GetAlltheProjects() {

		//step 1:create pre requisites 
         

		//step 2:perfom some actions
		Response respo = RestAssured.get("http://localhost:8084/projects");

		//step 3: validate the response
		respo.then().log().all();
		int actualdata = respo.statusCode();
		Assert.assertEquals(actualdata, 200);
        
	}

}
