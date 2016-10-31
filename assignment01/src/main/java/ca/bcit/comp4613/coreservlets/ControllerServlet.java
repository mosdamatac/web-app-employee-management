package ca.bcit.comp4613.coreservlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp4613.data.Employee;
import ca.bcit.comp4613.database.dao.EmployeeDao;
import ca.bcit.comp4613.util.StatusConstants;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao dao = new EmployeeDao();
		
		// Determine which button/form called the servlet
		if (request.getParameter("btnAddEmployee") != null) {
			System.out.println("Add");
			Employee employee = new Employee();
			employee.setId(request.getParameter("id"));
			employee.setFirstName(request.getParameter("firstName"));
			employee.setLastName(request.getParameter("lastName"));
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				java.util.Date parsed = format.parse(request.getParameter("dateOfBirth"));
				java.sql.Date dateOfBirth = new java.sql.Date(parsed.getTime());
				employee.setDateOfBirth(dateOfBirth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			int result = dao.add(employee);
			if (result == StatusConstants.ADD_DUPLICATE_CODE) {
				request.setAttribute("addStatus", StatusConstants.ADD_DUPLICATE);				
			} else if (result == 1) {
				request.setAttribute("addStatus", StatusConstants.ADD_SUCCESS);
			} else {
				request.setAttribute("addStatus", StatusConstants.ADD_FAIL);
			}
			
		} else if (request.getParameter("btnDeleteEmployee") != null) {
			System.out.println("Delete");
			int result = dao.delete(request.getParameter("id"));
			if (result > 0) {
				request.setAttribute("deleteStatus", StatusConstants.DELETE_SUCCESS);
			} else {
				request.setAttribute("deleteStatus", StatusConstants.DELETE_FAIL);
			}
			
		} else  if (request.getParameter("btnSearchEmployee") != null) {
			System.out.println("Search");
			Employee employee = dao.search(request.getParameter("id"));
			if (employee != null) {
				request.setAttribute("searchedEmployee", "Found " + employee.getFirstName() + " " + employee.getLastName());
				request.setAttribute("findStatus", StatusConstants.FIND_SUCCESS);
			} else {
				request.setAttribute("findStatus", StatusConstants.FIND_FAIL);
			}
		} else if (request.getParameter("btnSignOut") != null) {
			System.out.println("Sign out");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
