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
<br/><br/>
<form>
	<label for="username">User Name: </label>
	<input type="text" name="tbUsername"/>
	<br/>
	<label for="password">Password: </label>
	<input type="password" name="tbPassword"/>
	<br/>
	<input type="button" name="btnLogin" value="Log In"/>
</form>
</body>
</html>