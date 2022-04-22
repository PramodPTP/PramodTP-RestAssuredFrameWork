package Authentecations;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2_0 
{
	@Test
	public void auth2_0() 
	{
		Response respo = given()
				.formParam("client_id", "SDET-30-COOPS")
				.formParam("client_secret", "1b6327ab3f7101b10de3226635a0d77f")
				.formParam("grant_type ", "client_credentials")
				.formParam("redirect_uri ", "http://coop.apps.symfonycasts.com/application")
				.formParam("code ", "authorization_code")

				.when()
				.post("http://coop.apps.symfonycasts.com/token");

		String token = respo.jsonPath().get("access_token");
		System.out.println(token);

		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3115)


		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")

		.then()
		.log().all();












	}
}
