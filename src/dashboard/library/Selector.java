package dashboard.library;

import java.util.HashSet;
import java.util.List;


public interface Selector<T>
{
	public T getResourceClass(String className) throws ResourceNotFoundException;
	public void setResourceClass(String className) throws ResourceNotFoundException;
	public void setResourceClass(List<T> list);
	public HashSet<String> getUsedClassNames();
	public List<T> getUsedClasses();
	public String getResourceReferences();
}
