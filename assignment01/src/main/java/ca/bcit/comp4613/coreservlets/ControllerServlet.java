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
			employee.setId(request.getParameter("tbID"));
			employee.setFirstName(request.getParameter("tbFirstName"));
			employee.setLastName(request.getParameter("tbLastName"));
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				java.util.Date parsed = format.parse(request.getParameter("tbDOE"));
				java.sql.Date dateOfBirth = new java.sql.Date(parsed.getTime());
				employee.setDateOfBirth(dateOfBirth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			int result = dao.add(employee);
			if (result > 0) {
				request.setAttribute("addStatus", StatusConstants.ADD_SUCCESS);
			} else {
				request.setAttribute("addStatus", StatusConstants.ADD_FAIL);
			}
			
		} else if (request.getParameter("btnDeleteEmployee") != null) {
			System.out.println("Delete");
			dao.delete(request.getParameter("tbID"));
		} else  if (request.getParameter("btnSearchEmployee") != null) {
			System.out.println("Search");
			Employee employee = dao.search(request.getParameter("tbID"));
			if (employee != null) {
				System.out.println(employee.getFirstName() + " " + employee.getLastName());
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
