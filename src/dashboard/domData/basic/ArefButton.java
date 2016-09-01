package dashboard.domData.basic;

import dashboard.domParsers.AhrefButtonParser;

public class ArefButton extends Button
{
	protected String destinationURL;
	public ArefButton(String label, String destinationURL) 
	{
		super(label);
		this.destinationURL = destinationURL;
	}
	public String getDestinationURL() 
	{
		return destinationURL;
	}
	public String parseHTML()
	{
		return AhrefButtonParser.parse(this);
	}
}
