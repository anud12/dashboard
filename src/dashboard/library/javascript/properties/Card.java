package dashboard.library.javascript.properties;

import dashboard.domData.DomData;
import dashboard.library.javascript.JSProperty;
import dashboard.library.javascript.Method;

public class Card extends JSProperty
{
	
	public  Card()
	{
		super("Card","javascript/");
	}
	
	
	public Method generateCall(DomData dom)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Card.init(");
		builder.append("\n");
		builder.append("'");
		builder.append(dom.getId());
		builder.append("'");
		builder.append("\n");
		builder.append(");\n");
		Method method = new Method(builder.toString(), "Card");
		return method;
	}
}