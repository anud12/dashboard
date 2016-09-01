package dashboard.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import dashboard.domData.basic.Table;
import dashboard.domData.basic.TableRow;
import dashboard.domData.basic.TableRowHeader;
import dashboard.domData.basic.Text;

public class TableBuilder 
{
	public static Table build(ResultSet set) throws SQLException
	{		
		Table table = new Table();
		updateTable(set, table);
		return table;
	}
	public static void updateTable(ResultSet set,Table table) throws SQLException
	{
		table.clearRows();
		ResultSetMetaData setMeta = set.getMetaData();
		int collumnNumber = setMeta.getColumnCount();
		TableRowHeader header = new TableRowHeader();
		
		for(int i = 1 ; i < collumnNumber + 1 ; i++)
		{
			header.addDom(new Text(setMeta.getColumnLabel(i)));
		}
		
		table.setHeaderRow(header);
		
		while(set.next())
		{
			TableRow row = new TableRow();
			
			collumnNumber = setMeta.getColumnCount();
			
			for(int i = 1 ; i < collumnNumber + 1 ; i++)
			{
				row.addDom(new Text(set.getString(i)));
			}
			
			table.addRow(row);
		}
		
	}
}
