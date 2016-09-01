package dashboard.library.css;

public class CSSClass 
{
	protected String filePath;
	protected String className;
	
	public CSSClass(String className, String path)
	{
		this.filePath = path;
		this.className = className;
	}
	
	public void setPath(String path)
	{
		this.filePath = path;
	}
	
	public String getPath()
	{
		return filePath;
	}

	public String getClassName() 
	{
		return className;
	}

	public void setClassName(String className) 
	{
		this.className = className;
	}
	
}
