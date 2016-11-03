package ca.bcit.comp4613.data;

import java.util.Comparator;

public class IEmployeeComparator {

	public static Comparator<IEmployee> compareFirstName() {
		return new Comparator<IEmployee>() {
			public int compare(IEmployee employee1, IEmployee employee2) {
				return employee1.getFirstName().compareTo(employee2.getFirstName());
			}
		};
	}
	
	public static Comparator<IEmployee> compareDateOfBirth() {
		return new Comparator<IEmployee>() {
			public int compare(IEmployee employee1, IEmployee employee2) {
				if (employee1.getDateOfBirth() == null || employee2.getDateOfBirth() == null) {
					return 0;
				}
				return employee1.getDateOfBirth().compareTo(employee2.getDateOfBirth());
			}
		};
	}
}
