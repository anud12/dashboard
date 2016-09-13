

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dashboard.library.css.CSSLibrary;
import dashboard.library.javascript.JSLibrary;

/**
 * Application Lifecycle Listener implementation class CSSLoader
 *
 */
@WebListener
public class Initializer implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Initializer() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  
    { 
        
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  
    {
    	//Init here
    	CSSLibrary.initialize();
    	JSLibrary.initialize();
    }
	
}
