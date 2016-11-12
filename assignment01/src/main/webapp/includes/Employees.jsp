<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<div id="main">
	<div id="header">
		<h4>Employees List</h4>
	</div>
	<div id="content">
	<jsp:useBean id="employeeViewBean" class="ca.bcit.comp4613.data.bean.EmployeeViewBean" scope="session"/>
	
		<table class="dataTable">
			<tr>
				<th>Id</th>
				<th><a href="${pageContext.request.contextPath }/ViewServlet?column=firstName">FirstName</a></th>
				<th>LastName</th>
				<th><a href="${pageContext.request.contextPath }/ViewServlet?column=dateOfBirth">Dob</a></th>
			</tr>
			<c:forEach items="${employeeViewBean.employees}" var="employee">
				<tr>
					<td>${employee.id }</td>
					<td>${employee.firstName }</td>
					<td>${employee.lastName }</td>
					<td>${employee.formattedDOB }</td>
				</tr>
			</c:forEach>
		</table>
		<div id="employeePagination">
			${employeeViewBean.employeeCount } items found,
			displaying ${employeeViewBean.currentPage } to ${employeeViewBean.lastPage }.
			<c:choose>
				<c:when test="${employeeViewBean.currentPage == 1 }">
					[First/Prev]
				</c:when>
				<c:otherwise>
					[<a href="${pageContext.request.contextPath }/ViewServlet?page=1">First</a>/
					<a href="${pageContext.request.contextPath }/ViewServlet?page=${employeeViewBean.currentPage - 1}">Prev</a>]
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="1" end="${employeeViewBean.lastPage }">
				<c:choose>
					<c:when test="${employeeViewBean.currentPage == i }">
						<c:out value="${i }"/>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath }/ViewServlet?page=${i}"><c:out value="${i }"/></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${employeeViewBean.currentPage == employeeViewBean.lastPage }">
					[Next/Last]
				</c:when>
				<c:otherwise>
					[<a href="${pageContext.request.contextPath }/ViewServlet?page=${employeeViewBean.currentPage + 1}">Next</a>/
					<a href="${pageContext.request.contextPath }/ViewServlet?page=${employeeViewBean.lastPage}">Last</a>]
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>