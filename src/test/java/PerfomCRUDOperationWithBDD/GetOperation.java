package PerfomCRUDOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class GetOperation 
{
  @Test
  public void GetOperation() 
  {
	  
	  baseURI="http://localhost:8084";
	 
	  when()
	  .get("/projects")
	  
	 .then()
	 .assertThat()
	 .contentType(ContentType.JSON)
	 .statusCode(200)
	 .log().all();
	  
	  
	  
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
