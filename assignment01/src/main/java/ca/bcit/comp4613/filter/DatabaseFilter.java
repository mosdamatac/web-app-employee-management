package ca.bcit.comp4613.filter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp4613.database.util.DBConstants;
import ca.bcit.comp4613.database.util.DBUtil;
import ca.bcit.comp4613.database.util.EncryptDecrypt;

/**
 * Servlet Filter implementation class DatabaseFilter
 */
@WebFilter ( filterName="DatabaseFilter", urlPatterns="/*")
public class DatabaseFilter implements Filter {
	
	private FilterConfig config;
	private DBUtil dbUtil;

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		dbUtil.shutdown();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("DatabaseFilter called...");
		
   	 	ServletContext context = config.getServletContext();
    	Properties dbProps = new Properties();
         
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

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DatabaseFilter initialized...");
		this.config = fConfig;
	}

}
