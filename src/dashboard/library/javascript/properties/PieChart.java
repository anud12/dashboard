package dashboard.library.javascript.properties;

import dashboard.domData.DomData;
import dashboard.domData.basic.Table;
import dashboard.library.javascript.JSProperty;
import dashboard.library.javascript.Method;

public class PieChart extends JSProperty
{
	
	public  PieChart()
	{
		super("PieChart","javascript/");
	}
	
	
	public Method generateCall(String title, Table table, DomData destination, int headerLength, int primaryCollumn)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("PieChart.create({");
		builder.append("\n");
		
		builder.append("primaryKey:");
		builder.append(primaryCollumn);
		builder.append(",\n");
		
		builder.append("title:");
		builder.append("'");
		builder.append(title);
		builder.append("'");
		builder.append(",\n");
		
		builder.append("headerLength:");
		builder.append(headerLength);
		builder.append(",\n");
		
		builder.append("tableId:");
		builder.append("'");
		builder.append(table.getId());
		builder.append("'");
		builder.append(",\n");
		
		builder.append("drawDestinationId:");
		builder.append("'");
		builder.append(destination.getId());
		builder.append("'");
		builder.append(",\n");
		
		builder.append("appendClass:");
		builder.append("'");
		builder.append("chart");
		builder.append("'");
		builder.append("\n");
		
		builder.append("});\n");
		Method method = new Method(builder.toString(), "PieChart");
		return method;
	}

}
