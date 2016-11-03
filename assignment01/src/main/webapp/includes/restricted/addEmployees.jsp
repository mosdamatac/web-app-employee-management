<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<div id="main">
	<div id="header">
		<h4>Add Employees</h4>
	</div>
	<div id="content">		
		<form action="FormActionServlet" method="post">
			<table>
				<tr>
					<td class="labelTD"><label for="id">ID:</label></td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td><label for="firstName">First<br/>Name:</label></td>
					<td><input type="text" name="firstName"/></td>
				</tr>
				<tr>
					<td><label for="lastName">Last<br/>Name:</label></td>
					<td><input type="text" name="lastName"/></td>
				</tr>
				<tr>
					<td><label for="dateOfBirth" value="YYYY/MM/DD">DOE:</label></td>
					<td><input type="text" name="dateOfBirth"/></td>
				</tr>
			</table>			
			<div id="footer">
				<input type="submit" name="btnAddEmployee" value="Add Employee"/>
			</div>
			<label id="statusCode">${requestScope.addStatus }</label>
		</form>
	</div>
</div>