package PerfomCRUDOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetsingleProject 
{
@Test
public void GetSingleProOperation() 
{
	  baseURI="http://localhost:8084";
		 
	  when()
	  .get("/projects/TY_PROJ_1202")
	  
	 .then()
	 .assertThat()
	 .contentType(ContentType.JSON)
	 .statusCode(200)
	 .log().all();
}

}
