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
		<h4>Find An Employee By ID</h4>
	</div>
	<div id="content">
		<form>
			<label for="tbID">ID:</label>
			<input type="text" name="tbID"/><br/>
			<div id="footer">
				<input type="button" name="btnSearchEmployee" value="Search"/>
			</div>
		</form>
	</div>
</div>
</body>
</html>