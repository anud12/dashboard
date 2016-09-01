

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dashboard.domData.DomData;
import dashboard.domData.basic.ArefButton;
import dashboard.domData.basic.Div;
import dashboard.domData.basic.Text;
import dashboard.library.css.CSSClassNotFoundException;
import dashboard.library.css.CSSLibrary;
import dashboard.library.css.CSSSelector;

/**
 * Servlet implementation class Increment
 */
@WebServlet("/increment")
public class Increment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       public static String value = new String("0");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Increment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		value = new Integer( Integer.valueOf(value) + 1).toString();
		
		response.setContentType("text/html");
		
		LinkedList<DomData> domList = new LinkedList<>();
		CSSSelector selector = CSSLibrary.getSelector();
		
		try 
		{
			Div div = new Div();
			div.addCSSClass(selector.getResourceClass("header"));
						
			ArefButton refButton = new ArefButton("Test", "test");
			refButton.addCSSClass(selector.getResourceClass("button-primary"));
			
			div.addDom(refButton);
			
			refButton = new ArefButton("Increment", "increment");
			refButton.addCSSClass(selector.getResourceClass("button-primary"));
			refButton.addClass("current");
			div.addDom(refButton);
			
			domList.add(div);
			
			Div contentDiv = new Div();
			contentDiv.addCSSClass(selector.getResourceClass("content"));
			domList.add(contentDiv);
			
			StringBuilder builder = new StringBuilder();
			builder.append("Served at: ").append(request.getContextPath());
			builder.append("\n Value incremented");
			builder.append("\n New value :" + value);
			
			Div textDiv = new Div();
			textDiv.addDom(new Text(builder.toString()));
			contentDiv.addDom(textDiv);
		}	
		
		
		catch (CSSClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Writer writer = response.getWriter();
		
		writer.write("<head>");
		writer.write(selector.getResourceReferences());
		writer.write("</head>");
		
		writer.write("<body style='margin:0px'>");
		
		Iterator<DomData> iterator = domList.iterator();
		while(iterator.hasNext())
		{
			DomData dom = iterator.next();
			
			writer.write(dom.parseHTML());
			writer.write("\n");
		}
		writer.write("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
