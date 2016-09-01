package dashboard.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dashboard.domData.basic.Table;
import dashboard.library.css.CSSLibrary;

public class DBElement 
{
	protected String name;
	protected String querry;
	
	public DBElement(String name, String querry)
	{
		this.name = name;
		this.querry = querry;
	}
	
	public Table getTable()
	{
		ResultSet set = null;
		Connection connection = null;
		Table table = new Table();
		table.addCSSClass(CSSLibrary.getCSSClass("table"));
		try 
		{
			connection = DatabaseConnection.getConnection();
			set =  connection.createStatement().executeQuery(querry);
			TableBuilder.updateTable(set, table);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return table;
	}
	public void updateTable(Table table)
	{
		ResultSet set = null;
		Connection connection = null;
		try 
		{
			connection = DatabaseConnection.getConnection();
			set =  connection.createStatement().executeQuery(querry);
			TableBuilder.updateTable(set, table);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getName() 
	{
		return name;
	}
	
}
