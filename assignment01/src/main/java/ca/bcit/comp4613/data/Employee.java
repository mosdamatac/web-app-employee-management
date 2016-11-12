package ca.bcit.comp4613.data;

import java.sql.Date;

/**
 * @author A00973641, Mara Damatac
 * 
 * Data class for Employee.
 * Information for Employee: ID, First Name, Last Name, Date of Birth.
 *
 */
public abstract class Employee {
	
	protected String id;
	protected String firstName;
	protected String lastName;
	protected Date dateOfBirth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
