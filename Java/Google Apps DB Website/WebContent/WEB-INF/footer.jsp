<%@page import="java.text.SimpleDateFormat"%>
<%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat, 
java.text.DateFormat, java.util.Calendar"%>
<%@ page isELIgnored="false" %>
<%--The following become fields in each servlet that
results form a JSP page that includes this file. --%>
<%!private Date accessDate;%>
<html>
<head>
<title>footer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
DateFormat df = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
accessDate = new Date();
 %>

<p><%=df.format(accessDate)%> - ${companyName}</p>
</body>
</html>