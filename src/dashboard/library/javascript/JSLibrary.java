package dashboard.library.javascript;

import java.util.HashMap;

import dashboard.library.javascript.properties.Card;
import dashboard.library.javascript.properties.PieChart;
import dashboard.library.javascript.properties.StepChart;

public class JSLibrary 
{
protected static HashMap<String, JSProperty> JSProperties = new HashMap<>();
	
	static public JSProperty getJSClass(String className)
	{
		return JSProperties.get(className);
	}
	static public boolean exists(String className)
	{
		return JSProperties.containsKey(className);
	}
	static public void addJSProperty(JSProperty jsClass)
	{
		JSProperties.put(jsClass.getName(), jsClass);
	}
	public static JSSelector getSelector()
	{
		return new JSSelector();
	}
	static public void initialize()
	{
		addJSProperty(new StepChart());
		addJSProperty(new PieChart());
		addJSProperty(new Card());
	}
}
