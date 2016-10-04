package ca.comp.bcit4613.database;

import java.sql.Connection;
import java.sql.SQLException;

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
    	System.out.println("Listener called...");
    	
         ServletContext context = sce.getServletContext();
         String url = context.getInitParameter("dbUrl");
         String username = context.getInitParameter("dbUsername");
         String password = context.getInitParameter("dbPassword");
         String driver = context.getInitParameter("dbDriver");
         
         DBUtil dbUtil = DBUtil.getInstance();
         dbUtil.init(url, username, password, driver);
         try {
			Connection connection = dbUtil.getConnection();
			if (connection != null) {
				System.out.println("Successfully connected");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
