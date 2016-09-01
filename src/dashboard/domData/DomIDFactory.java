package dashboard.domData;

import java.util.HashMap;

public class DomIDFactory 
{
	protected static HashMap<String, Integer> idLibrary = new HashMap<>();
	public static String getID(DomData dom)
	{
		String string = dom.getClass().getSimpleName();
		int integer = 0;
		
		if(idLibrary.containsKey(string))
		{
			integer = idLibrary.get(string);
			integer++;
			idLibrary.put(string, integer);
			
			
		}
		else
		{
			idLibrary.put(string, integer);
		}
	
		return string.toLowerCase() + "-" + integer; 
		
	}
}
