package dashboard.library.css;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dashboard.library.Selector;

public class CSSSelector implements Selector<CSSClass>
{
	protected HashSet<String> usedClasses;
	
	public CSSSelector()
	{
		usedClasses = new HashSet<>();
	}
	
	public CSSClass getResourceClass(String className) throws CSSClassNotFoundException
	{
		setResourceClass(className);
		
		return CSSLibrary.getCSSClass(className);
	}
	public void setResourceClass(String className) throws CSSClassNotFoundException
	{
		if(!CSSLibrary.exists(className))
			throw new CSSClassNotFoundException("CSSClass " + className + " not found");
		
		usedClasses.add(className);
	}
	public void setResourceClass(List<CSSClass> list)
	{
		Iterator<CSSClass> iterator = list.iterator();
		while(iterator.hasNext())
		{
			CSSClass css = iterator.next();
			try 
			{
				setResourceClass(css.getClassName());
			} catch (CSSClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public HashSet<String> getUsedClassNames()
	{
		return usedClasses;
	}
	public List<CSSClass> getUsedClasses()
	{
		LinkedList<CSSClass> array = new LinkedList<>();
		
		Iterator<String> iterator = usedClasses.iterator();
		while(iterator.hasNext())
		{
			String className = iterator.next();
			
			array.add(CSSLibrary.getCSSClass(className));
		}
		return array;
	}
	
	public String getResourceReferences()
	{
		StringBuilder builder = new StringBuilder();
		
		Iterator<CSSClass> literator = getUsedClasses().iterator();
		
		while(literator.hasNext())
		{
			CSSClass cClass = literator.next();
			builder.append("<link rel='stylesheet' href='/dashboard/");
			builder.append(cClass.getPath());
			builder.append(cClass.getClassName());
			builder.append(".css'");
			builder.append(" type='text/css' media='all'/>");
			builder.append("\n");
		}
		return builder.toString();
	}
	
}
