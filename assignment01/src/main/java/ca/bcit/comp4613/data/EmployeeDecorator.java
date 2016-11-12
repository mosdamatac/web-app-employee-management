package ca.bcit.comp4613.data;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EmployeeDecorator extends Employee {
	
	private String formattedDOB;

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
