package dashboard.pages;

import dashboard.domData.DomData;
import dashboard.domData.basic.Div;
import dashboard.library.css.CSSLibrary;
import dashboard.library.javascript.JSLibrary;
import dashboard.library.javascript.properties.Card;

public class CardDiv extends Div
{
	protected Div container;
	protected Div title;
	
	public CardDiv(DomData title) 
	{
		super();
		
		this.container = new Div();
		this.title = new Div();
		
		super.addDom(this.title);
		super.addDom(this.container);
		
		this.addCSSClass(CSSLibrary.getCSSClass("card"));
		this.addJSProperty(((Card) JSLibrary.getJSClass("Card")).generateCall(this));
		
		this.title.addClass("card-title");
		this.title.addCSSClass(CSSLibrary.getCSSClass("button-secondary"));
		
		this.container.addClass("card-content");
		
		
		this.title.addDom(title);
	}
	public void addDom(DomData dom)
	{
		Div div = new Div();
		div.addClass("card-content-cell");
		div.addDom(dom);
		container.addDom(div);
	}
}
