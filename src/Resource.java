import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/resource/*")
public class Resource extends HttpServlet
{
	public void init()
    {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		System.out.println("POST!");
		
		String parameterValue = request.getParameter("list");
		
		response.setContentType("text/JSON");
		
		//Parsing
		JSONParser parser = new JSONParser();
		try 
		{
			//Get JSON array
			JSONArray array = (JSONArray) parser.parse(parameterValue);
			//Create response array
			JSONArray responseArray = new JSONArray();
			
			for ( int i = 0 ; i < array.size() ; i++)
			{
				JSONObject object = (JSONObject)array.get(i);
				
				String resource = (String) object.get("resource");
				//Insert response into object
				
				//Add object to array
				responseArray.add(object);
			}
			//Write response
			response.getWriter().write(responseArray.toJSONString());
			response.getWriter().flush();
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
