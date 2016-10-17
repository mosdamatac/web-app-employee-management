package ca.bcit.comp4613.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ca.bcit.comp4613.database.util.DbUtil;
import ca.bcit.comp4613.database.util.DbConstants;
import ca.bcit.comp4613.database.util.EncryptDecrypt;
import ca.bcit.comp4613.test.EmployeeTester;

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
    	Properties dbProps = new Properties();
        
        try {
        	InputStream inputStream = context.getResourceAsStream(DbConstants.DB_PROPERTIES_FILENAME);
        	if (inputStream != null) {
        		dbProps.load(inputStream);
        	} else {
        		throw new FileNotFoundException("Property file " + DbConstants.DB_PROPERTIES_FILENAME + " not found.");
        	}
        	
        	String url = dbProps.getProperty(DbConstants.DB_URL_KEY);
        	String username = dbProps.getProperty(DbConstants.DB_USER_KEY);
        	String encryptedPassword = dbProps.getProperty(DbConstants.DB_PASSWORD_KEY);
        	String driver = dbProps.getProperty(DbConstants.DB_DRIVER_KEY);
        	
        	EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        	// TODO move passcode to another resource
        	encryptDecrypt.init("lab03passcode", encryptedPassword);
        	String password = encryptDecrypt.decryptValue();
        	
        	System.out.println(password);
            
            DbUtil dbUtil = DbUtil.getInstance();
            dbUtil.init(url, username, password, driver);
        	 
			Connection connection = dbUtil.getConnection();
			if (connection != null) {
				System.out.println("Successfully connected");
				
				// TODO Delete this. Used only to test connection
				System.out.println("Starting database testing");
				EmployeeTester tester = new EmployeeTester();
				tester.testGet();
				//tester.testAdd();
				//tester.testUpdate();
				tester.testDelete();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
