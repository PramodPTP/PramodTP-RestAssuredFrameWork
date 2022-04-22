package PerfomCRUDOperationWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteThePorject 
{
  @Test
  public void DeleteOperation() 
  {
	  baseURI="http://localhost:8084";
		 
	  when()
	  .delete("/projects/TY_PROJ_1002")
	   
	 .then()
	 .assertThat()
	 .contentType(ContentType.JSON)
	 .statusCode(204)
	 .log().all();
  }
}
