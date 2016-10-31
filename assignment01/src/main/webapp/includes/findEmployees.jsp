<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<div id="main">
	<div id="header">
		<h4>Find An Employee By ID</h4>
	</div>
	<div id="content">
		<form action="ControllerServlet" method="post">
			<table>
				<tr>
					<td class="labelTD"><label for="id">ID:</label></td>
					<td><input type="text" name="id"/><br/></td>
				</tr>
			</table>
			<div id="footer">
				<input type="submit" name="btnSearchEmployee" value="Search"/>
			</div>
			<label id="searchedEmployee">${requestScope.searchedEmployee }</label><br/><br/>
			<label id="statusCode">${requestScope.findStatus }</label>
		</form>
	</div>
</div>