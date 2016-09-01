package dashboard.domParsers;

import java.util.Iterator;

import dashboard.domData.DomData;
import dashboard.domData.basic.TableRowHeader;

public class TableRowHeaderParser 
{
	public static String parse(TableRowHeader row)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("<tr ");
		builder.append("class = '");
		builder.append("");
		builder.append("' ");
		builder.append(">");
		
		builder.append("\n");
		
		Iterator<DomData> iterator = row.getData().iterator();
		
		int i = 0;
		while(iterator.hasNext())
		{
			DomData dom = iterator.next();
			builder.append("<th> ");
			builder.append(dom.parseHTML());
			builder.append("</th> ");
			builder.append("\n");
			i++;
		}
		
		builder.append("</tr>");
		
		return builder.toString();
	}
}
