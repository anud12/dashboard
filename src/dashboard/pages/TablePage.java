package dashboard.pages;

import dashboard.domData.DomData;
import dashboard.domData.basic.ArefButton;
import dashboard.domData.basic.Button;
import dashboard.domData.basic.Div;
import dashboard.library.css.CSSLibrary;

public class TablePage extends Div
{
	protected Div contentDiv; 
	
	public TablePage(String name) 
	{
		super();
		
		Div div = new Div();
		div.addCSSClass(CSSLibrary.getCSSClass("header"));
		
		ArefButton refButton = new ArefButton("Test", "test");
		refButton.addCSSClass(CSSLibrary.getCSSClass("button-primary"));
		refButton.addClass("current");
		div.addDom(refButton);
		
		refButton = new ArefButton("Increment", "increment");
		refButton.addCSSClass(CSSLibrary.getCSSClass("button-primary"));
		div.addDom(refButton);
		
		super.addDom(div);
		
		Div sideMenu = new Div();
		sideMenu.addCSSClass(CSSLibrary.getCSSClass("side-menu"));
		super.addDom(sideMenu);
		
		Button button;
		
		button = new Button("Top");
		button.addCSSClass(CSSLibrary.getCSSClass("button-primary"));
		sideMenu.addDom(button);
		
		button = new Button("Button");
		button.addCSSClass(CSSLibrary.getCSSClass("button-secondary"));
		sideMenu.addDom(button);
		
		button = new Button("Button");
		button.addCSSClass(CSSLibrary.getCSSClass("button-secondary"));
		sideMenu.addDom(button);
		
		button = new Button("Button");
		button.addCSSClass(CSSLibrary.getCSSClass("button-secondary"));
		sideMenu.addDom(button);
		
		button = new Button("Button");
		button.addCSSClass(CSSLibrary.getCSSClass("button-secondary"));
		sideMenu.addDom(button);
		
		contentDiv = new Div();
		contentDiv.addCSSClass(CSSLibrary.getCSSClass("content"));
		super.addDom(contentDiv);
	}
	public void addDom(DomData dom)
	{
		contentDiv.addDom(dom);
	}
	
	
}
