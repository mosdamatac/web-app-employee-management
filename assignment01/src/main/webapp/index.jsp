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
<div>
	<div id="left">
		<div class="pageSpace"><jsp:include page="/includes/Employees.jsp" flush="true"/></div>
		<div class="pageSpace"><jsp:include page="/includes/Logout.jsp" flush="true"/></div>
	</div>
	<div id="right">
		<div class="pageSpace"><jsp:include page="/includes/addEmployees.jsp" flush="true"/></div>
		<div class="pageSpace"><jsp:include page="/includes/findEmployees.jsp" flush="true"/></div>
		<div class="pageSpace"><jsp:include page="/includes/deleteEmployees.jsp" flush="true"/></div>
	</div>
</div>
</body>
</html>
