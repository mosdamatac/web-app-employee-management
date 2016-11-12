package ca.bcit.comp4613.database.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContext;

public class DBBean {
	
	private String url;
	private String username;
	private String password;
	private String driver;
	private ServletContext context;

	public DBBean() {
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setContext(ServletContext context) {
		this.context = context;
		init();
	}
	
	private void init() {
		Properties dbProps = new Properties();
    	DBUtil dbUtil;
         
        try {
        	InputStream inputStream = context.getResourceAsStream(DBConstants.DB_PROPERTIES_FILENAME);
        	if (inputStream != null) {
        		dbProps.load(inputStream);
        	} else {
        		throw new FileNotFoundException("Property file " + DBConstants.DB_PROPERTIES_FILENAME + " not found.");
        	}
        	
        	url = dbProps.getProperty(DBConstants.DB_URL_KEY);
        	username = dbProps.getProperty(DBConstants.DB_USER_KEY);
        	String encryptedPassword = dbProps.getProperty(DBConstants.DB_PASSWORD_KEY);
        	driver = dbProps.getProperty(DBConstants.DB_DRIVER_KEY);
        	
        	EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        	encryptDecrypt.init("assignmentPasscode", encryptedPassword);
        	password = encryptDecrypt.decryptValue();
        	
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
	}
	
	
}
