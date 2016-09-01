package dashboard.domParsers;

import java.util.Iterator;

import dashboard.domData.basic.ArefButton;
import dashboard.library.css.CSSClass;

public class AhrefButtonParser 
{
	public static String parse (ArefButton arefButton)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("<a href='");
		builder.append(arefButton.getDestinationURL());
		builder.append("' ");
		builder.append(">");
		
		builder.append("\n");
		
		builder.append("<button ");
		builder.append("id='");
		builder.append(arefButton.getId());
		builder.append("' ");
		builder.append("class='");
		
		Iterator<CSSClass> iteratorCSS = arefButton.getCSSClases().iterator();
		while(iteratorCSS.hasNext())
		{
			CSSClass css = iteratorCSS.next();
			builder.append(css.getClassName());
			builder.append(" ");
		}
		
		Iterator<String> iteratorClass = arefButton.getClases().iterator();
		while(iteratorClass.hasNext())
		{
			String css = iteratorClass.next();
			builder.append(css);
			builder.append(" ");
		}
		
		builder.append("' ");
		builder.append(">");
		builder.append("\n");
		
		builder.append(arefButton.getLabel());
		
		builder.append("\n");
		builder.append("</button>");
		builder.append("\n");
		builder.append("</a>");
		return builder.toString();
	}
}
