package dashboard.library.css;

import java.util.HashMap;

public  abstract  class CSSLibrary 
{
	protected static HashMap<String, CSSClass> CSSClasses = new HashMap<>();
	
	static public CSSClass getCSSClass(String className)
	{
		return CSSClasses.get(className);
	}
	static public boolean exists(String className)
	{
		return CSSClasses.containsKey(className);
	}
	static public void addCSSClass(CSSClass cssClass)
	{
		CSSClasses.put(cssClass.getClassName(), cssClass);
	}
	public static CSSSelector getSelector()
	{
		CSSSelector selector = new CSSSelector();
		try 
		{
			selector.setResourceClass("open-sans-font");
			selector.setResourceClass("body");
		} 
		catch (CSSClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return selector;
	}
	
	static public void initialize()
	{	
		addCSSClass(new CSSClass("button-secondary", "css/elements/"));
		addCSSClass(new CSSClass("button-primary", "css/elements/"));
		addCSSClass(new CSSClass("form", "css/elements/"));
		addCSSClass(new CSSClass("table", "css/elements/"));
		
		addCSSClass(new CSSClass("text", "css/"));
		addCSSClass(new CSSClass("title", "css/"));
		
		addCSSClass(new CSSClass("header", "css/containers/"));
		addCSSClass(new CSSClass("content", "css/containers/"));
		addCSSClass(new CSSClass("side-menu", "css/containers/"));
		addCSSClass(new CSSClass("card", "css/containers/"));
		
		addCSSClass(new CSSClass("body", "css/defaults/"));
		addCSSClass(new CSSClass("open-sans-font", "css/defaults/"));
		
	}
}
