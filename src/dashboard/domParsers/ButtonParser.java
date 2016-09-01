package dashboard.domParsers;

import java.util.Iterator;

import dashboard.domData.basic.Button;
import dashboard.library.css.CSSClass;

public class ButtonParser 
{
	public static String parse (Button button)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("<button ");
		builder.append("id='");
		builder.append(button.getId());
		builder.append("' ");
		builder.append("class='");
		
		Iterator<CSSClass> iteratorCSS = button.getCSSClases().iterator();
		while(iteratorCSS.hasNext())
		{
			CSSClass css = iteratorCSS.next();
			builder.append(css.getClassName());
			builder.append(" ");
		}
		
		Iterator<String> iteratorClass = button.getClases().iterator();
		while(iteratorClass.hasNext())
		{
			String css = iteratorClass.next();
			builder.append(css);
			builder.append(" ");
		}
		
		builder.append("' ");
		builder.append(">");
		builder.append("\n");
		
		builder.append(button.getLabel());
		
		builder.append("\n");
		builder.append("</button>");
		return builder.toString();
	}
}
