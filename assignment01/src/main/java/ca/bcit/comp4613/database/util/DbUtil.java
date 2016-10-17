package ca.bcit.comp4613.database.util;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtil {
	
	private static DbUtil instance = new DbUtil();
	private Connection dbConn;
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
	
	public static DbUtil getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		if (dbConn != null) {
			return dbConn;
		}
		
		try {
			Class.forName(driver);
			dbConn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
		return dbConn;
	}
	
	public boolean tableExists(String tableName) throws SQLException {
		ResultSet resultSet = null;
		
		try {
			Connection dbConn = getConnection();
			DatabaseMetaData dbMetaData = dbConn.getMetaData();
			resultSet = dbMetaData.getTables(dbConn.getCatalog(), "%", "%", null);
			String rsTableName = "";
			
			while (resultSet.next()) {
				rsTableName = resultSet.getString("TABLE_NAME");
				if (rsTableName.equalsIgnoreCase(tableName)) {
					return true;
				}
			}
		} finally {
			resultSet.close();
		}
		
		return false;
	}
	
	public void closeStatement(PreparedStatement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void shutdown() {
		if (dbConn != null) {
			try {
				dbConn.close();
				dbConn = null;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
