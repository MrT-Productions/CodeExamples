<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@page import="java.util.*,edu.elon.apps.AppDBManager, javax.servlet.*,
edu.elon.apps.App, java.io.*, java.sql.*, javax.naming.*" %>
<%--* @app_list.jsp		@Version 1.0 April/2012
 * 
 * Copyright (c) 2012 Thonda Taylor II Productions.
 * 3567 Campus Box, Elon, North Carolina, 38053 USA.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Thonda Taylor II Productions.  All of the work is original 
 * work completed solely by Thonda Taylor II, with no assistance
 * from anyone.
 */  --%>
<html>
<head>
<title>${companyName} App List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/TODThomework13/css/styles.css" rel="stylesheet">
</head>
<body>
<h1>Maintain Elon App Records</h1>
<table border="1">
<tr>
<th>App Code</th><th>Title</th><th>Catagory</th><th>Average Rating</th>
<th>Price</th><th></th>
</tr>
<%
String editLink = "<a href=\"http://170.224.161.30:9081/TODThomework13"+
"/ControllerServlet?editLink=&appCode=";
String editLinkEnd = "\">Edit</a>";
String deLink = "<a href=\"http://170.224.161.30:9081/TODThomework13"+
"/ControllerServlet?appCode=";
String deLinkEnd = "\">Delete</a>";
HttpSession mySession = request.getSession();
ArrayList<App> getallList = 
(ArrayList<App>) mySession.getAttribute("viewAllApps");
for(int i = 0; i < getallList.size(); i++){
mySession.setAttribute("i", i);%>

<tr><td>${viewAllApps[i].appCode}</td>
<td>${viewAllApps[i].appTitle}</td>
<td>${viewAllApps[i].appCatagory}</td>
<td>${viewAllApps[i].rating}</td>
<td>${viewAllApps[i].price}</td>
<%
if(request.isUserInRole("ElonAdmin")){
 %>
<td><a href="ControllerServlet?editLink=&appCode=${viewAllApps[i].appCode}">
Edit</a></td>
<td><a href="ControllerServlet?appCode=${viewAllApps[i].appCode}">
Delete</a></td></tr>
<%
}
 %>
<%
if(request.isUserInRole("ElonUser")){
 %> 
<td>No Edit Access</td>
<td>No Delete Access</td></tr> 
<%
}
 %>
<%
}
%>
</table>
<br />
<form method="post" action="/TODThomework13/ControllerServlet?menu=">
<input type="submit" value="Back to Menu" /></form>
<br />
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>