package dashboard.domData.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dashboard.domData.DomData;
import dashboard.domData.DomIDFactory;
import dashboard.domParsers.TextParser;
import dashboard.library.css.CSSClass;
import dashboard.library.javascript.Method;

public class Text implements DomData 
{
	protected ArrayList<DomData> data;
	protected String text;
	protected List<CSSClass> cssClases;
	protected List<String> clases;
	protected List<Method> properties;
	protected String id;
	
	public Text()
	{
		data = new ArrayList<>();
		cssClases = new LinkedList<>();
		clases = new LinkedList<>();
		id = DomIDFactory.getID(this);
		properties = new LinkedList<>();
	}
	public Text(String string)
	{
		data = new ArrayList<>();
		cssClases = new LinkedList<>();
		clases = new LinkedList<>();
		id = DomIDFactory.getID(this);
		properties = new LinkedList<>();
		this.text = string;
	}
	
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	
	public List<CSSClass> getCSSClases() 
	{
		return cssClases;
	}

	public void setCSSClass(List<CSSClass> cssClass) 
	{
		cssClases = cssClass;
	}
	public void addCSSClass(CSSClass cssClass)
	{
		cssClases.add(cssClass);
	}
	@Override
	public List<String> getClases() 
	{
		// TODO Auto-generated method stub
		return clases;
	}
	
	public void addClass(String className)
	{
		clases.add(className);
	}
	public void addJSProperty(Method property)
	{
		this.properties.add(property);
	}
	public String parseHTML() 
	{
		return TextParser.parse(this);
	}
	@Override
	public String getId() 
	{
		return id;
	}
	@Override
	public List<DomData> getDoms() 
	{
		return data;
	}
	@Override
	public List<Method> getJSMethods() 
	{
		return properties;
	}
	public List<DomData> getDomsRecursive()
	{
		List<DomData> data = new LinkedList<DomData>();
		synchronized(data)
		{
			data = new LinkedList<DomData>();
			data.addAll(this.data);
			Iterator<DomData> iterator = this.data.iterator();
			
			while(iterator.hasNext())
			{
				DomData dom = iterator.next();
				data.addAll(dom.getDoms());
			}
		}
		return data;
	}		
}
