package dashboard.domParsers;

import java.util.Iterator;

import dashboard.domData.basic.Table;
import dashboard.domData.basic.TableRow;
import dashboard.library.css.CSSClass;

public class TableParser 
{
	public static String parse (Table table)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("<table ");
		builder.append("id='");
		builder.append(table.getId());
		builder.append("' ");
		builder.append("class='");

		Iterator<CSSClass> iteratorCSS = table.getCSSClases().iterator();
		while(iteratorCSS.hasNext())
		{
			CSSClass css = iteratorCSS.next();
			builder.append(css.getClassName());
			builder.append(" ");
		}
		
		Iterator<String> iteratorClass = table.getClases().iterator();
		while(iteratorClass.hasNext())
		{
			String css = iteratorClass.next();
			builder.append(css);
			builder.append(" ");
		}
		
		
		builder.append("' ");
		builder.append(">");
		
		builder.append("\n");
		
		int i = 0;
		
		builder.append(TableRowHeaderParser.parse(table.getHeaderRow()));
		builder.append("\n");
		
		
		
		Iterator<TableRow> iterator = table.getRows().iterator();
		while(iterator.hasNext())
		{
			i++;
			TableRow row = iterator.next();
			builder.append(TableRowParser.parse(row));
			builder.append("\n");
		}
		
		builder.append("</table>");
		return builder.toString();
	}
}
