package dashboard.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	protected static boolean connected = false;
	protected static Connection connection = null;
	
	public static void connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "dashboard", "dashboard");
			
			connected = true;
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	public static Connection getConnection()
	{
		if(!connected) 
			connect();
		
		return connection;
	}
}
