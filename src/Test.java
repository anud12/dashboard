

import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dashboard.pages.CardDiv;
import dashboard.pages.TablePage;
import dashboard.db.DBLibrary;
import dashboard.domData.DomData;
import dashboard.domData.basic.Div;
import dashboard.domData.basic.Table;
import dashboard.domData.basic.Text;
import dashboard.library.css.CSSLibrary;
import dashboard.library.css.CSSSelector;
import dashboard.library.javascript.JSLibrary;
import dashboard.library.javascript.JSSelector;
import dashboard.library.javascript.Method;
import dashboard.library.javascript.properties.Card;
import dashboard.library.javascript.properties.PieChart;
import dashboard.library.javascript.properties.StepChart;


/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet 
{
	protected Div page;
	protected Table tableChart;
	protected Text incrementValue;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Test() 
    {
    	super();
    }
    public void init()
    {
    	try 
    	{
	    	page = new TablePage("page");
	    	
	    	Div text = new Div();
			text.addDom( new Text("Employers"));
			text.addCSSClass(CSSLibrary.getSelector().getResourceClass("title"));
			page.addDom(text);
			
			
			text = new Div();
			text.addDom( new Text("Use the for general-purpose access to your database. Useful when you are using static SQL statements at runtime. The Statement interface cannot accept parameters."));
			text.addCSSClass(CSSLibrary.getSelector().getResourceClass("text"));
			page.addDom(text);
			
			
			tableChart = DBLibrary.getElement("MONTH").getTable();
			tableChart.addCSSClass(CSSLibrary.getSelector().getResourceClass("table"));
			page.addDom(tableChart);
			
			PieChart property2 = (PieChart) JSLibrary.getJSClass("PieChart");
			tableChart.addJSProperty(property2.generateCall("Titlu", tableChart, text, 1, 1));
			
			
			Div div = new Div();
			
			div.addDom(new Text("Title text"));
			
			Div card = new CardDiv(div);

			div  = new Div();
			div.addDom(new Text("Lorem ipsum"));
			card.addDom(div);
			
			Table testTable = DBLibrary.getElement("MONTH").getTable();
			testTable.addCSSClass(CSSLibrary.getCSSClass("table"));
			card.addDom(testTable);
			
			StepChart property = (StepChart) JSLibrary.getJSClass("StepChart");
			System.out.println(property);
			tableChart.addJSProperty(property.generateCall("Titlu", tableChart, tableChart, 1, 1));
			
			div = new Div();
			div.addDom(new Text("Something end text"));
			card.addDom(div);
			
			page.addDom(card);
			
			card = new CardDiv(div);
			card.addDom(new Div());
			page.addDom(card);
			page.addDom(card);
			
			Table table;
			
			table = DBLibrary.getElement("YEAR").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getResourceClass("table"));
			page.addDom(table);
						
			table = DBLibrary.getElement("KPIS").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getResourceClass("table"));
			page.addDom(table);
			
			
			/*
			table = DBLibrary.getElement("DBA_ORCL_SOUTH_L1_QTY").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("DBA_ORCL_CENTRAL_QTY").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("DBA_ORCL_ARCOR").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("DBA_SYSBASE_MSSQL_SOUTH").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("QUALITY_ASSURANCE").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("STORAGE_PERFORMANCE").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("STORAGE_INFRS_BUILD").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("STORAGE_BLOCK").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("STORAGE_IP").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("STORAGE_PROTECTION").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			table = DBLibrary.getElement("SERVICE_DESIGN_OPERAITIONS").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getCSSClass("table"));
			page.addDomData(table);
			*/
			text = new Div();
			text.addDom( new Text("Increment value"));
			incrementValue = new Text();
			text.addDom(incrementValue);
			text.addCSSClass(CSSLibrary.getSelector().getResourceClass("table"));
			text.addClass("increment-value");
			page.addDom(text);
		} 
    	catch (Exception e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		System.out.print("Created " + this.toString() + " on ");
		System.out.println(Calendar.getInstance().getTime().toString());
    }
    public void destroy()
    {
    	System.out.print("Killed " + this.toString() + " on ");
		System.out.println(Calendar.getInstance().getTime().toString());
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		incrementValue.setText(Increment.value);
		CSSSelector selectorCSS = CSSLibrary.getSelector();
		
		Iterator<DomData> iteratorCSS = page.getDomsRecursive().iterator();
		while(iteratorCSS.hasNext())
		{
			DomData dom = iteratorCSS.next();
			selectorCSS.setResourceClass(dom.getCSSClases());
		}
		
		JSSelector selectorJS = JSLibrary.getSelector();
		Iterator<DomData> iteratorJS = page.getDomsRecursive().iterator();
		while(iteratorJS.hasNext())
		{
			DomData dom = iteratorJS.next();
			selectorJS.setResourceClassFromMethod(dom.getJSMethods());
		}
		
		response.setContentType("text/html");
		Writer writer = response.getWriter();
		
		writer.write("<head>");
		writer.write("<script src='");
		writer.write("javascript/jquery-3.1.0.min.js'");
		writer.write("> </script>\n");
		
		writer.write("<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>");
		writer.write("<script type='text/javascript' src='javascript/LoadFromUrl.js'></script>");
		
		writer.write(selectorJS.getResourceReferences());		
		
		writer.write("<script src='");
		writer.write("'> </script>\n");
		
		writer.write("<script>");
		writer.write("StepChart.init();\n");
		
		Iterator<DomData> iteratorCall = page.getDomsRecursive().iterator();
		while(iteratorCall.hasNext())
		{
			DomData dom = iteratorCall.next();
			Iterator<Method> iteratorMehtods = dom.getJSMethods().iterator();
			while(iteratorMehtods.hasNext())
			{
				Method method = iteratorMehtods.next();
				writer.write(method.getCall());
			}
		}
		
		writer.write("</script>\n");
		
		writer.write(selectorCSS.getResourceReferences());
		
		writer.write("</head>\n");
		
		
		writer.write("<body style='margin:0px'>");
		
		writer.write(page.parseHTML());
		
		
		writer.write("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
