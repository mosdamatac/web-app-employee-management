<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div id="main">
	<div id="header">
		<h4>Remove an Employee</h4>
	</div>
	<div id="content">
		<form action="ControllerServlet" method="post">
			<table>
				<tr>
					<td class="labelTD"><label for="tbID">ID:</label></td>
					<td><input type="text" name="tbID"/><br/></td>
				</tr>
			</table>
			<div id="footer">
				<input type="submit" name="btnDeleteEmployee" value="Delete"/>
			</div>
			<label id="statusCode">${requestScope.deleteStatus }</label>
		</form>
	</div>
</div>