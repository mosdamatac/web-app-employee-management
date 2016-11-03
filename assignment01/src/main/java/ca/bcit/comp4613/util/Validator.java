package ca.bcit.comp4613.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	private static final Pattern VALID_ID_REGEX = Pattern.compile("^A0[0-9]{7}$");
	
	public static boolean isValidEmployee(String id, String firstName, String lastName, String dateOfBirth) {
		return isValidID(id) && !firstName.isEmpty() && !lastName.isEmpty() && isValidDateOfBirth(dateOfBirth);
	}
	
	public static boolean isValidID(String id) {
		Matcher matcher = VALID_ID_REGEX.matcher(id);
		return matcher.find();
	}
	
	public static boolean isValidDateOfBirth(String dateOfBirth) {
		if (dateOfBirth.isEmpty()) return true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			format.parse(dateOfBirth);
			return true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
