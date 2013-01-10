<!DOCTYPE HTML>
<!-- * @elonapp.jsp		@Version 1.0 April/2012
 * 
 * Copyright (c) 2012 Thonda Taylor II Productions.
 * 3567 Campus Box, Elon, North Carolina, 38053 USA.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Thonda Taylor II Productions.  All of the work is original 
 * work completed solely by Thonda Taylor II, with no assistance
 * from anyone.
 */  -->
 <%@page language="java"contentType="text/html; 
 charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%!
private String companyName = "";

public void jspInit(){
ServletConfig config = getServletConfig();
companyName = config.getInitParameter("companyName");
if(companyName == null){companyName = "No Company Name";}
ServletContext context = getServletContext();
context.setAttribute("companyName", companyName);
} 
%>
<head>
<title>${companyName}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/TODThomework13/css/styles.css" rel="stylesheet">
</head>
<body>
<h1>Maintain Elon App Records</h1>
<%
if(request.isUserInRole("ElonAdmin")){
 %>
<form method="post" action="/TODThomework13/ControllerServlet?addapp="><input 
type="submit" value="Add App" name="addapp" />
</form>
<form method="post" action="/TODThomework13/ControllerServlet">
<input type="submit" value="View All Apps" name="viewall"/></form>
<%
}
 %>
<%
if(request.isUserInRole("ElonUser")){
 %> 
<form method="post" action="/TODThomework13/ControllerServlet">
<input type="submit" value="View All Apps" name="viewall"/></form>
<%
}
 %>
</body>
</html>