<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<div id="main">
	<div id="header">
		<h4>Add Employees</h4>
	</div>
	<div id="content">
		<form action="ControllerServlet" method="post">
			<table>
				<tr>
					<td class="labelTD"><label for="tbID">ID:</label></td>
					<td><input type="text" name="tbID"/></td>
				</tr>
				<tr>
					<td><label for="tbFirstName">First<br/>Name:</label></td>
					<td><input type="text" name="tbFirstName"/></td>
				</tr>
				<tr>
					<td><label for="tbLastName">Last<br/>Name:</label></td>
					<td><input type="text" name="tbLastName"/></td>
				</tr>
				<tr>
					<td><label for="tbDOE">DOE:</label></td>
					<td><input type="text" name="tbDOE"/></td>
				</tr>
			</table>			
			<div id="footer">
				<input type="submit" name="btnAddEmployee" value="Add Employee"/>
			</div>
			<label id="statusCode">${requestScope.addStatus }</label>
		</form>
	</div>
</div>