package ResponseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

public class ResponseTimeValidation 
{
@Test
public void ResponseTime() 
{
	//step 1: pre rqusities
	baseURI="http://localhost:8084";
	//step 2: actions
	Response respo = when()
	.get("/projects");
	
	//step 3:vlaidation
	respo.then()
	//.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
	.assertThat().time(Matchers.greaterThan(500L),TimeUnit.MILLISECONDS)
	.log().all();
	long time = respo.time();
	System.out.println(time);
	
	
}
}
