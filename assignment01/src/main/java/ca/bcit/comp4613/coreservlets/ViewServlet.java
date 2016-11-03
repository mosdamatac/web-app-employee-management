package ca.bcit.comp4613.coreservlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp4613.data.Employee;
import ca.bcit.comp4613.data.EmployeeWithForwardSlashDOB;
import ca.bcit.comp4613.data.IEmployeeComparator;
import ca.bcit.comp4613.data.viewbean.EmployeeViewBean;
import ca.bcit.comp4613.data.IEmployee;

/**
 * Servlet implementation class ComparatorServlet
 */
public class ViewServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeViewBean bean = (EmployeeViewBean) request.getSession().getAttribute("employeeViewBean");
		List<EmployeeWithForwardSlashDOB> employees = bean.getEmployees();
		
		if (request.getParameter("column") != null) {
			if (request.getParameter("column").equals("firstName")) {
				Collections.sort(employees, IEmployeeComparator.compareFirstName());
			} else if (request.getParameter("column").equals("dateOfBirth")) {
				Collections.sort(employees, IEmployeeComparator.compareDateOfBirth());
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
