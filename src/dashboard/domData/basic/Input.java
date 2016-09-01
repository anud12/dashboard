package dashboard.domData.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dashboard.domData.DomData;
import dashboard.domData.DomIDFactory;
import dashboard.domParsers.InputParser;
import dashboard.library.css.CSSClass;
import dashboard.library.javascript.Method;

public class Input implements DomData
{
	protected ArrayList<DomData> data;
	protected String type;
	protected String name;
	protected List<CSSClass> cssClases;
	protected List<String> clases;
	protected List<Method> properties;
	protected String id;
	
	public Input()
	{
		data = new ArrayList<>();
		cssClases = new LinkedList<>();
	}
	public Input (String type, String name)
	{
		data = new ArrayList<>();
		this.type = type;
		this.name = name;
		cssClases = new LinkedList<>();
		clases = new LinkedList<>();
		properties = new LinkedList<>();
		id = DomIDFactory.getID(this);
	}
	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
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
	public void addJSProperty(Method property)
	{
		this.properties.add(property);
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
	
	@Override
	public String parseHTML() 
	{
		return InputParser.parse(this);
	}
	@Override
	public String getId() 
	{
		return id;
	}
	@Override
	public List<Method> getJSMethods() 
	{
		return properties;
	}
	@Override
	public List<DomData> getDoms() 
	{	
		return data;
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
