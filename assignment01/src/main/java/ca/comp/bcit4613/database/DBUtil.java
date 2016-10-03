package ca.comp.bcit4613.database;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private static DBUtil instance = new DBUtil();
	private Connection connection;
	private String url;
	private String username;
	private String password;
	private String driver;
	
	public void init(String url, String username, String password, String driver) {
		if (!url.isEmpty()) this.url = url;
		if (!username.isEmpty()) this.username = username;
		if (!password.isEmpty()) this.password = password;
		if (!driver.isEmpty()) this.driver = driver;
	}
	
	public static DBUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		if (connection != null) {
			return connection;
		}
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
		return connection;
	}

}
