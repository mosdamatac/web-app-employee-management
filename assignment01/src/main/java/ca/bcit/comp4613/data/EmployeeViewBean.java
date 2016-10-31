package ca.bcit.comp4613.data;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.comp4613.database.dao.EmployeeDao;

public class EmployeeViewBean {

	private int employeeCount;
	private int currentPage = 1;
	private int lastPage;
	private List<Employee> employees;
	
	public int getEmployeeCount() {
		return employeeCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getLastPage() {
		return lastPage;
	}
	
	public List<Employee> getEmployees() {
		EmployeeDao dao = new EmployeeDao();
		List<Employee> temp = dao.get();
		employees = new ArrayList<>();
		employeeCount = temp.size();
		lastPage = (int) Math.ceil(employeeCount / 5.0);
		
		int index = (currentPage - 1) * 5;
		int offset = index + 5;
		
		for (int i = index; i < offset; i++) {
			employees.add(temp.get(i));
		}
		
		return employees;
	}	
	
}
