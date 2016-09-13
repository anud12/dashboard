package dashboard.domData.basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dashboard.domData.DomData;
import dashboard.domData.DomIDFactory;
import dashboard.domParsers.FormParser;
import dashboard.library.css.CSSClass;
import dashboard.library.javascript.Method;

public class Form implements DomData
{
	protected LinkedList<DomData> data;
	protected List<CSSClass> cssClases;
	protected List<String> clases;
	protected List<Method> properties;
	protected String method;
	protected String id;
	protected String destination;
	
	public Form(String method, String destination)
	{
		this.method = method;
		data = new LinkedList<>();
		cssClases = new LinkedList<>();
		clases = new LinkedList<>();
		properties = new LinkedList<>();
		id = DomIDFactory.getID(this);
		this.destination = destination;
	}
	public String getMethod()
	{
		return method;
	}
	public void addDom(DomData dom)
	{
		data.add(dom);
	}
	public LinkedList<DomData> getDoms()
	{
		return data;
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
		return FormParser.parse(this);
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
	public String getDestination() 
	{
		return destination;
	}
	public void setDestination(String destination) 
	{
		this.destination = destination;
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
