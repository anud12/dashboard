package dashboard.library.javascript;

public class Method 
{
	protected String call;
	protected String functionName;
	
	public Method(String string, String functionName)
	{
		call = string;
		this.functionName = functionName;
	}
	public String getCall()
	{
		return call;
	}
	public String getFunctionName()
	{
		return functionName;
	}
}
