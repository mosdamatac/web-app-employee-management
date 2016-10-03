package ca.comp.bcit4613.database;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DatabaseInitListener
 *
 */
public class DatabaseInitListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DatabaseInitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context = sce.getServletContext();
         String url = context.getInitParameter("dbUrl");
         String username = context.getInitParameter("dbUsername");
         String password = context.getInitParameter("dbPassword");
         String driver = context.getInitParameter("dbDriver");
    }
	
}
