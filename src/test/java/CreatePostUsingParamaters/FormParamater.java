package CreatePostUsingParamaters;

import static  io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class FormParamater 
{
  @Test
  public void FormParamater()
  {
	  baseURI="http://localhost:8084";
	  
	  given()
	  .formParam("createdBy", "pammi")
	  .formParam("projectName", "reena")
	  .formParam("status", "on going")
	  .formParam("teamSize", 25)
	  
	  .when()
	  .post("/addProject")
	  
	  
	  
	  .then()
	  .log().all();
	  
  }
}
