package ca.bcit.comp4613.data.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import ca.bcit.comp4613.data.EmployeeDecorator;
import ca.bcit.comp4613.database.dao.EmployeeDao;
import ca.bcit.comp4613.util.StatusConstants;
import ca.bcit.comp4613.util.Validator;

@SuppressWarnings("serial")
@ManagedBean(name = "employeeBean")
@RequestScoped
public class EmployeeBean implements Serializable {

	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String employeeID;
	private String searchResult;
	private String addResult;
	private EmployeeDao dao;
	
	public EmployeeBean() {
		dao = new EmployeeDao();
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	private void setSearchResult() {
		EmployeeDecorator employee = dao.search(employeeID);
		if (employee != null) {
			searchResult = String.format("Found %s %s\n%s",
					employee.getFirstName(),
					employee.getLastName(),
					StatusConstants.FIND_SUCCESS);
		} else {
			searchResult = StatusConstants.FIND_FAIL;
		}
	}
	
	public String getSearchResult() {
		return searchResult;
	}

	public String getAddResult() {
		return addResult;
	}

	private void setAddResult() {
		EmployeeDecorator employee = new EmployeeDecorator();
		if (Validator.isValidEmployee(employeeID, firstName, lastName, dateOfBirth)) {
			employee.setId(employeeID);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			if (!dateOfBirth.isEmpty()) {
				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					java.util.Date parsed = format.parse(dateOfBirth);
					java.sql.Date formattedDateOfBirth = new java.sql.Date(parsed.getTime());
					employee.setDateOfBirth(formattedDateOfBirth);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			int result = dao.add(employee);
			if (result == StatusConstants.ADD_DUPLICATE_CODE) {
				addResult = StatusConstants.ADD_DUPLICATE;				
			} else if (result == 1) {
				addResult = StatusConstants.ADD_SUCCESS;					
				
				// TODO update viewbean
				//employeeViewBean = new EmployeeViewBean();
				//request.getSession().setAttribute("employeeViewBean", employeeViewBean);
			}
		} else {
			addResult = StatusConstants.ADD_FAIL;
		}
	}
	
	public void commandClicked(ActionEvent event) {
		String buttonID = event.getComponent().getId();
		if (buttonID.equals("btnSearch")) {
			setSearchResult();
		} else if (buttonID.equals("btnAdd")) {
			setAddResult();
		}
	}
	
}
