package ca.bcit.comp4613.data;

import java.sql.Date;

public interface IEmployee {

	String getId();
	void setId(String id);
	
	String getFirstName();
	void setFirstName(String firstName);
	
	String getLastName();
	void setLastName(String lastName);
	
	Date getDateOfBirth();
	void setDateOfBirth(Date dateOfBirth);
}
