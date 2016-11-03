package ca.bcit.comp4613.data;

import java.sql.Date;

public abstract class EmployeeDecorator implements IEmployee {
	protected IEmployee decoratedEmployee;
	
	public EmployeeDecorator(IEmployee decoratedEmployee) {
		this.decoratedEmployee = decoratedEmployee;
	}
	
	public String getId() {
		return decoratedEmployee.getId();
	}
	public void setId(String id) {
		decoratedEmployee.setId(id);;
	}
	public String getFirstName() {
		return decoratedEmployee.getFirstName();
	}
	public void setFirstName(String firstName) {
		decoratedEmployee.setFirstName(firstName);;
	}
	public String getLastName() {
		return decoratedEmployee.getLastName();
	}
	public void setLastName(String lastName) {
		decoratedEmployee.setLastName(lastName);;
	}
	public Date getDateOfBirth() {
		return decoratedEmployee.getDateOfBirth();
	}
	public void setDateOfBirth(Date dateOfBirth) {
		decoratedEmployee.setDateOfBirth(dateOfBirth);;
	}
}
