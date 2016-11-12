package ca.bcit.comp4613.data.bean;

import java.util.Vector;

import ca.bcit.comp4613.data.EmployeeDecorator;
import ca.bcit.comp4613.database.dao.EmployeeDao;

public class EmployeeViewBean {

	private int employeeCount;
	private int currentPage = 1;
	private int lastPage;
	private Vector<EmployeeDecorator> employees;
	private Vector<EmployeeDecorator> allEmployees;
	
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
	
	public Vector<EmployeeDecorator> getEmployees() {		
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
			employees.add(allEmployees.get(i));
		}
	}
}
