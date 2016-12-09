package ca.bcit.comp4613.data;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

public class EmployeeDecorator extends Employee implements Serializable {
	
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
