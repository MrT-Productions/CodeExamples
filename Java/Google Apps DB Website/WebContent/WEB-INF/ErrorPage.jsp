<%--
 * @ErrorPage,jsp		@Version 1.0 April/2012
 * 
 * Copyright (c) 2012 Thonda Taylor II Productions.
 * 3567 Campus Box, Elon, North Carolina, 38053 USA.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Thonda Taylor II Productions.  All of the work is original 
 * work completed solely by Thonda Taylor II, with no assistance
 * from anyone.
 */ --%> 
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@page isErrorPage="true" %>
<head>
<title>ErrorPage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/TODThomework13/css/styles.css" rel="stylesheet">
</head>
<body>
<%@page isErrorPage="true" %>
<h1>You have a non working Database</h1>
<p>Consider one of the following actions to remedy:</p>
<ul>
<li>Insure the Derby Database has been started</li>
<li>Insure the Derby Database ElonDB has been created by administrator and
connected to a Datasource.</li>
<li>Insure the deployment administrator has loaded your ElonApp table 
deployment scripts.</li>
</ul>
<p>DB does not exist. Cannot run script</p>
</body>
</html>