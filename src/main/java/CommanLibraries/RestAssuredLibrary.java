package CommanLibraries;


import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RestAssuredLibrary {
	
	 /* This method will return the json path
			 * @param resp
			 * @param jsonPath
			 * @return
			 */
			public String getJsonPath(Response resp, String jsonPath)
			{
				String jsonpath = resp.jsonPath().get(jsonPath);
			
				return jsonPath;		
		     
			}
    
}
