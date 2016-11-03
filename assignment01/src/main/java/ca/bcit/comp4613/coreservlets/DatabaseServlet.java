package ca.bcit.comp4613.coreservlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp4613.database.util.DBConstants;
import ca.bcit.comp4613.database.util.DBUtil;
import ca.bcit.comp4613.database.util.EncryptDecrypt;

/**
 * Servlet implementation class DatabaseServlet
 */
public class DatabaseServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Database was called");
		
		ServletContext context = getServletContext();
    	Properties dbProps = new Properties();
    	DBUtil dbUtil;
         
        try {
        	InputStream inputStream = context.getResourceAsStream(DBConstants.DB_PROPERTIES_FILENAME);
        	if (inputStream != null) {
        		dbProps.load(inputStream);
        	} else {
        		throw new FileNotFoundException("Property file " + DBConstants.DB_PROPERTIES_FILENAME + " not found.");
        	}
        	
        	String url = dbProps.getProperty(DBConstants.DB_URL_KEY);
        	String username = dbProps.getProperty(DBConstants.DB_USER_KEY);
        	String encryptedPassword = dbProps.getProperty(DBConstants.DB_PASSWORD_KEY);
        	String driver = dbProps.getProperty(DBConstants.DB_DRIVER_KEY);
        	
        	EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        	encryptDecrypt.init("assignmentPasscode", encryptedPassword);
        	String password = encryptDecrypt.decryptValue();
        	
        	System.out.println(password);
            
            dbUtil = DBUtil.getInstance();
            dbUtil.init(url, username, password, driver);
        	 
			Connection connection = dbUtil.getConnection();
			if (connection != null) {
				System.out.println("Successfully connected");
				dbUtil.shutdown();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        response.sendRedirect("/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
