package Authentecations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.*;

public class BeraerToken
{
@Test

public void BerearToken() 
{
	baseURI="https://api.github.com";
	JSONObject jobj=new JSONObject();
	jobj.put("name","restrepo");
	
	given().auth()
    .oauth2("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")
    .body(jobj)
    .contentType(ContentType.JSON)
    
    .given().post("/user/repos")
    
    .then( )
    .log().all();
    
}
}
