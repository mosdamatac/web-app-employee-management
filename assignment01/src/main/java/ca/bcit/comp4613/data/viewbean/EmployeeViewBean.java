package ca.bcit.comp4613.data.viewbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import ca.bcit.comp4613.data.EmployeeWithForwardSlashDOB;
import ca.bcit.comp4613.data.IEmployee;
import ca.bcit.comp4613.database.dao.EmployeeDao;
import ca.bcit.comp4613.database.util.DBUtil;

public class EmployeeViewBean {

	private int employeeCount;
	private int currentPage = 1;
	private int lastPage;
	private Vector<EmployeeWithForwardSlashDOB> employees;
	private static Vector<IEmployee> allEmployees;
	
	public int getEmployeeCount() {
		return employeeCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		setEmployees();
	}
	
	public int getLastPage() {
		return lastPage;
	}
	
	public Vector<EmployeeWithForwardSlashDOB> getEmployees() {		
		return employees;
	}
	
	public EmployeeViewBean() {		
		EmployeeDao dao = new EmployeeDao();
		allEmployees = dao.get();
		employeeCount = allEmployees.size();
		lastPage = (int) Math.ceil(employeeCount / 5.0);
		setEmployees();
	}
	
	private void setEmployees() {
		employees = new Vector<>();
		int index = (currentPage - 1) * 5;
		int offset = (index + 5) < employeeCount ? (index + 5) : employeeCount;
		
		for (int i = index; i < offset; i++) {
			EmployeeWithForwardSlashDOB employee = new EmployeeWithForwardSlashDOB(allEmployees.get(i));
			employees.add(employee);
		}
	}
}
