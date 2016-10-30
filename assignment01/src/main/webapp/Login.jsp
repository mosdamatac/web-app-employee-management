<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${initParam.title }</title>
</head>
<body>
<h2>Login</h2>
<h1>Sorry, you must log in before accessing this resource.</h1>
<br/><br/>
<form action="j_security_check" method="post">
	<table>
		<tr>
			<td><label for="username">User Name: </label></td>
			<td><input type="text" name="j_username"/></td>
		</tr>
		<tr>
			<td><label for="password">Password: </label></td>
			<td><input type="password" name="j_password"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="btnLogin" value="Log In"/></td>
		</tr>
	</table>	
</form>
</body>
</html>