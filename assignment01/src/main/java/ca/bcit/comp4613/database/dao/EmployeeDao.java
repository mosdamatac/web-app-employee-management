package ca.bcit.comp4613.database.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import ca.bcit.comp4613.data.Employee;
import ca.bcit.comp4613.data.EmployeeWithForwardSlashDOB;
import ca.bcit.comp4613.data.IEmployee;
import ca.bcit.comp4613.database.util.DBConstants;
import ca.bcit.comp4613.database.util.DBUtil;

public class EmployeeDao {

	public Vector<IEmployee> get() {
		System.out.println("Retrieving employees");
		Vector<IEmployee> employees = new Vector<>();
		DBUtil db = DBUtil.getInstance();
		Connection dbConn = null;
		PreparedStatement ps = null;
		String sql = String.format("SELECT ID, firstName, lastName, dob FROM %s", DBConstants.EMPLOYEES_TABLE_NAME);
		
		try {
			dbConn = db.getConnection();
			System.out.println("Executing " + sql);
			ps = dbConn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			IEmployee employee;
			while (rs.next()) {
				employee = new Employee();
				employee = new EmployeeWithForwardSlashDOB(employee);
				employee.setId(rs.getString(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setDateOfBirth(rs.getDate(4));
				
				employees.add(employee);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return employees;
	}
	
	public int add(IEmployee employee) {
		DBUtil db = DBUtil.getInstance();
		Connection dbConn = null;
		PreparedStatement ps = null;
		String sql = String.format("INSERT INTO %s VALUES (?, ?, ?, ?)", DBConstants.EMPLOYEES_TABLE_NAME);
		int count = 0;
		
		try {
			System.out.println("Attempting to add employee.");
			dbConn = db.getConnection();
			
			ps = dbConn.prepareStatement(sql);
			ps.setString(1, employee.getId());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getLastName());
			ps.setDate(4, (Date) employee.getDateOfBirth());
			
			count = ps.executeUpdate();
			System.out.println("Successfully added row: " + count);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return ex.getErrorCode();		
		}
		
		return count;
	}
	
	public int update(IEmployee employee) {
		DBUtil db = DBUtil.getInstance();
		Connection dbConn = null;
		PreparedStatement ps = null;
		String sql = String.format("UPDATE %s SET %s=?, %s=?, %s=? WHERE %s=?", DBConstants.EMPLOYEES_TABLE_NAME,
				"firstName", "lastName", "dob", "ID");
		int count = 0;
		
		try {
			System.out.println("Attempting to update employee.");
			dbConn = db.getConnection();
			
			ps = dbConn.prepareStatement(sql);			
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setDate(3, (Date) employee.getDateOfBirth());
			ps.setString(4, employee.getId());
			
			count = ps.executeUpdate();
			System.out.println("Successfully updated row: " + count);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return count;
	}
	
	public int delete(String id) {
		DBUtil db = DBUtil.getInstance();
		Connection dbConn = null;
		PreparedStatement ps = null;
		String sql = String.format("DELETE FROM %s WHERE ID=?", DBConstants.EMPLOYEES_TABLE_NAME);
		int count = 0;
		
		try {
			System.out.println("Attempting to delete employee.");
			dbConn = db.getConnection();
			
			ps = dbConn.prepareStatement(sql);
			ps.setString(1, id);
			
			count = ps.executeUpdate();
			System.out.println("Successfully deleted row: " + count);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return count;
	}
	
	public IEmployee search(String id) {
		DBUtil db = DBUtil.getInstance();
		Connection dbConn = null;
		PreparedStatement ps = null;
		String sql = String.format("SELECT ID, firstName, lastName, dob FROM %s WHERE ID=?", DBConstants.EMPLOYEES_TABLE_NAME);
		
		IEmployee employee = null;
		try {
			System.out.println("Finding employee: " + id);
			dbConn = db.getConnection();
			
			ps = dbConn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getString(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setDateOfBirth(rs.getDate(4));
			}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return employee;
	}
}
