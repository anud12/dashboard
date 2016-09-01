package dashboard.domData;

import java.util.List;

import dashboard.library.css.CSSClass;
import dashboard.library.javascript.Method;

public interface DomData 
{
	public List<DomData> getDoms();
	public List<DomData> getDomsRecursive();
	public List<CSSClass> getCSSClases();
	public List<Method> getJSMethods();
	public List<String> getClases();
	public String parseHTML();
	public String getId();
}
