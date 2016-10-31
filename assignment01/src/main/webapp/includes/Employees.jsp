<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<div id="main">
	<div id="header">
		<h4>Employees List</h4>
	</div>
	<div id="content">
	<jsp:useBean id="employeeViewBean" class="ca.bcit.comp4613.data.EmployeeViewBean" scope="session"/>
		<table class="dataTable">
			<tr>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Dob</th>
			</tr>
			<c:forEach items="${employeeViewBean.employees}" var="employee">
				<tr>
					<td>${employee.id }</td>
					<td>${employee.firstName }</td>
					<td>${employee.lastName }</td>
					<td>${employee.dateOfBirth }</td>
				</tr>
			</c:forEach>
		</table>
		<div id="employeePagination">
			${employeeViewBean.employeeCount } items found,
			displaying ${employeeViewBean.currentPage } to ${employeeViewBean.lastPage }.
			[<a>First</a>/<a>Prev</a>]
			[<a>Next</a>/<a>Last</a>]
		</div>
	</div>
</div>