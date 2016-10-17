package ca.bcit.comp4613.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ca.bcit.comp4613.data.Employee;
import ca.bcit.comp4613.database.dao.EmployeeDao;

public class EmployeeTester {
	
	private EmployeeDao dao = new EmployeeDao();
	
	@SuppressWarnings("deprecation")
	public void testAdd() {
		Employee employee = new Employee();
		employee.setId("A09876543");
		employee.setFirstName("Tiger");
		employee.setLastName("Woods");
		employee.setDateOfBirth(new Date(1993, 02, 19));
		
		System.out.println("Add Result: " + dao.add(employee));
	}
	
	public void testDelete() {
		System.out.println("Delete Result: " + dao.delete("A09876543"));
	}
	
	public void testUpdate() {
		Employee employee = new Employee();
		employee.setId("A09876543");
		employee.setFirstName("Tiger");
		employee.setLastName("Panda");
		employee.setDateOfBirth(new Date(1993, 02, 19));
		
		System.out.println("Update Result: " + dao.update(employee));
	}
	
	public void testGet() {
		List<Employee> employees = new ArrayList<>();
		employees = dao.get();
		if (!employees.isEmpty()) {
			System.out.println(employees.size());
		} else {
			System.out.println("Can't get employees");
		}
	}

}
