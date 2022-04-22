package Authentecations;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BasicAuth 
{
  @Test
  public void BasicAuth() 
  {
	  baseURI="http://localhost:8084";
	  
	  given()
	  .auth().basic("rmgyantra", "rmgy@9999")
	  
	  .when()
	  .get("/login")
	  
	  .then()
	  .log().all();
  }
}
  
  
//  @Test
//  public void BasicAuth1() 
//  {
//	  baseURI="http://localhost:8084";
//	  
//	  given()
//	  .auth().preemptive().basic("rmgyantra", "rmgy@9999")                         //preemptive("rmgyantra", "rmgy@9999")
//	  
//	  .when()
//	  .get("/login")
//	  
//	  .then()
//	  .log().all();
//  }
  
//  @Test
//  public void BasicAuth() 
//  {
//	  baseURI="http://localhost:8084";
//	  
//	  given()
//	  .auth().digest("rmgyantra", "rmgy@9999")
//	  
//	  .when()
//	  .get("/login")
//	  
//	  .then()
//	  .log().all();
//  }
//  
//}
