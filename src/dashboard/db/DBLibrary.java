package dashboard.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DBLibrary 
{
	protected static HashMap<String , DBElement> elements = new HashMap<>();
	
	public static void addDBElement(DBElement element)
	{
		elements.put(element.getName(), element);
	}
	public static DBElement getElement(String name)
	{
		return elements.get(name);
	}
	
	public static void initialize()
	{
		Connection connection = DatabaseConnection.getConnection();
		
		try 
		{
			ResultSet set = connection.createStatement().executeQuery("select table_name from user_tables");
			
			while(set.next())
			{
				DBElement element;
				
				String string = set.getString(1);
				
				System.out.println(string);
				
				
				element = new DBElement(string, "select * from " + string);
				addDBElement(element);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
