package ca.bcit.comp4613.coreservlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp4613.data.EmployeeComparator;
import ca.bcit.comp4613.data.EmployeeDecorator;
import ca.bcit.comp4613.data.bean.EmployeeViewBean;

/**
 * Servlet implementation class ComparatorServlet
 */
public class ViewServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private static final String ASCENDING = "asc";
	private static final String DESCENDING = "desc";
	private static String firstNameOrder = ASCENDING;
	private static String dateOfBirthOrder = ASCENDING;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeViewBean bean = (EmployeeViewBean) request.getSession().getAttribute("employeeViewBean");
		Vector<EmployeeDecorator> employees = bean.getEmployees();
		
		if (request.getParameter("column") != null) {
			if (request.getParameter("column").equals("firstName")) {
				dateOfBirthOrder = ASCENDING;
				if (firstNameOrder.equals(ASCENDING)) {
					Collections.sort(employees, EmployeeComparator.compareFirstName());
					firstNameOrder = DESCENDING;
				} else {
					Collections.sort(employees, Collections.reverseOrder(EmployeeComparator.compareFirstName()));
					firstNameOrder = ASCENDING;
				}
			} else if (request.getParameter("column").equals("dateOfBirth")) {
				firstNameOrder = ASCENDING;
				if (dateOfBirthOrder.equals(ASCENDING)) {
					Collections.sort(employees, EmployeeComparator.compareDateOfBirth());
					dateOfBirthOrder = DESCENDING;
				} else {
					Collections.sort(employees, Collections.reverseOrder(EmployeeComparator.compareDateOfBirth()));
					dateOfBirthOrder = ASCENDING;
				}
			}
		} else if (request.getParameter("page") != null) {
			bean.setCurrentPage(Integer.parseInt(request.getParameter("page")));
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
