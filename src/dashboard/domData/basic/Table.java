package dashboard.domData.basic;

import java.util.List;

import dashboard.domData.DomData;
import dashboard.domData.DomIDFactory;
import dashboard.domParsers.TableParser;
import dashboard.domParsers.TiltedTableParser;
import dashboard.library.css.CSSClass;
import dashboard.library.javascript.Method;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Table implements DomData
{
	protected ArrayList<DomData> data;
	protected ArrayList<TableRow> rows;
	protected TableRowHeader header;
	protected List<CSSClass> cssClases;
	protected List<String> clases;
	protected List<Method> properties;
	protected String id;
	protected boolean tilted;
	
	public Table()
	{
		data = new ArrayList<>();
		rows = new ArrayList<>();
		cssClases = new LinkedList<>();
		clases = new LinkedList<>();
		header = new TableRowHeader();
		properties = new LinkedList<>();
		id = DomIDFactory.getID(this);
		tilted = false;
	}
	public Table(boolean tilted)
	{
		data = new ArrayList<>();
		rows = new ArrayList<>();
		cssClases = new LinkedList<>();
		clases = new LinkedList<>();
		header = new TableRowHeader();
		properties = new LinkedList<>();
		id = DomIDFactory.getID(this);
		this.tilted = tilted;
	}
	public List<TableRow> getRows()
	{
		return rows;
	}
	public void setHeaderRow(TableRowHeader row)
	{
		this.header = row;
	}
	public void setHeaderRow(TableRow row)
	{
		Iterator<DomData> iterator = row.getData().iterator();
		while(iterator.hasNext())
		{
			DomData dom = iterator.next();
			this.header.addDom(dom);
		}
	}
	public TableRowHeader getHeaderRow()
	{
		return header;
	}
	public void addRow(TableRow row)
	{
		rows.add(row);
	}
	public TableRow getRow(int index)
	{
		return rows.get(index);
	}
	public void clearRows()
	{
		rows.clear();
	}
	public List<CSSClass> getCSSClases() 
	{
		return cssClases;
	}

	public void setCSSClass(List<CSSClass> cssClass) 
	{
		cssClases = cssClass;
	}
	public void addCSSClass(CSSClass cssClass)
	{
		cssClases.add(cssClass);
	}
	public void addJSProperty(Method property)
	{
		this.properties.add(property);
	}
	@Override
	public List<String> getClases() 
	{
		// TODO Auto-generated method stub
		return clases;
	}
	
	public void addClass(String className)
	{
		clases.add(className);
	}
	@Override
	public String parseHTML() 
	{
		if(tilted)
		{
			return TiltedTableParser.parse(this);
		}
		return TableParser.parse (this);
	}
	@Override
	public String getId() 
	{
		return id;
	}
	@Override
	public List<Method> getJSMethods() 
	{
		return properties;
	}
	@Override
	public List<DomData> getDoms() 
	{
		return data;
	}
	
	public boolean isTilted() 
	{
		return tilted;
	}
	public void setTilted(boolean tilted) 
	{
		this.tilted = tilted;
	}
	public List<DomData> getDomsRecursive()
	{
		List<DomData> data = new LinkedList<DomData>();
		synchronized(data)
		{
			data = new LinkedList<DomData>();
			data.addAll(this.data);
			Iterator<DomData> iterator = this.data.iterator();
			
			while(iterator.hasNext())
			{
				DomData dom = iterator.next();
				data.addAll(dom.getDoms());
			}
		}
		return data;
	}
	
}
