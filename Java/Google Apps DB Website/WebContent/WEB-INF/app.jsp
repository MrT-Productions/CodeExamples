<%--* @app.jsp		@Version 1.0 April/2012
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
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@page import="java.util.*,edu.elon.apps.AppDBManager, javax.servlet.*,
edu.elon.apps.App, java.io.*, java.sql.*, javax.naming.*, java.lang.String" %>
<html>
<head>
<title>${companyName} Update App</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="../css/styles.css" rel="stylesheet" > -->
<link href="/TODThomework13/css/styles.css" rel="stylesheet">
</head>
<body>
<%
AppDBManager adbm = new AppDBManager();
HttpSession mySession = request.getSession();

ArrayList<App> findList = (ArrayList<App>) mySession.getAttribute("findApp");
String ac = request.getParameter("appCode");
String appCode = "";
String devName = "";
String title = "";
String cata = "";
String price = "";
String rating = "";
String dateUp = "2012-03-20";
String cversion = "";
String ad = "";
	for(App a : findList){
	appCode = a.getAppCode();
	devName = a.getDevelopersName();
	title = a.getAppTitle();
	cata = a.getAppCatagory();
	price = a.getPrice();
	rating = a.getRating();
	dateUp = a.getDateUpdated();
	cversion = a.getCurrentVersion();
	ad = a.getAppDescription();
	}	
 %>
<h1>Maintain App Records</h1>
<form method="post" action="/TODThomework13/ControllerServlet">
<table>
<tr><td>App Code:</td><td><input name="code" type="text" 
placeholder="app######" pattern="^(app)(\d{6})$"
value="${appBean.appCode}" required="required"/></td></tr>
<tr><td>Developers:</td><td><input name="devN" type="text" 
placeholder="Edward Elon" 
value="${appBean.developersName}" pattern="\w.{1,70}" required="required"/>
</td></tr>
<tr><td>App Title:</td><td><input name="title" type="text" 
placeholder="Application name" 
value="${appBean.appTitle}" pattern="^[A-Za-z0-9\s]{1,70}$" 
required="required"/></td></tr>
<tr><td>App Catagory:</td><td><select name="cata" >
<option selected="selected" value="${appBean.appCatagory}">
${appBean.appCatagory}</option>
<option value="Education">Business</option>
<option value="${appBean.appCatagory}">Education</option>
</select></td></tr>
<tr><td>Average Rating:</td><td><input name="avr" type="text" 
placeholder="4.0"/  value="${appBean.rating}" 
pattern="^\d.\d$" required="required" /></td></tr>
<tr><td>Date Updated:</td><td><input name="dup" value="${appBean.dateUpdated}" 
pattern="\d{4}-\d{2}-\d{2}" required="required"/></td></tr>
<tr><td>Current Version:</td><td><input name="cv" type="text" placeholder="1.0" 
 value="${appBean.currentVersion}" 
pattern=".*" required="required"/></td></tr>
<tr><td>App Description:</td><td><textarea name="appD" rows="5" cols="200" 
>${appBean.appDescription}</textarea></td></tr>
<tr><td>App Price:</td><td><input name="pr" value="${appBean.price}" 
pattern="^\d{1,}.\d\d$" required="required"/></td></tr>
<tr><td><input type="hidden"/></td><td><input type="hidden"/></td></tr>
<tr>
<td>
<input type="submit" value="Update App" name="updateApp"/></td><td><input
type="submit" 
value="View All Apps" name="viewall"/></td>
</form></tr>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>