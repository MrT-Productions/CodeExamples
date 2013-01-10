<%--* @ValidateDAO.jsp		@Version 1.0 April/2012
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
edu.elon.apps.App, java.io.*, java.sql.*, javax.naming.*" %>
<%-- <%@page errorPage="/WEB-INF/ErrorPage.jsp" %>--%>
<html>
<head>
<title>ValidateDAO</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/TODThomework13/css/styles.css" rel="stylesheet">
</head>
<body>
<h1>Test isAppTableCreated()</h1>
<%AppDBManager adbm = new AppDBManager();
boolean tf = adbm.isAppTableCreated(); %>
<p>isAppTableCreated() returns <%=tf %></p>
<p>Number of records currently in db:</p><%

int recordsinDB = adbm.getRocordsInDB();
out.println(recordsinDB); %>
<h1>Test Displaying Records Currently in DB - getAllApps()</h1>
<table border="1">
<tr>
<th>App Code</th><th>Developers Name</th><th>Title</th><th>Catagory</th>
<th>Price</th>
</tr>
<%
ArrayList<App> getallList = new ArrayList<App>();
getallList = adbm.getAllApps(); 
for(App a : getallList){
out.println("<tr>"
+"<td>"+a.getAppCode()+"</td>"
+"<td>"+a.getDevelopersName()+"</td>"
+"<td>"+a.getAppTitle()+"</td>"
+"<td>"+a.getAppCatagory()+"</td>"
+"<td>"+a.getPrice()+"</td></tr>");
}
 %>
</table>
<h1>Test Retrieving an App by app code for app000003 - findApp("app000003")</h1>
<table border="1">
<tr>
<th>App Code</th><th>Developers Name</th><th>Title</th><th>Catagory</th>
<th>Price</th>
</tr>
<%
ArrayList<App> findList = new ArrayList<App>();
findList = adbm.findApp("app000003"); 
for(App a : findList){
out.println("<tr>"
+"<td>"+a.getAppCode()+"</td>"
+"<td>"+a.getDevelopersName()+"</td>"
+"<td>"+a.getAppTitle()+"</td>"
+"<td>"+a.getAppCatagory()+"</td>"
+"<td>"+a.getPrice()+"</td></tr>");
}	
 %>
</table>
<h1>Test Updating an App by changing app000003 by adding one dollar to price
 - updateApp(app)</h1>
<table border="1">
<tr>
<th>App Code</th><th>Developers Name</th><th>Title</th><th>Catagory</th>
<th>Price</th>
</tr>
 <%
ArrayList<App> updatedList = new ArrayList<App>();
updatedList = adbm.findApp("app000003"); 
String newPrice = "11.99";
for(App a : updatedList){
a.setPrice(newPrice);
adbm.updateApp(a);
out.println("<tr>"
+"<td>"+a.getAppCode()+"</td>"
+"<td>"+a.getDevelopersName()+"</td>"
+"<td>"+a.getAppTitle()+"</td>"
+"<td>"+a.getAppCatagory()+"</td>"
+"<td>"+a.getPrice()+"</td></tr>");
}			
 %>
</table>  

<h1>Test Adding an new App with AppCode app111111 - insertApp(app)</h1>

<table border="1">
<tr>
<th>App Code</th><th>Developers Name</th><th>Title</th><th>Catagory</th>
<th>Price</th>
</tr>
<%
App toInsert = new App("app111111", "Amy Eubanks", "Butterflies", "Education",
"", "","1.99","","");
ArrayList<App> insertList = new ArrayList<App>();
adbm.insertApp(toInsert);
insertList.add(toInsert);
insertList = adbm.getAllApps(); 
for(App a : insertList){
out.println("<tr>"
+"<td>"+a.getAppCode()+"</td>"
+"<td>"+a.getDevelopersName()+"</td>"
+"<td>"+a.getAppTitle()+"</td>"
+"<td>"+a.getAppCatagory()+"</td>"
+"<td>"+a.getPrice()+"</td></tr>");
}	
 %>
</table> 
<h1>Test Deleting a App with AppCode app111111 - deleteApp("app111111")</h1>
<table border="1">
<tr>
<th>App Code</th><th>Developers Name</th><th>Title</th><th>Catagory</th>
<th>Price</th>
</tr>
<%
ArrayList<App> deleteList = new ArrayList<App>();
adbm.deleteApp("app111111");
deleteList = adbm.getAllApps(); 
for(App a : deleteList){
out.println("<tr>"
+"<td>"+a.getAppCode()+"</td>"
+"<td>"+a.getDevelopersName()+"</td>"
+"<td>"+a.getAppTitle()+"</td>"
+"<td>"+a.getAppCatagory()+"</td>"
+"<td>"+a.getPrice()+"</td></tr>");
}	
 %>
</table> 
<h1>Test Clearing all Apps from phoenix.Elon.app table in ElonDB - 
clearAllApps()</h1> 
<p>Number of records currently in db: <%=recordsinDB%></p>
<p>clearAllApps() called.</p>
<% adbm.clearAllApps();%>
<p>Number of records currently in db: <%
int recordsInDB = adbm.getRocordsInDB(); %><%=recordsInDB%></p>
<h1>Restoring DB entries</h1>
<table border="1">
<tr>
<th>App Code</th><th>Developers Name</th><th>Title</th><th>Catagory</th>
<th>Price</th>
</tr>
<%
ArrayList<App> restoreList = new ArrayList<App>();
App toInsert1 = new App("app000001", "Adobe Systems", "Adobe CreatePDF", 
"Business",
"", "","9.99","3.8","");
App toInsert2 = new App("app000002", "RCP Ringtones", "Business Ringtones", 
"Business",
"", "","1.99","3.9","");
App toInsert3 = new App("app000003", "Mobile Systems", "OfficeSuite Pro 5", 
"Business",
"", "","16.99","4.3","");
App toInsert4 = new App("app000004", "Escapist Games Limited", "Star Chart", 
"Education",
"", "","2.99","4.3","");
adbm.insertApp(toInsert1);
adbm.insertApp(toInsert2);
adbm.insertApp(toInsert3);
adbm.insertApp(toInsert4);

restoreList = adbm.getAllApps(); 
for(App a : restoreList){
out.println("<tr>"
+"<td>"+a.getAppCode()+"</td>"
+"<td>"+a.getDevelopersName()+"</td>"
+"<td>"+a.getAppTitle()+"</td>"
+"<td>"+a.getAppCatagory()+"</td>"
+"<td>"+a.getPrice()+"</td></tr>");
}
 %>
</table>
</body>
</html>