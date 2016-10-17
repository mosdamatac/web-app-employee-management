<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style.css"/>
<title>Insert title here</title>
</head>
<body>
<div id="main">
	<div id="header">
		<h4>Add Employees</h4>
	</div>
	<div id="content">
		<form>
			<label for="tbID">ID:</label>
			<input type="text" name="tbID"/><br/>
			<label for="tbFirstName">First<br/>Name:</label>
			<input type="text" name="tbFirstName"/><br/>
			<label for="tbLastName">Last<br/>Name:</label>
			<input type="text" name="tbLastName"/><br/>
			<label for="tbDOE">DOE:</label>
			<input type="text" name="tbDOE"/>
			<div id="footer">
				<input type="button" name="btnAddEmployee" value="Add Employee"/>
			</div>
		</form>
	</div>
</div>
</body>
</html>