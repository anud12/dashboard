package dashboard.domParsers;

import java.util.Iterator;

import dashboard.domData.DomData;
import dashboard.domData.basic.Div;
import dashboard.library.css.CSSClass;

public class DivParser 
{
	public static String parse (Div div)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("<div ");
		builder.append("id='");
		builder.append(div.getId());
		builder.append("' ");
		builder.append("class='");
		
		Iterator<CSSClass> iteratorCSS = div.getCSSClases().iterator();
		while(iteratorCSS.hasNext())
		{
			CSSClass css = iteratorCSS.next();
			builder.append(css.getClassName());
			builder.append(" ");
		}
		
		Iterator<String> iteratorClass = div.getClases().iterator();
		while(iteratorClass.hasNext())
		{
			String css = iteratorClass.next();
			builder.append(css);
			builder.append(" ");
		}
		
		builder.append("' ");
		builder.append(">");
		
		builder.append("\n");
		
		Iterator<DomData> iterator = div.getDoms().iterator();
		while(iterator.hasNext())
		{
			DomData dom = iterator.next();
			builder.append(dom.parseHTML());
			builder.append("\n");
		}
		builder.append("\n");
		builder.append("</div>");
		return builder.toString();
	}
}
