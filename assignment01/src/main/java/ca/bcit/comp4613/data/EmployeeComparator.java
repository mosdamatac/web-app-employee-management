package ca.bcit.comp4613.data;

import java.util.Comparator;

public class EmployeeComparator {

	public static Comparator<Employee> compareFirstName() {
		return new Comparator<Employee>() {
			public int compare(Employee employee1, Employee employee2) {
				return employee1.getFirstName().compareTo(employee2.getFirstName());
			}
		};
	}
	
	public static Comparator<Employee> compareDateOfBirth() {
		return new Comparator<Employee>() {
			public int compare(Employee employee1, Employee employee2) {
				if (employee1.getDateOfBirth() == null && employee2.getDateOfBirth() == null) {
					return 0;
				} else if (employee1.getDateOfBirth() != null && employee2.getDateOfBirth() == null) {
					return -1;
				} else if (employee1.getDateOfBirth() == null && employee2.getDateOfBirth() != null) {
					return 1;
				} else {
					return employee1.getDateOfBirth().compareTo(employee2.getDateOfBirth());
				}
			}
		};
	}
}
