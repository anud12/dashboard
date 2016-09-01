package dashboard.domParsers;

import java.util.Iterator;

import dashboard.domData.DomData;
import dashboard.domData.basic.Form;
import dashboard.library.css.CSSClass;

public class FormParser 
{
	public static String parse(Form form)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("<form ");
		builder.append("id='");
		builder.append(form.getId());
		builder.append("' ");
		builder.append("class='");
		
		Iterator<CSSClass> iteratorCSS = form.getCSSClases().iterator();
		while(iteratorCSS.hasNext())
		{
			CSSClass css = iteratorCSS.next();
			builder.append(css.getClassName());
			builder.append(" ");
		}
		
		Iterator<String> iteratorClass = form.getClases().iterator();
		while(iteratorClass.hasNext())
		{
			String css = iteratorClass.next();
			builder.append(css);
			builder.append(" ");
		}
		
		
		builder.append("' ");
		builder.append(">");
		
		builder.append("\n");
		
		Iterator<DomData> iterator = form.getDoms().iterator();
		
		while(iterator.hasNext())
		{
			DomData dom = iterator.next();
			
			builder.append(dom.parseHTML());
			builder.append("\n");
		}
		
		return builder.toString();
	}
}
