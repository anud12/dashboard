	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dashboard.domData.basic.Table;
import dashboard.domData.basic.TableRow;
import dashboard.domData.basic.Text;
import dashboard.library.css.CSSClassNotFoundException;
import dashboard.library.css.CSSLibrary;
import dashboard.library.css.CSSSelector;

@WebServlet("/table")
public class TableServlet  extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected Table table;
	protected CSSSelector selector;
	public void init()
    {
		File file = new File("C:/new text document (2).txt");
		
		BufferedReader reader = null;
		selector = CSSLibrary.getSelector();
		try 
		{
			reader = new BufferedReader(new FileReader(file));
			String line;
			table = new Table();
			table.addCSSClass(selector.getResourceClass("table"));
			
			while( (line = reader.readLine()) != null)
			{
				List<String> lines = Arrays.asList(line.split("\n"));
				TableRow row = new TableRow();
				
				Iterator<String> iterator = lines.iterator();
				
				while(iterator.hasNext())
				{
					String string = iterator.next();
					
					List<String> columns = Arrays.asList(string.split("\t"));
					Iterator<String> columnIterator = columns.iterator();
					
					while(columnIterator.hasNext())
					{
						String column = columnIterator.next();
						row.addDom(new Text(column));
					}
					
				}
				
				table.addRow(row);
			}
			
		} catch (IOException | CSSClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				
		response.setContentType("text/html");
		Writer writer = response.getWriter();
		
		writer.write("<head>");
		writer.write(selector.getResourceReferences());
		writer.write("</head>");
		
		writer.write("<body style='margin:0px'>");
		
		writer.write(table.parseHTML());
		
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
