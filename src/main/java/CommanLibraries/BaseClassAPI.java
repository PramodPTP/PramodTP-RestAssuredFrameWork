package CommanLibraries;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;



public class BaseClassAPI 
{
	public DataBaseLibrary dLib = new DataBaseLibrary() {
	};
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish databse connection
	dLib.ConnectToDataBase();
		System.out.println("=============db connection established============");
		
		//set base Uri and port
	    baseURI = "http://localhost";
	    port = 8084;
	    
	    
	}
	
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.CloseTheDataBaseConnection();
	}

}
		

