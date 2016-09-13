

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
	    	
	    	/*
			Table table;
			
			table = DBLibrary.getElement("YEAR").getTable();
			table.addCSSClass(CSSLibrary.getSelector().getResourceClass("table"));
			page.addDom(table);
			*/
	    	Div div = new Div();
	    	//div.addCSSClass(CSSLibrary.getCSSClass("something"));
	    	page.addDom(div);
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
