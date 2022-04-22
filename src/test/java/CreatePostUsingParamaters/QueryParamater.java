package CreatePostUsingParamaters;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;

public class QueryParamater
{
@Test
public void QueryParamater()
{
	baseURI="https://reqres.in";
	
	given()
	.queryParam("page", 2)
	
	
	.when()
	.get("/api/users?page")
	
	
	.then()
	.log().all();
}
}
