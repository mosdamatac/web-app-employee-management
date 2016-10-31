package ca.bcit.comp4613.util;

public interface StatusConstants {
	
	String ADD_SUCCESS = "Result Code: 200 Description: Success";
	String ADD_FAIL = "Result Code: 901 Description: invalid employee data!";
	String ADD_DUPLICATE = "Result Code: 502 Description: ID already exists for another employee";
	String FIND_SUCCESS = "Result Code: 000 Description: Success";
	String FIND_FAIL = "Result Code: 801 Description: No match found";
	String DELETE_SUCCESS = "Result Code: 001 Description: Deleted Successfully";
	String DELETE_FAIL = "Result Code: 902 Description: Delete Unsuccessful";
	int ADD_DUPLICATE_CODE = 2627;
}
