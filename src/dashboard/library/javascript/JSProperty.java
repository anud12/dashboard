package dashboard.library.javascript;

public abstract class JSProperty 
{
	protected String name;
	protected String path;
	
	public JSProperty(String name, String path)
	{
		this.name = name;
		this.path = path;
	}

	public String getName() 
	{
		return name;
	}

	public String getPath() 
	{
		return path;
	}
}
