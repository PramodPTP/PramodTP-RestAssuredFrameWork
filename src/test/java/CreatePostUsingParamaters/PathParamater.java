package CreatePostUsingParamaters;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

public class PathParamater
{
@Test
public  void pathparamater()
{
	
	baseURI="http://localhost:8084";
	 
	given()
	.pathParam("pid", "TY_PROJ_1009")
	
	.when()
	.get("/projects/{pid}")
	
	.then().log().all();
}
}
