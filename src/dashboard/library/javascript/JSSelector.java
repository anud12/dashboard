package dashboard.library.javascript;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dashboard.library.Selector;

public class JSSelector implements Selector<JSProperty>
{
	protected HashSet<String> usedProperties;
	
	public JSSelector()
	{
		usedProperties = new HashSet<String>();
	}

	@Override
	public JSProperty getResourceClass(String className) throws JSNotFoundException 
	{
		setResourceClass(className);
		
		return JSLibrary.getJSClass(className);
	}

	@Override
	public void setResourceClass(String className) throws JSNotFoundException 
	{
		if(!JSLibrary.exists(className))
			throw new JSNotFoundException("JSProperty " + className + " not found");
		
		usedProperties.add(className);
	}

	@Override
	public void setResourceClass(List<JSProperty> list)
	{
		Iterator<JSProperty> iterator = list.iterator();
		while(iterator.hasNext())
		{
			JSProperty js = iterator.next();
			try 
			{
				setResourceClass(js.getName());
			} catch (JSNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setResourceClassFromMethod(List<Method> list)
	{
		Iterator<Method> iterator = list.iterator();
		while(iterator.hasNext())
		{
			Method js = iterator.next();
			usedProperties.add(js.getFunctionName());
		}
	}
	@Override
	public HashSet<String> getUsedClassNames() 
	{
		return usedProperties;
	}

	@Override
	public List<JSProperty> getUsedClasses() 
	{
		LinkedList<JSProperty> array = new LinkedList<>();
		
		Iterator<String> iterator = usedProperties.iterator();
		while(iterator.hasNext())
		{
			String className = iterator.next();
			
			array.add(JSLibrary.getJSClass(className));
		}
		return array;
	}

	@Override
	public String getResourceReferences() 
	{
		StringBuilder builder = new StringBuilder();
		
		Iterator<JSProperty> literator = getUsedClasses().iterator();
		
		while(literator.hasNext())
		{
			JSProperty js = literator.next();
			builder.append("<script src='");
			builder.append(js.getPath());
			builder.append(js.getName());
			builder.append(".js'");
			builder.append("> </script>\n");
		}
		return builder.toString();
		
	}
}
