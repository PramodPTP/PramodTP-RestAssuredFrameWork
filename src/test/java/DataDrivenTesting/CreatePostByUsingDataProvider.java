package DataDrivenTesting;

import org.kohsuke.rngom.digested.Main;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommanLibraries.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import projectlibrary.ProjectLibrary;

public class CreatePostByUsingDataProvider
{
	@Test(dataProvider="getdata")
	public void CreatePost(String createdby,String ProjecTname,String status,int teamsize )
	{
		
		JavaUtility jlib=new JavaUtility();
		ProjectLibrary plib=new ProjectLibrary(createdby, ProjecTname+jlib.getRandomNumber(), status, teamsize);
		
		baseURI="http://localhost:8084";
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
      .then().log().all();
	
	}
	@DataProvider(name="getdata")
	public   Object[][] data()
	{
	
		Object[][] data= new Object[2][4];
	
		data[0][0]="pammi";
		data[0][1]="kgfreena";
		data[0][2]="on going";
		data[0][3]=10;
		
		data[1][0]="Falcon";
		data[1][1]="kgf-chapter-10-war in piece";
		data[1][2]="completed";
		data[1][3]=15;
		
		
		return data;
		
	}
}
