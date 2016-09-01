package dashboard.domData.basic;

import java.util.ArrayList;
import java.util.List;

import dashboard.domData.DomData;

public class TableRow 
{
	protected ArrayList<DomData> data;
	
	public TableRow ()
	{
		data = new ArrayList<>();
	}
	
	public List<DomData> getData()
	{
		return data;
	}
	
	public DomData getData(int index)
	{
		return data.get(index);
	}
	public void addDom(DomData dom)
	{
		data.add(dom);
	}
}
