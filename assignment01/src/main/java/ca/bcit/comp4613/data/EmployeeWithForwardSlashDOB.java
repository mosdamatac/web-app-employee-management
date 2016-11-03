package ca.bcit.comp4613.data;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EmployeeWithForwardSlashDOB extends EmployeeDecorator {
	
	private String formattedDOB;

	public EmployeeWithForwardSlashDOB(IEmployee decoratedEmployee) {
		super(decoratedEmployee);
	}
	
	public String getFormattedDOB() {
		Date dateOfBirth = super.getDateOfBirth();
		if (dateOfBirth == null) {
			return "NULL";
		}
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");		
		formattedDOB = formatter.format(dateOfBirth);
		
		return formattedDOB;
	}
}
