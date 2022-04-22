package CommanLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

public class DataBaseLibrary 
{
	Driver driver;
    Connection con;
    
    
    public void ConnectToDataBase() throws Throwable {
    	driver =new Driver();
    	DriverManager.registerDriver(driver);
    	con=DriverManager.getConnection(ConstantDataBaseLibrary.dbURL,ConstantDataBaseLibrary.dbUsername,ConstantDataBaseLibrary.dbPassword);	
    }
    
    
    public void CloseTheDataBaseConnection() throws Throwable {
    	con.close();
    }
    
    public String executeQueryAndGetData(String query, String expData, int column) throws Throwable
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String Data = result.getString(column).toString();
			if(Data.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			System.out.println(expData +"data verified");
			return expData;
		}
		else
		{
			System.out.println("data not matched");
			return "";
		}
    
	}
}
