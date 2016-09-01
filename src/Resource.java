import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dashboard.db.DBLibrary;

@WebServlet("/resource/*")
public class Resource extends HttpServlet
{
	public void init()
    {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		String[] chunks = request.getRequestURI().split("/");
		
		if(chunks.length >= 3)
		response.getWriter().println(DBLibrary.getElement(chunks[3]).getTable().parseHTML());
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
