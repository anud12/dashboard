package dashboard.domParsers;

import java.util.Iterator;

import dashboard.domData.basic.Input;
import dashboard.library.css.CSSClass;

public class InputParser 
{
	public static String parse (Input input)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("<input ");
		builder.append("type='");
		builder.append(input.getType());
		builder.append("' ");
		builder.append("name='");
		builder.append(input.getName());
		builder.append("' ");
		builder.append("class='");

		Iterator<CSSClass> iteratorCSS = input.getCSSClases().iterator();
		while(iteratorCSS.hasNext())
		{
			CSSClass css = iteratorCSS.next();
			builder.append(css.getClassName());
			builder.append(" ");
		}
		
		Iterator<String> iteratorClass = input.getClases().iterator();
		while(iteratorClass.hasNext())
		{
			String css = iteratorClass.next();
			builder.append(css);
			builder.append(" ");
		}
		
		
		builder.append("' ");
		builder.append("> ");
		
		
		return builder.toString();
	}
}
