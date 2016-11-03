<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style.css"/>
<title>${initParam.title }</title>
</head>
<body>
<div>
<jsp:include page="/DatabaseServlet" flush="true"/>
	<div id="left">
		<div class="pageSpace"><jsp:include page="/includes/Employees.jsp" flush="true"/></div>
		<div class="pageSpace"><jsp:include page="/includes/Logout.jsp" flush="true"/></div>
	</div>
	<div id="right">
	<c:if test="${pageContext.request.userPrincipal.name eq 'admin'}">
		<div class="pageSpace"><jsp:include page="/includes/restricted/addEmployees.jsp" flush="true"/></div>
	</c:if>
		<div class="pageSpace"><jsp:include page="/includes/findEmployees.jsp" flush="true"/></div>
	<c:if test="${pageContext.request.userPrincipal.name eq 'admin'}">
		<div class="pageSpace"><jsp:include page="/includes/restricted/deleteEmployees.jsp" flush="true"/></div>
	</c:if>
	</div>
</div>
</body>
</html>
